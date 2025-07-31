package backtracking;

/**
 * For a given n, form a magic square with numbers 1 to n^2, with each row, column and diagonal sum equal.
 */

public class MagicSquare {

    public static void main(String[] args) {
        //formMagicSquareUsingBacktracking(5);
        int[][] square = magicSquareForOdd(5);
        printSquare(square);
        System.out.println("Magic square for double even n");
        int[][] magicSquare = magicSquareUsingStrachey(4);
        printSquare(magicSquare);
    }

    public static void formMagicSquareUsingBacktracking(int n) {
        if (n < 3) {
            throw new IllegalArgumentException("Invalid n");
        }
        int[][] square = new int[n][n];
        boolean[] used = new boolean[n * n + 1];
        int magicSum = n * (n * n + 1) / 2;
        if (solve(0, 0, square, used, magicSum)) {
            printSquare(square);
        } else {
            System.out.println("Couldn't find a solution");
        }
    }

    private static boolean solve(int row, int col, int[][] square, boolean[] used, int magicSum) {
        int n = square.length;
        if (row == n) {
            return isMagicSquare(square, magicSum);
        }
        for (int i = 1; i <= n * n; i++) {
            if (!used[i]) {
                square[row][col] = i;
                used[i] = true;
                int nextRow = col == n - 1 ? row + 1 : row;
                int nextCol = col == n - 1 ? 0 : col + 1;
                if (isSafe(row, col, square, magicSum)) {
                    if (solve(nextRow, nextCol, square, used, magicSum)) return true;
                }
                square[row][col] = 0;
                used[i] = false;
            }
        }
        return false;
    }

    private static boolean isMagicSquare(int[][] square, int magicSum) {
        // check each row sum
        for (int i = 0; i < square.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < square.length; j++) {
                rowSum += square[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        // check each column sum
        for (int i = 0; i < square.length; i++) {
            int colSum = 0;
            for (int j = 0; j < square.length; j++) {
                colSum += square[j][i];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < square.length; i++) {
            diagonalSum1 += square[i][i];
            diagonalSum2 += square[i][square.length - 1 - i];
        }

        return diagonalSum1 == magicSum && diagonalSum2 == magicSum;
    }

    private static void printSquare(int[][] square) {
        for (int[] ints : square) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int row, int col, int[][] square, int magicSum) {
        // Check column sum
        if (row == square.length - 1) {
            int sum = 0;
            for (int i = 0; i < square.length; i++) {
                sum += square[i][col];
            }
            if (sum != magicSum) {
                return false;
            }
        }

        // Check row sum
        if (col == square.length - 1) {
            int sum = 0;
            for (int i = 0; i < square.length; i++) {
                sum += square[row][i];
            }
            if (sum != magicSum) {
                return false;
            }
        }

        // check partial sums
        int sum = 0;
        for (int i = 0; i <= col; i++) {
            sum += square[row][col];
        }
        if (sum > magicSum) {
            return false;
        }

        return true;
    }

    // Siamese method for odd n
    public static int[][] magicSquareForOdd(int n) {
        if (n % 2 == 0) {
            throw new IllegalArgumentException("Siamese method works only for odd n");
        }
        int[][] square = new int[n][n];
        // Start the 1st num from top row middle column
        int i = 0, j = n / 2;
        for (int num = 1; num <= n * n; num++) {
            square[i][j] = num;
            // Move up and right , wrap up if required
            int nextI = (i - 1 + n) % n;
            int nextJ = (j + 1) % n;
            // If already occupied then move down
            if (square[nextI][nextJ] != 0) {
                i = i + 1;
            } else {
                i = nextI;
                j = nextJ;
            }
        }
        return square;
    }

    public static int[][] magicSquareUsingStrachey(int n) {
        if (n % 4 != 0) {
            throw new IllegalArgumentException("Strachey method is applicable only for double even numbers");
        }
        int[][] square = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = num;
                num++;
            }
        }
        int magicNum = n * n + 1;
        for (int i = 0; i < n; i++) {
            square[i][i] = magicNum - square[i][i];
            square[i][n - 1 - i] = magicNum - square[i][n - 1 - i];
        }
        return square;
    }


}
