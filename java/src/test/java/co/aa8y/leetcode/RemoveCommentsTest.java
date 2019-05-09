package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RemoveCommentsTest {
  RemoveComments solution = new RemoveComments();

  @Test
  public void testLeetCodeExample1() {
    String[] source = {
      "/*Test program */",
      "int main()",
      "{ ",
      "  // variable declaration ",
      "int a, b, c;",
      "/* This is a test",
      "   multiline  ",
      "   comment for ",
      "   testing */",
      "a = b + c;",
      "}"
    };
    // CHECKSTYLE:OFF
    List<String> expected = Arrays.asList(
      "int main()",
      "{ ",
      "  ",
      "int a, b, c;",
      "a = b + c;",
      "}"
    );
    // CHECKSTYLE:ON
    List<String> actual = solution.removeComments(source);

    assertIterableEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    String[] source = {
      "a/*comment",
      "line",
      "more_comment*/b"
    };
    List<String> expected = Arrays.asList("ab");
    List<String> actual = solution.removeComments(source);

    assertIterableEquals(expected, actual);
  }
}
