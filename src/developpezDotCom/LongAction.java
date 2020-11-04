/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developpezDotCom;

import javax.swing.JProgressBar;

/**
 *
 * @author Damien
 */
public class LongAction {

    public void traitementLong(JProgressBar pBar) {
        // initialisation de la progressBar au début du traitement
        pBar.setMinimum(0);
        pBar.setMaximum(99);
        pBar.setValue(0);

        // Traitement
        for (int i = 0; i < 100; i++) {
            System.out.print(".");
            pBar.setValue(i);
            try {
                // Pause pour simuler un traitement
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("");
    }
}
