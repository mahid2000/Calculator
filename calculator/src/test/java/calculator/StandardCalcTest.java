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





}
