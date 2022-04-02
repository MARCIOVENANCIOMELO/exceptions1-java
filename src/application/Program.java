package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	System.out.print("Entre com numero do quarto: ");
	int number = sc.nextInt();
	System.out.print("checkin date (dd/mm/aaaa) ");
	Date checkIn = sdf.parse(sc.next());
	System.out.print("checkOut date (dd/mm/aaaa) ");
	Date checkOut = sdf.parse(sc.next());
	
	if (!checkOut.after(checkIn)) {
		System.out.println("Erro data de checkOut precisa ser maior que checkIn");
	}
	else {
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reserva: " + reservation);
		System.out.println();
		System.out.print("checkin date (dd/mm/aaaa) ");
		checkIn = sdf.parse(sc.next());
		System.out.print("checkOut date (dd/mm/aaaa) ");
		checkOut = sdf.parse(sc.next());	
	
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("reserva de update deve ser fututo");
		}
		else if (!checkOut.after(checkIn)) {
			System.out.println("Erro data de checkOut precisa ser maior que checkIn");
		}
		else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
		}
		sc.close();
		
	}
}
}	

	