package calculator;

import java.util.Scanner;


/**
 * Standard implementation of calculator using RevPolishCalc.
 *
 * @author Mahid inspired by Vijay Sinha https://java2blog.com/infix-to-postfix-java/
 *
 */
public class StandardCalc implements Calculator {
  private Calculator rpCalc;
  private StrStack postFix;
  private OpStack operators;
  private float output;

  /**
   * Constructor for StandardCalc() which initialises two Stack implementations which can hold
   * Strings and Symbols and an instance of RevPolishcalc.
   * 
   */
  public StandardCalc() {
    rpCalc = new RevPolishCalc();
    postFix = new StrStack();
    operators = new OpStack();
  }

  /**
   * Method to set precedence of operations.
   *
   * @author Vijay Sinha https://java2blog.com/infix-to-postfix-java/.
   *
   * @param s String operator to check precedence of
   * @return integer value of precedence
   */
  public static int precedence(String s) {
    if (s.charAt(0) == '+' || s.charAt(0) == '-') {
      return 1;
    } else if (s.charAt(0) == '*' || s.charAt(0) == '/') {
      return 2; // * and / divide have higher precedence.
    }
    return 0;
  }

  /**
   * Method to convert Infix string expression into Postfix.
   *
   * @author Mahid inspired by Vijay Sinha https://java2blog.com/infix-to-postfix-java/.
   *
   * @param exp String infix expression
   * @return String postfix expression
   */
  public String in2post(String exp) {
    Scanner convert = new Scanner(exp);
    while (convert.hasNext()) {
      // scanner get next object
      String ch = convert.next();
      // if next object is a ( then push to operator stack
      if (ch.equals(Symbol.LEFT_BRACKET.getSymbol())) {
        operators.push(Symbol.LEFT_BRACKET);
      } else if (ch.matches("[-+]?[0-9]*\\.?[0-9]+")) {
        // check if next object is a float using Regular expressions and push it to String Stack
        // regex String was obtained from
        // https://www.studytonight.com/java-examples/how-to-check-if-a-string-is-numeric-in-java
        postFix.push(ch + "");
      } else if (ch.equals(Symbol.RIGHT_BRACKET.getSymbol())) {
        /*
         * if next object is ) then pop two float Strings from StrStack and a symbol from OpStack
         * and ADD them into a string which is pushed back onto the StrStack. repeat until only ( is
         * left in the OpStack. Note that the two floats are added together in reverse order to
         * account for division
         */
        while (!operators.top().equals(Symbol.LEFT_BRACKET)) {
          String op = operators.pop().getSymbol();
          String first = postFix.pop();
          String second = postFix.pop();
          // Create new postfix expression
          String update = second + " " + first + " " + op;
          // update postfix
          postFix.push(update);
        }
        // pop '(' from stack to empty it
        operators.pop();
      } else if (ch.equals(Symbol.PLUS.getSymbol()) || ch.equals(Symbol.MINUS.getSymbol())
          || ch.equals(Symbol.TIMES.getSymbol()) || ch.equals(Symbol.DIVIDE.getSymbol())) {
        // Repeat updating postfix for remaining operators in OpStack
        while (!operators.isEmpty() && !operators.top().equals(Symbol.LEFT_BRACKET)
            && precedence(ch) <= precedence(operators.top().getSymbol())) {
          String op = operators.pop().getSymbol();
          String first = postFix.pop();
          String second = postFix.pop();
          String update = second + " " + first + " " + op;
          postFix.push(update);
        }
        // push next operator onto OpStack after checking precedence
        if (ch.equals(Symbol.DIVIDE.getSymbol())) {
          operators.push(Symbol.DIVIDE);
        } else if (ch.equals(Symbol.TIMES.getSymbol())) {
          operators.push(Symbol.TIMES);
        } else if (ch.equals(Symbol.PLUS.getSymbol())) {
          operators.push(Symbol.PLUS);
        } else if (ch.equals(Symbol.MINUS.getSymbol())) {
          operators.push(Symbol.MINUS);
        }
      }
    }

    /*
     * Check is there are any remaining operators in OpStack at the end and update postfix
     * accordingly
     */
    while (!operators.isEmpty()) {
      String op = operators.pop().getSymbol();
      String first = postFix.pop();
      String second = postFix.pop();
      String update = second + " " + first + " " + op;
      postFix.push(update);
    }
    // pop final postfix from StrStack
    final String output = postFix.pop();
    // close scanner to prevent resource leak and return postfix expression
    convert.close();
    return output;
  }

  /**
   * Overridden evaluate() takes in String of a calculation in standard notation, turns it into
   * reverse polish notation and returns a float.
   *
   * @param calculate String calculation expression
   * @return output evaluated float
   * @throws InvalidExpressionException when calculation expression is not valid
   *
   */
  @Override
  public float evaluate(String calculate) throws InvalidExpressionException {
    // check if expression is null and throw InvalidExpressionException if it is
    if (calculate == null || calculate.equals("")) {
      throw new InvalidExpressionException("Expression is Null");
    }
    /*
     * call in2Post() passing it the infix expression as a argument and returning a postfix String
     * expression
     */
    String calculation = in2post(calculate);
    // try RevPolishCalc to evaluate expression
    try {
      output = rpCalc.evaluate(calculation);
    } catch (InvalidExpressionException e) {
      // if InvalidExpressionException is thrown return a error message
      System.out.print("Could not evaluate expression " + e);
      throw e;
    }
    // return float output of evaluated expression
    return output;
  }
}
