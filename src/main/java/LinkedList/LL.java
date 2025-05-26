package LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size=0;
    }
    private class Node{
        private int value;
        private  Node next;

        public Node(int value) {
            this.value=value;
        }
        public Node(int value, Node next){
            this.value=value;
            this.next=next;
        }
    }

    //insertfirst
    //insertlast
    //insert value at a given index
    //delete first
    //delete last
    //delete from an index
    //find the node
    //get the value
    //display
    //reverse list

    //insert first
    public void insertFirst(int value ){
        Node node =new Node(value);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    //insert last
    public void insertLast(int value){
        Node node =new Node(value);
        if(tail==null){
            insertFirst(value);
            return;
        }

        tail.next=node;
        tail=node;
        size++;
    }
    //display
    public void Display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value +"->");
            temp=temp.next;
        }
        System.out.print("END");
    }
    //insert at index
    public void insertAtIndex(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(value,temp.next);
        temp.next=node;
        size++;
    }
    //get value
    public Node get(int index ){
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    public Node find(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public int deleteFirst(){
        int value=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;

    }
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }
    //insert using recursion
    public void insertRec(int value,int index ) {

        head=insertRec(value,index,head);
    }
        private Node insertRec(int value,int index,Node node){
            if(index==0){
                Node temp=new Node(value,node);
                size++;
                return temp;
            }
            node.next=insertRec(value,index-1,node.next);
            return node;
        }

    public void reverserec(Node node){
        if(node==tail){
            tail=head;
            return;
        }
        reverserec(node.next);
        tail.next=node;
        tail=node;
        node.next=null;
    }
    }

