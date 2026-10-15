public class OrderApplicationManualTest {
    public static void main(String[] args) {
        testOrderItemSubtotal();
        testOrderTotals();
        testPointService();
        testInvalidQuantity();
        System.out.println("All manual tests passed.");
    }

    private static void testOrderItemSubtotal() {
        Product book = new Product("P001", "Java 入門書", 680);
        OrderItem item = new OrderItem(book, 2);
        checkEquals("OrderItem subtotal", 1360, item.getSubtotal());
    }

    private static void testOrderTotals() {
        Product book = new Product("P001", "Java 入門書", 680);
        Product keyboard = new Product("P002", "商務鍵盤", 1200);
        Customer customer = new Customer("C001", "Amy", "P");

        Order order = new Order("O20260925001", customer);
        order.addItem(book, 2);
        order.addItem(keyboard, 1);

        checkEquals("Order subtotal", 2560, order.calculateSubtotal());
        checkEquals("Order discount", 150, order.calculateDiscount());
        checkEquals("Order final amount", 2410, order.calculateFinalAmount());
    }

    private static void testPointService() {
        PointService service = new PointService();
        checkEquals("G member points", 24, service.calculatePoints(new Customer("C001", "Gary", "G"), 2410));
        checkEquals("S member points", 36, service.calculatePoints(new Customer("C002", "Sandy", "S"), 2410));
        checkEquals("P member points", 48, service.calculatePoints(new Customer("C003", "Peter", "P"), 2410));
    }

    private static void testInvalidQuantity() {
        Product book = new Product("P001", "Java 入門書", 680);
        boolean thrown = false;
        try {
            new OrderItem(book, 0);
        } catch (IllegalArgumentException ex) {
            thrown = true;
        }
        checkEquals("Invalid quantity throws exception", true, thrown);
    }

    private static void checkEquals(String testName, int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(testName + " expected " + expected + " but was " + actual);
        }
        System.out.println("[PASS] " + testName);
    }

    private static void checkEquals(String testName, boolean expected, boolean actual) {
        if (expected != actual) {
            throw new AssertionError(testName + " expected " + expected + " but was " + actual);
        }
        System.out.println("[PASS] " + testName);
    }
}
