/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-03-23 16:51:27
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-03-23 17:39:33
 */
public class Goldbach {
    public static boolean isPrime(int n) {
        int divider = 2;
        while (divider < Math.sqrt(n)) {
            if (n % divider == 0) {
                return false;
            }
            divider++;
        }
        return true;
    }

    public static void findPair(int num) {
        int num1 = num/2;
        while(num1 >= 2){
            if (isPrime(num1))
                if(isPrime(num-num1)) {
                    System.out.println(num + "=" + num1 + "+" + (num-num1));
                    break;
			    }
            num1 -= 1;
        }
    }

    public static void goldbachInRange(int from_n, int to_n) {
        // from to loop
        for (int i = from_n; i < to_n; i+=2) {
            findPair(i); 
        }
    }

    public static void main(String[] args) {
        goldbachInRange(2, 1000);
    }
}
