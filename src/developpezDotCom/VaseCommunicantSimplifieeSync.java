/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developpezDotCom;

import java.util.Random;

/**
 *
 * @author Damien
 */
public class VaseCommunicantSimplifieeSync {

    private static final int QUANTITE_INITIALE = 200;
    private static final int NB_thread_MAX = 1000;

    private int[] vase = {QUANTITE_INITIALE / 2, QUANTITE_INITIALE / 2};

    public VaseCommunicantSimplifieeSync() {
        for (int i = 0; i < NB_thread_MAX; i++) {
            new ThreadTransfert().start();
        }
    }

    public class ThreadTransfert extends Thread {

        Random r = new Random();
        int quantite;

        public void run() {
            quantite = r.nextInt(11) - 6;
            if (transfertSync(quantite) != QUANTITE_INITIALE) {
                System.err.println("Quantité totale invalide"/* à l'itération " + iteration*/);
                System.exit(-1);
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized int transfertSync(int qte) {
        // Ne pas enlever les System.out de ce test !
        System.out.print("-(" + qte + ") dans le vase 1 ");
        vase[0] -= qte;
        System.out.println("+(" + qte + ") dans le vase 2");
        vase[1] += qte;
        return vase[0] + vase[1];
    }

    public static void main(String[] args) {
        new VaseCommunicant();
    }
}
