package com.performance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.performance.dto.DepartmentDto;
import com.performance.dto.MenuDto;
import com.performance.dto.UserDto;

import dbUtil.DbUtil;

public class UserDao {
	public static boolean validateUser(String userId, String password) {
		boolean result = false;

		DbUtil dbUtil = DbUtil.getInstance();
		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  userId,\r\n" + "  firstName,\r\n" + "  lastName,\r\n" + "  email,\r\n"
					+ "  phone,\r\n" + "  PASSWORD,\r\n" + "  roleId,\r\n" + "  tag\r\n" + "FROM\r\n" + "  users\r\n"
					+ "" + "where userId=? and password=? and tag=1";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static UserDto getUser(String userId) {
		UserDto dto = new UserDto();

		DbUtil dbUtil = DbUtil.getInstance();
		try {
			Connection connection = dbUtil.getDbConnection();

			String sql = "SELECT * FROM users WHERE userId=? and tag=1";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				dto.setFirstName(resultSet.getString("firstName"));
				dto.setLastName(resultSet.getString("lastName"));
				dto.setUserId("userId");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dto;
	}

	public static List<MenuDto> getMenus(String userId) {
		List<MenuDto> menuList = new ArrayList<>();
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT menuName,menuUrl FROM menu WHERE roleId IN(SELECT roleId FROM users WHERE userId=?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MenuDto menu = new MenuDto();
				menu.setMenuName(resultSet.getString("menuName"));
				menu.setMenuUrl(resultSet.getString("menuUrl"));

				menuList.add(menu);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return menuList;

	}

	public static List<DepartmentDto> getDepartments() {

		List<DepartmentDto> departmentList = new ArrayList<>();
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "select departmentId, departmentName from department";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DepartmentDto department = new DepartmentDto();
				department.setDepartmentId(resultSet.getInt("departmentId"));
				department.setDepartmentName(resultSet.getString("departmentName"));

				departmentList.add(department);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return departmentList;

	}

	public static boolean addUser(UserDto userDetails) {
		// TODO Auto-generated method stub
		boolean result = false;

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "INSERT INTO users (\r\n" + "  userId,\r\n" + "  firstName,\r\n" + "  lastName,\r\n"
					+ "  email,\r\n" + "  phone,\r\n" + "  PASSWORD,\r\n" + "  roleId,\r\n" + "  tag\r\n" + ")\r\n"
					+ "VALUES\r\n" + "  (?,?,?,?,?,?,?,?);";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, userDetails.getUserId());
			statement.setString(2, userDetails.getFirstName());
			statement.setString(3, userDetails.getLastName());
			statement.setString(4, userDetails.getEmail());
			statement.setString(5, userDetails.getPhone());
			statement.setString(6, userDetails.getPassword());
			statement.setInt(7, userDetails.getRoleId());
			statement.setBoolean(8, false);

			int row = statement.executeUpdate();

			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public static UserDto getUserInformation(String userId) {

		UserDto userDto = new UserDto();
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT    userId,    firstName,    lastName,    email,\r\n"
					+ "					   phone,    PASSWORD,    u.roleId,  roleName  FROM\r\n"
					+ "					   users u, role r WHERE userId=? AND u.roleId=r.roleId AND tag=1;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				userDto.setUserId(rs.getString("userId"));
				userDto.setFirstName(rs.getString("firstName"));
				userDto.setLastName(rs.getString("lastName"));
				userDto.setEmail(rs.getString("email"));
				userDto.setPhone(rs.getString("phone"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRoleId(Integer.parseInt(rs.getString("roleId")));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return userDto;
	}

	public static boolean updateUser(UserDto userDetails) {
		boolean result = false;
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "UPDATE\r\n" + "  users\r\n" + "SET\r\n" + "  firstName = ?,\r\n" + "  lastName = ?,\r\n"
					+ "  email = ?,\r\n" + "  phone = ?,\r\n" + "  PASSWORD = ?,\r\n" + "  roleId = ?\r\n"
					+ "WHERE userId = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, userDetails.getFirstName());
			statement.setString(2, userDetails.getLastName());
			statement.setString(3, userDetails.getEmail());
			statement.setString(4, userDetails.getPhone());
			statement.setString(5, userDetails.getPassword());
			statement.setInt(6, userDetails.getRoleId());
			statement.setString(7, userDetails.getUserId());

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<UserDto> getInactiveUserDetails() {

		List<UserDto> userList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();
		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  userId,\r\n" + "  firstName,\r\n" + "  lastName,\r\n" + "  email,\r\n"
					+ "  phone,\r\n" + "  roleName\r\n" + "FROM\r\n"
					+ "  users u, role r WHERE u.roleId=r.roleId AND tag=0;";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				UserDto userDto = new UserDto();

				userDto.setUserId(resultSet.getString("userId"));
				userDto.setFirstName(resultSet.getString("firstName"));
				userDto.setLastName(resultSet.getString("lastName"));
				userDto.setEmail(resultSet.getString("email"));
				userDto.setPhone(resultSet.getString("phone"));

				userDto.setRoleName(resultSet.getString("roleName"));

				userList.add(userDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	public static void activateUser(String userId) {

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "UPDATE\r\n" + "  users\r\n" + "SET\r\n" + "  tag = ?\r\n" + "WHERE userId =? ;";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setBoolean(1, true);
			statement.setString(2, userId);

			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void deleteUser(String userId) {

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "DELETE\r\n" + "FROM\r\n" + "  users\r\n" + "WHERE userId = ? and tag=0;";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, userId);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void deleteAllocatedSubject(String subCode, String deptId, String techerId) {

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "DELETE\r\n" + "FROM\r\n" + "  student_performance2.subjectalocated\r\n"
					+ "WHERE subjectCode = ?\r\n" + "  AND teacherId = ?\r\n" + "  AND departmentId = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, subCode);
			statement.setString(2, techerId);
			statement.setString(3, deptId);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
