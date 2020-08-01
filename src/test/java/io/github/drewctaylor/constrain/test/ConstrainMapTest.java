package io.github.drewctaylor.constrain.test;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.github.drewctaylor.constrain.ConstrainMap.constrainEmpty;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainNonEmpty;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSize;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSizeExclusive;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSizeGreaterThan;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSizeGreaterThanOrEqual;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSizeLessThan;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSizeLessThanOrEqual;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSizeMinimumExclusiveMaximumInclusive;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainSizeMinimumInclusiveMaximumExclusive;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._2;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class ConstrainMapTest
{
    @Test
    void testConstrainEmpty()
    {
        final var valueInvalid = singletonMap(new Object(), new Object());
        final var valueValid = emptyMap();

        assertThrows(NullPointerException.class, () -> constrainEmpty(valueValid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueValid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueValid, " "));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueInvalid, "name"));
        assertEquals(valueValid, constrainEmpty(valueValid, "name").getValue());
    }

    @Test
    void testConstrainNonEmpty()
    {
        final var valid = singletonMap(new Object(), new Object());

        assertThrows(NullPointerException.class, () -> constrainNonEmpty(valid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(valid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(valid, " "));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(emptyMap(), "name"));
        assertEquals(valid, constrainNonEmpty(valid, "name").getValue());
    }

    @Test
    void testConstrainSize()
    {
        assertThrows(NullPointerException.class, () -> constrainSizeLessThan(emptyMap(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainSizeLessThanOrEqual(emptyMap(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainSize(emptyMap(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainSizeGreaterThanOrEqual(emptyMap(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> constrainSizeGreaterThan(emptyMap(), integer(_0()), null));

        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThan(emptyMap(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThanOrEqual(emptyMap(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(emptyMap(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThanOrEqual(emptyMap(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThan(emptyMap(), integer(_0()), ""));

        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThan(emptyMap(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThanOrEqual(emptyMap(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(emptyMap(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThanOrEqual(emptyMap(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThan(emptyMap(), integer(_0()), " "));

        assertEquals(Map.of(0, "zero"), constrainSizeLessThan(Map.of(0, "zero"), integer(_2()), "name").getValue());
        assertEquals(Map.of(0, "zero"), constrainSizeLessThanOrEqual(Map.of(0, "zero"), integer(_1()), "name").getValue());
        assertEquals(Map.of(0, "zero"), constrainSize(Map.of(0, "zero"), integer(_1()), "name").getValue());
        assertEquals(Map.of(0, "zero"), constrainSizeGreaterThanOrEqual(Map.of(0, "zero"), integer(_1()), "name").getValue());
        assertEquals(Map.of(0, "zero"), constrainSizeGreaterThan(Map.of(0, "zero"), integer(_0()), "name").getValue());

        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThan(Map.of(0, "zero"), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThanOrEqual(Map.of(0, "zero"), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(Map.of(0, "zero"), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThanOrEqual(Map.of(0, "zero"), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThan(Map.of(0, "zero"), integer(_1()), "name"));

        assertThrows(IllegalArgumentException.class, () -> constrainSizeExclusive(Map.of(0, "zero"), integer(_0()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeExclusive(Map.of(0, "zero"), integer(_1()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(Map.of(0, "zero"), integer(_1()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(Map.of(0, "zero"), integer(_2()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumExclusiveMaximumInclusive(Map.of(0, "zero"), integer(_1()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumExclusiveMaximumInclusive(Map.of(0, "zero"), integer(_0()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumInclusiveMaximumExclusive(Map.of(0, "zero"), integer(_2()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumInclusiveMaximumExclusive(Map.of(0, "zero"), integer(_1()), integer(_1()), "name"));

        assertEquals(Map.of(0, "zero"), constrainSizeExclusive(Map.of(0, "zero"), integer(_0()), integer(_2()), "name").getValue());
        assertEquals(Map.of(0, "zero"), constrainSize(Map.of(0, "zero"), integer(_1()), integer(_1()), "name").getValue());
        assertEquals(Map.of(0, "zero"), constrainSizeMinimumExclusiveMaximumInclusive(Map.of(0, "zero"), integer(_0()), integer(_1()), "name").getValue());
        assertEquals(Map.of(0, "zero"), constrainSizeMinimumInclusiveMaximumExclusive(Map.of(0, "zero"), integer(_1()), integer(_2()), "name").getValue());
    }
}
