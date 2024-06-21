import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class V25HashMap {
    public static void main(String[] args) {
        Map<Integer, String> rollNumberVsNameMap = new HashMap<>();
        rollNumberVsNameMap.put(null,"Test");
        rollNumberVsNameMap.put(0 ,null); // key or value can be null in a hashmap
        rollNumberVsNameMap.put(1 ,"A");
        rollNumberVsNameMap.put(2 ,"B");

        //compute if present
        rollNumberVsNameMap.putIfAbsent(null, "test");
        rollNumberVsNameMap.putIfAbsent(0,"Zero");
        rollNumberVsNameMap.putIfAbsent(3,"C");

        // iterating over a hashmap
        for(Map.Entry<Integer, String> entryMap: rollNumberVsNameMap.entrySet()){
            Integer key = entryMap.getKey();
            String value = entryMap.getValue();
            System.out.println("Key: " + key + " value: " + value);
        }

        //isEmpty
        System.out.println("isEmpty(): " + rollNumberVsNameMap.isEmpty());

        //size
        System.out.println("size: " + rollNumberVsNameMap.size());

        //containsKey()
        System.out.println("containsKey(3): " + rollNumberVsNameMap.containsKey(3));

        //get(Key)
        System.out.println("get(9): " + rollNumberVsNameMap.get(9));

        //getOrDefault
        System.out.println("get(9): " + rollNumberVsNameMap.getOrDefault(9, "default value"));

        //remove(key)
        System.out.println("remove(null): " + rollNumberVsNameMap.remove(null));

        for(Map.Entry<Integer, String> entryMap: rollNumberVsNameMap.entrySet()){
            Integer key = entryMap.getKey();
            String value = entryMap.getValue();
            System.out.println("Key: " + key + " value: " + value);
        }

        //keySet()
       for(Integer key : rollNumberVsNameMap.keySet()){
           System.out.println("Key: " + key);
       }

       //values()
        Collection<String> values = rollNumberVsNameMap.values();
       for(String value: values){
           System.out.println("value: " + value);
       }


    }
}
