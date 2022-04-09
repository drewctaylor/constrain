package io.github.drewctaylor.constrain.test;

import io.github.drewctaylor.constrain.ConstrainBound.Inclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.constrain.ConstrainBound.MaximumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.Minimum;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.constrain.number.ConstrainNumberBigDecimal;
import io.github.drewctaylor.constrain.number.ConstrainNumberBigInteger;
import io.github.drewctaylor.constrain.number.ConstrainNumberByte;
import io.github.drewctaylor.constrain.number.ConstrainNumberDouble;
import io.github.drewctaylor.constrain.number.ConstrainNumberFloat;
import io.github.drewctaylor.constrain.number.ConstrainNumberInteger;
import io.github.drewctaylor.constrain.number.ConstrainNumberLong;
import io.github.drewctaylor.constrain.number.ConstrainNumberShort;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.iterate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class ConstrainNumberTest
{

    private static <TYPE extends Comparable<TYPE>> void testBoundNumber(
            final List<TYPE> negativeList,
            final List<TYPE> positiveList,
            final TYPE zero,
            final BiFunction<TYPE, String, MaximumExclusive<TYPE, _0$>> boundNegative,
            final BiFunction<TYPE, String, MinimumExclusive<TYPE, _0$>> boundPositive,
            final BiFunction<TYPE, String, Inclusive<TYPE, _0$, _0$>> boundZero,
            final BiFunction<TYPE, String, Maximum<TYPE, _0$>> boundZeroOrNegative,
            final BiFunction<TYPE, String, Minimum<TYPE, _0$>> boundZeroOrPositive)
    {
        assertThrows(NullPointerException.class, () -> boundNegative.apply(null, "name"));
        assertThrows(NullPointerException.class, () -> boundPositive.apply(null, "name"));
        assertThrows(NullPointerException.class, () -> boundZero.apply(null, "name"));
        assertThrows(NullPointerException.class, () -> boundZeroOrNegative.apply(null, "name"));
        assertThrows(NullPointerException.class, () -> boundZeroOrPositive.apply(null, "name"));

        assertThrows(NullPointerException.class, () -> boundNegative.apply(zero, null));
        assertThrows(NullPointerException.class, () -> boundPositive.apply(zero, null));
        assertThrows(NullPointerException.class, () -> boundZero.apply(zero, null));
        assertThrows(NullPointerException.class, () -> boundZeroOrNegative.apply(zero, null));
        assertThrows(NullPointerException.class, () -> boundZeroOrPositive.apply(zero, null));

        assertThrows(IllegalArgumentException.class, () -> boundNegative.apply(zero, ""));
        assertThrows(IllegalArgumentException.class, () -> boundPositive.apply(zero, ""));
        assertThrows(IllegalArgumentException.class, () -> boundZero.apply(zero, ""));
        assertThrows(IllegalArgumentException.class, () -> boundZeroOrNegative.apply(zero, ""));
        assertThrows(IllegalArgumentException.class, () -> boundZeroOrPositive.apply(zero, ""));

        negativeList.stream().forEach(negative -> assertEquals(negative, boundNegative.apply(negative, "name").getValue()));
        negativeList.stream().forEach(negative -> assertEquals(0, boundNegative.apply(negative, "name").getMaximum().toInt()));
        negativeList.stream().forEach(negative -> assertThrows(IllegalArgumentException.class, () -> boundPositive.apply(negative, "name")));
        negativeList.stream().forEach(negative -> assertThrows(IllegalArgumentException.class, () -> boundZero.apply(negative, "name")));
        negativeList.stream().forEach(negative -> assertEquals(negative, boundZeroOrNegative.apply(negative, "name").getValue()));
        negativeList.stream().forEach(negative -> assertEquals(0, boundZeroOrNegative.apply(negative, "name").getMaximum().toInt()));
        negativeList.stream().forEach(negative -> assertThrows(IllegalArgumentException.class, () -> boundZeroOrPositive.apply(negative, "name")));

        positiveList.stream().forEach(positive -> assertThrows(IllegalArgumentException.class, () -> boundNegative.apply(positive, "name")));
        positiveList.stream().forEach(positive -> assertEquals(positive, boundPositive.apply(positive, "name").getValue()));
        positiveList.stream().forEach(positive -> assertEquals(0, boundPositive.apply(positive, "name").getMinimum().toInt()));
        positiveList.stream().forEach(positive -> assertThrows(IllegalArgumentException.class, () -> boundZero.apply(positive, "name")));
        positiveList.stream().forEach(positive -> assertThrows(IllegalArgumentException.class, () -> boundZeroOrNegative.apply(positive, "name")));
        positiveList.stream().forEach(positive -> assertEquals(positive, boundZeroOrPositive.apply(positive, "name").getValue()));
        positiveList.stream().forEach(positive -> assertEquals(0, boundZeroOrPositive.apply(zero, "name").getMinimum().toInt()));

        assertThrows(IllegalArgumentException.class, () -> boundNegative.apply(zero, "name"));
        assertThrows(IllegalArgumentException.class, () -> boundPositive.apply(zero, "name"));
        assertEquals(zero, boundZero.apply(zero, "name").getValue());
        assertEquals(0, boundZero.apply(zero, "name").getMinimum().toInt());
        assertEquals(0, boundZero.apply(zero, "name").getMaximum().toInt());
        assertEquals(zero, boundZeroOrNegative.apply(zero, "name").getValue());
        assertEquals(0, boundZeroOrNegative.apply(zero, "name").getMaximum().toInt());
        assertEquals(zero, boundZeroOrPositive.apply(zero, "name").getValue());
        assertEquals(0, boundZeroOrPositive.apply(zero, "name").getMinimum().toInt());
    }

    @Test
    void testBoundBigDecimal()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate(-1L, l -> l - 1L).limit(maxSize).map(BigDecimal::valueOf).collect(toList()),
                iterate(1L, l -> l + 1L).limit(maxSize).map(BigDecimal::valueOf).collect(toList()),
                BigDecimal.ZERO,
                ConstrainNumberBigDecimal::constrainNegative,
                ConstrainNumberBigDecimal::constrainPositive,
                ConstrainNumberBigDecimal::constrainZero,
                ConstrainNumberBigDecimal::constrainZeroOrNegative,
                ConstrainNumberBigDecimal::constrainZeroOrPositive);
    }

    @Test
    void testBoundBigInteger()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate(-1L, l -> l - 1L).limit(maxSize).map(BigInteger::valueOf).collect(toList()),
                iterate(1L, l -> l + 1L).limit(maxSize).map(BigInteger::valueOf).collect(toList()),
                BigInteger.ZERO,
                ConstrainNumberBigInteger::constrainNegative,
                ConstrainNumberBigInteger::constrainPositive,
                ConstrainNumberBigInteger::constrainZero,
                ConstrainNumberBigInteger::constrainZeroOrNegative,
                ConstrainNumberBigInteger::constrainZeroOrPositive);
    }

    @SuppressWarnings("NumericCastThatLosesPrecision")
    @Test
    void testBoundByte()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate((byte) -1, b -> (byte) (b - 1)).limit(maxSize).collect(toList()),
                iterate((byte) 1, b -> (byte) (b + 1)).limit(maxSize).collect(toList()),
                (byte) 0,
                ConstrainNumberByte::constrainNegative,
                ConstrainNumberByte::constrainPositive,
                ConstrainNumberByte::constrainZero,
                ConstrainNumberByte::constrainZeroOrNegative,
                ConstrainNumberByte::constrainZeroOrPositive);
    }

    @Test
    void testBoundDouble()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate(-1.0, d -> d - 1.0).limit(maxSize).collect(toList()),
                iterate(1.0, d -> d + 1.0).limit(maxSize).collect(toList()),
                0.0,
                ConstrainNumberDouble::constrainNegative,
                ConstrainNumberDouble::constrainPositive,
                ConstrainNumberDouble::constrainZero,
                ConstrainNumberDouble::constrainZeroOrNegative,
                ConstrainNumberDouble::constrainZeroOrPositive);
    }

    @Test
    void testBoundFloat()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate(-1.0f, f -> f - 1.0f).limit(maxSize).collect(toList()),
                iterate(1.0f, f -> f + 1.0f).limit(maxSize).collect(toList()),
                0.0f,
                ConstrainNumberFloat::constrainNegative,
                ConstrainNumberFloat::constrainPositive,
                ConstrainNumberFloat::constrainZero,
                ConstrainNumberFloat::constrainZeroOrNegative,
                ConstrainNumberFloat::constrainZeroOrPositive);
    }

    @Test
    void testBoundInt()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate(-1, i -> i - 1).limit(maxSize).collect(toList()),
                iterate(1, i -> i + 1).limit(maxSize).collect(toList()),
                0,
                ConstrainNumberInteger::constrainNegative,
                ConstrainNumberInteger::constrainPositive,
                ConstrainNumberInteger::constrainZero,
                ConstrainNumberInteger::constrainZeroOrNegative,
                ConstrainNumberInteger::constrainZeroOrPositive);
    }

    @Test
    void testBoundLong()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate(-1L, l -> l - 1L).limit(maxSize).collect(toList()),
                iterate(1L, l -> l + 1L).limit(maxSize).collect(toList()),
                0L,
                ConstrainNumberLong::constrainNegative,
                ConstrainNumberLong::constrainPositive,
                ConstrainNumberLong::constrainZero,
                ConstrainNumberLong::constrainZeroOrNegative,
                ConstrainNumberLong::constrainZeroOrPositive);
    }

    @SuppressWarnings("NumericCastThatLosesPrecision")
    @Test
    void testBoundShort()
    {
        final long maxSize = 5L;

        testBoundNumber(
                iterate((short) -1, sh -> (short) (sh - 1)).limit(maxSize).collect(toList()),
                iterate((short) 1, sh -> (short) (sh + 1)).limit(maxSize).collect(toList()),
                (short) 0,
                ConstrainNumberShort::constrainNegative,
                ConstrainNumberShort::constrainPositive,
                ConstrainNumberShort::constrainZero,
                ConstrainNumberShort::constrainZeroOrNegative,
                ConstrainNumberShort::constrainZeroOrPositive);
    }
}
