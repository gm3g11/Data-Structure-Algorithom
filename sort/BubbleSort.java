package sort;

import java.util.Arrays;

/**
 * @param
 * @return
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3,9,-1,10,20};
        System.out.println("冒泡排序前的数组："+ Arrays.toString(array));
        bubbleSort(array);
        System.out.println("冒泡排序后的数组："+ Arrays.toString(array));


    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }

                
            }
            
        }

    }
}
