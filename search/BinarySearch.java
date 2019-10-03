package eric.meng.search;

/**
 * @param
 * @return
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,2313,5431,122222};
        int index=binarySearch(arr,0,arr.length-1,8);
        System.out.println(index);

    }

    public static int binarySearch(int[]arr,int left, int right,int searchValue){
        int mid =left+(right-left)/2;
        if(left>right){
            return -1;
        }
        if (arr[mid]>searchValue){
            return binarySearch(arr,left,mid-1,searchValue);
        } else if (arr[mid]<searchValue){
            return binarySearch(arr,mid+1,right,searchValue);
        } else {
            return mid;
        }
    }
}
