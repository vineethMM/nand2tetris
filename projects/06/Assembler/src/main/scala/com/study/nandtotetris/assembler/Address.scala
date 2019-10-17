package com.study.nandtotetris.assembler

import scala.util.Try

object Address15 {
  def leftPad(str:String, paddedLength:Int, ch:Char ='.' ) : String = {
    var remLength = paddedLength - str.length;

    if (remLength <= 0) {
      return str;
    }

    val builder = StringBuilder.newBuilder

    for( a <- 0 until remLength){
      builder.append(ch);
    }

    builder.append(str);

    builder.toString();
  }

  def toAddress15(short: Short): Option[String] = {
     Try (
        leftPad(short.toBinaryString, 15, '0')
      ).toOption
  }

  val r0Address = 0.toShort
  val r1Address = 1.toShort
  val r2Address = 2.toShort
  val r3Address = 3.toShort
  val r4Address = 4.toShort
  val r5Address = 5.toShort
  val r6Address = 6.toShort
  val r7Address = 7.toShort
  val r8Address = 8.toShort
  val r9Address = 9.toShort
  val r10Address = 10.toShort
  val r11Address = 11.toShort
  val r12Address = 12.toShort
  val r13Address = 13.toShort
  val r14Address = 14.toShort
  val r15Address = 15.toShort

  val screenAddress = 16384.toShort
  val keyboardAddress = 24576.toShort

  val spAddress = 0.toShort
  val lclAddress = (1).toShort
  val argAddress = (2).toShort
  val thisAddress = (3).toShort
  val thatAddress = (4).toShort
}