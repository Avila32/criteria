package marina;

public class Taxes {
    public static void main(String[] args) {
        double ik = 1000;
        double ik_hat = 100;
        double rk = 900;
        double t = 0.13;
        double pi = 0.2;
        double pi2 = 0.4;
        double a = 100;
        double p_wave = 0.1;
        double pk = (ik_hat - rk) / ik_hat;
        pk = saturate(pk);

        double c2 = pi2*(ik - rk);
        double c1 = ik - c2 - t*rk;
        double bk = Math.min((1 - p_wave) * c2 / 2, a);
        double p_hat = (1 / a) * bk;
//        p_hat = 0;
        p_hat = saturate(p_hat);

//        System.out.println("p hat = " + p_hat);

        double E1 = ik - t*ik;
        double E2 = (1 - pk) * (ik - t*rk);
        double E3 = ik - pi * (ik - rk) - t*rk;
        double e1 = c1 + p_hat*((1 - p_wave)*c2 - bk);
        boolean giveBribe = e1 > E3;
        double e2 = pk * Math.max(e1, E3);
        double e = Math.max(E1, E2 + e2);
        boolean beNicePerson = E1 > e2 + E2;

//        System.out.println("w2 = " + e2 / pk);
//        System.out.println("W2 = " + E2 / (1 - pk));
//        System.out.println("pk = " + pk);

        System.out.println("Прибыль в случае декларирования всего дохода: " + E1);
        System.out.println("Матожидание выигрыша: " + e);
        System.out.println("Оптимальная стратегия:");
        if (beNicePerson) {
            System.out.println("Задекларировать все свои доходы");
        } else {
            System.out.println("Задекларировать часть доходов");
            if (giveBribe) {
                System.out.println("В случае проверки дать взятку в размере " + bk + " рублей");
            } else {
                System.out.println("В случае проверки не давать взятки и заплатить штраф");
            }
        }
    }

    public static double clamp(double x, double l, double r) {
        if (x < l) return l;
        if (x > r) return r;
        return x;
    }

    public static double saturate(double x) {
        return clamp(x, 0, 1);
    }
}
