public class Pet {
	private String name;
	private String type;
	private String colour;
	private Owner owner;
	private DateOfBirth dob;
	
	Pet (String n, String t, String c){
		this.name = n;
		this.type = t;
		this.colour = c;
	}
	
	public void setOwner (String n, String a, String p, int d, int m, int y) {
		this.owner = new Owner(n, a, p, d, m, y);
	}
	
	public void setDOB (int d, int m, int y) {
		this.dob = new DateOfBirth(d, m, y);
	}
	
	@Override
	public String toString() {
		String myDob, myOwner;
		
		if (this.dob == null) {
			myDob = "?";
		}
		else {
			myDob = this.dob.toString();
		}
		
		if (this.owner == null) {
			myOwner = "None (Stray)";
		}
		else {
			myOwner = this.owner.toString();
		}
		
		return "--PET--" +
				"\nName:\t" + this.name +
				"\nType:\t" + this.type +
				"\nColour:\t" + this.colour +
				"\ndob:\t" + myDob +
				"\n--OWNER--\n" +
				myOwner;
	}
	
}