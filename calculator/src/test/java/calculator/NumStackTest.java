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
  
  
}
