package practice.string;

public class VersionCompare {
    public static int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");
        int maxSize = Math.max(v1Arr.length, v2Arr.length);
        for (int i = 0; i < maxSize; i++) {
            Integer v1 = (i < v1Arr.length) ? Integer.valueOf(v1Arr[i]) : Integer.valueOf("0");
            Integer v2 = (i < v2Arr.length) ? Integer.valueOf(v2Arr[i]) : Integer.valueOf("0");
            int res = v1.compareTo(v2);
            if (res != 0) return res;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.0";
        String v2 = "1.0.0";
        System.out.println(compareVersion(v1, v2));
    }
}
