package practice.string;

public class Permutation {

    public void permutation(String str) {
        permutationRec(str, 0, str.length() - 1);
    }

    private void permutationRec(String str, int left, int right) {
        if (left == right) System.out.println(str);
        else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permutationRec(str, left + 1, right);
                str = swap(str, left, i);
            }
        }
    }

    private String swap(String str, int i, int j) {
        char[] charArr = str.toCharArray();
        char t = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = t;
        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        String str = "ABCD";
        Permutation permutation = new Permutation();
        permutation.permutation(str);
    }
}
