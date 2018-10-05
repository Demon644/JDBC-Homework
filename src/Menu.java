
public class Menu {
	
	public void addMenu() {
		System.out.println("1 - Add country\n"
				+ "2 - Add city\n"
				+ "3 - Add human\n"
				+ "0 - Back");
	}
	
	public void showAllMenu() {
		System.out.println("1 - Show humans in the database(by name)\n"
				+ "2 - Show cities in the database(by name , from end to beginning\n"
				+ "3 - Show countries in the database\n"
				+ "0 - Back");
	}
	
	public void showOneMenu() {
		System.out.println("1 - Show info about human by id\n"
				+ "2 - Show info about city by id\n"
				+ "3 - Show info about country by id");
	}
	
	public void showSortingMenu() {
		System.out.println("1 - Show info about humans from the same city\n"
				+ "2 - Show info about cities with the same country\n"
				+ "3 - Show info about human(which city and country)");
	}
	
	public void mainMenu() {
		System.out.println("1 - Add\n"
				+ "2 - Show all\n"
				+ "3 - Show one\n"
				+ "4 - Show sorting menu\n"
				+ "5 - Find human by name\n"
				+ "6 - Fill the table with random stuff\n"
				+ "7 - Update info about human by id\n"
				+ "0 - Exit");
	}
	
}
