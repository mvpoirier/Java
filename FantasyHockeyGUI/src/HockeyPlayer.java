/**
 * 	Hockey Player child class that inherits the Person class.
 */

// Hockey Player 'extends' the superclass Person
public class HockeyPlayer extends Person {

	// Example of encapsulating private data members; requires mutator/accessor (setter/getter) methods.
	private String team;
	private String position;
	private int number;
	
	public HockeyPlayer(String f, String l, int a, String t, String p, int n) {
		super(f, l, a);
		this.team = t;
		this.position = p;
		this.number = n;
	}
	
	public String getTeam () {
		return this.team;
	}
	
	public void setTeam (String t) {
		this.team = t;
	}
	
	public String getPosition () {
		return this.position;
	}
	
	public void setPosition (String p) {
		this.position = p;
	}
	
	public int getNumber () {
		return this.number;
	}
	
	public void setNumber (int n) {
		this.number = n;
	}
}
