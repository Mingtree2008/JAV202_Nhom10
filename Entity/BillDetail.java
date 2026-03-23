package Entity;

import java.math.BigDecimal;

public class BillDetail {
    private int billDetailId;
    private int billId;
    private int drinkId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal price;

    // Constructor mặc định
    public BillDetail() {
    }

    // Constructor đầy đủ
    public BillDetail(int billDetailId, int billId, int drinkId,
                      int quantity, BigDecimal unitPrice, BigDecimal price) {
        this.billDetailId = billDetailId;
        this.billId = billId;
        this.drinkId = drinkId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.price = price;
    }

    // Constructor không có ID (dùng khi INSERT)
    public BillDetail(int billId, int drinkId, int quantity, BigDecimal unitPrice, BigDecimal price) {
        this.billId = billId;
        this.drinkId = drinkId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.price = price;
    }

    // Getter & Setter
    public int getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(int billDetailId) {
        this.billDetailId = billDetailId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "billDetailId=" + billDetailId +
                ", billId=" + billId +
                ", drinkId=" + drinkId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", price=" + price +
                '}';
    }
}
