//@@author daniellingzy-unused

package vimification.common.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vimification.common.core.GuiSettings;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link DataConversionException}.
 */
public class DataConversionExceptionTest {

    @Test
    @DisplayName("Constructor with cause should set cause")
    public void testWithCause() {
        Exception cause = new Exception("test cause");
        DataConversionException exception = new DataConversionException(cause);

        assertEquals(cause, exception.getCause());
    }

    @Test
    @DisplayName("Constructor with null cause should set null cause")
    public void testWithNullCause() {
        DataConversionException exception = new DataConversionException(null);

        assertEquals(null, exception.getCause());
    }

    @Test
    @DisplayName("getMessage with cause should return cause message")
    public void testGetMessageWithCause() {
        Exception cause = new Exception("test cause");
        DataConversionException exception = new DataConversionException(cause);

        assertEquals("java.lang.Exception: test cause", exception.getMessage());
    }

    @Test
    @DisplayName("toString with cause should return cause toString")
    public void testToStringWithCause() {
        Exception cause = new Exception("test cause");
        DataConversionException exception = new DataConversionException(cause);

        assertEquals("vimification.common.exceptions.DataConversionException: java.lang.Exception: test cause", exception.toString());
    }

    @Test
    @DisplayName("toString with null cause should return default toString")
    public void testToStringWithNullCause() {
        DataConversionException exception = new DataConversionException(null);

        assertEquals("vimification.common.exceptions.DataConversionException", exception.toString());
    }

}
