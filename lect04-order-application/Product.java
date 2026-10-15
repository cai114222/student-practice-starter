public class Product {
    private String id;
    private String name;
    private int unitPrice;

    public Product(String id, String name, int unitPrice) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("商品編號不可空白");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("商品名稱不可空白");
        }
        this.id = id;
        this.name = name;
        setUnitPrice(unitPrice);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("商品單價不可小於 0");
        }
        this.unitPrice = unitPrice;
    }

    public int calculateSubtotal(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("數量必須大於 0");
        }
        return unitPrice * quantity;
    }

    public String getSummary() {
        return id + " - " + name + "：NT$" + unitPrice;
    }
}
