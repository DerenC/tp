//@@author daniellingzy-unused

package vimification.common.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for the {@link IllegalValueException} class.
 */
public class IllegalValueExceptionTest {

    /**
     * Test the constructor with a message parameter.
     */
    @Test
    @DisplayName("Test constructor with message")
    public void testConstructorWithValidMessage() {
        String message = "Test message";
        IllegalValueException exception = new IllegalValueException(message);

        assertEquals(message, exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test the constructor with a message and cause parameter.
     */
    @Test
    @DisplayName("Test constructor with message and cause")
    public void testConstructorWithValidMessageAndCause() {
        String message = "Test message";
        Exception cause = new Exception("Test cause");
        IllegalValueException exception = new IllegalValueException(message, cause);

        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}
