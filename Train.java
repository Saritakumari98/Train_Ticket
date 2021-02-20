package trainticket;

public class Train {

	/*========  Variable declaration ===========*/
	private int trainNo;
	private String trainName;
	private String source;
	private String destination;
	private double ticketprice;


	/*=========  Constructor ================*/
	public Train(int trainNo, String trainName, String source, String destination, double ticketprice) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.ticketprice = ticketprice;
	}


	/*=========   start of getter & setter methods======*/
	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	/*==========  end of getter & setter methods =================*/


	/*=============== Overriding of toString method ================= */
	@Override
	public String toString() {
		return "Train [trainNo=" + trainNo + ", trainName=" + trainName + ", source=" + source + ", destination="
				+ destination + ", ticketprice=" + ticketprice + "]";
	}




}
