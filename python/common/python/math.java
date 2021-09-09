package python;

@org.python.Module(
    __doc__ = "Various math functions.\n"
)

public class math extends org.python.types.Module {
    public math() {
        super();
    }

    @org.python.Method(
        __doc__ = "Returns the Real value x truncated to an integer.\n",
        args = {"value"}
    )
    public static org.python.Object trunc(org.python.Object value) {
        double valueNumber = 0.0;

        if (value instanceof org.python.types.Float) {
            valueNumber = ((org.python.types.Float)value).value;
        } else if (value instanceof org.python.types.Int) {
            valueNumber = ((org.python.types.Int)value).value;
        } else {
            throw new org.python.exceptions.TypeError("value needs to be a number");
        } 

        return org.python.types.Int.getInt(valueNumber < 0 ? (int)Math.ceil(valueNumber) : (int)Math.floor(valueNumber));
    }

    @org.python.Method(
        __doc__ = "Return the absolute value of x\n",
        args = {"value"}
    )
    public static org.python.Object fabs(org.python.Object value) {
        double valueNumber = 0.0;

        if (value instanceof org.python.types.Float) {
            valueNumber = Math.abs(((org.python.types.Float)value).value);
        } else if (value instanceof org.python.types.Int) {
            valueNumber = Math.abs(((org.python.types.Int)value).value);
        } else {
            throw new org.python.exceptions.TypeError("not support input type");
        } 

        return new org.python.types.Float(valueNumber);
    }
}
