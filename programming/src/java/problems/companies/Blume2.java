package src.java.problems.companies;

import java.util.Scanner;

public class Blume2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();

        int len = str.length();

        if(len%2 == 0) {
            String s1 = str.substring(0,len/2);
            String s2 = str.substring(len/2, len);

            String finalString = s2+s1;
             s1 = finalString.substring(0,len/2);
             s2 = finalString.substring(len/2, len);
            StringBuilder sb = new StringBuilder();
            int i=s1.length()-1;
            int j=0;

            while(i>0 && j < s2.length()) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    char s = s1.charAt(i);
                    while(s1.charAt(i) == s) {
                        i-=1;
                    }
                    while(s2.charAt(j) == s) {
                        j+=1;
                    }
                } else {
                    break;
                }

            }

            System.out.println((s1.substring(0,i+1)+s2.substring(j,s2.length())).length());

        }

    }





}
