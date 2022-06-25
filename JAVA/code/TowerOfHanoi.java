import java.util.Stack;


public class TowerOfHanoi {
    static Stack<Integer> rodLeft = new Stack<>();
    static Stack<Integer> rodMid = new Stack<>();
    static Stack<Integer> rodRight = new Stack<>();

    public static void view() {
        System.out.println( "------show ------" );

        System.out.println( rodLeft + "\t|\t" + rodMid + "\t|\t" + rodRight);
    }

    public static void move(Stack<Integer> fromRod, Stack<Integer> toRod) {
        int disc = fromRod.pop();
        toRod.add(disc);
    }

    public static void moveDiscs(int n, Stack<Integer> fromRod, Stack<Integer> toRod, Stack<Integer> byPassRod) {
        if (n > 0) {
            // 1-3 move n - 1 to byPass
            // (n - 1),
             
            //     1
            // 3   2   0
            moveDiscs(n - 1, fromRod, byPassRod, toRod);


            // 2-3 move from start to finish
            //     1
            //     2   3
            view();
            move(fromRod, toRod);
 
            // 3-3 move n - 1 byPass to finish
            //         1
            //         2
            //         3
            moveDiscs(n - 1, byPassRod, toRod, fromRod);
        } 

    }

    public static void main(String[] args) {
        rodLeft.add(3);
        rodLeft.add(2);
        rodLeft.add(1);

        // view();
        // move(rodLeft, rodMid);
        // view();

        view();

        System.out.println( "\n\n    ---start moving --    " );

        moveDiscs(3, rodLeft, rodRight, rodMid);

        System.out.println( "\n\n    ---finish moving --    " );
        view();



    }
}
