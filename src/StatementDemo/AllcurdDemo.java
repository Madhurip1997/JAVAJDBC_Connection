package StatementDemo;

import java.sql.Connection;
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
			String query="insert into employee_Java values("+empno+",'"+name+"',"+salary+",'"+city+"')";
			Statement st=con.createStatement();
			int r;
			r = st.executeUpdate(query);
			if(r==1)
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
		 Statement st=con.createStatement();
		 
		 String query="update employee_Java set salary="+salary+" where empno="+empno;
	     System.out.println(query);
	     
	     int r=st.executeUpdate(query);
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
		Statement st=con.createStatement();
		String query="delete from employee_Java where Empno="+empno;
		
		int r=st.executeUpdate(query);
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
		Statement st = con.createStatement();;
	
			
			
			String query="select * from employee_Java";
			ResultSet rs=st.executeQuery(query);
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
