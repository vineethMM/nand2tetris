package com.study.nandtotetris.assembler

import scala.util.Try

case class AsmProgram(commands: List[String]) {

  val psuedoCommand = "\\((.*)\\)".r.anchored
  val commandRegex = "@([0-9]+)".r.anchored

  val program = List[String]()


  lazy val programAddresses: SymbolTable = commands
    .zipWithIndex
    .filter{ case (c, n) =>  c.startsWith("(")  }
    .foldLeft(SymbolTable(Map())){
      (s, c ) => {
        c._1 match { case psuedoCommand(cc) =>  s.addSymbol(cc, c._2 - s.table.size) }
      }
    }

  lazy val defaultAndProgramAddress = SymbolTable(programAddresses.table ++ SymbolTable.defaultMappings)

  lazy val memoryAddresses = {

    def  isMemoryAdrress(c: String) =
      c.startsWith("@") &&  !defaultAndProgramAddress.table.contains(c.substring(1)) && Try(c.substring(1).toShort).toOption.isEmpty

    SymbolTable(
    commands
     .collect{ case c if isMemoryAdrress(c) => c.substring(1) }
     .zipWithIndex
     .map{ case (s, i) => (s -> (i + 16 ).toShort) }
      .toMap
    )
  }

  lazy val allSymbols =
    SymbolTable(SymbolTable.defaultSymbolTable.table ++ programAddresses.table ++ memoryAddresses.table)

  def binaryProgram =
    commands
    .collect{
      case commandRegex(digit)      => Acommand(s"@${digit}")
      case  c if c.startsWith("@")  => Acommand(s"@${allSymbols.getAddress15(c.substring(1)).get}")
      case c if !c.startsWith("(")   => Ccommand(c)
    }.flatMap(_.binaryInstruction)

  val s = List("@2","D=A" ,"@3","D=D+A" ,"@0","M=D")
}
