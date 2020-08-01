package io.github.drewctaylor.constrain.test;

import io.github.drewctaylor.constrain.ConstrainCollection;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static io.github.drewctaylor.constrain.ConstrainCollection.constrainEmpty;
import static io.github.drewctaylor.constrain.ConstrainCollection.constrainNonEmpty;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._0;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._1;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder._2;
import static io.github.drewctaylor.typeencoded.TypeEncodedIntegerBuilder.integer;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class ConstrainCollectionTest
{
    @Test
    void testConstrainEmpty()
    {
        final Collection<Object> valueInvalid = singletonList(new Object());
        final Collection<Object> valueValid = emptyList();

        assertThrows(NullPointerException.class, () -> constrainEmpty(valueValid, null));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueValid, ""));
        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueValid, " "));

        assertThrows(IllegalArgumentException.class, () -> constrainEmpty(valueInvalid, "name"));
        assertEquals(valueValid, constrainEmpty(valueValid, "name").getValue());
    }

    @Test
    void testConstrainNonEmpty()
    {
        final var valid = singletonList(new Object());

        assertThrows(NullPointerException.class, () -> constrainNonEmpty(emptyList(), null));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(emptyList(), ""));
        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(emptyList(), " "));

        assertThrows(IllegalArgumentException.class, () -> constrainNonEmpty(emptyList(), "name"));
        assertEquals(valid, constrainNonEmpty(valid, "name").getValue());
    }

    @Test
    void testConstrainSize()
    {

        assertThrows(NullPointerException.class, () -> ConstrainCollection.constrainSizeLessThan(emptyList(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> ConstrainCollection.constrainSizeLessThanOrEqual(emptyList(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> ConstrainCollection.constrainSize(emptyList(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> ConstrainCollection.constrainSizeGreaterThanOrEqual(emptyList(), integer(_0()), null));
        assertThrows(NullPointerException.class, () -> ConstrainCollection.constrainSizeGreaterThan(emptyList(), integer(_0()), null));

        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeLessThan(emptyList(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeLessThanOrEqual(emptyList(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSize(emptyList(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeGreaterThanOrEqual(emptyList(), integer(_0()), ""));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeGreaterThan(emptyList(), integer(_0()), ""));

        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeLessThan(emptyList(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeLessThanOrEqual(emptyList(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSize(emptyList(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeGreaterThanOrEqual(emptyList(), integer(_0()), " "));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeGreaterThan(emptyList(), integer(_0()), " "));

        assertEquals(List.of(0), ConstrainCollection.constrainSizeLessThan(List.of(0), integer(_2()), "name").getValue());
        assertEquals(List.of(0), ConstrainCollection.constrainSizeLessThanOrEqual(List.of(0), integer(_1()), "name").getValue());
        assertEquals(List.of(0), ConstrainCollection.constrainSize(List.of(0), integer(_1()), "name").getValue());
        assertEquals(List.of(0), ConstrainCollection.constrainSizeGreaterThanOrEqual(List.of(0), integer(_1()), "name").getValue());
        assertEquals(List.of(0), ConstrainCollection.constrainSizeGreaterThan(List.of(0), integer(_0()), "name").getValue());

        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeLessThan(List.of(0), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeLessThanOrEqual(List.of(0), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSize(List.of(0), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeGreaterThanOrEqual(List.of(0), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeGreaterThan(List.of(0), integer(_1()), "name"));

        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeExclusive(List.of(0), integer(_0()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeExclusive(List.of(0), integer(_1()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSize(List.of(0), integer(_1()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSize(List.of(0), integer(_2()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeMinimumExclusiveMaximumInclusive(List.of(0), integer(_1()), integer(_1()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeMinimumExclusiveMaximumInclusive(List.of(0), integer(_0()), integer(_0()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeMinimumInclusiveMaximumExclusive(List.of(0), integer(_2()), integer(_2()), "name"));
        assertThrows(IllegalArgumentException.class, () -> ConstrainCollection.constrainSizeMinimumInclusiveMaximumExclusive(List.of(0), integer(_1()), integer(_1()), "name"));

        assertEquals(List.of(0), ConstrainCollection.constrainSizeExclusive(List.of(0), integer(_0()), integer(_2()), "name").getValue());
        assertEquals(List.of(0), ConstrainCollection.constrainSize(List.of(0), integer(_1()), integer(_1()), "name").getValue());
        assertEquals(List.of(0), ConstrainCollection.constrainSizeMinimumExclusiveMaximumInclusive(List.of(0), integer(_0()), integer(_1()), "name").getValue());
        assertEquals(List.of(0), ConstrainCollection.constrainSizeMinimumInclusiveMaximumExclusive(List.of(0), integer(_1()), integer(_2()), "name").getValue());
    }
}
