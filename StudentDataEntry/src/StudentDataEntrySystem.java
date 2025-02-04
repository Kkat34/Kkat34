import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BaseStudent {
    private String firstName;
    private String lastName;
    private int studentId;

    public BaseStudent(String firstName, String lastName, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "BaseStudent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}

class UndergradStudent extends BaseStudent {
    private String major;
    private int projectedGraduationYear;

    public UndergradStudent(String firstName, String lastName, int studentId, String major, int projectedGraduationYear) {
        super(firstName, lastName, studentId);
        this.major = major;
        this.projectedGraduationYear = projectedGraduationYear;
    }
    @Override
    public String toString() {
        return super.toString() + " UndergradStudent{" +
                "major='" + major + '\'' +
                ", projectedGraduationYear=" + projectedGraduationYear +
                '}';
    }
}

class GradStudent extends BaseStudent {
    private String advisorName;
    private String researchArea;

    public GradStudent(String firstName, String lastName, int studentId, String advisorName, String researchArea) {
        super(firstName, lastName, studentId);
        this.advisorName = advisorName;
        this.researchArea = researchArea;
    }

    @Override
    public String toString() {
        return super.toString() + " GradStudent{" +
                "advisorName='" + advisorName + '\'' +
                ", researchArea='" + researchArea + '\'' +
                '}';
    }
}
class DoctoralStudent extends GradStudent {
    private String thesisTitle;

    public DoctoralStudent(String firstName, String lastName, int studentId, String advisorName, String researchArea, String thesisTitle) {
        super(firstName, lastName, studentId, advisorName, researchArea);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return super.toString() + " DoctoralStudent{" +
                "thesisTitle='" + thesisTitle + '\'' +
                '}';
    }
}
public class StudentDataEntrySystem {
    public static void main(String[] args){
        List<BaseStudent> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueEntry = true;

        while (continueEntry) {
            System.out.println("Select student type to create: 1. Undergrad 2. Grad 3. Doctoral 4.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newLine

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String undergradFirstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String undergradLastName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int undergradId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter major: ");
                    String major = scanner.nextLine();
                    System.out.print("Enter projected graduation year: ");
                    int gradYear = scanner.nextInt();
                    students.add(new UndergradStudent(undergradFirstName, undergradLastName, undergradId, major, gradYear));
                    break;
                case 2:
                    System.out.print("Enter first name: ");
                    String gradFirstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String gradLastName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int gradId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter advisor name: ");
                    String advisorName = scanner.nextLine();
                    System.out.print("Enter research area: ");
                    String researchArea = scanner.nextLine();
                    students.add(new GradStudent(gradFirstName, gradLastName, gradId, advisorName, researchArea));
                    break;
                case 3:
                    System.out.print("Enter first name: ");
                    String docFirstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String docLastName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int docId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter advisor name: ");
                    String docAdvisorName = scanner.nextLine();
                    System.out.print("Enter research area: ");
                    String docResearchArea = scanner.nextLine();
                    System.out.print("Enter thesis title: ");
                    String thesisTitle = scanner.nextLine();
                    students.add(new DoctoralStudent(docFirstName, docLastName, docId, docAdvisorName, docResearchArea, thesisTitle));
                    break;
                case 4:
                    continueEntry = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("All entered students:");
        for (BaseStudent student : students) {
            System.out.println(student);
        }
    }
}