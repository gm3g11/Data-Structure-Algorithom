package eric.meng.linkedlist;

/**
 * @param
 * @return
 **/
public class Josephu {
    public static void main(String[] args) {
        //构建环形链表和遍历
        CircleSingleLinkedList circleSingleLinkedList= new CircleSingleLinkedList() ;
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(1,2,5);

    }






    //创建一个Boy类，表示一个节点
    static class Boy {
        private int no;
        private Boy next;
        public Boy (int no){
            this.no=no;
        }

        public int getNo() {
            return no;
        }

        public void setNext(Boy next) {
            this.next = next;
        }

        public Boy getNext() {
            return next;
        }

        public void setNo(int no) {
            this.no = no;


        }
    }

    //创建一个环形单向链表
    static class CircleSingleLinkedList {
        //创建一个first 节点，当前没有编号
        private Boy first= null;
        //添加小孩节点，构建一个环形的链表
        public void addBoy (int nums){
            //做一个校验
            if (nums <1) {
                System.out.println("nums的值不正确");
                return;
            }
            Boy curBoy=null;//辅助变量
            for (int i = 1; i <= nums; i++) {
                Boy boy = new Boy(i);
                //如果是第一个小孩
                if (i==1) {
                    first=boy;
                    first.setNext(first); //构成环
                    curBoy=first;
                } else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy=boy;

                }

            }

        }
        /**
         *@Author EricM
         *@Description //Todo
         *@Date 20:37 2019/9/10
         *@Param [startNo:表示从第几个小孩开始, countNum：数几下, nums：最初有多少个小孩]
         *@return void
        **/
        public void countBoy(int startNo, int countNum, int nums) {
            if(first==null || startNo<1 || startNo > nums){
                System.out.println("参数有误，请重新输入");
                return;
            }
            Boy helper=first;
            //需要创建一个辅助指针（变量），事先指向环形链表的最后节点
            while(true){
                if (helper.getNext()==first){
                    break;
                }
                helper= helper.getNext();
            }

            for (int j = 0; j < startNo-1; j++) {
                first= first.getNext();
                helper=helper.getNext();
            }

            while(true) {
                if (helper==first) {
                    break;
                }
                for (int i = 0; i < countNum -1; i++) {
                    first=first.getNext();
                    helper=helper.getNext();
                    
                }
                System.out.printf("小孩%d出圈\n", first.getNo());
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("最后留在圈中小孩编号%d \n", helper.getNo());

        }



        //遍历环形链表
        public void showBoy(){
            if (first == null){
                System.out.println("没有任何小孩");
                return;
            }
            Boy curBoy=first;
            while (true){
                System.out.printf("小孩的编号%d \n",curBoy.getNo());
                if(curBoy.getNext()==first) {
                    break;
                }
                curBoy=curBoy.getNext();
            }
        }

    }



}
