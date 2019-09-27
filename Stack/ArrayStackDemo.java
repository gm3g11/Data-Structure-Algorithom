package eric.meng.Stack;

import java.util.Scanner;

/**
 * @param
 * @return
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {
        //创建一个栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);


        while (loop) {
            System.out.println("show, 显示栈");
            System.out.println("exit, 退出");
            System.out.println("push, 入栈");
            System.out.println("pop, 出栈");

            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
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
        static class ArrayStack {
            private int maxSize; //栈的大小
            private int[] stack; //数组模拟栈
            private int top = -1; //栈顶，初始化-1

            public ArrayStack(int maxSize) {
                this.maxSize = maxSize;
                stack = new int[maxSize];
            }

            //栈满
            public boolean isFull() {
                if (top == maxSize - 1) {
                    return true;
                } else {
                    return false;
                }
            }

            //栈空
            public boolean isEmpty() {
                return top == -1;
            }

            //入栈
            public void push(int value) {
                if (isFull()) {
                    System.out.println("栈满，无法添加");
                    return;
                }
                top++;
                stack[top] = value;
            }

            //出栈
            public int pop() {
                if (isEmpty()) {
                    //System.out.println("栈空，没有数据了");
                    throw new RuntimeException("栈空，没有数据了");
                }
                int value = stack[top];
                top--;
                return value;
            }

            //打印
            public void list() {
                if (isEmpty()) {
                    System.out.println("栈空，没有数据");
                    return;
                }
                for (int i = top; i >= 0; i--) {
                    System.out.println(stack[i]);
                }
            }
        }
    }

