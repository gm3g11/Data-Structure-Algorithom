package sort;

import java.util.Arrays;

/**
 * @param
 * @return
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr= {101, 34, 119, 1, -1, 90, 123};
        System.out.println("选择排序前的数组："+ Arrays.toString(arr));
        selectSort(arr);
        System.out.println("选择排序后的数组："+ Arrays.toString(arr));
        

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[i]>arr[j]){
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;

                }
                
            }
            
        }
    }
    
}
