/*
 * NAME:	Mr. Poirier
 * DATE:	2021-03-14 (Pi Day!)
 * PURPOSE:	An example of creating objects (OOP D.1)
 * 			A driver main method to support the Box class.
 */

import java.util.Scanner;

public class BoxMain {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		double l, w, h;
		Box myFirstBox, userBox;
		
		myFirstBox = new Box (1.0, 2.0, 3.0);
		System.out.println(myFirstBox);
		
		System.out.println("\nlength: " + myFirstBox.length);
		System.out.println("width: " + myFirstBox.width);
		System.out.println("height: " + myFirstBox.height + "\n");
		
		System.out.println("Enter length: ");
		l = s.nextDouble();
		System.out.println("Enter width: ");
		w = s.nextDouble();
		System.out.println("Enter height: ");
		h = s.nextDouble();
		s.close();
		
		userBox = new Box (l, w, h);
		System.out.println("\n" + userBox);
		System.out.println("Vol: " + userBox.calcVolume());
		System.out.println("SA: " + userBox.calcSA());
	}

}

