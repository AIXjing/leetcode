package lrucache;

import java.util.HashMap;

class LRUCache_0 {
    private HashNode sentinel;
    private final int capacity;
    private int size;

    // a deque structure
    public LRUCache_0(int capacity) {
        if (capacity <  1 || capacity > 3000) {
            throw new IllegalArgumentException("capacity should be [1,3000]");
        }
        sentinel = new HashNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
        this.capacity = capacity;
    }

    // get the key-value pair and put them to the first
    public int get(int key) {
        HashNode target = find(key);
        if (target == null) {
            return -1;
        }
        remove(target);
        int value = target.pair.get(key);
        // add the target node to the first;
        put(key, value);
        return value;
    }

    // find the HashNode with the key
    private HashNode find(int key) {
        // the basic method to find the pair with the key: O(n)
        HashNode target = null;
        HashNode startNode = sentinel.next;
        HashMap<Integer, Integer> pairToCompair = startNode.pair;
        while (pairToCompair != null) {
            if (pairToCompair.containsKey(key)) {
                target = startNode;
            }
            startNode = startNode.next;
            pairToCompair = startNode.pair;
        }
        return target;
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
    }

    // put HashNode with (key,value) to the first
    // if key exists, update the value
    public void put(int key, int value) { // equal to addFirst
        if (key < 0 || key > 10000 || value < 0 || value > 100000) {
            throw new IllegalArgumentException("not valid key or value");
        }
        HashNode repNode = find(key);
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
        p.next = new HashNode(pair, p, n);
        n.prev = p.next;
        size += 1;
    }

    private void removeLast() {
        HashNode lastNode = sentinel.prev;
        HashNode newLast = lastNode.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
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
}

