package src.java.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P31 {
    public static void main(String[] args) {
        int [] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i= 0; i< nums.length; i++){
            m.put(nums[i], i);
        }

        for(int k : m.keySet()) {
            if(m.containsKey(target-k)){
                return new int []{m.get(k), m.get(target-k)};
            }
        }

        return new int[]{0,0};
    }
}

