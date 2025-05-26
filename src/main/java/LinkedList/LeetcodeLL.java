package LinkedList;

public class LeetcodeLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
        public ListNode deleteDuplicates(ListNode node) {
            ListNode head=node;
            if(node==null){
                return node;
            }
            while(node.next!=null){
                if(node.val==node.next.val){
                    node.next=node.next.next;

                }
                else{
                    node=node.next;
                }

            }
            return head;
        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head=new ListNode();
            ListNode temp=head;
            while(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    temp.next=list1;
                    list1=list1.next;
                    temp=temp.next;
                }
                else{
                    temp.next=list2;
                    list2=list2.next;
                    temp=temp.next;
                }
            }
            temp.next=(list1!=null)?list1:list2;
            return head.next;
        }

        //check if list has a cycle
        public boolean hasCycle(ListNode head) {
            ListNode fast= head;
            ListNode slow=head;
            while(fast!=null &&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    return true;
                }

            }
            return false;
        }

        //check length of cycle
        public int lengthCycle(ListNode head){
            ListNode fast=head;
            ListNode slow=head;
            int length=0;
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    do{
                        slow=slow.next;
                        length++;
                    }while(slow!=fast);
                    return length;
                }
            }
            return 0;
        }
        //start node of cycle
        public ListNode detectCycle(ListNode head) {
            ListNode fast=head;
            ListNode slow=head;
            int length=0;
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    length=lengthCycle(slow);
                    break;
                }
            }
            if(length==0){
                return null;
            }
            ListNode f=head;
            ListNode s=head;
            while(length>0){
                s=s.next;
                length--;
            }
            while(f!=s){
                f=f.next;
                s=s.next;
            }
            return s;
        }

        //middle of linked list
        public ListNode middleNode(ListNode head) {
            ListNode fast=head;
            ListNode slow=head;
            while(fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }

        //sort a linked list - use merge sort - midpoint function to split, then sortlist to recursively sort with the help of merge function
        public ListNode sortList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode mid=midpoint(head);
            ListNode left=sortList(head);
            ListNode right=sortList(mid);

            return merge(left,right);
        }
        public ListNode merge(ListNode list1,ListNode list2){
            ListNode head=new ListNode();
            ListNode tail=head;
            while(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    tail.next=list1;
                    list1=list1.next;
                    tail=tail.next;
                }
                else{
                    tail.next=list2;
                    list2=list2.next;
                    tail=tail.next;
                }

            }
            tail.next=(list1!=null)?list1:list2;
            return head.next;
        }
        public ListNode midpoint(ListNode head){
            ListNode fast=head;
            ListNode slow=head;
            ListNode prev=head;
            while(fast!=null && fast.next!=null){
                prev=slow;
                fast=fast.next.next;
                slow=slow.next;
            }
            if(prev!=null){
                prev.next=null;
            }
            return slow;
        }

        //Happy number q - if number is 19 - 1^2+9^2=82....8^2_2^2=..... if ends in 1 then happy else if loops continuosly not
        //use LL cycle detection and if the slow pointer meets at 1 then happy
        public boolean isHappy(int n) {
            int fast=n;
            int slow=n;
            do{
                slow=findsquare(slow);
                fast=findsquare(findsquare(fast));
            }while(slow!=fast);
            if(slow==1){
                return true;
            }
            return false;
        }
        public int findsquare(int num){
            int ans=0;
            while(num>0){
                int rem=num%10;
                ans+=rem*rem;
                num/=10;
            }
            return ans;
        }

        //reverse a linked list in place
        public ListNode reverseList(ListNode head) {
            ListNode prev=null;
            ListNode pres=head;
            ListNode next=null;
            while(pres!=null){
                next=pres.next;
                pres.next=prev;
                prev=pres;
                pres=next;
                if(next!=null){
                    next=next.next;
                }
            }
            return prev;
        }
    //reverse between a give left and right node ina  linked list
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        //parse till prev becomes one node previous node of left and current is left
        for (int i = 1; current != null && i < left; i++) {
            prev = current;
            current = current.next;
        }
        //connection before left and after right
        ListNode leftcon = prev;
        ListNode rightcon = current;
        //exchange one by one between left and right
        ListNode next = current.next;
        for (int i = 0; i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        //now that the middle subset list is changed i have to join the elemets before and after the subset to the new nodes.
        if (leftcon != null) {
            leftcon.next = prev;
        } else {
            head = prev;
        }
        rightcon.next = current;
        return head;
    }

    //reverse k nodes in a group
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1||head==null){
            return head ;
        }
        ListNode prev=null;
        ListNode current=head;

        int length=getlength(head);
        int count=length/k;
        while(count>0){

            ListNode next=current.next;
            ListNode last=prev;
            ListNode newlast=current;
            for(int i=0;current!=null && i<k;i++){
                current.next=prev;
                prev=current;
                current=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last!=null){
                last.next=prev;
            }
            else{
                head=prev;
            }

            newlast.next=current;
            prev=newlast;
            count--;

        }
        return head;
    }
    public int getlength(ListNode head){
        ListNode p=head;
        int length=0;
        while(p!=null){
            length++;
            p=p.next;
        }
        return length;
    }

    //reverse alternate k nodes in LL
    public ListNode reverseAltKGroup(ListNode head, int k){
        if(k<2||head==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;


        while(curr!=null){
            ListNode next=curr.next;
            ListNode leftcon=prev;
            ListNode rightcon=curr;
            for(int i=0;curr!=null && i<k;i++){
                curr.next=prev;
                prev=curr;
                curr=next;
                if(next!=null){
                    next=next.next;
                }

            }
            if(leftcon!=null){
                leftcon.next=prev;
            }
            else{
                head=prev;
            }
            rightcon.next=curr;
            for(int j=0; curr!=null && j<k;j++){
                prev=curr;
                curr=curr.next;
            }
        }
        return head;
    }

    //rotate list k times
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null||head.next==null){
            return head;
        }
        ListNode last=head;
        int length=1;
        while(last.next!=null){
            length++;
            last=last.next;

        }
        last.next=head;
        ListNode newlast=head;
        int rotations=k%length;
        int skips=length-rotations;
        for(int i=0;i<skips-1;i++){
            newlast=newlast.next;
        }
        head=newlast.next;
        newlast.next=null;
        return head;
    }

}

