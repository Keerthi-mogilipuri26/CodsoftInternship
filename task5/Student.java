import java.util.ArrayList;

class Student {
    String studentID;
    String name;
    ArrayList<String> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Registered Courses: " + registeredCourses);
    }
}
