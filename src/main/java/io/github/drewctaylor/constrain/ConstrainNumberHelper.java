package io.github.drewctaylor.constrain;

import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.constrain.ConstrainBound.MaximumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Minimum;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedIntegerConcrete;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.TypeEncodedInteger;

import static io.github.drewctaylor.constrain.ConstrainBound.constrain;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMaximumExclusive;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimum;
import static io.github.drewctaylor.constrain.ConstrainBound.constrainMinimumExclusive;

final class ConstrainNumberHelper<TYPE, ZERO extends TypeEncodedInteger<ZERO>>
{
    private final TypeEncodedIntegerConcrete<ZERO> zero;

    ConstrainNumberHelper(
            final TypeEncodedIntegerConcrete<ZERO> zero)
    {
        this.zero = zero;
    }

    MinimumExclusive<TYPE, ZERO> constrainPositive(
            final TYPE value)
    {
        return constrainMinimumExclusive(value, zero);
    }

    Minimum<TYPE, ZERO> constrainZeroOrPositive(
            final TYPE value)
    {
        return constrainMinimum(value, zero);
    }

    Inclusive<TYPE, ZERO, ZERO> constrainZero(
            final TYPE value)
    {
        return constrain(value, zero, zero);
    }

    Maximum<TYPE, ZERO> constrainZeroOrNegative(
            final TYPE value)
    {
        return constrainMaximum(value, zero);
    }

    MaximumExclusive<TYPE, ZERO> constrainNegative(
            final TYPE value)
    {
        return constrainMaximumExclusive(value, zero);
    }
}
