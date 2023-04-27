//@@author daniellingzy-unused

package vimification.common.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.awt.Point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link GuiSettings}.
 */
@DisplayName("GuiSettings class")
class GuiSettingsTest {

    @Nested
    @DisplayName("Default constructor")
    class DefaultConstructor {

        @Test
        @DisplayName("should set default values")
        void testDefaultValues() {
            // given
            GuiSettings settings = new GuiSettings();

            // then
            assertEquals(740, settings.getWindowWidth());
            assertEquals(600, settings.getWindowHeight());
            assertNull(settings.getWindowCoordinates());
        }
    }

    @Nested
    @DisplayName("Parameterized constructor")
    class ParameterizedConstructor {

        @Test
        @DisplayName("should set values correctly")
        void testCorrectValues() {
            // given
            double width = 800.0;
            double height = 600.0;
            int x = 100;
            int y = 200;

            // when
            GuiSettings settings = new GuiSettings(width, height, x, y);

            // then
            assertEquals(width, settings.getWindowWidth());
            assertEquals(height, settings.getWindowHeight());
            assertEquals(new Point(x, y), settings.getWindowCoordinates());
        }
    }

    @Nested
    @DisplayName("Equals method")
    class EqualsMethod {

        @Test
        @DisplayName("should return true when objects are equal")
        void test_objectsEqual() {
            // given
            GuiSettings settings1 = new GuiSettings();
            GuiSettings settings2 = new GuiSettings();

            // then
            assertEquals(settings1, settings2);
        }

        @Test
        @DisplayName("should return false when objects are not equal")
        void test_objectsNotEqual() {
            // given
            GuiSettings settings1 = new GuiSettings();
            GuiSettings settings2 = new GuiSettings(740, 600, 0, 0);

            // then
            assertNotEquals(settings1, settings2);
        }
    }

    @Nested
    @DisplayName("Hash code method")
    class HashCodeMethod {

        @Test
        @DisplayName("should return the same hash code for equal objects")
        void testHashCodeMethod() {
            // given
            GuiSettings settings1 = new GuiSettings();
            GuiSettings settings2 = new GuiSettings();

            // then
            assertEquals(settings1.hashCode(), settings2.hashCode());
        }
    }

    @Nested
    @DisplayName("To string method")
    class ToStringMethod {

        @Test
        @DisplayName("should return a string representation of the object")
        void testToString() {
            // given
            GuiSettings settings = new GuiSettings();

            // then
            assertEquals("GuiSettings [windowWidth=740.0" + ", windowHeight=600.0"
                    + ", windowCoordinates=null]", settings.toString());
        }
    }
}
