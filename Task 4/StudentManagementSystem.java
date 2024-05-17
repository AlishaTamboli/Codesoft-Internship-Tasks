import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_management";
        String user = "root";  // Replace with your MySQL username
        String password = "Alisha@123";  // Replace with your MySQL password
        return DriverManager.getConnection(url, user, password);
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, roll_number, grade) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getRollNumber());
            pstmt.setString(3, student.getGrade());
            pstmt.executeUpdate();
            System.out.println("Added: " + student);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeStudent(String rollNumber) {
        String sql = "DELETE FROM students WHERE roll_number = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rollNumber);
            pstmt.executeUpdate();
            System.out.println("Removed student with Roll Number: " + rollNumber);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Student searchStudent(String rollNumber) {
        String sql = "SELECT * FROM students WHERE roll_number = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rollNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getString("name"), rs.getString("roll_number"), rs.getString("grade"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(rs.getString("name"), rs.getString("roll_number"), rs.getString("grade")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
