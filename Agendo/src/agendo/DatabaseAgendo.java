package agendo;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;  


public class DatabaseAgendo {

	
	public Connection connect() {
		String url = "jdbc:sqlite:src/agendodb.db";  
		Connection conn = null;
        // create a connection to the database  
        try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection to SQLite has been established.");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
        return conn;
	}
	
	public void insertNewAccount(String username, String email, String password, String status) {
		String sql = "INSERT INTO account(username, email, password, status) VALUES(?,?,?,?)";  
		   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, username);  
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, status);
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
	}
	
	
	public ArrayList<Account> selectAllAccount() {
		String sql = "SELECT * FROM account";  
		ArrayList<Account> accountList = new ArrayList<Account>();         
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            // loop through the result set  
            while (rs.next()) {  
            	if(rs.getString("status")=="ADMIN") {
            		AdminAccount ac = new AdminAccount(rs.getString("username"),rs.getString("email"),rs.getString("password"));
            		accountList.add(ac);
            	}else {
            		UserAccount uc = new UserAccount(rs.getString("username"),rs.getString("email"),rs.getString("password"));
            		accountList.add(uc);
            	}
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            System.out.println("ilang");
        }
		return accountList;  
	}
}
