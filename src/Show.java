import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Show extends Program {
	
	public void humansByName() throws SQLException {
		String query = "select first_name,last_name,age from human order by first_name asc";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		while(rs.next()) {
			System.out.println(
					"First name: " + rs.getString("first_name") + "\t |" +
					"Last name: " + rs.getString("last_name") + "\t |" + 
					"Age: " + rs.getInt("age") + "\t |"
					);
		}
		pstmt.close();
		rs.close();
	}
	
	public void citiesByNameAsc() throws SQLException {
		String query = "select name from city order by name desc";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					"Name: " + rs.getString("name") + "\t |"
					);
		}
		pstmt.close();
		rs.close();
		
	}
	
	public void countries() throws SQLException {
		String query = "select name from country";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					"Name: " + rs.getString("name") + "\t |"
					);
		}
		pstmt.close();
		rs.close();
	}
	
}
