/*
 * NAME:	Mr. Poirier
 * DATE:	2021-03-14 (Pi Day!)
 * PURPOSE:	An example of creating objects (OOP D.1)
 * 			A simple Box class.
 */

public class Box {
	// Data
	public double length;
	public double width;
	public double height;
	
	// Constructor
	public Box (double l, double w, double h) {
		length = l;
		width = w;
		height = h;
	}
	
	// Actions
	public double calcVolume () {
		return length * width * height;
	}
	
	public double calcSA () {
		return (2 * length * width) + (2 * length * height) + (2 * width * height);
	}
	
	@Override
	public String toString() {
		return "l: " + length + "\nw: " + width + "\nh: " + height;
	}
}

