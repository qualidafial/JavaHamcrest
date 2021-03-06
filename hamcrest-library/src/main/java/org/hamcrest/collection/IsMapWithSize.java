package org.hamcrest.collection;

import java.util.Map;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matches if map size satisfies a nested matcher.
 */
public final class IsMapWithSize<M extends Map<?, ?>> extends FeatureMatcher<M, Integer> {
    public IsMapWithSize(Matcher<? super Integer> sizeMatcher) {
      super(sizeMatcher, "a map with size", "map size");
    }

    @Override
    protected Integer featureValueOf(M actual) {
      return actual.size();
    }

    /**
     * Creates a matcher for {@link java.util.Map}s that matches when the <code>size()</code> method returns
     * a value that satisfies the specified matcher.
     * <p/>
     * For example:
     * <pre>assertThat(myMap, is(aMapWithSize(equalTo(2))))</pre>
     *
     * @param sizeMatcher
     *     a matcher for the size of an examined {@link java.util.Map}
     */
    @Factory
    public static <M extends Map<?, ?>> Matcher<M> aMapWithSize(Matcher<? super Integer> sizeMatcher) {
        return new IsMapWithSize<M>(sizeMatcher);
    }

    /**
     * Creates a matcher for {@link java.util.Map}s that matches when the <code>size()</code> method returns
     * a value equal to the specified <code>size</code>.
     * <p/>
     * For example:
     * <pre>assertThat(myMap, is(aMapWithSize(2)))</pre>
     *
     * @param size
     *     the expected size of an examined {@link java.util.Map}
     */
    @Factory
    public static <M extends Map<?, ?>> Matcher<M> aMapWithSize(int size) {
        return aMapWithSize(equalTo(size));
    }

    /**
     * Creates a matcher for {@link java.util.Map}s that matches when the <code>size()</code> method returns
     * zero.
     * <p/>
     * For example:
     * <pre>assertThat(myMap, is(anEmptyMap()))</pre>
     *
     */
    @Factory
    public static <M extends Map<?, ?>> Matcher<M> anEmptyMap() {
        return aMapWithSize(equalTo(0));
    }
}
