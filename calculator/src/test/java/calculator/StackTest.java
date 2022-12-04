package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
  private Stack tested = null;

  @BeforeEach
  public void setup() {
    tested = new Stack();
  }

  // Test 1: Test to see if size is empty.
  @Test
  void testSize() {
    // Initialy returned 0 but then initialised a private size variable in Stack and made a method
    // to return the size variable. Size was increased in the push method and decreased in the pop
    // method.

    assertEquals(tested.size(), 0, "Test is newly created stack to see that it has size 0");
  }

  // Test 2: Test to see if pushing an Event onto the Stack increases its size
  @Test
  void testPush() {
    // Initialised a ArrayList for the Stack and made a push method that takes an Entry argument and
    // adds it to the Stack and increases size.
    Entry entery1 = new Entry(5.0f);
    tested.push(entery1);
    assertEquals(tested.size(), 1, "When push() is called the Size of the stack should increase");
  }

  // Test 3: Test to see if an EmptyStackException is thrown when an Empty Stack is popped .
  @Test
  void testEmptyPop() {
    // Made a pop method which returned a EmptyStackException if Stack size was 0. Else it removes
    // the last Entry.
    assertThrows(EmptyStackException.class, () -> tested.pop(),
        "you cannot pop from an empty stack");
  }

  // Test 4: Test to see if both Push() and Pop() work in unison. Pushing and popping should leave
  // the Stack empty.
  @Test
  void pushThenPop() {
    Entry entery2 = new Entry(6.0f);
    tested.push(entery2);
    // Popped Entry put into variable so I could call getValue() on it.
    Entry out = tested.pop();
    assertEquals(out.getValue(), 6.0, "Pushing a 6 then popping it should return 6");
    assertEquals(tested.size(), 0, "Pushing a 6 then popping it should give an empty stack");
    assertThrows(EmptyStackException.class, () -> tested.pop(),
        "Push, pop, pop should throw an exception");
  }

  // Test 5: Another test to see if push() and pop() work in unison and is scalable.
  @Test
  void pushTwice() {
    Entry entery1 = new Entry(5.0f);
    Entry entery2 = new Entry(6.0f);
    tested.push(entery1);
    tested.push(entery2);
    Entry out1 = tested.pop();
    Entry out2 = tested.pop();
    assertEquals(out1.getValue(), 6.0,
        "Pushing twice then popping should return the seccond Entry pushed");
    assertEquals(out2.getValue(), 5.0,
        "Pushing twice then popping should return the first thing pushed");
    assertEquals(tested.size(), 0,
        "Pushing Events and then popping them should give an empty stack");
    assertThrows(EmptyStackException.class, () -> tested.pop(),
        "Push, pop, pop should throw an exception");
  }

  // Test 6: Test to see if push() is scalable and doesn't break under load.
  @Test
  void pushLots() {
    // For loop to push 100 entries into stack to show that the ArrayList increases in size, even
    // when a large quantity of Entries are made.
    for (int index = 0; index < 100; index++) {
      Entry enter = new Entry(index + 5);
      tested.push(enter);
    }
    assertEquals(tested.size(), 100, "Pushing should increase the size");
  }

  // Test 7: Test to see if Symbol Events can be pushed onto Stack.
  @Test
  void pushSymbol() {
    Entry entery3 = new Entry(Symbol.PLUS);
    tested.push(entery3);
    assertEquals(tested.size(), 1, "Pushing a entry should increase size of empty stack");
    Entry out = tested.pop();
    assertEquals(out.getSymbol(), Symbol.PLUS, "Pushing PLUS and popping should return '+'");
    assertEquals(tested.size(), 0, "Pushing a five then popping it should give an empty stack");
  }

  // Test to see if Type Events can be pushed onto Stack.
  @Test
  void pushType() {
    Entry enter = new Entry(Type.NUMBER);
    tested.push(enter);
    assertEquals(tested.size(), 1, "Pushing a entry should increase size of empty stack");
    Entry out = tested.pop();
    assertEquals(out.getType(), Type.NUMBER, "Pushing NUMBER and popping should return NUMBER");
    assertEquals(tested.size(), 0, "Pushing a five then popping it should give an empty stack");
  }

  // Test 9: Test to see if Top() works even under load. The Event at the top of the Stack should be
  // returned.
  @Test
  void testTopPop() {
    Entry entery1 = new Entry(1.0f);
    Entry entery2 = new Entry(2.0f);
    Entry entery3 = new Entry(3.0f);
    Entry entery7 = new Entry(8.0f);
    Entry entery8 = new Entry(4.5f);
    Entry entery9 = new Entry(6.9f);
    tested.push(entery1);
    tested.pop();
    tested.push(entery9);
    tested.push(entery2);
    tested.push(entery3);
    // Random Pops to simulate real world Stack usage
    tested.pop();
    tested.push(entery8);
    tested.push(entery7);
    tested.pop();
    Entry top = tested.top();
    // Entry 8 was the last Entry that was pushed and not popped so it will be at the top of the
    // Stack.
    assertEquals(top.getValue(), 4.5,
        "The top entry in the stack should be the one at the end of the stack.");


  }


}


