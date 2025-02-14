package secao10;

import java.util.Scanner;

public class s10ex3 {
    public static void execute(){
        Scanner sc = new Scanner(System.in);

        System.out.print("M: ");
        int m = sc.nextInt();

        System.out.print("N: ");
        int n = sc.nextInt();

        System.out.print("\n");


        int[][] matrix = new int[m][n];

        // Populate matrix
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("\n");

        // Print matrix
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }

        System.out.print("\nX: ");
        int x = sc.nextInt();

        // Search for X
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                // Print current position of X
                if (matrix[i][j] == x){
                    System.out.print("Position "+ i + "," + j + "\n");

                    // Print adjacent numbers to X
                    // Up
                    if(i > 0){
                        System.out.print("Up: "+ matrix[i-1][j] + "\n");
                    }

                    // Right
                    if(j < n - 1){
                        System.out.print("Right: "+ matrix[i][j+1] + "\n");
                    }

                    // Left
                    if(j > 0){
                        System.out.print("Left: "+ matrix[i][j-1] + "\n");
                    }

                    // Down
                    if(i < m - 1){
                        System.out.print("Down: "+ matrix[i+1][j] + "\n");
                    }
                }



            }
        }


        sc.close();
    }
}

