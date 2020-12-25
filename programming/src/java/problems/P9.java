package src.java.problems;

import java.util.*;

public class P9 {

    public static void main(String[] args) {
//        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        String [] strs = {""};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> r = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();

        for(String s : strs) {
            String k = s;
            char charArray[] = s.toCharArray();
            Arrays.sort(charArray);
            s=new String(charArray);

            if(m.containsKey(s)) {
                List<String> l = new ArrayList<>();
                l.addAll(m.get(s));
                l.add(k);
                m.put(s, l);
            } else {
                m.put(s, Arrays.asList(k));
            }
        }
        for(String k : m.keySet()){
            r.add(m.get(k));
        }
        return r;
    }
}
