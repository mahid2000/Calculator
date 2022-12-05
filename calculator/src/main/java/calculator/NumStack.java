package calculator;

import java.util.EmptyStackException;

/**
 * Stack class implementation of Numeric Entry objects. ReversePolish notation only uses Stack of
 * numeric values so we have created a facade class to hide the details.
 *
 * @author Mahid Inspired by Stack.java
 *
 */
public class NumStack {

  private final Stack numStack;

  /**
   * Constructor to initialise a new Stack.
   * 
   */
  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * Method to push Numeric Entry objects onto stack.
   *
   * @param i Float provided by user
   */
  public final void push(final float i) {
    this.numStack.push(new Entry(i));
  }

  /**
   * Method to pop Numeric Entry objects off stack. Removes Numeric Entry from Stack
   *
   * @return Numeric Entry at top of stack
   * @throws EmptyStackException if stack is empty
   */
  public final float pop() throws EmptyStackException {
    return this.numStack.pop().getValue();
  }

  /**
   * Method to check if Numeric Stack is empty.
   *
   * @return True if NumSatck is empty or False if it has a size larger than 0
   */
  public final boolean isEmpty() {
    return this.numStack.size() <= 0;
  }

}
