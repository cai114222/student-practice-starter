import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNo;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();

    public Order(String orderNo, Customer customer) {
        if (orderNo == null || orderNo.isBlank()) {
            throw new IllegalArgumentException("訂單編號不可空白");
        }
        if (customer == null) {
            throw new IllegalArgumentException("顧客不可為 null");
        }
        this.orderNo = orderNo;
        this.customer = customer;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addItem(Product product, int quantity) {
        // TODO 1：建立 OrderItem 並加入 items
        OrderItem item = new OrderItem(product, quantity);
        items.add(item);
    }

    public int calculateSubtotal() {
        // TODO 2：使用 for 迴圈加總每一筆 OrderItem 的小計
            int subtotal = 0;
            for (OrderItem item : items) {
                subtotal += item.getSubtotal();
            }
        return subtotal;
    }

    public int calculateDiscount() {
        // TODO 3：依照規則回傳折扣金額
        // 滿 3000 折 300；滿 2000 折 150；滿 1000 折 50；未滿 1000 不折扣
        int subtotal=calculateSubtotal();
        if (subtotal >= 3000) {
            return 300;
        } else if (subtotal >= 2000) {
            return 150;
        } else if (subtotal >= 1000) {
            return 50;
        }
        else {return 0;}

    }

    public int calculateFinalAmount() {
       
        return calculateSubtotal() - calculateDiscount();
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public void printReceipt() {
        System.out.println("訂單編號：" + orderNo);
        System.out.println("顧客：" + customer.getName() + "（" + customer.getLevelName() + "）");
        System.out.println("------------------------------");
      
        for (OrderItem item : items) {
            System.out.println(item.getLineSummary());
        }
        System.out.println("------------------------------");
        System.out.println("小計：" + calculateSubtotal());
        System.out.println("折扣：" + calculateDiscount());
        System.out.println("應付金額：" + calculateFinalAmount());
    }
}
