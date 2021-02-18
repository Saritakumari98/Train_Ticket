package trainticket;



import java.util.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Ticket {

	private int counter=100;
	private String pnr;
	private LocalDate TravelDate;
	private Train train;
	private TreeMap Passengers;



	public Ticket(LocalDate travelDate, Train train) {

		TravelDate = travelDate;
		this.train = train;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	public String getPnr() {
		return pnr;
	}


	public void setPnr(String pnr) {
		this.pnr = pnr;
	}


	public LocalDate getTravelDate() {
		return TravelDate;
	}


	public void setTravelDate(LocalDate travelDate) {

		TravelDate = travelDate;


	}


	public Train getTrain() {
		return train;
	}


	public void setTrain(Train train) {
		this.train = train;
	}


	public  String generatePNR()
	{


		String S=String.valueOf(train.getSource().charAt(0));
		String D=String.valueOf(train.getDestination().charAt(0));;
		String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
		String pnr=S+D+"_"+date+"_"+counter++;

		if(TravelDate.isAfter(LocalDate.now()))
			return pnr;
		else
			return "Please Enter valid date";

	}

	double calPassengerFare(Passenger Passenger)
	{



		if(Passenger.getAge()<=12)
			return (50/100)*(train.getTicketprice());

		else if(Passenger.getAge()>=60)
			return (60/100)*(train.getTicketprice());

		else if(Passenger.getGender()=='F' )
			return (25/100)*(train.getTicketprice());

		else
			return train.getTicketprice();


	}

	public void addPassenger(String name,int age,char gender)
	{ 
		
      Passengers.put(new Passenger(name, age, gender),(int)calPassengerFare(new Passenger(name, age, gender)));
	}

	double calculateTotalTicketPrice()
	{
		return counter;

	}

	StringBuilder generateTicket()
	{
		return null;

	}

	public  void writeTicket()
	{

	}
}
