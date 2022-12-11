package calculator;

import java.util.EmptyStackException;

/**
 * Stack class implementation of Symbol Entry objects. Infix notation uses Stack of Symbol values as
 * well as a Stack of Numeric values so we have created facade classes to hide the details.
 *
 * @author Mahid Inspired by Stack.java
 *
 */
public class OpStack {

  private final Stack opStack;

  /**
   * Constructor to initialise a new Stack.
   * 
   */
  public OpStack() {
    this.opStack = new Stack();
  }

  /**
   * Method to push Symbol Entry objects onto stack.
   *
   * @param s Symbol provided by user
   */
  public final void push(final Symbol s) {
    this.opStack.push(new Entry(s));
  }

  /**
   * Method to pop Symbol Entry objects off stack. Removes Symbol Entry from Stack
   *
   * @return Symbol Entry at top of stack or Symbol.INVALID if Entry is not a a recognised symbol
   * @throws EmptyStackException if stack is empty
   */
  public final Symbol pop() throws EmptyStackException {
    /*
     * try/catch block to catch IllegalArgumentException thrown by getSymbol() and return a
     * Symbol.INVALID if operator is not recognised
     */
    try {
      return this.opStack.pop().getSymbol();
    } catch (IllegalArgumentException e) {
      /* if Illegal Argument exception is thrown return Symbol.INVALID */
      return Symbol.INVALID;
    }
  }

  /**
   * Method to check if Numeric Stack is empty.
   *
   * @return True if NumSatck is empty or False if it has a size larger than 0
   */
  public final boolean isEmpty() {
    return this.opStack.size() <= 0;
  }
}
