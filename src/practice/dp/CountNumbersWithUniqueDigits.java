package practice.dp;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;
        int currRes = 9;
        int multiplier = 9;
        while (n > 1) {
            currRes *= multiplier;
            res += currRes;
            multiplier--;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(2));
    }
}
