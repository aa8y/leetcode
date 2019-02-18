package co.aa8y.leetcode;

/**
 * 344. Reverse String
 *
 * <p>Write a function that reverses a string. The input string is given as an array of characters 
 * {@code char[]}.
 * 
 * <p>Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * <p>You may assume all the characters consist of printable ascii characters.
 * 
 * <p>Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * <p>Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
  /**
   * Reverses a string, in-place.
   *
   * @param s String in the form of a character array
   */
  public void reverseString(char[] s) {
    if (s == null || s.length == 0 || s.length == 1) {
      return;
    }
    for (int i = 0; i < s.length / 2; i++) {
      swap(s, i, s.length - i - 1);
    }
  }

  private void swap(char[] s, int from, int to) {
    char tmp = s[from];
    s[from] = s[to];
    s[to] = tmp;
  }
}
