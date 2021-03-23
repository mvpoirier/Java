public class Owner {
	private String name;
	private String address;
	private String profession;
	private DateOfBirth dob;
	
	Owner (String n, String a, String p, int d, int m, int y){
		this.name = n;
		this.address = a;
		this.profession = p;
		dob = new DateOfBirth (d, m, y);
	}
	
	@Override
	public String toString() {
		return "Name:\t" + this.name +
				"\nAddr.:\t" + this.address +
				"\nProf.:\t" + this.profession +
				"\ndob:\t" + this.dob.toString();
	}
}