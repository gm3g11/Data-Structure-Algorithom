package eric.meng.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @param
 * @return
 **/
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr= {101,34,199,1,-1,89};
//        System.out.println("插入排序前的数组："+ Arrays.toString(arr));
//        insertSort(arr);
//        System.out.println("插入排序后的数组："+ Arrays.toString(arr));

        //创建一个8000个的随机数组
        int[] arr= new int[8000];
        for (int i = 0; i <8000 ; i++) {
            arr[i]=(int) (Math.random()*80000000);
        }
        //排序前的时间
        //System.out.println("排序前");
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);
        insertSort(arr);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);



    }

    public static void insertSort(int[] arr) {
        int insertVal=0;
        int insertIndex=0;
        for (int i = 1; i <arr.length ; i++) {
            insertVal=arr[i];
            insertIndex=i-1;

            //说明
            //1.insertIndex >=0 保证在给insertVal 找插入位置时，不越界
            //2.insertVal < arr[insertIndex] 待插入的数，没有找到插入位置
            //3.需要将 arr[insertIndex]后移

            while (insertIndex>=0 && insertVal<arr[insertIndex]) {
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
        }

    }
}
