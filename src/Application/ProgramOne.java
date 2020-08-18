package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class ProgramOne {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check in date (dd/mm/yyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check out date (dd/mm/yyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check in date (dd/mm/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check out date (dd/mm/yyy): ");
		    checkOut = sdf.parse(sc.next());
		    
		    reservation.updateDates(checkIn, checkOut);
		
		    System.out.println("Reservation: " + reservation);
	
			sc.close();
		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeErrorException e) {
			System.out.println("Unexpected error");
		}
	}
}
