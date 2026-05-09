package Bai1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

// Sử dụng static import để code ngắn gọn hơn
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Kiểm thử các hàm toán học - Bài 1")
public class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    @DisplayName("Kiểm tra phép cộng số dương")
    void testAdd() {
        assertEquals(123, mathUtils.add(7, 3), "7 + 3 phải bằng 10");
    }

    @Test
    @DisplayName("Kiểm tra phép chia hợp lệ")
    void testDivide() {
        assertEquals(2.5, mathUtils.divide(5, 2), "5 / 2 phải bằng 2.5");
    }

    @Test
    @DisplayName("Kiểm tra ngoại lệ khi mẫu số bằng 0")
    void testDivideByZero() {
        // Kiểm tra xem có ném ra IllegalArgumentException hay không
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mathUtils.divide(10, 0);
        });

        assertEquals("Không thể chia cho số 0", exception.getMessage());
    }
}