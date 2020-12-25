package src.java.problems;

public class P16 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,4,3,2,1};
        int n = 4;

        for(int k : shuffle(nums, n)){
            System.out.println(k);
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        int [] res = new int [nums.length];
        for(int i = 0, j=0; j<n ; j++){
            res[i] = nums[j];
            res[i+1] = nums[j+n];
            i+=2;
        }
        return res;
    }
}
