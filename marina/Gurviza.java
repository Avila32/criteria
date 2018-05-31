package marina;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

import static marina.MatrixUtil.readMatrix;

public class Gurviza extends Method {
    @Override
    public void run(Scanner input) {
        System.out.println("Метод гурвица");
        System.out.println("Введите матрицу выигрышей: ");
        double[][] a = readMatrix(input);

        System.out.println("Введите критерий пессимизма (0 < lamda < 1): ");
        double lambda = input.nextDouble();

        int n = a.length;
        int m = a[0].length;
        int max[] = MatrixUtil.indicesOfMaxInRows(a);
        int min[] = MatrixUtil.indicesOfMinInRows(a);

        double res[] = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = lambda * a[i][min[i]] + (1 - lambda) * a[i][max[i]];
        }
        int ind = MatrixUtil.indexOfMin(res);

        System.out.println("Матрица игры:");
        MatrixUtil.print(a);
        System.out.println("Lambda: " + lambda);
        System.out.println("По Гурвицу выбираем стратегию № " + (ind + 1));
        System.out.println("минимаксное значение: " + res[ind]);
    }

    public static void main(String[] args) {
        String data = test1();

        InputStream is = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        Scanner input = new Scanner(is).useLocale(Locale.US);

        new Gurviza().run(input);
    }

    public static String test1() {
        String data = "4 4\n";
        data += "5 10 18 25\n";
        data += "8 7 8 23\n";
        data += "21 18 12 21\n";
        data += "30 22 19 15\n";
        data += "0.5\n";
        return data;
    }
}

