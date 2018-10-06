import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Program {
    static Menu menu = new Menu();
    static Add add = new Add();
    static Show show = new Show();
    static Connection conn;
    static Scanner sc = new Scanner(System.in);
    private static int running = 1;
    private static int choise;

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/homework?serverTimezone=UTC";
        String username = "root";
        String password = "";

        conn = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("Connection status = " + !conn.isClosed());
        createTables();
        menu.mainMenu();
        while (running == 1) {
            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    while (choise != 0) {
                        menu.addMenu();
                        choise = sc.nextInt();
                        switch (choise) {
                            case 1:
                                System.out.println("Enter name: ");
                                add.addCountry(sc.next());
                                System.out.println("1");
                                break;
                            case 2:
                                System.out.println("Enter name: ");
                                add.addCity(sc.next());
                                System.out.println("2");
                                break;
                            case 3:
                                System.out.println("Enter firts name, last name, age");
                                add.addHuman(sc.next(), sc.next(), sc.nextInt());
                                System.out.println("3");
                                break;
                            case 0:
                                menu.mainMenu();
                                break;
                        }
                    }
                    break;
                case 2:
                    while (choise != 0) {
                        menu.showAllMenu();
                        choise = sc.nextInt();
                        switch (choise) {
                            case 1:
                                show.allHumansByName();
                                break;
                            case 2:
                                show.citiesByNameAsc();
                                break;
                            case 3:
                                show.countries();
                                break;
                            case 0:
                                menu.mainMenu();
                                break;
                        }
                    }

                    break;
                case 3:
                    while (choise != 0) {
                        menu.showOneMenu();
                        choise = sc.nextInt();
                        switch (choise) {
                            case 1:
                                System.out.println("Input the id of a human");
                                show.humanById(sc.nextInt());
                                break;
                            case 2:
                                System.out.println("Input the id of a city");
                                show.citiesById(sc.nextInt());
                                break;
                            case 3:
                                System.out.println("Input the id of a country");
                                show.countriesById(sc.nextInt());
                                break;
                            case 0:
                                menu.mainMenu();
                                break;
                        }
                    }
                    break;
                case 4:
                    //TODO
                    break;
                case 5:
                    //TODO
                    break;
                case 6:
                    //TODO
                    break;
                case 7:
                    //TODO
                    break;
                case 0:
                    running = 0;
                    break;
            }
        }
    }

    public static void createTables() throws SQLException {
        String query = "create table if not exists human("
                + "idHuman int primary key not null auto_increment,"
                + "first_name varchar(100) not null,"
                + "last_name varchar(100) not null,"
                + "age int not null,"
                + "city_id int"
                + ");";
        String query2 = "create table if not exists city("
                + "idCity int primary key not null auto_increment,"
                + "name varchar(100) not null,"
                + "country_id int"
                + ");";
        String query3 = "create table if not exists country("
                + "idCountry int primary key not null auto_increment,"
                + "name varchar(100) not null"
                + ");";
        String query4 = "alter table human add foreign key (city_id) references city(idCity);";
        String query5 = "alter table city add foreign key (country_id) references country(idCountry);";
        Statement stmt = conn.createStatement();
        stmt.execute(query);
        stmt.execute(query2);
        stmt.execute(query3);
        stmt.execute(query4);
        stmt.execute(query5);
        System.out.println("Tables have been crated");
        stmt.close();

    }


}
