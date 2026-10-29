//16.
//В матрице найти минимальный элемент и переместить его на место
//заданного элемента путем перестановки строки столбцов

import java.util.Scanner;


 class Task2 {
  public static void main(String[] args) {
   Scanner in = new Scanner(System.in);
   int method = 0;
   System.out.println("Enter n > 0 dimension of matrix: ");
   int n = 0;
   while (true) {
    n = in.nextInt();
    if (n > 0) {
     break;
    }
    System.out.println("Wrong. Try again. Write n > 0");
   }
   System.out.println("Choose method of matrix creating. Write 1 to write yourself, write 2 to randomize matrix: ");
   while (true) {
    method = in.nextInt();
    if (method == 1 || method == 2) {
     break;
    }
    System.out.println("Wrong. Try again. Write 1 or 2.");
   }

   int[][] matrix = null;

   switch (method) {
    case 1 -> matrix = Task1.createUserMatrix(n, in);
    case 2 -> matrix = Task1.createRandomMatrix(n);
   }
   Task1.printMatrix(matrix, "Matrix: ");

   int targetRow = readIndex(in, n, "row");
   int targetCol = readIndex(in, n, "column");

   changeMinToSelectElement(matrix, targetRow, targetCol);

   Task1.printMatrix(matrix, "Change Matrix: ");
  }

  public static int readIndex(Scanner in, int n, String name) {
   while (true) {
    System.out.println("Enter target " + name + " (1.." + n + "): ");
    int value = in.nextInt();
    if (value >= 1 && value <= n) {
     return value - 1;
    }
    System.out.println("Wrong. Try again.");
   }
  }

  public static void changeMinToSelectElement(int[][] matrix, int targetRow, int targetColumn){
   int[] min = findMinEl(matrix);
   int minRow = min[0];
   int minCol = min[1];

   swapColumns(matrix, minCol, targetColumn);
   swapRows(matrix, minRow, targetRow);
  }

  public static void swapColumns(int[][] matrix, int minColumn, int targetColumn){
  if (targetColumn == minColumn){
   return;
  }

  for(int i = 0; i < matrix.length; i++){
   int temp = matrix[i][minColumn];
   matrix[i][minColumn] = matrix[i][targetColumn];
   matrix[i][targetColumn] = temp;
  }
  }

  public static void swapRows(int[][] matrix, int minRow, int targetRow){
   if (targetRow == minRow){
    return;
   }

    int[] temp = matrix[minRow];
    matrix[minRow] = matrix[targetRow];
    matrix[targetRow] = temp;
  }

  public static int[] findMinEl(int[][] matrix){
   int minRow = 0;
   int minCol = 0;
   int minVal = matrix[0][0];

   for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
     if (matrix[i][j] < minVal) {
      minVal = matrix[i][j];
      minRow = i;
      minCol = j;
     }
    }
   }

   return new int[]{minRow, minCol};
  }
 }

