package com.study.nandtotetris.assembler

import scala.util.Try

sealed trait MemoryAddress15 {
  def at14 : Boolean
  def at13 : Boolean
  def at12 : Boolean
  def at11 : Boolean
  def at10 : Boolean
  def at9 : Boolean
  def at8 : Boolean
  def at7 : Boolean
  def at6 : Boolean
  def at5 : Boolean
  def at4 : Boolean
  def at3: Boolean
  def at2 : Boolean
  def at1: Boolean
  def at0 : Boolean

  def print: String =
    List(at14, at13, at12, at11, at10, at9, at8, at7, at6, at5, at4, at3, at2, at1, at0)
    .map( bit => if(bit) "1" else "0")
    .mkString
}

case class Address15 (
  at14: Boolean,
  at13: Boolean,
  at12: Boolean,
  at11: Boolean,
  at10: Boolean,
  at9: Boolean,
  at8: Boolean,
  at7: Boolean,
  at6: Boolean,
  at5: Boolean,
  at4: Boolean,
  at3: Boolean,
  at2: Boolean,
  at1: Boolean,
  at0: Boolean
) extends MemoryAddress15


object Address15 {
  def leftPad(str:String,
              paddedLength:Int,
              ch:Char ='.' ) : String = {
    var remLength = paddedLength - str.length;

    if (remLength <= 0) {
      return str;
    }

    val builder = StringBuilder.newBuilder

    for( a <- 0 until remLength){
      builder.append(ch);
    }

    builder.append(str);

    return builder.toString();
  }

  def toAddress15(short: Short): Option[String] = {
    val isInRange = true

    if(isInRange){
      Some(
        leftPad(short.toBinaryString, 15, '0')
      )
    } else {
      None
    }
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