public class Customer {
    private String id;
    private String name;
    private String level;
    private int points;

    public Customer(String id, String name, String level) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("顧客編號不可空白");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("顧客姓名不可空白");
        }
        this.id = id;
        this.name = name;
        setLevel(level);
        this.points = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }

    public void setLevel(String level) {
        if (!("G".equals(level) || "S".equals(level) || "P".equals(level))) {
            throw new IllegalArgumentException("會員等級只能是 G、S 或 P");
        }
        this.level = level;
    }

    public String getLevelName() {
        if ("P".equals(level)) {
            return "白金會員";
        }
        if ("S".equals(level)) {
            return "銀卡會員";
        }
        return "一般會員";
    }

    public void addPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("新增點數不可小於 0");
        }
        this.points += points;
    }
}
