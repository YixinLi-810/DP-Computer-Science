public class Random {
    public static void main(String[] args) {
        int[] ns = new int[10];

        for (int i = 0; i < 10; i++){
            ns[i] = (int)(10 * Math.random());
        }

        for (int n: ns){
            System.out.print( n + " " );
        }
    }
}
