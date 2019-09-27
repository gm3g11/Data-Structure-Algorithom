package eric.meng.Recursion;

/**
 * @param
 * @return
 **/
public class RecursionTest {
    public static void main(String[] args) {
        test(4);

        int res=factorial(4);
        System.out.println(res);
    }


    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    public static int factorial(int n) {
        if (n==1){
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }
}
