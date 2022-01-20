package src.java.problems;

import java.util.*;

public class P45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine().trim().split(" ")[1]);
        Map<String, List<Integer>> map = new HashMap<>();
        while(size-- > 0){
            String [] ip = sc.nextLine().trim().split(" ");
            String key = ip[2]+ip[3];
            int val = Integer.parseInt(ip[1]);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(val);
        }
        System.out.println();
        for(Map.Entry<String, List<Integer>> m : map.entrySet()){
            StringBuilder sb = new StringBuilder();
            int[] arr = m.getValue().stream().mapToInt(i -> i).toArray();
            sb.append(m.getKey());
            sb.append(": [");
            for (int i =0; i<arr.length-1; i++)
                sb.append(arr[i] + " ");
            sb.append(arr[arr.length-1]);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }


}

/*
init 12
reg 1 B V
reg 2 A V
reg 3 A V
reg 4 B NV
reg 5 B V
reg 6 A NV
reg 7 A V
reg 8 A NV
reg 9 B NV
reg 10 B V
reg 11 A NV
reg 12 B NV
fin
 */