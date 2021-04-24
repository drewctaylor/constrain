[![Workflow Maven Deploy](https://github.com/drewctaylor/constrain/workflows/workflow-maven-deploy/badge.svg)](https://github.com/drewctaylor/constrain/workflows/workflow-maven-deploy/badge.svg)
[![Code Coverage](https://codecov.io/gh/drewctaylor/constrain/branch/trunk/graph/badge.svg)](https://codecov.io/gh/drewctaylor/constrain)

# Constrain

```java
final class ConstrainStringTest
{
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

    void testStringMaximum10(
            final Maximum<String, _1<_0$>> stringMaximum10)
    {
    }

    void testStringMinimumExclusive(
            final MinimumExclusive<String, _0$> stringMinimumExclusive)
    {
    }

    void testStringNonEmpty(
            final NonEmpty<String> stringNonEmpty)
    {
    }
}
```

## To Use

1) Update the `pom.xml` to include a reference to the sonatype staging and snapshot repositories.

   For example:

    ```xml
    <repositories>
        <repository>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <id>ossrh</id>
            <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
        </repository>
        <repository>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <id>ossrh-snapshot</id>
            <url>https://oss.sonatype.org/content/repositories/snapshots</url>
        </repository>
    </repositories>
    ```

2) Update the `pom.xml` to include the library.

    For example:
    
    ```xml
    <dependencies>
        <dependency>
            <groupId>io.github.drewctaylor</groupId>
            <artifactId>constrain</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>
    ```
