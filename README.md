[![Workflow Maven Package](https://github.com/drewctaylor/constrain/workflows/workflow-maven-package/badge.svg)](https://github.com/drewctaylor/constrain/workflows/workflow-maven-package/badge.svg)
[![Workflow Maven Deploy](https://github.com/drewctaylor/constrain/workflows/workflow-maven-deploy/badge.svg)](https://github.com/drewctaylor/constrain/workflows/workflow-maven-deploy/badge.svg)
[![Code Coverage](https://codecov.io/gh/drewctaylor/constrain/branch/master/graph/badge.svg)](https://codecov.io/gh/drewctaylor/constrain)

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

    void test(final Maximum<String, _1<_0$>> stringMaximum10)
    {
    }
}
```

## To Use Constrain

To use require:

1) Update your `~/.m2/settings.xml` to include your github username or github email address and your [github personal access token](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line).

    For example:

    ```xml
    <settings>
        <servers>
            <server>
                <id>constrain</id>
                <username>your-github-username-or-email-address</username>
                <password>your-github-personal-access-token</password>
            </server>
        </servers>
    </settings>
    ```

2) Update your `pom.xml` to include a reference to the plugin repository.

    For example:

    ```xml
    <repositories>
        <repository>
            <id>constrain</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/drewctaylor/constrain</url>
        </repository>
    </repositories>
    ```

3) Update your `pom.xml` to include the plugin. 

    For example:
    
    ```xml
    <dependencies>
        <dependency>
            <groupId>io.github.drewctaylor</groupId>
            <artifactId>constrain</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
    ```
