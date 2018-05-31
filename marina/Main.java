package marina;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Выберите характер неопределенности: ");
        System.out.println("1 - В условиях риска");
        System.out.println("2 - В условиях полной неопределенности");
        int idx = input.nextInt();
        while (idx != 1 && idx != 2) {
            System.out.println("Выберите характер неопределенности (число от 1 до 2)");
            idx = input.nextInt();
        }

        Method method;
        if (idx == 1) {
            method = new BayesaLaplas();
        } else {
            System.out.println("Выберите критерий принятия решения: ");
            System.out.println("1 - Вальда");
            System.out.println("2 - Сэвиджа");
            System.out.println("3 - Гурвица");
            while ((method = getMethod(input.nextInt())) == null) {
                System.out.println("Выберите критерий принятия решения (число от 1 до 3)");
            }
        }

        method.run(input);
    }

    public static Method getMethod(int idx) {
        switch (idx) {
            case 1:
                return new Valda();
            case 2:
                return new Sevidge();
            case 3:
                return new Gurviza();
        }
        return null;
    }
}
