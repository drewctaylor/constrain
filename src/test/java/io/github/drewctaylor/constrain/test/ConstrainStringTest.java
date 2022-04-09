package io.github.drewctaylor.constrain.test;

import io.github.drewctaylor.constrain.ConstrainBound.Maximum;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusive;
import io.github.drewctaylor.constrain.ConstrainBound.MinimumExclusiveMaximumInclusive;
import io.github.drewctaylor.constrain.NonEmpty;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0$;
import io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1$;
import org.junit.jupiter.api.Test;

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
import static io.github.drewctaylor.constrain.NonEmpty.fromMinimumExclusive;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._2;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class ConstrainStringTest
{
    @Test
    void testRequireEmpty()
    {
        final String invalid = "a";
        final String valid = "";

        assertThrows(NullPointerException.class, () -> constrainEmpty(valid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valid, " "));

        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(invalid, "name"));
        assertEquals(valid, constrainEmpty(valid, "name").getValue());
    }

    @Test
    void testRequireNonEmpty()
    {
        final String invalid = "";
        final String valid = "a";

        assertThrows(NullPointerException.class, () -> constrainNonEmpty(valid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(valid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(valid, " "));

        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(invalid, "name"));
        assertEquals(valid, constrainNonEmpty(valid, "name").getValue());
    }

    @Test
    void testRequireLength()
    {
        assertThrows(NullPointerException.class, () -> constrainLengthLessThan("", integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainLengthLessThanOrEqual("", integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainLength("", integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainLengthGreaterThanOrEqual("", integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainLengthGreaterThan("", integer(_0()), null));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThan("", integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThanOrEqual("", integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLength("", integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThanOrEqual("", integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThan("", integer(_0()), ""));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThan("", integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThanOrEqual("", integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLength("", integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThanOrEqual("", integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThan("", integer(_0()), " "));

        assertThrows(NullPointerException.class, () -> constrainLengthExclusive("", integer(_0()), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainLength("", integer(_0()), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive("", integer(_0()), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive("", integer(_0()), integer(_0()), null));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthExclusive("", integer(_0()), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLength("", integer(_0()), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive("", integer(_0()), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive("", integer(_0()), integer(_0()), ""));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthExclusive("", integer(_0()), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLength("", integer(_0()), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive("", integer(_0()), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive("", integer(_0()), integer(_0()), " "));

        assertEquals("0", constrainLengthLessThan("0", integer(_2()), "name").getValue());
        assertEquals("0", constrainLengthLessThanOrEqual("0", integer(_1()), "name").getValue());
        assertEquals("0", constrainLength("0", integer(_1()), "name").getValue());
        assertEquals("0", constrainLengthGreaterThanOrEqual("0", integer(_1()), "name").getValue());
        assertEquals("0", constrainLengthGreaterThan("0", integer(_0()), "name").getValue());

        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThan("0", integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthLessThanOrEqual("0", integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLength("0", integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThanOrEqual("0", integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthGreaterThan("0", integer(_1()), "name"));

        assertThrows(IllegalArgumentException.class, () -> constrainLengthExclusive("0", integer(_1()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthExclusive("0", integer(_0()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLength("0", integer(_2()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLength("0", integer(_1()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive("0", integer(_1()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumExclusiveMaximumInclusive("0", integer(_0()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive("0", integer(_2()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainLengthMinimumInclusiveMaximumExclusive("0", integer(_1()), integer(_1()), "name"));

        assertEquals("0", constrainLengthExclusive("0", integer(_0()), integer(_2()), "name").getValue());
        assertEquals("0", constrainLength("0", integer(_1()), integer(_1()), "name").getValue());
        assertEquals("0", constrainLengthMinimumExclusiveMaximumInclusive("0", integer(_0()), integer(_1()), "name").getValue());
        assertEquals("0", constrainLengthMinimumInclusiveMaximumExclusive("0", integer(_1()), integer(_2()), "name").getValue());
    }

    @SuppressWarnings(
    { "RedundantExplicitVariableType", "unused" })
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

        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1a = constrainLengthMinimumExclusiveMaximumInclusive("0", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1a");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1b = constrainLengthMinimumExclusiveMaximumInclusive("01", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1b");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1c = constrainLengthMinimumExclusiveMaximumInclusive("012", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1c");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1d = constrainLengthMinimumExclusiveMaximumInclusive("0123", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1d");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1e = constrainLengthMinimumExclusiveMaximumInclusive("01234", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1e");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1f = constrainLengthMinimumExclusiveMaximumInclusive("012345", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1f");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1g = constrainLengthMinimumExclusiveMaximumInclusive("0123456", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1g");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1h = constrainLengthMinimumExclusiveMaximumInclusive("01234567", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1h");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1i = constrainLengthMinimumExclusiveMaximumInclusive("012345678", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1i");
        final MinimumExclusiveMaximumInclusive<String, _0$, _1<_0$>> stringMaximum10Minimum1j = constrainLengthMinimumExclusiveMaximumInclusive("0123456789", integer(_0()), integer(_1(_0())), "stringMaximum10Minimum1j");

        testStringMaximum10(stringMaximum10a);
        testStringMaximum10(stringMaximum10b);
        testStringMaximum10(stringMaximum10c);
        testStringMaximum10(stringMaximum10d);
        testStringMaximum10(stringMaximum10e);
        testStringMaximum10(stringMaximum10f);
        testStringMaximum10(stringMaximum10g);
        testStringMaximum10(stringMaximum10h);
        testStringMaximum10(stringMaximum10i);
        testStringMaximum10(stringMaximum10j);

        testStringMaximum10(stringMaximum10Minimum1a);
        testStringMaximum10(stringMaximum10Minimum1b);
        testStringMaximum10(stringMaximum10Minimum1c);
        testStringMaximum10(stringMaximum10Minimum1d);
        testStringMaximum10(stringMaximum10Minimum1e);
        testStringMaximum10(stringMaximum10Minimum1f);
        testStringMaximum10(stringMaximum10Minimum1g);
        testStringMaximum10(stringMaximum10Minimum1h);
        testStringMaximum10(stringMaximum10Minimum1i);
        testStringMaximum10(stringMaximum10Minimum1j);

        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1a));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1b));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1c));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1d));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1e));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1f));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1g));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1h));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1i));
        testStringMinimumExclusive(fromMinimumExclusive(stringMaximum10Minimum1j));

        final Maximum<String, _1<_1$>> stringMaximum11 = constrainLengthLessThanOrEqual("01234567890", integer(_1(_1())), "stringMaximum11");

        // commented lines should not compile

        // testStringMaximum10(stringMaximum11);
        // testStringNonEmpty(stringMaximum10a);
        // testStringNonEmpty(stringMaximum10b);
        // testStringNonEmpty(stringMaximum10c);
        // testStringNonEmpty(stringMaximum10d);
        // testStringNonEmpty(stringMaximum10e);
        // testStringNonEmpty(stringMaximum10f);
        // testStringNonEmpty(stringMaximum10g);
        // testStringNonEmpty(stringMaximum10h);
        // testStringNonEmpty(stringMaximum10i);
        // testStringNonEmpty(stringMaximum10j);
    }

    @SuppressWarnings("unused")
    void testStringMaximum10(
            final Maximum<String, _1<_0$>> stringMaximum10)
    {
    }

    @SuppressWarnings("unused")
    void testStringMinimumExclusive(
            final MinimumExclusive<String, _0$> stringMinimumExclusive)
    {
    }

    @SuppressWarnings("unused")
    void testStringNonEmpty(
            final NonEmpty<String> stringNonEmpty)
    {
    }
}
