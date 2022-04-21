import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PiscalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        List<Integer> row;
        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            row = new ArrayList<>();
            row.add(0,1);
            for (int i = 1; i < rowNum; i++) {
                row.add(i, prevRow.get(i-1) + prevRow.get(i));
            }
            if (rowNum != 0) row.add(rowNum, 1);
            triangle.add(row);
            prevRow = row;
        }
        return triangle;
    }

    public static void main (String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generate(numRows);
        for (int row = 0; row < numRows; row++) {
            for (int i = 0; i < row + 1; i ++) {
                System.out.print(triangle.get(row).get(i));
            }
            System.out.println();
        }
    }

}
