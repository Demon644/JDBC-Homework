import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Show extends Program {

    public void allHumansByName() throws SQLException {
        String query = "select first_name,last_name,age from human order by first_name asc";

        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
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

        while (rs.next()) {
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

        while (rs.next()) {
            System.out.println(
                    "Name: " + rs.getString("name") + "\t |"
            );
        }
        pstmt.close();
        rs.close();
    }

    public void humanById(int id) throws SQLException {
        String query = "select * from human where idHuman = ?";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "First name: " + rs.getString("first_name") + "\t |" +
                            "Last name: " + rs.getString("last_name") + "\t |" +
                            "Age: " + rs.getInt("age") + "\t |"
            );
        }
        pstmt.close();
        rs.close();
    }

    public void citiesById(int id) throws SQLException {
        String query = "select * from city where idCity = ?";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "Name: " + rs.getString("name") + "\t |"
            );
        }
        pstmt.close();
        rs.close();
    }

    public void countriesById(int id) throws SQLException {
        String query = "select * from country where idCountry = ?";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "Name: " + rs.getString("name") + "\t |"
            );
        }
        pstmt.close();
        rs.close();
    }
}
