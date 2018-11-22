import java.sql.*;

public class DockerConnectMySQL {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://db:3306/usersdb";

	static final String USER = "admin";
	static final String PASS = "admin123";
	
	String sql = null;

	private Connection conn = null;

	private Statement stmt = null;

	public Statement getStatement(){

		try{
			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected database successfully...");

			stmt = conn.createStatement();

		}catch(Exception e){
			e.printStackTrace();
		}

		return stmt;
	}

	public void createTable(){

		

		try{

			getStatement();
			
			sql = "CREATE TABLE USERS (uname VARCHAR(30) not NULL, firstname VARCHAR(255), lastname VARCHAR(255), password VARCHAR(8), PRIMARY KEY ( uname ))"; 

			System.out.println("Creating table in given database...");
			stmt.executeUpdate(sql);
			System.out.println("Table Created successfully");

			System.out.println("Inserting records into the table...");

			sql = "INSERT INTO USERS VALUES ('admin', 'admin', 'admin', 'admin123')";
			stmt.executeUpdate(sql);
			System.out.println("Admin details inserted into table.");

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se){
				se.printStackTrace();
			}

			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}

	public void insertRecords(String uname, String firstname, String lastname, String password){

		try{

			getStatement();

			System.out.println("Inserting records into the table...");

			sql = "INSERT INTO USERS VALUES ('"+uname+"','"+firstname+"','"+lastname+"','"+password+"')";
			int result = stmt.executeUpdate(sql);
			System.out.println(result+" User details inserted into table.");

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se){
				se.printStackTrace();
			}

			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}

	public String getUser(String uname,String password){

		String userDetails = null;

		try{

			getStatement();

			sql = "SELECT uname, firstname, lastname, password FROM USERS WHERE uname='"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs == null){
				userDetails = "nouser";
			}else{
				while(rs.next()){
					userDetails = rs.getString("uname")+":"+rs.getString("firstname")+":"+rs.getString("lastname")+":"+rs.getString("password");
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se){
				se.printStackTrace();
			}

			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	return userDetails;
	}
}