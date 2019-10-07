// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed.
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.



// derive screen size
@24576 // max address = ((256 * 512)/16) + 16384
D=A
@SCREEN
D=D-A
@screen_size
M=D

(WAIT)
  @KBD
  D=M

  @BLACK
  D;JNE

  @color
  M=0
  @SET_SCREEN
  0;JMP

  (BLACK)
     @color
     M=-1
     @SET_SCREEN
     0; JMP

(SET_SCREEN)
  @i
  M=0

  // Store base address to variable `screen_start`
  @SCREEN
  D=A
  @address
  M=D

(LOOP)
   @screen_size
   D=M // base address is also the size of screen
   @i
   D=D-M //
   @WAIT
   D;JEQ     // When all the registers are set, stop program execution

   @color
   D=M      // fetch color into register D
   @address
   A=M      // Set address to current address in `address`
   M=D      // set color to address

   // Increment address
   @address
   M=M+1

   // Increment loop variable
   @i
   M=M+1

  // continue the loop
   @LOOP
   0;JMP
