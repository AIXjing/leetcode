package lrucache;
import org.junit.Test;

public class LRUCache_1Test {
    @Test
    public void testLRUCache1() {
        LRUCache_1 lruCache1 = new LRUCache_1(2);
        lruCache1.put(1, 1);
        lruCache1.put(2, 2);
        lruCache1.get(1);
        lruCache1.put(3, 3);
        lruCache1.get(2);
        lruCache1.put(4, 4);
        lruCache1.get(1);
        lruCache1.get(3);
        lruCache1.get(4);
        System.out.println(lruCache1.get(5));
    }

    @Test
    public void testLRUCache2() {
        LRUCache_1 lruCache1 = new LRUCache_1(2);
        lruCache1.put(2, 1);
        lruCache1.put(2, 2);
        System.out.println(lruCache1.get(2));
        lruCache1.put(1, 1);
        lruCache1.put(4, 1);
        lruCache1.get(2);
        System.out.println(lruCache1.get(2));
    }

    @Test
    public void testLRUCache3() {
        LRUCache_1 lruCache1 = new LRUCache_1(2);
        lruCache1.put(2, 1);
        lruCache1.put(1, 1);
        lruCache1.put(2, 3);
        lruCache1.put(4, 1);
        System.out.println(lruCache1.get(1));
        System.out.println(lruCache1.get(2));
    }

    @Test
    public void testLRUCache4() {
        LRUCache_1 lruCache1 = new LRUCache_1(1);
        System.out.println(lruCache1.get(0));
    }

    @Test
    public void testLRUCache5() {
        LRUCache_1 lruCache1 = new LRUCache_1(2);
        lruCache1.put(2,1);
        lruCache1.put(3,2);
        System.out.println(lruCache1.get(3));
        System.out.println(lruCache1.get(2));
        lruCache1.put(4,3);
        System.out.println(lruCache1.get(2));
        System.out.println(lruCache1.get(3));
        System.out.println(lruCache1.get(4));
    }

    @Test
    public void testLRUCache6() {
        LRUCache_1 lruCache1 = new LRUCache_1(1);
        lruCache1.put(12,1);
        lruCache1.put(15,11);
        lruCache1.put(5,2);
        lruCache1.put(1,15);
        lruCache1.put(4,2);
        System.out.println(lruCache1.get(5));
        lruCache1.put(15,15);
    }
}