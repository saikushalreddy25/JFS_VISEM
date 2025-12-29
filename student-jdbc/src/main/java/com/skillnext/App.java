package com.skillnext;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Semester: ");
                    int sem = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    dao.addStudent(new Student(name, sem, dept));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\n--- All Students ---");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Semester: ");
                    int newSem = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();

                    dao.updateStudent(new Student(updateId, newName, newSem, newDept));
                    System.out.println("Student Updated Successfully!");
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    dao.deleteStudent(deleteId);
                    System.out.println("Student Deleted Successfully!");
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        }

        sc.close();
    }
}
