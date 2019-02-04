package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class CandyTest {
  private Candy solution = new Candy();

  @Test
  public void testLeetCodeExample1() {
    int[] ratings = { 1, 0, 2 };
    int expected = 5;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[] ratings = { 1, 2, 2 };
    int expected = 4;   // 1, 2, 1
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1() {
    int[] ratings = { };
    int expected = 0;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2() {
    int[] ratings = { 20 };
    int expected = 1;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom3() {
    int[] ratings = { 3, 3 };
    int expected = 2;   // 1, 1
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom4() {
    int[] ratings = { 3, 5 };
    int expected = 3;   // 1, 2
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom5() {
    int[] ratings = { 5, 3 };
    int expected = 3;   // 2, 1
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom6() {
    int[] ratings = { 4, 5, 7 };
    int expected = 6;   // 1, 2, 3
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom7() {
    int[] ratings = { 7, 5, 4 };
    int expected = 6;   // 3, 2, 1
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  // Ref: https://leetcode.com/problems/candy/discuss/42939/I-don't-think-the-%22Expected%22-output-is-correct!
  @Test
  public void testLeetCodeDiscussion1() {
    int[] ratings = { 1, 2, 4, 4, 3 };
    int expected = 9;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  // Ref: https://leetcode.com/problems/candy/discuss/42862/How-to-explain-this-problem
  @Test
  public void testLeetCodeDiscussion2A() {
    int[] ratings = { 29, 51, 87, 87 };
    int expected = 7;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  // Ref: https://leetcode.com/problems/candy/discuss/42862/How-to-explain-this-problem
  @Test
  public void testLeetCodeDiscussion2B() {
    int[] ratings = { 29, 51, 87, 87, 72, 12 };
    int expected = 12;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  // Ref: https://leetcode.com/problems/candy/discuss/42862/How-to-explain-this-problem
  @Test
  public void testLeetCodeDiscussion2C() {
    int[] ratings = { 1, 2, 87, 87, 87, 2, 1 };
    int expected = 13;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  // Ref: https://leetcode.com/problems/candy/discuss/42833/What-if-there-are-two-equal-numbers
  @Test
  public void testLeetCodeDiscussion3B() {
    int[] ratings = { 1, 4, 4, 3, 2, 1 };
    int expected = 13;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  // Ref: https://leetcode.com/problems/candy/discuss/42917/Is-the-Test-Case-WrongThe-test-case-as-follow
  @Test
  public void testLeetCodeDiscussion4() {
    int[] ratings = {
      58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82, 47, 25, 94, 89, 54, 26, 54, 54, 99, 64, 71, 76, 63,
      81, 82, 60, 64, 29, 51, 87, 87, 72, 12, 16, 20, 21, 54, 43, 41, 83, 77, 41, 61, 72, 82, 15,
      50, 36, 69, 49, 53, 92, 77, 16, 73, 12, 28, 37, 41, 79, 25, 80, 3, 37, 48, 23, 10, 55, 19, 51,
      38, 96, 92, 99, 68, 75, 14, 18, 63, 35, 19, 68, 28, 49, 36, 53, 61, 64, 91, 2, 43, 68, 34, 46,
      57, 82, 22, 67, 89
    };
    int expected = 208;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase4X() throws URISyntaxException {
    int[] ratings = getRatingsFromFile("/135_Candy_LeetCodeTestCase4X.txt");
    int expected = 72006000;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase48() throws URISyntaxException {
    int[] ratings = getRatingsFromFile("/135_Candy_LeetCodeTestCase48.txt");
    int expected = 200010000;
    int actual = solution.candy(ratings);

    assertEquals(expected, actual);
  }

  private int[] getRatingsFromFile(String fileName) {
    URL url = this.getClass().getResource(fileName);

    try (Stream<String> lines = Files.lines(Paths.get(url.toURI()))) {
      return lines.map(Integer::parseInt)
                  .mapToInt(Integer::intValue)
                  .toArray();
    } catch (IOException | URISyntaxException e) {
      throw new IllegalArgumentException(fileName + " could not be read.", e);
    }
  }
}
