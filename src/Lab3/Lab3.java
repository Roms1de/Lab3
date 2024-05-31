package Lab3;

public class Lab3 {
    static void matrixChainOrder(int p[]) {
        int n = p.length - 1;
        int m[][] = new int[n + 1][n + 1];
        int s[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Минимальное кол-во умножений " + m[1][n]);
        System.out.print("Оптимальная расстановка скобок: ");
        printOptimalParenthesis(s, 1, n);
    }

    static void printOptimalParenthesis(int s[][], int i, int j) {
        if (i == j)
            System.out.print("A" + i);
        else {
            System.out.print("(");
            printOptimalParenthesis(s, i, s[i][j]);
            printOptimalParenthesis(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 10, 3, 5, 50, 6};
        matrixChainOrder(arr);
    }
}
