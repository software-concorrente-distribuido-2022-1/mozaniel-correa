public class TestContador {
    public static void main(String[] args) throws Exception {
       Contador contador = new Contador();
        contador.start();
    
        Contador2 contador2 = new Contador2();
        Thread thread1 = new Thread(contador2);
        Thread thread2 = new Thread(contador2);
        System.out.println("\nInicia segunda etapa");
        thread1.start();
        thread2.start();
    }
}
