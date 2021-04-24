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

import java.util.Collection;

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
import static io.github.drewctaylor.require.RequireCollection.requireEmpty;
import static io.github.drewctaylor.require.RequireCollection.requireNonEmpty;
import static io.github.drewctaylor.require.RequireCollection.requireSize;
import static io.github.drewctaylor.require.RequireCollection.requireSizeExclusive;
import static io.github.drewctaylor.require.RequireCollection.requireSizeGreaterThan;
import static io.github.drewctaylor.require.RequireCollection.requireSizeGreaterThanOrEqual;
import static io.github.drewctaylor.require.RequireCollection.requireSizeLessThan;
import static io.github.drewctaylor.require.RequireCollection.requireSizeLessThanOrEqual;
import static io.github.drewctaylor.require.RequireCollection.requireSizeMinimumExclusiveMaximumInclusive;
import static io.github.drewctaylor.require.RequireCollection.requireSizeMinimumInclusiveMaximumExclusive;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;

/**
 * Constrain a collection to be empty or non-empty or to have a size within bounds.
 */
public final class ConstrainCollection
{
    private ConstrainCollection()
    {
    }

    /**
     * Constrain the given collection, if empty; otherwise, throw an IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * 
     * @return                          the given collection, if empty
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection is not empty
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>> Empty<COLLECTION> constrainEmpty(
            final COLLECTION collection,
            final String name)
    {
        return fromInclusive(constrain(requireEmpty(collection, name), integer(_0()), integer(_0())));
    }

    /**
     * Constrain the given collection, if non-empty; otherwise, throw an IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * 
     * @return                          the given collection, if non-empty
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection is not empty
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>> NonEmpty<COLLECTION> constrainNonEmpty(
            final COLLECTION collection,
            final String name)
    {
        return fromMinimumExclusive(constrainMinimumExclusive(requireNonEmpty(collection, name), integer(_0())));
    }

    /**
     * Constrain the given collection, if size is less than the given maximum; otherwise, throw an IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given collection, if size less than the given maximum
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not less than the given maximum
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MAX extends TypeEncodedInteger<MAX>> MaximumExclusive<COLLECTION, MAX> constrainSizeLessThan(
            final COLLECTION collection,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(maximum, "maximum");

        return constrainMaximumExclusive(requireSizeLessThan(collection, maximum.toInt(), name), maximum);
    }

    /**
     * Constrain the given collection, if size is less than or equal to the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given collection, if size is less than or equal to the given maximum
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not less than or equal to the given maximum
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MAX extends TypeEncodedInteger<MAX>> Maximum<COLLECTION, MAX> constrainSizeLessThanOrEqual(
            final COLLECTION collection,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(maximum, "maximum");

        return constrainMaximum(requireSizeLessThanOrEqual(collection, maximum.toInt(), name), maximum);
    }

    /**
     * Constrain the given collection, if size is the given size; otherwise, throw an IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  size                     the given size
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <SIZE>                   the given size, encoded as a type
     * 
     * @return                          the given collection, if size is the given size
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not the given size
     * @throws NullPointerException     if size is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, SIZE extends TypeEncodedInteger<SIZE>> Inclusive<COLLECTION, SIZE, SIZE> constrainSize(
            final COLLECTION collection,
            final TypeEncodedInteger<SIZE> size,
            final String name)
    {
        requireNonNull(size, "size");

        return constrain(requireSize(collection, size.toInt(), name), size, size);
    }

    /**
     * Constrain the given collection, if size is greater than or equal to the given size; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  minimum                  the given minimum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MIN>                    the given minimum, encoded as a type
     * 
     * @return                          the given collection, if size is greater than or equal to the given size
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not greater than or equal to the given size
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MIN extends TypeEncodedInteger<MIN>> Minimum<COLLECTION, MIN> constrainSizeGreaterThanOrEqual(
            final COLLECTION collection,
            final TypeEncodedInteger<MIN> minimum,
            final String name)
    {
        requireNonNull(minimum, "minimum");

        return constrainMinimum(requireSizeGreaterThanOrEqual(collection, minimum.toInt(), name), minimum);
    }

    /**
     * Constrain the given collection, if size is greater than the given size; otherwise, throw an IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  minimum                  the given minimum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MIN>                    the given minimum, encoded as a type
     * 
     * @return                          the given collection, if size is greater than the given size
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not greater than the given size
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MIN extends TypeEncodedInteger<MIN>> MinimumExclusive<COLLECTION, MIN> constrainSizeGreaterThan(
            final COLLECTION collection,
            final TypeEncodedInteger<MIN> minimum,
            final String name)
    {
        requireNonNull(minimum, "minimum");

        return constrainMinimumExclusive(requireSizeGreaterThan(collection, minimum.toInt(), name), minimum);
    }

    /**
     * Constrain the given collection, if size is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given collection, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Inclusive<COLLECTION, MIN, MAX> constrainSize(
            final COLLECTION collection,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrain(requireSize(collection, minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given collection, if size is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given collection, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Exclusive<COLLECTION, MIN, MAX> constrainSizeExclusive(
            final COLLECTION collection,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainExclusive(requireSizeExclusive(collection, minimum.toInt(), maximum.toInt(), name), minimum,
                maximum);
    }

    /**
     * Constrain the given collection, if size is between the given minimum and the given maximum; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given collection, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumExclusiveMaximumInclusive<COLLECTION, MIN, MAX> constrainSizeMinimumExclusiveMaximumInclusive(
            final COLLECTION collection,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainMinimumExclusiveMaximumInclusive(requireSizeMinimumExclusiveMaximumInclusive(collection,
                minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }

    /**
     * Constrain the given collection, if size is between the given minimum and the given maximum ; otherwise, throw an
     * IllegalArgumentException.
     *
     * @param  collection               the given collection
     * @param  minimum                  the given minimum
     * @param  maximum                  the given maximum
     * @param  name                     the name of the given collection
     * @param  <TYPE>                   the type of the collection element
     * @param  <COLLECTION>             the type of the collection
     * @param  <MIN>                    the given minimum, encoded as a type
     * @param  <MAX>                    the given maximum, encoded as a type
     * 
     * @return                          the given collection, if size is between the given minimum and the given maximum
     * 
     * @throws NullPointerException     if collection is null
     * @throws IllegalArgumentException if collection size is not between the given minimum and the given maximum
     * @throws NullPointerException     if minimum is null
     * @throws NullPointerException     if maximum is null
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is empty
     */
    public static <TYPE, COLLECTION extends Collection<TYPE>, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumInclusiveMaximumExclusive<COLLECTION, MIN, MAX> constrainSizeMinimumInclusiveMaximumExclusive(
            final COLLECTION collection,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum,
            final String name)
    {
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return constrainMinimumInclusiveMaximumExclusive(requireSizeMinimumInclusiveMaximumExclusive(collection,
                minimum.toInt(), maximum.toInt(), name), minimum, maximum);
    }
}