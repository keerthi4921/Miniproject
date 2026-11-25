
public class Student {

    private int studentId;
    private String name;
    private String department;
    private int mark1, mark2, mark3;

    public Student(int studentId, String name, String department,
                   int mark1, int mark2, int mark3) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int calculateTotal() {
        return mark1 + mark2 + mark3;
    }

    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    public String calculateGrade() {
        double avg = calculateAverage();

        if (avg >= 90)
            return "A+";
        else if (avg >= 80)
            return "A";
        else if (avg >= 70)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 50)
            return "D";
        else
            return "Fail";
    }

    public String calculateResult() {
        if (mark1 >= 35 && mark2 >= 35 && mark3 >= 35)
            return "PASS";
        else
            return "FAIL";
    }

    public void updateMarks(int m1, int m2, int m3) {
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
    }

    public void displayStudent() {
        System.out.println("\nStudent ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Subject 1  : " + mark1);
        System.out.println("Subject 2  : " + mark2);
        System.out.println("Subject 3  : " + mark3);
        System.out.println("Total      : " + calculateTotal());
        System.out.println("Average    : " + calculateAverage());
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("Result     : " + calculateResult());
    }
}
