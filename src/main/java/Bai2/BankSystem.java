package Bai2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp mô phỏng hệ thống tài khoản ngân hàng.
 * Đã được tái cấu trúc (Refactor) để vượt qua bài kiểm tra Google Checkstyle.
 */
public class BankSystem {

    // Khởi tạo Logger
    private static final Logger logger = LoggerFactory.getLogger(BankSystem.class);

    private double balance;
    private final String accountId;

    /**
     * Khởi tạo tài khoản ngân hàng mới.
     *
     * @param accountId Mã số tài khoản
     * @param initialBalance Số dư ban đầu
     */
    public BankSystem(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        // Log mức độ DEBUG: Ghi lại trạng thái khởi tạo hệ thống
        logger.debug("Khởi tạo tài khoản {} với số dư ban đầu: {}", accountId, initialBalance);
    }

    /**
     * Thực hiện giao dịch nạp tiền.
     *
     * @param amount Số tiền cần nạp
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            // Log mức độ ERROR: Dữ liệu đầu vào sai nghiêm trọng
            logger.error("Lỗi bảo mật/dữ liệu: Cố gắng nạp số tiền không hợp lệ ({}) vào tài khoản {}",
                    amount, accountId);
            throw new IllegalArgumentException("Số tiền nạp phải lớn hơn 0");
        }
        balance += amount;

        // Log mức độ INFO: Giao dịch bình thường, thành công
        logger.info("Giao dịch NẠP thành công. Tài khoản: {} | Số tiền: +{} | Số dư mới: {}",
                accountId, amount, balance);
    }

    /**
     * Thực hiện giao dịch rút tiền.
     *
     * @param amount Số tiền cần rút
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            // Log mức độ WARN: Lỗi logic nghiệp vụ (không đủ tiền), hệ thống không sập nhưng cần cảnh báo
            logger.warn("Cảnh báo từ chối giao dịch: Tài khoản {} yêu cầu rút {} nhưng số dư chỉ còn {}",
                    accountId, amount, balance);
            return;
        }
        balance -= amount;

        // Log mức độ INFO: Giao dịch bình thường, thành công
        logger.info("Giao dịch RÚT thành công. Tài khoản: {} | Số tiền: -{} | Số dư mới: {}",
                accountId, amount, balance);
    }

    /**
     * Lấy số dư hiện tại.
     *
     * @return Số dư tài khoản
     */
    public double getBalance() {
        return balance;
    }
}
