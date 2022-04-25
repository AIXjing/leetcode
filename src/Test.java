import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> raw = new ArrayList<>();
        raw.add("cap");
        raw.add("apple");
        raw.add("banana");
        raw.add("cat");
        raw.add("noodle");
        raw.add("earth");
        List<String> copy = new ArrayList<>(raw);
        System.out.println("Print out raw list: ");
        printList(raw);
        Collections.sort(raw);
        System.out.println("Print out sorted raw list: ");
        printList(raw);
        System.out.println("Print out coped list");
        printList(copy);

        System.out.println("===========");
        System.out.println("remove apple");
        raw.remove("apple");
        System.out.println("Print out modified raw list: ");
        printList(raw);
        System.out.println("Print out coped list");
        printList(copy);

    }

    private static void printList(List<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("=============");
    }

}
