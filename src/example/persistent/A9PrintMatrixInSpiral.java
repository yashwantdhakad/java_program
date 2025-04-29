package example.persistent;

public class A9PrintMatrixInSpiral {
    public static void printSpiral(int[][] matrix) {
        // Validate input
        if (matrix == null || matrix.length == 0) {
            System.out.println("Matrix is empty or null");
            return;
        }

        int topRow = 0, bottomRow = matrix.length - 1;
        int leftCol = 0, rightCol = 0;

        // Determine the maximum column length for each row
        int maxCols = 0;
        for (int[] row : matrix) {
            if (row != null && row.length > maxCols) {
                maxCols = row.length;
            }
        }
        rightCol = maxCols - 1;

        StringBuilder result = new StringBuilder();

        while (topRow <= bottomRow && leftCol <= rightCol) {
            // Traverse from left to right across the top row
            for (int i = leftCol; i <= rightCol && topRow < matrix.length && i < matrix[topRow].length; i++) {
                result.append(matrix[topRow][i]).append(" ");
            }
            topRow++;

            // Traverse down the rightmost column
            for (int i = topRow; i <= bottomRow && rightCol >= 0; i++) {
                if (i < matrix.length && rightCol < matrix[i].length) {
                    result.append(matrix[i][rightCol]).append(" ");
                }
            }
            rightCol--;

            // Traverse from right to left across the bottom row (if there is any)
            if (leftCol <= rightCol && bottomRow >= 0) {
                for (int i = rightCol; i >= leftCol && bottomRow < matrix.length && i < matrix[bottomRow].length; i--) {
                    result.append(matrix[bottomRow][i]).append(" ");
                }
                bottomRow--;
            }

            // Traverse up the leftmost column (if there is any)
            if (topRow <= bottomRow && leftCol >= 0) {
                for (int i = bottomRow; i >= topRow && i < matrix.length && leftCol < matrix[i].length; i--) {
                    result.append(matrix[i][leftCol]).append(" ");
                }
                leftCol++;
            }
        }

        System.out.println("Spiral form of the matrix: " + result.toString().trim());
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        printSpiral(matrix);

        // Test with uneven rows
        int[][] unevenMatrix = {
                {1, 2, 3},
                {4, 5},
                {6}
        };
        System.out.println("\nUneven Matrix:");
        for (int[] row : unevenMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        printSpiral(unevenMatrix);

        // Test with empty matrix
        int[][] emptyMatrix = {};
        printSpiral(emptyMatrix);
    }
}