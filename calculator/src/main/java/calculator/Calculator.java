package calculator;

/**
 * Abstract Calculator class.
 *
 * @author Mahid
 *
 */
public interface Calculator {
  // Had to make custom Exception class to throw InvalidExpressionException as requested by client.
  /**
   * Abstract method to evaluate String expressions.
   *
   * @param calculate String expression to be calculated
   * @return float calculated value
   * @throws InvalidExpressionException when expression cannot be calculated
   */
  float evaluate(final String calculate) throws InvalidExpressionException;
}
