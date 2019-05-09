package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AddToArrayFormOfIntegerTest {
  private AddToArrayFormOfInteger solution = new AddToArrayFormOfInteger();

  @Test
  public void testLeetCodeExample1() {
    int[] a = { 1, 2, 0, 0 };
    int k = 34;
    List<Integer> expected = Arrays.asList(1, 2, 3, 4);
    List<Integer> actual = solution.addToArrayForm(a, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[] a = { 2, 7, 4 };
    int k = 181;
    List<Integer> expected = Arrays.asList(4, 5, 5);
    List<Integer> actual = solution.addToArrayForm(a, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    int[] a = { 2, 1, 5 };
    int k = 806;
    List<Integer> expected = Arrays.asList(1, 0, 2, 1);
    List<Integer> actual = solution.addToArrayForm(a, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample4() {
    int[] a = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
    int k = 1;
    List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    List<Integer> actual = solution.addToArrayForm(a, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1() {
    int[] a = { 1 };
    int k = 999999999;
    List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    List<Integer> actual = solution.addToArrayForm(a, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase145() {
    int[] a = { 1, 2, 3, 4 };
    int k = 8766;
    List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0);
    List<Integer> actual = solution.addToArrayForm(a, k);

    assertEquals(expected, actual);
  }
}
