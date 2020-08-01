package io.github.drewctaylor.constrain;

import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

public final class Empty<TYPE> implements Inclusive<TYPE, _0$, _0$>
{
    private final Inclusive<TYPE, _0$, _0$> empty;

    private Empty(
            final Inclusive<TYPE, _0$, _0$> empty)
    {
        this.empty = empty;
    }

    public static <TYPE> Empty<TYPE> fromInclusive(
            final Inclusive<TYPE, _0$, _0$> empty)
    {
        return new Empty<>(empty);
    }

    @Override
    public TypeEncodedInteger<_0$> getMaximum()
    {
        return empty.getMaximum();
    }

    @Override
    public TYPE getValue()
    {
        return empty.getValue();
    }

    @Override
    public TypeEncodedInteger<_0$> getMinimum()
    {
        return empty.getMinimum();
    }

    @Override
    public String toString()
    {
        return "Empty{" +
                "empty=" + empty +
                '}';
    }
}
