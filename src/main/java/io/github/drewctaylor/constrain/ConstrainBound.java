package io.github.drewctaylor.constrain;

import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;

import static io.github.drewctaylor.require.Require.requireNonNull;

/**
 * Constrain a type.
 */
public final class ConstrainBound
{
    private ConstrainBound()
    {
    }

    @SuppressWarnings("FieldNotUsedInToString")
    private abstract static class HelperForBounded<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>>
    {
        private final TYPE value;
        private final TypeEncodedInteger<MIN> minimum;
        private final TypeEncodedInteger<MAX> maximum;

        private HelperForBounded(
                final TYPE value,
                final TypeEncodedInteger<MIN> minimum,
                final TypeEncodedInteger<MAX> maximum)
        {
            this.value = value;
            this.minimum = minimum;
            this.maximum = maximum;
        }

        /**
         * Return the value.
         *
         * @return the value.
         */
        public final TYPE getValue()
        {
            return value;
        }

        /**
         * Return the minimum value, encoded as a type.
         *
         * @return the minimum value, encoded as a type.
         */
        public final TypeEncodedInteger<MIN> getMinimum()
        {
            return minimum;
        }

        /**
         * Return the maximum value, encoded as a type.
         *
         * @return the maximum value, encoded as a type.
         */
        public final TypeEncodedInteger<MAX> getMaximum()
        {
            return maximum;
        }

        public abstract String toString();
    }

    private static final class InclusiveDefault<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> extends HelperForBounded<TYPE, MIN, MAX>
            implements Inclusive<TYPE, MIN, MAX>
    {
        private InclusiveDefault(
                final TYPE value,
                final TypeEncodedInteger<MIN> minimum,
                final TypeEncodedInteger<MAX> maximum)
        {
            super(value, minimum, maximum);
        }

        @Override
        public String toString()
        {
            return "InclusiveDefault{" +
                    "value=" + getValue() +
                    ", minimum=" + getMinimum() +
                    ", maximum=" + getMaximum() +
                    '}';
        }
    }

    private static final class ExclusiveDefault<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> extends HelperForBounded<TYPE, MIN, MAX>
            implements Exclusive<TYPE, MIN, MAX>
    {
        private ExclusiveDefault(
                final TYPE value,
                final TypeEncodedInteger<MIN> minimum,
                final TypeEncodedInteger<MAX> maximum)
        {
            super(value, minimum, maximum);
        }

        @Override
        public String toString()
        {
            return "ExclusiveDefault{" +
                    "value=" + getValue() +
                    ", minimum=" + getMinimum() +
                    ", maximum=" + getMaximum() +
                    '}';
        }
    }

    private static final class MinimumExclusiveMaximumInclusiveDefault<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> extends HelperForBounded<TYPE, MIN, MAX>
            implements MinimumExclusiveMaximumInclusive<TYPE, MIN, MAX>
    {
        private MinimumExclusiveMaximumInclusiveDefault(
                final TYPE value,
                final TypeEncodedInteger<MIN> minimum,
                final TypeEncodedInteger<MAX> maximum)
        {
            super(value, minimum, maximum);
        }

        @Override
        public String toString()
        {
            return "MinimumExclusiveMaximumInclusiveDefault{" +
                    "value=" + getValue() +
                    ", minimum=" + getMinimum() +
                    ", maximum=" + getMaximum() +
                    '}';
        }
    }

    private static final class MinimumInclusiveMaximumExclusiveDefault<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> extends HelperForBounded<TYPE, MIN, MAX>
            implements MinimumInclusiveMaximumExclusive<TYPE, MIN, MAX>
    {
        private MinimumInclusiveMaximumExclusiveDefault(
                final TYPE value,
                final TypeEncodedInteger<MIN> minimum,
                final TypeEncodedInteger<MAX> maximum)
        {
            super(value, minimum, maximum);
        }

        @Override
        public String toString()
        {
            return "MinimumInclusiveMaximumExclusiveDefault{" +
                    "value=" + getValue() +
                    ", minimum=" + getMinimum() +
                    ", maximum=" + getMaximum() +
                    '}';
        }
    }

    /**
     * A value whose type indicates its minimum and maximum value.
     *
     * @param <TYPE> the type of the value
     * @param <MIN>  the minimum value, encoded as a type
     * @param <MAX>  the maximum value, encoded as a type
     */
    public interface Inclusive<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>>
            extends Minimum<TYPE, MIN>, Maximum<TYPE, MAX>
    {
    }

    /**
     * A value whose type indicates its minimum and maximum value.
     *
     * @param <TYPE> the type of the value
     * @param <MIN>  the minimum value, encoded as a type
     * @param <MAX>  the maximum value, encoded as a type
     */
    public interface Exclusive<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>>
            extends Inclusive<TYPE, MIN, MAX>, MinimumExclusive<TYPE, MIN>, MaximumExclusive<TYPE, MAX>
    {
    }

    /**
     * A value whose type indicates its minimum and maximum value.
     *
     * @param <TYPE> the type of the value
     * @param <MIN>  the minimum value, encoded as a type
     * @param <MAX>  the maximum value, encoded as a type
     */
    public interface MinimumExclusiveMaximumInclusive<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>>
            extends Inclusive<TYPE, MIN, MAX>, MinimumExclusive<TYPE, MIN>
    {
    }

    /**
     * A value whose type indicates its minimum and maximum value.
     *
     * @param <TYPE> the type of the value
     * @param <MIN>  the minimum value, encoded as a type
     * @param <MAX>  the maximum value, encoded as a type
     */
    public interface MinimumInclusiveMaximumExclusive<TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>>
            extends Inclusive<TYPE, MIN, MAX>, MaximumExclusive<TYPE, MAX>
    {
    }

    /**
     * Constrain the given value to have the given minimum and maximum value.
     *
     * @param  value                the given value
     * @param  minimum              the given minimum value
     * @param  maximum              the given maximum value
     * @param  <TYPE>               the type of the given value
     * @param  <MIN>                the minimum value, encoded as a type
     * @param  <MAX>                the maximum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if minimum is null
     * @throws NullPointerException if maximum is null
     */
    public static <TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Inclusive<TYPE, MIN, MAX> constrain(
            final TYPE value,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum)
    {
        requireNonNull(value, "value");
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return new InclusiveDefault<>(value, minimum, maximum);
    }

    /**
     * Constrain the given value to have the given minimum and maximum value.
     *
     * @param  value                the given value
     * @param  minimum              the given minimum value
     * @param  maximum              the given maximum value
     * @param  <TYPE>               the type of the given value
     * @param  <MIN>                the minimum value, encoded as a type
     * @param  <MAX>                the maximum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if minimum is null
     * @throws NullPointerException if maximum is null
     */
    static <TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> Exclusive<TYPE, MIN, MAX> constrainExclusive(
            final TYPE value,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum)
    {
        requireNonNull(value, "value");
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return new ExclusiveDefault<>(value, minimum, maximum);
    }

    /**
     * Constrain the given value to have the given minimum and maximum value.
     *
     * @param  value                the given value
     * @param  minimum              the given minimum value
     * @param  maximum              the given maximum value
     * @param  <TYPE>               the type of the given value
     * @param  <MIN>                the minimum value, encoded as a type
     * @param  <MAX>                the maximum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if minimum is null
     * @throws NullPointerException if maximum is null
     */
    static <TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumExclusiveMaximumInclusive<TYPE, MIN, MAX> constrainMinimumExclusiveMaximumInclusive(
            final TYPE value,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum)
    {
        requireNonNull(value, "value");
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return new MinimumExclusiveMaximumInclusiveDefault<>(value, minimum, maximum);
    }

    /**
     * Constrain the given value to have the given minimum and maximum value.
     *
     * @param  value                the given value
     * @param  minimum              the given minimum value
     * @param  maximum              the given maximum value
     * @param  <TYPE>               the type of the given value
     * @param  <MIN>                the minimum value, encoded as a type
     * @param  <MAX>                the maximum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if minimum is null
     * @throws NullPointerException if maximum is null
     */
    static <TYPE, MIN extends TypeEncodedInteger<MIN>, MAX extends TypeEncodedInteger<MAX>> MinimumInclusiveMaximumExclusive<TYPE, MIN, MAX> constrainMinimumInclusiveMaximumExclusive(
            final TYPE value,
            final TypeEncodedInteger<MIN> minimum,
            final TypeEncodedInteger<MAX> maximum)
    {
        requireNonNull(value, "value");
        requireNonNull(minimum, "minimum");
        requireNonNull(maximum, "maximum");

        return new MinimumInclusiveMaximumExclusiveDefault<>(value, minimum, maximum);
    }

    @SuppressWarnings("FieldNotUsedInToString")
    private abstract static class HelperForUnbounded<TYPE, CONSTRAINT extends TypeEncodedInteger<CONSTRAINT>>
    {
        private final TYPE value;
        private final TypeEncodedInteger<CONSTRAINT> constraint;

        private HelperForUnbounded(
                final TYPE value,
                final TypeEncodedInteger<CONSTRAINT> constraint)
        {
            this.value = value;
            this.constraint = constraint;
        }

        /**
         * Return the value.
         *
         * @return the value.
         */
        public final TYPE getValue()
        {
            return value;
        }

        /**
         * Return the maximum value, encoded as a type.
         *
         * @return the maximum value, encoded as a type.
         */
        @SuppressWarnings("SuspiciousGetterSetter")
        public final TypeEncodedInteger<CONSTRAINT> getMaximum()
        {
            return constraint;
        }

        /**
         * Return the minimum value, encoded as a type.
         *
         * @return the minimum value, encoded as a type.
         */
        @SuppressWarnings("SuspiciousGetterSetter")
        public final TypeEncodedInteger<CONSTRAINT> getMinimum()
        {
            return constraint;
        }

        public abstract String toString();
    }

    private static final class MaximumDefault<TYPE, MAX extends TypeEncodedInteger<MAX>> extends HelperForUnbounded<TYPE, MAX> implements Maximum<TYPE, MAX>
    {
        private MaximumDefault(
                final TYPE value,
                final TypeEncodedInteger<MAX> bound)
        {
            super(value, bound);
        }

        @Override
        public String toString()
        {
            return "MaximumDefault{" +
                    "value=" + getValue() +
                    ", maximum=" + getMaximum() +
                    ", minimum=" + getMinimum() +
                    '}';
        }
    }

    private static final class MaximumExclusiveDefault<TYPE, MAX extends TypeEncodedInteger<MAX>> extends HelperForUnbounded<TYPE, MAX> implements MaximumExclusive<TYPE, MAX>
    {
        private MaximumExclusiveDefault(
                final TYPE value,
                final TypeEncodedInteger<MAX> bound)
        {
            super(value, bound);
        }

        @Override
        public String toString()
        {
            return "MaximumExclusiveDefault{" +
                    "value=" + getValue() +
                    ", maximum=" + getMaximum() +
                    ", minimum=" + getMinimum() +
                    '}';
        }
    }

    private static final class MinimumDefault<TYPE, MAX extends TypeEncodedInteger<MAX>> extends HelperForUnbounded<TYPE, MAX> implements Minimum<TYPE, MAX>
    {
        private MinimumDefault(
                final TYPE value,
                final TypeEncodedInteger<MAX> bound)
        {
            super(value, bound);
        }

        @Override
        public String toString()
        {
            return "MinimumDefault{" +
                    "value=" + getValue() +
                    ", maximum=" + getMaximum() +
                    ", minimum=" + getMinimum() +
                    '}';
        }
    }

    private static final class MinimumExclusiveDefault<TYPE, MAX extends TypeEncodedInteger<MAX>> extends HelperForUnbounded<TYPE, MAX> implements MinimumExclusive<TYPE, MAX>
    {
        private MinimumExclusiveDefault(
                final TYPE value,
                final TypeEncodedInteger<MAX> bound)
        {
            super(value, bound);
        }

        @Override
        public String toString()
        {
            return "MinimumExclusiveDefault{" +
                    "value=" + getValue() +
                    ", maximum=" + getMaximum() +
                    ", minimum=" + getMinimum() +
                    '}';
        }
    }

    /**
     * A value whose type indicates its maximum value.
     *
     * @param <TYPE> the type of the value
     * @param <MAX>  the maximum value, encoded as a type
     */
    public interface Maximum<TYPE, MAX extends TypeEncodedInteger<MAX>>
    {
        /**
         * Return the value.
         *
         * @return the value.
         */
        TYPE getValue();

        /**
         * Return the maximum value, encoded as a type.
         *
         * @return the maximum value, encoded as a type.
         */
        TypeEncodedInteger<MAX> getMaximum();
    }

    /**
     * A value whose type indicates its maximum value.
     *
     * @param <TYPE> the type of the value
     * @param <MAX>  the maximum value, encoded as a type
     */
    public interface MaximumExclusive<TYPE, MAX extends TypeEncodedInteger<MAX>> extends Maximum<TYPE, MAX>
    {
    }

    /**
     * A value whose type indicates its minimum value.
     *
     * @param <TYPE> the type of the value
     * @param <MIN>  the minimum value, encoded as a type
     */
    public interface Minimum<TYPE, MIN extends TypeEncodedInteger<MIN>>
    {
        /**
         * Return the value.
         *
         * @return the value.
         */
        TYPE getValue();

        /**
         * Return the minimum value, encoded as a type.
         *
         * @return the minimum value, encoded as a type.
         */
        TypeEncodedInteger<MIN> getMinimum();
    }

    /**
     * A value whose type indicates its minimum value.
     *
     * @param <TYPE> the type of the value
     * @param <MIN>  the minimum value, encoded as a type
     */
    public interface MinimumExclusive<TYPE, MIN extends TypeEncodedInteger<MIN>> extends Minimum<TYPE, MIN>
    {
    }

    /**
     * Constrain the given value to have the given maximum value.
     *
     * @param  value                the given value
     * @param  maximum              the given maximum value
     * @param  <TYPE>               the type of the given value
     * @param  <MAX>                the maximum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if maximum is null
     */
    public static <TYPE, MAX extends TypeEncodedInteger<MAX>> Maximum<TYPE, MAX> constrainMaximum(
            final TYPE value,
            final TypeEncodedInteger<MAX> maximum)
    {
        requireNonNull(value, "value");
        requireNonNull(maximum, "maximum");

        return new MaximumDefault<>(value, maximum);
    }

    /**
     * Constrain the given value to have the given maximum value.
     *
     * @param  value                the given value
     * @param  maximum              the given maximum value
     * @param  <TYPE>               the type of the given value
     * @param  <MAX>                the maximum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if maximum is null
     */
    public static <TYPE, MAX extends TypeEncodedInteger<MAX>> MaximumExclusive<TYPE, MAX> constrainMaximumExclusive(
            final TYPE value,
            final TypeEncodedInteger<MAX> maximum)
    {
        requireNonNull(value, "value");
        requireNonNull(maximum, "maximum");

        return new MaximumExclusiveDefault<>(value, maximum);
    }

    /**
     * Constrain the given value to have the given minimum value.
     *
     * @param  value                the given value
     * @param  minimum              the given minimum value
     * @param  <TYPE>               the type of the given value
     * @param  <MIN>                the minimum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if minimum is null
     */
    public static <TYPE, MIN extends TypeEncodedInteger<MIN>> Minimum<TYPE, MIN> constrainMinimum(
            final TYPE value,
            final TypeEncodedInteger<MIN> minimum)
    {
        requireNonNull(value, "value");
        requireNonNull(minimum, "minimum");

        return new MinimumDefault<>(value, minimum);
    }

    /**
     * Constrain the given value to have the given minimum value.
     *
     * @param  value                the given value
     * @param  minimum              the given minimum value
     * @param  <TYPE>               the type of the given value
     * @param  <MIN>                the minimum value, encoded as a type
     * @return                      the given value
     * @throws NullPointerException if value is null
     * @throws NullPointerException if minimum is null
     */
    public static <TYPE, MIN extends TypeEncodedInteger<MIN>> MinimumExclusive<TYPE, MIN> constrainMinimumExclusive(
            final TYPE value,
            final TypeEncodedInteger<MIN> minimum)
    {
        requireNonNull(value, "value");
        requireNonNull(minimum, "minimum");

        return new MinimumExclusiveDefault<>(value, minimum);
    }
}
