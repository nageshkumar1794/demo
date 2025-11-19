package com.example.demo.override;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String id;
    private String name;
    private String dept;
    private double salary;

    public Employee(String id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public double getSalary() { return salary; }
}
class CacheItem {
    private final Object value;
    private final Instant expiresAt;

    public CacheItem(Object value, Instant expiresAt) {
        this.value = value;
        this.expiresAt = expiresAt;
    }

    public Object getValue() { return value; }
    public Instant getExpiresAt() { return expiresAt; }
}
public class MapExamplesJava8 {

    /* ===========================================================
       Example 1: Count word frequency from file (Java 8)
       =========================================================== */
    public static void example1_wordFrequency() throws IOException {
        Map<String, Long> freq = Files.lines(Path.of("logs.txt"))
                .flatMap(line -> Arrays.stream(line.split("\\W+")))
                .filter(word -> !word.trim().isEmpty())
                .collect(Collectors.groupingBy(
                        s -> s.toLowerCase(),
                        Collectors.counting()
                ));

        freq.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .forEach(System.out::println);
    }

    /* ===========================================================
       Example 2: First non-repeating char using LinkedHashMap
       =========================================================== */
    public static Character example2_firstNonRepeatingChar(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return null;
    }

    /* ===========================================================
       Example 3: Simple Cache with Expiration (No records)
       =========================================================== */



    private static final Map<String, CacheItem> cache = new HashMap<>();

    public static void example3_cachePut(String key, Object value, long ttlSeconds) {
        cache.put(key, new CacheItem(value, Instant.now().plusSeconds(ttlSeconds)));
    }

    public static Object example3_cacheGet(String key) {
        CacheItem item = cache.get(key);
        if (item == null) return null;

        if (Instant.now().isAfter(item.getExpiresAt())) {
            cache.remove(key);
            return null;
        }
        return item.getValue();
    }

    /* ===========================================================
       Example 4: Sort a HashMap by keys using TreeMap
       =========================================================== */
    public static Map<String, Double> example4_sortByKeys(Map<String, Double> map) {
        return new TreeMap<>(map);
    }

    /* ===========================================================
       Example 5: Sort HashMap by values descending
       =========================================================== */
    public static List<Map.Entry<String, Integer>> example5_sortByValues(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());
    }

    /* ===========================================================
       Example 6: Group employees by department
       =========================================================== */


    public static Map<String, List<Employee>> example6_groupByDepartment(List<Employee> list) {
        return list.stream().collect(Collectors.groupingBy(Employee::getDept));
    }

    /* ===========================================================
       Example 7: Custom-sorted TreeMap (Java 8)
       =========================================================== */
    public static Map<String, Integer> example7_customSortedMap() {
        return new TreeMap<>(new Comparator<String>() {
            public int compare(String a, String b) {
                int lenCompare = Integer.compare(a.length(), b.length());
                return lenCompare != 0 ? lenCompare : a.compareTo(b);
            }
        });
    }

    /* ===========================================================
       Example 8: Merge maps with conflict resolution
       =========================================================== */
    public static Map<String, Integer> example8_mergeMaps(Map<String, Integer> a, Map<String, Integer> b) {
        for (Map.Entry<String, Integer> entry : b.entrySet()) {
            a.merge(entry.getKey(), entry.getValue(), (oldV, newV) -> oldV + newV);
        }
        return a;
    }

    /* ===========================================================
       Example 9: LRU Cache using LinkedHashMap
       =========================================================== */
    public static Map<Integer, String> example9_createLRUCache(final int maxSize) {
        return new LinkedHashMap<Integer, String>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > maxSize;
            }
        };
    }

    /* ===========================================================
       Example 10: Find duplicates in array
       =========================================================== */
    public static Set<Integer> example10_findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> duplicates = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    /* ===========================================================
       Example 11: Zip two lists into a map
       =========================================================== */
    public static <K, V> Map<K, V> example11_zipToMap(List<K> keys, List<V> values) {
        Map<K, V> map = new HashMap<>();
        int len = Math.min(keys.size(), values.size());
        for (int i = 0; i < len; i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

    /* ===========================================================
       Example 12: Highest-salary employee per department
       =========================================================== */
    public static Map<String, Employee> example12_highestSalaryByDept(List<Employee> employees) {
        return employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                Optional::get
                        )
                )
        );
    }

    /* ===========================================================
       Example 13: Check if two strings are anagrams
       =========================================================== */
    public static boolean example13_areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : a.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : b.toCharArray())
            map.put(c, map.getOrDefault(c, 0) - 1);

        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }

    /* ===========================================================
       Example 14: Map <-> JSON (Manual, simple)
       =========================================================== */
    public static String example14_mapToJson(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("{");
        int count = 0;

        for (Map.Entry<String, Object> e : map.entrySet()) {
            sb.append("\"").append(e.getKey()).append("\":\"")
                    .append(e.getValue()).append("\"");
            if (++count < map.size()) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }

    public static Map<String, String> example14_jsonToMap(String json) {
        Map<String, String> map = new HashMap<>();

        json = json.substring(1, json.length() - 1);
        String[] parts = json.split(",");

        for (String p : parts) {
            String[] kv = p.split(":");
            String key = kv[0].replace("\"", "").trim();
            String val = kv[1].replace("\"", "").trim();
            map.put(key, val);
        }
        return map;
    }

    /* ===========================================================
       Example 15: Group employees by join year using TreeMap
       =========================================================== */
    public static Map<Integer, List<Employee>> example15_groupByYear(
            List<Employee> employees,
            final Map<String, Integer> joinYears) {

        return employees.stream().collect(
                Collectors.groupingBy(
                        e -> joinYears.get(e.getId()),
                        TreeMap::new,
                        Collectors.toList()
                )
        );
    }

    /* ===========================================================
       MAIN METHOD (empty per your request)
       =========================================================== */
//    public static void main(String[] args) {
//        // Intentionally empty
//    }
}
