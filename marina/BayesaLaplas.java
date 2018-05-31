package marina;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

import static marina.MatrixUtil.readMatrix;

public class BayesaLaplas extends Method {
    @Override
    public void run(Scanner input) {
        System.out.println("Метод Байеса-Лапласа");
        System.out.println("Введите матрицу выигрышей: ");
        double[][] a = readMatrix(input);
        int n = a.length;
        int m = a[0].length;

        double q[] = new double[m];
        System.out.println("Введите вектор вероятностей:");
        for (int i = 0; i < m; i++) {
            q[i] = input.nextDouble();
        }

        double[] mean = MatrixUtil.mulMatVec(a, q);
        int maxIndex = MatrixUtil.indexOfMax(mean);
        double max = mean[maxIndex];

        System.out.println("Матрица игры:");
        MatrixUtil.print(a);
        System.out.println("Вектор вероятностей:");
        MatrixUtil.print(q);

        System.out.println("По Байесу-Лапласу выбираем стратегию № " + (maxIndex + 1));
        System.out.println("максимальное мат.ожидание: " + max);
    }

    public static void main(String[] args) {
        String data = "2 6\n";
        data += "2 1 0 2 1 0\n";
        data += "1 1 1 0 0 0\n";
        data += "0.14583333333 0.4375 0.29166666666 0.02083333333 0.0625 0.04166666666\n";

        InputStream is = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        Scanner input = new Scanner(is).useLocale(Locale.US);

        new BayesaLaplas().run(input);
    }
}





