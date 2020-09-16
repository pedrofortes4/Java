package calculadoramatricial;
import java.util.Scanner;
public class CalculadoraMatricial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1, n1, m2, n2, preencher, k = 0;
        float c = 0;

        System.out.print("MULTIPLICAÇÃO MATRICIAL: ");
        System.out.println("A x B = C");
        System.out.print("Informe o número de linhas de A (m1): ");
        m1 = sc.nextInt();
        System.out.print("Informe o número de colunas de A (n1): ");
        m2 = sc.nextInt();
        System.out.print("Informe o número de linhas de B (m2): ");
        n1 = sc.nextInt();
        System.out.print("Informe o número de colunas de B (n2): ");
        n2 = sc.nextInt();

        if (n1 != m2) {
            System.out.println("Multiplicação inviável.");
            System.out.println("O número de colunas da primeira matriz(n1) deve ser igual ao número de linhas da segunda(m2).");
        } else {
            float A[][] = new float[m1][n1];
            float B[][] = new float[m2][n2];
            float C[][] = new float[m1][n2];
            System.out.println("Como deseja preencher os elementos das matrizes? Digite o número correspondente:");
            System.out.println("(1) Manualmente");
            System.out.println("(2) Automaticamente");
            preencher = sc.nextInt();

            switch (preencher) {
                case 1: // PREENCHIMENTO MANUAL
                    // Matriz A {
                    System.out.println("Matriz A:");
                    for (int i = 0; i < m1; i++) {
                        for (int j = 0; j < n1; j++) {
                            System.out.print("Insira o valor do elemento a" + (i + 1) + "" + (j + 1) + ": ");
                            A[i][j] = sc.nextFloat();
                        }
                    }

                    System.out.println("Matriz A:");
                    for (int i = 0; i < m1; i++) {
                        for (int j = 0; j < n1; j++) {
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    // } Matriz A

                    // Matriz B {
                    System.out.println("Matriz B:");
                    for (int i = 0; i < m2; i++) {
                        for (int j = 0; j < n2; j++) {
                            System.out.print("Insira o valor do elemento b" + (i + 1) + "" + (j + 1) + ": ");
                            B[i][j] = sc.nextFloat();
                        }
                    }

                    System.out.println("Matriz B:");
                    for (int i = 0; i < m2; i++) {
                        for (int j = 0; j < n2; j++) {
                            System.out.print(B[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    // } Matriz B
                    break;
                case 2: // PREENCHIMENTO AUTOMÁTICO (ALEATÓRIO)
                    int inf, sup, mul, add;
                    System.out.println("Informe o menor valor possível para os elementos das matrizes:");
                    inf = sc.nextInt();
                    System.out.println("Informe o maior valor possível para os elementos das matrizes:");
                    sup = sc.nextInt();
                    mul = sup - inf + 1;
                    mul = (inf < 0 && sup > 0) ? ++mul : mul;
                    add = inf;
                    add = (inf < 0) ? --add : add;
                    // Matriz A {
                    for (int i = 0; i < m1; i++) {
                        for (int j = 0; j < n1; j++) {
                            A[i][j] = (int)((Math.random()*mul)+add);
                        }
                    }

                    System.out.println("Matriz A:");
                    for (int i = 0; i < m1; i++) {
                        for (int j = 0; j < n1; j++) {
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    // } Matriz A

                    // Matriz B {
                    for (int i = 0; i < m2; i++) {
                        for (int j = 0; j < n2; j++) {
                            B[i][j] = (int)((Math.random()*mul)+add);
                        }
                    }

                    System.out.println("Matriz B:");
                    for (int i = 0; i < m2; i++) {
                        for (int j = 0; j < n2; j++) {
                            System.out.print(B[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    // } Matriz B
                    break;
                default:
                    break;
            }

            // Matriz C { 
            //Preenchimento
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {

                    while (k < n1) {
                        c += A[i][k] * B[k][j];
                        k++;
                    }

                    C[i][j] = c;
                    c = 0;
                    k = 0;
                }
            }

            System.out.println("Matriz C[" + m1 + "][" + n2 + "]:"); //Impressão
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println("");
            }
            // } Matriz C

        }
    }

}
