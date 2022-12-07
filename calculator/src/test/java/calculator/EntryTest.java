package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryTest {
  // Initialise private Entry Objects;
  private Entry entryType;
  private Entry entryValue;
  private Entry entrySymbol;
  private Entry entryString;



  // Creates group of new Entry objects to test before the start of each test.
  @BeforeEach
  void setUp() {
    entryValue = new Entry(1);
    entrySymbol = new Entry(Symbol.MINUS);
    entryType = new Entry(Type.NUMBER);
    entryString = new Entry("1");
  }

  // Test 1: Test to see if Type is recognised and is retrievable.
  @Test
  void testGetType() {
    // Initially returned 0 but after making constructors for each privately initialised data type I
    // returned the enum type.
    assertEquals(entryType.getType(), Type.NUMBER,
        "Tests if Enty Type has been initialised and retrived correctly");
  }

  // Test 2: Test to see if String is recognised and is retrievable.
  @Test
  void testGetString() {
    assertEquals(entryString.getString(), "1",
        "Tests Entry String has been initialised and retrived correctly");
  }

  // Test 3: Tests to see if Symbol is recognised and is retrievable.
  @Test
  void testGetSymbol() {
    assertEquals(entrySymbol.getSymbol(), Symbol.MINUS,
        "Tests if Enty Symbol has been initialised and retrived correctly");
  }

  // Test 4: Tests to see if Value is recognised and is retrievable.
  @Test
  void testGetValue() {
    assertEquals(entryValue.getValue(), 1,
        "Tests if Enty Value has been initialised and retrived correctly");
  }

  // Test 5: Tests to see if Symbol and Type enums are returnable as a String.
  @Test
  void testToString() {
    // At first I returned both Symbol and Type values but the test failed stating I couldn't
    // perform the toString() method on a null value.
    // To apss the test i created 2 if statements to check if either Symbol was null or Type was
    // null.
    // If Symbol was null I returned the string format of Type ad vice versa.
    assertEquals(entryType.toString(), "NUMBER",
        "Checks to see if toString() method displays enums in a String format");
  }


}
