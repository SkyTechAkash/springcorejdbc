package org.springcore.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springcore.jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.jdbc.dao.StudentDao;
import com.springcore.jdbc.dao.StudentImpl;

public class App {
	public static void main(String[] args) {
		
		// Traditional Way to run the db query
		// get the bean object of JDBC Template
		//ApplicationContext context = new ClassPathXmlApplicationContext("org/springcore/jdbc/Config.xml"); // ---> used for XML Configuration....
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);  // ---> used for without Configuration.....
		/*
		 * JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * 
		 * //insert query String q = "insert into student(id,name,city) values(?,?,?)";
		 * 
		 * template.update(q,102,"Sachin","Mangalore");
		 */

		// Best Practice to do ... recommended way for Enterprise Level
		StudentDao getDao = context.getBean("studentDao",StudentDao.class);
		//StudentDao getDao = (StudentDao) bean;

		// insert StudentData.........................
		  Student std = new Student(); 
		  std.setId(106); 
		  std.setName("Aditi");
		  std.setCity("Meerut"); getDao.insert(std);
		  System.out.println("Data has been inserted......");

		// Deleting StudentData.......................
		/*
		 * Student std1 = new Student(); int delete =
		 * getDao.delete(102);
		 * 
		 * System.out.println(delete + "student id with " + std1.getId() + " is deleted..."
		 * );
		 */

		// Updating the StudentData.................
		/*
		 * Student std2 = new Student(); std2.setId(102); std2.setName("Akash");
		 * std2.setCity("BLR");
		 * 
		 * getDao.update(std2);
		 */

		// Selecting the single StudentData Object from Student Table
		Student findById = getDao.findById(104);
		System.out.println(findById);
		
		//Selecting the List of StudentData Object from Student Table
		List<Student> findAll = getDao.findAll();
		System.out.println(findAll);

	}
}
