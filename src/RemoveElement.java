/**
 * @source: https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        ListNode handler = newHead;
        while (head != null) {
            if (head.val != val) {
                handler.next = head;
                handler = handler.next;
            }
            head = head.next;
        }
        // remember to set handler.next = null, otherwise handler will point to the rest of head.
        handler.next = null;
        return newHead.next;
    }

    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
