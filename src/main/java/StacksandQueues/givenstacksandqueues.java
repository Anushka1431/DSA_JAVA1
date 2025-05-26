package StacksandQueues;


import java.util.*;

public class givenstacksandqueues {
    public static void main(String[] args) throws StackException{
        CustomStack stack=new CustomStack();

//        Stack<Integer> stack=new Stack<>();
        stack.push(20);
        stack.push(15);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

//        Queue<Integer> queue=new LinkedList<>();
//        queue.add(19);
//        queue.add(30);
//
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//
//        Deque<Integer> deque=new ArrayDeque<>();
//        deque.add(89);
//        deque.addFirst(15);
//        deque.addLast(10);
//        System.out.print(deque);
    }


}
