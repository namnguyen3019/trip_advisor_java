import java.util.Scanner;

public class AppMain {
	
	static DataStorage d = new PostgreSQL();
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String selection = "";
		
		while(!selection.equals("x")) {
			System.out.println("What do you want to do today? ");
			System.out.println("1. Register ");
			System.out.println("2. Login ");
			System.out.println("x. Exit ");
			
			selection = sc.nextLine();
			if(selection.equals("1")) {
				 // register();
			} else if (selection.equals("2")) {				
				User curUser = login();
				
				if(curUser != null) {
					UserScreen userScreen = new UserScreen(curUser);
					userScreen.showMenu();
					
					
				}
				
	
			}
		}

	}


	
	public static void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an username");
		String username = sc.nextLine();
		System.out.println("Enter an password");
		String pwd = sc.nextLine();
		
		// go to database and create a new user account
		d.register(username, pwd);
	}
	
	public static User login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an username");
		String username = sc.nextLine();
		System.out.println("Enter an password");
		String pwd = sc.nextLine();
		return d.login(username, pwd);
		
	}
}
