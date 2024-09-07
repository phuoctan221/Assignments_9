package student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    String id;
    String fullName;
    float GPA;
    Date dateOfBirth;
    String major;

    public Student(String id, String fullName, float GPA, Date dateOfBirth, String major) {
        this.id = id;
        this.fullName = fullName;
        this.GPA = GPA;
        this.dateOfBirth = dateOfBirth;
        this.major = major;
    }

    public Student() {
    }

    public boolean isValidDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateStr); 
            return true;
        } catch (Exception e) {
            return false; 
        }
    }

    public Student enterStudentInfo(Student student) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter ID: ");
        student.id = sc.nextLine();

        System.out.print("Enter Full Name: ");
        student.fullName = sc.nextLine();

        System.out.print("Enter GPA: ");
        student.GPA = sc.nextFloat();
        sc.nextLine(); 

        System.out.print("Enter Major: ");
        student.major = sc.nextLine();

        String dobString;
        do {
            System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
            dobString = sc.nextLine();
            if (!isValidDate(dobString)) {
                System.out.println("Invalid date format. Please try again.");
            }
        } while (!isValidDate(dobString));

        try {
            student.dateOfBirth = dateFormat.parse(dobString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Student ID: " + id +
               "\nFull Name: " + fullName +
                "\nDate of Birth: " + dateFormat.format(dateOfBirth)+
               "\nGPA: " + GPA +
               "\nMajor: " + major;
    }
}