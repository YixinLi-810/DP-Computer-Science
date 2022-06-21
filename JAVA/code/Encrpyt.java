import java.util.ArrayList;


public class Encrpyt {
    public static ArrayList<Integer> digits(int n) {
        ArrayList<Integer>ds = new ArrayList<>();

        while(n > 0) {
            ds.add(0, n % 10);
            n /= 10;
        }

        return ds;
    }

    public static void viewInt(ArrayList<Integer> ns) {
        int first = ns.get(0);
        if (first > 0) {
            System.out.print( first );
        }
        for (int i = 1; i < ns.size(); i++) {
            System.out.print( ns.get(i) );
        }
        System.out.print( "\n" );
    }

    public static void encrypt(ArrayList<Integer> ns) {

        // 0 1 2 3 4
        // 4 3 2 1 0

        // 0 1 2 3
        // 3 2 1 0

        for (int i = 0; i < ns.size() / 2; i++ ) {
            int left = ns.get(i);
            int right = ns.get(ns.size() - 1 - i);
            ns.set(i, (right + 5) % 10);
            ns.set(ns.size() - 1 - i, (left + 5) % 10);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer>ds = digits(5578955);
        System.out.println( ds );
        viewInt(ds);

        encrypt(ds);
        System.out.println( ds );
        viewInt(ds);

        encrypt(ds);
        System.out.println( ds );
        viewInt(ds);
        
    }
}
