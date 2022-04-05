import java.util.ArrayList;

import computation.contextfreegrammar.*;
import computation.derivation.*;
import computation.parser.*;
import computation.parsetree.*;

// ******************************  PART C: ******************************
// 1. List all derivations in G with 2n − 1 steps, where n is the length of w, unless n = 0, in which case list all derivations with one step. 
// 2. If any of these derivations generate w, return true. If not, return false.
// *********************************************************************

public class Parser implements IParser {

    private int wordLen;
    private int stepNum;
    private int stepsLeft;
    private Variable startVar;
    private Word startWord;
    private Derivation d;

    private ArrayList<Derivation> derivationArray = new ArrayList<Derivation>();

    public ArrayList<Derivation> createDerivations(ArrayList<Derivation> array, ContextFreeGrammar cfg){
    // To create leftmost derivation take the arraylist of derivations and return a new list with all the possible rules applied to the latest word's first variable.
    ArrayList<Derivation> newArray = new ArrayList<Derivation>();

    for(int i = 0; i < array.size(); i++){
    Word latestWord = array.get(i).getLatestWord();
      //Search for first instance of a variable in our latest word.
      for(int j = 0; j < latestWord.length(); j++){
        if(!latestWord.get(j).isTerminal()){
          //Look for relevant rules for the variable
          for(Rule rule : cfg.getRules()){
            if(rule.getVariable().equals(latestWord.get(j))){
              Derivation extended = new Derivation(array.get(i));
              Word replacementWord = latestWord.replace(j, rule.getExpansion());
              extended.addStep(replacementWord, rule, j);
              newArray.add(extended);
            }
          }
          // Once we find a symbol we can break out
          break; 
        }
      }      
    }
    return newArray;
  }

    public ArrayList<Derivation> trimDerivations(ArrayList<Derivation> array, int stepsLeft){
        //Trims derivation list in line with 2n-1 steps
        ArrayList<Derivation> newArray = new ArrayList<Derivation>();
        // Iterates through derivations in array
        for(int i = 0; i < array.size(); i++){
            int variableCount = 0;
            Word latestWord = array.get(i).getLatestWord();
            for(Symbol symbol : latestWord){
                if(!symbol.isTerminal()){
                    variableCount++;
                }
            }
            if(variableCount <= stepsLeft){
                newArray.add(array.get(i));
            }
        }
    return newArray;
   }

    private boolean emptyWordPresent(ContextFreeGrammar cfg){
        for(Rule rule : cfg.getRules()){
            if(rule.getExpansion().equals(Word.emptyWord)){
                return true;
            }
        }
    return false;
  }
  
    public boolean isInLanguage(ContextFreeGrammar cfg, Word w){
        wordLen = w.length();
        // If length is = 0 then we know that this is the empty word
        // Check if E accepted by our grammar
        if(wordLen == 0){
            return emptyWordPresent(cfg);
        }
        // Use our 2n - 1 calculation again
        stepNum = (wordLen * 2) - 1;
        stepsLeft = stepNum;
        startVar = cfg.getStartVariable();
        startWord = new Word(startVar);
        d = new Derivation(startWord);
        derivationArray.add(d);
        
        //While loop builds out a list of possible derivations
        while(stepsLeft > 0){
            derivationArray = createDerivations(derivationArray, cfg);
            derivationArray = trimDerivations(derivationArray, stepsLeft);
            stepsLeft--;
        }
        //Checks if input word is present in final list of derivations
        for(Derivation der : derivationArray){
            if(der.getLatestWord().equals(w)){
                return true;
            } 
        }    
    return false;
    }

// ******************************  PART D: ******************************
// Adapt your code so that it returns a parse tree whenever the input word w has a derivation in the input grammar 
// cfg, and just null otherwise.
// *********************************************************************


    public ParseTreeNode generateParseTree(ContextFreeGrammar cfg, Word w) {

        // Sorry I gave this a good attempt but couldn't get the code working in time sadly!

        return null;
    } 
}