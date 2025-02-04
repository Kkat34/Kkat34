public class CreditCard extends Bill{
    private double charges;
    private double credits;

    public CreditCard(String vendor, double charges, double credits) {
        super(vendor);
        this.charges = charges;
        this.credits = credits;
    }

    @Override
    public double getPaymentAmount() {
        return charges - credits;
    }
}



