package eric.meng.sort;

import java.util.Arrays;

/**
 * @param
 * @return
 **/
public class MergeSort {
    public static void main(String[] args) {
        int arr[]={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];
        System.out.println("归并排序前的数组："+ Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序后的数组："+Arrays.toString(arr));
    }
    /***
     *@Author EricM
     *@Description 合并数组
     *@Date 9:07 2019/10/2
     *@Param [arr 排序的原始数组, left左边的初始索引, mid 中间索引, right 右边索引, tmp 中转数组]
     *@return void
    **/

    public static void merge(int[] arr, int left, int mid, int right, int[] tmp) {

        int i = left; //初始化i, 左边有序序列的初始索引
        int j = mid +1; //初始化右边序列的初始索引
        int t=0; //初始，tmp的索引
        //1.左右两边进行比较
        while(i<=mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边的元素
            //即左边的填充到tmp中
            //然后i++,t++
            if(arr[i]<=arr[j]){
                tmp[t]=arr[i];
                i++;
                t++;
            } else {
                tmp[t]=arr[j];
                j++;
                t++;
            }
        }

        //2.如果一边还有剩余的，直接填充
        while(i<=mid) {
            tmp[t]=arr[i];
            i++;
            t++;

        }
        while(j<=right){
            tmp[t]=arr[j];
            j++;
            t++;
        }

        //3.将temp数组元素拷贝到arr
        //不是每次都拷
        t=0;
        int tempLeft=left;
        System.out.println("开始合并， "+ "最左面："+tempLeft+"最右面"+right);
        while (tempLeft <=right) {
            arr[tempLeft]=tmp[t];
            t++;
            tempLeft+=1;
        }

    }

    //分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right) {
            int mid=(left+right)/2;
            //System.out.println("分解左面");
            mergeSort(arr,left,mid,temp);
            //System.out.println("分解右面");
            mergeSort(arr,mid+1,right,temp);
            System.out.println("*****");
            //合并
            merge(arr,left,mid,right,temp);
        }
    }


}
