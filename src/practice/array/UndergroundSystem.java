package practice.array;

import java.util.*;

public class UndergroundSystem {
    Map<Integer, Map<String, Integer>> checkInUserMap;
    Map<Integer, Map<String, Integer>> checkOutUserMap;

    public UndergroundSystem() {
        this.checkInUserMap = new HashMap<>();
        this.checkOutUserMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int time) {
        Map<String, Integer> map = (checkInUserMap.containsKey(id)) ? checkInUserMap.get(id) : new HashMap<>();
        map.put(stationName, time);
        checkInUserMap.put(id, map);
    }

    public void checkOut(int id, String stationName, int time) {
        Map<String, Integer> map = (checkOutUserMap.containsKey(id)) ? checkOutUserMap.get(id) : new HashMap<>();
        map.put(stationName, time);
        checkOutUserMap.put(id, map);
    }

    public double getAverageTime(String startStation, String endStation) {
        double sum = 0.0;
        int count = 0;
        for (int userId : checkInUserMap.keySet()) {
            Map<String, Integer> userCheckInMap = checkInUserMap.get(userId);
            if (!userCheckInMap.containsKey(startStation)) continue;
            if (!checkOutUserMap.containsKey(userId)) continue;
            Map<String, Integer> userCheckOutMap = checkOutUserMap.get(userId);
            if (!userCheckOutMap.containsKey(endStation)) continue;
            int checkInTime = userCheckInMap.get(startStation);
            int checkOutTime = userCheckOutMap.get(endStation);
            sum += checkOutTime - checkInTime;
            count++;
        }
        return sum/count;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000.
        // One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); // return 11.00000.
        // Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); // return 12.00000.
        // Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
