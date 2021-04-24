package io.github.drewctaylor.constrain;

import io.github.drewctaylor.constrain.ConstrainBound.Exclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.constrain.ConstrainBound.MaximumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Minimum;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusiveMaximumInclusive;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumInclusiveMaximumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;

import java.util.Map;

import static io.github.drewctaylor.constrain.ConstrainBound.constrain;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximumExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumExclusiveMaximumInclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumInclusiveMaximumExclusive;
import static io.github.drewctaylor.constrain.Empty.fromInclusive;
import static io.github.drewctaylor.constrain.NonEmpty.fromMinimumExclusive;
import static io.github.drewctaylor.require.Require.requireNonNull;
import static io.github.drewctaylor.require.RequireMap.requireEmpty;
import static io.github.drewctaylor.require.RequireMap.requireNonEmpty;
import static io.github.drewctaylor.require.RequireMap.requireSize;
import static io.github.drewctaylor.require.RequireMap.requireSizeExclusive;
import static io.github.drewctaylor.require.RequireMap.requireSizeGreaterThan;
import static io.github.drewctaylor.require.RequireMap.requireSizeGreaterThanOrEqual;
import static io.github.drewctaylor.require.RequireMap.requireSizeLessThan;
import static io.github.drewctaylor.require.RequireMap.requireSizeLessThanOrEqual;
import static io.github.drewctaylor.require.RequireMap.requireSizeMinimumExclusiveMaximumInclusive;
import static io.github.drewctaylor.require.RequireMap.requireSizeMinimumInclusiveMaximumExclusive;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;

/**
 * Constrain a map to be empty or non-empty or to have a size within bounds.
 */
public final class ConstrainMap
{
    private ConstrainMap()
    {
    }

    /**
     * Constrain the given map, if empty; otherwise, throw an IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * 
     * @return                          the given map, if empty
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map is not empty
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>> Empty<MAP> constrainEmpty(
            final MAP map,
            final String name)
    {
        return fromInclusive(constrain(requireEmpty(map, name), integer(_0()), integer(_0())));
    }

    /**
     * Constrain the given map, if non-empty; otherwise, throw an IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * 
     * @return                          the given map, if non-empty
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map is not empty
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>> NonEmpty<MAP> constrainNonEmpty(
            final MAP map,
            final String name)
    {
        return fromMinimumExclusive(constrainMinimumExclusive(requireNonEmpty(map, name), integer(_0())));
    }

    /**
     * Constrain the given map, if size is less than the given maximum; otherwise, throw an IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given map, if size less than the given maximum
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not less than the given maximum
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MAX extends TypeEncodedInteger<MAX>> MaximumExclusive<MAP, MAX> constrainSizeLessThan(
            final MAP map,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(maximum, "maximum");

        return constrainMaximumExclusive(requireSizeLessThan(map, maximum.toInt(), name), maximum);
    }

    /**
     * Constrain the given map, if size is less than or equal to the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given map, if size is less than or equal to the given maximum
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not less than or equal to the given maximum
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MAX extends TypeEncodedInteger<MAX>> Maximum<MAP, MAX> constrainSizeLessThanOrEqual(
            final MAP map,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(maximum, "maximum");

        return constrainMaximum(requireSizeLessThanOrEqual(map, maximum.toInt(), name), maximum);
    }

    /**
     * Constrain the given map, if size is the given size; otherwise, throw an IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  size                     the given size
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <SIZE>                   the type of the given size
     * 
     * @return                          the given map, if size is the given size
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not the given size
     * @throws NullPointerException     if size is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, SIZE extends TypeEncodedInteger<SIZE>> Inclusive<MAP, SIZE, SIZE> constrainSize(
            final MAP map,
            final TypeEncodedInteger<SIZE> size,
            final String name)
    {
        requireNonNull(size, "size");

        return constrain(requireSize(map, size.toInt(), name), size, size);
    }

    /**
     * Constrain the given map, if size is greater than or equal to the given size; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  minimum                  the given minimum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MIN>                    the given minimum, encoded as a type
     * 
     * @return                          the given map, if size is greater than or equal to the given size
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not greater than or equal to the given size
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MIN extends TypeEncodedInteger<MIN>> Minimum<MAP, MIN> constrainSizeGreaterThanOrEqual(
            final MAP map,
            final TypeEncodedInteger<MIN> minimum,
            final String name)
    {
        requireNonNull(minimum, "minimum");

        return constrainMinimum(requireSizeGreaterThanOrEqual(map, minimum.toInt(), name), minimum);
    }

    /**
     * Constrain the given map, if size is greater than the given size; otherwise, throw an IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  minimum                  the given minimum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MIN>                    the given minimum, encoded as a type
     * 
     * @return                          the given map, if size is greater than the given size
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not greater than the given size
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MIN extends TypeEncodedInteger<MIN>> MinimumExclusive<MAP, MIN> constrainSizeGreaterThan(
            final MAP map,
            final TypeEncodedInteger<MIN> minimum,
            final String name)
    {
        requireNonNull(minimum, "minimum");

        return constrainMinimumExclusive(requireSizeGreaterThan(map, minimum.toInt(), name), minimum);
    }

    /**
     * Constrain the given map, if size is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given map, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Inclusive<MAP, MIN, MAX> constrainSize(
            final MAP map,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrain(requireSize(map, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given map, if size is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given map, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Exclusive<MAP, MIN, MAX> constrainSizeExclusive(
            final MAP map,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainExclusive(requireSizeExclusive(map, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given map, if size is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given map, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumExclusiveMaximumInclusive<MAP, MIN, MAX> constrainSizeMinimumExclusiveMaximumInclusive(
            final MAP map,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainMinimumExclusiveMaximumInclusive(requireSizeMinimumExclusiveMaximumInclusive(map, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given map, if size is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  map                      the given map
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given map
     * @param  <KEY>                    the type of the map key
     * @param  <VALUE>                  the type of the map value
     * @param  <MAP>                    the type of the map
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given map, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if map is null
     * @throws IllegalArgumentException if map size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <KEY, VALUE, MAP extends Map<KEY, VALUE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumInclusiveMaximumExclusive<MAP, MIN, MAX> constrainSizeMinimumInclusiveMaximumExclusive(
            final MAP map,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainMinimumInclusiveMaximumExclusive(requireSizeMinimumInclusiveMaximumExclusive(map, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }
}