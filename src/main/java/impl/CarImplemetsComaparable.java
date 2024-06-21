import java.util.Comparator;

public class CarImplemetsComaparable implements Comparable<CarImplemetsComaparable> {
    /**
     *  used in class V23QueueCollection
     */

    String carName;
    String carType;

    CarImplemetsComaparable(String name, String type){
        this.carName = name;
        this.carType = type;
    }

    @Override
    public int compareTo(CarImplemetsComaparable o2){
        return this.carType.compareTo(o2.carType); // decreasing order of carName
    }
}
