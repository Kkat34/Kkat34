abstract class Bill implements Payable {
    protected String vendor;

    public Bill(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Vendor: " + vendor + ", Amount: " + getPaymentAmount();
    }
}
