import java.util.Scanner;
import java.util.TreeMap;

class CourseDatabase {
    TreeMap<String, Course> courses;

    public CourseDatabase() {
        courses = new TreeMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.courseCode, course);
    }

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public void listCourses() {
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }
}

class StudentDatabase {
    TreeMap<String, Student> students;

    public StudentDatabase() {
        students = new TreeMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.studentID, student);
    }

    public Student getStudent(String studentID) {
        return students.get(studentID);
    }

    public void listStudents() {
        for (Student student : students.values()) {
            student.displayDetails();
            System.out.println();
        }
    }
}

public class StudentCourseRegistrationSystem {
    static CourseDatabase courseDatabase = new CourseDatabase();
    static StudentDatabase studentDatabase = new StudentDatabase();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adding some sample courses with reduced slots
        courseDatabase.addCourse(new Course("CP101", "C Programming", "Basics of C programming", 3, "MWF 10:00-11:00"));
        courseDatabase.addCourse(new Course("PY101", "Python", "Introduction to Python", 3, "TTh 09:00-10:30"));
        courseDatabase.addCourse(new Course("DB101", "Database", "Introduction to Databases", 3, "MWF 11:00-12:00"));
        courseDatabase.addCourse(new Course("DL101", "Deep Learning", "Basics of Deep Learning", 3, "TTh 11:00-12:30"));

        // Adding some sample students
        studentDatabase.addStudent(new Student("S001", "John"));
        studentDatabase.addStudent(new Student("S002", "Alice"));
        studentDatabase.addStudent(new Student("S003", "Bob"));
        studentDatabase.addStudent(new Student("S004", "Alen"));
        studentDatabase.addStudent(new Student("S005", "Eve"));

        while (true) {
            System.out.println("1. List Students");
            System.out.println("2. List Courses");
            System.out.println("3. Register for Course");
            System.out.println("4. Drop Course");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                studentDatabase.listStudents();
            } else if (choice == 2) {
                courseDatabase.listCourses();
            } else if (choice == 3) {
                System.out.print("Enter your student ID: ");
                String studentID = scanner.nextLine();
                Student student = studentDatabase.getStudent(studentID);

                if (student == null) {
                    System.out.println("Student not found!");
                    continue;
                }

                System.out.print("Enter course code to register: ");
                String courseCode = scanner.nextLine();
                Course course = courseDatabase.getCourse(courseCode);

                if (course == null) {
                    System.out.println("Course not found!");
                } else if (course.isFull()) {
                    System.out.println("Course is full!");
                } else {
                    course.enroll();
                    student.registerCourse(courseCode);
                    System.out.println("Successfully registered for " + course.title);
                }
            } else if (choice == 4) {
                System.out.print("Enter your student ID: ");
                String studentID = scanner.nextLine();
                Student student = studentDatabase.getStudent(studentID);

                if (student == null) {
                    System.out.println("Student not found!");
                    continue;
                }

                System.out.print("Enter course code to drop: ");
                String courseCode = scanner.nextLine();
                Course course = courseDatabase.getCourse(courseCode);

                if (course == null) {
                    System.out.println("Course not found!");
                } else {
                    course.drop();
                    student.dropCourse(courseCode);
                    System.out.println("Successfully dropped " + course.title);
                }
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }
}
