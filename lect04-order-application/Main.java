public class Main {
    public static void main(String[] args) {
        Product book = new Product("P001", "Java 入門書", 680);
        Product keyboard = new Product("P002", "商務鍵盤", 1200);

        Customer customer = new Customer("C001", "Amy", "P");

        Order order = new Order("O20260925001", customer);
        order.addItem(book, 2);
        order.addItem(keyboard, 1);

        order.printReceipt();

        PointService pointService = new PointService();
        int points = pointService.calculatePoints(customer, order.calculateFinalAmount());
        customer.addPoints(points);

        System.out.println("本次獲得點數：" + points);
        System.out.println("顧客累積點數：" + customer.getPoints());
    }
}
