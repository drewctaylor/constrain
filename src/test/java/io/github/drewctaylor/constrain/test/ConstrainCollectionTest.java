package io.github.drewctaylor.constrain.test;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static io.github.drewctaylor.constrain.ConstrainCollection.constrainEmpty;
import static io.github.drewctaylor.constrain.ConstrainCollection.constrainNonEmpty;
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
    //
    // private static <TYPE, COLLECTION extends Collection<TYPE>> void testConstrainSizeHelper(
    // final List<COLLECTION> list)
    // {
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) < 0).forEach(value -> assertThrows(NullPointerException.class, () ->
    // constrainSizeLessThan(value, bound, null))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) <= 0).forEach(value -> assertThrows(NullPointerException.class, () ->
    // constrainSizeLessThanOrEqual(value, bound, null))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) == 0).forEach(value -> assertThrows(NullPointerException.class, () ->
    // constrainSize(value, bound, null))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) >= 0).forEach(value -> assertThrows(NullPointerException.class, () ->
    // constrainSizeGreaterThanOrEqual(value, bound, null))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) > 0).forEach(value -> assertThrows(NullPointerException.class, () ->
    // constrainSizeGreaterThan(value, bound, null))));
    //
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) < 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeLessThan(value, bound, ""))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) <= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeLessThanOrEqual(value, bound, ""))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) == 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSize(value, bound, ""))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeGreaterThanOrEqual(value, bound, ""))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeGreaterThan(value, bound, ""))));
    //
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) < 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeLessThan(value, bound, " "))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) <= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeLessThanOrEqual(value, bound, " "))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) == 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSize(value, bound, " "))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeGreaterThanOrEqual(value, bound, " "))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeGreaterThan(value, bound, " "))));
    //
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) < 0).forEach(value -> assertEquals(value, constrainSizeLessThan(value, bound,
    // "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) <= 0).forEach(value -> assertEquals(value, constrainSizeLessThanOrEqual(value,
    // bound, "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) == 0).forEach(value -> assertEquals(value, constrainSize(value, bound,
    // "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) >= 0).forEach(value -> assertEquals(value,
    // constrainSizeGreaterThanOrEqual(value, bound, "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) > 0).forEach(value -> assertEquals(value, constrainSizeGreaterThan(value,
    // bound, "name"))));
    //
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeLessThan(value, bound, "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeLessThanOrEqual(value, bound, "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) != 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSize(value, bound, "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) < 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeGreaterThanOrEqual(value, bound, "name"))));
    // list.stream().map(Collection::size).forEach(bound -> list.stream().filter(value ->
    // valueOf(value.size()).compareTo(bound) <= 0).forEach(value -> assertThrows(IllegalArgumentException.class, () ->
    // constrainSizeGreaterThan(value, bound, "name"))));
    //
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) <= 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSizeExclusive(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) < 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSize(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) <= 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSizeMinimumExclusiveMaximumInclusive(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) < 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSizeMinimumInclusiveMaximumExclusive(value, boundMinimum, boundMaximum, "name")))));
    //
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) > 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) < 0).forEach(value -> assertEquals(value, constrainSizeExclusive(value,
    // boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) >= 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) <= 0).forEach(value -> assertEquals(value, constrainSize(value,
    // boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) > 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) <= 0).forEach(value -> assertEquals(value,
    // constrainSizeMinimumExclusiveMaximumInclusive(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Collection::size).forEach(boundMinimum -> list.stream().map(Collection::size).forEach(boundMaximum
    // -> list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) >= 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) < 0).forEach(value -> assertEquals(value,
    // constrainSizeMinimumInclusiveMaximumExclusive(value, boundMinimum, boundMaximum, "name")))));
    // }
    //
    // @Test
    // void testConstrainSize()
    // {
    // testConstrainSizeHelper(range(0, 6).mapToObj(i -> range(0, i + 1).mapToObj(index -> new
    // Object()).collect(toList())).collect(toList()));
    // testConstrainSizeHelper(range(0, 6).mapToObj(i -> range(0, i + 1).mapToObj(index -> new
    // Object()).collect(toSet())).collect(toList()));
    // }
}
