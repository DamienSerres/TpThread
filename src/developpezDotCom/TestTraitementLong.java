/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developpezDotCom;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 *
 * @author Damien
 */
public class TestTraitementLong extends JFrame {

    JProgressBar jBar = new JProgressBar();
    GridLayout layout = new GridLayout(2, 1);
    JButton btnAction = new JButton("Lancer le traitement");

    public TestTraitementLong() {
        // Construction de la fenêtre de test
        Container contentPane = getContentPane();
        contentPane.setLayout(layout);
        contentPane.add(jBar);
        contentPane.add(btnAction);
        setTitle("Test de progressBar");

// Ajout du listener du bouton
//        btnAction.addActionListener(
//      new ActionListener() {
//        public void actionPerformed(ActionEvent e) {
//          // Instanciation et lancement du traitement
//          LongAction action = new LongAction();
//          action.traitementLong(jBar);
//        }
//      }
//    );
        btnAction.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // création d'un thread d'exécution
                Thread t = new Thread() {
                    public void run() {
                        // Instanciation et lancement du traitement
                        LongAction action = new LongAction();
                        action.traitementLong(jBar);
                    }
                };
                t.start();
            }
        }
        );

        // Affichage de la fenêtre
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new TestTraitementLong();
    }
}
