package eric.meng.Recursion;

/**
 * @param
 * @return
 **/
public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        //创建一个地图
        int[][] map = new int[8][7];

        //使用1表示墙
        //上下全部为墙
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右全部为墙
        for (int i = 0; i <8 ; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }

        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        map[2][2]=1;
        map[2][3]=1;
        //打印迷宫
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();

        }

        setWay(map,1,1);
        System.out.println("走完地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();

        }

    }

    //使用递归回溯给小球找路
    /*说明
    1. map表示地图
    2. i,j 表示从哪个地方出发
    3.如果小球能走到map[6][5],说明通路找到
    4.约定，map[i][j]的值
        a.为0时，表示还没走过
        b.为1时,表示墙
        c.为2时，表示可以走
        d.为3时，走了，但是走不通
    5.走迷宫的策略是，下->右->上->左，如果走不通，再回溯
    */
/***
 *@Author EricM
 *@Description //回溯递归找路
 *@Date 17:21 2019/9/27
 *@Param [map, i, j]，i和j是开始的位置，顺序是下右上左
 *@return boolean
**/
public static boolean setWay(int[][] map, int i, int j) {
    //如果终点map[6][5]为2，证明可以走通
    if (map[6][5] == 2) {
        return true;
    } else {
        //假定初始位置可以走通，为2
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay(map, i + 1, j)) {//向下走
                return true;
            } else if (setWay(map, i, j + 1)) { //向右走
                return true;
            } else if (setWay(map, i - 1, j)) { //向上走
                return true;
            } else if (setWay(map, i, j - 1)) { //向左走
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else { //map[i][j] !=0
            return false;
        }
    }
}




}
