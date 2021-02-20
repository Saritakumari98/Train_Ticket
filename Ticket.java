package trainticket;



import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ticket {

	private int counter=100;
	private String pnr;
	private LocalDate TravelDate;
	private Train train;
        private TreeMap <Passenger,Double>Passengers=new TreeMap();



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
		
		

		String source=String.valueOf(train.getSource().charAt(0));
		String destination=String.valueOf(train.getDestination().charAt(0));
		String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
		 pnr= source+destination+"_"+date+"_"+counter;
                 this.counter++;
        // System.out.println(" pnr "+pnr);
		if(TravelDate.isAfter(LocalDate.now()))
			return pnr;
		else
			return "Please Enter valid date";
		/*
		String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
		
		StringBuilder sb=new StringBuilder();
		System.out.println("train  "+train.getSource().charAt(0));
		sb.append(train.getSource().charAt(0));
		System.out.println("Source  "+sb);
		sb.append(train.getDestination().charAt(0));
		sb.append(date);
		
		System.out.println(sb);
		
		return sb.toString();*/

	}

	double calPassengerFare(Passenger Passenger)
	{



		if(Passenger.getAge()<=12)
			return (0.5)*(train.getTicketprice());

		else if(Passenger.getAge()>=60)
			return (0.6)*(train.getTicketprice());

		else if(Passenger.getGender()=='F' )
			return (0.25)*(train.getTicketprice());

		else
			return train.getTicketprice();


	}
	//Passengers=new TreeMap();
	public void addPassenger(String name,int age,char gender)
	{ 
		
		Double fare= calPassengerFare(new Passenger(name, age, gender));
		//System.out.println(fare);
		Passengers.put(new Passenger(name, age, gender),fare);
	}

	double calculateTotalTicketPrice()
	{
		Double totalPrice=0.0;
		//Collection<Double> price=Passengers.values();
		
		for(Double values:Passengers.values())
		{
			totalPrice=totalPrice+values;
			//System.out.println(totalPrice);
		}
		
		//System.out.println(totalPrice);
		return totalPrice;

	}

	StringBuilder generateTicket()
	{
		Collection<Passenger> entrySet=Passengers.keySet();
		StringBuilder sb=new StringBuilder();
		
		sb.append("PNR   :"+generatePNR()).append("\n")
		.append("TrainNo :"+train.getTrainNo()).append("\n")
		.append("Train Name :"+train.getTrainName()).append("\n")
		.append("from :"+train.getSource()).append("\n")
		.append("to :"+train.getDestination()).append("\n")
		.append("travelDate :"+TravelDate).append("\n")
		.append("\n").append("\n").append("Passengers :")
		.append("\n").append("Name    \t").append("     Age\t")
		.append("    Gender").append("\tFare").append("\n");
		 for(Passenger Key:entrySet)
		 {
			sb.append(Key+"    "+Passengers.get(Key));
			sb.append("\n");
		 }
		 sb.append("\n")
		.append("totalPrice: "+calculateTotalTicketPrice());
		return sb;

	}

	public  void writeTicket() throws IOException
	{
		FileWriter f=new FileWriter(generatePNR()+".txt");
		BufferedWriter bw=new BufferedWriter(f);
		 bw.append(generateTicket());
		 bw.flush();
		 bw.close();
	}


	@Override
	public String toString() {
		return "Ticket [counter=" + counter + ", pnr=" + pnr + ", TravelDate=" + TravelDate + ", train=" + train
				+ ", Passengers=" + Passengers + "]";
	}
	
	
}
