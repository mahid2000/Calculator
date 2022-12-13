package calculator;

import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Suite of Test Classes.
 *
 * @author Mahid inspired by Dave Cohen
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({StackTest.class, EntryTest.class, NumStackTest.class, OpStackTest.class,
    StrStackTest.class, RevPolishCalcTest.class, StandardCalcTest.class, CalcModelTest.class})
@SuiteDisplayName("Test Suite for CS2800 Calcualtor application")
public class TestSuite {
}
