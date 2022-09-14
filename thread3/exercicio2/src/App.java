public class App {
    public static void main(String[] args) throws Exception {
        Parallel teste = new Parallel();
        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
       int result = teste.parallelSearch(2,intArray, 2);
       System.out.println(result);
    }
}
