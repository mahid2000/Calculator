package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
  private NumStack tested = null;


  // Before each test initialises an empty NumStack
  @BeforeEach
  public void setup() {
    tested = new NumStack();
  }

  // Test 1: Test to see if pop() and isEmpty() recognise the NumStack as empty
  @Test
  void testEmpty() {
    assertEquals(tested.isEmpty(), true,
        "an empty NumStack should return True when .isEmpty() method is applied");
    assertThrows(EmptyStackException.class, () -> tested.pop(),
        "an empty NumStack should throw a EmptyStackException if pop() is called");
  }

  // Test 2: Test to see if push() pushes a Entry into NumStack
  @Test
  void testPush() {
    tested.push((float) 6.9);
    assertEquals(tested.isEmpty(), false,
        "if a float 6.9 is pushed onto the NumStack then it should not be empty");
  }

  // Test 3: Test to see if pop() pops a Numeric Entry off NumStack
  @Test
  void testPop() {
    tested.push((float) 6.9);
    assertEquals(tested.pop(), (float) 6.9,
        "if a float 6.9 is pushed onto the NumStack then popping should return flaot 6.9");
  }
  
  // Test 4: Test to see if pop() pops the Numeric Entry at the top of NumStack
  @Test
  void testPushPop() {
    tested.push((float) 6.9);
    tested.push((float) 2.1);
    tested.push((float) 5.200);
    tested.push((float) 9.11);
    tested.pop();
    tested.push((float) 4.20);
    assertEquals(tested.pop(), (float) 4.20,
        "popping should return the Numeric Entry at the top of the NumStack");
  }

}
