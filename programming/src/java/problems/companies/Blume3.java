package src.java.problems.companies;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Blume3 {
    public static void main(String[] args) {
        int MAX_CHARS = 256;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();

        int dist_count = 0;

        boolean[] vis = new boolean[MAX_CHARS];
        Arrays.fill(vis, false);
        for (int i = 0; i < n; i++) {
            if (vis[str.charAt(i)] == false) {
                vis[str.charAt(i)] = true;
                dist_count++;
            }
        }

        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;

        int count = 0;
        int[] c_n = new int[MAX_CHARS];
        for (int j = 0; j < n; j++) {
            c_n[str.charAt(j)]++;

            if (c_n[str.charAt(j)] == 1)
                count++;

            if (count == dist_count) {
                while (c_n[str.charAt(start)] > 1) {
                    if (c_n[str.charAt(start)] > 1)
                        c_n[str.charAt(start)]--;
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        System.out.println(str.substring(start_index, start_index + min_len));
    }



}
