package practice.string;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTableOfFood {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, List<String>> tableOrderMap = new TreeMap<>();
        TreeSet<String> foodSet = new TreeSet<>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            tableOrderMap.compute(tableNumber, (k, v) -> (v == null) ? new ArrayList<>() : v).add(order.get(2));
            foodSet.add(order.get(2));
        }
        List<List<String>> res = new ArrayList<>();
        List<String> items = new ArrayList<>();
        items.add("Table");
        items.addAll(foodSet);
        res.add(items);
        for (Integer tableNumber : tableOrderMap.keySet()) {
            List<String> tableOrders = tableOrderMap.get(tableNumber);
            List<String> itemCounts = new ArrayList<>();
            itemCounts.add(String.valueOf(tableNumber));
            for (String item : foodSet) {
                long count = tableOrders.stream().filter(item::equals).count();
                itemCounts.add(String.valueOf(count));
            }
            res.add(itemCounts);
        }
        return res;
    }

    public static void main(String[] args) {
        String[][] orders = {{"David", "3", "Ceviche"}, {"Corina", "10", "Beef Burrito"}, {"David", "3", "Fried Chicken"}, {"Carla", "5", "Water"}, {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}};
        DisplayTableOfFood displayTableOfFood = new DisplayTableOfFood();
        List<List<String>> orderList = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            List<String> tableOrder = new ArrayList<>();
            tableOrder.add(orders[i][0]);
            tableOrder.add(orders[i][1]);
            tableOrder.add(orders[i][2]);
            orderList.add(tableOrder);
        }
        System.out.println(displayTableOfFood.displayTable(orderList));
    }
}
