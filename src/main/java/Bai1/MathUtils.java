package Bai1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp tiện ích toán học - Bài tập 1.
 * Sử dụng Logback (thông qua SLF4J) để ghi log có cấu trúc.
 */
public class MathUtils {

    // Khởi tạo Logger cho class MathUtils
    private static final Logger logger=LoggerFactory.getLogger(MathUtils.class);

    /**
     * Thực hiện phép cộng hai số nguyên.
     */
    public int add(int a, int b) {
        int result = a + b;
        // Thay thế System.out.println bằng structured logging
        logger.info("Thực hiện phép tính cộng: {} + {} = {}", a, b, result);
        return result;
    }

    /**
     * Thực hiện phép chia hai số nguyên.
     * @throws IllegalArgumentException nếu số chia bằng 0.
     */
    public double divide(int a, int b) {
        if (b == 0) {
            logger.error("Lỗi chia cho 0: Tử số = {}, Mẫu số = 0", a);
            throw new IllegalArgumentException("Không thể chia cho số 0");
        }

        double result = (double) a / b;
        logger.info("Thực hiện phép tính chia: {} / {} = {}", a, b, result);
        return result;
    }
}
