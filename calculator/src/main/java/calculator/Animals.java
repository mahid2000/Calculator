package calculator;

import java.util.ArrayList;

/**
 * @author Mahid
 *
 * This class is a printable list of text names of animals.
 */
public class Animals {
  /**
   * Prints the list of animals to a String.
   */
  @Override
  public String toString() {
    return "Animals [list=" + list + "]";
  }

  /**
   * The list of animals.
   */
  private ArrayList<String> list;

  /**
   * A default constructor that creates a empty list of animals.
   */
  public Animals() {
    list = new ArrayList<String>();
  }

  /**
   * This method adds a new animal to the list.
   * 
   * @param line the next animal to add.
   */
  public void add(String line) {
    // TODO Auto-generated method stub
    list.add(line);
  }
}
