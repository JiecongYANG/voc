import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.python.stdlib.datetime.Date;
import org.python.exceptions.ValueError;
import org.python.types.Int;
import java.util.Map;
import java.util.TimeZone;
import java.util.HashMap;
import java.util.Calendar;

public class DateTest {
    // Testing if creating a specified date works
    @Test
    public void testCreateDate() {
        org.python.Object[] args = { org.python.types.Int.getInt(2021), org.python.types.Int.getInt(9),
                org.python.types.Int.getInt(16), };
        Map kwargs = new HashMap<java.lang.String, org.python.Object>();
        Date date = new Date(args, kwargs);
        assertEquals(date.year, args[0]);
        assertEquals(date.month, args[1]);
        assertEquals(date.day, args[2]);
    }

    // Testing if today's date works
    @Test
    public void testToday() {
        org.python.Object[] args = {};
        Map kwargs = new HashMap<java.lang.String, org.python.Object>();
        Date today = new Date(args, kwargs);
        java.util.Date javaToday = new java.util.Date();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Stockholm"));
        calendar.setTime(javaToday);
        assertEquals(today.year, cal.get(Calendar.YEAR));
        assertEquals(today.month, Int.getInt(cal.get(Calendar.MONTH) + 1));
        assertEquals(today.day, cal.get(Calendar.DAY_OF_MONTH));
    }
}
