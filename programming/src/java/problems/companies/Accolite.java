package src.java.problems.companies;

import java.util.Arrays;
import java.util.Scanner;

public class Accolite {
    public static void main(String[] args) {
        int [][]p= {
                {3,2,5},
                {8,9,1},
                {4,7,6}
        };

        int [][]c= {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        System.out.println(solve(p, c));
    }

    public static int solve(int[][] p, int [][]c){
        int [][] comb = new int[p.length][p[0].length];
        for(int i=0; i<p.length; i++){
            for(int j = 0 ;j<p[0].length; j++){
                comb[i][j] = (p[i][j] - c[i][j]) >=0 ?  (p[i][j] - c[i][j]) : 0;
            }
        }
        return calculate(comb);
    }

    private static int calculate(int[][] a) {
        int res =1;
        for(int k = 0;k< a.length; k++){
            int[] arr = new int[a[k].length];
            for(int i = 0;i<arr.length; i++){
                arr[i] = a[k][i];
            }
            Arrays.sort(arr);
            res+=arr[0];
        }
        return res;

    }
}
