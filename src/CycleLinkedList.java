/**
 * @source: https://leetcode.com/problems/linked-list-cycle/
 * @description: Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * @algrithms:
 * 1. Use two pointers, walker and runner.
 * 2. walker moves step by step. runner moves two steps at time.
 * 3. if the Linked List has a cycle walker and runner will meet at some point.
 */

import java.util.HashMap;

public class CycleLinkedList {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

}
