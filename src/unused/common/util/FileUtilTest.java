//@@author daniellingzy-unused

package vimification.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vimification.common.core.GuiSettings;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Unit tests for {@link FileUtil}.
 */
@DisplayName("FileUtil Test")
public class FileUtilTest {

    @Test
    @DisplayName("isValidPath() with valid path")
    public void testIsValidPath_validPath() {
        assertTrue(FileUtil.isValidPath("test.txt"));
    }

    @Test
    @DisplayName("createIfMissing() with existing file")
    public void testCreateIfMissing_existingFile() throws IOException {
        Path path = Files.createTempFile("test", ".txt");
        assertTrue(FileUtil.isFileExists(path));
        FileUtil.createIfMissing(path);
        assertTrue(FileUtil.isFileExists(path));
        Files.deleteIfExists(path);
    }

    @Test
    @DisplayName("createIfMissing() with non-existent file")
    public void testCreateIfMissing_nonExistentFile() throws IOException {
        Path path = Files.createTempDirectory("test").resolve("newfile.txt");
        assertFalse(FileUtil.isFileExists(path));
        FileUtil.createIfMissing(path);
        assertTrue(FileUtil.isFileExists(path));
        Files.deleteIfExists(path);
        Files.deleteIfExists(path.getParent());
    }

    @Test
    @DisplayName("readFromFile()")
    public void testReadFromFile() throws IOException {
        String content = "Hello, World!";
        Path path = Files.createTempFile("test", ".txt");
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        assertEquals(content, FileUtil.readFromFile(path));
        Files.deleteIfExists(path);
    }

    @Test
    @DisplayName("writeToFile() with existing file")
    public void testWriteToFile_existingFile() throws IOException {
        String content = "Hello, World!";
        Path path = Files.createTempFile("test", ".txt");
        Files.write(path, "test".getBytes(StandardCharsets.UTF_8));
        FileUtil.writeToFile(path, content);
        assertEquals(content, FileUtil.readFromFile(path));
        Files.deleteIfExists(path);
    }

    @Test
    @DisplayName("writeToFile() with non-existent file")
    public void testWriteToFile_nonExistentFile() throws IOException {
        String content = "Hello, World!";
        Path path = Files.createTempDirectory("test").resolve("newfile.txt");
        assertFalse(FileUtil.isFileExists(path));
        FileUtil.writeToFile(path, content);
        assertEquals(content, FileUtil.readFromFile(path));
        Files.deleteIfExists(path);
        Files.deleteIfExists(path.getParent());
    }
}
