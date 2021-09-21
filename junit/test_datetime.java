import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.python.exceptions.SyntaxError;
import org.python.stdlib.datetime.DateTime;
import org.python.stdlib.datetime.Date;
import java.util.Collections;
import java.util.*;

public class test_datetime {

    org.python.types.Int y = org.python.types.Int.getInt(100);
    org.python.types.Int m = org.python.types.Int.getInt(2);
    org.python.types.Int d = org.python.types.Int.getInt(3);
    org.python.Object[] args1 = {y, m, d};
    DateTime datetime1 = new DateTime(args1,  Collections.emptyMap());

    org.python.types.Int year = org.python.types.Int.getInt(2012);
    org.python.types.Int month = org.python.types.Int.getInt(2);
    org.python.types.Int day = org.python.types.Int.getInt(14);
    org.python.types.Int hour = org.python.types.Int.getInt(16);
    org.python.types.Int minute = org.python.types.Int.getInt(45);
    org.python.types.Int second = org.python.types.Int.getInt(11);
    org.python.types.Int microsecond = org.python.types.Int.getInt(12496);
    org.python.Object[] args2 = { year, month, day, hour, minute, second, microsecond };
    DateTime datetime2 = new DateTime(args2,  Collections.emptyMap());

    HashMap<String, org.python.Object> hm = new HashMap<String, org.python.Object>();

    @BeforeEach
    public void setUp() {
        hm.clear();
    }

    @Test
    public void test_DateTime_args() {
        assertEquals(new org.python.types.Str("100"), datetime1.__year__());
        assertEquals(new org.python.types.Str("2012-02-14 16:45:11.012496"), datetime2.__str__());
    }

    @Test
    public void test_DateTime_kwargs() {
        hm.put("year", year);
        hm.put("month", month);
        hm.put("hour", hour);
        hm.put("day", day);
        hm.put("minute", minute);
        hm.put("second", second);
        hm.put("microsecond", microsecond);

        org.python.Object[] empty = new org.python.Object[0];

        DateTime datetime3 = new DateTime(empty, hm);
        assertEquals(new org.python.types.Str("2012"), datetime3.__year__());
        assertEquals(new org.python.types.Str("2012-02-14 16:45:11.012496"), datetime3.__str__());
    }

    @Test
    public void test_DateTime_args_kwargs_combined() {
        org.python.Object[] args3 = { year, month, day };
        hm.put("hour", hour);
        hm.put("minute", minute);
        hm.put("second", second);
        hm.put("microsecond", microsecond);

        DateTime datetime3 = new DateTime(args3,  hm);
        assertEquals(new org.python.types.Str("2012-02-14 16:45:11.012496"), datetime3.__str__());
    }

    @Test
    public void test_DateTime_syntaxerror() {
        try {
            org.python.Object[] args4 = { year, month, day };
            org.python.types.Int year1 = org.python.types.Int.getInt(2014);
            hm.put("year", year1);
            hm.put("hour", hour);
            hm.put("minute", minute);
            hm.put("second", second);
            hm.put("microsecond", microsecond);
            DateTime datetime3 = new DateTime(args4,  hm);
            fail("Exception not thrown");
        } catch (SyntaxError e) {
            assertEquals("positional argument follows keyword argument", e.getMessage());
        }
    }

    @Test
    public void test_DateTime_date() {
        org.python.Object datetime3 = DateTime.today();
        assertEquals(new org.python.types.Str("2021"), ((DateTime) datetime3).year);
    }

    @Test
    public void test_DateTime_weekday() {
        assertEquals(new org.python.types.Str("1").__int__(), datetime2.weekday());
    }

    @Test
    public void test_DateTime_kwargs_invalid() {
        try {
        org.python.Object invalid = new org.python.types.Str("2012");
        hm.put("year", invalid);
        hm.put("month", month);
        hm.put("hour", hour);
        hm.put("day", day);
        hm.put("minute", minute);
        hm.put("second", second);
        hm.put("microsecond", microsecond);
        org.python.Object[] empty = new org.python.Object[0];
        DateTime datetime3 = new DateTime(empty,  hm);
        fail("Exception not thrown");
        } catch (Exception e) {
            assertTrue(e instanceof ClassCastException);
        }
    }

    @Test
    public void test_DateTime_eq() {
        assertEquals(org.python.types.Bool.TRUE, datetime2.__eq__(datetime2));
        assertEquals(org.python.types.Bool.FALSE, datetime2.__eq__(datetime1));

    }

    @Test
    public void test_DateTime_le() {
        assertEquals(org.python.types.Bool.TRUE, datetime2.__le__(datetime2));
        assertEquals(org.python.types.Bool.FALSE, datetime2.__le__(datetime1));
        assertEquals(org.python.types.Bool.TRUE, datetime1.__le__(datetime2));
    }

    @Test
    public void test_DateTime_lt() {
        assertEquals(org.python.types.Bool.FALSE, datetime2.__lt__(datetime2));
        assertEquals(org.python.types.Bool.FALSE, datetime2.__lt__(datetime1));
        assertEquals(org.python.types.Bool.TRUE, datetime1.__lt__(datetime2));
    }

    @Test
    public void test_DateTime_gt() {
        assertEquals(org.python.types.Bool.FALSE, datetime2.__gt__(datetime2));
        assertEquals(org.python.types.Bool.TRUE, datetime2.__gt__(datetime1));
        assertEquals(org.python.types.Bool.FALSE, datetime1.__gt__(datetime2));
    }

    @Test
    public void test_DateTime_ge() {
        assertEquals(org.python.types.Bool.TRUE, datetime2.__ge__(datetime2));
        assertEquals(org.python.types.Bool.TRUE, datetime2.__ge__(datetime1));
        assertEquals(org.python.types.Bool.FALSE, datetime1.__ge__(datetime2));
    }

    @Test
    public void test_DateTime_comparison_invalid() {
        org.python.types.Str invalid = new org.python.types.Str("Invalid");
        assertEquals(org.python.types.NotImplementedType.NOT_IMPLEMENTED, datetime2.__ge__(invalid));
    }

    @Test
    public void test_DateTime_combine() {
        Date date = new Date(args1,  Collections.emptyMap());
        org.python.Object test = DateTime.combine(date, null);
        assertEquals(new org.python.types.Str("100"), ((DateTime) test).__year__());
        assertEquals(new org.python.types.Str("2"), ((DateTime) test).__month__());
    }

    @Test
    public void test_DateTime_replace() {
        org.python.Object comp = datetime2.replace(y, null, null, null, null, null, null);
        assertEquals(new org.python.types.Str("100"), ((DateTime) comp).__year__());
        assertEquals(new org.python.types.Str("2"), ((DateTime) comp).__month__());
    }

}
