/*
 * NAME:	Mr. Poirier
 * DATE:	March 2, 2021
 * PURPOSE: Creating a force class, and discussing public vs. private.
 */

public class ForceMain {
	public static void main(String[] args) {
		Force soccerKick = new Force (5.0, 20.0, 45);
		soccerKick.print();

		// Method below will not work: private data members
		// printForce(soccerKick.mass, soccerKick.acceleration);
	}
}
