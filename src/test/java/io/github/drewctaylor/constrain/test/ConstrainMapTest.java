package io.github.drewctaylor.constrain.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
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
        final Map<Object, Object> valueInvalid = singletonMap(new Object(), new Object());
        final Map<Object, Object> valueValid = emptyMap();

        assertThrows(NullPointerException.class, () -> constrainEmpty(valueValid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueValid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueValid, " "));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueInvalid, "name"));
        assertEquals(valueValid, constrainEmpty(valueValid, "name").getValue());
    }

    @Test
    void testConstrainNonEmpty()
    {
        final Map<Object, Object> valid = singletonMap(new Object(), new Object());

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

        final HashMap<Integer, String> map = new HashMap<Integer, String>()
        {
            {
                put(0, "zero");
            }
        };

        assertEquals(map, constrainSizeLessThan(map, integer(_2()), "name").getValue());
        assertEquals(map, constrainSizeLessThanOrEqual(map, integer(_1()), "name").getValue());
        assertEquals(map, constrainSize(map, integer(_1()), "name").getValue());
        assertEquals(map, constrainSizeGreaterThanOrEqual(map, integer(_1()), "name").getValue());
        assertEquals(map, constrainSizeGreaterThan(map, integer(_0()), "name").getValue());

        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThan(map, integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThanOrEqual(map, integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(map, integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThanOrEqual(map, integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThan(map, integer(_1()), "name"));

        assertThrows(IllegalArgumentException.class, () -> constrainSizeExclusive(map, integer(_0()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeExclusive(map, integer(_1()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(map, integer(_1()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSize(map, integer(_2()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumExclusiveMaximumInclusive(map, integer(_1()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumExclusiveMaximumInclusive(map, integer(_0()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumInclusiveMaximumExclusive(map, integer(_2()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> constrainSizeMinimumInclusiveMaximumExclusive(map, integer(_1()), integer(_1()), "name"));

        assertEquals(map, constrainSizeExclusive(map, integer(_0()), integer(_2()), "name").getValue());
        assertEquals(map, constrainSize(map, integer(_1()), integer(_1()), "name").getValue());
        assertEquals(map, constrainSizeMinimumExclusiveMaximumInclusive(map, integer(_0()), integer(_1()), "name").getValue());
        assertEquals(map, constrainSizeMinimumInclusiveMaximumExclusive(map, integer(_1()), integer(_2()), "name").getValue());
    }
}
