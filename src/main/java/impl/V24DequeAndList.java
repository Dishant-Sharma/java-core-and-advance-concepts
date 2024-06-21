import java.util.*;

public class V24DequeAndList {
    public static void main(String args[]) {
        /**
         *      ArrayDeque
         */
        System.out.println("<--------------------- ArrayDeque As Queue -------------------->");
        ArrayDeque<Integer> arrayDequeAsQueue = new ArrayDeque<>();

        // Insertion
        arrayDequeAsQueue.addLast(1);
        arrayDequeAsQueue.addLast(5);
        arrayDequeAsQueue.addLast(10);

        //Deletion
        int element = arrayDequeAsQueue.removeFirst();
        System.out.println(element);

        //LIFO
        System.out.println("<--------------------- ArrayDeque As Stack -------------------->");

        ArrayDeque<Integer> arrayDequeAsStack = new ArrayDeque<>();
        arrayDequeAsStack.addFirst(1);
        arrayDequeAsStack.addFirst(5);
        arrayDequeAsStack.addFirst(10);

        //Deletion
        int removeElement = arrayDequeAsStack.removeFirst();
        System.out.println(removeElement);


        /*
                ArrayList concrete class implementing List interface methods
         */

        List<Integer> list1 = new ArrayList<>();

        // add (int index, Element e)
        list1.add(0,100);
        list1.add(1,200);
        list1.add(2,300);

        // addAll(int index, Collection c)
        List<Integer> list2 = new ArrayList<>();

        list2.add(0,400);
        list2.add(1,500);
        list2.add(2,600);

        list1.addAll(2,list2);
        list1.forEach((Integer val) -> System.out.println(val));

        // replaceAll(UniaryOperator op)
        list1.replaceAll((Integer val) -> -1 * val); // this method takes UnaryOperator as parameter which is a functional interface that's why passing a lambda expression. check it's implementation
        System.out.println(" after replace all");
        list1.forEach((Integer val) -> System.out.println(val));

        // sort(Comparator c)
        list1.sort((Integer val1, Integer val2) -> val1 - val2);
        System.out.println("after sorting in increasing order");
        list1.forEach((Integer val) -> System.out.println(val ));

        // get(int index)
        System.out.println(" value present at index 2 is: " + list1.get(2));

        // set(int index, Element e)
        list1.set(2, -400);
        System.out.println("after set method");

        list1.forEach((Integer val) -> System.out.println(val));

        // remove(int index)
        list1.remove(2);
        System.out.println("after removing");
        list1.forEach((Integer val) -> System.out.println(val));

        // indexOf(Object o)
        System.out.println("index of -200 Integer object is:" + list1.indexOf(-200));

        // need to provide the index in listIterator, from where it has to start.
        ListIterator<Integer> listIterator1 = list1.listIterator(list1.size());

        // traversing in backward direction

        while(listIterator1.hasPrevious()){
            int previousVal = listIterator1.previous();
            System.out.println("traversing backward: " + previousVal + " nextIndex: " + listIterator1.nextIndex() + " previous index: " +
                    listIterator1.previousIndex());
            if(previousVal == -100){
                listIterator1.set(-50);
            }
        }
        list1.forEach((Integer val) -> System.out.println("after set :" + val));

        // traversing in forward direction
        ListIterator<Integer> listIterator2 = list1.listIterator();
        while(listIterator2.hasNext()){
            int val = listIterator2.next();
            System.out.println("traversing backward: " + val + " nextIndex: " + listIterator2.nextIndex() + " previous index: " +
                    listIterator2.previousIndex());
            if(val == -200){
                listIterator2.add(-100);
            }
        }
        list1.forEach((Integer val) -> System.out.println("after add :" + val));

        List<Integer> subList = list1.subList(1,4);
        subList.forEach((Integer val) -> System.out.println("sublist: " + val));

        subList.add(-900);
        list1.forEach((Integer val) -> System.out.println("after value added in sublist :" + val));


        /**
                LinkedList
         */

        LinkedList<Integer> list = new LinkedList<>();

        // using Deque functionality
        list.addLast(200);
        list.addLast(300);
        list.addLast(400);
        list.addFirst(100);
        System.out.println(list.getFirst());

        // using list functionality
        LinkedList<Integer> llist2 = new LinkedList<>();
        llist2.add(0, 100);
        llist2.add(1, 300);
        llist2.add(2, 400);
        llist2.add(3, 200);
        System.out.println(llist2.get(1) + " and " + llist2.get(2));

    }
}
