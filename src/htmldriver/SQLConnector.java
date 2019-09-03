package htmldriver;
import  java.sql.Connection;		
import  java.sql.Statement;
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;	

public class SQLConnector {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Connect to database
		String dbUrl = "jdbc:mysql://localhost:3306/emp";
		
		//Database username
		String username = "root";
		
		//Database password
		String password = "champion";
		
		//Query to Execute
		String query = "select * from employee;";
		
		//Load mySQL jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		
		//Create Statement Object
		Statement stmtStatement = con.createStatement();
		
		//Execute the SQL Query. Store result in Result Set
		ResultSet rSet = stmtStatement.executeQuery(query);
		
		//While Loop to iterrage through all data and print results
		while (rSet.next()) {
			String myName = rSet.getString(1);
			String myAge = rSet.getString(2);
			System.out.println(myName + "  " + myAge);
			System.out.println("----------------");
		}
		
		//closing DB connection
		con.close();



	}

}
