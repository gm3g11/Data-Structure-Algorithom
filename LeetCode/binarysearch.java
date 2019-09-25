package eric.meng.LeetCode;

/**
 * @param
 * @return
 **/
class Solution {
    public static void main(String[] args) {
        


    }


    static public int findDuplicate(int[] nums) {
        for (int i=0 ;i<=nums.length;i++){
            for (int k=i+1;k<=nums.length;k++){
                if (i==k) {
                    return i;
                }
            }
        }
        return -1;
    }

}


