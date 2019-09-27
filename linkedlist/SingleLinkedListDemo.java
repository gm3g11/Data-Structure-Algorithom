package eric.meng.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"松江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"无用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);


        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();
        //修改测试
        System.out.println("====修改后的链表状况====");

        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~");
        singleLinkedList.update(newHeroNode);
//        修改后的链表状况
        singleLinkedList.list();

        //删除节点

//        singleLinkedList.del(1);
//        System.out.println("====删除后的链表状况====");
//        singleLinkedList.del(1);
//        singleLinkedList.del(4);
//        singleLinkedList.list();
//        System.out.println(getLength(singleLinkedList.getHead()));

        //测试是否得到倒数第k个节点
        HeroNode res = findIndexNode(singleLinkedList.getHead(),1);
        System.out.println("res="+ res);

        //反转链表
        System.out.println("====原先链表===");
        singleLinkedList.list();
//        System.out.println("====反转链表===");
//        reverseList (singleLinkedList.getHead());
//        singleLinkedList.list();

        System.out.println("===逆序打印==");
        reversePrint(singleLinkedList.getHead());

    }

    //方法，获取单链表个数（如果带头结点的链表，需要不统计头结点）
/**
 *@Author EricM
 *@Description //Todo
 *@Date 15:33 2019/9/9
 *@Param head 链表的头部
 *@return 返回的就是有效节点的个数
**/

public static int getLength (HeroNode head){
    if (head.next==null) {
        return 0;
    }
    int length =0;
    HeroNode cur = head.next;
    while (cur != null){
        length++;
        cur=cur.next;
    }
    return length;
}

//逆序打印链表
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

/**
 *@Author EricM
 *@Description //Todo 
 *@Date 16:22 2019/9/9
 *@Param [head, index]
 *@return eric.meng.linkedlist.HeroNode
**/
//查找单链表的倒数第k个节点
public static HeroNode findIndexNode (HeroNode head, int index) {
    if (head.next==null) {
        return null;
    }
    int size =getLength(head);
    //index校验
    if (index <=0 || index >size){    return null;}
    HeroNode cur = head.next;

    for (int i=0;i<=size - index;i++){
        cur=cur.next;
    }
    return cur;


}
//将单链表反转
public static void reverseList (HeroNode head) {
//如果空链表，或者只有一个节点，无需翻转
    if (head.next==null || head.next.next==null){
        return;
    }
    HeroNode cur = head.next;
    HeroNode next=null;
    HeroNode reverseHead = new HeroNode(0,"","");
    while (cur != null) {
        next=cur.next;
        cur.next=reverseHead.next;
        reverseHead.next=cur;
        cur=next;
        }
    head.next=reverseHead.next;
}



}





//定义SingleLinkedList，管理英雄
class SingleLinkedList {
//    初始化头节点
    private HeroNode head = new HeroNode(0,"","");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    //第一种添加节点到单向链表
    public void add (HeroNode heroNode) {
        HeroNode temp =head;
        while (true) {
            if (temp.next ==null ) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
//    第二种添加英雄方式，根据排名添加
    // 如果有这个排名则添加失败
    public void addByOrder (HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false ; // 标识添加编号是否存在，默认为false
        while (true) {
            if (temp.next==null) {
                break;
            }
            if (temp.next.no> heroNode.no) {  //位置找到了，在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                flag =true;
                break;
            }
            temp=temp.next;
        }
        if (flag){//不能添加，说明编号存在
            System.out.printf("准备插入的编号:%d,已经存在\n", heroNode.no);
        } else {
        heroNode.next=temp.next;
        temp.next=heroNode;
        }
    }

    //修改节点信息，根据编号修改，即编号不能改，如果改了，即为添加
    //1.根据no来修改
    public void update (HeroNode newHeroNode){
        if (head.next== null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据No编号
        //定义一个辅助变量
        HeroNode temp = head.next;
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


    //删除节点
    //思路
    //1. head节点不能动，因此temp=head.next
    //2. 说明我们比较时，是temp.next.no和需要删除的节点的no比较

    public void del (int no) {
        HeroNode tmp = head;
        boolean flag =false;
        while (true) {
            if (tmp.next==null){
                break;
            }
            if (tmp.next.no==no){
                flag=true;
                break;
            }
            tmp=tmp.next;
        }
        if (flag) {
            tmp.next=tmp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no );
        }
    }


    //显示链表

    public void list() {
        if (head.next==null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp=temp.next;

        }
    }


}




//定义heronode，每个就是一个节点


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
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

