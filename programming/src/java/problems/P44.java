package src.java.problems;

public class P44 {
    public static void main(String[] args) {

    }

    public static String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int st = 0;
        while(k > 0 && st < n) {
            if(s.charAt(st) !=  ' ' ){
                sb.append(s.charAt(st++));
            } else {
                sb.append(s.charAt(st++));
                --k;
            }
        }

        return sb.toString();
    }
}
