package co.aa8y.leetcode.testutils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility class to read test resource text files.
 */
public class FileUtil {
  /**
   * Reads the file and returns as it as a single {@code String}, each line separated with a newline
   * character.
   *
   * @param fileName Name of the file in the test resource directory
   * @return Content of the file
   */
  public static String read(String fileName) {
    return readLines(fileName).stream()
                              .collect(Collectors.joining(System.getProperty("line.separator")));
  }

  /**
   * Reads the file and returns as it as a {@code List<String>}.
   *
   * @param fileName Name of the file in the test resource directory
   * @return Content of the file
   */
  public static List<String> readLines(String fileName) {
    URL url = FileUtil.class.getResource(fileName);

    try (Stream<String> lines = Files.lines(Paths.get(url.toURI()))) {
      return lines.collect(Collectors.toList());
    } catch (IOException | URISyntaxException e) {
      throw new IllegalArgumentException(fileName + " could not be read.", e);
    }
  }

  /**
   * Reads the file and returns as it as an array of {@code int}s, provided all the integers in
   * the file are separated by a newline character.
   *
   * @param fileName Name of the file in the test resource directory
   * @return Content of the file
   */
  public static int[] readLinesAsIntArray(String fileName) {
    return readLines(fileName).stream()
                              .map(Integer::parseInt)
                              .mapToInt(Integer::intValue)
                              .toArray();
  }
}
