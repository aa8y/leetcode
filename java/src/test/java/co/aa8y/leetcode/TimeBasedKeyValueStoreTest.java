package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeBasedKeyValueStoreTest {
  TimeBasedKeyValueStore.TimeMap timeMap;

  @BeforeEach
  public void setup() {
    timeMap = new TimeBasedKeyValueStore.TimeMap();
  }

  @AfterEach
  public void cleanup() {
    timeMap = null;
  }

  @Test
  public void testLeetCodeExample1() {
    timeMap.set("foo", "bar", 1);
    assertEquals("bar", timeMap.get("foo", 1));
    assertEquals("bar", timeMap.get("foo", 3));

    timeMap.set("foo", "bar2", 4);
    assertEquals("bar2", timeMap.get("foo", 4));
    assertEquals("bar2", timeMap.get("foo", 5));
  }

  @Test
  public void testLeetCodeExample2() {
    timeMap.set("love", "high", 10);
    timeMap.set("love", "low", 20);

    assertEquals("", timeMap.get("love", 5));
    assertEquals("high", timeMap.get("love", 10));
    assertEquals("high", timeMap.get("love", 15));
    assertEquals("low", timeMap.get("love", 20));
    assertEquals("low", timeMap.get("love", 25));
  }

  @Test
  public void testLeetCodeTestCase45() {
  }
}
