import java.util.*;

public interface DataStorage {
	
	public User login(String username, String psw);
	public boolean register(String username, String psw);
	public ArrayList<Attraction> searchByTag(String tag_name);

}
