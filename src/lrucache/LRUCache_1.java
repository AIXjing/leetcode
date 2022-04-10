package lrucache;

/** @source: https://leetcode.com/problems/lru-cache/
 * @Jing
 * method 1: create a hashMap to map key and node O(3-5)
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class LRUCache_1 {
    private HashNode sentinel;
    private HashMap<Integer, HashNode> hashNodeMap;
    private final int capacity;
    private int size;

    // a deque structure
    public LRUCache_1(int capacity) {
        sentinel = new HashNode(null, null, null);
        hashNodeMap = new HashMap<>();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
        this.capacity = capacity;
    }

    // get the value and put key-HashNode map to the first in the queue
    public int get(int key) {
        HashNode target = hashNodeMap.get(key);
        if (target == null) {
            return -1;
        } else if (target.value == null) {
            return -1;
        }
        int value = removeFromQueue(target);
        hashNodeMap.remove(key);
        put(key, value);
        return value;
    }

    // remove the HashNode with the key
    private Integer removeFromQueue(HashNode target) {
        // connect HashNode before and after the target Node
        HashNode targetPrev = target.prev;
        HashNode targetNext = target.next;
        targetPrev.next = targetNext;
        targetNext.prev = targetPrev;
        int value = target.value;
        target.next = null;
        target.prev = null;
        target = null;
        size -= 1;
        return value;
    }

    // put HashNode with (key,value) to the first
    // if key exists, update the value
    public void put(int key, int value) { // equal to addFirst
        if (hashNodeMap.get(key) != null) {
            if (hashNodeMap.get(key).value == null) {
                hashNodeMap.remove(key);
            } else {
                removeFromQueue(hashNodeMap.get(key));
            }
        }
        HashNode oldHead = sentinel;
        HashNode oldFirst = sentinel.next;
        HashNode newHashNode = new HashNode(value, oldHead, oldFirst);
        oldHead.next = newHashNode;
        oldFirst.prev = oldHead.next;
        size += 1;
        hashNodeMap.put(key,newHashNode);
        if (size > this.capacity) {
            removeLast();
        }
    }

    private void removeLast() {
        HashNode lastNode = sentinel.prev;
        HashNode newLast = lastNode.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        lastNode.prev = null;
        lastNode.next = null;
        lastNode.value = null;
        size -= 1;
    }

    private static<T, E> T getKeyByValue(HashMap<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    // nested HashNode class
    class HashNode {
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

