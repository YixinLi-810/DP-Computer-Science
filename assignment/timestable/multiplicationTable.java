/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-04-11 08:14:41
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-04-11 08:25:57
 */

public class multiplicationTable {
    public static void makeOneRow(Integer n) {
        for(int col = 1; col < n+1; col++){
            System.out.print(col+"x"+ n+"="+col*n+" ");
        }
    }

    public static void main(String[] args){
        for(int i = 1; i < 10; i++){
            makeOneRow(i);
            System.out.println();
        }
    }
}
// def make_one_row(n):
//     for col in range(1, n + 1):
//         print(f'{col}x{n}={col*n}', end=' ')


// for i in range(9):
//     make_one_row(i)
//     print()