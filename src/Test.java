import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "halo");
        for (Integer i : map.keySet()) {
            System.out.print(map.get(i) + ", ");
        }
    }

}
