public class ElectricBill extends Bill {
    private double baseCharge;
    private double costPerKWh;
    private double kWhConsumed;

    public ElectricBill(String vendor, double baseCharge, double costPerKWh, double kWhConsumed) {
        super(vendor);
        this.baseCharge = baseCharge;
        this.costPerKWh = costPerKWh;
        this.kWhConsumed = kWhConsumed;
    }

    @Override
    public double getPaymentAmount() {
        return baseCharge + (costPerKWh * kWhConsumed);
    }
}


