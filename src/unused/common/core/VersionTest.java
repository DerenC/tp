//@@author daniellingzy-unused

package vimification.common.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Version}.
 */
public class VersionTest {

    @Test
    @DisplayName("Test fromString with valid input")
    public void testFromStringValidInput() {
        String versionString = "V1.2.3";
        Version expectedVersion = new Version(1, 2, 3, false);
        Version actualVersion = Version.fromString(versionString);
        assertEquals(expectedVersion, actualVersion);
    }

    @Test
    @DisplayName("Test fromString with valid input containing ea")
    public void testFromStringValidInputWithEa() {
        String versionString = "V1.2.3ea";
        Version expectedVersion = new Version(1, 2, 3, true);
        Version actualVersion = Version.fromString(versionString);
        assertEquals(expectedVersion, actualVersion);
    }

    @Test
    @DisplayName("Test fromString with invalid input")
    public void testFromStringInvalidInput() {
        String versionString = "invalid";
        assertThrows(IllegalArgumentException.class, () -> Version.fromString(versionString));
    }

    @Test
    @DisplayName("Test toString")
    public void testToString() {
        Version version = new Version(1, 2, 3, false);
        String expectedString = "V1.2.3";
        String actualString = version.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    @DisplayName("Test toString with ea")
    public void testToStringWithEa() {
        Version version = new Version(1, 2, 3, true);
        String expectedString = "V1.2.3ea";
        String actualString = version.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    @DisplayName("Test compareTo with equal versions")
    public void testCompareToEqual() {
        Version version1 = new Version(1, 2, 3, false);
        Version version2 = new Version(1, 2, 3, false);
        assertEquals(0, version1.compareTo(version2));
    }

    @Test
    @DisplayName("Test compareTo with different major versions")
    public void testCompareToDifferentMajor() {
        Version version1 = new Version(1, 2, 3, false);
        Version version2 = new Version(2, 2, 3, false);
        assertTrue(version1.compareTo(version2) < 0);
    }

    @Test
    @DisplayName("Test compareTo with different minor versions")
    public void testCompareToDifferentMinor() {
        Version version1 = new Version(1, 2, 3, false);
        Version version2 = new Version(1, 3, 3, false);
        assertTrue(version1.compareTo(version2) < 0);
    }

    @Test
    @DisplayName("Test compareTo with different patch versions")
    public void testCompareToDifferentPatch() {
        Version version1 = new Version(1, 2, 3, false);
        Version version2 = new Version(1, 2, 4, false);
        assertTrue(version1.compareTo(version2) < 0);
    }
}

