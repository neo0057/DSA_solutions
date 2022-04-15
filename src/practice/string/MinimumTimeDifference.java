package practice.string;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean minutes[] = new boolean[1440];
        for (int i = 0; i < timePoints.size(); i++) {
            String splitTime[] = timePoints.get(i).split(":");
            int hours = Integer.parseInt(splitTime[0]);
            int minute = Integer.parseInt(splitTime[1]);
            int totalTime = hours * 60 + minute;
            if (minutes[totalTime]) return 0;
            minutes[totalTime] = true;
        }
        int min = Integer.MAX_VALUE;
        int firstTimeStamp = -1;
        int lastTimeStamp = -1;
        int currentTimeStamp = -1;

        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i]) {
                if (lastTimeStamp == -1) {
                    lastTimeStamp = i;
                    firstTimeStamp = i;
                    continue;
                }
                currentTimeStamp = i;
                min = Math.min(min, currentTimeStamp - lastTimeStamp);
                lastTimeStamp = i;
            }
        }
        return Math.min(min, 1440 - lastTimeStamp + firstTimeStamp);
    }

    public static void main(String[] args) {
        String[] timePoints = {"23:59","00:00"};
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        System.out.println(minimumTimeDifference.findMinDifference(Arrays.asList(timePoints)));
    }
}
