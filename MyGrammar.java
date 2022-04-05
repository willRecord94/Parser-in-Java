import computation.contextfreegrammar.*;
import java.util.List;
import java.util.ArrayList;

public class MyGrammar {
	public static ContextFreeGrammar makeGrammar() {

	// ****************************** PART B. ******************************
    // Implement your converted grammar, so that it can be used to run tests.
    // *********************************************************************
    
    // 1. Create the variables for the grammar.

    Variable S0 = new Variable("S0");
    Variable S = new Variable('S');
    Variable T = new Variable('T');
    Variable F = new Variable('F');
    Variable A = new Variable('A');
    Variable B = new Variable('B');
    Variable C = new Variable('C');
    Variable L = new Variable('L');
    Variable P = new Variable('P');
    Variable M = new Variable('M');
    Variable R = new Variable('R');

    // 2. Create the terminals for the grammar.

    Terminal x = new Terminal('x');
    Terminal plus = new Terminal('+');
    Terminal mult = new Terminal('*');
    Terminal one = new Terminal('1');
    Terminal zero = new Terminal('0');
    Terminal left = new Terminal('(');
    Terminal right = new Terminal(')');

    // 3. Create an arrayList (resizeable array) for our Chomsky Normal Form rules and add all the rules worked out in part 1 of the assignment.

    List<Rule> rules = new ArrayList<Rule>();

    //Rules for S0

    Rule s0r1 = new Rule(S0, new Word(S, A));
    Rule s0r2 = new Rule(S0, new Word(T, B));
    Rule s0r3 = new Rule(S0, new Word(L, C));
    Rule s0r4 = new Rule(S0, new Word(one));
    Rule s0r5 = new Rule(S0, new Word(zero));
    Rule s0r6 = new Rule(S0, new Word(x));

    rules.add(s0r1);
    rules.add(s0r2);
    rules.add(s0r3);
    rules.add(s0r4);
    rules.add(s0r5);
    rules.add(s0r6);

    // S

    Rule sr1 = new Rule(S, new Word(S, A));
    Rule sr2 = new Rule(S, new Word(T, B));
    Rule sr3 = new Rule(S, new Word(L, C));
    Rule sr4 = new Rule(S, new Word(one));
    Rule sr5 = new Rule(S, new Word(zero));
    Rule sr6 = new Rule(S, new Word(x));

    rules.add(sr1);
    rules.add(sr2);
    rules.add(sr3);
    rules.add(sr4);
    rules.add(sr5);
    rules.add(sr6);

    // T
    
    Rule tr1 = new Rule(T, new Word(T, B));
    Rule tr2 = new Rule(T, new Word(L, C));
    Rule tr3 = new Rule(T, new Word(one));
    Rule tr4 = new Rule(T, new Word(zero));
    Rule tr5 = new Rule(T, new Word(x));

    rules.add(tr1);
    rules.add(tr2);
    rules.add(tr3);
    rules.add(tr4);
    rules.add(tr5);

    // F

    Rule fr1 = new Rule(F, new Word(L, C));
    Rule fr2 = new Rule(F, new Word(one));
    Rule fr3 = new Rule(F, new Word(zero));
    Rule fr4 = new Rule(F, new Word(x));

    rules.add(fr1);
    rules.add(fr2);
    rules.add(fr3);
    rules.add(fr4);

    // A,B,C

    Rule ar1 = new Rule(A, new Word(P, T));
    Rule br1 = new Rule(B, new Word(M, F));
    Rule cr1 = new Rule(C, new Word(S, R));

    rules.add(ar1);
    rules.add(br1);
    rules.add(cr1);

    // Operators

    Rule lr1 = new Rule(L, new Word(left));
    Rule pr1 = new Rule(P, new Word(plus));
    Rule mr1 = new Rule(M, new Word(mult));
    Rule rr1 = new Rule(R, new Word(right));
    
    rules.add(lr1);
    rules.add(pr1);
    rules.add(mr1);
    rules.add(rr1);

    ContextFreeGrammar cfg = new ContextFreeGrammar(rules);

		return cfg;
	}
}
