public class Produtor implements Runnable {
  private int n;
  private final Deposito d;

  Produtor(final Deposito d, int n) {
    this.d = d;
    this.n = n;
  }

  @Override
  public void run() {
    for (int i = 0; i < n; i++) {
      this.d.colocar();
    }
  }
}
