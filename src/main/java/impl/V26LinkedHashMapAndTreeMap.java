import java.util.*;

public class V26LinkedHashMapAndTreeMap {
    public static void main(String[] args) {
        System.out.println(" ----------------- Below is LinkedHashMap output  where ordering is not guaranteed ------");
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "A");
        map.put(21, "B");
        map.put(23, "C");
        map.put(141, "D");
        map.put(25, "E");

        map.forEach((Integer key, String val) -> System.out.println(key + " : " + val));
        // check out this forEach method and in its implementation where LinkedHashMap has overridden it you will get
        // to know how ordering is happening with double linkedlist concept.

        System.out.println(" ----------------- Below is normal HashMap output where ordering is not guaranteed ---------------");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "A");
        map2.put(21, "B");
        map2.put(23, "C");
        map2.put(141, "D");
        map2.put(25, "E");

        for(Map.Entry<Integer, String> entry: map2.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        // in the linkedHashMap constructor there is a parameter accessOrder which is by default false which means we want insertion order like above case
        // to get the access order we have to pass it as true and it will maintain the lowest frequently used elements
        // to highly frequently used elements

        System.out.println(" ----- with access order --------- ");

        Map<Integer, String> map3 = new LinkedHashMap<>(16, .75f, true);
        map3.put(1, "A");
        map3.put(21, "B");
        map3.put(23, "C");
        map3.put(141, "D");
        map3.put(25, "E");

        // access some data
        map3.get(23);
        map3.forEach((Integer key, String val) -> System.out.println(key + " : " + val)); // since 23 is used it should come at last

        System.out.println(" -------------------- TreeMap ------------------------");
        Map<Integer, String> map4 = new TreeMap<>((Integer key1, Integer key2) -> key2 - key1); // comparator for decreasing order
        map4.put(21, "GA");
        map4.put(11, "TB");
        map4.put(13, "TC");
        map4.put(5, "TC");

        //decreasing order
        map4.forEach((Integer key, String val) -> System.out.println(key + " : " + val));

        System.out.println(" TreeMap with natural ordering");
        Map<Integer, String> map5 = new TreeMap<>(); // natural ordering for Integer is ascending
        map5.put(21, "GA");
        map5.put(11, "TB");
        map5.put(13, "TC");
        map5.put(5, "TC");
        map5.forEach((Integer key, String val) -> System.out.println(key + " : " + val));


        System.out.println("------- SortedMap interface methods -------");

        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(21,"SJ");
        sortedMap.put(11,"PJ");
        sortedMap.put(13,"KJ");
        sortedMap.put(5,"TJ");

        System.out.println(sortedMap.headMap(13)); //exclusive of 13 will return all the previous mappings from start
        System.out.println(sortedMap.tailMap(13)); // inclusive of 13 will return all the next mappings till the end
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());

        System.out.println("------- NavigableMap interface methods -------");

        NavigableMap <Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "A");
        navigableMap.put(21, "B");
        navigableMap.put(23, "C");
        navigableMap.put(141, "D");
        navigableMap.put(25, "E");

        System.out.println(" lowerEntry: " + navigableMap.lowerEntry(23)); // returns the immediate Entry(Key, Value both) which is less than 23, if no value at all then return null
        System.out.println(" lowerKey: " + navigableMap.lowerKey(23)); // returns the immediate Key only which is less than 23, if no value at all then return null
        System.out.println(" higherEntry: " + navigableMap.higherEntry(23)); // returns the immediate Entry(Key, Value both) which is greater than 23, if no value at all then return null
        System.out.println(" higherKey: " + navigableMap.higherKey(23)); // returns the immediate Key only which is greater than 23, if no value at all then return null
        System.out.println(" floorEntry: " + navigableMap.floorEntry(24)); // returns the immediate Entry(Key, Value both) which is equal (first check if key 24 is there) or less than (second check) 24, if no value at all then return null
        System.out.println(" floorKey: " + navigableMap.floorKey(24)); // returns the immediate Key which is equal (first check if key 24 is there) or less than (second check) 24, if no value at all then return null
        System.out.println(" ceilingEntry: " + navigableMap.ceilingEntry(23)); // returns the immediate Entry(Key, Value both) which is equal (first check if key 23 is there) or greater than (second check) 23, if no value at all then return null
        System.out.println(" ceilingKey: " + navigableMap.ceilingKey(23)); // returns the immediate Key which is equal (first check if key 23 is there) or greater than (second check) 23, if no value at all then return null
        System.out.println(" firstEntry: " + navigableMap.firstEntry()); // gives first Entry<K,V>  in the map
        System.out.println(" lastEntry: " + navigableMap.lastEntry()); // gives last Entry<K,V>  in the map
        System.out.println(" firstKey: " + navigableMap.firstKey()); // gives first key in the map
        System.out.println(" lastKey: " + navigableMap.lastKey()); // gives last key in the map
        System.out.println(" pollFirstEntry: " + navigableMap.pollFirstEntry()); // return the least entry from the map and then remove it
        System.out.println(" pollLastEntry: " + navigableMap.pollLastEntry()); // return the last entry from the map and then remove it

        navigableMap.forEach((Integer key, String val) -> System.out.println(key + " : " + val));

        System.out.println("descendingMap: " + navigableMap.descendingMap()); // reverse the map and return
        System.out.println("navigableKeySet: " + navigableMap.navigableKeySet()); //if treeMap is sorted in ascending order keys will come in ascending order else in descending
        System.out.println("descendingKeySet: " + navigableMap.descendingKeySet()); //if treeMap is sorted in ascending order keys will come in descending order else in ascending
        System.out.println("headMap(K toKey, boolean inclusive): " + navigableMap.headMap(23, true));
        System.out.println("tailMap(K fromKey , boolean inclusive): " + navigableMap.tailMap(23,true));
     }

}
