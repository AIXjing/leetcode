/**
 * @source: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergedLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode();
        ListNode handler = head; // to point the head of the merged listnode
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                handler.next = p1;
                p1 = p1.next;
            } else {
                handler.next = p2;
                p2 = p2.next;
            }
            handler = handler.next;
        }
        if (p1 == null) handler.next = p2;
        else handler.next = p1;
        return head.next;
    }

    // recursive method
    public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRec(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRec(list1, list2.next);
            return list2;
        }
    }
}
