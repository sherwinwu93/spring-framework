package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqlUtil {
	private final static String url = "jdbc:mysql://localhost:3306/spring";
	private final static String username = "root";
	private final static String password = "Wusd123..";
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;

	static {
		//1.注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int update(String sql, Object... params) {
		int line = 0;
		try {
			//3.获取预编译对象
			statement = connection.prepareStatement(sql);
			//3.1.设置参数
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			//4.执行SQL语句
			line = statement.executeUpdate();
			//5.处理结果集
			System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return line;
	}

	public static List<Map<String, Object>> query(String sql, Object... params) {
		List<Map<String, Object>> rowList = new ArrayList<>();
		try {

			//3.获取预编译对象
			statement = connection.prepareStatement(sql);
			//4.设置请求参数
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			//5.执行sql
			resultSet = statement.executeQuery();
			//6.处理结果集
			//头部信息
			ResultSetMetaData metaData = resultSet.getMetaData();
			while (resultSet.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					String columnName = metaData.getColumnName(i + 1);
					Object columnValue = resultSet.getObject(columnName);
					row.put(columnName, columnValue);
				}
				rowList.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rowList;
	}

	private static void close() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
