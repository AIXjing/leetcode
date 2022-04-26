import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/reverse-linked-list/
 */
public class ReservedLinkedList {
    // my initial method: store all node value in an arrayList and reverse it and then make a new linkedlist
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ListNode newLinedList = new ListNode();
        ListNode handler = newLinedList;
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            handler.next = new ListNode(list.get(i));
            handler = handler.next;
        }
        return newLinedList;
    }

    // iteration method
    public ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
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

