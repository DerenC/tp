//@@author daniellingzy-unused

package vimification.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vimification.common.core.GuiSettings;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link StringUtil}.
 */
@DisplayName("StringUtil Unit Tests")
class StringUtilTest {

    @Test
    @DisplayName("Test getDetails() method")
    void testGetDetails() {
        // Test with a new RuntimeException
        String errorMsg = "This is a test error message";
        RuntimeException ex = new RuntimeException(errorMsg);
        String details = StringUtil.getDetails(ex);
        assertTrue(details.contains(errorMsg), "Error message not found in details string");
        assertTrue(details.contains("java.lang.RuntimeException"), "Exception class not found in details string");
    }

    @Test
    @DisplayName("Test requireNonEmpty() method with non-empty string")
    void testRequireNonEmptyWithNonEmptyString() {
        String input = "This is a non-empty string";
        String output = StringUtil.requireNonEmpty(input);
        assertEquals(input, output, "Output string should be the same as the input string");
    }

    @Test
    @DisplayName("Test requireNonEmpty() method with empty string")
    void testRequireNonEmptyWithEmptyString() {
        String input = "";
        String errorMsg = "Input string cannot be empty";
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> StringUtil.requireNonEmpty(input, errorMsg));
        assertEquals(errorMsg, ex.getMessage(), "Error message should be the same as the input message");
    }
}
