package practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, List<Integer>> pickUpMap = new HashMap<>();
        Map<Integer, List<Integer>> dropMap = new HashMap<>();
        for (int[] trip : trips) {
            pickUpMap.compute(trip[1], (k, v) -> (v == null) ? new ArrayList<>() : v).add(trip[0]);
            dropMap.compute(trip[2], (k, v) -> (v == null) ? new ArrayList<>() : v).add(trip[0]);
        }
        int remainingCapacity = capacity;
        for (int point = 0; point <= 1000; point++) {
            if (dropMap.containsKey(point)) remainingCapacity += getPassengerSum(dropMap.get(point));
            if (pickUpMap.containsKey(point)) remainingCapacity -= getPassengerSum(pickUpMap.get(point));
            if (remainingCapacity < 0) return false;
        }
        return true;
    }

    private int getPassengerSum(List<Integer> integers) {
        int sum = 0;
        for (Integer num : integers) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        int[][] trips = {{9, 0, 1}, {3, 3, 7}};
        int capacity = 4;
        int[][] trips2 = {{2, 1, 5}, {3, 5, 7}};
        int[][] trips3 = {{9, 3, 4}, {9, 1, 7}, {4, 2, 4}, {7, 4, 5}};
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(trips, capacity));
//        System.out.println(carPooling.carPooling(trips, capacity + 1));
//        System.out.println(carPooling.carPooling(trips2, 3));
//        System.out.println(carPooling.carPooling(trips3, 23));
    }
}
