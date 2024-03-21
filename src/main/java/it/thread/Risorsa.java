package it.thread;

import java.util.concurrent.Semaphore;

public class Risorsa {
    private int val;
    private Semaphore semProduttore, semConsumatore;

    Risorsa() {
        this.semConsumatore = new Semaphore(0);
        this.semProduttore = new Semaphore(1);
    }

    public void produci(int val) {
        this.val = val;
    }

    public int consuma() {
        return this.val;
    }

    public Semaphore getSemProd() {
        return this.semProduttore;
    }

    public Semaphore getSemCons() {
        return this.semConsumatore;
    }
}
