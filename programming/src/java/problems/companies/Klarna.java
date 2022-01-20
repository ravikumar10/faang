package src.java.problems.companies;

import java.util.*;

public class Klarna {

    static Map<String, List<String>> menuMap = new HashMap<String, List<String>>(){{
            put("Classic", Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey"));
            put("Freezie", Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"));
            put("Greenie", Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice"));
            put("Just Desserts", Arrays.asList("banana", "lime", "ice cream", "chocolate", "peanut", "cherry"));
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ingredients("Greenie,   -lime"));
    }

    public static String ingredients(String order) {
        List<String> finalOrder = getMenuDetails(order);
        return String.join(",", finalOrder);
    }

    public static List<String> getMenuDetails(String menuOptions){

        if(menuOptions == null || menuOptions.isEmpty()){
            throw new IllegalArgumentException();
        }

        String[] menu  = menuOptions.trim().split(",");
        List<String> omitList = new ArrayList<>();
        List<String> addList = new ArrayList<>();
        String key = menu[0];
        for(int i=1; i<menu.length; i++){
            if(menu[i].trim().startsWith("-"))
                omitList.add(menu[i].trim().substring(1).trim());
            else {
                addList.add(menu[i].trim());
            }
        }

        return processMenu(key, omitList, addList);
    }

    public static List<String> processMenu(String menuKey, List<String> omitList, List<String> addList){
        if(! menuMap.containsKey(menuKey)){
            throw new IllegalArgumentException();
        }

        List<String> order = new LinkedList<>(menuMap.get(menuKey));

        for(int i=0; i<addList.size(); i++){
            if(order.contains(addList.get(i))){
                throw new IllegalArgumentException();
            }
        }

        for(int i=0; i<omitList.size(); i++){
            if(order.contains(omitList.get(i))){
                order.remove(omitList.get(i));
            }
        }

         Collections.sort(order);
        return order;
    }
}
