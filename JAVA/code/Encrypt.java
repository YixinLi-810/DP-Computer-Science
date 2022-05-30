/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-05-30 17:02:03
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-05-30 17:05:21
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Encrypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println( "input a 4 digits number" );
        int n = in.nextInt();
        int unit = n % 10000 / 1000;
        int tens = 0;
        int huns = 0;
        int thus = 0;
        System.out.println( unit );
        System.out.println( tens );
        System.out.println( huns );
        System.out.println( thus );
        ArrayList<Integer> digits = new ArrayList<>();
        // Todo:
        while (n > 0) {
            int digit = n % 10;
            digits.add(0, digit);
            n /= 10;
        }
    }
}