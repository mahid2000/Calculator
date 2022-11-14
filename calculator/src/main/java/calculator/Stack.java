package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Stack class implementation of a stack of Entry objects.
 * 
 * @author Mahid Inspired by Dave Cohen
 *
 */
public class Stack {
  private int size = 0;
  private ArrayList<Entry> entries = new ArrayList<Entry>();

  /**
   * Method to return the size of ArrayList Stack
   * 
   * @return size of stack.
   */
  public int size() {
    return size;
  }

  /**
   * Method to push Entry objects onto stack.
   * 
   * @param e Entry provided by user.
   */
  public void push(Entry e) {
    entries.add(e);
    size++;
  }

  /**
   * Method to pop Entry objects off stack. Removes Entry from stack.
   * 
   * @return Entry at top of stack
   */
  public Entry pop() {
    if (entries.size() <= 0) {
      throw new EmptyStackException();
    }
    return entries.remove(--size);
  }

  /**
   * Method to get Entry at top of stack without removing it.
   * 
   * @return Entry at top of stack
   */
  public Entry top() {
    if (entries.size() <= 0) {
      throw new EmptyStackException();
    }
    return entries.get(size - 1);
  }

}
