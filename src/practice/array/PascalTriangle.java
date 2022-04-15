package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        if (numRows == 1) return res;
        res.add(Arrays.asList(1, 1));
        if (numRows == 2) return res;
        for (int i = 2; i < numRows; i++) {
            List<Integer> rowElements = new ArrayList<>();
            List<Integer> prvRow = res.get(i - 1);
            rowElements.add(1);
            for (int j = 0; j < prvRow.size() - 1; j++) rowElements.add(prvRow.get(j) + prvRow.get(j + 1));
            rowElements.add(1);
            res.add(rowElements);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> res = pascalTriangle.generate(10);
        for (List<Integer> list : res) {
            for (Integer num : list) System.out.print(num + " ");
            System.out.println();
        }
    }
}
