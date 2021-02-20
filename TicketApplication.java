package trainticket;

import java.io.*;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;


public class TicketApplication {



	public static void main(String[] args) throws IOException, NullPointerException{


		/*=============== Creating the object of Scanner class ================= */
		Scanner sc=new Scanner(System.in);



		System.out.println("======Welcome To Ticket Reservation=========");



		/*=============== Creating the object of TrainDAO class ================= */
		TrainDAO traindao=new TrainDAO();



		/*=============== Formatting the Date Pattern ================= */
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");




		/*=============== Taking user input of train number ================= */
		System.out.println("Enter the train Number");
		Train train =traindao.findTrain(sc.nextInt());



		/*=============== Taking user input of Travel Date ================= */
		System.out.println("Enter TravelDate");
		String date=sc.next();



		LocalDate travelDate=LocalDate.parse(date,df);


		/*=============== Creating the object of Ticket class ================= */
		Ticket ticket=new Ticket(travelDate,train);


		/*=============== setting the value  of Counter variable and getting the value in count variable ================= */
		ticket.setCounter(100);
		int count=ticket.getCounter();



		/*=============== Taking user input of Number of Passengers ================= */
		System.out.println("Enter Number of Passengers");
		int numberOfPassengers=sc.nextInt();




		sc.nextLine();
		/*=============== Taking user input for Passengers Details ================= */
		for(int i=1;i<=numberOfPassengers;i++)
		{
			System.out.println("Enter Passenger Name");
			String name=sc.next();
			sc.nextLine();

			System.out.println("Enter Age");
			int age=sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Gender(M/F)");
			String gender=sc.next();
			char g=gender.charAt(0);


			ticket.addPassenger(name, age, g);//adding the Passenger
			count++;



		}


		System.out.print("Ticket Booked with PNR:"+ticket.generatePNR());//printing the PNR

		ticket.writeTicket();//This method write the ticket details in a file

		System.out.println();
		System.out.println("Ticket should be written to the file with filename :"+ ticket.generatePNR());     




	}

}
