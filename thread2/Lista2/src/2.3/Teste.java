public class Teste {
    public static void main(String[] args) {
        final Deposito dep = new Deposito();
         Produtor p = new Produtor( dep, 1);
         Consumidor c = new Consumidor( dep, 2);
         Thread h = new Thread(p);
         h.start();
         Thread h1 = new Thread(c);
         h1.start();
         try {
           h.join();
           h1.join();
         } catch (InterruptedException e){
             }
         System.out.println("Execução do main da classe Deposito terminada!");
 
     }
}
