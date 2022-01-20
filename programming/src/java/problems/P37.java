package src.java.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P37 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};

        System.out.println(createTargetArray(nums, index));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        Map<Integer, Stack<Integer>> m = new HashMap<>();

        for(int i=0;i<index.length; i++){
            if(!m.containsKey(index[i])){
                Stack<Integer> s = new Stack<>();
                s.push(nums[i]);
                m.put(index[i], s);
            } else {
                Stack<Integer> s = (Stack)m.get(index[i]);
                s.push(nums[i]);
                m.put(index[i], s);
            }

        }

        int [] r = new  int[nums.length];
        int k=0;
        for(int i=0;i<index.length; i++){
            if(m.containsKey(i)){
                Stack<Integer> s = m.get(i);
                while(!s.isEmpty()){
                    r[k++] = s.pop();
                }
            }

        }
        return r;
    }
}
