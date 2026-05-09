package Bai4;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilsTest {

    @Test
    void testFilePath() {
        FileUtils utils = new FileUtils();
        String actualPath = utils.getLogFilePath();

        // Cố gắng so sánh với chuẩn của hệ điều hành hiện tại đang chạy
        String expectedPath = "logs" + File.separator + "app.log";

        assertEquals(expectedPath, actualPath, "Đường dẫn file phải đúng với hệ điều hành!");
    }
}