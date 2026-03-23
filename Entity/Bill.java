package Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private int billId;
    private int userId;
    private int drinkId;
    private BigDecimal totalAmount;
    private Date checkInDate;
    private Date checkOutDate;
    private String status;

    // Constructor mặc định
    public Bill() {
    }

    // Constructor đầy đủ
    public Bill(int billId, int userId, int drinkId, BigDecimal totalAmount,
                Date checkInDate, Date checkOutDate, String status) {
        this.billId = billId;
        this.userId = userId;
        this.drinkId = drinkId;
        this.totalAmount = totalAmount;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    // Constructor không có ID (dùng khi INSERT)
    public Bill(int userId, int drinkId, BigDecimal totalAmount,
                Date checkInDate, Date checkOutDate, String status) {
        this.userId = userId;
        this.drinkId = drinkId;
        this.totalAmount = totalAmount;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    // Getter & Setter
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", userId=" + userId +
                ", drinkId=" + drinkId +
                ", totalAmount=" + totalAmount +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", status='" + status + '\'' +
                '}';
    }
}
