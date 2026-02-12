import java.util.Arrays;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode();
        ListNode head = cur;
        int remember = 0;
        while(l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remember;
            remember = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (remember != 0) {
            cur.next = new ListNode(remember);
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        int[] list1 = new int[]{2,4,3};
        int[] list2 = new int[]{5,6,4};

        ListNode listNode1 = new ListNode();
        ListNode cur1 = listNode1;
        for (int i = 0; i < list1.length; i++) {
            cur1.next = new ListNode(list1[i]);
            cur1 = cur1.next;
        }

        ListNode listNode2 = new ListNode();
        ListNode cur2 = listNode2;
        for (int i = 0; i < list2.length; i++) {
            cur2.next = new ListNode(list2[i]);
            cur2 = cur2.next;
        }

        ListNode result = atn.addTwoNumbers(listNode1.next, listNode2.next);
        printList(result);
    }

    private static void printList(ListNode listNode) {
        while (listNode != null) {
            if (listNode.next != null) System.out.print(listNode.val + " -> ");
            else System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}
