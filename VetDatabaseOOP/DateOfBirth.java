public class DateOfBirth {
	final private String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private int day;
	private int month;
	private int year;
	
	DateOfBirth (int d, int m, int y){
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	@Override
	public String toString() {
		return this.monthNames[this.month - 1] + " " + this.day + " " + this.year;
	}
}