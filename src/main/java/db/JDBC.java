package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		String sql;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
		// 避免中文乱码要指定useUnicode和characterEncoding
		// 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
		// 下面语句之前就要先创建javademo数据库
		String url = "jdbc:mysql://172.30.11.240:3306/customer?"
				+ "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";

		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动

			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			System.out.println("exists begin");
			Long begin = System.currentTimeMillis();
			for (int count = 0; count < 10; count++) {
				sql = "select * from customer.customer c WHERE status = 1 and not exists (	select * from customer.customer_label cl where c.id=cl.customer_id and cl.label_name = '连环') ";
				ResultSet result = stmt.executeQuery(sql);
				while (result.next()) {
					//System.out.println("customerId\t" + result.getLong(0));// 入如果返回的是int类型可以用getInt()
				}
			}
			System.out.println("exists end \t"+(System.currentTimeMillis() - begin));
			
			System.out.println("step begin");
			begin = System.currentTimeMillis();
			for (int count = 0; count < 10; count++) {
				sql = "select * from customer.customer where status=1";
				ResultSet result = stmt.executeQuery(sql);
				while (result.next()) {
					//System.out.println(i++);
					String sql2 = "select * from customer.customer_label cl where cl.label_name = '连环' and cl.customer_id="
							+ result.getString("id");
					stmt2.executeQuery(sql2);
					//System.out.println(result.isClosed());
				}
			}
			System.out.println("step end \t"+(System.currentTimeMillis() - begin));
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
}
