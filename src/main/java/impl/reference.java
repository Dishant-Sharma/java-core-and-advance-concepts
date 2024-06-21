import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class reference {
        public static void printLogValues(List<Integer>... logNumberList){ // logNumberList is varargs
            Object [] objectList = logNumberList;
            List<String> stringValList = new ArrayList<>();
            stringValList.add("Hello");
            objectList[0] = stringValList;
        }
}
