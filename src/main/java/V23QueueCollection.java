import java.util.*;

public class V23QueueCollection {
    public static void main(String[] args) {

        /**
         *      MIN PRIORITY QUEUE: used to solve problems of min heap
         */

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        /**
         *      here we haven't passed any value in the constructor i.e. empty constructor which will use default settings
         *      here default order of element insertion is happening with natural ordering
         *      for Integer natural ordering is ascending
         *      to change natural order we will use comparator
         *      since natural ordering is being used and we expect an Integer value so ordering will be is ascending order.
         *      and ascending order is minimum at first therefore it will implement min heap
         *      understand the concept of heap
         *      so in conclusion to implement min heap we have to provide an empty constructor.
         */

        minPQ.add(5);
        minPQ.add(2);
        minPQ.add(8);
        minPQ.add(1);

        // print all the values
        minPQ.forEach((Integer val) -> System.out.println(val));

        // remove top element from PQ and print
        while (!minPQ.isEmpty()){
            int val = minPQ.poll();
            System.out.println("remove from top: " + val);
        }

        /**
         *  MAX PRIORITY QUEUE: used to solve problems of max heap
         */

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer a, Integer b) -> b-a);

        /**
         *      here we have to provide a comparator in the constructor parameter to get a max heap
         *      (we need decreasing order for Integer in max heap)
         */

        maxPQ.add(5);
        maxPQ.add(2);
        maxPQ.add(8);
        maxPQ.add(1);

        // print all the values
        maxPQ.forEach((Integer val) -> System.out.println(val));

        // remove top element from PQ and print
        while (!maxPQ.isEmpty()){
            int val = maxPQ.poll();
            System.out.println("remove from top: " + val);
        }



        /**
         *  Comparator primitive collection ordering solution
         */

        System.out.println(" ----------- Comparator primitive collection ordering solution ----------");

        Integer[] arr ={17, 3, 5, 1, 10};
        // ascending
        Arrays.sort(arr);
        //this is equivalent to this below line
        Arrays.sort(arr, (Integer val1, Integer val2) -> val1- val2);
        //checkout the sort method here and find  c.compare(dest[j-1], dest[j])>0
        // both the above sort() methods use different compare methods

        //for descending
        Arrays.sort(arr, (Integer val1, Integer val2) -> val2 - val1); // (Integer val1, Integer val2) -> val2 - val1 comparator for decreasing order
        for(int v: arr){
            System.out.println(v);
        }

        /**
         *  Comparator object collection ordering solution
         */

        System.out.println(" -----------  Comparator object collection ordering solution----------");

        Car[] carArray = new Car[3];

        carArray[0]= new Car("SUV", "CNG");
        carArray[1]= new Car("Sedan", "Petrol");
        carArray[2]= new Car("HatchBack", "Diesel");
        //for descending order of carType
        Arrays.sort(carArray, (Car val1, Car val2) -> val2.carType.compareTo(val1.carType)); // Car val1, Car val2) -> val1.carType.compareTo(val1.carType) comparator for decreasing order of carType
        // compareTo is used for String lexicographical ordering

        // increasing order of carName
        // Arrays.sort(carArray, (Car val1, Car val2) -> val1.carName.compareTo(val2.carName));
        for(Car v: carArray){
            System.out.println(v.carName + "..."+ v.carType);
        }

        /**
         *  for increasing order use value one first in comparator ie val1 compare val 2
         *  for decreasing order use value two first in comparator ie val2 compare val 1
         */

        /**
         * Now say since Comparator is a functional interface and we know to implement a functional interface we have three
         * ways: using anonymous class, using implements keyword and using lambda function
         * now say if you don't want to implement comparator with lamdba function directly you can create a different class that implements comparator and override compare
         * method with the way you want it to function. we can create multiple such classes each implementing a different type of comparison logic and ordering
         * lets see an example of it using CarNameComparator and let's invoke it over a list collection rather than an array, the only difference would be while sorting we have
         * to call Collections.sort() instead of Array.sort() and pass the new comparator class in its parameter
         */

        System.out.println(" -----------  Comparator implementation using a new different comparator class ----------");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("SUV", "CNG"));
        cars.add(new Car("Sedan", "Petrol"));
        cars.add(new Car("HatchBack", "Diesel"));

        Collections.sort(cars, new CarNameComparator());
        cars.forEach((Car v) -> System.out.println(v.carName + "..."+ v.carType));

        /**
        *      Also if you want to have only one type of compare method and nobody should use that in this case in the object class (like car) that
         *     you have you can implement Comparator there itself and override the compare method and have an empty constructor that will call this
         *     overridden method when a new object is created with an empty constructor
         *     but this option doesn't provide much diversity
         */
        System.out.println(" ----------- Object class itself Implements Comparator ----------");

        List<CarImplementsComparator> carsList = new ArrayList<>();
        carsList.add(new CarImplementsComparator("SUV", "CNG"));
        carsList.add(new CarImplementsComparator("Sedan", "Petrol"));
        carsList.add(new CarImplementsComparator("HatchBack", "Diesel"));

        Collections.sort(carsList, new CarImplementsComparator()); // call empty constructor here
        carsList.forEach((CarImplementsComparator v) -> System.out.println(v.carName + "..."+ v.carType));


        /**
         *  Comparable
         */
        System.out.println(" ----------- Comparable ----------");
        List<CarImplemetsComaparable> carsComparableList = new ArrayList<>();
        carsComparableList.add(new CarImplemetsComaparable("SUV", "CNG"));
        carsComparableList.add(new CarImplemetsComaparable("Sedan", "Petrol"));
        carsComparableList.add(new CarImplemetsComaparable("HatchBack", "Diesel"));

        Collections.sort(carsComparableList);
        carsComparableList.forEach((CarImplemetsComaparable v) -> System.out.println(v.carName + "..."+ v.carType));

    }
}
