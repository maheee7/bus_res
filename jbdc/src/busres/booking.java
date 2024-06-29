package busres;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class booking {
	
     String passengerName;
     int busNo;
     Date date;
     
     
     Scanner scanner= new Scanner(System.in);
     booking(){
    	 System.out.println("Enter your Name");
    	 passengerName = scanner.next();
    	 System.out.println("Enter the busno");
    	 busNo = scanner.nextInt();
    	 System.out.println("Enter the date of booking in date-mm-yyyy");
    	 String dateInput = scanner.next();
    	 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
    	 
    	 try {
			date = dataFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }


     public boolean isAvailable()  throws SQLException{
 		
 		BusDao busdao = new BusDao();
 		BookingDao bookingdao = new BookingDao();
 		int capacity = busdao.getCapacity(busNo);

 		int booked = bookingdao.getBookedCount(busNo,date);
 		
 		return booked<capacity;
 		
 	}
}
