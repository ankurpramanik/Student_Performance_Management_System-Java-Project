package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static DbUtil dbUtil;

	public static DbUtil getInstance() {
		if (dbUtil == null) {
			dbUtil = new DbUtil();
			System.out.println("\nDbUtil Created\n");
		}

		return dbUtil;
	}

	public Connection getDbConnection() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_performance2", "root", "ankur123");
		return connection;

	}

}
