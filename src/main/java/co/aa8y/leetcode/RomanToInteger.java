package co.aa8y.leetcode;

import static java.util.AbstractMap.SimpleImmutableEntry;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 13. Roman to Integer
 *
 * <p>Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * <p>For example, two is written as II in Roman numeral, just two one's added together. Twelve is
 * written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is
 * XX + V + II.
 *
 * <p>Roman numerals are usually written largest to smallest from left to right. However, the
 * numeral for four is not IIII. Instead, the number four is written as IV. Because the one is
 * before the five we subtract it making four. The same principle applies to the number nine, which
 * is written as IX. There are six instances where subtraction is used:
 *   1. I can be placed before V (5) and X (10) to make 4 and 9.
 *   2. X can be placed before L (50) and C (100) to make 40 and 90.
 *   3. C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 
 * 1 to 3999.
 *
 * <p>Example 1:
 * Input: "III"
 * Output: 3
 *
 * <p>Example 2:
 * Input: "IV"
 * Output: 4
 *
 * <p>Example 3:
 * Input: "IX"
 * Output: 9
 *
 * <p>Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * <p>Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {
  private static final Map<Character, Integer> ROMAN_CHAR_VALUES = Stream.of(
      new SimpleImmutableEntry<>('I', 1),
      new SimpleImmutableEntry<>('V', 5),
      new SimpleImmutableEntry<>('X', 10),
      new SimpleImmutableEntry<>('L', 50),
      new SimpleImmutableEntry<>('C', 100),
      new SimpleImmutableEntry<>('D', 500),
      new SimpleImmutableEntry<>('M', 1000))
      .collect(Collectors.collectingAndThen(Collectors.toMap(Map.Entry::getKey, 
                                                             Map.Entry::getValue),
                                            Collections::<Character, Integer>unmodifiableMap));
  private static final Comparator<Character> ROMAN_CHAR_COMPARATOR = new Comparator<Character>() {
    public int compare(Character l, Character r) {
      return ROMAN_CHAR_VALUES.get(l) - ROMAN_CHAR_VALUES.get(r);
    }
  };

  /**
   * Converts a roman number provided in {@code String} form to its {@code Integer} equivalent.
   *
   * @param s Roman number
   * @return Integer equivalent of the Roman number
   */
  public int romanToInt(String s) {
    return romanToInt(s.toCharArray(), 0, 0);
  }

  private Integer romanToInt(char[] cs, int i, Integer acc) {
    if (i == cs.length) {
      return acc;
    }
    Character curr = Character.valueOf(cs[i]);
    Integer currValue = ROMAN_CHAR_VALUES.get(curr);

    if (i == 0) {
      // No previous character to consider
      return romanToInt(cs, i + 1, acc + currValue);
    } else {
      Character prev = Character.valueOf(cs[i - 1]);

      if (ROMAN_CHAR_COMPARATOR.compare(prev, curr) < 0) {
        Integer prevValue = ROMAN_CHAR_VALUES.get(prev);

        return romanToInt(cs, i + 1, acc - prevValue + (currValue - prevValue));
      }
      return romanToInt(cs, i + 1, acc + currValue);
    }
  }
}
