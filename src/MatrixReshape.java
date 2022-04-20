import java.util.Arrays;

public class MatrixReshape {
    // runtime : O(n*m + r*c)
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        // transfer mat to 1d matrix
        int[] mat1d = new int[m*n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat1d[k] = mat[i][j];
                k++;
            }
        }
        // reshape 1d matrix to rxc matrix'
        int l = 0;
        int[][] newMatrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                 newMatrix[i][j] = mat1d[l];
                l++;
            }
        }
        return newMatrix;
    }

    public static void main (String[] args) {
        int[][] mat = {{1,2}, {3,4}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }

        int[][] reshaped = matrixReshape(mat, 2,4);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(reshaped[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
