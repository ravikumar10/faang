package src.java.problems;

public class P35 {
    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrmu#p";

        System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String S, String T) {
        String sf = "";
        int i = S.length()-1;
        int hashCnt =0;
        while(i >= 0){
            if(S.charAt(i)  != '#'){
                if(hashCnt > 0){
                    i-=1;
                    hashCnt-=1;
                } else{
                    sf = S.charAt(i)+sf;
                    i-=1;
                }
            } else {
                hashCnt+=1;
                i-=1;
            }
        }

        String st = "";
         i = T.length()-1;
         hashCnt =0;
        while(i >= 0){
            if(T.charAt(i)  != '#'){
                if(hashCnt > 0){
                    i-=1;
                    hashCnt-=1;
                } else{
                    st = T.charAt(i)+st;
                    i-=1;
                }
            } else {
                hashCnt+=1;
                i-=1;
            }
        }

        return sf.equals(st);

    }
}
