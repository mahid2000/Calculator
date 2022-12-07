package calculator;

/**
 * Reverse Polish Notation implementation of Calculator.
 *
 * @author Mahid
 *
 */
public class RevPolishCalc implements Calculator {

  @SuppressWarnings("unused")
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
    // TODO Auto-generated method stub
    if (calculate == null || calculate.equals("")) {
      throw new InvalidExpressionException("Expression is Null");
    }
    // return input String as a Float to pass test 3
    return Float.valueOf(calculate);
  }

}
