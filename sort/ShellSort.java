package eric.meng.sort;

import java.util.Arrays;

/**
 * @param
 * @return
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 4, 6, 0, 5};
        System.out.println("希尔排序前的数组："+Arrays.toString(arr));
        shellSort(arr);
        System.out.println("希尔排序后的数组："+Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                int index=i;
                int indexValue=arr[index];
         //       if(arr[index]<arr[index-gap]){
                while (index - gap >= 0 && indexValue < arr[index - gap]) {
                    arr[index] = arr[index - gap];
                    index -= gap;
                    }

               // }
                arr[index]=indexValue;

            }
            
        }

        
    }
}
