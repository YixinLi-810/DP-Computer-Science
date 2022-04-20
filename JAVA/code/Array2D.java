/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-04-11 08:35:48
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-04-11 08:43:07
 */
public class Array2D {
    public static void main(String[] args) {
        int[][] name_loc = {
            {10,11,12,13,10},
            {10,13,14,12,12},
            {13,13,14,15,12},
            {16,17,17,17,16},
        };
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(name_loc[i][j]+" ");
            } 
            System.out.println();
        }
        // new Array
    }
}
