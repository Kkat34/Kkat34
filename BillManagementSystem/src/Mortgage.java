public class Mortgage extends Bill{
    private double principal;
    private double interest;
    private double taxes;
    private double insurance;

    public Mortgage(String vendor, double principal, double interest, double taxes, double insurance) {
        super(vendor);
        this.principal = principal;
        this.interest = interest;
        this.taxes = taxes;
        this.insurance = insurance;
    }

    @Override
    public double getPaymentAmount() {
        return principal + interest + taxes + insurance;
    }
}
