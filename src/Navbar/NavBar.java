package Navbar;

import Model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class NavBar{
    private static Student[] students = new Student[100];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("***************STUDENT MANAGE***************************");
            System.out.println("1. Show List Student..");
            System.out.println("2. Create Student.");
            System.out.println("3. Update Student.");
            System.out.println("4. Delete Student.");
            System.out.println("5. Sort Student By Age ASC (Tăng Dần).");
            System.out.println("6. Exit.");
            System.out.print(" Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStudents();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    sortStudentsByAge();
                    break;
                case 6:
                    System.out.println("Next!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter ID Student: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name Student: ");
        String name = scanner.nextLine();

        System.out.print("Enter age Student: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(id, name, age);
        students[count++] = student;

        System.out.print("More successful students. ");

    }

    private static void viewStudents() {
        if (count == 0) {
            System.out.print("No students displayed. ");
            return;
        }
        System.out.println("Show Student List: ");
        System.out.println("ID\tName\tAge");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].getStudentId() + "\t" + students[i].getStudentName() + "\t" + students[i].getAge());
        }
    }

    private static void updateStudent(Scanner scanner) {
        if (count == 0) {
            System.out.print("No students update. ");
            return;
        }
        System.out.print("Enter ID update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int index = findStudentIndex(id);

        if (index == -1) {
            System.out.print("No students updtae.");
            return;
        }
        System.out.print("Enter new name student:  ");
        String name = scanner.nextLine();

        System.out.print("Enter new age student: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        students[index].setStudentName(name);
        students[index].setAge(age);

        System.out.print("Update successful students. ");
    }

    private static void deleteStudent(Scanner scanner) {
        if (count == 0) {
            System.out.print("No students delete:  ");
            return;
        }
        System.out.print("Enter Id student: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int index = findStudentIndex(id);

        if (index == -1) {
            System.out.print("ID not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            students[i] = students[i + 1];
        }
        count--;

        System.out.print("Delete successful students.");
    }

    private static void sortStudentsByAge() {
        if (count == 0) {
            System.out.print("No student arrangements.");
            return;
        }

        Arrays.sort(students, 0, count, (s1, s2) -> s1.getAge() - s2.getAge());

        System.out.println("Sort Student By Age ASC (Tăng Dần): ");
        System.out.println("ID\tName\tAge");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].getStudentId() + "\t" + students[i].getStudentName() + "\t" + students[i].getAge());
        }
    }

    private static int findStudentIndex(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == id) {
                return i;
            }
        }

        return -1;
    }
}