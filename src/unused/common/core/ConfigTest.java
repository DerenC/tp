//@@author daniellingzy-unused

/**
 * All the code in this folder were not used as I wanted to merge it too close to the deadline.
 * As the common classes were mostly adapted from Ab3, these codes do not really value-add to the final submission as well.
 * Hence I placed these codes under unused folder instead.
 */


package vimification.common.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.util.logging.Level;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Config}.
 */
@DisplayName("Config")
public class ConfigTest {

    private Config config;

    @BeforeEach
    void setUp() {
        config = new Config();
    }

    @Nested
    @DisplayName("Getters and Setters")
    class GettersAndSetters {

        @Test
        @DisplayName("GetLogLevel")
        void testGetLogLevel() {
            assertEquals(Level.INFO, config.getLogLevel());
        }

        @Test
        @DisplayName("SetLogLevel")
        void testSetLogLevel() {
            config.setLogLevel(Level.WARNING);
            assertEquals(Level.WARNING, config.getLogLevel());
        }

        @Test
        @DisplayName("GetUserPrefsFilePath")
        void testGetUserPrefsFilePath() {
            assertNotNull(config.getUserPrefsFilePath());
        }

        @Test
        @DisplayName("SetUserPrefsFilePath")
        void testSetUserPrefsFilePath() {
            Path path = Path.of("test.json");
            config.setUserPrefsFilePath(path);
            assertSame(path, config.getUserPrefsFilePath());
        }
    }

    @Nested
    @DisplayName("Equals and HashCode")
    class EqualsAndHashCode {

        @Test
        @DisplayName("Equals: Same object")
        void testEqualsSameObject() {
            assertTrue(config.equals(config));
        }

        @Test
        @DisplayName("Equals: Null")
        void testEqualsNull() {
            assertFalse(config.equals(null));
        }

        @Test
        @DisplayName("Equals: Different class")
        void testEqualsDifferentClass() {
            assertFalse(config.equals("string"));
        }

        @Test
        @DisplayName("Equals: Same values")
        void testEqualsSameValues() {
            Config otherConfig = new Config();
            assertTrue(config.equals(otherConfig));
            assertEquals(config.hashCode(), otherConfig.hashCode());
        }

        @Test
        @DisplayName("Equals: Different log level")
        void testEqualsDifferentLogLevel() {
            Config otherConfig = new Config();
            otherConfig.setLogLevel(Level.WARNING);
            assertFalse(config.equals(otherConfig));
            assertNotEquals(config.hashCode(), otherConfig.hashCode());
        }

        @Test
        @DisplayName("Equals: Different user prefs file path")
        void testEqualsDifferentUserPrefsFilePath() {
            Config otherConfig = new Config();
            otherConfig.setUserPrefsFilePath(Path.of("test.json"));
            assertFalse(config.equals(otherConfig));
            assertNotEquals(config.hashCode(), otherConfig.hashCode());
        }
    }

    @Nested
    @DisplayName("ToString")
    class ToString {

        @Test
        @DisplayName("ToString")
        void testToString() {
            assertEquals("Config [logLevel=INFO, userPrefsFilePath=.vimification/preferences.json]", config.toString());
        }
    }
}

