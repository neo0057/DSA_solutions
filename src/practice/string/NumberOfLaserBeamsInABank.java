package practice.string;

public class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int[] dp = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            int count = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') count++;
            }
            dp[i] = count;
        }
        int res = 0;
        int prvCount = dp[0];
        for (int i = 1; i < bank.length; i++) {
            if (dp[i] == 0) continue;
            if (prvCount > 0) res += dp[i] * prvCount;
            prvCount = dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] bank = {"011001", "000000", "010100", "001000"};
        NumberOfLaserBeamsInABank numberOfLaserBeamsInABank = new NumberOfLaserBeamsInABank();
        System.out.println(numberOfLaserBeamsInABank.numberOfBeams(bank));
    }
}
