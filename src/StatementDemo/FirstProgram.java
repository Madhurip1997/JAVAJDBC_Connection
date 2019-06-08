package StatementDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstProgram {
	public static void main(String[] args) {
		Connection con=null;
		
		try {
			con=DBConnection.getConnection();
			Statement st=con.createStatement();
			String query="select * from student";
			 ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
		} 
		catch (SQLException e)
		{
		
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
