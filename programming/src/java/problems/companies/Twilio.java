package src.java.problems.companies;

import java.util.ArrayList;
import java.util.List;

public class Twilio {
    public static void main(String[] args) {
        String s = "I like cheese";
        String t = "like";

        System.out.println(missingWords(s,t));
    }

    public static List<String> missingWords(String s, String t){
        String[] l1 = s.split(" ");

        List<String> l2 = new ArrayList<>();
        String [] t1 = t.split(" ");
        for(int i = 0;i<t1.length; i++){
            String k  = t1[i];
            l2.add(k);
        }

        List<String> res = new ArrayList<>();
        for(int i = l1.length-1; i>=0; i--){
            String  ss = l1[i];
            if(l2.contains(ss)) {
                int lastIndex = l2.lastIndexOf(ss);
                if(lastIndex <= i){
                    i = lastIndex;
                } else {
                    res.add(ss);
                }
            } else {
                res.add(ss);
            }
        }

        return res;

    }
}
