import java.util.*;

public class GradeCal {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name Of the Student");
        String name = sc.next();

        System.out.println(name + " , Enter Your 5 subject Marks");

        int[] arr = new int[5];
        int total = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter " + (i + 1) + " Subject Marks out of 100: ");
            arr[i] = sc.nextInt();
            total = total + arr[i];
        }

      

        int average = total / 5;

        char grade = calculateGrade(average);
        System.out.println("Your marks are " + total + " Out of 500");
        System.out.println("Your grade is '" + grade + "'.");
        System.out.println("Your Percentage is " + average + "%.");
    }

    public static char calculateGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
