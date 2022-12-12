package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {

  private CalcModel tester;

  @BeforeEach
  void setup() {
    this.tester = new CalcModel();
  }

  // Test 1: Test to see if CalcModel initialises...
  @Test
  void testConstructor() {
    assertTrue(tester instanceof CalcModel);
  }

  // Test 2: Test to see if CalcModel can call RevPolishCalc to calculate the expression
  @Test
  void testCalcRevPol() {
    assertEquals(tester.calculate("1 1 +", false), 2.0f,
        "If boolean inFix is flase the String calcualtion should pass to RevPolishCalc.evaluate()");
  }

  // Test 3: Test to see if CalcModel can call RevPolishCalc to calculate the expression
  @Test
  void testCalcStandard() {
    assertEquals(tester.calculate("1 + 1", true), 2.0f,
        "If boolean inFix is truee the String calcualtion should pass to StandardCalc.evaluate()");
  }

  // Test 4: Test to see if CalcModel.prevAnswer can retrieve previous answer from memory
  @Test
  void testAns() {
    tester.calculate("1 + 1", true);
    assertEquals(tester.prevAnswer(), 2.0f,
        " testAns() should return previous calcualtions answer if it was stored in memory");
    tester.calculate("1 2 +", false);
    assertEquals(tester.prevAnswer(), 3.0f,
        " testAns() should return previous calcualtions answer if it was stored in memory");
  }

}
