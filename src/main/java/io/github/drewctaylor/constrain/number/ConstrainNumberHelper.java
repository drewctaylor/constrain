package io.github.drewctaylor.constrain.number;

import static io.github.drewctaylor.constrain.ConstrainBound.constrain;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximumExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumExclusive;
import static io.github.drewctaylor.constrain.number.Negative.fromMaximumExclusive;
import static io.github.drewctaylor.constrain.number.Positive.fromMinimumExclusive;
import static io.github.drewctaylor.constrain.number.Zero.fromInclusive;
import static io.github.drewctaylor.constrain.number.ZeroOrNegative.fromMaximum;
import static io.github.drewctaylor.constrain.number.ZeroOrPositive.fromMinimum;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;

final class ConstrainNumberHelper<TYPE>
{
    Positive<TYPE> constrainPositive(
            final TYPE value)
    {
        return fromMinimumExclusive(constrainMinimumExclusive(value, integer(_0())));
    }

    ZeroOrPositive<TYPE> constrainZeroOrPositive(
            final TYPE value)
    {
        return fromMinimum(constrainMinimum(value, integer(_0())));
    }

    Zero<TYPE> constrainZero(
            final TYPE value)
    {
        return fromInclusive(constrain(value, integer(_0()), integer(_0())));
    }

    ZeroOrNegative<TYPE> constrainZeroOrNegative(
            final TYPE value)
    {
        return fromMaximum(constrainMaximum(value, integer(_0())));
    }

    Negative<TYPE> constrainNegative(
            final TYPE value)
    {
        return fromMaximumExclusive(constrainMaximumExclusive(value, integer(_0())));
    }
}
