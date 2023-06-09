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
  private int oppCount = 0;
  private int floCount = 0;

  /**
   * Constructor for Calculator's memory Stack.
   *
   */
  public RevPolishCalc() {
    this.ram = null;
  }

  /**
   * Overridden evaluate() takes in String of a calculation in reverse polish notation and returns a
   * float.
   *
   * @param calculate String calculation expression
   * @return output evaluated float
   * @throws InvalidExpressionException when calculation expression is not valid
   *
   */
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
          floCount += 1;
        } else {
          // if it is not a float then check if its a symbol
          String symbol = calculation.next();
          if (symbol.equals(Symbol.PLUS.getSymbol()) && !ram.isEmpty()) {
            /*
             * if it is a PLUS symbol then pop previous two entry's from numStack, add them and push
             * back the result
             */

            float opp2 = Float.NaN;
            opp2 = ram.pop();
            float opp1 = 0.0f;
            if (!ram.isEmpty()) { 
              opp1 = ram.pop();
            }
            output = opp1 + opp2;
            ram.push(output);
            oppCount += 1;
          }
          if (symbol.equals(Symbol.MINUS.getSymbol()) && !ram.isEmpty()) {
            /*
             * if it is a MINUS symbol then pop previous two entry's from numStack, switch them and
             * subtract them and push back the result
             */
            float opp2 = Float.NaN;
            opp2 = ram.pop();
            float opp1 = 0.0f;
            if (!ram.isEmpty()) { 
              opp1 = ram.pop();
            }
            output = opp1 - opp2;
            ram.push(output);
            oppCount += 1;
          }
          if (symbol.equals(Symbol.TIMES.getSymbol()) && !ram.isEmpty()) {
            /*
             * if it is a TIMES symbol then pop previous two entry's from numStack, multiply them
             * and then push back the result
             */
            float opp2 = Float.NaN;
            opp2 = ram.pop();
            float opp1 = 0.0f;
            if (!ram.isEmpty()) { 
              opp1 = ram.pop();
            }
            output = opp1 * opp2;
            ram.push(output);
            oppCount += 1;
          }
          if (symbol.equals(Symbol.DIVIDE.getSymbol())) {
            /*
             * if it is a DIVIDE symbol then pop previous two entry's from numStack, divide the
             * first popped value by the second popped value and push back the result
             * 
             */
            float opp2 = 0;
            if (!ram.isEmpty()) {
              opp2 = ram.pop();
            }
            // if divisor is 0 then throw InvalidExpressionException
            if (opp2 == 0) {
              throw new InvalidExpressionException(" You Cannot Divide By 0 !!! ");
            }
            if (!ram.isEmpty()) {
              float opp1 = ram.pop();
              output = opp1 / opp2;
              ram.push(output);
            } else {
              ram.push(Float.NaN);
            }
            oppCount += 1;
          }
        }
      }
      calculation.close();
      output = ram.pop();
      if (oppCount <= 0 && floCount >= 2 || oppCount >= floCount) {
        throw new InvalidExpressionException("Operation Invalid...");
      }
    }
    // previously returned input String as a Float to pass test 3
    // return Float.valueOf(calculate);
    // now return last popped output
    return output;
  }

}
