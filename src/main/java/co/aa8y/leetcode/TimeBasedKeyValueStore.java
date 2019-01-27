package co.aa8y.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 *
 * <p>Create a timebased key-value store class {@code TimeMap}, that supports two operations.
 *
 * <p>1. {@code set(string key, string value, int timestamp)}
 * a. Stores the key and value, along with the given timestamp.
 *
 * <p>2. {@code get(string key, int timestamp)}
 * a. Returns a value such that {@code set(key, value, timestamp_prev)} was called previously, with
 *    {@code timestamp_prev <= timestamp}.
 * b. If there are multiple such values, it returns the one with the largest {@code timestamp_prev}.
 * c. If there are no values, it returns the empty string ("").
 *
 * <p>Example 1
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"],
 *        inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:
 * <pre>{@code
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
 * kv.get("foo", 1);  // output "bar"
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3
 *                   // and timestamp 2, then the only value is at timestamp 1 ie "bar"
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // output "bar2"
 * kv.get("foo", 5); //output "bar2"
 * }</pre>
 *
 * <p>Example 2:
 * Input: inputs = ["TimeMap","set","set","get","get","get","get","get"],
 *        inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],
 *                  ["love",20],["love",25]]
 * Output: [null,null,null,"","high","high","low","low"]
 */
public class TimeBasedKeyValueStore {
  static class TimeMap {
    private final Map<String, TreeMap<Integer, String>> timeMap = new HashMap<>();

    public TimeMap() { }

    public void set(String key, String value, int timestamp) {
      TreeMap<Integer, String> values = timeMap.getOrDefault(key, new TreeMap<Integer, String>());
      values.put(Integer.valueOf(timestamp), value);
      timeMap.put(key, values);
    }

    public String get(String key, int timestamp) {
      if (!timeMap.containsKey(key)) {
        return "";
      }
      TreeMap<Integer, String> values = timeMap.get(key);
      Integer ts = Integer.valueOf(timestamp);
      Optional<Integer> possibleClosestTimestamp = findClosestTimestamp(values.navigableKeySet(),
                                                                        ts);

      if (!possibleClosestTimestamp.isPresent()) {
        return "";
      }
      Integer closestTimestamp = possibleClosestTimestamp.get();
      String value = values.get(closestTimestamp);

      if (!closestTimestamp.equals(timestamp)) {
        set(key, value, closestTimestamp.intValue());
      }
      return value;
    }

    private Optional<Integer> findClosestTimestamp(SortedSet<Integer> timestamps,
                                                   Integer timestamp) {
      if (timestamps.contains(timestamp)) {
        return Optional.of(timestamp);
      }
      SortedSet<Integer> closestTimestamps = timestamps.headSet(timestamp);
      if (closestTimestamps.isEmpty()) {
        return Optional.<Integer>empty();
      }
      return Optional.of(closestTimestamps.last());
    }
  }
}
