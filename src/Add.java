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

    public void addCity(String name, int id) throws SQLException {
        String query = "insert into city("
                + "name, "
                + "country_id)"
                + " values (?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void addHuman(String first_name, String last_name, int age, int id) throws SQLException {
        String query = "insert into human("
                + "first_name,"
                + "last_name,"
                + "age,"
                + "city_id)"
                + " values (?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, first_name);
        pstmt.setString(2, last_name);
        pstmt.setInt(3, age);
        pstmt.setInt(4, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    void fillRandom(){

    }
}
