package com.study.nandtotetris.assembler

import scala.io.Source

import java.io._

object Assembler {

  def main(args: Array[String]): Unit = {
    val instruction = "(.*)//.*".r.anchored
    val lines1 = Source.fromFile(args(0))
      .getLines
      .toList

    val lines = lines1
      .filter( a => !(a.trim.startsWith("//")) && a.trim.length != 0)
      .map{
        case instruction(a) => a.trim
        case a => a.trim
      }

    val asmProgram = AsmProgram(lines)

    // FileWriter
    val file = new File(args(1))
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(asmProgram.binaryProgram.mkString("\n"))
    bw.close()
  }
}
