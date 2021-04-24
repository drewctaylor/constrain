package io.github.drewctaylor.constrain.number;

import static io.github.drewctaylor.require.RequireNumberDouble.requireNegative;
import static io.github.drewctaylor.require.RequireNumberDouble.requirePositive;
import static io.github.drewctaylor.require.RequireNumberDouble.requireZero;
import static io.github.drewctaylor.require.RequireNumberDouble.requireZeroOrNegative;
import static io.github.drewctaylor.require.RequireNumberDouble.requireZeroOrPositive;

/**
 * Constrain a double to be positive, negative, or zero.
 */
public final class ConstrainNumberDouble
{
    private ConstrainNumberDouble()
    {
    }

    private static final ConstrainNumberHelper<Double> constrainNumberHelper = new ConstrainNumberHelper<>();

    /**
     * Constrain the given value, if positive; otherwise, throw an IllegalArgumentException.
     *
     * @param  value                    the given value
     * @param  name                     the name of the given value
     * 
     * @return                          the given value if positive
     * 
     * @throws NullPointerException     if value is null
     * @throws IllegalArgumentException if value is not positive
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is blank
     */
    public static Positive<Double> constrainPositive(
            final Double value,
            final String name)
    {
        return constrainNumberHelper.constrainPositive(requirePositive(value, name));
    }

    /**
     * Constrain the given value, if zero or positive; otherwise, throw an IllegalArgumentException.
     *
     * @param  value                    the given value
     * @param  name                     the name of the given value
     * 
     * @return                          the given value if zero or positive
     * 
     * @throws NullPointerException     if value is null
     * @throws IllegalArgumentException if value is not zero or not positive
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is blank
     */
    public static ZeroOrPositive<Double> constrainZeroOrPositive(
            final Double value,
            final String name)
    {
        return constrainNumberHelper.constrainZeroOrPositive(requireZeroOrPositive(value, name));
    }

    /**
     * Constrain the given value, if zero; otherwise, throw an IllegalArgumentException.
     *
     * @param  value                    the given value
     * @param  name                     the name of the given value
     * 
     * @return                          the given value if zero
     * 
     * @throws NullPointerException     if value is null
     * @throws IllegalArgumentException if value is not zero
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is blank
     */
    public static Zero<Double> constrainZero(
            final Double value,
            final String name)
    {
        return constrainNumberHelper.constrainZero(requireZero(value, name));
    }

    /**
     * Constrain the given value, if zero or negative; otherwise, throw an IllegalArgumentException.
     *
     * @param  value                    the given value
     * @param  name                     the name of the given value
     * 
     * @return                          the given value if zero or negative
     * 
     * @throws NullPointerException     if value is null
     * @throws IllegalArgumentException if value is not zero or not negative
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is blank
     */
    public static ZeroOrNegative<Double> constrainZeroOrNegative(
            final Double value,
            final String name)
    {
        return constrainNumberHelper.constrainZeroOrNegative(requireZeroOrNegative(value, name));
    }

    /**
     * Constrain the given value, if negative; otherwise, throw an IllegalArgumentException.
     *
     * @param  value                    the given value
     * @param  name                     the name of the given value
     * 
     * @return                          the given value if negative
     * 
     * @throws NullPointerException     if value is null
     * @throws IllegalArgumentException if value is not negative
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is blank
     */
    public static Negative<Double> constrainNegative(
            final Double value,
            final String name)
    {
        return constrainNumberHelper.constrainNegative(requireNegative(value, name));
    }
}
