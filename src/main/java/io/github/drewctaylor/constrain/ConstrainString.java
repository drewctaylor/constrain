package io.github.drewctaylor.constrain;

import io.github.drewctaylor.constrain.ConstrainBound.Exclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.constrain.ConstrainBound.MaximumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Minimum;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusiveMaximumInclusive;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumInclusiveMaximumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedIntegerConcrete;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

import static io.github.drewctaylor.constrain.ConstrainBound.constrain;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximumExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumExclusiveMaximumInclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumInclusiveMaximumExclusive;
import static io.github.drewctaylor.require.Require.requireNonNull;
import static io.github.drewctaylor.require.RequireString.requireEmpty;
import static io.github.drewctaylor.require.RequireString.requireLength;
import static io.github.drewctaylor.require.RequireString.requireLengthExclusive;
import static io.github.drewctaylor.require.RequireString.requireLengthGreaterThan;
import static io.github.drewctaylor.require.RequireString.requireLengthGreaterThanOrEqual;
import static io.github.drewctaylor.require.RequireString.requireLengthLessThan;
import static io.github.drewctaylor.require.RequireString.requireLengthLessThanOrEqual;
import static io.github.drewctaylor.require.RequireString.requireLengthMinimumExclusiveMaximumInclusive;
import static io.github.drewctaylor.require.RequireString.requireLengthMinimumInclusiveMaximumExclusive;
import static io.github.drewctaylor.require.RequireString.requireNonEmpty;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;

/**
 * Constrain a string to be empty or non-empty or to have a length within bounds.
 */
public final class ConstrainString
{
    private ConstrainString()
    {
    }

    /**
     * Constrain the given string, if empty; otherwise, throw an IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  name                     the name of the given string
     * 
     * @return                          the given string, if empty
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string is not empty
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static Inclusive<String, _0$, _0$> constrainEmpty(
            final String string,
            final String name)
    {
        return constrain(requireEmpty(string, name), integer(_0()), integer(_0()));
    }

    /**
     * Constrain the given string, if non-empty; otherwise, throw an IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  name                     the name of the given string
     * 
     * @return                          the given string, if non-empty
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string is not empty
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static MinimumExclusive<String, _0$> constrainNonEmpty(
            final String string,
            final String name)
    {
        return constrainMinimumExclusive(requireNonEmpty(string, name), integer(_0()));
    }

    /**
     * Constrain the given string, if length is less than the given maximum; otherwise, throw an IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given string
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given string, if length less than the given maximum
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not less than the given maximum
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MAX extends TypeEncodedInteger<MAX>> MaximumExclusive<String, MAX> constrainLengthLessThan(
            final String string,
            final TypeEncodedIntegerConcrete<MAX> maximum,
            final String name)
    {
        requireNonNull(maximum, "maximum");

        return constrainMaximumExclusive(requireLengthLessThan(string, maximum.toInt(), name), maximum);
    }

    /**
     * Constrain the given string, if length is less than or equal to the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given string
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given string, if length is less than or equal to the given maximum
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not less than or equal to the given maximum
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MAX extends TypeEncodedInteger<MAX>> Maximum<String, MAX> constrainLengthLessThanOrEqual(
            final String string,
            final TypeEncodedIntegerConcrete<MAX> maximum,
            final String name)
    {
        requireNonNull(maximum, "maximum");

        return constrainMaximum(requireLengthLessThanOrEqual(string, maximum.toInt(), name), maximum);
    }

    /**
     * Constrain the given string, if length is the given length; otherwise, throw an IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  length                   the given length
     * @param  name                     the name of the given string
     * @param  <LENGTH>                 the type of the given length
     * 
     * @return                          the given string, if length is the given length
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not the given length
     * @throws NullPointerException     if length is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <LENGTH extends TypeEncodedInteger<LENGTH>> Inclusive<String, LENGTH, LENGTH> constrainLength(
            final String string,
            final TypeEncodedIntegerConcrete<LENGTH> length,
            final String name)
    {
        requireNonNull(length, "length");

        return constrain(requireLength(string, length.toInt(), name), length, length);
    }

    /**
     * Constrain the given string, if length is greater than or equal to the given length; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  minimum                  the given minimum
     * @param  name                     the name of the given string
     * @param  <MIN>                    the given minimum, encoded as a type
     * 
     * @return                          the given string, if length is greater than or equal to the given length
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not greater than or equal to the given length
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MIN extends TypeEncodedInteger<MIN>> Minimum<String, MIN> constrainLengthGreaterThanOrEqual(
            final String string,
            final TypeEncodedIntegerConcrete<MIN> minimum,
            final String name)
    {
        requireNonNull(minimum, "minimum");

        return constrainMinimum(requireLengthGreaterThanOrEqual(string, minimum.toInt(), name), minimum);
    }

    /**
     * Constrain the given string, if length is greater than the given length; otherwise, throw an IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  minimum                  the given minimum
     * @param  name                     the name of the given string
     * @param  <MIN>                    the given minimum, encoded as a type
     * 
     * @return                          the given string, if length is greater than the given length
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not greater than the given length
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MIN extends TypeEncodedInteger<MIN>> MinimumExclusive<String, MIN> constrainLengthGreaterThan(
            final String string,
            final TypeEncodedIntegerConcrete<MIN> minimum,
            final String name)
    {
        requireNonNull(minimum, "minimum");

        return constrainMinimumExclusive(requireLengthGreaterThan(string, minimum.toInt(), name), minimum);
    }

    /**
     * Constrain the given string, if length is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given string
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given string, if length is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Inclusive<String, MIN, MAX> constrainLength(
            final String string,
            final TypeEncodedIntegerConcrete<MIN> minimum,
            final TypeEncodedIntegerConcrete<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrain(requireLength(string, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given string, if length is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given string
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given string, if length is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Exclusive<String, MIN, MAX> constrainLengthExclusive(
            final String string,
            final TypeEncodedIntegerConcrete<MIN> minimum,
            final TypeEncodedIntegerConcrete<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainExclusive(requireLengthExclusive(string, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given string, if length is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given string
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given string, if length is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumExclusiveMaximumInclusive<String, MIN, MAX> constrainLengthMinimumExclusiveMaximumInclusive(
            final String string,
            final TypeEncodedIntegerConcrete<MIN> minimum,
            final TypeEncodedIntegerConcrete<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainMinimumExclusiveMaximumInclusive(requireLengthMinimumExclusiveMaximumInclusive(string, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given string, if length is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  string                   the given string
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given string
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given string, if length is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if string is null
     * @throws IllegalArgumentException if string length is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumInclusiveMaximumExclusive<String, MIN, MAX> constrainLengthMinimumInclusiveMaximumExclusive(
            final String string,
            final TypeEncodedIntegerConcrete<MIN> minimum,
            final TypeEncodedIntegerConcrete<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainMinimumInclusiveMaximumExclusive(requireLengthMinimumInclusiveMaximumExclusive(string, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }
}