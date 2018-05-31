package marina;

import java.util.Scanner;

/**
 * Created by marina on 05.10.17.
 */
public class HodgaLorena {
    static void hodgalorena(double a[][],double q[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert degree of pessimism for criterion HodgaLorena: ");
        double v = input.nextDouble();

        int h = a.length;
        int l = a[0].length;
        double vald[]=new double[l];
        for (int i = 0; i < h; i++) {
            q[i]= q[i] * v;
        }
        double laplas[]= MatrixUtil.mulMatVec(a,q);
        int ind[]= MatrixUtil.indicesOfMinInColumns(a);
        for (int j = 0; j <l; j++) {
             vald[j] = a[ind[j]][j]*(1-v);
        }
       double leman[] = MatrixUtil.summVect(vald,laplas);
        MatrixUtil.indexOfMax(leman);
    }
}
