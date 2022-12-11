package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {
  
  private OpStack tested;

  // Before each test initialises an empty OpStack
  @BeforeEach
  public void setup() {
    tested = new OpStack();
  }

  // Test 1: Test to see if pop() and isEmpty() recognise the OpStack as empty
  @Test
  void testEmpty() {
    assertEquals(tested.isEmpty(), true,
        "an empty OpStack should return True when .isEmpty() method is applied");
    assertThrows(EmptyStackException.class, () -> tested.pop(),
        "an empty OpStack should throw a EmptyStackException if pop() is called");
  }

  // Test 2: Test to see if push() pushes an Entry into OpStack
  @Test
  void testPush() {
    tested.push(Symbol.PLUS);
    assertEquals(tested.isEmpty(), false,
        "if a Symbol.PLUS is pushed onto the OpStack then it should not be empty");
  }

  // Test 3: Test to see if pop() pops a Symbol Entry off OpStack
  @Test
  void testPop() {
    tested.push(Symbol.PLUS);
    assertEquals(tested.pop(), Symbol.PLUS,
        "if a Symbol.PLUS is pushed onto the OpStack then popping should return Symbol.PLUS");
    assertEquals(tested.isEmpty(), true,
        "if a Symbol.PLUS is pupopped off OpStack then isEmpty() should return True");
  }
  
  // Test 4: Test to see if pop() pops the Symbol Entry at the top of OpStack
  @Test
  void testPushPop() {
    tested.push(Symbol.DIVIDE);
    tested.push(Symbol.INVALID);
    tested.push(Symbol.LEFT_BRACKET);
    tested.push(Symbol.MINUS);
    tested.pop();
    tested.push(Symbol.PLUS);
    assertEquals(tested.pop(), Symbol.PLUS,
        "popping should return the Operater Entry at the top of the OpStack");
    tested.pop();
    tested.pop();
    tested.pop();
    assertEquals(tested.isEmpty(), true,
        "Popping all Entrys should empty the OpStack");
  }


}
