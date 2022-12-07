package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {

  private Calculator tester = null;

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

}
