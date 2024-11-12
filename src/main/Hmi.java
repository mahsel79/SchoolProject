package main;

import models.School;
import models.Student;
import services.SchoolServices;

import java.util.Scanner;

public class Hmi {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        School school = createSchool(); // Moved method outside of start method
        SchoolServices schoolServices = new SchoolServices(school);

        System.out.println("Welcome to " + school.getName() + " in " + school.getAddress());
        String action;

        do {
            System.out.println("What do you want to do? ");
            action = scanner.next();
            if (action.equals("addStudent")) {
                Student student = new Student();
                System.out.println("Please enter the name of the student: ");
                student.setName(scanner.next());
                System.out.println("Please enter the age of the student: ");
                student.setAge(scanner.nextInt());
                System.out.println("Please enter the phone number of the student: ");
                student.setParentPhoneNumber(scanner.next());
                schoolServices.addStudent(student);
            }
            if (action.equals("printAllStudents")) {
                for (Student student : school.getStudents()) {
                    System.out.println(student.getName() + " " + student.getAge() + " " + student.getParentPhoneNumber());
                }
            }
        } while (!action.equals("exit"));
    }

    private static School createSchool() { // Moved this method outside start method
        School school = new School();
        school.setName("Selman Online Programming");
        school.setAddress("Malmö");
        school.setPhoneNumber("+46765551504");
        return school;
    }
}
