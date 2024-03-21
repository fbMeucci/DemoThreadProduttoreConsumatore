package it.thread;

public class App {
    public static void main(String[] args) {
        Risorsa r = new Risorsa();
        Produttore p = new Produttore(r, "PROD");
        Consumatore c = new Consumatore(r, "CONS");
        p.start();
        c.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.arresta();
        c.arresta();
    }
}
