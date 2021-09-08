package python;

@org.python.Module(
    __doc__ = "Various math functions.\n"
)

public class math extends org.python.types.Module {
    public math() {
        super();
    }

    @org.python.Method(
        __doc__ = "Return x factorial as an integer.\n",
        args = {"value"}
    )
    public static org.python.Object factorial(org.python.Object value) {
        int counter, f = 1;
        long x = 0;

        if (value instanceof org.python.types.Int && ((org.python.types.Int)value).value >= 0) {
            x = ((org.python.types.Int)value).value;
            for (counter = 1; counter <= (int)x; counter++) {
                f = f*counter;
            }
        } else {
            throw new org.python.exceptions.ValueError("Value needs to be of type Int and non negative.");
        }

        return org.python.types.Int.getInt(f);
    }
}
