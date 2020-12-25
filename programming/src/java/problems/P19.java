package src.java.problems;

import java.util.Arrays;

public class P19 {
    public static void main(String[] args) {
//        int []nums = {1,2,3,4};
        int []nums = {1,1,1,1,1};
        Arrays.stream(runningSum(nums)).forEach(System.out::println);
    }
    public static int[] runningSum(int[] nums) {
        int sum = nums[0];
        for(int i=1; i< nums.length;i++){
            sum+=nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
