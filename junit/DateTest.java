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
            Int.getInt(2021), // year
            Int.getInt(12), // month
            Int.getInt(21), // day
        };
        Date date = new Date(args, Collections.EMPTY_MAP);
        assertEquals(date.year, args[0]);
        assertEquals(date.month, args[1]);
        assertEquals(date.day, args[2]);
    }

    // Testing if today's date works
    @Test
    public void testToday() {
        Date today = (Date) Date.today();
        java.util.Date javaToday = new java.util.Date();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Stockholm"));
        calendar.setTime(javaToday);
        assertEquals(today.year, Int.getInt(calendar.get(Calendar.YEAR)));
        assertEquals(today.month, Int.getInt(calendar.get(Calendar.MONTH) + 1));
        assertEquals(today.day, Int.getInt(calendar.get(Calendar.DAY_OF_MONTH)));
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

    @Test
    public void testCTime() {
        org.python.Object[] args = {
            Int.getInt(2012), ///year
            Int.getInt(12), // month
            Int.getInt(21), // day
        };
        Date d = new Date(args, Collections.EMPTY_MAP);
        assertEquals(d.ctime(), new Str("Fri Dec  21 00:00:00 2012"));
    }


}
