public class ItemType {
    private String name;
    private double deposit;
    private double costPerDay;

    // Default constructor
    public ItemType() {
        this.name = "";
        this.deposit = 0.0;
        this.costPerDay = 0.0;
    }

    // Parameterized constructor
    public ItemType(String name, double deposit, double costPerDay) {
        this.name = name;
        this.deposit = deposit;
        this.costPerDay = costPerDay;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format("Name:%s\nDeposit:%.1f\nCost Per Day:%.1f", name, deposit, costPerDay);
    }
}
