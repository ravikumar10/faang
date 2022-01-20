package src.java.problems;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P40 {
    public static void main(String[] args) {
        replaceDigits("a1b2c3d4e");
    }

    private static void replaceDigits(String s) {
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Integer> cntM = new HashMap<>();
        Map<Integer, List<Integer>> indxM = new HashMap<>();

        for(int i=0; i< groupSizes.length; i++){
            cntM.put(groupSizes[i], cntM.getOrDefault(groupSizes[i], 0)+1);

            if(!indxM.containsKey(groupSizes[i])){
                List<Integer> l = new ArrayList<>();
                l.add(i);
                indxM.put(groupSizes[i], l);
            } else{
                List<Integer> l = indxM.get(groupSizes[i]);
                l.add(i);
                indxM.put(groupSizes[i], l);
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : cntM.entrySet()){
            int key = entry.getKey();
            int size = entry.getValue();
            final AtomicInteger counter = new AtomicInteger(0);

            List<Integer> list = indxM.get(key);
            if(size % key == 0){
                Collection<List<Integer>> subLists=list.stream().collect(Collectors.groupingBy
                        (it->counter.getAndIncrement() / key))
                        .values();
                res.addAll(subLists) ;

            }
        }

        return res;

    }
}
