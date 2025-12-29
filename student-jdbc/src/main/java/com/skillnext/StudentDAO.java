package com.skillnext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final String url = "jdbc:mysql://localhost:3306/skillnext_db";
    private final String user = "root";  // change if your MySQL username is different
    private final String password = "root"; // change to your MySQL password

    // Get database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Add student
    public void addStudent(Student s) {
        String sql = "INSERT INTO student(name, sem, dept) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getSem());
            ps.setString(3, s.getDept());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("sem"),
                        rs.getString("dept")
                );
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update student
    public void updateStudent(Student s) {
        String sql = "UPDATE student SET name=?, sem=?, dept=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getSem());
            ps.setString(3, s.getDept());
            ps.setInt(4, s.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
