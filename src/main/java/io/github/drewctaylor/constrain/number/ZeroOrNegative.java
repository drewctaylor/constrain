package io.github.drewctaylor.constrain.number;

import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;

public final class ZeroOrNegative<TYPE> implements Maximum<TYPE, _0$>
{
    private final Maximum<TYPE, _0$> zeroOrNegative;

    private ZeroOrNegative(
            final Maximum<TYPE, _0$> zeroOrNegative)
    {
        this.zeroOrNegative = zeroOrNegative;
    }

    public static <TYPE> ZeroOrNegative<TYPE> fromMaximum(
            final Maximum<TYPE, _0$> zeroOrNegative)
    {
        return new ZeroOrNegative<>(zeroOrNegative);
    }

    @Override
    public TYPE getValue()
    {
        return zeroOrNegative.getValue();
    }

    @Override
    public TypeEncodedInteger<_0$> getMaximum()
    {
        return zeroOrNegative.getMaximum();
    }

    @Override
    public String toString()
    {
        return "ZeroOrNegative{" +
                "zeroOrNegative=" + zeroOrNegative +
                '}';
    }
}
