package trainticket;



import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ticket {

	/*========  Variable declaration ===========*/
	private int counter;
	private String pnr;
	private LocalDate TravelDate;
	private Train train;
	private TreeMap <Passenger,Double>Passengers=new TreeMap();


	/*=========  Constructor ================*/
	public Ticket(LocalDate travelDate, Train train) {

		TravelDate = travelDate;
		this.train = train;
	}

	/*=========   start of getter & setter methods======*/
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

	/*==========  end of getter & setter methods =================*/


	/*=============== generatePNR method generate the PNR  ================= */	
	public  String generatePNR() 
	{



		String source=String.valueOf(train.getSource().charAt(0));
		String destination=String.valueOf(train.getDestination().charAt(0));
		String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
		pnr= source+destination+"_"+date+"_"+counter;


		if(TravelDate.isAfter(LocalDate.now()))
			return pnr;
		else
			return "Travel Date is before current date ";


	}
	
	
	/*=============== calPassengerFare method calculate the one passenger price  ================= */
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


	/*=============== addPassenger method is used to add passenger for ticket booking ================= */
	public void addPassenger(String name,int age,char gender)
	{ 

		Double fare= calPassengerFare(new Passenger(name, age, gender));

		Passengers.put(new Passenger(name, age, gender),fare);
	}


	/*=============== calculateTotalTicketPrice method calculate the total price of passenger ================= */
	double calculateTotalTicketPrice()
	{
		Double totalPrice=0.0;


		for(Double values:Passengers.values())
		{
			totalPrice=totalPrice+values;

		}


		return totalPrice;

	}


	/*=============== generateTicket method generate the ticket of passenger ================= */
	StringBuilder generateTicket() 
	{
		Collection<Passenger> entrySet=Passengers.keySet();
		String traveldate=TravelDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		StringBuilder sb=new StringBuilder();

		sb.append("PNR   :"+generatePNR()).append("\n")
		.append("TrainNo :"+train.getTrainNo()).append("\n")
		.append("Train Name :"+train.getTrainName()).append("\n")
		.append("from :"+train.getSource()).append("\n")
		.append("to :"+train.getDestination()).append("\n")
		.append("travelDate :"+traveldate).append("\n")
		.append("\n").append("\n").append("Passengers :")
		.append("\n").append("Name    \t").append("     Age\t")
		.append("    Gender").append(" Fare").append("\n");
		for(Passenger Key:entrySet)
		{
			sb.append(Key+"    "+Passengers.get(Key));
			sb.append("\n");
		}
		sb.append("\n")
		.append("totalPrice: "+calculateTotalTicketPrice());
		return sb;

	}

	/*=============== writeTicket method  write the ticket of passenger in a file ================= */
	public  void writeTicket() throws IOException
	{
		FileWriter f=new FileWriter(generatePNR()+".txt");
		BufferedWriter bw=new BufferedWriter(f);
		bw.append(generateTicket());
		bw.flush();
		bw.close();
	}

	/*=============== Overriding of toString method ================= */
	@Override
	public String toString() {
		return "Ticket [counter=" + counter + ", pnr=" + pnr + ", TravelDate=" + TravelDate + ", train=" + train
				+ ", Passengers=" + Passengers + "]";
	}

}
