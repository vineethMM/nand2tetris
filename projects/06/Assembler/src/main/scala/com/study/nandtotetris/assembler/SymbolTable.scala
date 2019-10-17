package com.study.nandtotetris.assembler

import Address15._

import scala.util.Try

trait SymbolTableT {
  def table: Map[String, Short]
  def addSymbol(symbol: String, address: Int): SymbolTable

  def getAddress15(symbol: String): Option[Short] = table.get(symbol)
}

case class SymbolTable(table : Map[String, Short]) extends SymbolTableT {
  override def addSymbol(symbol: String, address: Int): SymbolTable = {
    Try{
      SymbolTable(table ++ Map(symbol -> address.toShort))
    }.toOption
        .getOrElse(this)
  }

}

object SymbolTable {

  val defaultMappings = Map[String, Short](
    "R0" -> r0Address,
    "R1" -> r1Address,
    "R2" -> r2Address,
    "R3" -> r3Address,
    "R4" -> r4Address,
    "R5" -> r5Address,
    "R6" -> r6Address,
    "R7" -> r7Address,
    "R8" -> r8Address,
    "R9" -> r9Address,
    "R10" -> r10Address,
    "R11" -> r11Address,
    "R12" -> r12Address,
    "R13" -> r13Address,
    "R14" -> r14Address,
    "R15" -> r15Address,
    "SCREEN" -> screenAddress,
    "KBD" -> keyboardAddress,
    "SP" -> spAddress,
    "LCL" -> lclAddress,
    "ARG" -> argAddress,
    "THIS" -> thisAddress,
    "THAT" -> thatAddress
  )
  val compMap = Map(
    // a = 0
    "0"   -> "0101010",
    "1"   -> "0111111",
    "-1"  -> "0111010",
    "D"   -> "0001100",
    "A"   -> "0110000",
    "!D"  -> "0001101",
    "!A"  -> "0110001",
    "-D"  -> "0001111",
    "-A"  -> "0110011",
    "D+1" -> "0011111",
    "A+1" -> "0110111",
    "D-1" -> "0001110",
    "A-1" -> "0110010",
    "D+A" -> "0000010",
    "D-A" -> "0010011",
    "A-D" -> "0000111",
    "D&A" -> "0000000",
    "D|A" -> "0010101",
    // a = 1
    "M"   -> "1110000",
    "!M"  -> "1110001",
    "-M"  -> "1110011",
    "M+1" -> "1110111",
    "M-1" -> "1110010",
    "D+M" -> "1000010",
    "D-M" -> "1010011",
    "M-D" -> "1000111",
    "D&M" -> "1000000",
    "D|M" -> "1010101"
  )

  val destMap = Map(
    ""    -> "000",
    "M"   -> "001",
    "D"   -> "010",
    "MD"  -> "011",
    "A"   -> "100",
    "AM"  -> "101",
    "AD"  -> "110",
    "AMD" -> "111"
  )

  val jumpMap = Map(
    ""    -> "000",
    "JGT" -> "001",
    "JEQ" -> "010",
    "JGE" -> "011",
    "JLT" -> "100",
    "JNE" -> "101",
    "JLE" -> "110",
    "JMP" -> "111"
  )

  val defaultSymbolTable = SymbolTable(defaultMappings)
}

