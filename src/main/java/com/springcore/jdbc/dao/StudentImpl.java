package com.springcore.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springcore.jdbc.entites.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;

	public int insert(Student std) {
		String q = "insert into student(id,name,city) values(?,?,?)";
		int insert = this.jdbcTemplate.update(q,std.getId(),std.getName(),std.getCity());
		return insert;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int delete(int stdId) {
		String q = "delete from student where id=?";
		int delete = this.jdbcTemplate.update(q,stdId);
		return delete;
	}

	public int update(Student std) {
		String q = "update student set name=?, city=? where id=?";
		return this.jdbcTemplate.update(q,std.getName(),std.getCity(),std.getId());
	}

	public Student findById(int stdId) {
		String q = "Select * from student where id=?";
		return this.jdbcTemplate.queryForObject(q, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
		}, stdId);
	}

	public List<Student> findAll() {
		String q = "Select * from student";
		return this.jdbcTemplate.query(q, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
		});
	}
	
	 

}
