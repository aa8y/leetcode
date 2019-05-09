package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SatisfiabilityOfEqualityEquationsTest {
  private SatisfiabilityOfEqualityEquations solution = new SatisfiabilityOfEqualityEquations();

  @Test
  public void testLeetCodeExample1() {
    String[] equations = {
      "a==b",
      "b!=a"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    String[] equations = {
      "b==a",
      "a==b"
    };
    boolean expected = true;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    String[] equations = {
      "a==b",
      "b==c",
      "a==c"
    };
    boolean expected = true;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample4() {
    String[] equations = {
      "a==b",
      "b!=c",
      "c==a"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample5() {
    String[] equations = {
      "c==c",
      "b==d",
      "x!=z"
    };
    boolean expected = true;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase129() {
    String[] equations = {
      "e!=c",
      "b!=b",
      "b!=a",
      "e==d"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase147() {
    String[] equations = {
      "d!=d",
      "f==c",
      "e==b",
      "c==a"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase15X() {
    String[] equations = {
      "f!=c",
      "f==a",
      "b!=d",
      "b!=d",
      "f!=c"
    };
    boolean expected = true;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase15Y() {
    String[] equations = {
      "f==e",
      "e==a",
      "a==a",
      "e==a",
      "b!=b"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase153() {
    String[] equations = {
      "f==a",
      "a==b",
      "f!=e",
      "a==c",
      "b==e",
      "c==f"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase155() {
    String[] equations = {
      "d!=e",
      "d!=g",
      "b!=j",
      "j==b",
      "c!=i",
      "b!=d",
      "j==d"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase165() {
    String[] equations = {
      "b!=f",
      "c!=e",
      "f==f",
      "d==f",
      "b==f",
      "a==f"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase166() {
    String[] equations = {
      "h==j",
      "c!=g",
      "e==j",
      "f!=e",
      "g!=e",
      "j==h",
      "h!=e",
      "j!=a"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase16X() {
    String[] equations = {
      "c!=j",
      "b!=i",
      "j==c",
      "c==k",
      "d!=f",
      "b==k",
      "e!=h"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase170() {
    String[] equations = {
      "g==c",
      "f!=e",
      "e==b",
      "j==b",
      "g!=a",
      "e==c",
      "b!=f",
      "d!=a",
      "j==g",
      "f!=i",
      "a==e"
    };
    boolean expected = false;
    boolean actual = solution.equationsPossible(equations);

    assertEquals(expected, actual);
  }
}
