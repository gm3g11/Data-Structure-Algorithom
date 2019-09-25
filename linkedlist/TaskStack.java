package eric.meng.linkedlist;

import java.util.Stack;

/**
 * @param
 * @return
 **/
public class TaskStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        //出栈
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
