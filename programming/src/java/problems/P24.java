package src.java.problems;

import java.util.Arrays;

public class P24 {
    public static void main(String[] args) {
        int [] wt = {3,2,2,1};
        int limit = 3;
        System.out.println(numRescueBoats(wt, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int result = 0;

        while (i <= j) {
            result++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return result;
    }
}

/*
    https://leetcode.com/problems/boats-to-save-people/solution/
 */