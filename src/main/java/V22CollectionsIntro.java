import java.util.*;

public class V22CollectionsIntro {
    public static void main(String[] args) {

        /*
               ITERABLE INTERFACE METHODS
         */

        List<Integer> values = new ArrayList<>(); // List interface can hold an object of it's child
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        // using Iterator
        System.out.println(" Iterating the values using Iterator method");

        Iterator<Integer> valuesIterator = values.iterator();
        while (valuesIterator.hasNext()){
            int val = valuesIterator.next();
            System.out.println(val);
            if(val == 3){
                valuesIterator.remove();
            }
        }

        System.out.println("Iterating values using for each loop");
        for (int val: values) {
            System.out.println(val);
        }

        // using for each method
        System.out.println("testing forEach method");
        values.forEach((Integer val) -> System.out.println(val));

        /*
                COLLECTION INTERFACE - various methods used
        */

        List<Integer> collectionValues = new ArrayList<>();
        collectionValues.add(2);
        collectionValues.add(3);
        collectionValues.add(4);

        //size
        System.out.println("size: " + collectionValues.size());
        //isEmpty
        System.out.println("isEmpty: " + collectionValues.isEmpty());
        //contains
        System.out.println("contains: " + collectionValues.contains(5));
        //add
        collectionValues.add(5);
        System.out.println("added: " + collectionValues.contains(5));
        //remove using index
        collectionValues.remove(3);
        System.out.println("remove using index: " + collectionValues.contains(5));
        //remove using Object, removes the first occurrence of the value
        collectionValues.remove(Integer.valueOf(3));
        System.out.println("remove using index: " + collectionValues.contains(3));

        // let's create another collection say stack

        Stack<Integer> stackValues = new Stack<>();
        stackValues.add(6);
        stackValues.add(7);
        stackValues.add(8);

        // add all
        collectionValues.addAll(stackValues);
        System.out.println("add all test using contains: " + collectionValues.contains(stackValues));
        // contains all
        collectionValues.remove(Integer.valueOf(7));
        System.out.println("contains all after removing one element: " + collectionValues.contains(stackValues));
        // remove all
        values.removeAll(stackValues);
        System.out.println("remove all :" + collectionValues.contains(8));
        // clear
        collectionValues.clear();
        System.out.println("clear: "+ collectionValues.isEmpty());


        /**
         *    Collections Utility class methods
         */

        List<Integer> collectionsValues = new ArrayList<>();
        collectionsValues.add(1);
        collectionsValues.add(3);
        collectionsValues.add(2);
        collectionsValues.add(4);

        System.out.println("max val: " + Collections.max(collectionsValues));
        System.out.println("min val: " + Collections.min(collectionsValues));

        Collections.sort(collectionsValues);
        System.out.println("sorted");
        collectionsValues.forEach((Integer val) -> System.out.println(val));
    }
}
