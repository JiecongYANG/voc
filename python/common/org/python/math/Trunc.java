package org.python.math;

public class Trunc extends org.python.types.Object {
    public static double trunc(double value) {
        return value < 0 ? Math.ceil(value) : Math.floor(value);
    }
}
