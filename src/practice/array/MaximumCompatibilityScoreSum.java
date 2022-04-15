package practice.array;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumCompatibilityScoreSum {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        Comparator<int[]> comparator = (a1, a2) -> {
            int i = 0;
            while (i < a1.length && a1[i] == a2[i]) i++;
            if (i == a1.length) return 0;
            return a1[i] - a2[i];
        };
        Arrays.sort(students, comparator);
        Arrays.sort(mentors, comparator);
        int res = 0;
        for (int i = 0; i < students.length; i++) {
            int[] studentScore = students[i];
            int[] mentorScore = mentors[i];
            for (int j = 0; j < studentScore.length; j++) {
                res += (studentScore[j] == mentorScore[j]) ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] students = {{1, 1, 0}, {1, 0, 1}, {0, 0, 1}}, mentors = {{1, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        int[][] students2 = {{0, 0}, {0, 0}, {0, 0}}, mentors2 = {{1, 1}, {1, 1}, {1, 1}};
        int[][] students3 = {{0, 0, 1, 1, 1, 0, 1}, {0, 1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 1, 1}};
        int[][] mentors3 = {{0, 1, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1}, {0, 1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0}};
        MaximumCompatibilityScoreSum maximumCompatibilityScoreSum = new MaximumCompatibilityScoreSum();
//        System.out.println(maximumCompatibilityScoreSum.maxCompatibilitySum(students, mentors));
//        System.out.println(maximumCompatibilityScoreSum.maxCompatibilitySum(students2, mentors2));
        System.out.println(maximumCompatibilityScoreSum.maxCompatibilitySum(students3, mentors3));
    }
}
