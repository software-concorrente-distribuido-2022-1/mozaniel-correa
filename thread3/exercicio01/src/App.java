public class App {
    public static void main(String[] args) throws Exception {
        Primo primo = new Primo();
        Primo2 primo2 = new Primo2();
        primo.calculaPrimo();
        try{
            primo.join();
        }catch(RuntimeException error){

        }
        primo2.calculaPrimo();
        try{
            primo2.join();
        }catch(RuntimeException error){

        }
        //Demorou mais de 1 hora para ambos
    }
}
