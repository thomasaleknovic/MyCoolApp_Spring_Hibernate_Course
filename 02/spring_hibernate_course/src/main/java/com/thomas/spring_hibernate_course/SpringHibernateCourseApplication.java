package com.thomas.spring_hibernate_course;

import com.thomas.spring_hibernate_course.dao.StudentDAO;
import com.thomas.spring_hibernate_course.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
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
