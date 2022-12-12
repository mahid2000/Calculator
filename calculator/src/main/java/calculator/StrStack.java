package calculator;

import java.util.EmptyStackException;

/**
 * Stack class implementation of String Entry objects. 
 *
 * @author Mahid Inspired by Stack.java
 *
 */
public class StrStack {

  private final Stack strStack;

  /**
   * Constructor to initialise a new Stack.
   *
   */
  public StrStack() {
    this.strStack = new Stack();
  }

  /**
   * Method to push String Entry objects onto stack.
   *
   * @param s String provided by user
   */
  public final void push(final String s) {
    this.strStack.push(new Entry(s));
  }

  /**
   * Method to pop String Entry objects off stack. Removes String Entry from Stack
   *
   * @return String Entry at top of stack or error message if not a valid String
   * @throws EmptyStackException if stack is empty
   */
  public final String pop() throws EmptyStackException {
    /* try/catch block to catch IllegalArgumentException thrown by toString() and return
    a error message */
    try {
      return this.strStack.pop().getString();
    } catch (IllegalArgumentException e) {
      /* if Illegal Argument exception is thrown return error message */
      return "This is not a valid String " + e;
    }
  }

  /**
   * Method to check if String Stack is empty.
   *
   * @return True if strStack is empty or False if it has a size larger than 0
   */
  public final boolean isEmpty() {
    return this.strStack.size() <= 0;
  }
  
  /**
   * Method to get String at the top of StrStack without removing it.
   *
   * @return String at top of StrStack
   */
  public String top() {
    if (strStack.size() <= 0) {
      throw new EmptyStackException();
    }
    return strStack.top().getString();
  }

}
