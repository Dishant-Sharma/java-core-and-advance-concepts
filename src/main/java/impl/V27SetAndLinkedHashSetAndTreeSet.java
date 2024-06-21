import java.util.*;

public class V27SetAndLinkedHashSetAndTreeSet {
    public static void main(String[] args) {

        System.out.println("--------------------- HashSet -------------");
        Set<Integer> set1 = new HashSet<>();
        set1.add(12);
        set1.add(11);
        set1.add(33);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();
        set2.add(11);
        set2.add(9);
        set2.add(88);
        set2.add(10);
        set2.add(5);
        set2.add(12);

        // Union of 2 sets
        set1.addAll(set2);
        System.out.println("after union");
        set1.forEach((Integer val) -> System.out.println(val));

        // Intersection of 2 sets

        set1.retainAll(set2);
        System.out.println(" after intersection");
        set1.forEach((Integer val) -> System.out.println(val));

        //difference of 2 sets
        set1.removeAll(set2);
        System.out.println(" after difference");
        set1.forEach((Integer val) -> System.out.println(val));


        System.out.println(" -------------- LinkedHashSet  -----------------");
        Set<Integer> intSet = new LinkedHashSet<>();
        intSet.add(2);
        intSet.add(77);
        intSet.add(82);
        intSet.add(63);
        intSet.add(5);

        Iterator<Integer> iterable = intSet.iterator();
        while (iterable.hasNext()){
            int val = iterable.next();
            System.out.println(val);
        }

        System.out.println("------------------- TreeSet----------");
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(77);
        treeSet.add(82);
        treeSet.add(63);
        treeSet.add(5);

        Iterator<Integer> iterable2 = intSet.iterator();
        while (iterable2.hasNext()){
            int val = iterable2.next();
            System.out.println(val);
        }
    }
}
