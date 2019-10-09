* Memory chips.
   Here, we introduce the discrete time concept (rather than considering time as continuous). This is important to abstract way the delays in propagating the voltage in physical implementation. Basic unit of time is one clock cycle. Memory chips are nothing but circuits that can `remember` high/low voltage over discrete time. They are called sequential chips.
* Once we designed a a `bit` storage, same can be leveraged to create 16 bit memory register. 16 here forms the word length of the Hack computer. Word is the unit of information that can be
  addressed and moved at a time.
* important to keep in mind that these `bit`s are re-usable and volatile.
   Reusable : same `bit` can be used to store different values at different intervals of time. Driven by the load and input bits
   Volatile: Once the power is cut, memory is erased.    
* 16 bit registers are bundled together to form memory chips.
* Given a memory chip can have many registers, its necessity to introduce `address` to these registers.
* Only one register from a memory chip is selected at a time which is denoted by the address bits.
* Memory hierarchy:
  Main memory -> cache memory -> register memory (here it is referring to cpu registers)
  Given, only one memory register can be addressed at a given time and selecting that memory from millions of registers is a time taking process, a hierarchy of memories are introduced.
  Logically there are no difference in how they store and retrieve data. However, the difference is in physical implementation. Faster the memory access implies costlier the implementation resulting in smaller in capacity. Closer to the CPU, more faster the memory.
