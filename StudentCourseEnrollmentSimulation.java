import java.util.Scanner;
abstract class Course {
    private String faculty;
    private String content;
    private boolean isEnrolled;
    private double grade;
    private int attendance;

    Course(String faculty, String content) {
        this.faculty = faculty;
        this.content = content;
        this.isEnrolled = false;
        this.grade = 0.0;
        this.attendance = 0;
    }

    public void enroll() {
        if (!isEnrolled) {
            isEnrolled = true;
            System.out.println("Enrolled in " + getCourseName() + " with faculty " + faculty);
        } else {
            System.out.println("Already enrolled in " + getCourseName());
        }
    }
    public void viewContent() {
        if (isEnrolled) {
            System.out.println("Course: " + getCourseName() + " | Content: " + content);
        } else {
            System.out.println("You must enroll first to view content of " + getCourseName());
        }
    }

    public abstract String getCourseName();

    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }
}

class Math extends Course {
    Math(String faculty, String content) {
        super(faculty, content);
    }

    @Override
    public String getCourseName() {
        return "Math";
    }
}

class Physics extends Course {
    Physics(String faculty, String content) {
        super(faculty, content);
    }

    @Override
    public String getCourseName() {
        return "Physics";
    }
}

class History extends Course {
    History(String faculty, String content) {
        super(faculty, content);
    }

    @Override
    public String getCourseName() {
        return "History";
    }
}

class Student {
    private String name;
    private String rollNumber;

    private Course course1;
    private Course course2;
    private Course course3;

    Student(String name, String rollNumber, Course c1, Course c2, Course c3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course1 = c1;
        this.course2 = c2;
        this.course3 = c3;
    }

    public void enrollInCourse(int courseNumber) {
        if (courseNumber == 1) course1.enroll();
        else if (courseNumber == 2) course2.enroll();
        else if (courseNumber == 3) course3.enroll();
        else System.out.println("Invalid course number!");
    }

    public void viewCourseContent(int courseNumber) {
        if (courseNumber == 1) course1.viewContent();
        else if (courseNumber == 2) course2.viewContent();
        else if (courseNumber == 3) course3.viewContent();
        else System.out.println("Invalid course number!");
    }

    public void showGrades() {
        System.out.println("Grades and Attendance for " + name + ":");
        System.out.println(course1.getCourseName() + " | Grade: " + course1.getGrade() + " | Attendance: " + course1.getAttendance());
        System.out.println(course2.getCourseName() + " | Grade: " + course2.getGrade() + " | Attendance: " + course2.getAttendance());
        System.out.println(course3.getCourseName() + " | Grade: " + course3.getGrade() + " | Attendance: " + course3.getAttendance());
    }
}


public class StudentCourseEnrollmentSimulation {
    public static void main(String[] args) {
        Course math = new Math("Dr. Smith", "Algebra, Calculus, Geometry");
        Course physics = new Physics("Dr. Johnson", "Mechanics, Thermodynamics");
        Course history = new History("Dr. Brown", "Ancient, Medieval, Modern History");

        Student s1 = new Student("Shubham", "S001", math, physics, history);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Enroll in Math");
            System.out.println("2. Enroll in Physics");
            System.out.println("3. Enroll in History");
            System.out.println("4. View Math Content");
            System.out.println("5. View Physics Content");
            System.out.println("6. View History Content");
            System.out.println("7. Show Grades & Attendance");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) s1.enrollInCourse(choice);
            else if (choice >= 4 && choice <= 6) s1.viewCourseContent(choice - 3);
            else if (choice == 7) s1.showGrades();
            else if (choice == 8) {
                System.out.println("Exiting...");
                break;
            }
            else System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
