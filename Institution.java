/*
 * EECS 2500 - Linear Data Structures
 * 
 * Dr. Gerald Heuring
 * 
 * Paulo D. Nadal
 * 
 * Project 0
 * 
 * 20 September 2023
 */

 // this is the class for objects of "Institution"s
public class Institution {
	
	// variables
	protected String name;
	protected String nickname;
	protected int year;
	protected String city;
	protected String state;
	protected int studentbody;
	
	// no arg constructor
	public Institution()
	{
		
	}
	
	// constructor that takes in 6 parameters
	public Institution(String name, String nickname, int year, String city, String state, int studentbody)
	{
		this.name = name;
		this.nickname = nickname;
		this.year = year;
		this.city = city;
		this.state = state;
		this.studentbody = studentbody;
	}
	
	// makes the given parameters into a string !!
	public String toString()
	{
		return    "\nName: " + name + "\n"
				+ "Nickname: " + nickname + "\n" 
				+ "Year founded: " + year + "\n"
				+ "City: " + city + "\n"
				+ "State: " + state + "\n"
				+ "Approximate # of students: " + studentbody + "\n";
		
	}

	// ma getters and setters for each of the parameters. they make the input specific to a singular object.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStudentbody() {
		return studentbody;
	}

	public void setStudentbody(int studentbody) {
		this.studentbody = studentbody;
	}

	public static void main(String[] args) {
		
		// create new institution object
		Institution institution = new Institution("Name", "Nickname", 0000, "City", "State", 000000);
		// print out the institution and its parameters
		System.out.print(institution);
	}

}
