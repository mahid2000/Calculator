package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {

  private Calculator tester = null;
  private Random random = new Random();

  @BeforeEach
  void setUp() {
    this.tester = new RevPolishCalc();
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
    /* Method to test if an Exception is not thrown 
       Inspired by Andrii Abramov
       https://stackoverflow.com/questions/17731234/how-to-test-that-no-exception-is-thrown */
    try {
      assertEquals(tester.evaluate(temp), Float.valueOf(temp),
          " the String temp of a randomly generated integer should return itself as a float");
    } catch (InvalidExpressionException e) {
      fail(temp + " threw a InvalidExpressionException " + e);
    }

  }

}
