package src.java.problems;

import java.util.Stack;

public class P42 {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
//        int[] nums = {5,7,1,8};
//        int[] nums = {1,2,3,2};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int nonD = 1;
        int max = Integer.MAX_VALUE;
        for(int i : nums){
            if(st.isEmpty()){
                st.push(i);
            }
            else{
                if(i >= st.peek()  ){
                    st.push(i);
                } else if(nonD-- > 0 ){
                    if(st.size() > 1)
                        st.push(st.peek());
                    else {
                        st.pop();
                        st.push(i);
                    }
                } else{
                    return false;
                }
            }
        }

        return true;
    }
}
