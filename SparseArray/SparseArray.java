package eric.meng.SparseArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建原始11*11的二维数组
        //0:表示没旗子，1： 黑子， 2： 蓝子

        int chessArr1 [][] = new int [11] [11];
        chessArr1 [1] [2] =1;
        chessArr1 [2] [3] =2 ;
        chessArr1 [2] [4] =2 ;
//        for (int i = 0; i < 11; i++) {
//            System.out.println(Arrays.toString(chessArr1[i]));
//
//        }
// 打印二维数组
        for (int[] row : chessArr1) {
            for (int data:row ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
/*将二维数组转化为稀疏数组
* 1.遍历得到非零个数
* */
    int sum =0 ;
        for (int i = 0; i < chessArr1.length ; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] !=0) {
                    sum++;
                }

            }

        }
        System.out.println(sum);

//        将数组写入文件中
        File file = new File("d:\\CS\\DataStructures\\array.txt");
        FileWriter out = new FileWriter(file);
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                out.write(chessArr1[i][j]+"\t");
            }
            out.write("\r\n");
        }
        out.close();



//2.创建稀疏数组
        int sparseArr[][] = new int [sum+1] [3];
//3.给稀疏数组赋值
        // 3.1 第一行初始化
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //3.2遍历二维数组，非零的存放进来
        int count =0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0) {
                    count ++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }

            }

        }
        //输出稀疏数组
        System.out.println("");
        for (int[] row : sparseArr) {
            for (int data:row ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //稀疏数组 -----》 恢复成原始二维数组
        /*
        * 1.先将二维数组第一行读出来，创建行和列
        * 2. 读取稀疏数组数据，付给二位数字
        * */

        int chessArray2[][]= new int[sparseArr[0][0]][sparseArr[0][1]];
        int count1 =0;
        for (int i = 1; i < sparseArr.length; i++) {
//            count1++
            chessArray2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //输出还原数组
        System.out.println("还原数组");
        for (int[] row : chessArray2) {
            for (int data:row ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
