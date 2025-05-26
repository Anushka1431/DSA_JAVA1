package Trees;


    public class AVLTree {
        public AVLTree(){

        }
        public class Node{
            int value;
            int height;
            Node left;
            Node right;

            public Node(int value){
                this.value=value;
            }
            public int getValue(){
                return value;
            }
        }
        private Node root;
        public int height() {
            return height(root);
        }
        private int height(Node node) {
            if(node==null){
                return -1;
            }
            return node.height;
        }
        public boolean isEmpty(){
            return root==null;
        }
        public void insert(int value){
            root=insert(value,root);
        }
        private Node insert(int value, Node node){
            if(node==null){
                node = new Node(value);
                return node;
            }
            if(value<node.value){
                node.left=insert(value,node.left);
            }
            if(value>node.value){
                node.right=insert(value,node.right);
            }
            node.height=Math.max(height(node.left),height(node.right))+1;
            return rotate(node);//return this only after rotating if its not balanced
        }
        public Node rotate(Node node){
            if(height(node.left)-height(node.right)>1){
                //left heavy scenario
                //left left
                if(height(node.left.left)-height(node.left.right)>1){
                    return rotateRight(node);
                }
                //left right

                if(height(node.left.left)-height(node.left.right)<0){
                    node.left=rotateLeft(node.left);
                    return rotateRight(node);
                }
            }
            if(height(node.left)-height(node.right)<-1){
                //right heavy scenario
                //right right
                if(height(node.right.right)-height(node.right.left)>0){
                    return rotateLeft(node);
                }
                //right left
                if(height(node.right.right)-height(node.right.left)<0){
                    node.right=rotateRight(node.left);
                    return rotateLeft(node);
                }
            }
            return node;
        }

        private Node rotateLeft(Node p) {
            Node c=p.right;
            Node t=c.left;

            c.left=p;
            p.right=t;
            p.height=Math.max(height(p.left),height(p.right))+1;
            c.height=Math.max(height(c.left),height(c.right))+1;
            return c;
        }

        private Node rotateRight(Node p) {
            Node c=p.left;
            Node t=c.right;

            c.right=p;
            p.left=t;

            p.height=Math.max(height(p.left),height(p.right))+1;
            c.height=Math.max(height(c.left),height(c.right))+1;

            return c;
        }

        public void populate(int[] nums){
            for(int i=0;i<nums.length;i++){
                insert(nums[i]);
            }
        }
        public void populatesorted(int[] nums){
            populatesorted(nums,0,nums.length);
        }
        private void populatesorted(int[] nums, int start,int end){// this populates a sorted array in two halves instead of one staright line
            if(start>=end){
                return ;
            }
            int mid=(start+end)/2;
            insert(nums[mid]);
            populatesorted(nums,start,mid);
            populatesorted(nums,mid+1,end);
        }

        public boolean balanced(){
            return balanced(root);
        }
        private boolean balanced(Node node){
            if(node==null){
                return true;
            }
            return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left)&&balanced(node.right);
        }
        public void display(){
            display(this.root,"Root node is:");
        }
        private void display(Node node, String details){
            if(node==null){
                return ;
            }
            System.out.println(details+node.value);
            display(node.left,"left child of "+node.value+" is ");
            display(node.right,"right child of "+node.value+" is ");
        }

        public static void main(String[] args) {
            AVLTree tree = new AVLTree();

            for(int i=0; i < 1000; i++) {
                tree.insert(i);
            }

            System.out.println(tree.height());
        }
        }



