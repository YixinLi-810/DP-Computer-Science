/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-05-12 14:54:41
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-05-12 15:08:32
 */

public class reverse{
public static void main(String[] args){
        int n = 1230;
        int s = 0;
        while(n != 0){
            s = s * 10 + n % 10;
            n /= 10;
        } 
        System.out.print(s);
    }
}