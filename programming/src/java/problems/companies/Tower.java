package src.java.problems.companies;

import java.util.*;

public class Tower {
    public static void main(String[] args) {
        String[] s = {"He", "loves", "eating", "corn"};
        System.out.println(goodPairs(4, s));
    }

    public static int goodPairs(int N, String[] S){
        //this is default OUTPUT. You can change it.

        char[] inArray = "orange".toCharArray();
        int result=-404;

        //write your Logic here:
        Map<String, List<String>> m = new HashMap<>();
        for(String s : S){
            int i=0;

            Set<Character> chSet = new HashSet<>();
            for (char o : s.toLowerCase().toCharArray()) {
                chSet.add(o);
            }

            StringBuffer sb = new StringBuffer();
            for(i=0;i<inArray.length;i++){
                if(chSet.contains(inArray[i])) {
                    sb.append(inArray[i]);
                }
            }
            String key = sb.toString();

            if(m.containsKey(key)){
                m.get(key).add(s);
            } else {
                if(!key.isEmpty()) {
                    m.put(key, new ArrayList<String>());
                    m.get(key).add(s);
                }
            }
        }

        int cnt=0;
        for(String k : m.keySet()){
            StringBuffer requiredKey = new StringBuffer();
            for(int i=0;i<inArray.length;i++){
                if(k.indexOf(inArray[i]) == -1)
                    requiredKey.append(inArray[i]);
            }

            String rkKey = requiredKey.toString();
            cnt+= (m.getOrDefault(rkKey,new ArrayList<>()).size()*m.get(k).size());

        }

        return cnt;
    }
}
