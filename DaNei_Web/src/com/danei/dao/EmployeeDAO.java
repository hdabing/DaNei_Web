package com.danei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sun.net.www.content.text.plain;

import com.danei.entity.Employee;
import com.danei.util.DBUtil;

/**
 * 
 * DAO类： 封装了访问数据库的代码。
 */
public class EmployeeDAO {
	// 查询员工信息
	public List<Employee> findAll() throws Exception {
		List<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("select * from emp");
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");

				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setAge(age);
				employees.add(e);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(conn);
		}
		return employees;
	}

	// 添加员工信息
	public void save(Employee e) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn
					.prepareStatement("insert into emp(name,salary,age) values(?,?,?)");
			/* id不需要设置，因为在mysql数据库中id字段设置为了自动增值。 */
			pst.setString(1, e.getName());
			pst.setDouble(2, e.getSalary());
			pst.setInt(3, e.getAge());
			pst.executeUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw e1;
		} finally {
			DBUtil.close(conn);
		}

	}

	// 删除员工信息
	public void delete(int id) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("delete from emp where id=?");
			/* id不需要设置，因为在mysql数据库中id字段设置为了自动增值。 */
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			throw e2;
		} finally {
			DBUtil.close(conn);
		}
	}

	// 通过id得到员工信息
	public Employee findById(int id) throws Exception {
		Employee e = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("select * from emp where id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setAge(age);
			}
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			throw e3;
		} finally {
			DBUtil.close(conn);
		}
		return e;
	}

	// 修改员工信息
	public void modify(Employee e) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("update emp "
					+ "set name=?,salary=?,age=? where id=? ");
			pst.setString(1, e.getName());
			pst.setDouble(2, e.getSalary());
			pst.setInt(3, e.getAge());
			pst.setInt(4, e.getId());
			pst.executeUpdate();
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
			throw e4;
		} finally {
			DBUtil.close(conn);
		}
	}

	// 测试
	public static void main(String[] args) throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		// 测试查询员工信息是否成功
		List<Employee> employees = dao.findAll();
		// 已经重写toString方法
		System.out.println(employees);

		// 测试添加,保存员工信息是否成功
		Employee e = new Employee();
		//
		// e.setName("emp01");
		// e.setSalary(5000);
		// e.setAge(30);
		// dao.save(e);
		// employees=dao.findAll();
		// System.out.println(employees);
		//
		// 测试删除员工信息是否成功
		/*
		 * dao.delete(4); employees = dao.findAll();
		 * System.out.println(employees);
		 */
		// 测试是否可以通过id得到员工信息

		// e=dao.findById(1); String name=e.getName(); double
		// salary=e.getSalary(); int age=e.getAge();
		// System.out.println(name+" "+salary+""+age);
		// 测试修改员工信息是否成功
		// e.setId(5);
		// e.setName("李白");
		// e.setSalary(7000);
		// e.setAge(30);
		// dao.modify(e);
		// employees = dao.findAll();
		// System.out.println(employees);
		//
	}
}
