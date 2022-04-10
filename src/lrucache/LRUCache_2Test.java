package lrucache;

import org.junit.Test;


public class LRUCache_2Test {
    @Test
    public void testLRUCache1() {
        LRUCache_2 lruCache2 = new LRUCache_2(2);
        lruCache2.put(2, 1);
        lruCache2.put(1, 1);
        lruCache2.put(2, 3);
        lruCache2.put(4, 1);
        System.out.println(lruCache2.get(1));
        System.out.println(lruCache2.get(2));
    }

    @Test
    public void testLRUCache2() {
        LRUCache_2 lruCache2 = new LRUCache_2(2);
        lruCache2.put(1, 1);
        lruCache2.put(2, 2);
        System.out.println(lruCache2.get(1));
        lruCache2.put(3, 3);
        System.out.println(lruCache2.get(2));
        lruCache2.put(4, 4);
        System.out.println(lruCache2.get(1));
        System.out.println(lruCache2.get(3));
        System.out.println(lruCache2.get(4));
    }

    @Test
    public void testLRUCache6() {
        LRUCache_2 lruCache2 = new LRUCache_2(1);
        lruCache2.put(12,1);
        lruCache2.put(15,11);
        lruCache2.put(5,2);
        lruCache2.put(1,15);
        lruCache2.put(4,2);
        System.out.println(lruCache2.get(5));
        lruCache2.put(15,15);
    }
}