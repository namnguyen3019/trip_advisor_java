import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class User {
	
	private String username;
	private String password;
	private boolean isAdmin = false;
	
	private String tag;
	

	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public ArrayList<Attraction> searchByTag(String tag_name){
		
		// 
		return AppMain.d.searchByTag(tag_name);
		
	
		
		
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
