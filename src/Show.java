import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Show extends Program {

    void allHumansByName() throws SQLException {
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

    void citiesByNameAsc() throws SQLException {
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

    void countries() throws SQLException {
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

    void humanById(int id) throws SQLException {
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

    void citiesById(int id) throws SQLException {
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

    void countriesById(int id) throws SQLException {
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

    void sameCityHuman(String name) throws SQLException {
        String query = "select h.first_name, h.last_name, h.age, c.name from human h join city c " +
                "on h.city_id = c.idCity where c.name = ?";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "First name: " + rs.getString("first_name") + "\t |" +
                            "Last name: " + rs.getString("last_name") + "\t |" +
                            "Age: " + rs.getInt("age") + "\t |" +
                            "City: " + rs.getString("name") + "\t |"
            );
        }
        pstmt.close();
        rs.close();
    }

    void sameCountryCity(String name) throws SQLException {
        String query = "select ct.name as cityName, cn.name as countryName from country cn join city ct " +
                "on ct.country_id = cn.idCountry where cn.name = ?";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "City name: " + rs.getString("cityName") + "\t |" +
                            "Country name: " + rs.getString("countryName") + "\t |"
            );
        }
        pstmt.close();
        rs.close();
    }

    void humanLocation(String firstName, String lastName) throws SQLException {
        String query = ("select ct.name as cityName, cn.name as countryName, h.first_name, h.last_name, h.age " +
                "from human h inner join city ct on ct.idCity = h.city_id inner join country cn on cn.idCountry = ct.country_id " +
                "where h.first_name = ? and h.last_name = ?"
        );

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "First name: " + rs.getString("first_name") + "\t |" +
                            "Last name: " + rs.getString("last_name") + "\t |" +
                            "Age: " + rs.getInt("age") + "\t |" +
                            "City: " + rs.getString("cityName") + "\t |" +
                            "Country: " + rs.getString("countryName") + "\t |"
            );
        }
        pstmt.close();
        rs.close();
    }

    void search(String text) throws SQLException {
        String query = "select ct.name as cityName, cn.name as countryName, h.first_name, h.last_name, h.age " +
                "from human h inner join city ct on ct.idCity = h.city_id inner join country cn on cn.idCountry = ct.country_id " +
                "where h.first_name like ?";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + text + "%");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "First name: " + rs.getString("first_name") + "\t |" +
                            "Last name: " + rs.getString("last_name") + "\t |" +
                            "Age: " + rs.getInt("age") + "\t |" +
                            "City: " + rs.getString("cityName") + "\t |" +
                            "Country: " + rs.getString("countryName") + "\t |"
            );
        }
        pstmt.close();
        rs.close();

    }
}
