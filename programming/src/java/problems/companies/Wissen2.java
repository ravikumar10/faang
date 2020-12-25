package src.java.problems.companies;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Minimum number for plateform needed
 */

public class Wissen2 {
    public static void main(String[] args) {
        int[][] foo = new int[][] {
                new int[] { 1, 2 },
                new int[] { 3, 4},
        };

//        System.out.println(getLot(foo));


        String name2 = "saample";

        Map<Character, Integer> ch = new HashMap<>();
        int count=0;
        for(char c : name2.toCharArray()) {
            if(ch.containsKey(c)){
                ch.put(c, ch.get(c)+1);
            } else {
                ch.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> c : ch.entrySet()){
            if(c.getValue() == 1) {
                count+=1;
            }
        }
        System.out.println(count);
    }

    static int getLot(int[][] lot){


        int n = lot.length;

        int [] start = new int[n];
        int [] end = new int[n];

        for(int i=0;i<n;i++){
            start[i] = lot[i][0];
            end[i] = lot[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                plat_needed++;
                i++;
            }

            else if (start[i] > end[j]) {
                plat_needed--;
                j++;
            }

            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }
}
