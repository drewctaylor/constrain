package io.github.drewctaylor.constrain.number;

import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

public final class Positive<TYPE> implements MinimumExclusive<TYPE, _0$>
{
    private final MinimumExclusive<TYPE, _0$> positive;

    private Positive(
            final MinimumExclusive<TYPE, _0$> positive)
    {
        this.positive = positive;
    }

    public static <TYPE> Positive<TYPE> fromMinimumExclusive(
            final MinimumExclusive<TYPE, _0$> positive)
    {
        return new Positive<>(positive);
    }

    @Override
    public TYPE getValue()
    {
        return positive.getValue();
    }

    @Override
    public TypeEncodedInteger<_0$> getMinimum()
    {
        return positive.getMinimum();
    }

    @Override
    public String toString()
    {
        return "Positive{" +
                "positive=" + positive +
                '}';
    }
}
