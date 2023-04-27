//@@author daniellingzy-unused

package vimification.common.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link LogsCenter}.
 */
public class LogsCenterTest {

    private static final Logger LOGGER = LogsCenter.getLogger(LogsCenterTest.class);

    @BeforeEach
    public void setUp() {
        Config config = new Config();
        config.setLogLevel(Level.WARNING);
        LogsCenter.init(config);
    }

    @Test
    @DisplayName("Test LogsCenter.getLogger with name")
    public void testGetLogger() {
        Logger logger = LogsCenter.getLogger("testLogger");
        assertNotNull(logger);
        assertEquals(logger.getName(), "testLogger");
    }

    @Test
    @DisplayName("Test LogsCenter.getLogger with class")
    public void testGetLoggerWithClass() {
        Logger logger = LogsCenter.getLogger(LogsCenterTest.class);
        assertNotNull(logger);
        assertEquals(logger.getName(), LogsCenterTest.class.getSimpleName());
    }

    @Test
    @DisplayName("Test LogsCenter.getLogger with null name")
    public void test_getLogger_withNullName_returnsRootLogger() {
        Logger logger = LogsCenter.getLogger((Class<Object>) null);
        assertEquals(Logger.getLogger("").getName(), logger.getName());
    }

    @Test
    @DisplayName("Test LogsCenter.getLogger with existing name")
    public void test_getLogger_withExistingName_returnsSameLogger() {
        String name = "testLogger";
        Logger logger1 = LogsCenter.getLogger(name);
        Logger logger2 = LogsCenter.getLogger(name);
        assertEquals(logger1, logger2);
    }

    @Test
    @DisplayName("Test LogsCenter.getLogger with different name")
    public void test_getLogger_withDifferentName_returnsDifferentLogger() {
        Logger logger1 = LogsCenter.getLogger("logger1");
        Logger logger2 = LogsCenter.getLogger("logger2");
        assertNotEquals(logger1, logger2);
    }
}
