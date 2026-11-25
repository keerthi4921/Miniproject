
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }

            System.out.println("Please enter a valid number.");
            sc.nextLine();
        }
    }

    public static int readMark(Scanner sc, String message) {
        while (true) {
            int mark = readInt(sc, message);

            if (mark >= 0 && mark <= 100) {
                return mark;
            }

            System.out.println("Marks must be between 0 and 100.");
        }
    }

    public static Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    public static void addStudent(Scanner sc) {

        int id = readInt(sc, "Enter Student ID: ");

        if (searchStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        int m1 = readMark(sc, "Enter Subject 1 Marks: ");
        int m2 = readMark(sc, "Enter Subject 2 Marks: ");
        int m3 = readMark(sc, "Enter Subject 3 Marks: ");

        Student s = new Student(id, name, department, m1, m2, m3);

        students.add(s);

        System.out.println("Student added successfully!");
    }

    public static void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.displayStudent();
        }
    }

    public static void searchStudentById(Scanner sc) {

        int id = readInt(sc, "Enter Student ID to search: ");

        Student s = searchStudent(id);

        if (s != null) {
            s.displayStudent();
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void updateStudent(Scanner sc) {

        int id = readInt(sc, "Enter Student ID to update: ");

        Student s = searchStudent(id);

        if (s != null) {
            int m1 = readMark(sc, "Enter New Subject 1 Marks: ");
            int m2 = readMark(sc, "Enter New Subject 2 Marks: ");
            int m3 = readMark(sc, "Enter New Subject 3 Marks: ");

            s.updateMarks(m1, m2, m3);

            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void deleteStudent(Scanner sc) {

        int id = readInt(sc, "Enter Student ID to delete: ");

        Student s = searchStudent(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void displayTopper() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        Student topper = students.get(0);

        for (Student s : students) {
            if (s.calculateAverage() > topper.calculateAverage()) {
                topper = s;
            }
        }

        System.out.println("\n===== CLASS TOPPER =====");
        topper.displayStudent();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Class Topper");
            System.out.println("7. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayAllStudents();
                    break;

                case 3:
                    searchStudentById(sc);
                    break;

                case 4:
                    updateStudent(sc);
                    break;

                case 5:
                    deleteStudent(sc);
                    break;

                case 6:
                    displayTopper();
                    break;

                case 7:
                    System.out.println("Thank you! Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
