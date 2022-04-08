package lrucache;

import java.util.HashMap;
import java.util.Optional;

class LRUCache_1 {
    private HashNode sentinel;
    private HashMap<Integer, HashNode> hashNodeMap;
    private final int capacity;
    private int size;

    // a deque structure
    public LRUCache_1(int capacity) {
        if (capacity <  1 || capacity > 3000) {
            throw new IllegalArgumentException("capacity should be [1,3000]");
        }
        sentinel = new HashNode(null, null, null);
        hashNodeMap = new HashMap<>();
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
        return hashNodeMap.get(key);
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

        removeKeyInMap(target);
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
        HashNode newHashNode = new HashNode(pair, p, n);
        p.next = newHashNode;
        n.prev = p.next;
        size += 1;

        hashNodeMap.put(key,newHashNode);
    }

    private void removeLast() {
        HashNode lastNode = sentinel.prev;
        HashNode newLast = lastNode.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        lastNode.next = null;
        lastNode.prev = null;

        removeKeyInMap(lastNode);
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
    private void removeKeyInMap(HashNode targetNode) {
        for (Integer k : targetNode.pair.keySet()) {
            hashNodeMap.remove(k);
        }
    }
}

