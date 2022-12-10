package calculator;

/**
 * CalcModel class to hide implementation of Calculators and store last answer in memory.
 *
 * @author Mahid
 *
 */
public class CalcModel {

  private final Calculator revPolCalc;
  private NumStack memory;

  /**
   * Constructor to initialise calculators and memory stack.
   * 
   */
  public CalcModel() {
    revPolCalc = new RevPolishCalc();
    memory = new NumStack();
  }

  /**
   * Factory method to call different implementations of calculator to perform their respective
   * calculations.
   *
   * @param calculation String expression to be evaluated
   * @param isInfix boolean stating weather expression is infix or postfix
   * @return float calculated answer
   */
  public final float calculate(final String calculation, final boolean isInfix) {
    if (isInfix) {
      // TO-DO: implement function to turn postfix notation to infix
      System.out.print("not yet implemented...");
      return Float.NaN;
    }
    // Try evaluate the postfix expression by passing the calculation String to RevPolishCalc
    try {
      // Push answer into memory for future use
      memory.push(revPolCalc.evaluate(calculation));
      // Return the answer
      return revPolCalc.evaluate(calculation);
    } catch (InvalidExpressionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // TO-DO: return helpful error message here
    return Float.NaN;
  }
}
