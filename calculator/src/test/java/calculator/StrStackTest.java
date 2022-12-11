package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {
  
  private StrStack tested;

  // Before each test initialises an empty StrStack
  @BeforeEach
  public void setup() {
    tested = new StrStack();
  }

  // Test 1: Test to see if pop() and isEmpty() recognise the StrStack as empty
  @Test
  void testEmpty() {
    assertEquals(tested.isEmpty(), true,
        "an empty StrStack should return True when .isEmpty() method is applied");
    assertThrows(EmptyStackException.class, () -> tested.pop(),
        "an empty StrStack should throw a EmptyStackException if pop() is called");
  }




}