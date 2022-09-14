package exercicio2;

public class Deposito {
    public static Object d;
    public  int items = 0;
    public static final int capacidade=10;
    public void Deposito(){
    }
    public synchronized int retirar() {
        if (this.items>0) {
            items--;
            System.out.println("Caixa retirada: Sobram " + items + " caixas");
            return 1; }
        return 0;
    }
    public  synchronized int colocar() {
        if (this.items<capacidade) {
            this.items++;
            System.out.println("Caixa armazenada: Passaram a ser " + items + " caixas");
            return 1; 
        }
        return 0;
    }
   
}
