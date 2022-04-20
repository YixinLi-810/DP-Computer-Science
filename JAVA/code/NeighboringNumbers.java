/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-04-11 09:08:45
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-04-11 09:08:46
 */
public class NeighboringNumbers {
    public static void main(String[] args) {
        int[] ns = {33, 62, 21};
        for (int i = 0; i < ns.length - 1; i++ ) {
            System.out.println( ns[i] + ":" + ns[i + 1]);
        }
    }
}