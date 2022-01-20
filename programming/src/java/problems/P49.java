package src.java.problems;

public class P49 {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {

        if(s.length() == 0)
            return s;

        s = s.trim();

        String[] st = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = st.length-1;i>0; i--){
            if(st[i].length() == 0)
                continue;
            sb.append(st[i]);
            sb.append(" ");
        }

        sb.append(st[0]);

        return sb.toString();
    }
}
