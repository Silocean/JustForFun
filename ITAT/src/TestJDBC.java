import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestJDBC {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//一种方法，不用配置ODBC数据源，直接连
			//conn = DriverManager.getConnection("jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:/employee.accdb","","");
			//另一种方法，配置数据源，使用JDBC_ODBC访问
			conn = DriverManager.getConnection("jdbc:odbc:student","","");
			//pst = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
			st = conn.createStatement();
			String sql = "select * from T_Student order by S_ID";
			rs = st.executeQuery(sql);
			while(rs.next()) { 
				System.out.println(rs.getString("S_ID") + "\t" + rs.getString("S_Name") + "\t" + rs.getString("S_Email") + "\t" + rs.getString("S_Score"));
			}
//			pst.setInt(1, 1001);
//			pst.setString(2, "Jerry");
//			pst.setString(3, "Jerry@126.com");
//			pst.setInt(4, 2500);
//			pst.setDate(5, new Date(82, 7, 27));
//			pst.executeUpdate();
//			pst.setInt(1, 1002);
//			pst.setString(2, "John");
//			pst.setString(3, "John@126.com");
//			pst.setInt(4, 3800);
//			pst.setDate(5, new Date(80, 2, 19));
//			pst.executeUpdate();
//			pst.setInt(1, 1003);
//			pst.setString(2, "Mike");
//			pst.setString(3, "Mike@126.com");
//			pst.setInt(4, 3000);
//			pst.setDate(5, new Date(78, 0, 28));
//			pst.executeUpdate();
//			String sql = "select * from employee order by employee_id desc";
//			rs = st.executeQuery(sql);
//			while(rs.next()) {
//				System.out.println(rs.getInt("employee_id") + "\t" + rs.getString("name") + "\t" + rs.getString("email") + "\t" + rs.getInt("salary") + "\t" +rs.getDate("birthday"));
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
