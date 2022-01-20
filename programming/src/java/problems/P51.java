package src.java.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class P51 {

    public static void main(String[] args) {
        int [] ip = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(maxSlidingWindow(ip,k));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b-a);

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            maxPQ.add(nums[i]);

            if(maxPQ.size() > k){
                maxPQ.remove(nums[i-k]);
            }

            if(maxPQ.size() == k){
                res.add(maxPQ.peek());
            }


        }

        return res.stream().mapToInt(i->i).toArray();
    }
}
