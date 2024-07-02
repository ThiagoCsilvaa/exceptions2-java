package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner w = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = w.nextInt();
		System.out.print("Check-in date (dd/MM/yyy): ");
		Date checkIn = sdf.parse(w.next());
		System.out.print("Check-out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(w.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Eror in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			
			System.out.println("Enter data to updtate the reservation: ");
			System.out.print("Check-in date (dd/MM/yyy): ");
            checkIn = sdf.parse(w.next());
			System.out.print("Check-out date (dd/MM/yyy): ");
		    checkOut = sdf.parse(w.next());
		    
		    
		    Date now = new Date();
		    if(checkIn.before(now) || checkOut.before(now)) {
		    	System.out.println("Error in reservation: Reservation dates for updates must be future dates");
		    }
		    else if (!checkOut.after(checkIn)) {
					System.out.println("Eror in reservation: Check-out date must be after check-in date");
		    	
		    }
		    else {
		    reservation.updateDates(checkIn, checkOut, now);
		    System.out.println("Reservation: " + reservation);
		    
		}
		
	}


}
}

