public class PointService {
    public int calculatePoints(Customer customer, int finalAmount) {
        if (customer == null) {
            throw new IllegalArgumentException("顧客不可為 null");
        }
        if (finalAmount < 0) {
            throw new IllegalArgumentException("金額不可小於 0");
        }

        int basePoints = finalAmount / 100;

        // TODO：依會員等級計算點數
        // G：basePoints
        // S：basePoints * 1.5 後四捨五入
        // P：basePoints * 2
        return basePoints;
    }
}
