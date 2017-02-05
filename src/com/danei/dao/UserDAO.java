package com.danei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.danei.entity.Employee;
import com.danei.entity.User;
import com.danei.util.DBUtil;

public class UserDAO {

	// 查询用户信息
	public List<User> findAll() throws Exception {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("select * from user");
			rs = pst.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String truename = rs.getString("truename");
				String sex = rs.getString("sex");

				User user = new User();

				// 设置用户信息
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setTruename(truename);
				user.setSex(sex);
				users.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(conn);
		}
		return users;

	}

	// 添加用户信息
	public void add(User user) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn
					.prepareStatement("insert into user(username,password,truename,sex) values(?,?,?,?)");
			/* id不需要设置，因为在mysql数据库中id字段设置为了自动增值。 */
			// 设置用户信息
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getTruename());
			pst.setString(4, user.getSex());
			pst.executeUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw e1;
		} finally {
			DBUtil.close(conn);
		}

	}

	// 删除用户信息
	public void delete(int id) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("delete from user where id=?");
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

	// 根据用户名获得用户信息
	public User findByUsername(String username) throws Exception {
		User user = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("select * from user where username=?");
			pst.setString(1, username);
			rs = pst.executeQuery();
			//
			if (rs.next()) {
				user = new User();

				int id = rs.getInt("id");
				username = rs.getString("username");
				String password = rs.getString("password");
				String truename = rs.getString("truename");
				String sex = rs.getString("sex");
				// 设置用户信息
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setTruename(truename);
				user.setSex(sex);
			}
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			throw e3;
		} finally {
			DBUtil.close(conn);
		}
		return user;
	}

	// 修改用户信息
	public void modify(User user) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try { 
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement("update user "
					+ "set username=?,password=?,truename=?,sex=? where id=?");
			System.err.println(user.getId()+""+user.getUsername()+""+user.getPassword());
			System.err.println(user.getId()+""+user.getUsername()+""+user.getPassword()+""+user.getTruename());
			// 设置用户信息
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getTruename());
			pst.setString(4, user.getSex());
			pst.setInt(5, user.getId());
			pst.executeUpdate();
			System.err.println(user.getId()+""+user.getUsername()+""+user.getPassword()+""+user.getTruename());
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
			throw e4;
		} finally {
			DBUtil.close(conn);
		}
	}

	public static void main(String[] args) throws Exception {
		UserDAO userdao = new UserDAO();

		// 测试查询用户信息是否成功
		List<User> users = userdao.findAll();
		// 已经重写toString方法
		System.out.println(users);

		User user = new User();
		// 测试添加用户信息是否成功

		// user.setUsername("user01");
		// user.setPassword("123456");
		// user.setTruename("user01");
		// user.setSex("男");
		// userdao.add(user);
		// users = userdao.findAll();
		// System.out.println(users);

		// 测试删除用户信息是否成功
		/*
		 * userdao.delete(4); users= userdao.findAll();
		 * System.out.println(users);
		 */

		// 测试根据用户名获得用户信息是否成功
		/*
		 * user = userdao.findByUsername("admin"); // 已经重写toString方法
		 * System.out.println(user);
		 */
		// 测试修改用户信息是否成功
		// user.setId(6);
		// user.setUsername("user02");
		// user.setPassword("123456");
		// user.setTruename("user02");
		// user.setSex("女");
		// userdao.modify(user);
		// users = userdao.findAll();
		// System.out.println(users);

	}
}
