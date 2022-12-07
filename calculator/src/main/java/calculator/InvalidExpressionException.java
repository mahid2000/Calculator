package calculator;

/**
 * Custom Exception class thrown when evaluating an Invalid Expression.
 *
 * @author Mahid
 *
 */
public class InvalidExpressionException extends Exception {
  /**
   * Auto generated serial number to help differentiate InvalidExpressionException from other
   * Exceptions.
   *
   */
  private static final long serialVersionUID = 1944082334437244666L;

  /**
   * Method to call superclass Exceptions method which returns error message. 
   *
   * @param error message in a String Format
   */
  public InvalidExpressionException(final String error) {
    super(error);
  }
}
