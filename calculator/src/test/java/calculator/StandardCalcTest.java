package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {

  private Calculator tester;
  private Random random = new Random();

  @BeforeEach
  void setUp() {
    tester = new StandardCalc();
  }

  // Test 1: Test to see if evaluate() throws InvalidExpressionException when input is null
  @Test
  void testNull() {
    assertThrows(InvalidExpressionException.class, () -> tester.evaluate(""),
        "the calculator should throw a InvalidExpressionException if the expression is empty");
    assertThrows(InvalidExpressionException.class, () -> tester.evaluate(null),
        "the calculator should throw a InvalidExpressionException if the expression is null");
  }

  // Test 2: Test to see if evaluate() can evaluate the String "0"
  @Test
  void testZero() throws InvalidExpressionException {
    assertEquals(tester.evaluate("0"), 0.00,
        "the String '0' should not throw a InvalidExpressionException");
  }

  // Test 3: Test to see if evaluate() can evaluate a random Integer String
  @Test
  void testRandInt() throws InvalidExpressionException {
    final String temp = String.valueOf(random.nextInt());

    // assertDoesNotThrow was pointed out to me by a colleague Isacc during time spent in the lab
    // (Surname Unknown)
    assertDoesNotThrow(() -> {
      assertEquals(tester.evaluate(temp), Float.valueOf(temp),
          " the String temp of a randomly generated integer should return itself as a float");
    });
  }

  // Test 4: Test to see if evaluate() can perform addition
  @Test
  void testAdd() throws InvalidExpressionException {
    float f1 = random.nextFloat();
    final float f2 = random.nextFloat();
    final float reasult = f1 + f2;
    final String revPol = f1 + " " + "+" + " " + f2;
    assertEquals(tester.evaluate(revPol), reasult,
        "when + is detected, pop last two entrys on numstack, add them and then push them back on");
  }

  // Test 5: Test to see if evaluate() can perform subtraction
  @Test
  void testSubtract() throws InvalidExpressionException {
    float f1 = random.nextFloat();
    final float f2 = random.nextFloat();
    final float reasult = f1 - f2;
    final String revPol = f1 + " " + "-" + " " + f2;
    assertEquals(tester.evaluate(revPol), reasult,
        "when - is detected, pop last two entrys on numstack find the difference and push back on");
  }

  // Test 6: Test to see if evaluate can perform multiplication
  @Test
  void testMultiply() throws InvalidExpressionException {
    float f1 = random.nextFloat();
    final float f2 = random.nextFloat();
    final float reasult = f1 * f2;
    final String revPol = f1 + " " + "*" + " " + f2;
    assertEquals(tester.evaluate(revPol), reasult,
        "when * is detected, pop last two entrys on numstack find the product and push back on");
  }

  /*
   * Test 7: Test to see if evaluate can perform division and throws an InvalidExpressionException
   * when divisor is 0
   */
  @Test
  void testDivide() throws InvalidExpressionException {
    float f1 = random.nextFloat();
    final float f2 = random.nextFloat();
    final float reasult = f1 / f2;
    final String revPol = f1 + " " + "/" + " " + f2;
    assertEquals(tester.evaluate(revPol), reasult,
        "when / is detected, pop last two entrys on numstack find the quotient and push back on");
    assertThrows(InvalidExpressionException.class, () -> tester.evaluate("4 0 /"),
        "you should not be able to divide by 0");
  }

  // Test 8: Test to see if evaluate() will work on expressions with brackets
  @Test
  void testBrackets() throws InvalidExpressionException {
    assertEquals(tester.evaluate("( 1 + 2 ) "), 3.0f);
    assertEquals(tester.evaluate("( 1 + 2 ) - 2 "), 1.0f);
    assertEquals(tester.evaluate("( 1 + 2 ) * 2 / ( 1 + 1 ) "), 3.0f);
  }


  // Test 9: Test to see if evaluate() will work on a simple exponent expressions

  @Test
  public final void simpleExp() throws InvalidExpressionException {
    assertEquals(tester.evaluate(" 11 + 9"), 20.0f, "11 + 9 should be 20");
    assertEquals(tester.evaluate(" 1 + 2 + 3"), 6.0f, "1 + 2 + 3 should be 6");
    assertEquals(tester.evaluate(" 9 * ( 1 + 1 ) / 6"), 3.0f, "9 * ( 1 + 1 ) / 6 should be 3");
    assertEquals(tester.evaluate(" ( 27 / ( 9 - 2 ) * 5 + 6 ) * 7"), 177.0f,
        "( 27 / ( 9 - 2 ) * 5 + 6 ) * 7 should be 177");
    assertEquals(tester.evaluate(" ( 20 - 4 ) * 6"), 96.0f, "( 20 - 4 ) * 6 should be 96");
    assertEquals(tester.evaluate(" ( ( 6 + 6 + 6 ) / 4 ) * 2"), 9.0f,
        "( ( 6 + 6 + 6 ) / 4 ) * 2 should be 9");
  }



}
