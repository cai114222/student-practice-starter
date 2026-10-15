public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        // TODO 1：檢查 product 不可為 null
        // TODO 2：檢查 quantity 必須大於 0
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSubtotal() {
        // TODO 3：回傳 商品單價 * 數量
        return 0;
    }

    public String getLineSummary() {
        // TODO 4：回傳「商品名稱 x 數量 = 小計」
        return "TODO";
    }
}
