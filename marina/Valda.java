package marina;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

import static marina.MatrixUtil.readMatrix;

public class Valda extends Method {
    @Override
    public void run(Scanner input) {
        System.out.println("Метод Вальда");

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
        int[] q = v1 ? MatrixUtil.indicesOfMaxInColumns(a) : MatrixUtil.indicesOfMinInColumns(a);
        double[] v = new double[m];
        for (int i = 0; i < m; i++) {
            v[i] = a[q[i]][i];
        }
        int columnInd = v1 ? MatrixUtil.indexOfMin(v) : MatrixUtil.indexOfMax(v);
        int rowInd = q[columnInd];

        System.out.println("Матрица игры:");
        MatrixUtil.print(a);
        System.out.println("по критерию Вальда выбираем стратегию № " + (rowInd + 1));
        System.out.println("минимаксное значение: " + a[rowInd][columnInd]);
    }

    public static void main(String[] args) {
        String data = test2();

        InputStream is = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        Scanner input = new Scanner(is).useLocale(Locale.US);

        new Valda().run(input);
    }

    //2, 8
    public static String test2() {
        String data = "2\n";
        data += "4 3\n";

        data += "5 10 18\n";
        data += "8 7 8\n";
        data += "21 18 12\n";
        data += "30 22 19\n";
        return data;
    }

    //2, 10000
    public static String test1() {
        String data = "1\n";
        data += "2 2\n";

        data += "10100 100\n";
        data += "10000 10000\n";
        return data;
    }
}
