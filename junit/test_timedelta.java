import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.python.Object;
import org.python.types.*;
import org.python.stdlib.datetime.*;

import java.util.Collections;

public class test_timedelta {

    org.python.types.Int days0 = org.python.types.Int.getInt(100);
    org.python.types.Int seconds0 = org.python.types.Int.getInt(2);
    org.python.types.Int microseconds0 = org.python.types.Int.getInt(3);
    org.python.Object[] args0 = {days0, seconds0, microseconds0};
    TimeDelta timedelta0 = new TimeDelta(args0,  Collections.emptyMap());

    org.python.types.Int days1 = org.python.types.Int.getInt(200);
    org.python.types.Int seconds1 = org.python.types.Int.getInt(4);
    org.python.types.Int microseconds1 = org.python.types.Int.getInt(3);
    org.python.Object[] args1 = {days1, seconds1, microseconds1};
    TimeDelta timedelta1 = new TimeDelta(args1,  Collections.emptyMap());

    //org.python.types.Int days2 = org.python.types.Int.getInt(2012);
    //org.python.types.Int seconds2 = org.python.types.Int.getInt(2);
    //org.python.types.Int microseconds2 = org.python.types.Int.getInt(14);
    org.python.types.Int milliseconds2 = org.python.types.Int.getInt(16);
    org.python.types.Int minutes2 = org.python.types.Int.getInt(45);
    org.python.types.Int hours2 = org.python.types.Int.getInt(11);
    org.python.types.Int weeks2 = org.python.types.Int.getInt(12496);
    

    HashMap<String, org.python.Object> hm = new HashMap<String, org.python.Object>();

    @BeforeEach
    public void setUp() {
        hm.clear();
    }

    @Test
    public void test_TimeDelta_kwargs() {
        hm.put("milliseconds", milliseconds2);
        hm.put("minutes", minutes2);
        hm.put("hours", hours2);
        hm.put("weeks", weeks2);
        TimeDelta timedelta2 = new TimeDelta(args1,  hm);
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__eq__(timedelta2));
    }

    @Test
    public void test_TimeDelta_args() {
        assertEquals(new org.python.types.Str("100"), timedelta0.__days__());
        assertEquals(new org.python.types.Str("2"), timedelta0.__seconds__());
        assertEquals(new org.python.types.Str("3"), timedelta0.__microseconds__());
        assertEquals(new org.python.types.Str("-999999999 days, 0:00:00"), timedelta0.__min__());
        assertEquals(new org.python.types.Str("999999999 days, 23:59:59.999999"), timedelta0.__max__());
        assertEquals(new org.python.types.Str("0:00:00.000001"), timedelta0.__resolution__());
        assertEquals(new org.python.types.Str("8640002.000003"), timedelta0.total_seconds());
    }

    @Test
    public void test_TimeDelta_eq() {
        assertEquals(org.python.types.Bool.TRUE, timedelta0.__eq__(timedelta0));
        assertEquals(org.python.types.Bool.FALSE, timedelta0.__eq__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__eq__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_TimeDelta_neq() {
        assertEquals(org.python.types.Bool.FALSE, timedelta0.__neq__(timedelta0));
        assertEquals(org.python.types.Bool.TRUE, timedelta0.__neq__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__neq__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_DateTime_gt() {
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__gt__(timedelta1));
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__gt__(timedelta0));
        assertEquals(org.python.types.Bool.FALSE, timedelta0.__gt__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__gt__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_DateTime_lt() {
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__lt__(timedelta1));
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__lt__(timedelta0));
        assertEquals(org.python.types.Bool.TRUE, timedelta0.__lt__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__lt__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_DateTime_ge() {
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__ge__(timedelta1));
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__ge__(timedelta0));
        assertEquals(org.python.types.Bool.FALSE, timedelta0.__ge__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__ge__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_DateTime_le() {
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__le__(timedelta1));
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__le__(timedelta0));
        assertEquals(org.python.types.Bool.TRUE, timedelta0.__le__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__le__(new org.python.types.Str("invalidInput")));
    }




    @Test
    public void testInstantiation() {
        // Test simple instantiation using the constructor of TimeDelta.
        // See https://docs.python.org/3/library/datetime.html#datetime.timedelta
    }


    // TODO: Use test-driven development to implement 
    // - all comparison operations 
    // - choose two operations from: difference, multiplication, division, floor division, modulo, divmod    
    /*
    @Test
    public void testEqual() {
        assert(false);
    }

    @Test
    public void testNotEqual() {
        assert(false);
    }

    @Test
    public void testLessThan() {
        assert(false);
    }

    @Test
    public void testGreaterThan() {
        assert(false);
    }

    @Test
    public void testLessThanOrEqual() {
        assert(false);
    }

    @Test
    public void testGreaterThanOrEqual() {
        assert(false);
    }
    */
}
