import java.util.Arrays;

/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-04-11 16:47:39
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-04-11 16:56:28
 */
public class Bubble {
    public static void swap(int[] ns, int leftIndex, int rightIndex) {
        int copy = ns[leftIndex];
        ns[leftIndex] = ns[rightIndex];
        ns[rightIndex] = copy;
    }
    public static void main(String[] args) {
        int[] ns = {1, 2, 4, 8};
        int count = 0;
        for (int i = 0; i < ns.length-1; i++) {
            boolean flag = true;
            for(int j = 0; j < ns.length-1-i; j++){
                if(ns[j]>ns[j+1]){
                    flag=false;
                    swap(ns, j, j+1);
                }
            }
            count ++;
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(ns));
        System.out.println(count);
    }
}