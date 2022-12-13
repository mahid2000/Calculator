package calculator;

import java.util.LinkedList;

/**
 * CalcModel class to hide implementation of Calculators and store last answer in memory.
 *
 * @author Mahid
 *
 */
public class CalcModel {

  final Calculator revPolCalc;
  final Calculator standardCalc;
  final LinkedList<Float> memory;

  /**
   * Constructor to initialise calculators and memory stack.
   * 
   */
  public CalcModel() {
    revPolCalc = new RevPolishCalc();
    standardCalc = new StandardCalc();
    memory = new LinkedList<Float>();
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
      try {
        memory.add(standardCalc.evaluate(calculation));
        return standardCalc.evaluate(calculation);
      } catch (InvalidExpressionException e) {
        e.printStackTrace();
      }
    }
    // Try evaluate the postfix expression by passing the calculation String to RevPolishCalc
    try {
      // Push answer into memory for future use
      memory.add(revPolCalc.evaluate(calculation));
      // Return the answer
      return revPolCalc.evaluate(calculation);
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
    System.out.print("Calcualtion could not be completed...");
    return Float.NaN;
  }
  
  /**
   * Method to return previous answer from memory.
   *
   * @return float previous answer
   */
  public final float prevAnswer() {
    final float ans;
    if (memory != null) {
      ans = memory.getLast();
      return ans;
    }
    return 0.0f;
  }
}

