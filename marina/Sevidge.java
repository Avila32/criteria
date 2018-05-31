package marina;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

import static marina.MatrixUtil.readMatrix;

public class Sevidge extends Method {
    @Override
    public void run(Scanner input) {
        System.out.println("Метод Сэвиджа");
        System.out.println("Выберите матрицу потерь или выигрыша");
        System.out.println("1 - Матрица потерь");
        System.out.println("2 - Матрица выигрыша");
        int idx = input.nextInt();
        while (idx != 1 && idx != 2) {
            System.out.println("Выберите матрицу потерь или выигрыша (число от 1 до 2)");
            idx = input.nextInt();
        }
        boolean v1 = idx == 1;

        System.out.println("Введите матрицу " + (v1 ? "потерь: " : "выигрыша: "));
        double[][] a = readMatrix(input);

        int n = a.length;
        int m = a[0].length;
        double[][] matrixRisk = new double[n][m];
        int[] q = v1 ? MatrixUtil.indicesOfMinInColumns(a) : MatrixUtil.indicesOfMaxInColumns(a);

        if (v1) {
            for (int j = 0; j < m; j++) {
                double minInColumn = a[q[j]][j];
                for (int i = 0; i < n; i++) {
                    matrixRisk[i][j] = a[i][j] - minInColumn;
                }
            }
        } else {
            for (int j = 0; j < m; j++) {
                double maxInColumn = a[q[j]][j];
                for (int i = 0; i < n; i++) {
                    matrixRisk[i][j] = maxInColumn - a[i][j];
                }
            }
        }

        int[] r = MatrixUtil.indicesOfMaxInRows(matrixRisk);
        double[] values = new double[r.length];
        for (int i = 0; i < r.length; i++) {
            values[i] = matrixRisk[i][r[i]];
        }

        int minInd = MatrixUtil.indexOfMin(values);

        System.out.println("Матрица сожалений:");
        MatrixUtil.print(matrixRisk);

        System.out.println("По Севиджу выбираем стратегию № " + (minInd + 1));
        System.out.println("Сожаления: " + values[minInd]);
    }

    public static void main(String[] args) {
        String data = test1();

        InputStream is = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        Scanner input = new Scanner(is).useLocale(Locale.US);

        new Sevidge().run(input);
    }

    public static String test1() {
        String data = "1\n";
        data += "4 4\n";
        data += "5 10 18 25\n";
        data += "8 7 8 23\n";
        data += "21 18 12 21\n";
        data += "30 22 19 15\n";
        return data;
    }

    //1, 2
    public static String test2() {
        String data = "2\n";
        data += "3 4\n";
        data += "2 7 8 6\n";
        data += "2 8 7 3\n";
        data += "4 3 4 2\n";
        return data;
    }
}
