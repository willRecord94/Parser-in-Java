# Parser-in-Java

University assignment to create parsing algortihms that utilise context-free grammars. This repository was an assignment I completed for The University of Bath in 2021.

- Course: MSc Computer Science
- Module: Foundations of Computation

### Assignment Background:

- Context-free grammars are used in modelling the syntax of programming languages.

- A compiler for such a language will include a parser which uses an algorithm to determine whether a given string belongs to the language generated by a given context free grammar and, if so, constructs a parse tree of the string.

- The compiler then goes on to translate this parse tree into low-level machine code.

### Task:

The assignment is broken down into the following parts:

A. You will be given a concrete context-free grammar for arithmetic expressions which you must convert to Chomsky normal form. You will implement your converted grammar, so that it can be used to run tests.

- src/MyGramar.java

B. You will implement a general algorithm for deciding whether or not an input string w is generated by an arbitrary input grammar in Chomsky normal form.

- Input: A context-free grammar G in Chomsky normal form together with a word w

- Output: A boolean value indicating whether or not w 2 L(G)

- src/Parser.java

### Note: For this assignment I only needed to implement the algorithm code found in the two classes shown above. All other code was provided by the academic staff:

### Running the algorithms:

TBC


