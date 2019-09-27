package eric.meng.Recursion;

/**
 * @param
 * @return
 **/
public class Queen_8 {
    //定义有多少个皇后
    int max=8;
    //定义数组array，保存皇后的位置，比如arr={0,4,7,5,2,6,1,3}
    //arr的下标代表行数，即第几个皇后，值代表列数
    int[] arr = new int[max];
    static int count=0;

    public static void main(String[] args) {

        Queen_8 queen = new Queen_8();
        queen.check(0);
        System.out.printf("一共有%d种解法\n",count);

    }


    //检测第n个棋子是否和之前的棋子冲突
    private boolean judge(int n) {
        //说明
        //array[i]==array[n]，说明在同一列
        //Math.abs(array[n]-array[i])==Math.abs(n-i)表示在同一斜线
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
    //打印位置
    private void printArr() {
        count++;
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //放置第n个棋子，也可以代表每一行
    private void check(int n ) {
        if (n==max) { //说明8个皇后都放好了
            printArr();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            arr[n]=i;
            if (judge(n)) {
                check(n+1);
            }
        }

    }
    


}
