The course so far has been really interesting. It is connecting the dots. Almost all of the topics discussed here in the course has been part of the syllabus in my B.tech degree. But I feel like there each topic has been discussed and/or looked in very deep so that we( at least I) got lost in the details. As a result the overall picture of a computer faded away. But now, I can visualise a basic computer that is build using simple logic gates.

Below are my synopsis regarding ALU:

*  Why zeros and ones ?
   Everywhere we can read that computers understand only zeros and ones. We could argue that, it is wrong. Computers only understand high voltage and low voltage. Zeros and Ones are nothing but an abstraction used to represent low and high voltage respectively. One can choose `a` and `b` instead of zero and one.
*  Using basic logic gates construct an ALU (Arithmetic and Logic Unit).
*  All the operations in ALU are combinational i.e they are instantaneous.
   i.e the operations are take effect within no time.
*  The number of operations supported by ALU is a major design concern.
*  The trade off here is hardware-software. Given the fact that all the Arithmetic and Logic operations can be achieved through a basic set of operations, the designer can choose which all
   operations should be implemented on hardware, apart from the basic ones consider cost-performance trade offs.
*  A set of Arithmetic and logic operations are built into the ALU that are chained. i.e output of one operation becomes input of the next. With a set of control input, whether to apply or not apply these operations on input is decided. The number of operations, sequence of operations and control bits are part of the design process of ALU which is complex. Now control bits form the instruction set of an ALU.   
