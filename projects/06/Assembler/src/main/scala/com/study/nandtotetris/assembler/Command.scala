package com.study.nandtotetris.assembler

import scala.util.Try

sealed trait Command {
  def command: String

  def binaryInstruction: Option[String]
}

case class PseudoCommand(command: String) extends Command {
  val psuedoCommand = "\\((.*)\\)".r.anchored

 override def binaryInstruction = None

  def getSymbol: Option[String] = command match {
    case psuedoCommand(c) => Some(c)
    case _                => None
  }
}

case  class Acommand(command: String) extends Command {
  // Format is "@decimalAdress' eg: "@230"
  val commandRegex = "@([0-9]+)".r.anchored

  val addressInDecimal: Option[Short] = command match {
    case commandRegex(addr) => Try(addr.toShort).toOption
    case _                  => None
  }

  def binaryInstruction: Option[String] = {
      addressInDecimal
        .flatMap(Address15.toAddress15)
        .map(addr => s"0${addr}")
  }
}

case class Ccommand(command: String) extends Command {
  val destCompuJump     = "(.*)=(.*);(.*)".r.anchored
  val destComp = "(.*)=(.*)".r.anchored
  val compJump = "(.*);(.*)".r.anchored
  val comp     = "(.*)".r.anchored

  val (destOpt, cmpOpt, jumpOpt): Tuple3[Option[String], Option[String], Option[String]] = command match {
    case destCompuJump(d, c, j) => (Some(d), Some(c), Some(j))
    case destComp(d, c)         => (Some(d), Some(c), Some(""))
    case compJump(c, j)         => (Some(""),Some(c), Some(j))
    case comp(c)                => (Some(""), Some(c), Some(""))
    case _                      => (None, None, None)
  }

  def binaryInstruction: Option[String] =
    for {
      dest     <- destOpt
      cmp      <- cmpOpt
      jump     <- jumpOpt
      destBin  <- SymbolTable.destMap.get(dest)
      compBin  <- SymbolTable.compMap.get(cmp)
      jumpBin  <- SymbolTable.jumpMap.get(jump)
    } yield {
      s"111${compBin}${destBin}${jumpBin}"
    }
}