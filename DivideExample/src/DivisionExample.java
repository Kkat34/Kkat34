public class DivisionExample {
    public static void main(String[] args) {
        try {
            divideWrapper(10, 0);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
    public static int divide(int a, int b) {
        return a / b;
    }

    public static void divideWrapper(int a, int b) throws Exception {
        try {
            divide(a, b);
        } catch (Exception e) {
            throw e;
        }
    }
}