package exercicio2;

import static java.lang.Thread.sleep;

public class Consumidor implements Runnable {
    public  final Deposito dep;
    public int seg;

    public Consumidor(final Deposito d, int s) {
        this.dep = d;
        this.seg = s;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            synchronized (this) {
                if (this.dep.items == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else d.retirar() ;
                notify();
                try {
                    sleep(seg * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}