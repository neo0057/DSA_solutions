package practice.string;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int r = columnNumber % 26;
            char ch = (char) (r + 'A');
            res.append(ch);
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        System.out.println(excelSheetColumnTitle.convertToTitle(701));
        System.out.println(excelSheetColumnTitle.convertToTitle(28));
    }
}
