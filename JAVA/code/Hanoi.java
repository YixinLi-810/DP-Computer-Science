import java.util.*;
/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-06-26 07:32:45
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-06-26 07:35:37
 */
public class Hanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many discs do you want? ");
        int num = in.nextInt();
        hanoi(num, 'A', 'B', 'C');
    }
    public static void hanoi(int num, char a, char b, char c){
        if (num == 1) {
            System.out.println("Disc " + num + " : " + a + " -> " + c);
        }else{
            hanoi(num - 1, a, c, b);
            System.out.println("Disc " + num + " : " + a + " -> " + c);
            hanoi(num - 1, b, a, c);
        }
    }
}
