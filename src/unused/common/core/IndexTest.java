//@@author daniellingzy-unused

package vimification.common.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Index} class.
 */
@DisplayName("Index Class Tests")
public class IndexTest {

    @Test
    @DisplayName("Test fromZeroBased() with valid input")
    public void fromZeroBased_validInput_pass() {
        Index index = Index.fromZeroBased(5);
        assertEquals(5, index.getZeroBased());
    }

    @Test
    @DisplayName("Test fromOneBased() with valid input")
    public void fromOneBased_validInput_pass() {
        Index index = Index.fromOneBased(6);
        assertEquals(5, index.getZeroBased());
    }

    @Test
    @DisplayName("Test getOneBased() with valid input")
    public void getOneBased_validInput_pass() {
        Index index = Index.fromZeroBased(3);
        assertEquals(4, index.getOneBased());
    }

    @Test
    @DisplayName("Test equals() with same zero-based value")
    public void equals_sameZeroBasedValue_pass() {
        Index index1 = Index.fromZeroBased(3);
        Index index2 = Index.fromZeroBased(3);
        assertTrue(index1.equals(index2));
    }

    @Test
    @DisplayName("Test equals() with different zero-based values")
    public void equals_differentZeroBasedValue_fail() {
        Index index1 = Index.fromZeroBased(2);
        Index index2 = Index.fromZeroBased(5);
        assertFalse(index1.equals(index2));
    }

    @Test
    @DisplayName("Test toString() with valid input")
    public void toString_validInput_pass() {
        Index index = Index.fromOneBased(8);
        assertEquals("Index [8]", index.toString());
    }
}
