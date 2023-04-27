//@@author daniellingzy-unused

package vimification.common.util;

import javafx.scene.image.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vimification.common.core.GuiSettings;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link AppUtil}.
 */
@DisplayName("AppUtil Class")
public class AppUtilTest {

    @Test
    @DisplayName("Test getImage method with valid path")
    public void testGetImageWithValidPath() {
        Image image = AppUtil.getImage("/images/info_icon.png");
        assertNotNull(image);
    }

    @Test
    @DisplayName("Test getImage method with null path")
    public void testGetImageWithNullPath() {
        assertThrows(NullPointerException.class, () -> {
            AppUtil.getImage(null);
        });
    }
}
