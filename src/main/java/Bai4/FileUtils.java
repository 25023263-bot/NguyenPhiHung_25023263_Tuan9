package Bai4;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    // Đã refactor: Sử dụng Paths API để tự động tương thích mọi hệ điều hành
    public String getLogFilePath() {
        Path path = Paths.get("logs", "app.log");
        return path.toString();
    }
}