package io.github.drewctaylor.constrain.number;

import java.math.BigDecimal;

import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireNegative;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requirePositive;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireZero;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireZeroOrNegative;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireZeroOrPositive;

/**
 * Constrain a BigDecimal to be positive, negative, or zero.
 */
public final class ConstrainNumberBigDecimal
{
    private ConstrainNumberBigDecimal()
    {
    }

    private static final ConstrainNumberHelper<BigDecimal> constrainNumberHelper = new ConstrainNumberHelper<>();

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
    public static Positive<BigDecimal> constrainPositive(
            final BigDecimal value,
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
    public static ZeroOrPositive<BigDecimal> constrainZeroOrPositive(
            final BigDecimal value,
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
    public static Zero<BigDecimal> constrainZero(
            final BigDecimal value,
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
    public static ZeroOrNegative<BigDecimal> constrainZeroOrNegative(
            final BigDecimal value,
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
    public static Negative<BigDecimal> constrainNegative(
            final BigDecimal value,
            final String name)
    {
        return constrainNumberHelper.constrainNegative(requireNegative(value, name));
    }
}
