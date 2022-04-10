package lrucache;

/** @source: https://leetcode.com/problems/lru-cache/
 * @Jing
 * method 2: use key as index to store the node in an array O(1)
 * */

import java.util.HashMap;

public class LRUCache_2 {
    private HashNode sentinel;
    private HashNode[] keys;
    private final int capacity;
    private int size;

    // a deque structure
    public LRUCache_2 (int capacity) {
        if (capacity <  1 || capacity > 3000) {
            throw new IllegalArgumentException("capacity should be [1,3000]");
        }
        sentinel = new HashNode(null, null, null);
        keys = new HashNode[10];
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
        HashNode target = keys[key];
        int value = target.pair.get(key);
        remove(target);
        put(key,value);
        return value;
    }

    // remove the HashNode with the key
    private void remove(HashNode target) {
        // connect HashNode before and after the target Node
        HashNode targetPrev = target.prev;
        HashNode targetNext = target.next;
        targetPrev.next = targetNext;
        targetNext.prev = targetPrev;
        target.next = null;
        target.prev = null;
        size -= 1;
        removeHashNodeInArrays(target);
    }

    // put HashNode with (key,value) to the first
    // if key exists, update the value
    public void put(int key, int value) { // equal to addFirst
        if (key < 0 || key > 10000 || value < 0 || value > 100000) {
            throw new IllegalArgumentException("not valid key or value");
        }
        HashNode repNode = keys[key];
        if(repNode != null) {
            remove(repNode);
        }
        if (this.size == this.capacity) {
            removeLast();
        }
        HashNode p = sentinel;
        HashNode n = sentinel.next;
        HashMap<Integer, Integer> pair = new HashMap<>();
        pair.put(key, value);
        HashNode newHashNode = new HashNode(pair, p, n);
        p.next = newHashNode;
        n.prev = p.next;
        size += 1;
        keys[key] = newHashNode;
    }

    private void removeLast() {
        HashNode lastNode = sentinel.prev;
        HashNode newLast = lastNode.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        lastNode.next = null;
        lastNode.prev = null;

        removeHashNodeInArrays(lastNode);
        size -= 1;
    }

    // nested HashNode class
    private class HashNode {
        private HashMap<Integer, Integer> pair;
        HashNode prev;
        HashNode next;

        public HashNode (HashMap<Integer, Integer> pair, HashNode prev, HashNode next) {
            this.pair = pair;
            this.prev = prev;
            this.next = next;
        }
    }

    // remote <key, hashNode> in hashNodeMap
    private void removeHashNodeInArrays(HashNode targetNode) {
        for (Integer k : targetNode.pair.keySet()) {
            keys[k] = null;
        }
    }

}
