package practice.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int res = 0, c = 1;
        int start = 0;
        char prv = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == prv) c++;
            else {
                if (c > 1){
                    chars[start++] = prv;
                    List<Integer> arr = findDigits(c);
                    for (int j = arr.size() - 1; j >= 0; j--) chars[start++] = (char) (arr.get(j) + '0');
                    res += arr.size() + 1;
                } else {
                    chars[start++] = prv;
                    res++;
                }
                c= 1;
                prv = chars[i];
            }
        }
        if (c == 1) {
            chars[start] = prv;
            res++;
        }
        else if (c > 1) {
            chars[start++] = prv;
            List<Integer> arr = findDigits(c);
            for (int j = arr.size() - 1; j >= 0; j--) chars[start++] = (char) (arr.get(j) + '0');
            res += arr.size() + 1;
        }
        chars = Arrays.copyOfRange(chars, 0, res);
        return res;
    }

    private List<Integer> findDigits(int n) {
        int res = 0;
        List<Integer> arr = new ArrayList<>();
        while (n > 0) {
            arr.add(n%10);
            n = n/10;
            res++;
        }
        return arr;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] chars3 = {'a', 'b', 'c'};
        char[] chars4 = {'a','a','a','a','a','b'};
        StringCompression sc = new StringCompression();
        System.out.println(sc.compress(chars4));
        System.out.println(chars4);
    }
}
