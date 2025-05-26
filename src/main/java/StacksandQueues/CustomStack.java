package StacksandQueues;

public class CustomStack {
     protected int[] data;
     public static final int DEFAULT_SIZE=10;

     int ptr=-1;
     public CustomStack(){
          this(DEFAULT_SIZE);
     }
     public CustomStack(int size){
          this.data=new int[size];
     }
     public boolean push(int item){
          if(isFull()){
               System.out.print("Stack is full");
               return false;
          }
          ptr++;
          data[ptr]=item;
          return true;
     }
     public int pop() throws StackException{
          if(isEmpty()){
               throw new StackException("stack is empty so cannot pop");
          }

          int returned=data[ptr];
          ptr--;
          return returned;
     }
     public int peek() throws StackException{
          if (isEmpty()) {
               throw new StackException("Cannot peek from an empty stack!!");
          }
          return data[ptr];
     }
     public boolean isFull(){
          return ptr==data.length-1;
     }
     public boolean isEmpty(){
          return ptr==-1;
     }
}
