package practice.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterRestaurant {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = Stream.of(restaurants).filter(restaurant -> restaurant[2] == veganFriendly)
                .filter(restaurant -> restaurant[3] <= maxPrice)
                .filter(restaurant -> restaurant[4] <= maxDistance)
                .sorted(Comparator.comparingInt(restaurant -> restaurant[1]))
                .map(restaurant -> restaurant[0])
                .collect(Collectors.toList());
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        int veganFriendly = 1, maxPrice = 50, maxDistance = 10;
        FilterRestaurant filterRestaurant = new FilterRestaurant();
        System.out.println(filterRestaurant.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }
}
