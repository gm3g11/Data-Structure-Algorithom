package eric.meng.sort;

import java.util.Arrays;

/**
 * @param
 * @return
 **/
public class RadixSort {
    public static void main(String[] args) {
        int arr[]= {53,3,542,748,14,214};
        System.out.println("归并排序前的数组："+ Arrays.toString(arr));
        radixSort(arr);
        System.out.println("归并排序后的数组："+Arrays.toString(arr));
    }
    public static void radixSort(int[]arr) {
        //1.得到数组最大数的位数
        //1.a 得到最大的数
        int max = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //1.b 最大数的位数
        int maxLength = (max + "").length();
        //System.out.println(maxLength);

        //2.定义一个二维数组，代表10个桶，每个桶是一个数组
        //说明
        //a. 二维数组包含10个一维数组
        //b. 为了防止数据溢出，每个桶的大小为arr.length
        //c. 名确定，基数排序是空间换时间
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际放多少数据，定义一个一维数组
        //比如，bucketElementCounts[0]，记录的是bucket[0]桶的放入个数
        int[] bucketElementCounts = new int[10];

        //3.把数组放入桶中
        //使用循环代码处理
        //第一次循环需要处理的位数，个位，十位，百位。。。
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第二次循环，对数组中每个数进行处理，取出个位，十位，百位
            for (int j = 0; j < arr.length; j++) {
                int digitElement = arr[j] / n % 10;
                bucket[digitElement][bucketElementCounts[digitElement]] = arr[j];
                bucketElementCounts[digitElement]++;


            }


            //4.按照桶的顺序取出
            int index = 0;
//        System.out.println(Arrays.toString(bucket[0]));
//        System.out.println(Arrays.toString(bucket[1]));
//        System.out.println(Arrays.toString(bucket[2]));
//        System.out.println(Arrays.toString(bucket[3]));
//        System.out.println(Arrays.toString(bucket[4]));
//        System.out.println(Arrays.toString(bucket[5]));
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                        //System.out.println(index);
                    }

                }
                bucketElementCounts[k] = 0;

            }
        }
    }
}




