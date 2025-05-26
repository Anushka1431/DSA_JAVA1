package LinkedList;

public class main {
    public static void main(String[] args) {
//        LL list=new LL();
//        list.insertFirst(3);
//        list.insertFirst(8);
//        list.insertFirst(5);
//        list.insertFirst(9);
//        list.insertLast(7);
//        list.insertAtIndex(10,3);
//        list.insertRec(60,4);
//        list.Display();
//        //list.reverserec();

        int[] values1 = {1, 2, 3, 4,5,6,7};
        LeetcodeLL.ListNode head1 = createList(values1);

        System.out.print("Original list1: ");
        printList(head1);

//        int[] values2 = {1, 3,5,6};
//        LeetcodeLL.ListNode head2 = createList(values2);
//
//        System.out.print("Original list2: ");
//        printList(head2);


        LeetcodeLL sol = new LeetcodeLL();
        //LeetcodeLL.ListNode result = sol.deleteDuplicates(head);
        //LeetcodeLL.ListNode result = sol.mergeTwoLists(head1,head2);
        //LeetcodeLL.ListNode result = sol.reverseList(head1);
        LeetcodeLL.ListNode result = sol.reverseAltKGroup(head1, 2);
        System.out.print("ans ");
        printList(result);

    }
    public static LeetcodeLL.ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        LeetcodeLL.ListNode head = new LeetcodeLL.ListNode(arr[0]);
        LeetcodeLL.ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new LeetcodeLL.ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Utility to print the list
    public static void printList(LeetcodeLL.ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }


}


