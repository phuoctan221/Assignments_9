package student;

public class Processor {
    public static void main(String[] args) {
        Student student = new Student(); 
        student = student.enterStudentInfo(student); 
        System.out.println(student.toString());
    }
}