// EmployeeTest.java
public class EmployeeTest {
    public static void main(String[] args) {
        // Create two Employee objects
        Employee employee1 = new Employee("Katrina", "Ampa", 12000);
        Employee employee2 = new Employee("Kevin", "Fona", 10000);

        // Display each employee's yearly salary
        System.out.printf("Yearly salary of %s %s: $%.2f%n", 
                          employee1.getFirstName(), employee1.getLastName(), employee1.getYearlySalary());
        System.out.printf("Yearly salary of %s %s: $%.2f%n%n", 
                          employee2.getFirstName(), employee2.getLastName(), employee2.getYearlySalary());

        // Give each employee a 10% raise
        employee1.giveRaise(10);
        employee2.giveRaise(10);

        // Display each employee's yearly salary again
        System.out.printf("Yearly salary of %s %s after raise: $%.2f%n", 
                          employee1.getFirstName(), employee1.getLastName(), employee1.getYearlySalary());
        System.out.printf("Yearly salary of %s %s after raise: $%.2f%n%n", 
                          employee2.getFirstName(), employee2.getLastName(), employee2.getYearlySalary());
    }
}
