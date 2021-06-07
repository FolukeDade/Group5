package lottery;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseAdmin {
	
	   static final String DB_URL = "jdbc:sqlite:C:\\LotteryApp\\database\\LotteryDB.db";
	   // trusted_Connection=True;";
       // static final String USER = "guest";
       // static final String PASS = "guest123";
	
	   
	// Retrive Info from Database
	private static void displayInfo(String title, ResultSet rs) throws SQLException {
	        System.out.println(title);
	        while (rs.next()) {
	           // System.out.println(rs.getString("ProductNumber") + " : " + rs.getString("Name"));
	            System.out.println(rs.getString("lottoDate") + " : " + rs.getString("participant") + " : " + rs.getString("prize") );
	        }
	}
	
	
	public static boolean ConnectDB(String url) {
        Connection conn = null;
        boolean test = true;
        
        try {
            //String url = "jdbc:sqlite:C:/LotteryApp/Database/lotteryDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            test = true;
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            test = false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return test;
    }
	
	        
	public static boolean sqlSelect(String lottoDate) {
		boolean status = true;
	
		
		// Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL); // (DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         
	    	  PreparedStatement sqlQry = conn.prepareStatement("SELECT * FROM RaffleHist where lottoDate = ? ");
	    	  sqlQry.setString(1, lottoDate);
	    	  
	    	  // Execute a query
	    	  ResultSet rs = sqlQry.executeQuery() ;
	    	  
//	    	  while (rs.next()) {
//	                System.out.println(rs.getInt("id") +  "\t" + 
//	                                   rs.getString("participant") + "\t" +
//	                                   rs.getString("prize") + "\t" +
//	                                   rs.getString("lottodate") + "\t" );
//	            }
	          displayInfo("List of Winners on: " + lottoDate + "", rs);
	    	  
	      } catch (SQLException e) {
	    	 status = false;
	         e.printStackTrace();
	      } 
		
		return status;

	}

	
	public static boolean sqlSelect() {
		boolean status = true;
		
		// Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL); // (DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         
	    	  PreparedStatement sqlQry = conn.prepareStatement("SELECT * FROM RaffleHist order by lottoDate, participant");
	    	  
	    	  // Execute a query
	    	  ResultSet rs = sqlQry.executeQuery() ;
	          displayInfo("Winners", rs);
	    	  
	      } catch (SQLException e) {
	    	 status = false;
	         e.printStackTrace();
	      } 
		
		return status;

	}

	
	public static boolean sqlInsert(String participant, String prize ) {
	    boolean status = true;
       
        String strDate =  new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime() );

		// Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL); ) { // (DB_URL, USER, PASS);
   	      
   	           String sql = "INSERT INTO RaffleHist(participant, prize, lottodate) VALUES(?,?,?)";

                PreparedStatement pstmt = conn.prepareStatement(sql) ;
	            pstmt.setString(1, participant);
	            pstmt.setString(2, prize);
	            pstmt.setString(3, strDate);
	            pstmt.executeUpdate();
	      } catch (SQLException e) {
	    	 status = false;
	         e.printStackTrace();
	      } 
	      
		return status;
	
	}
	
}