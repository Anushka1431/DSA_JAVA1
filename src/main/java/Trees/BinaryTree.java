package Trees;
import java.util.Scanner;
//a complete binary tree will have second last level full and the last level should be filled from left to right
//node is i then left child would be 2i and rigth child is 2i+1 and parent is i/2
//max nodes is 2^(h+1) -1
//no. of nodes on a level l has 2^l nodes max
//n nodes has height atleast logn

public class BinaryTree {
    public BinaryTree(){

    }
    private static class Node{
        Node left;
        Node right;
        int value;

        public Node(int value){
            this.value=value;
        }
    }
    private Node root;
    public void populate(Scanner sc){
        System.out.println("Enter the root Node: ");
        int value=sc.nextInt();
        root=new Node(value);
        populate(sc,root);
    }
    private void populate(Scanner sc, Node node){
        System.out.println("Do you want to enter left of " + node.value);
        boolean left= sc.nextBoolean();
        if(left){
            System.out.println("Enter the left node of " +node.value);
            int value=sc.nextInt();
            node.left=new Node(value);
            populate(sc,node.left);
        }
        System.out.println("Do you want to enter right of " +node.value);
        boolean right= sc.nextBoolean();
        if(right){
            System.out.println("Enter the right node of "+node.value);
            int value=sc.nextInt();
            node.right=new Node(value);
            populate(sc,node.right);
        }
    }

    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){ //N-L-R
        if(node==null){
            return;
        }
        System.out.println(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node node){ //L-N-R
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.println(node.value+" ");
        inorder(node.right);
    }
    public void postorder(){
        postorder(root);
    }
    private void postorder(Node node){ //L-R-N
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value+" ");

    }

    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        bt.populate(scanner);
        bt.inorder();
    }
}
