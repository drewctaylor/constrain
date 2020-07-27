package io.github.drewctaylor.constrain;

import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.constrain.ConstrainBound.MaximumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Minimum;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

import static io.github.drewctaylor.require.RequireNumberInteger.requireNegative;
import static io.github.drewctaylor.require.RequireNumberInteger.requirePositive;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZero;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrNegative;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;

/**
 * Constrain an Integer to be positive, negative, or zero.
 */
public final class ConstrainNumberInteger
{
    private ConstrainNumberInteger()
    {
    }

    private static final ConstrainNumberHelper<Integer, _0$> constrainNumberHelper = new ConstrainNumberHelper<>(integer(_0()));

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
    public static MinimumExclusive<Integer, _0$> constrainPositive(
            final Integer value,
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
    public static Minimum<Integer, _0$> constrainZeroOrPositive(
            final Integer value,
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
    public static Inclusive<Integer, _0$, _0$> constrainZero(
            final Integer value,
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
    public static Maximum<Integer, _0$> constrainZeroOrNegative(
            final Integer value,
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
    public static MaximumExclusive<Integer, _0$> constrainNegative(
            final Integer value,
            final String name)
    {
        return constrainNumberHelper.constrainNegative(requireNegative(value, name));
    }
}
