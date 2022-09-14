public class OneThread extends Thread {
    public int list[];
    public int start;
    public int finish;
    public int find;
    public int result;
    public OneThread(int[] a, int aux2, int i, int x) {
        this.list = a;
        this.start = aux2;
        this.finish = i;
        this.find = x;
    }
   
    public void find(){
        int found = -1;
        for(int i = start;i<finish;i++){
            if(this.list[i]== this.find){
                found = i;
            }
        }
        this.result = found;
    }

    @Override
    public void run(){
       find();
    }
}
