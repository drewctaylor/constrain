package io.github.drewctaylor.constrain.test;

import org.junit.jupiter.api.Test;

import static io.github.drewctaylor.constrain.ConstrainMap.constrainEmpty;
import static io.github.drewctaylor.constrain.ConstrainMap.constrainNonEmpty;
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
    //
    // private static <KEY, VALUE, MAP extends Map<KEY, VALUE>> void testConstrainSizeHelper(
    // final List<MAP> list)
    // {
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <
    // 0).forEach(value -> assertThrows(NullPointerException.class, () -> constrainSizeLessThan(value, bound, null))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <=
    // 0).forEach(value -> assertThrows(NullPointerException.class, () -> constrainSizeLessThanOrEqual(value, bound,
    // null))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) ==
    // 0).forEach(value -> assertThrows(NullPointerException.class, () -> constrainSize(value, bound, null))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >=
    // 0).forEach(value -> assertThrows(NullPointerException.class, () -> constrainSizeGreaterThanOrEqual(value, bound,
    // null))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >
    // 0).forEach(value -> assertThrows(NullPointerException.class, () -> constrainSizeGreaterThan(value, bound, null))));
    //
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThan(value, bound, ""))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <=
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThanOrEqual(value, bound,
    // ""))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) ==
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSize(value, bound, ""))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >=
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThanOrEqual(value, bound,
    // ""))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThan(value, bound, ""))));
    //
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThan(value, bound, " "))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <=
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThanOrEqual(value, bound, "
    // "))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) ==
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSize(value, bound, " "))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >=
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThanOrEqual(value, bound,
    // " "))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThan(value, bound, "
    // "))));
    //
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <
    // 0).forEach(value -> assertEquals(value, constrainSizeLessThan(value, bound, "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <=
    // 0).forEach(value -> assertEquals(value, constrainSizeLessThanOrEqual(value, bound, "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) ==
    // 0).forEach(value -> assertEquals(value, constrainSize(value, bound, "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >=
    // 0).forEach(value -> assertEquals(value, constrainSizeGreaterThanOrEqual(value, bound, "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >
    // 0).forEach(value -> assertEquals(value, constrainSizeGreaterThan(value, bound, "name"))));
    //
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >=
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThan(value, bound,
    // "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) >
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeLessThanOrEqual(value, bound,
    // "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) !=
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSize(value, bound, "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThanOrEqual(value, bound,
    // "name"))));
    // list.stream().map(Map::size).forEach(bound -> list.stream().filter(value -> valueOf(value.size()).compareTo(bound) <=
    // 0).forEach(value -> assertThrows(IllegalArgumentException.class, () -> constrainSizeGreaterThan(value, bound,
    // "name"))));
    //
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) <= 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSizeExclusive(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) < 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSize(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) <= 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) > 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSizeMinimumExclusiveMaximumInclusive(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) < 0 ||
    // valueOf(value.size()).compareTo(boundMaximum) >= 0).forEach(value -> assertThrows(IllegalArgumentException.class, ()
    // -> constrainSizeMinimumInclusiveMaximumExclusive(value, boundMinimum, boundMaximum, "name")))));
    //
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) > 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) < 0).forEach(value -> assertEquals(value, constrainSizeExclusive(value,
    // boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) >= 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) <= 0).forEach(value -> assertEquals(value, constrainSize(value,
    // boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) > 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) <= 0).forEach(value -> assertEquals(value,
    // constrainSizeMinimumExclusiveMaximumInclusive(value, boundMinimum, boundMaximum, "name")))));
    // list.stream().map(Map::size).forEach(boundMinimum -> list.stream().map(Map::size).forEach(boundMaximum ->
    // list.stream().filter(value -> valueOf(value.size()).compareTo(boundMinimum) >= 0 &&
    // valueOf(value.size()).compareTo(boundMaximum) < 0).forEach(value -> assertEquals(value,
    // constrainSizeMinimumInclusiveMaximumExclusive(value, boundMinimum, boundMaximum, "name")))));
    // }
    //
    // @Test
    // void testConstrainSize()
    // {
    // testConstrainSizeHelper(range(0, 6).mapToObj(i -> range(0, i + 1).mapToObj(index -> new
    // Object()).collect(toMap(identity(), identity()))).collect(toList()));
    // }
}
