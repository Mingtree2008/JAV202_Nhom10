package Entity;

import java.util.Date;

public class Category {
    private int typeId;
    private String typeName;
    private Date createDate;
    private String describe;
    private boolean status;

    // Constructor mặc định
    public Category() {
    }

    // Constructor đầy đủ
    public Category(int typeId, String typeName, Date createDate, String describe, boolean status) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.createDate = createDate;
        this.describe = describe;
        this.status = status;
    }

    // Constructor không có ID (dùng khi INSERT)
    public Category(String typeName, Date createDate, String describe, boolean status) {
        this.typeName = typeName;
        this.createDate = createDate;
        this.describe = describe;
        this.status = status;
    }

    // Getter & Setter
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", createDate=" + createDate +
                ", describe='" + describe + '\'' +
                ", status=" + status +
                '}';
    }
}
