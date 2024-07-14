import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the total number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Initializing variables
        int totalMarks = 0;

        // Get marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.printf("Enter marks for subject %d (out of 100): ", i);
            int marks = scanner.nextInt();

            // Validate marks (0 to 100)
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                continue; // Skip to the next iteration if marks are invalid
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Calculate grade based on average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
