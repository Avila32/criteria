package marina;

import javafx.util.Pair;

import java.io.InputStream;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class MatrixUtil {
    public static double[][] readMatrix(Scanner input) {
        System.out.println("Введите размеры матрицы:");
        int n = input.nextInt();
        int m = input.nextInt();
        double array[][] = new double[n][m];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = input.nextDouble();
            }
        }
        return array;
    }

    static double[] mulMatVec(double a[][], double b[]) {
        int n = a.length;
        int m = a[0].length;
        double[] res = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i] += a[i][j] * b[j];
            }
        }
        return res;
    }

    static int indexOfMax(double a[]) {
        int n = a.length;
        double max = a[0];
        int ind = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
                ind = i;
            }
        }
        return ind;
    }

    static int indexOfMin(double a[]) {
        int n = a.length;
        double min = a[0];
        int ind = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                ind = i;
            }
        }
        return ind;
    }

    static int[] indicesOfMaxInColumns(double a[][]) {
        int n = a.length;
        int m = a[0].length;
        int[] res = new int[m];
        for (int j = 0; j < m; j++) {
            double max = a[0][j];
            int ind = 0;
            for (int i = 1; i < n; i++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    ind = i;
                }
            }
            res[j] = ind;
        }
        return res;
    }

    static int[] indicesOfMinInColumns(double a[][]) {
        int n = a.length;
        int m = a[0].length;
        int[] res = new int[m];
        for (int j = 0; j < m; j++) {
            double min = a[0][j];
            int ind = 0;
            for (int i = 1; i < n; i++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                    ind = i;
                }
            }
            res[j] = ind;
        }
        return res;
    }


    static int[] indicesOfMaxInRows(double a[][]) {
        int n = a.length;
        int m = a[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            double max = a[i][0];
            int ind = 0;
            for (int j = 1; j < m; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    ind = j;
                }
            }
            res[i] = ind;
        }
        return res;
    }

    static int[] indicesOfMinInRows(double a[][]) {
        int n = a.length;
        int m = a[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            double min = a[i][0];
            int ind = 0;
            for (int j = 1; j < m; j++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                    ind = j;
                }
            }
            res[i] = ind;
        }
        return res;
    }

    static void print(double[][] a) {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void print(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static double[] summVect(double[] a, double[] b) {
        int n = a.length;
        double c[] = new double[n];
        for (int i = 0; i < n; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }
}