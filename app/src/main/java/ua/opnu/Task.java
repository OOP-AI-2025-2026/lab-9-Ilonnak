package ua.opnu;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    public static void main(String[] args) {
    }

    // ------------------- Task 1 -------------------
    public void removeShorterStrings(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }

        int i = 0;
        while (i < list.size() - 1) {
            String first = list.get(i);
            String second = list.get(i + 1);

            int len1 = (first == null) ? 0 : first.length();
            int len2 = (second == null) ? 0 : second.length();

            if (len1 <= len2) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i++;
        }
    }

    // ------------------- Task 2 -------------------
    public void stutter(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        for (int i = 0; i < list.size(); i += 2) {
            String value = list.get(i);
            list.add(i, value);
        }
    }

    // ------------------- Task 3 -------------------
    public void switchPairs(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }

        for (int i = 0; i < list.size() - 1; i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }

    // ------------------- Task 4 -------------------
    public void removeDuplicates(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }

    // ------------------- Task 5 -------------------
    public void markLength4(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (word != null && word.length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    // ------------------- Task 6 -------------------
    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return true;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            queue.add(val);
            stack.push(val);
        }

        boolean palindrome = true;

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            int rev = stack.pop();
            if (val != rev) {
                palindrome = false;
            }
            queue.add(val);
        }

        return palindrome;
    }

    // ------------------- Task 7 -------------------
    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = queue.size();
        int nonNegCount = 0;

        for (int i = 0; i < n; i++) {
            int x = queue.remove();
            if (x < 0) {
                stack.push(x);
            } else {
                queue.add(x);
                nonNegCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < nonNegCount; i++) {
            queue.add(queue.remove());
        }
    }

    // ------------------- Task 8 -------------------
    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }

        ArrayDeque<Integer> buffer = new ArrayDeque<>();
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            int x = queue.remove();
            if (x % 2 == 0) {
                queue.add(x);
            } else {
                buffer.addLast(x);
            }
        }

        while (!buffer.isEmpty()) {
            queue.add(buffer.removeFirst());
        }
    }

    // ------------------- Task 9 -------------------
    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }

        int max = 0;
        for (String s : set) {
            if (s != null && s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    // ------------------- Task 10 -------------------
    public void removeEvenLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s != null && s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    // ------------------- Task 11 -------------------
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) {
            return 0;
        }

        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> s2 = new HashSet<>(list2);

        s1.retainAll(s2);
        return s1.size();
    }

    // ------------------- Task 12 -------------------
    public boolean isUnique(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }

        Set<String> values = new HashSet<>(map.values());
        return values.size() == map.size();
    }

    // ------------------- Task 13 -------------------
    public Map<String, Integer> intersect(Map<String, Integer> map1,
                                          Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        if (map1 == null || map2 == null) {
            return result;
        }

        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            String key = e.getKey();
            Integer value = e.getValue();
            if (map2.containsKey(key) && value.equals(map2.get(key))) {
                result.put(key, value);
            }
        }
        return result;
    }

    // ------------------- Task 14 -------------------
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        if (map == null) {
            return result;
        }

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer key = e.getKey();
            String value = e.getValue();

            if (!result.containsKey(value)) {
                result.put(value, key);
            } else {
                if (key > result.get(value)) {
                    result.put(value, key);
                }
            }
        }
        return result;
    }

    // ------------------- Task 15 -------------------
    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int value : map.values()) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        int rareValue = Integer.MAX_VALUE;
        int minCount = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int value = e.getKey();
            int count = e.getValue();

            if (count < minCount || (count == minCount && value < rareValue)) {
                minCount = count;
                rareValue = value;
            }
        }

        return rareValue;
    }

    // ------------------- Task 16 -------------------
    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : list) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int max = 0;
        for (int count : freq.values()) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
