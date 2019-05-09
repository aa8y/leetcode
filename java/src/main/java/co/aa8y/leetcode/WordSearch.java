package co.aa8y.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 79. Word Search
 *
 * <p>Given a 2D board and a word, find if the word exists in the grid.
 *
 * <p>The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring. The same letter cell may not be
 * used more than once.
 *
 * <p>Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
  private VisitFactory visitFactory;

  /**
   * Given a board with characters, checks if all the characters of the given word are present on it
   * without being repeated in a sequential order.
   *
   * @param board Board with characters
   * @param word Word which needs to be checked against the board
   * @return true if present, else false
   */
  public boolean exist(char[][] board, String word) {
    if (board.length == 0 || board[0].length == 0) {
      return word.isEmpty();
    }
    if (word.isEmpty()) {
      return true;
    }
    int m = board.length;
    int n = board[0].length;
    char[] w = word.toCharArray();
    visitFactory = new VisitFactory(m, n);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (exist(board, Collections.<Visit>emptySet(), w, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean exist(char[][] board,
                        Set<Visit> visits,
                        char[] word,
                        int i,
                        int j,
                        int k) {
    if (k == word.length) {
      return true;
    }
    if (!visitFactory.inBounds(i, j) || hasVisited(visits, i, j)) {
      return false;
    }
    if (board[i][j] != word[k]) {
      return false;
    }
    Set<Visit> newVisits = new HashSet<>(visits);
    newVisits.add(visitFactory.getOrCreate(i, j));

    return exist(board, newVisits, word, i - 1,     j, k + 1)
        || exist(board, newVisits, word,     i, j + 1, k + 1)
        || exist(board, newVisits, word, i + 1,     j, k + 1)
        || exist(board, newVisits, word,     i, j - 1, k + 1);
  }

  private boolean hasVisited(Set<Visit> visits, int i, int j) {
    Visit visit = visitFactory.getOrCreate(i, j);
    return visits.contains(visit);
  }

  static class Visit {
    // CHECKSTYLE:OFF
    private final int i;
    private final int j;
    // CHECKSTYLE:ON

    public Visit(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  static class VisitFactory {
    // CHECKSTYLE:OFF
    private int m;
    private int n;
    // CHECKSTYLE:ON
    private Visit[][] visits;

    public VisitFactory(int m, int n) {
      this.m = m;
      this.n = n;
      this.visits = new Visit[m][n];
    }

    public Visit getOrCreate(int i, int j) {
      if (inBounds(i, j)) {
        Visit visit = visits[i][j];
        if (visit != null) {
          return visit;
        }
        visit = new Visit(i, j);
        visits[i][j] = visit;
        return visit;
      }
      throw new IndexOutOfBoundsException("i and j need to be within bounds.");
    }

    public boolean inBounds(int i, int j) {
      return !(i < 0 || i >= m || j < 0 || j >= n);
    }
  }
}
