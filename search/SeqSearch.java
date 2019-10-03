package eric.meng.search;

/**
 * @param
 * @return
 **/
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,-9,2,3,-11,-1,34,89};
        int index = seqSearch(arr,-11);
        if (index==-1){
            System.out.println("没有找到");
        } else {
            System.out.println("找到下标为："+ index);
        }

    }
    public static int seqSearch(int[]arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value){
                return i;
            }

        }
        return -1;
    }
}
