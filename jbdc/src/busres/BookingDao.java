package busres;

import java.util.Date;
import java.sql.*;
public class BookingDao {
       
	public int getBookedCount(int busNo,Date date) throws SQLException
	{

		String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con = Dbconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public void addBooking(booking Bookings) throws SQLException
	{
		String query = "Insert into booking values(?,?,?)";
		Connection con = Dbconnection.getConnection();
		java.sql.Date sqldate = new java.sql.Date(Bookings.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, Bookings.passengerName);
		pst.setInt(2, Bookings.busNo);
		pst.setDate(3, sqldate);

		pst.executeUpdate();
	}

	
	
}
