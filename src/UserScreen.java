import java.util.*;

public class UserScreen {
	
	private User user;
	
	public UserScreen(User user) {
		this.user = user;
	}
	
	public void showAdminScreen() {
		// 
		
	}
	
	public void showUserScreen() {}
	public void showNotification() {
		// ArrayList<Answer> listOfAnswer = user.getNotification();
		
	}
	public void showMenu() {
		if(user.getIsAdmin() == true) { 
			showAdminScreen() ;}
		else { 
			showNotification();
			showUserScreen();
		}
		
		
		
		Scanner sc = new Scanner(System.in);
		String selection = "";

		while (!selection.equalsIgnoreCase("x")) {
			System.out.println("What do you want to do today? ");
			System.out.println("1. Search an attraction by tag");
			//System.out.println("2. Search an attraction by city");
			System.out.println("3. Create an attraction");
			System.out.println("4. Post a review ");
			System.out.println("5. Give a score");
			System.out.println("x. return");

			selection = sc.nextLine();
			if (selection.equals("1")) {
				System.out.println("Enter a tag");
				String tag_name = sc.nextLine();
				ArrayList<Attraction> attByTag= user.searchByTag(tag_name);
				showAttByTag(attByTag);
				
			} else if (selection.equals("3")) {
				
			}
		}
		sc.close();
		
	}
	
	public void showAttByTag(ArrayList<Attraction> attByTag) {
		
		
		// print it out
		// 1 - > taka a attraction_name
		Attraction att1 = attByTag.get(0);
		new AttractionScreen(this.user, att1).showMenu();
		
	}

}
