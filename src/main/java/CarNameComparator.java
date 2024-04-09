import java.util.Comparator;

public class CarNameComparator implements Comparator<Car> {
    /**
     *  used in class V23QueueCollection
     */

    @Override
    public  int compare(Car o1, Car o2){
        return o2.carName.compareTo(o1.carName); // decreasing order of carName
    }

    /**
     *  similarly we can have more comparators like carType comparator where we can have comparison based on carType and ordring ascending or descending
     */
}
