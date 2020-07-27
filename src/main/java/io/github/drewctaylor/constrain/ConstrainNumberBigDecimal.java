package io.github.drewctaylor.constrain;

import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.constrain.ConstrainBound.MaximumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Minimum;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

import java.math.BigDecimal;

import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireNegative;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requirePositive;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireZero;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireZeroOrNegative;
import static io.github.drewctaylor.require.RequireNumberBigDecimal.requireZeroOrPositive;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;

/**
 * Constrain a BigDecimal to be positive, negative, or zero.
 */
public final class ConstrainNumberBigDecimal
{
    private ConstrainNumberBigDecimal()
    {
    }

    private static final ConstrainNumberHelper<BigDecimal, _0$> constrainNumberHelper = new ConstrainNumberHelper<>(integer(_0()));

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
    public static MinimumExclusive<BigDecimal, _0$> constrainPositive(
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
    public static Minimum<BigDecimal, _0$> constrainZeroOrPositive(
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
    public static Inclusive<BigDecimal, _0$, _0$> constrainZero(
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
    public static Maximum<BigDecimal, _0$> constrainZeroOrNegative(
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
    public static MaximumExclusive<BigDecimal, _0$> constrainNegative(
            final BigDecimal value,
            final String name)
    {
        return constrainNumberHelper.constrainNegative(requireNegative(value, name));
    }
}
