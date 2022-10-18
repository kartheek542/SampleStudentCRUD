package com.fatcat.sample.model;

public class Student {
	private long sid;
	private String name;
	private int age;
	private String dept;
	private int year;
	
	public Student() {
		
	}

	public Student(long sid, String name, int age, String dept, int year) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.year = year;
	}

	public Student(String name, int age, String dept, int year) {
		super();
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.year = year;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", dept=" + dept + ", year=" + year + "]";
	}
	
	
}
