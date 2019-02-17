package co.aa8y.leetcode.testutils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {
  public static int[] readLinesAsIntArray(String fileName) {
    URL url = FileUtil.class.getResource(fileName);

    try (Stream<String> lines = Files.lines(Paths.get(url.toURI()))) {
      return lines.map(Integer::parseInt)
                  .mapToInt(Integer::intValue)
                  .toArray();
    } catch (IOException | URISyntaxException e) {
      throw new IllegalArgumentException(fileName + " could not be read.", e);
    }
  }
}
