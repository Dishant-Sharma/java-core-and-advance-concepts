import java.util.Comparator;

public class CarImplementsComparator implements Comparator<CarImplementsComparator> {
    /**
     *  used in class V23QueueCollection
     */

    String carName;
    String carType;

    CarImplementsComparator(){

    } // this empty constructor will call the compare method when object creation will happen

    CarImplementsComparator(String name, String type){
        this.carName = name;
        this.carType = type;
    }

    @Override
    public int compare(CarImplementsComparator o1, CarImplementsComparator o2){
        return o2.carName.compareTo(o1.carName); // decreasing order of carName
    }
}
