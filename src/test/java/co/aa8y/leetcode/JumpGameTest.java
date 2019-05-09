package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class JumpGameTest {
  private JumpGame solution = new JumpGame();

  @Test
  public void testLeetCodeExample1() {
    int[] nums = { 2, 3, 1, 1, 4 };
    boolean expected = true;
    boolean actual = solution.canJump(nums);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[] nums = { 3, 2, 1, 0, 4 };
    boolean expected = false;
    boolean actual = solution.canJump(nums);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase71() {
    int[] nums = {
      8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6,
      0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2,
      1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5
    };
    boolean expected = true;
    boolean actual = solution.canJump(nums);

    assertEquals(expected, actual);
  }

  /*
  @Test
  public void testLeetCodeTestCase7X() {
    int[] nums = new int[25000];
    Arrays.fill(nums, 1);
    boolean expected = true;
    boolean actual = solution.canJump(nums);

    assertEquals(expected, actual);
  }
  */
}
