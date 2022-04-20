/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-04-15 07:33:50
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-04-15 07:40:27
 */
import java.util.Arrays;

public class selectSort{
    
    public static void main(String[] args) {
        int arr[] = {101,34,119,1,34};
        selectSort(arr);
    }

    public static void selectSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i]  = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}