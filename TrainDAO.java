package trainticket;

import java.sql.*;

public class TrainDAO {
	String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false";
	String USERNAME="root";
	String PASSWORD="root";

	public Train findTrain(int trainNo)
	{

		int TRAIN_NO=trainNo;
		Train train =null;

		try
		{   //step 1
			Class.forName(DRIVER_NAME);
			System.out.println("class found");

			//step 2
			Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("connected");

			//step 3
			PreparedStatement pstmt=con.prepareStatement("select * from train where TRAIN_NO= ?");
			pstmt.setInt(1,TRAIN_NO );

			ResultSet rs=pstmt.executeQuery();


			while(rs.next())
			{
				train = new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
			}
			con.close();

		}
		catch(Exception e)
		{
			
			System.out.println(e);
		}


		return train;

	}



}
