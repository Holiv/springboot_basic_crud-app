package com.p30dev.cruddemo;

import com.p30dev.cruddemo.dao.StudentDAO;
import com.p30dev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {
	public Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

//		System.out.println("Enter the student Id: ");
//		Integer studentId = Integer.parseInt(scanner.nextLine());

//		System.out.println("Enter the student Name: ");
//		String studentName =  scanner.nextLine();

//		System.out.println("Enter the student Name have the Last Name updated: ");
//		String studentCurrentName =  scanner.nextLine();
//
//		System.out.println("Enter the student New Last Name: ");
//		String studentNewLastName =  scanner.nextLine();

		System.out.println("Enter the student first name to be deleted: ");
		String firstName =  scanner.nextLine();

		return runner -> {
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			readStudent(studentDAO, studentId);

//			getAllStudents(studentDAO);

//			getStudentByName(studentDAO, studentName);

//			updateStudentLastName(studentDAO, studentCurrentName, studentNewLastName);

//			updateAllStudentsLastNameToTester(studentDAO);

			deleteStudent(studentDAO, firstName);
		};
	}

	private void deleteStudent(StudentDAO studentDAO, String firstName) {
		studentDAO.deleteStudent(firstName);
		System.out.printf("Student %s was deleted", firstName);
	}

	private void updateAllStudentsLastNameToTester(StudentDAO studentDAO) {
		studentDAO.updateAllStudentsLastName();
	}

	private void updateStudentLastName(StudentDAO student, String studentCurrentName, String studentNewLastName) {
		student.updateStudentLastName(studentCurrentName, studentNewLastName);
		Student updatedStudent = student.findByName(studentCurrentName);
		System.out.println("Updated Student: " + updatedStudent);
	}

	private void readStudent(StudentDAO studentDAO, Integer id) {
		Student student = studentDAO.findById(id);
		System.out.println("Student found: " + student.toString());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("Laiz", "Alvarenga", "laiz@gmail.com");
		Student student2 = new Student("Thomas", "Oliveira", "thomas@gmail.com");
		Student student3 = new Student("Amora", "Alvarenga", "amora@gmail.com");

		List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3));
		for (Student student : students) {
			studentDAO.save(student);
			System.out.println(student.toString());
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Helton", "Oliveira", "mrheltonso@gmail.com");

		studentDAO.save(student);

		System.out.println("Student created and saved on the Database id of number " + student.getId());
	}

	private void getStudentByName(StudentDAO studentDAO, String name) {
		Student student = studentDAO.findByName(name);
		System.out.println("Student found: " + student.toString());
	}
}
