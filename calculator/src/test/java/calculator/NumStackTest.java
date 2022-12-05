package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
  private NumStack tested = null;

  @BeforeEach
  public void setup() {
    tested = new NumStack();
  }

  @Test
  void testEmpty() {
    assertEquals(tested.isEmpty(), true,
        "an empty NumStack should return True when .isEmpty() method is applied");
    assertThrows(EmptyStackException.class, () -> tested.pop(),
        "an empty NumStack should throw a EmptyStackException if pop() is called");
  }
}
