package practice.array;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int c11 = 0, c12 = 0;
            int c21 = 0, c22 = 0;
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) c11++;
                if (rating[i] < rating[j]) c12++;
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[i] < rating[j]) c21++;
                if (rating[i] > rating[j]) c22++;
            }
            res += c11 * c21 + c12 * c22;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = {2, 5, 3, 4, 1};
        CountNumberOfTeams countNumberOfTeams = new CountNumberOfTeams();
        System.out.println(countNumberOfTeams.numTeams(ratings));
    }
}
