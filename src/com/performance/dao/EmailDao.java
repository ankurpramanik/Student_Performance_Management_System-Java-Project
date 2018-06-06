package com.performance.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.performance.dto.EmailDto;

import dbUtil.DbUtil;

public class EmailDao {

	public static boolean sendMail(EmailDto emailList) {
		boolean result = false;
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "INSERT INTO student_performance2.pailanmail (\r\n" + "  firstName,\r\n" + "  lastName,\r\n"
					+ "  email,\r\n" + "  SUBJECT,\r\n" + "  messege,\r\n" + "  tag\r\n" + ")\r\n" + "VALUES\r\n"
					+ "  (?,?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, emailList.getFirstName());
			statement.setString(2, emailList.getLastName());
			statement.setString(3, emailList.getEmail());
			statement.setString(4, emailList.getSubject());
			statement.setString(5, emailList.getMessege());
			statement.setBoolean(6, true);

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<EmailDto> getMesseges() {
		List<EmailDto> mailList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();
		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  slNo,\r\n" + "  firstName,\r\n" + "  lastName,\r\n" + "  email,\r\n"
					+ "  SUBJECT,\r\n" + "  messege,\r\n" + "  tag\r\n" + "FROM\r\n"
					+ "  pailanmail WHERE tag=1 ORDER BY slNo DESC;";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				EmailDto emailDto = new EmailDto();

				emailDto.setSlNo(resultSet.getInt("slNo"));
				emailDto.setFirstName(resultSet.getString("firstName"));
				emailDto.setLastName(resultSet.getString("lastName"));
				emailDto.setEmail(resultSet.getString("email"));
				emailDto.setSubject(resultSet.getString("subject"));
				emailDto.setMessege(resultSet.getString("messege"));

				System.out.println("mail serial no=====  " + emailDto.getSlNo());

				mailList.add(emailDto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mailList;
	}

	public static void deleteMessege(int slNo) {

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "DELETE FROM pailanmail WHERE slNo = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, slNo);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
