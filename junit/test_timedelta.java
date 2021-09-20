import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.HashMap;
import java.util.Map;
import org.python.exceptions.*;
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
    public void test_TimeDelta_args_different_length() {
        org.python.types.Int days0 = org.python.types.Int.getInt(100);
        org.python.types.Int seconds0 = org.python.types.Int.getInt(2);
        org.python.types.Int microseconds0 = org.python.types.Int.getInt(3);
        org.python.Object[] args0 = {days0, seconds0, microseconds0};
        TimeDelta timedelta0 = new TimeDelta(args0,  Collections.emptyMap());

        org.python.Object[] args1 = {days0, seconds0};
        org.python.Object[] args2 = {days0};
        TimeDelta timedelta1 = new TimeDelta(args1,  Collections.emptyMap());
        TimeDelta timedelta2 = new TimeDelta(args2,  Collections.emptyMap());

    }

    @Test
    public void test_TimeDelta_args_invalid_2() {
        try
        {
            hm.put("millisecondsxxx", milliseconds2);
            hm.put("minutes", minutes2);
            hm.put("hours", hours2);
            hm.put("weeks", weeks2);
            TimeDelta timedelta2 = new TimeDelta(args1,  hm);
        }
        catch (TypeError e)
        {
            assertEquals("millisecondsxxx is an invalid keuword argument for this function", e.getMessage());
        }
        try
        {
            org.python.Object[] args1 = {days1, days1, days1, seconds1, seconds1, seconds1, microseconds1,microseconds1, microseconds1,microseconds1};
            TimeDelta timedelta2 = new TimeDelta(args1, Collections.emptyMap());
        }
        catch (TypeError e)
        {
            assertEquals("__new__() takes at most 7 arguments (10 given)", e.getMessage());
        }
    }

    @Test
    public void test_TimeDelta_args_invalid_3() {
        try
        {
            hm.put("days", days1);
            hm.put("seconds", seconds1);
            hm.put("microseconds", microseconds1);
            TimeDelta timedelta2 = new TimeDelta(args1,  hm);
        }
        catch (TypeError e)
        {
            assertEquals("Argument given by name ('days') and position (1)", e.getMessage());
        }

        try
        {
            hm.clear();
            hm.put("seconds", seconds1);
            hm.put("microseconds", microseconds1);
            TimeDelta timedelta2 = new TimeDelta(args1,  hm);
        }
        catch (TypeError e)
        {
            assertEquals("Argument given by name ('seconds') and position (2)", e.getMessage());
        }

        try
        {
            hm.clear();
            hm.put("microseconds", microseconds1);
            TimeDelta timedelta2 = new TimeDelta(args1,  hm);
        }
        catch (TypeError e)
        {
            assertEquals("Argument given by name ('microseconds') and position (3)", e.getMessage());
        }
        

    }

    @Test
    public void test_TimeDelta_args() {
        assertEquals(new org.python.types.Str("100"), timedelta0.__days__());
        assertEquals(new org.python.types.Str("2"), timedelta0.__seconds__());
        assertEquals(new org.python.types.Str("3"), timedelta0.__microseconds__());
        assertEquals(new org.python.types.Str("-999999999 days, 0:00:00"), timedelta0.__min__());
        assertEquals(new org.python.types.Str("999999999 days, 23:59:59.999999"), timedelta0.__max__());
        assertEquals(new org.python.types.Str("0:00:00.000001"), timedelta0.__resolution__());
    }
    @Test
    public void test_TimeDelta_total_seconds() {
        org.python.types.Int days0 = org.python.types.Int.getInt(100);
        org.python.types.Int seconds0 = org.python.types.Int.getInt(2);
        org.python.types.Int microseconds0 = org.python.types.Int.getInt(3);
        org.python.Object[] args0 = {days0, seconds0, microseconds0};
        TimeDelta timedelta0 = new TimeDelta(args0,  Collections.emptyMap());
        assertEquals(new org.python.types.Str("8640002.000003"), timedelta0.total_seconds());

        org.python.types.Int microseconds01 = org.python.types.Int.getInt(30);
        org.python.Object[] args01 = {days0, seconds0, microseconds01};
        TimeDelta timedelta01 = new TimeDelta(args01,  Collections.emptyMap());
        assertEquals(new org.python.types.Str("8640002.000030"), timedelta01.total_seconds());

        org.python.types.Int microseconds02 = org.python.types.Int.getInt(300);
        org.python.Object[] args02 = {days0, seconds0, microseconds02};
        TimeDelta timedelta02 = new TimeDelta(args02,  Collections.emptyMap());
        assertEquals(new org.python.types.Str("8640002.000300"), timedelta02.total_seconds());

        org.python.types.Int microseconds03 = org.python.types.Int.getInt(3000);
        org.python.Object[] args03 = {days0, seconds0, microseconds03};
        TimeDelta timedelta03 = new TimeDelta(args03,  Collections.emptyMap());
        assertEquals(new org.python.types.Str("8640002.003000"), timedelta03.total_seconds());

        org.python.types.Int microseconds04 = org.python.types.Int.getInt(30000);
        org.python.Object[] args04 = {days0, seconds0, microseconds04};
        TimeDelta timedelta04 = new TimeDelta(args04,  Collections.emptyMap());
        assertEquals(new org.python.types.Str("8640002.030000"), timedelta04.total_seconds());

        org.python.types.Int microseconds05 = org.python.types.Int.getInt(300000);
        org.python.Object[] args05 = {days0, seconds0, microseconds05};
        TimeDelta timedelta05 = new TimeDelta(args05,  Collections.emptyMap());
        assertEquals(new org.python.types.Str("8640002.300000"), timedelta05.total_seconds());

        org.python.types.Int microseconds06 = org.python.types.Int.getInt(0);
        org.python.Object[] args06 = {days0, seconds0, microseconds06};
        TimeDelta timedelta06 = new TimeDelta(args06,  Collections.emptyMap());
        assertEquals(new org.python.types.Str("8640002.0"), timedelta06.total_seconds());

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
    public void test_TimeDelta_gt() {
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__gt__(timedelta1));
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__gt__(timedelta0));
        assertEquals(org.python.types.Bool.FALSE, timedelta0.__gt__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__gt__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_TimeDelta_lt() {
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__lt__(timedelta1));
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__lt__(timedelta0));
        assertEquals(org.python.types.Bool.TRUE, timedelta0.__lt__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__lt__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_TimeDelta_ge() {
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__ge__(timedelta1));
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__ge__(timedelta0));
        assertEquals(org.python.types.Bool.FALSE, timedelta0.__ge__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__ge__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_TimeDelta_le() {
        assertEquals(org.python.types.Bool.TRUE, timedelta1.__le__(timedelta1));
        assertEquals(org.python.types.Bool.FALSE, timedelta1.__le__(timedelta0));
        assertEquals(org.python.types.Bool.TRUE, timedelta0.__le__(timedelta1));

        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, timedelta0.__le__(new org.python.types.Str("invalidInput")));
    }
    
    @Test
    public void test_TimeDelta_pos() {
        TimeDelta timeDeltaPos = (TimeDelta)timedelta0.__pos__();

        assertEquals(timedelta0.__days__(), timeDeltaPos.__days__());
        assertEquals(timedelta0.__seconds__(), timeDeltaPos.__seconds__());
        assertEquals(timedelta0.__microseconds__(), timeDeltaPos.__microseconds__());
    }

    @Test
    public void test_TimeDelta_str() {
        org.python.types.Str days = timedelta0.__days__();
        org.python.types.Str seconds = timedelta0.__seconds__();
        org.python.types.Str microseconds = timedelta0.__microseconds__();
        String timeDeltaStr = days + " days, " + "seconds: " + seconds + ", microseconds: " + microseconds;
        
        assertEquals(new org.python.types.Str(timeDeltaStr), timedelta0.__str__());
    }

    @Test
    public void test_TimeDelta_add() {
        TimeDelta timeDeltaSum = (TimeDelta)timedelta0.__add__(timedelta1);

        assertEquals(
            new org.python.types.Str(Long.toString(100 + 200)),
            timeDeltaSum.__days__());
        assertEquals(
            new org.python.types.Str(Long.toString(2 + 4)),
            timeDeltaSum.__seconds__());
        assertEquals(
            new org.python.types.Str(Long.toString(3 + 3)),
            timeDeltaSum.__microseconds__());

        assertThrows(ClassCastException.class, () -> {
            timedelta0.__add__(new org.python.types.Str("invalidInput"));
        });
    }

    @Test
    public void test_TimeDelta_sub() {
        TimeDelta timeDeltaDifference = (TimeDelta)timedelta1.__sub__(timedelta0);
        assertEquals(
            new org.python.types.Str(Long.toString(days1.value - days0.value)),
            timeDeltaDifference.__days__());
        assertEquals(
            new org.python.types.Str(Long.toString(seconds1.value - seconds0.value)),
            timeDeltaDifference.__seconds__());
        assertEquals(
            new org.python.types.Str(Long.toString(microseconds1.value - microseconds0.value)),
            timeDeltaDifference.__microseconds__());

        assertEquals(
            org.python.types.NotImplementedType.NOT_IMPLEMENTED,
            timedelta0.__sub__(new org.python.types.Str("invalidInput")));
    }

    @Test
    public void test_TimeDelta_mul_scalarGreaterThan1() {
        org.python.Object scalar = new org.python.types.Float(400000.0);
        TimeDelta timeDeltaProduct = (TimeDelta)timedelta0.__mul__(scalar);
        
        assertEquals(
            new org.python.types.Str(Long.toString((long)(9 + 100 * 400000.0))),
            timeDeltaProduct.__days__());
        assertEquals(
            new org.python.types.Str(Long.toString(22400 + 1)),
            timeDeltaProduct.__seconds__());
        assertEquals(
            new org.python.types.Str(Long.toString(200000)),
            timeDeltaProduct.__microseconds__());
    }

    @Test
    public void test_TimeDelta_mul_scalarLessThan1() {
        org.python.Object scalar = new org.python.types.Float(0.2);
        TimeDelta timeDeltaProduct = (TimeDelta)timedelta0.__mul__(scalar);
        
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.floor(100 * 0.2))),
            timeDeltaProduct.__days__());
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.floor(2 * 0.2))),
            timeDeltaProduct.__seconds__());
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.round(3 * 0.2 + 2 * 0.2 * 1000000))),
            timeDeltaProduct.__microseconds__());

        org.python.Object scalar2 = new org.python.types.Float(0.75);
        TimeDelta timeDeltaProduct2 = (TimeDelta)timedelta0.__mul__(scalar2);
        
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.floor(100 * 0.75))),
            timeDeltaProduct2.__days__());
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.floor(2 * 0.75))),
            timeDeltaProduct2.__seconds__());
        assertEquals(
            // Microseconds borrow 0.5 seconds.
            new org.python.types.Str(Long.toString((long)Math.round(3 * 0.75 + 0.5 * 1000000))),
            timeDeltaProduct2.__microseconds__());

        org.python.Object scalar3 = new org.python.types.Float(0.135);
        TimeDelta timeDeltaProduct3 = (TimeDelta)timedelta0.__mul__(scalar3);
        
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.floor(100 * 0.135))),
            timeDeltaProduct3.__days__());
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.floor(2 * 0.135 + 0.005 * 100 * 24 * 3600))),
            timeDeltaProduct3.__seconds__());
        assertEquals(
            new org.python.types.Str(Long.toString((long)Math.round(3 * 0.135 + 2 * 0.135 * 1000000))),
            timeDeltaProduct3.__microseconds__());
    }

    @Test
    public void test_TimeDelta_mul_intScalar() {
        org.python.Object scalar = org.python.types.Int.getInt(400000);
        TimeDelta timeDeltaProduct = (TimeDelta)timedelta0.__mul__(scalar);
        
        assertEquals(
            new org.python.types.Str(Long.toString((long)(9 + 100 * 400000))),
            timeDeltaProduct.__days__());
        assertEquals(
            new org.python.types.Str(Long.toString(22400 + 1)),
            timeDeltaProduct.__seconds__());
        assertEquals(
            new org.python.types.Str(Long.toString(200000)),
            timeDeltaProduct.__microseconds__());
    }

    @Test
    public void test_TimeDelta_mul_invalidScalar() {
        assertEquals(
            org.python.types.NotImplementedType.NOT_IMPLEMENTED,
            timedelta0.__mul__(new org.python.types.Str("invalid")));

        assertEquals(
            org.python.types.NotImplementedType.NOT_IMPLEMENTED,
            timedelta0.__mul__(new org.python.types.Float(-1.0)));
    }

    @Test
    public void test_TimeDelta_constant_4() {
        assertEquals(org.python.types.Int.getInt(4),TimeDelta.constant_4());
    }
}
