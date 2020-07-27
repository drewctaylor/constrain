package io.github.drewctaylor.constrain.test;

import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1$;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.github.drewctaylor.constrain.ConstrainString.constrainEmpty;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLength;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLengthExclusive;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLengthGreaterThan;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLengthGreaterThanOrEqual;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLengthLessThan;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLengthLessThanOrEqual;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLengthMinimumExclusiveMaximumInclusive;
import static io.github.drewctaylor.constrain.ConstrainString.constrainLengthMinimumInclusiveMaximumExclusive;
import static io.github.drewctaylor.constrain.ConstrainString.constrainNonEmpty;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class ConstrainStringTest
{
    @Test
    void testRequireEmpty()
    {
        final var invalid = "a";
        final var valid = "";

        assertThrows(NullPointerException.class, () -> constrainEmpty(valid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valid, " "));

        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(invalid, "name"));
        assertEquals(valid, constrainEmpty(valid, "name").getValue());
    }

    @Test
    void testRequireNonEmpty()
    {
        final var invalid = "";
        final var valid = "a";

        assertThrows(NullPointerException.class, () -> constrainNonEmpty(valid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(valid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(valid, " "));

        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(invalid, "name"));
        assertEquals(valid, constrainNonEmpty(valid, "name").getValue());
    }

    private static void testRequireLengthHelper(
            final List<String> list)
    {
        assertThrows(NullPointerException.class, () -> constrainLengthLessThan(list.get(0), integer(_1(_0())), null));
        assertThrows(NullPointerException.class, () -> constrainLengthLessThanOrEqual(list.get(0), integer(_1(_0())), null));
        assertThrows(NullPointerException.class, () -> constrainLength(list.get(0), integer(_1(_0())), null));
        assertThrows(NullPointerException.class, () -> constrainLengthGreaterThanOrEqual(list.get(0), integer(_1(_0())), null));
        assertThrows(NullPointerException.class, () -> constrainLengthGreaterThan(list.get(0), integer(_1(_0())), null));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThan(list.get(0), integer(_1(_0())), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThanOrEqual(list.get(0), integer(_1(_0())), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLength(list.get(0), integer(_1(_0())), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThanOrEqual(list.get(0), integer(_1(_0())), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThan(list.get(0), integer(_1(_0())), ""));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThan(list.get(0), integer(_1(_0())), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThanOrEqual(list.get(0), integer(_1(_0())), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLength(list.get(0), integer(_1(_0())), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThanOrEqual(list.get(0), integer(_1(_0())), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThan(list.get(0), integer(_1(_0())), " "));

        assertThrows(NullPointerException.class, () -> constrainLengthExclusive(list.get(0), integer(_0()), integer(_1(_0())), null));
        assertThrows(NullPointerException.class, () -> constrainLength(list.get(0), integer(_0()), integer(_1(_0())), null));
        assertThrows(NullPointerException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive(list.get(0), integer(_0()), integer(_1(_0())), null));
        assertThrows(NullPointerException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive(list.get(0), integer(_0()), integer(_1(_0())), null));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthExclusive(list.get(0), integer(_0()), integer(_1(_0())), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLength(list.get(0), integer(_0()), integer(_1(_0())), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive(list.get(0), integer(_0()), integer(_1(_0())), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive(list.get(0), integer(_0()), integer(_1(_0())), ""));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthExclusive(list.get(0), integer(_0()), integer(_1(_0())), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLength(list.get(0), integer(_0()), integer(_1(_0())), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive(list.get(0), integer(_0()), integer(_1(_0())), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive(list.get(0), integer(_0()), integer(_1(_0())), " "));
        //
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) < 0).forEach(value -> assertEquals(value, constrainLengthLessThan(value,
        // bound, "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) <= 0).forEach(value -> assertEquals(value,
        // constrainLengthLessThanOrEqual(value, bound, "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) == 0).forEach(value -> assertEquals(value, constrainLength(value, bound,
        // "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) >= 0).forEach(value -> assertEquals(value,
        // constrainLengthGreaterThanOrEqual(value, bound, "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) > 0).forEach(value -> assertEquals(value, constrainLengthGreaterThan(value,
        // bound, "name"))));
        //
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
        // constrainLengthLessThan(value, bound, "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
        // constrainLengthLessThanOrEqual(value, bound, "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) != 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
        // constrainLength(value, bound, "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) < 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
        // constrainLengthGreaterThanOrEqual(value, bound, "name"))));
        // list.stream().map(String::length).forEach(bound -> list.stream().filter(value ->
        // valueOf(value.length()).compareTo(bound) <= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
        // constrainLengthGreaterThan(value, bound, "name"))));
        //
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) <= 0 ||
        // valueOf(value.length()).compareTo(boundMaximum) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class,
        // () -> constrainLengthExclusive(value, boundMinimum, boundMaximum, "name")))));
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) < 0 ||
        // valueOf(value.length()).compareTo(boundMaximum) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
        // -> constrainLength(value, boundMinimum, boundMaximum, "name")))));
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) <= 0 ||
        // valueOf(value.length()).compareTo(boundMaximum) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
        // -> constrainLengthMinimumExclusiveMaximumInclusive(value, boundMinimum, boundMaximum, "name")))));
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) < 0 ||
        // valueOf(value.length()).compareTo(boundMaximum) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class,
        // () -> constrainLengthMinimumInclusiveMaximumExclusive(value, boundMinimum, boundMaximum, "name")))));
        //
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) > 0 &&
        // valueOf(value.length()).compareTo(boundMaximum) < 0).forEach(value -> assertEquals(value,
        // constrainLengthExclusive(value, boundMinimum, boundMaximum, "name")))));
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) >= 0 &&
        // valueOf(value.length()).compareTo(boundMaximum) <= 0).forEach(value -> assertEquals(value, constrainLength(value,
        // boundMinimum, boundMaximum, "name")))));
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) > 0 &&
        // valueOf(value.length()).compareTo(boundMaximum) <= 0).forEach(value -> assertEquals(value,
        // constrainLengthMinimumExclusiveMaximumInclusive(value, boundMinimum, boundMaximum, "name")))));
        // list.stream().map(String::length).forEach(boundMinimum -> list.stream().map(String::length).forEach(boundMaximum ->
        // list.stream().filter(value -> valueOf(value.length()).compareTo(boundMinimum) >= 0 &&
        // valueOf(value.length()).compareTo(boundMaximum) < 0).forEach(value -> assertEquals(value,
        // constrainLengthMinimumInclusiveMaximumExclusive(value, boundMinimum, boundMaximum, "name")))));
    }

    @Test
    void testRequireLength()
    {
        // noinspection NumericCastThatLosesPrecision,CharUsedInArithmeticContext
        testRequireLengthHelper(range(0, 6).mapToObj(i -> range(0, i + 1).mapToObj(index -> (char) ('a' + index)).map(String::valueOf).reduce("", String::concat)).collect(toList()));
    }

    @SuppressWarnings("RedundantExplicitVariableType")
    @Test
    void testExample()
    {
        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThanOrEqual("01234567890", integer(_1(_0())), "stringMaximum10B"));

        final Maximum<String, _1<_0$>> stringMaximum10a = constrainLengthLessThanOrEqual("0", integer(_1(_0())), "stringMaximum10a");
        final Maximum<String, _1<_0$>> stringMaximum10b = constrainLengthLessThanOrEqual("01", integer(_1(_0())), "stringMaximum10b");
        final Maximum<String, _1<_0$>> stringMaximum10c = constrainLengthLessThanOrEqual("012", integer(_1(_0())), "stringMaximum10c");
        final Maximum<String, _1<_0$>> stringMaximum10d = constrainLengthLessThanOrEqual("0123", integer(_1(_0())), "stringMaximum10d");
        final Maximum<String, _1<_0$>> stringMaximum10e = constrainLengthLessThanOrEqual("01234", integer(_1(_0())), "stringMaximum10e");
        final Maximum<String, _1<_0$>> stringMaximum10f = constrainLengthLessThanOrEqual("012345", integer(_1(_0())), "stringMaximum10f");
        final Maximum<String, _1<_0$>> stringMaximum10g = constrainLengthLessThanOrEqual("0123456", integer(_1(_0())), "stringMaximum10g");
        final Maximum<String, _1<_0$>> stringMaximum10h = constrainLengthLessThanOrEqual("01234567", integer(_1(_0())), "stringMaximum10h");
        final Maximum<String, _1<_0$>> stringMaximum10i = constrainLengthLessThanOrEqual("012345678", integer(_1(_0())), "stringMaximum10i");
        final Maximum<String, _1<_0$>> stringMaximum10j = constrainLengthLessThanOrEqual("0123456789", integer(_1(_0())), "stringMaximum10j");

        test(stringMaximum10a);
        test(stringMaximum10b);
        test(stringMaximum10c);
        test(stringMaximum10d);
        test(stringMaximum10e);
        test(stringMaximum10f);
        test(stringMaximum10g);
        test(stringMaximum10h);
        test(stringMaximum10i);
        test(stringMaximum10j);

        final Maximum<String, _1<_1$>> stringMaximum11 = constrainLengthLessThanOrEqual("01234567890", integer(_1(_1())), "stringMaximum11");

        // commented lines should not compile

        // test(stringMaximum11);
    }

    void test(
            final Maximum<String, _1<_0$>> stringMaximum10)
    {
    }
}
