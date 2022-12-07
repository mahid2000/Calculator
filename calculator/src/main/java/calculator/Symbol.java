package calculator;

/**
 * List of Non-Numeral Symbols that could be added to the calculation.
 *
 * @author Mahid
 *
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "");

  private String symbol;

  /**
   * Constructor for enum Symbol. Sets the String parameter as the Entry Symbol.
   *
   * @param s String format of Symbol Entry.
   */
  private Symbol(String s) {
    this.symbol = s;
  }

  /**
   * Method to create String representation of Symbol and return it.
   *
   * @return String format of enum Symbol.
   */
  public String getSymbol() {
    return this.symbol;
  }


}
