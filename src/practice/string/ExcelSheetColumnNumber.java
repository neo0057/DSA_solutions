package practice.string;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char ch : columnTitle.toCharArray()) res = res * 26 + (ch + 1 - 'A');
        return res;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("AB"));
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
    }
}
