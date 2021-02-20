package trainticket;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class TicketApplication {

	public static LocalDate dateInput(String userInput)
	{
		DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date=LocalDate.parse(userInput, dateFormat);
		return date;

	}

	public static void main(String[] args) throws IOException, NullPointerException{
		Scanner sc=new Scanner(System.in);
		
		

		System.out.println("======Welcome To Train Reservation=========");

		
        TrainDAO traindao=new TrainDAO();
        System.out.println("Enter the train Number");
		Train train =traindao.findTrain(sc.nextInt());
		
		
		
		System.out.println("Enter TravelDate");
		String userInput=sc.next();
		
		LocalDate travelDate=dateInput(userInput);
		Ticket ticket=new Ticket(travelDate,train);
		
		System.out.println("Enter Number of Passengers");
		int numberOfPassengers=sc.nextInt();
		
        sc.nextLine();
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
           
			
			ticket.addPassenger(name, age, g);
			
			

		}
		

		System.out.print("Ticket Booked with PNR:"+ticket.generatePNR());
		ticket.writeTicket();
		
		//System.out.println("Ticket should be written to the file with filename :"+ ticket.generatePNR());     
		



	}

}
