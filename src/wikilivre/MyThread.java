/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikilivre;

/**
 *
 * @author Damien
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Un nouveau processus léger");
            Thread.sleep(1000); // suspendu pendant 1 seconde
            System.out.println("Fin du nouveau processus léger");
        } catch (InterruptedException ex) {
            System.out.println("Processus léger interrompu");
        }
    }
   
    public static void main(String[] args) {
        MyThread myth = new MyThread();
        System.err.println("Démarrer le processus léger ...");
        myth.start();
        System.err.println("Le processus léger est démarré.");
    }
}
