//@@author daniellingzy-unused

package vimification.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vimification.common.core.GuiSettings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link CollectionUtil}.
 */
@DisplayName("CollectionUtil Test")
class CollectionUtilTest {

    @DisplayName("requireAllNonNull(Object... items) Test")
    @Test
    void test_requireAllNonNull_withObjects_shouldNotThrowException() {
        Object[] items = new Object[]{"a", "b", "c"};
        assertDoesNotThrow(() -> CollectionUtil.requireAllNonNull(items));
    }

    @DisplayName("requireAllNonNull(Collection<?> items) Test")
    @Test
    void test_requireAllNonNull_withCollection_shouldNotThrowException() {
        Collection<Object> items = Arrays.asList("a", "b", "c");
        assertDoesNotThrow(() -> CollectionUtil.requireAllNonNull(items));
    }

    @DisplayName("requireAllNonNull(Object... items) Test")
    @Test
    void test_requireAllNonNull_withNullArgument_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> CollectionUtil.requireAllNonNull((Object[]) null));
    }

    @DisplayName("requireAllNonNull(Collection<?> items) Test")
    @Test
    void test_requireAllNonNull_withNullCollection_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> CollectionUtil.requireAllNonNull((Collection<Object>) null));
    }

    @DisplayName("requireAllNonNull(Object... items) Test")
    @Test
    void test_requireAllNonNull_withNullElement_shouldThrowException() {
        Object[] items = new Object[]{"a", null, "c"};
        assertThrows(NullPointerException.class, () -> CollectionUtil.requireAllNonNull(items));
    }

    @DisplayName("requireAllNonNull(Collection<?> items) Test")
    @Test
    void test_requireAllNonNull_withNullCollectionElement_shouldThrowException() {
        Collection<Object> items = Arrays.asList("a", null, "c");
        assertThrows(NullPointerException.class, () -> CollectionUtil.requireAllNonNull(items));
    }

    @DisplayName("isAnyNonNull(Object... items) Test")
    @Test
    void test_isAnyNonNull_withNonEmptyObjects_shouldReturnTrue() {
        assertTrue(CollectionUtil.isAnyNonNull("a", null, "c"));
    }

    @DisplayName("isAnyNonNull(Object... items) Test")
    @Test
    void test_isAnyNonNull_withEmptyObjects_shouldReturnFalse() {
        assertFalse(CollectionUtil.isAnyNonNull());
    }

    @DisplayName("isAnyNonNull(Object... items) Test")
    @Test
    void test_isAnyNonNull_withNullArgument_shouldReturnFalse() {
        assertFalse(CollectionUtil.isAnyNonNull((Object[]) null));
    }

    @DisplayName("isAnyNonNull(Object... items) Test")
    @Test
    void test_isAnyNonNull_withNullElement_shouldReturnTrue() {
        assertTrue(CollectionUtil.isAnyNonNull("a", null, "c"));
    }

    @DisplayName("isAnyNonNull(Collection<?> items) Test")
    @Test
    void test_isAnyNonNull_withNonEmptyCollection_shouldReturnTrue() {
        Collection<Object> items = Arrays.asList("a", null, "c");
        assertTrue(CollectionUtil.isAnyNonNull(items));
    }

    @DisplayName("isAnyNonNull(Collection<?> items) Test")
    @Test
    void test_isAnyNonNull_withNullCollection_shouldReturnFalse() {
        assertFalse(CollectionUtil.isAnyNonNull((Collection<Object>) null));
    }
}