import org.junit.Test;
import static org.junit.Assert.*;
import org.python.stdlib.datetime.Date;
import org.python.exceptions.TypeError;
import org.python.exceptions.ValueError;
import org.python.types.*;
import java.util.Map;
import java.util.TimeZone;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Collections;

import java.util.*;

public class DateTest {
    // Testing if creating a specified date works
    @Test
    public void testCreateDate() {
        org.python.Object[] args = {
            Int.getInt(2021),
            Int.getInt(12),
            Int.getInt(21),
        };
        Date date = new Date(args, Collections.EMPTY_MAP);
        assertEquals(date.year, args[0]);
        assertEquals(date.month, args[1]);
        assertEquals(date.day, args[2]);
    }

    // Testing if today's date works
    @Test
    public void testToday() {
        Date dateToday = (Date) Date.today();
        java.util.Date javaUtilToday = new java.util.Date();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Stockholm"));
        calendar.setTime(javaUtilToday);
        assertEquals(dateToday.year, Int.getInt(calendar.get(Calendar.YEAR)));
        assertEquals(dateToday.month, Int.getInt(calendar.get(Calendar.MONTH) + 1));
        assertEquals(dateToday.day, Int.getInt(calendar.get(Calendar.DAY_OF_MONTH)));
    }

    // Testing week of the day, date.weekday is day of the week as a number with m
    // Monday(0)-Sunday(6)
    @Test
    public void testWeek() {
        org.python.Object[] args = {
            Int.getInt(2021),
            Int.getInt(9),
            Int.getInt(21),
        };
        Date date = new Date(args, Collections.EMPTY_MAP);

        assertEquals(date.weekday(), Int.getInt(1));
    }
    // Test of Isoweekday, Return the day of the week as an integer, where Monday is 1 and Sunday is 7.
    @Test
    public void testIsoWeekday() {
        org.python.Object[] args = {
            Int.getInt(2021),
            Int.getInt(9),
            Int.getInt(21),
        };
        Date date = new Date(args, Collections.EMPTY_MAP);

        assertEquals(date.isoweekday(), Int.getInt(2));
    }
    @Test
    public void testCTime() {
        org.python.Object[] args = {
            Int.getInt(2012),
            Int.getInt(12),
            Int.getInt(21),
        };
        Date date = new Date(args, Collections.EMPTY_MAP);
        assertEquals(date.ctime(), new Str("Fri Dec  21 00:00:00 2012"));
    }

    @Test
    public void testFromIsoFormat() {
        Date date1 = Date.fromisoformat(new Str("2012-12-21"));
        assertEquals(date1.year, Int.getInt(2012));
        assertEquals(date1.month, Int.getInt(12));
        assertEquals(date1.day, Int.getInt(21));

        Date date2 = Date.fromisoformat(new Str("1996-04-28"));
        assertEquals(date2.year, Int.getInt(1996));
        assertEquals(date2.month, Int.getInt(04));
        assertEquals(date2.day, Int.getInt(28));

        Date date3 = Date.fromisoformat(new Str("2021-09-20"));
        assertNotEquals(date3.year, Int.getInt(2022));
        assertNotEquals(date3.month, Int.getInt(10));
        assertNotEquals(date3.day, Int.getInt(29));
    }
    @Test()
    public void testCompare() {

        org.python.Object[] args = {
            Int.getInt(2012),
            Int.getInt(12),
            Int.getInt(21),
        };
        Date date = new Date(args, Collections.EMPTY_MAP);
        assertTrue(date.__eq__(date).toBoolean());
        assertFalse(date.__neq__(date).toBoolean());
        assertFalse(date.__gt__(date).toBoolean());
        assertFalse(date.__lt__(date).toBoolean());
        assertTrue(date.__ge__(date).toBoolean());
        assertTrue(date.__le__(date).toBoolean());

        org.python.Object[] args1 = {
            Int.getInt(2021),
            Int.getInt(9),
            Int.getInt(20),
        };
        Date date1 = new Date(args1, Collections.EMPTY_MAP);

        assertFalse(date.__eq__(date1).toBoolean());
        assertTrue(date.__neq__(date1).toBoolean());
        assertFalse(date.__gt__(date1).toBoolean());
        assertTrue(date.__lt__(date1).toBoolean());
        assertFalse(date.__ge__(date1).toBoolean());
        assertTrue(date.__le__(date1).toBoolean());

    }

    @Test(expected = TypeError.class)
    public void testTooFewArguments() {
        org.python.Object[] args = {
            Int.getInt(2012),
            Int.getInt(12),
        };
        new Date(args, Collections.EMPTY_MAP);
    }

    @Test(expected = ValueError.class)
    public void testInvalidValue() {
        org.python.Object[] args = {
            Int.getInt(2012),
            Int.getInt(100),
            Int.getInt(21),
        };
       new Date(args, Collections.EMPTY_MAP);
    }

    @Test
    public void testKwargs() {
        Map<java.lang.String, org.python.Object> kwargs = new HashMap();
        org.python.Object[] args = {};

        kwargs.put("year", Int.getInt(2012));
        kwargs.put("month", Int.getInt(12));
        kwargs.put("day", Int.getInt(21));

        Date date = new Date(args, kwargs);
        org.python.types.Int year = (Int) kwargs.get("year");
        org.python.types.Int month = (Int) kwargs.get("month");
        org.python.types.Int day = (Int) kwargs.get("day");

        assertEquals(date.year, year);
        assertEquals(date.month, month);
        assertEquals(date.day, day);
    }

}
