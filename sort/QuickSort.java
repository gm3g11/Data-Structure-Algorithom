package eric.meng.sort;

import java.util.Arrays;

/**
 * @param
 * @return
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr ={-9,78,23,-567,0,70,-1,900,4561};
//        int[] arr ={-9,78,0,23,-456,70};
        System.out.println("快速排序前的数组："+ Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("快速排序后的数组："+Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right) {
        int l =left; //左下标
        int r =right; //右下标
        int pivot= arr[(left+right)/2]; //中轴值
        int temp=0; //临时变量，交换用

        //while循环的目的，是比pivot的值小的放左面，大的放右面
        while(l<r) {
            //在pivot的左边找，找到大于等于pivot的值时候，退出
            while(arr[l]<pivot){
                l+=1;
            }
            //在pivot的右边找，找到小于等于pivot的值时候，退出
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l>=r，说明pivot的左右两边的值，已经按照左边小于pivot，
            //右边大于pivot排好了
            if(l>=r) {
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;


            if(arr[l]==pivot){
                r-=1;
            }
            if (arr[r]==pivot){
                l+=1;
            }

        }


        if (l==r){
            l+=1;
            r-=1;
        }

        if(left<r) {
            quickSort(arr,left,r);
        }

        if(right>l) {
            quickSort(arr,l,right);
        }



    }
}
