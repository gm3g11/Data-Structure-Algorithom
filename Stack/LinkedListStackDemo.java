package eric.meng.Stack;

import java.util.Scanner;

/**
 * @param
 * @return
 **/
public class LinkedListStackDemo {
    public static void main(String[] args) {
        String key="";
        int maxSize =4;
        boolean loop =true;
        Scanner scanner = new Scanner(System.in);
        LinkedListStack stack =new LinkedListStack();


        while (loop) {
            System.out.println("show, 显示栈");
            System.out.println("exit, 退出");
            System.out.println("push, 入栈");
            System.out.println("pop, 出栈");

            key = scanner.next();
            switch (key) {
                case "show":
                    stack.printStack();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);

                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;


            }





        }




    }

    static class LinkedListStack {
        private int maxSize; //栈的大小
        public StackType head = new StackType(0); //头结点

        //判断是否为满
        public boolean isFull(int maxSize) {
            this.maxSize=maxSize;
            int count = 0;
            StackType tmp = head;

            while (true) {
                if (tmp.next == null) {
                    break;
                }
                tmp = tmp.next;
                count++;
            }

            return count > maxSize;
        }

        //判断是否为空
        public boolean isEmpty() {
            if (head.next == null) {
                return true;
            } else {
                return false;
            }
        }

        //添加节点
        public void push(int value) {
            StackType pushValue = new StackType(value);
            if (isFull(maxSize)) {
                System.out.println("栈满了");
                return;
            }
            StackType tmp = head;
            while (true) {
                if (tmp.next == null) {
                    break;
                }
                tmp = tmp.next;
            }

            tmp.next = pushValue;


        }

        //弹出节点

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈空，没有数据了");
            }
            StackType tmp = head;
            while (true) {
                if (tmp.next.next == null) {
                    break;
                }
                tmp = tmp.next;
            }

            int value = tmp.next.next.value;
            tmp.next = null;
            return value;
        }


        //显示节点

        public void printStack() {
            if (isEmpty()) {
                System.out.println("栈空，没有数据");
                return;
            }
            StackType tmp = head;

            while (true) {
                if (tmp.next == null) {
                    //System.out.printf("该节点数值：%d\n", tmp.value);
                    break;
                }
                System.out.printf("该节点数值：%d\n", tmp.value);
                tmp = tmp.next;
            }
        }



    }




}
//定义一个节点
class StackType {
    public int value;
    public StackType next; //指向下一个节点

    public StackType(int value) {
        this.value = value;
    }

}
