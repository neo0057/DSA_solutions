package practice.array;

public class RotateFunction {
    public int maxRotateFunction(int[] arr) {
        int arrSum = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            ans += i * arr[i];
        }
        int lastResult = ans;
        for (int i = arr.length - 1; i > 0; i--) {
            lastResult = lastResult - arr[i] * arr.length + arrSum;
            ans = Math.max(lastResult, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        RotateFunction rotateFunction = new RotateFunction();
        System.out.println(rotateFunction.maxRotateFunction(arr));
    }
}
