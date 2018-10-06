import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add extends Program {
    public void addCountry(String name) throws SQLException {
        String query = "insert into country("
                + "name)"
                + " values (?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void addCity(String name) throws SQLException {
        String query = "insert into city("
                + "name)"
                + " values (?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void addHuman(String first_name, String last_name, int age) throws SQLException {
        String query = "insert into human("
                + "first_name,"
                + "last_name,"
                + "age)"
                + " values (?,?,?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, first_name);
        pstmt.setString(2, last_name);
        pstmt.setInt(3, age);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
