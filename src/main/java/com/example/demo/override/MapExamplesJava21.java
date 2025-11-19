package com.example.demo.override;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

record CacheItem21(Object value, Instant expiresAt) {}
record Employee21(String id, String name, String dept, double salary) {}

public class MapExamplesJava21 {
    private static final Map<String, CacheItem21> cache = new HashMap<>();

    /* ===========================================================
   Example 1: Count occurrences of each word in a log file
   =========================================================== */
    public static void example1_wordFrequency() throws IOException {
        var freq = Files.lines(Path.of("logs.txt"))
                .flatMap(line -> Arrays.stream(line.split("\\W+")))
                .filter(word -> !word.isBlank())
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        freq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    /* ===========================================================
       Example 2: First non-repeating character using LinkedHashMap
       =========================================================== */
    public static Character example2_firstNonRepeatingChar(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        input.chars().forEach(c -> map.merge((char) c, 1, Integer::sum));

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    /* ===========================================================
       Example 3: Simple Cache with Expiration using Record
       =========================================================== */

    public static void example3_cachePut(String key, Object value, long ttlSeconds) {
        cache.put(key, new CacheItem21(value, Instant.now().plusSeconds(ttlSeconds)));
    }

    public static Object example3_cacheGet(String key) {
        CacheItem21 item = cache.get(key);
        if (item == null) return null;

        if (Instant.now().isAfter(item.expiresAt())) {
            cache.remove(key);
            return null;
        }
        return item.value();
    }

    /* ===========================================================
       Example 4: Sort a HashMap by Keys using TreeMap
       =========================================================== */
    public static Map<String, Double> example4_sortByKeys(Map<String, Double> map) {
        return new TreeMap<>(map);
    }

    /* ===========================================================
       Example 5: Sort a HashMap by Values (descending)
       =========================================================== */
    public static List<Map.Entry<String, Integer>> example5_sortByValues(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();
    }

    /* ===========================================================
       Example 6: Group employees by department
       =========================================================== */


    public static Map<String, List<Employee21>> example6_groupByDepartment(List<Employee21> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee21::dept));
    }

    /* ===========================================================
       Example 7: Custom sorting in TreeMap (len + alphabetical)
       =========================================================== */
    public static Map<String, Integer> example7_customSortedMap() {
        return new TreeMap<>(Comparator
                .comparingInt(String::length)
                .thenComparing(String::compareTo));
    }

    /* ===========================================================
       Example 8: Merge two maps with conflict resolution
       =========================================================== */
    public static Map<String, Integer> example8_mergeMaps(Map<String, Integer> a, Map<String, Integer> b) {
        b.forEach((key, value) -> a.merge(key, value, Integer::sum));
        return a;
    }

    /* ===========================================================
       Example 9: LRU Cache using LinkedHashMap
       =========================================================== */
    public static Map<Integer, String> example9_createLRUCache(int maxSize) {
        return new LinkedHashMap<>(maxSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > maxSize;
            }
        };
    }

    /* ===========================================================
       Example 10: Find duplicates in integer array
       =========================================================== */
    public static Set<Integer> example10_findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) map.merge(n, 1, Integer::sum);

        return map.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    /* ===========================================================
       Example 11: Convert two lists into a map
       =========================================================== */
    public static <K, V> Map<K, V> example11_zipToMap(List<K> keys, List<V> values) {
        Map<K, V> map = new HashMap<>();
        for (int i = 0; i < Math.min(keys.size(), values.size()); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

    /* ===========================================================
       Example 12: Highest salary employee per department
       =========================================================== */
    public static Map<String, Employee21> example12_highestSalaryByDept(List<Employee21> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee21::dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee21::salary)),
                                Optional::get
                        )
                ));
    }

    /* ===========================================================
       Example 13: Check if two strings are anagrams
       =========================================================== */
    public static boolean example13_areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        a.chars().forEach(c -> map.merge((char) c, 1, Integer::sum));
        b.chars().forEach(c -> map.merge((char) c, -1, Integer::sum));

        return map.values().stream().allMatch(v -> v == 0);
    }

    /* ===========================================================
       Example 14: Convert Map to JSON and back (simple)
       =========================================================== */
    public static String example14_mapToJson(Map<String, Object> map) {
        return map.entrySet().stream()
                .map(e -> "\"" + e.getKey() + "\":\"" + e.getValue() + "\"")
                .collect(Collectors.joining(",", "{", "}"));
    }

    public static Map<String, String> example14_jsonToMap(String json) {
        Map<String, String> map = new HashMap<>();

        json = json.substring(1, json.length() - 1); // remove braces

        for (String part : json.split(",")) {
            String[] kv = part.split(":");
            map.put(
                    kv[0].replace("\"", "").trim(),
                    kv[1].replace("\"", "").trim()
            );
        }
        return map;
    }

    /* ===========================================================
       Example 15: Count employees by join year (TreeMap)
       =========================================================== */
    public static Map<Integer, List<Employee21>> example15_groupByYear(List<Employee21> employees, Map<String, Integer> joinYears) {
        return employees.stream().collect(
                Collectors.groupingBy(
                        e -> joinYears.get(e.id()),
                        TreeMap::new,
                        Collectors.toList()
                )
        );
    }
}
