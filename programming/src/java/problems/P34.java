package src.java.problems;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class P34 {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'c';

        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        if(target == 'z' && letters.length >0)
            return letters[0];

        int l = 0;
        int h = letters.length-1;
        int m =0;
        while (l<=h){
            m = l+(h-l)/2;
            if(letters[m] == target)
                break;
            else if(letters[m] < target)
                    l= m+1;
            else {
                h = m-1;
            }
        }

        if(target < letters[m])
            return letters[m];
        else return letters[m+1%letters.length-1];

    }
}
