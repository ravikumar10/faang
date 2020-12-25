package src.java.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P15 {
    public static void main(String[] args) {
        int [] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list=new ArrayList<Boolean>(Arrays.asList(new Boolean[candies.length]));
        Collections.fill(list, Boolean.FALSE);
        int max = Integer.MIN_VALUE;
        for(int a : candies)
            max = Math.max(max, a);

        for(int i= 0; i<candies.length; i++){
            if(candies[i]+extraCandies >= max)
                list.set(i, true);
        }

        return list;
    }
}
