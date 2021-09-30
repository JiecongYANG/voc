import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListPerformanceRemove {
    public static org.python.types.List py_list_from_java_ints(Integer... ns) {
        java.util.List<org.python.Object> list_of_ints = Arrays.stream(ns).map(n -> org.python.types.Int.getInt(n)).collect(Collectors.toList());
        return new org.python.types.List(list_of_ints);
    }

    @Test
    public void testList_remove() {
        org.python.types.List java_list = py_list_from_java_ints();

        for(int i = 0; i < 200000; i++) {
            java_list.append(org.python.types.Int.getInt(i));
        }
        System.out.println("Remove");
        for(int i = 0; i < 200000; i++) {
            java_list.remove(org.python.types.Int.getInt(i));
        }

    }
}
