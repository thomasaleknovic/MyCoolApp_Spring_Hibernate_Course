package com.thomas.spring_hibernate_course;

import com.thomas.spring_hibernate_course.dao.StudentDAO;
import com.thomas.spring_hibernate_course.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastname(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All students");
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with ID:" + studentId);

		studentDAO.delete(studentId);


	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with ID:" + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");

		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		System.out.println("Updated student:" + myStudent);
	}

	private void queryForStudentsByLastname(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("James", "Lock", "aleknovic@gmail.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Searching students by it's lastname...");
		List<Student> theStudents = studentDAO.findByLastName(tempStudent.getLastName());
		for (Student student : theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Searching students...");
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object...");
		Student tempStudent = new Student("James", "Aleknovic", "aleknovic@gmail.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		System.out.println("\n retrieving student with id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: " + myStudent);

		Student myStudent2 = studentDAO.findById(3);
		System.out.println("Found the student: " + myStudent2);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new students objects...");
		Student tempStudent1 = new Student("Thomas", "Aleknovic", "aleknovic@gmail.com");
		Student tempStudent2 = new Student("John", "Beloved", "john@gmail.com");
		Student tempStudent3 = new Student("Peter", "Rock", "peter@gmail.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student: " + tempStudent1.getFirstName() + " Generated id: " + tempStudent1.getId());
		System.out.println("Saved student: " + tempStudent2.getFirstName() + " Generated id: " + tempStudent2.getId());
		System.out.println("Saved student: " + tempStudent3.getFirstName() + " Generated id: " + tempStudent3.getId());


	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Thomas", "Aleknovic", "aleknovic@gmail.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
