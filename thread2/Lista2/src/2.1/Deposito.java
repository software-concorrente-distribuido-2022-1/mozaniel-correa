public class Deposito {
  public int items = 0;
  private final int capacidade = 10;

  public int retirar() {
    if (items > 0) {
      items--;
      System.out.println("Caixa retirada: Sobram " + items + " caixas");
      return 1;
    }
    return 0;
  }

  public int colocar () {
    if (items<capacidade) {
      items++;
      System.out.println("Caixa armazenada: Passaram a ser "+items+" caixas");
      return 1; 
    }
      return 0;
  }

  public static void main(String[] args) {
    Deposito dep = new Deposito();
    Produtor p = new Produtor(dep, 2);
    Consumidor c = new Consumidor(dep, 1);
    Thread t1 = new Thread(p);
    Thread t2 = new Thread(c);
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Execução do main da classe Deposito terminada!");
  }
}
