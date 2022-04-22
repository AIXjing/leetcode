public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowNums = matrix.length;
        int colNums = matrix[0].length;
        // if target is larger than the maximum value in the matrix, return false;
        if (target > matrix[rowNums - 1][colNums - 1]) return false;
        // else to find in which row the target will be by comparing target with the first element in each row
        int checkRow = 0;
        for (int i = 0; i < rowNums; i++) {
            if (target == matrix[i][0]) return true;
            // if target smaller than the first element in each row, then it must be in the above row
            if (target < matrix[i][0]) {
                if (i != 0) checkRow = i - 1;
                break;
            }
        }
        // if target is larger than the first element in the last row, then check the last row
        if (target > matrix[rowNums-1][0]) checkRow = rowNums - 1;
//        int i = 0;
//        while (i < rowNums && target >= matrix[i][0]) {
//            if (target == matrix[i][0]) return true;
//            i++;
//        }

        for (int j = 0; j < colNums; j++) {
            if (matrix[checkRow][j] == target) return true;
        }
        return false;
    }

    public static void main (String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 30;
        System.out.println(searchMatrix(matrix, target));
    }
}
