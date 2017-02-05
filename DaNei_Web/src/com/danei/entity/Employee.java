package com.danei.entity;

/**
 * 实体类： 用来保存从数据库查询出来的数据
 * */
public class Employee {

	private int		id;

	private String	name;

	private double	salary;

	private int		age;

	//重写toString方法，方便单元测试
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", age=" + age + "]";
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
