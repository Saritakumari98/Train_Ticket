package trainticket;

import java.util.*;


/*========  Implementation of Comparable Interface in Passenger class ===========*/
public class Passenger implements Comparable<Passenger>
{

	/*========  Variable declaration ===========*/
	private String name;
	private int age;
	private char gender;


	/*=========  Constructor ================*/
	public Passenger(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	/*=========   start of getter & setter methods======*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	/*==========  end of getter & setter methods =================*/


	/*=============== Overriding of toString method ================= */
	@Override
	public String toString() {
		return  name +"                 "+age+"              "+gender;
	}


	/*=============== Overriding of compareTo method of Comparable Interface================= */
	@Override
	public int compareTo(Passenger p) {
		return name.compareTo(p.name);
	}




}
