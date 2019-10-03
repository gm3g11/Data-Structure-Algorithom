package eric.meng.search;

/**
 * @param
 * @return
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,2313,5431,122222};
        int index=insertValueSearch(arr,0,arr.length-1,8);
        System.out.println(index);

    }

    public static int insertValueSearch(int[]arr,int left, int right,int searchValue){
        int mid =left+(right-left)*(searchValue-arr[left])/(arr[right]-arr[left]);
        if(left>right){
            return -1;
        }
        if (arr[mid]>searchValue){
            return insertValueSearch(arr,left,mid-1,searchValue);
        } else if (arr[mid]<searchValue){
            return insertValueSearch(arr,mid+1,right,searchValue);
        } else {
            return mid;
        }
    }
}

