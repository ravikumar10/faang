package src.java.problems;

import java.util.*;

public class P32 {
    public static void main(String[] args) {
       int [] nums1 = {1,2,2,1};
       int [] nums2 = {2,2};
       Arrays.stream(intersect(nums1, nums2)).forEach(System.out::println);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length ){
            return helper(nums1, nums2);
        } else {
            return helper(nums2, nums1);
        }
    }

    public static int [] helper(int []nums1, int []nums2){
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i : nums1){
            m1.put(i, m1.getOrDefault(i, 0)+1);
        }

        for(int i : nums2){
            m2.put(i, m2.getOrDefault(i, 0)+1);
        }

        for(int k : m1.keySet()){
            if(m2.containsKey(k)) {
                int t = Math.min(m1.get(k), m2.get(k));
                int[] r = new int[t];
                while (t-- > 0)
                    res.add(k);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
