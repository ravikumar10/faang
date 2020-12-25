package src.java.problems;

import java.util.HashMap;

public class P14 {
    public static void main(String[] args) {
        String [] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }
    public static int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        HashMap<Character, Integer> copyMap;
        for (String word : words) {
            copyMap = (HashMap<Character, Integer>) countMap.clone();
            boolean fail = false;
            for (char c : word.toCharArray()) {
                if (copyMap.get(c) == null || copyMap.get(c) <= 0) {
                    fail = true;
                    break;
                } else {
                    copyMap.put(c, copyMap.get(c) - 1);
                }
            }
            if (!fail) res += word.length();
        }
        return res;
    }
}
