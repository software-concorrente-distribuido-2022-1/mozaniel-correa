public class Parallel{
    public void Parallel(){

    }
    public static int parallelSearch(int x, int[] A, int numThreads){
        int aux = A.length/numThreads;
        int aux2 = 0;
        int result = -1;
        OneThread[] threads = new  OneThread[numThreads];
        for(int i = 0;i<numThreads;i++){
            threads[i] = new OneThread(A,aux2,(aux2 + aux)-1,x);
            aux2 = aux2+aux;
        }
        for(int h = 0;h<numThreads;h++){
           threads[h].start();
        }
        for(int g = 0;g<numThreads;g++){
            try{
                threads[g].join();
            }catch(InterruptedException error){

            }
         }
         for(int j = 0;j<numThreads;j++){
            if(threads[j].result != -1){
                result = threads[j].result;
            }
         }
         return result;


    }
}