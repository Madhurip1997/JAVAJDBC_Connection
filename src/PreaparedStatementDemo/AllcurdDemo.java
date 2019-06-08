package PreaparedStatementDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AllcurdDemo {
	public static void InsertDemo() {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter employee no");
		int empno=sc.nextInt();
		
		System.out.println("enter the name");
		String name=sc.next();
		
		System.out.println("enter theemployee salary");
		int salary=sc.nextInt();
		
		System.out.println("enter the city");
		String city=sc.next();
		
		Connection con=null;
		
		
		try {
			con=DBConnection.getConnection();
			String query="insert into employee_Java values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,empno);
			pst.setString(2,name);
			pst.setInt(3,salary);
			pst.setString(4,city);
			
			int res = pst.executeUpdate();
			if(res==1)
				System.out.println("record inserted");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		finally {
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		
	}
	public static void UpdateDemo() {
	Scanner sc = new Scanner (System.in) ;
		System.out.println("enter employee no");
		int empno=sc.nextInt();
		
		System.out.println("enter salary");
		int salary=sc.nextInt();
		
		
		 Connection con=null;
			try {	 
		 con=DBConnection.getConnection();
		 
		 String query="update employee_Java set salary=? where empno=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(2,"Mumabi");
		pst.setInt(1,2000);
	    
	     
	     int r=pst.executeUpdate();
	     System.out.println(r+"Record update");
	     
	     
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	
	public static void DeleteDemo() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee number:");
		int empno=sc.nextInt();
		
		Connection con=null;
		try {
		con=DBConnection.getConnection();
		String query="delete from employee_Java where Empno=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,51);
	
		
		int r=pst.executeUpdate();
		System.out.println(r+"Delete Record");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public static void show()
	{
		Connection con=null;
		
		try {
		con=DBConnection.getConnection();
	
		String query="select * from employee_Java";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
			
			ResultSetMetaData rsm=rs.getMetaData();
			int column=rsm.getColumnCount();
			while(rs.next()) {
				for(int i=1;i<=column;i++) {
					System.out.println(rs.getString(i)+" ");
					}
				System.out.println();
			}
		
		} catch (SQLException e) {
		
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
	public static void main(String[] args)
	{
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("------Menu-----");
			System.out.println("1.Insert Record");
			System.out.println("2.Update Record");
			System.out.println("3.Delete Record");
		    System.out.println("4.show all record");
		    System.out.println("5.exit");
		    System.out.println("--------------");
		    System.out.println("enter choice:");
		    int ch=sc.nextInt();
		    switch(ch)
		    {
		    case 1:InsertDemo();
		       break;
		    case 2:UpdateDemo();
		       break;
		    case 3:DeleteDemo();
		      break;
		    case 4:show();
		      break;
		    case 5:
		    	System.exit(0);
		    
		    
		    
		    }
		    
		}
//		InsertDemo();
//		UpdateDemo();
//		DeleteDemo();
//		show();
	}
	

}
