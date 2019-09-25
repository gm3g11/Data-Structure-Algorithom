package eric.meng.Queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show), 显示队列");
            System.out.println("e(exit), 退出队列");
            System.out.println("a(add), 添加数据到队列");
            System.out.println("g(get), 取出数据");
            System.out.println("h(head), 查看队列头");
            key = scanner.next().charAt(0); //接收一个字符

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.headQueue();
                        System.out.printf("头数据是%d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }

    }

    //编写一个ArrayQueue的类
    static class CircleArray {
        private int maxSize;   //数组最大容量
        private int front;   //队列头指针 指向第一个元素 初始值为0
        private int rear;   //队列尾指针 指向最后一个元素的前一个 初始值为0
        private int[] arr;   //模拟队列

        //创建队列的构造器

        public CircleArray(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = 0; //指向队列头的前一个位置
            rear = 0;  //指向队列尾，队列最后一个数据


        }

        //判断队列是否满

        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        //添加数据
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满，不能加入数据");
                return;
            }

            arr[rear] = n;
            //rear必须考虑取模
            rear = (rear + 1) % maxSize;
        }

        //出队列
        public int getQueue() {
            if (isEmpty()) {
                //抛出异常
                throw new RuntimeException("队列空，不能取数据");
            }
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        //显示队列所有数据
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列空的，没有数据");
                return;
            }
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        //求出当前队列有效数据个数

        public int size() {
            return (rear - front + maxSize) % maxSize;

        }

        //显示队列头数据，不是取出数据
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，没有数据");
            }
            return arr[front];
        }
    }
}
