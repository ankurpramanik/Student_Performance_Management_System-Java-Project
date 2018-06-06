package com.performance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.performance.dto.RoleDto;

import dbUtil.DbUtil;

public class RoleIdDao {
	public static List<RoleDto> getRole() {
		List<RoleDto> roleList = new ArrayList<>();
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT roleId, roleName FROM role";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				RoleDto role = new RoleDto();
				role.setRoleId(resultSet.getInt("roleId"));
				role.setRoleName(resultSet.getString("roleName"));

				roleList.add(role);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return roleList;
	}
}
