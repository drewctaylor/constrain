package io.github.drewctaylor.constrain;

import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

public final class NonEmpty<TYPE> implements MinimumExclusive<TYPE, _0$>
{
    private final MinimumExclusive<TYPE, _0$> nonEmpty;

    private NonEmpty(
            final MinimumExclusive<TYPE, _0$> nonEmpty)
    {
        this.nonEmpty = nonEmpty;
    }

    public static <TYPE> NonEmpty<TYPE> fromMinimumExclusive(
            final MinimumExclusive<TYPE, _0$> nonEmpty)
    {
        return new NonEmpty<>(nonEmpty);
    }

    @Override
    public TYPE getValue()
    {
        return nonEmpty.getValue();
    }

    @Override
    public TypeEncodedInteger<_0$> getMinimum()
    {
        return nonEmpty.getMinimum();
    }

    @Override
    public String toString()
    {
        return "NonEmpty{" +
                "nonEmpty=" + nonEmpty +
                '}';
    }
}
