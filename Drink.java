package entity;

import java.math.BigDecimal;

public class Drink {
    private int drinkId;
    private int typeId;
    private String drinkName;
    private BigDecimal cost;
    private String image;
    private String describe;

    // Constructor mặc định
    public Drink() {
    }

    // Constructor đầy đủ
    public Drink(int drinkId, int typeId, String drinkName, BigDecimal cost, String image, String describe) {
        this.drinkId = drinkId;
        this.typeId = typeId;
        this.drinkName = drinkName;
        this.cost = cost;
        this.image = image;
        this.describe = describe;
    }

    // Constructor không có ID (dùng khi INSERT)
    public Drink(int typeId, String drinkName, BigDecimal cost, String image, String describe) {
        this.typeId = typeId;
        this.drinkName = drinkName;
        this.cost = cost;
        this.image = image;
        this.describe = describe;
    }

    // Getter & Setter
    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkId=" + drinkId +
                ", typeId=" + typeId +
                ", drinkName='" + drinkName + '\'' +
                ", cost=" + cost +
                ", image='" + image + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
