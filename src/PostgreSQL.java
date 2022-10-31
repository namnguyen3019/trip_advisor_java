import java.sql.*;
import java.util.*;

public class PostgreSQL implements DataStorage {
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
			

	@Override
	public User login(String username, String psw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(String username, String pws) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Attraction> searchByTag(String tag_name) {
		
		ArrayList<Attraction> attByTag = new ArrayList<Attraction>();
		
		try {
			 conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
	         st = conn.createStatement();
	         
	         String query = "SSELECT attraction_name, avg_rating\n"
	         		+ "FROM att_avg_rating\n"
	         		+ "WHERE attraction_name = ANY(\n"
	         		+ "SELECT attraction_name from attraction_tag\n"
	         		+ "	WHERE tag_name = '"+tag_name+"'\n"
	         		+ ")\n"
	         		+ "ORDER BY avg_rating DESC;";
	         
	         rs = st.executeQuery(query);
	         
	         while(rs.next()) {
	        	 String attraction_name = rs.getString("attraction_name");
	        	 Float avg_rating = rs.getFloat("avg_rating"); 	 
	        	 Attraction att = new Attraction(attraction_name);
	        	 attByTag.add(att);
	        	 
	         }
	         
	         return attByTag;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			
		}
		return null;
	}
	
	

}
