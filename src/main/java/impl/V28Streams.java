import javax.jws.soap.SOAPBinding;
import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class V28Streams {
    public static void main(String[] args) {
        System.out.println("Example without a stream");

        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(1000);
        salaryList.add(3500);

        int count = 0;
        for (Integer salary : salaryList) {
            if (salary > 3000) {
                count++;
            }
        }
        System.out.println("Total Employee with salary > 3000: " + count);

        System.out.println("Same example with Streams");

        List<Integer> salaryList1 = new ArrayList<>();
        salaryList1.add(3000);
        salaryList1.add(4100);
        salaryList1.add(9000);
        salaryList1.add(1000);
        salaryList1.add(3500);

        long output = salaryList.stream().filter((Integer sal) -> sal > 3000).count();
        System.out.println("Total Employee with salary > 3000: " + output);

        System.out.println("Intermediate Stream methods");
        System.out.println("1. filter()");
        Stream<String> nameStream = Stream.of("Hello", "Everybody", "How", "Are", "You", "Doing"); //Step 1
        Stream<String> filteredStream = nameStream.filter((String name) -> name.length() <= 3); //Step 2
        List<String> filteredNameStream = filteredStream.collect(Collectors.toList()); //Step 3
        filteredNameStream.forEach((String val) -> System.out.print(val + " "));

        System.out.println("\n Intermediate Stream methods");
        System.out.println("2. map()");
        Stream<String> nameStream1 = Stream.of("Hello", "Everybody", "How", "Are", "You", "Doing"); //Step 1
        Stream<String> filteredNames = nameStream1.map((String name) -> name.toLowerCase()); //Step 2
        filteredNames.forEach((String val) -> System.out.print(val + " "));

        System.out.println("\n Intermediate Stream methods");
        System.out.println("3. flatMap()");

        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("I", "Love", "Java"),
                Arrays.asList("Concepts", "Are", "Very", "Clear"),
                Arrays.asList("It's", "Very", "Easy")
        );
        Stream<String> wordStream1 = sentenceList.stream()
                .flatMap((List<String> sentence) -> sentence.stream());
        wordStream1.forEach((String val) -> System.out.print(val + " "));
        System.out.println();
        Stream<String> wordStream2 = sentenceList.stream()
                .flatMap((List<String> sentence) -> sentence.stream().map((String val) -> val.toLowerCase()));
        wordStream2.forEach((String val) -> System.out.print(val + " "));

        System.out.println("\n Intermediate Stream methods");
        System.out.println("4. distinct()");

        Integer[] arr = {1, 5, 2, 7, 4, 4, 2, 0, 9};
        Stream<Integer> arrStream = Arrays.stream(arr).distinct();
        arrStream.forEach((Integer val) -> System.out.print(val + " "));

        System.out.println("\n Intermediate Stream methods");
        System.out.println("5. sorted()");

        Integer[] arr1 = {1, 5, 2, 7, 4, 4, 2, 0, 9};
        Stream<Integer> arrStream1 = Arrays.stream(arr1).sorted();
        arrStream1.forEach((Integer val) -> System.out.print(val + " "));

        Stream<Integer> arrStream2 = Arrays.stream(arr1).sorted((Integer val1, Integer val2) -> val2 - val1); // sorting in decreasing order
        arrStream2.forEach((Integer val) -> System.out.print(val + " "));

        System.out.println("\n Intermediate Stream methods");
        System.out.println("6. peek()");

        List<Integer> numbers = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> numberStream = numbers.stream()
                .filter((Integer val) -> val > 2)
                .peek((Integer val) -> System.out.print(val + " "))
                .map((Integer val) -> 1 * val);
        List<Integer> numbersList = numberStream.collect(Collectors.toList());
        System.out.println();
        numbersList.forEach((Integer i) -> System.out.print(i + " "));
        System.out.println();

        System.out.println("\n Intermediate Stream methods");
        System.out.println("7. limit()");

        List<Integer> numbers1 = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> numberStream1 = numbers1.stream().limit(3);
        List<Integer> numbersList1 = numberStream1.collect(Collectors.toList());
        numbersList1.forEach((Integer i) -> System.out.print(i + " "));
        System.out.println();

        System.out.println("\n Intermediate Stream methods");
        System.out.println("8. skip()");

        List<Integer> numbers2 = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> numberStream2 = numbers2.stream().skip(3);
        List<Integer> numbersList2 = numberStream2.collect(Collectors.toList());
        numbersList2.forEach((Integer i) -> System.out.print(i + " "));
        System.out.println();

        System.out.println("\n Intermediate Stream methods");
        System.out.println("9. mapToInt()");

        List<String> numbers3 = Arrays.asList("2", "1", "3", "4", "6");
        IntStream numberStream3 = numbers3.stream().mapToInt((String val) -> Integer.parseInt(val));
        int [] numberArray = numberStream3.toArray();
        Arrays.stream(numberArray).forEach((int val) -> System.out.print(val + " "));
        System.out.println();
        int[] numbersArray1 = {2, 1, 4, 7};
        IntStream numbersStream1 = Arrays.stream(numbersArray1);
        int[] filteredNumbers = numbersStream1.filter((int val) -> val > 2).toArray();
        Arrays.stream(filteredNumbers).forEach((int val) -> System.out.print(val + " "));

        System.out.println();

        /**
         *  SEQUENCE OF STREAM OPERATION
         */

        System.out.println(" ------------ sequence of stream operation ------------ ");
        List<Integer> nos = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> nosStream = nos.stream()
                .filter((Integer val) -> val >=3)
                .peek((Integer val) -> System.out.println(" after filtering: " + val))
                .map((Integer val) -> (val * -1))
                .peek((Integer val) -> System.out.println(" after negating: " + val))
                .sorted()
                .peek((Integer val) -> System.out.println(" after sorting: " + val));

        List<Integer> filteredNosStream = nosStream.collect(Collectors.toList());
//        filteredNosStream.forEach((Integer val) -> System.out.println(val));
        System.out.println(filteredNosStream);


        /**
         *  Terminal Operations
         */

        System.out.println(" Terminal Operations ");
        System.out.println("1. forEach()");

        List<Integer> listOne = Arrays.asList(2, 1, 4, 7, 10);
        listOne.stream()
                .filter((Integer val) -> val >= 3)
                .forEach((Integer val) -> System.out.println(val));


        System.out.println(" Terminal Operations ");
        System.out.println("2. toArray()");

        List<Integer> randomNos = Arrays.asList(2, 1, 4, 7, 10);
        Object[] filteredNosArray = randomNos.stream()
                .filter((Integer val) -> val >= 3)
                .toArray(); // by default returns object array
        System.out.println(Arrays.toString(filteredNosArray));


        Integer [] filteredNosArray2 = randomNos.stream()
                .filter((Integer val) -> val >= 3)
                .toArray((int size) -> new Integer[size]); // to return specific data type array
        System.out.println(Arrays.toString(filteredNosArray2));

        System.out.println(" Terminal Operations ");
        System.out.println("3. reduce()");

        Optional<Integer> reducedValue = randomNos.stream()
                .reduce((Integer val1, Integer val2) -> val1 + val2);
        System.out.println(reducedValue.get());


        System.out.println(" Terminal Operations ");
        System.out.println("4.Min() and Max()");
        List<Integer> randomList = Arrays.asList(12, 2, 44, 29, 3);
        Optional<Integer> minValueType1 = randomList.stream()
                .filter((Integer val) -> val > 3)
                .min((Integer val1, Integer val2) -> val1 - val2);
        System.out.println(minValueType1.get());
        // basically min is the wrong word for this method, this method actually gives the first element of the sorted stream
        // so by default we have natural ordering as ascending
        Optional<Integer> minValueType2 = randomList.stream()
                .filter((Integer val) -> val > 3)
                .min((Integer val1, Integer val2) -> val2 - val1);
        System.out.println(minValueType2.get());

        Optional<Integer> maxValueType1 = randomList.stream()
                .filter((Integer val) -> val > 3)
                .max((Integer val1, Integer val2) -> val1 - val2);
        System.out.println(maxValueType1.get());
        // returns first element of the decreasing order sorted stream


        Optional<Integer> maxValueType2 = randomList.stream()
                .filter((Integer val) -> val > 3)
                .max((Integer val1, Integer val2) -> val2 - val1);
        System.out.println(maxValueType2.get());


        System.out.println(" Terminal Operations ");
        System.out.println("5. collect()");

        List<Integer> collectNos = Arrays.asList(5, 22, 11, 9);
        List<Integer> filteredCollectNos = collectNos.stream()
                .filter((Integer val) -> val > 3)
                .collect(Collectors.toList());
        System.out.println(filteredCollectNos);

        System.out.println(" Terminal Operations ");
        System.out.println("6. count()");
        List<Integer> numList = Arrays.asList(5, 4, 43, 32 ,11);
        long noOfValuesPresent = numList.stream().filter((Integer val1) -> val1 > 5)
                .count();
        System.out.println(noOfValuesPresent);

        System.out.println(" Terminal Operations ");
        System.out.println("7. anyMatch()");

        boolean hasValue = numList.stream().anyMatch((Integer val1) -> val1 > 3);
        System.out.println(hasValue);

        System.out.println(" Terminal Operations ");
        System.out.println("8. allMatch()");

        boolean hasValue1 = numList.stream().allMatch((Integer val1) -> val1 > 89);
        System.out.println(hasValue1);

        System.out.println(" Terminal Operations ");
        System.out.println("9. noneMatch()");

        boolean hasValue2 = numList.stream().noneMatch((Integer val1) -> val1 > 89);
        System.out.println(hasValue2);

        System.out.println(" Terminal Operations ");
        System.out.println("10. findFirst()");

        Optional<Integer> firstValue = numList.stream().filter((Integer val) -> val >= 5)
                .findFirst();
        System.out.println(firstValue.get());

        System.out.println(" Terminal Operations ");
        System.out.println("11. findAny()");

        Optional<Integer> anyValue = numList.stream().filter((Integer val) -> val >= 5)
                .findAny();
        System.out.println(anyValue.get());

        /**
         *   Sequential and Parallel processing of streams
         */

        List<Integer> nList = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);
        // Sequential processing
        long sequentialProcessingTime = System.currentTimeMillis();
        nList.stream()
                .map((Integer val) -> val * val)
                .forEach((Integer val) -> System.out.print(val + " "));
        System.out.println(" Sequential processing time taken: " + (System.currentTimeMillis() - sequentialProcessingTime) + " milliseconds");

        // parallel processing
        List<Integer> nList1 = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);
        long parallelProcessingTime = System.currentTimeMillis();
        nList1.parallelStream()
                .map((Integer val) -> val * val)
                .forEach((Integer val) -> System.out.print(val + " "));
        System.out.println(" Parallel processing time taken: " + (System.currentTimeMillis() - parallelProcessingTime) + " milliseconds");


    }
}
