package voc;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ListPerformanceTest {
    public static org.python.types.List py_list_from_java_ints(Integer... ns) {
        java.util.List<org.python.Object> list_of_ints = Arrays.stream(ns).map(n -> org.python.types.Int.getInt(n)).collect(Collectors.toList());
        return new org.python.types.List(list_of_ints);
    }

    org.python.types.List java_list = py_list_from_java_ints();

    @Test
    public void testList_contain() {
        System.out.println("__contains__");

        for(int i = 0; i < 100000; i++) {
            java_list.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
        }

        for(int i = 100000; i < 100100; i++) {
            java_list.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(100000));
        }
        //System.out.println(java_list);
        System.out.println(java_list.__contains__(org.python.types.Int.getInt(100000)));
        //not contain
        System.out.println(java_list.__contains__(org.python.types.Int.getInt(200000)));
        System.out.println(java_list.__contains__(org.python.types.Int.getInt(5000)));
    }

    @Test
    public void testList_extend_performance() {
        System.out.println("extend performance");

        for(int i = 0; i < 100000; i++) {
            java_list.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
        }

        for(int i = 0; i < 30000; i++){
            java_list.extend(new org.python.types.Str("abcdefg"));
        }

        for(int i = 0; i < 30000; i++){
            java_list.extend(new org.python.types.Range(org.python.types.Int.getInt(10)));
        }

        byte[] b={ 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 0; i < 30000; i++){
            java_list.extend(new org.python.types.Bytes(b));
        }

        for(int i = 0; i < 30000; i++){
            java_list.extend(new org.python.types.ByteArray(b));
        }
    }

    @Test
    public void testList_extend_check() {
        System.out.println("extend check");
        for(int i = 0; i < 10; i++) {
            java_list.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
        }
        System.out.println(java_list);
        java_list.extend(new org.python.types.Str("abcdefg"));
        System.out.println(java_list);
        java_list.extend(new org.python.types.Range(org.python.types.Int.getInt(10)));
        System.out.println(java_list);
        byte[] b={ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        java_list.extend(new org.python.types.Bytes(b));
        System.out.println(java_list);
        java_list.extend(new org.python.types.ByteArray(b));
        System.out.println(java_list);
    }
}
