package io.github.drewctaylor.constrain.number;

import io.github.drewctaylor.constrain.ConstrainBound.Minimum;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

public final class ZeroOrPositive<TYPE> implements Minimum<TYPE, _0$>
{
    private final Minimum<TYPE, _0$> zeroOrPositive;

    private ZeroOrPositive(
            final Minimum<TYPE, _0$> zeroOrPositive)
    {
        this.zeroOrPositive = zeroOrPositive;
    }

    public static <TYPE> ZeroOrPositive<TYPE> fromMinimum(
            final Minimum<TYPE, _0$> zeroOrPositive)
    {
        return new ZeroOrPositive<>(zeroOrPositive);
    }

    @Override
    public TYPE getValue()
    {
        return zeroOrPositive.getValue();
    }

    @Override
    public TypeEncodedInteger<_0$> getMinimum()
    {
        return zeroOrPositive.getMinimum();
    }

    @Override
    public String toString()
    {
        return "ZeroOrPositive{" +
                "zeroOrPositive=" + zeroOrPositive +
                '}';
    }
}
