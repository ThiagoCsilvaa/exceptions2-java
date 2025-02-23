package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		
		Scanner w = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try { 
		    System.out.print("Room number: ");
			int number = w.nextInt();
			System.out.print("Check-in date (dd/MM/yyy): ");
			Date checkIn = sdf.parse(w.next());
			System.out.print("Check-out date (dd/MM/yyy): ");
		    Date checkOut = sdf.parse(w.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to updtate the reservation: ");
			System.out.print("Check-in date (dd/MM/yyy): ");
	        checkIn = sdf.parse(w.next());
			System.out.print("Check-out date (dd/MM/yyy): ");
		    checkOut = sdf.parse(w.next());
			 
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		 catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage()); 
		 } 
		 catch (RuntimeException e) {
			 System.out.println("Unexoected error");
		 }  
		
	}
		
	}




