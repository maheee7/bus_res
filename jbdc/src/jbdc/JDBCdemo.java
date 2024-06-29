package jbdc;
import java.sql.*;

public class JDBCdemo {

	public static void main(String[] args) throws Exception {
	
		sp3();
		
	}
	
	
	public static void readRecords()throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String userName ="root";
		String password = "Mahe@123";
		String query = "select * from employee";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		
		while(rs.next()) 
		{
		System.out.println("id is "+rs.getInt(1));
		System.out.println("name is "+rs.getString(2));
		System.out.println("sal is "+rs.getInt(3));
		}
		con.close();	

	
	}
	
	public static void insertRecords()throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String userName ="root";
		String password = "Mahe@123";
		String query = "insert into employee values (6,'srider',24000)";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		 int rows =  st.executeUpdate(query);
		
		System.out.println("rows affected "+rows);
		con.close();	

	}
	//insert with variables
		public static void insertVar() throws Exception{
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			String userName = "root";
			String passWord = "Mahe@123";
			
			int id=7;
			String name = "Varun";
			int salary = 300000;
			
			// "insert into employee values(5,'varun',300000);"
			String query = "insert into employee values (" + id + ",'" + name + "'," + salary + ");";

			
			Connection con = DriverManager.getConnection(url,userName,passWord);
			Statement st = con.createStatement();
			int rows = st.executeUpdate(query);
			
			System.out.println("Number of rows affected: " + rows);		
			con.close();
		}
		//insert with prepared statement
		public static void insertUsingPst() throws Exception{
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			String userName = "root";
			String passWord = "Mahe@123";
			
			int id=8;
			String name = "Nila";
			int salary = 310000;
			
			// "insert into employee values(5,'varun',300000);"
			String query = "insert into employee values (?,?,?);";

			
			Connection con = DriverManager.getConnection(url,userName,passWord);
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, salary);
			int rows = pst.executeUpdate();
			
			System.out.println("Number of rows affected: " + rows);	
			con.close();
			
		}
		
		//delete
		public static void delete() throws Exception{
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			String userName = "root";
			String passWord = "Mahe@123";
			
			int id=5;

			String query = "delete from employee where emp_id = " + id;

			
			Connection con = DriverManager.getConnection(url,userName,passWord);
			Statement st = con.createStatement();
			int rows = st.executeUpdate(query);
			
			System.out.println("Number of rows affected: " + rows);		
			con.close();
		}
		
		//update
		public static void update() throws Exception{
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			String userName = "root";
			String passWord = "Mahe@123";
			

			String query = "update employee set salary = 150000 where emp_id=1";

			
			Connection con = DriverManager.getConnection(url,userName,passWord);
			Statement st = con.createStatement();
			int rows = st.executeUpdate(query);
			
			System.out.println("Number of rows affected: " + rows);		
			con.close();
		}
		//Types of statement
		//normal statement
		//prepared statement
		//callable statement call GetEmp()
		
		//calling simple stored procedure
		public static void sp() throws Exception{
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			String userName = "root";
			String passWord = "Mahe@123";

			Connection con = DriverManager.getConnection(url,userName,passWord);
			CallableStatement cst = con.prepareCall("{call getemp()}");
			ResultSet rs = cst.executeQuery();
			
			while(rs.next()) {
				System.out.println("Id is " + rs.getInt(1));
				System.out.println("Name is " + rs.getString(2));
				System.out.println("Salary is " + rs.getInt(3));
			}
			
			con.close();
		}
		
		public static void sp2() throws Exception{
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			String userName = "root";
			String passWord = "Mahe@123";
            int id  = 4;
            
			Connection con = DriverManager.getConnection(url,userName,passWord);
			CallableStatement cst = con.prepareCall("{call getempbyid(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			
			while(rs.next()) {
				System.out.println("Id is " + rs.getInt(1));
				System.out.println("Name is " + rs.getString(2));
				System.out.println("Salary is " + rs.getInt(3));
			}
			
			con.close();
		}
		
		
		public static void sp3() throws Exception{
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			String userName = "root";
			String passWord = "Mahe@123";
			int id = 6;
			Connection con = DriverManager.getConnection(url,userName,passWord);
			CallableStatement cst = con.prepareCall("{call getnamebyId(?,?)}");
			cst.setInt(1, id);
			cst.registerOutParameter(2, Types.VARCHAR);
			
			cst.executeUpdate();
			
			System.out.println(cst.getString(2));
			
			con.close();
		}
}

