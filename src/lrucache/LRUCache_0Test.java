package lrucache;
import org.junit.Test;

public class LRUCache_0Test {
    @Test
    public void testLRUCache1() {
        LRUCache_0 lruCache0 = new LRUCache_0(2);
        lruCache0.put(1, 1);
        lruCache0.put(2, 2);
        lruCache0.get(1);
        lruCache0.put(3, 3);
        lruCache0.get(2);
        lruCache0.put(4, 4);
        lruCache0.get(1);
        lruCache0.get(3);
        lruCache0.get(4);
        System.out.println(lruCache0.get(5));
    }

    @Test
    public void testLRUCache2() {
        LRUCache_0 lruCache0 = new LRUCache_0(2);
        lruCache0.put(2, 1);
        lruCache0.put(2, 2);
        System.out.println(lruCache0.get(2));
        lruCache0.put(1, 1);
        lruCache0.put(4, 1);
        lruCache0.get(2);
        System.out.println(lruCache0.get(2));
    }

    @Test
    public void testLRUCache3() {
        LRUCache_0 lruCache0 = new LRUCache_0(2);
        lruCache0.put(2, 1);
        lruCache0.put(1, 1);
        lruCache0.put(2, 3);
        lruCache0.put(4, 1);
        System.out.println(lruCache0.get(1));
        System.out.println(lruCache0.get(2));
    }
}