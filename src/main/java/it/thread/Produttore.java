package it.thread;

public class Produttore extends Thread {
    private Risorsa r;
    private boolean running;

    Produttore(Risorsa r, String name) {
        super(name);
        this.r = r;
        running = true;
    }

    public void arresta() {
        this.running = false;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        try {
            while (running) {
                this.r.getSemProd().acquire();
                int val = (int) (Math.random() * 100 + 1);
                System.out.println(name + " produce:  " + val);
                r.produci(val);
                this.r.getSemCons().release();
            }
            System.out.println("Fine thread " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
