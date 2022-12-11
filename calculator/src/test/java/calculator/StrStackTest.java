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

  // Test 2: Test to see if push() pushes an Entry into StrStack
  @Test
  void testPush() {
    tested.push(Symbol.PLUS.getSymbol());
    assertEquals(tested.isEmpty(), false,
        "if a String is pushed onto the StrStack then it should not be empty");
  }

  // Test 3: Test to see if pop() pops a String Entry off StrStack
  @Test
  void testPop() {
    final String s = " 1 1 + ";
    tested.push(s);
    assertEquals(tested.pop(), " 1 1 + ",
        "if a String is pushed onto the OpStack then popping should return that Srring");
    assertEquals(tested.isEmpty(), true,
        "if a Symbol.PLUS is pupopped off OpStack then isEmpty() should return True");
  }
  



}