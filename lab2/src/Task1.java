//4. Дана матрица. Построить матрицу, полученную перестановкой
//столбцов(первого с последним, второго с предпоследним и т.д.) из данной.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int method = 0;
        System.out.println("Enter n > 0 dimension of matrix: ");
        int n = 0;
        while (true) {
            n = in.nextInt();
            if (n > 0){
                break;
            }
            System.out.println("Wrong. Try again. Write n > 0");
        }
        System.out.println("Choose method of matrix creating. Write 1 to write yourself, write 2 to randomize matrix: ");
        while (true) {
            method = in.nextInt();
            if (method == 1 || method == 2){
                break;
            }
            System.out.println("Wrong. Try again. Write 1 or 2.");
        }

        int[][] matrix = null;

        switch (method){
            case 1 -> matrix = createUserMatrix(n, in);
            case 2 -> matrix = createRandomMatrix(n);
        }
        printMatrix(matrix, "Matrix: ");
        swapColumnsOfMatrix(matrix);
        printMatrix(matrix, "Change Matrix: ");
    }

    public static int[][] createUserMatrix(int n, Scanner in){
        int [][] matrix = new int[n][n];
        System.out.println("Enter " + n + " rows:");
        for (int i = 0; i < n; i++){
            System.out.print("Row " + (i + 1) + ": ");
            for(int j = 0; j < n; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] createRandomMatrix(int n){
     int [][] matrix = new int[n][n];
        Random random = new Random();
     for (int i = 0; i < n; i++){
         for(int j = 0; j < n; j++){
             matrix[i][j] = random.nextInt(-10, 11);
         }
     }
     return matrix;
    }

    public static void swapColumnsOfMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix, String message){
        System.out.println(message);
        for(int[] row: matrix){
            System.out.print("[");
            for(int element: row) {
                System.out.printf("%4d", element);
            }
            System.out.println("]");
        }
        System.out.println();
    }
}