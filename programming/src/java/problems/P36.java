package src.java.problems;

import java.util.Arrays;

public class P36 {
    public static void main(String[] args) {
        int []costs = {1,1,2,4,1, 1};
        int coins =7;

        System.out.println(maxIceCream(costs, coins));
    }

    public static int maxIceCream(int[] costs, int coins) {
        int [] dp = new int[coins+1];
       Arrays.sort(costs);
       for(int i =0 ; i<costs.length; i++){
           if((coins -= costs[i] )< 0){
               return i;
           }
       }

       return costs.length;
    }
}
