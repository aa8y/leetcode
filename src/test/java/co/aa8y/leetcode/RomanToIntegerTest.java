package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanToIntegerTest {
  private RomanToInteger solution = new RomanToInteger();

  @Test
  public void testLeetCodeExample1() {
    int expected = 3;
    int actual = solution.romanToInt("III");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int expected = 4;
    int actual = solution.romanToInt("IV");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    int expected = 9;
    int actual = solution.romanToInt("IX");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample4() {
    int expected = 58;
    int actual = solution.romanToInt("LVIII");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample5() {
    int expected = 1994;
    int actual = solution.romanToInt("MCMXCIV");

    assertEquals(expected, actual);
  }
}
