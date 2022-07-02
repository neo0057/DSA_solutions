package interviews.india.bInsight;

import java.util.ArrayList;
import java.util.List;

public class BInsightR2 {

    public boolean isPalindrome(int n) {
        List<Integer> remainders = new ArrayList<>();
        while (n > 0) {
            Integer r = n%10;
            remainders.add(r);
            n = n/10;
        }
        int len = remainders.size();
        for (int i = 0; i < len/2; i++) {
            if (remainders.get(i) != remainders.get(len - i - 1)) return false;
        }
        return true;
    }
}
