package calculator;

import java.util.Scanner;

/**
 * Reverse Polish Notation implementation of Calculator.
 *
 * @author Mahid
 *
 */
public class RevPolishCalc implements Calculator {


  private NumStack ram;

  /**
   * Constructor for Calculator's memory Stack.
   *
   */
  public RevPolishCalc() {
    this.ram = null;
  }

  @Override
  public float evaluate(String calculate) throws InvalidExpressionException {
    // Check if Expression is null
    if (calculate == null || calculate.equals("")) {
      throw new InvalidExpressionException("Expression is Null");
    }

    // Initialise NumStack
    ram = new NumStack();
    float output = 0;

    try (Scanner calculation = new Scanner(calculate)) {
      while (calculation.hasNext()) {
        // if next item in string is a float then push it to numStack
        if (calculation.hasNextFloat()) {
          float fl = calculation.nextFloat();
          ram.push(fl);
        } else {
          // if it is not a float then check if its a symbol
          String symbol = calculation.next();
          if (symbol.equals(Symbol.PLUS.getSymbol())) {
            /*
             * if it is a PLUS symbol then pop previous two entry's from numStack, add them and push
             * back the result
             */
            float opp2 = ram.pop();
            float opp1 = ram.pop();
            output = opp1 + opp2;
            ram.push(output);
          }
          if (symbol.equals(Symbol.MINUS.getSymbol())) {
            /*
             * if it is a MINUS symbol then pop previous two entry's from numStack, switch them and
             * subtract them and push back the result
             */
            float opp2 = ram.pop();
            float opp1 = ram.pop();
            output = opp1 - opp2;
            ram.push(output);
          }
          if (symbol.equals(Symbol.TIMES.getSymbol())) {
            /*
             * if it is a TIMES symbol then pop previous two entry's from numStack,
             * multiply them and then push back the result
             */
            float opp2 = ram.pop();
            float opp1 = ram.pop();
            output = opp1 * opp2;
            ram.push(output);
          }
          if (symbol.equals(Symbol.DIVIDE.getSymbol())) {
            /*
             * if it is a DIVIDE symbol then pop previous two entry's from numStack,
             * divide the first popped value by the second popped value and push back the result
             * 
             */
            float opp2 = ram.pop();
            if (opp2 == 0) {
              System.out.print("check throw");
              throw new InvalidExpressionException(" You Cannot Divide By 0 !!! ");
            }
            float opp1 = ram.pop();
            output = opp1 / opp2;
            ram.push(output);
          }

        }
      }
      output = ram.pop();
    } 
    // previously returned input String as a Float to pass test 3
    // return Float.valueOf(calculate);
    // now return last popped output
    return output;
  }

}
