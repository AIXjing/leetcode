package lrucache;

/** @source: https://leetcode.com/problems/lru-cache/
 * @Jing
 * method 2: use key as index to store the node in an array O(1)
 * */

public class LRUCache_2 {
    private HashNode sentinel;
    private HashNode[] keys;
    private final int capacity;
    private int size;

    // a deque structure
    public LRUCache_2 (int capacity) {
        sentinel = new HashNode(null, null, null);
        keys = new HashNode[100];
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
        this.capacity = capacity;
    }

    // get the key-value pair and put them to the first
    public int get(int key) {
        if (keys[key] == null) {
            return -1;
        }
        if (keys[key].value == null) {
            keys[key] = null;
            return -1;
        }
        HashNode target = keys[key];
        int value = target.value;
        removeFromQueue(target);
        put(key,value);
        return value;
    }

    // remove the HashNode with the key
    private Integer removeFromQueue(HashNode target) {
        // connect HashNode before and after the target Node
        if (target.value == null) return null;
        HashNode targetPrev = target.prev;
        HashNode targetNext = target.next;
        targetPrev.next = targetNext;
        targetNext.prev = targetPrev;
        int value = target.value;
        target.next = null;
        target.prev = null;
        target.value = null;
        size -= 1;
        return value;
    }


    public void put(int key, int value) {
        HashNode repNode = keys[key];
        if(repNode != null) {
            removeFromQueue(repNode);
        }
        HashNode oldHead = sentinel;
        HashNode oldFirst = sentinel.next;
        HashNode newHashNode = new HashNode(value, oldHead, oldFirst);
        oldHead.next = newHashNode;
        oldFirst.prev = oldHead.next;
        size += 1;
        keys[key] = newHashNode;
        if (this.size > this.capacity) {
            removeLast();
        }
    }

    private void removeLast() {
        HashNode lastNode = sentinel.prev;
        HashNode newLast = lastNode.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        lastNode.next = null;
        lastNode.prev = null;
        lastNode.value = null;
        size -= 1;
    }

    // nested HashNode class
    private static class HashNode {
        private Integer value;
        HashNode prev;
        HashNode next;

        public HashNode (Integer v, HashNode prev, HashNode next) {
            this.value = v;
            this.prev = prev;
            this.next = next;
        }
    }

}
