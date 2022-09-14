public class Consumidor extends Thread {
  private Deposito d;
  private int n;

  Consumidor(Deposito d, int n) {
    this.d = d;
    this.n = n;
  }

  @Override
  public void run() {
    for (int i = 0; i < n; i++) {
      this.d.retirar();
    }
  }
}
