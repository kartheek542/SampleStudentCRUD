package com.fatcat.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fatcat.sample.model.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Student> findAll() {
		String query = "SELECT * from student;";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Student.class));
	}
	
	public int save(Student student) {
		String query = "INSERT INTO student (name, age, dept, year) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(query, student.getName(), student.getAge(), student.getDept(), student.getYear());
	}
	
	public Student findBySid(long sid) {
		String query = "SELECT * from student WHERE sid = ?";
		try {
			Student student = jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Student.class), sid);
			return student;
		} catch (Exception e) {
			return null;
		}
	}
	
	public int update(Student student) {
		String query = "UPDATE student SET name = ?, age = ?, dept = ?, year = ? WHERE sid = ?";
		return jdbcTemplate.update(query, student.getName(), student.getAge(), student.getDept(), student.getYear(), student.getSid());
	}
	
	public int deleteBySid(long sid) {
		String query = "DELETE FROM student WHERE sid = ?";
		return jdbcTemplate.update(query, sid);
	}
}
