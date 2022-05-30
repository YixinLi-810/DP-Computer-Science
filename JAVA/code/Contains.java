/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-05-30 08:23:52
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-05-30 08:26:23
 */
public class Contains {
    public static boolean isIn(int x, int[] COL) {
        for(int i = 0; i < COL.length; i++){
            if(x == COL[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] BASKETBALL = {10011, 11876, 10122} ;
        int[] TENNIS = {10011, 11876, 10002} ;
        int[] FOOTBALL = {10011, 10002, 22103, 32000};

        System.out.println( isIn(11876, BASKETBALL)); // returns True
        System.out.println( isIn(11876, FOOTBALL)); //  returns False
    }
}
