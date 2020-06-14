package spiral;

import java.util.Scanner;

public class Spiral {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Code from Pedro Fortes - pedrofortes4@gmail.com
        
        int n, origem, x, y, valor = 0, passos = 1;
        // 'n' is the side of the square (matrix); 'origem' is the point where value 1 will be assigned;
        // 'x' and 'y' are the indexes: z[y][x]; 'valor' + 1 is the value to be assigned to each position of the matrix;
        // 'passos' is the amount of times some directional jumps will need to happen;
        System.out.println("Input the side of the matrix");
        n = sc.nextInt();
        int[][] z = new int[n][n];
        origem = (n - 1) / 2;
        // This is how you calculate where value 1 begins at the matrix;
        x = origem;
        y = origem;
        // value 1 will always be at the main diagonal of the matrix. So both 'x' and 'y' receive 'origem';
        z[y][x] = (valor + 1);
        // Here I assign the first value, 1
        while ((valor + 1) < n * n) {
            // This loop allows this code to work for any value of 'n'
            // It uses the value assigned to each matrix position as a verification parameter.
            // When it reaches n², it's over.
            z[y][++x] = (++valor + 1);
            // When the last value assigned is odd, the next step is always to jump to the right (++x) once on the matrix...
            // ... and then assign last value + 1 (++valor)
            for (int i = 0; i < passos; i++) {
                // Then, jump down (++y) a number of times (passos) equal to the side of the CURRENT square - 1
                // I already initialized 'passos' as 1, which corresponds to the first case
                z[++y][x] = (++valor + 1);
                // Jump one down, assign incremented value. I always add 1 because 'valor' started at zero.
            }

            for (int i = 0; i < passos; i++) {
                // Second step when last square ends with an odd number is to jump to the left (--x) the same amount of times...
                //...as we jumped down in the last "for" loop. This is how we add extra layers as sides of the square
                z[y][--x] = (++valor + 1);
                // Jump one left, assign incremented value.
            }
            // If 'n' is even, the process will be finished at this point after (n - 1) occurrences of the last loop.
            if ((valor + 1) == (n * n)) {
                break;
                // So, we check if that's the case. If it is, we break the "while" loop and move foward to printing results.
            }
            passos++;
            // 'passos' must be incremented if the process isn't finished yet.
            z[y][--x] = (++valor + 1);
            // When the last value assigned is even, the next step is always to jump to the left (--x) once on the matrix...
            // ... and then assign last value + 1 (++valor)
            for (int i = 0; i < passos; i++) {
                // Then, jump up (--y) a number of times (passos) equal to the side of the CURRENT square - 1
                // And keep assigning the incremented value to that position
                z[--y][x] = (++valor + 1);

            }

            for (int i = 0; i < passos; i++) {
                // And finally, jump right (++x) a number of times (passos) equal to the side of the CURRENT square - 1
                z[y][++x] = (++valor + 1);

            }

            passos++;
            // Increment the value of 'passos' in case the "while" loop isn't finished
        }
        // Now, let's print the resulting matrix
        double controle;
        int digitosMax, digitosValor, zeros;

        digitosMax = (int) (Math.log10((double) (n * n)));
        // Here, I use logarithm base 10 of the biggest possible number on the matrix (n²) to find out its amount of digits;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // These overlaid loops will run through each position of the matrix
                controle = Math.log10((double) (z[i][j]));
                // Now I get the amount of digits of the value on the current position
                digitosValor = (int) controle;
                // Convert into "int", once we can only calculate logarithms from double variables
                zeros = digitosMax - digitosValor;
                // Getting the difference between the current value and the max value amount of digits
                // This allows us to have a good lookin', well formatted, aligned output
                for (int k = 0; k < zeros; k++) {
                    // This loop adds a blank space for each digit remaining on the current value in relation to the maximum value
                    System.out.print(" ");
                    // I actually started adding zeros instead of blank spaces (hence the name of the variable)
                    // But I liked the result with blank spaces more than with zeros.
                    // If you want to try the zeros, just replace (" ") in the print statement by (0)
                }
                System.out.print(z[i][j] + " ");
                // This is the value of the current position of the matrix, followed by the space to separate values on the same line
            }
            System.out.println("");
            // And finally, the new line after the last value of the column
        }

    }

}
