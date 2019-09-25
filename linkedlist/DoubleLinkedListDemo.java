package eric.meng.linkedlist;

/**
 * @param
 * @return
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        HeroNode2 hero1= new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2= new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3= new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4= new HeroNode2(4,"林冲","豹子头");

        DoubleLinkedList doubleLinkedList= new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改测试
        System.out.println("修改测试");
        HeroNode2 newHeroNode= new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();

        //删除测试
        System.out.println("删除测试");
        doubleLinkedList.del(3);
        doubleLinkedList.list();


    }
    /**
     *@Author EricM
     *@Description //创建一个双向链表
     *@Date 15:48 2019/9/10
     *@Param 
     *@return 
    **/
    static class DoubleLinkedList {
        //    初始化头节点
        private HeroNode2 head = new HeroNode2(0,"","");
        //返回头结点
        public HeroNode2 getHead() {
            return head;
        }
        //1.显示链表
        public void list() {
            if (head.next==null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode2 temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp=temp.next;

            }
        }
        //2.第一种添加节点到双向链表的最后
        public void add (HeroNode2 heroNode) {
            HeroNode2 temp =head;
            while (true) {
                if (temp.next ==null ) {
                    break;
                }
                temp = temp.next;
            }
            //形成双向链表
            temp.next = heroNode;
            heroNode.pre=temp;
        }

        //3.修改一个节点
        public void update (HeroNode2 newHeroNode){
            if (head.next== null) {
                System.out.println("链表为空");
                return;
            }
            //找到需要修改的节点，根据No编号
            //定义一个辅助变量
            HeroNode2 temp = head.next;
            boolean flag =false;
            while(true) {
                if (temp == null) {
                    break;
                }
                if (temp.no==newHeroNode.no){
                    flag=true;
                    break;
                }
                temp =temp.next;
            }

            if (flag){
                temp.name=newHeroNode.name;
                temp.nickname=newHeroNode.nickname;
            } else {
                System.out.printf("没有找到%d 的节点，不能修改\n", newHeroNode.no);
            }

        }

        //4.删除一个节点
        //对于双向链表可以直接找到要删除节点，
        //找到后可以自我删除即可
        public void del (int no) {
            HeroNode2 tmp = head.next;
            boolean flag =false;

            if (head.next== null) {
                System.out.println("链表为空，无法删除");
                return;
            }

            while (true) {
                if (tmp==null){
                    break;
                }
                if (tmp.no==no){
                    flag=true;
                    break;
                }
                tmp=tmp.next;
            }
            if (flag) {
                tmp.pre.next=tmp.next;

                //这里有风险，因为有可能是最后一个节点，没有next节点
                if(tmp.next != null) {
                    tmp.next.pre = tmp.pre;
                }

            } else {
                System.out.printf("要删除的 %d 节点不存在\n", no );
            }
        }







    }
    
/**
 *@Author EricM
 *@Description //定义节点
 *@Date 16:04 2019/9/10
 *@Param 
 *@return 
**/
static class HeroNode2{
        public int no;
        public String name;
        public String nickname;
        public HeroNode2 next; //指向下一个节点,默认为null
        public HeroNode2 pre; //指向前一个节点，默认为null

        //构造器
        public HeroNode2(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }
//    为了显示方便，重写toString
        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
//                ", next=" + next +
                    '}';
        }
    }
    
}
