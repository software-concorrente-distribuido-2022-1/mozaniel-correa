public class Primo extends Thread {
    public void Primo(){
        
    }
    public void calculaPrimo(){
        for(int i = 1000000;i<=30000000;i++){
            Boolean verify = true;
            for(int h = 2;h<i;h++){
                int aux = i%h;
                if(aux == 0){
                    verify = false;
                }
            }
            if(verify == true){
                System.out.println(i);
            }
        }
    }

    @Override
    public void run(){
        calculaPrimo();
    }
    
    
} 