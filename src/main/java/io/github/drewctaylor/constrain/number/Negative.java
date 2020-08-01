package io.github.drewctaylor.constrain.number;

import io.github.drewctaylor.constrain.ConstrainBound.MaximumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

public final class Negative<TYPE> implements MaximumExclusive<TYPE, _0$>
{
    private final MaximumExclusive<TYPE, _0$> negative;

    private Negative(
            final MaximumExclusive<TYPE, _0$> negative)
    {
        this.negative = negative;
    }

    public static <TYPE> Negative<TYPE> fromMaximumExclusive(
            final MaximumExclusive<TYPE, _0$> negative)
    {
        return new Negative<>(negative);
    }

    @Override
    public TYPE getValue()
    {
        return negative.getValue();
    }

    @Override
    public TypeEncodedInteger<_0$> getMaximum()
    {
        return negative.getMaximum();
    }

    @Override
    public String toString()
    {
        return "Negative{" +
                "negative=" + negative +
                '}';
    }
}
