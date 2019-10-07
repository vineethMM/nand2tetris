// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

// initialise accumulator
   @acc // declare a variable res which will act as accumulator
   M=0  // initialise accumulator to 0

// declare the loop variable
   @R1
   D=M // set D register to value at R1

   @i
   M=D // initialise the loop variable to value at R1

   @LOOP
   0;JMP // proceed to LOOP

(LOOP)
   @i
   D=M // fetch loop variable

   @STOP
   D; JEQ // if i = 0 then STOP

   @acc
   D=M // fetch acc value

   @R0
   D=D+M // acc = acc + R0

   @acc
   M=D  // store it back in acc

   @i
   M=M-1 // i--

   @LOOP
   0;JMP

(STOP)
   @acc
   D=M
   @R2
   M=D // Store accumulator to R2 register
   @END
   0;JMP

// program termination
(END)
   @END
   0;JMP
