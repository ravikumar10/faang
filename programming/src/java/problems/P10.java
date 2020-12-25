package src.java.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P10 {
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3,3,3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> f = new HashMap<>();
        Set<Integer> n = new HashSet<>();

        for(int a : arr){
            f.put(a, f.getOrDefault(a,0)+1);
        }
        for(int b: f.values()){
            if(n.contains(b)){
                return false;
            }
            n.add(b);
        }
        return true;
    }
}

/*
https://leetcode.com/problems/unique-number-of-occurrences/submissions/
 */