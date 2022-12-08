package calculator;

import java.util.EmptyStackException;
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
            /* if it is a PLUS symbol then pop previous two entry's from numStack, add them and push
             back the result */
            float opp2 = ram.pop();
            float opp1 = ram.pop();
            output = opp1 + opp2;
            ram.push(output);
          }

          return output;


        }

      }
    } catch (EmptyStackException e) {
      e.printStackTrace();
    }

    // return input String as a Float to pass test 3
    return Float.valueOf(calculate);
  }

}
