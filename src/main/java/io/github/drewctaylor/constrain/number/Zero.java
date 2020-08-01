package io.github.drewctaylor.constrain.number;

import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

public final class Zero<TYPE> implements Inclusive<TYPE, _0$, _0$>
{
    private final Inclusive<TYPE, _0$, _0$> zero;

    private Zero(
            final Inclusive<TYPE, _0$, _0$> zero)
    {
        this.zero = zero;
    }

    public static <TYPE> Zero<TYPE> fromInclusive(
            final Inclusive<TYPE, _0$, _0$> zero)
    {
        return new Zero<>(zero);
    }

    @Override
    public TypeEncodedInteger<_0$> getMaximum()
    {
        return zero.getMaximum();
    }

    @Override
    public TYPE getValue()
    {
        return zero.getValue();
    }

    @Override
    public TypeEncodedInteger<_0$> getMinimum()
    {
        return zero.getMinimum();
    }

    @Override
    public String toString()
    {
        return "Zero{" +
                "zero=" + zero +
                '}';
    }
}
