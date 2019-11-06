/*
 * 	A VERY basic linked list impelementation for a Fantasy Hockey team.
 * 	Tutorial: https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 * 	Java JRE 1.8.0 Implementation: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
 */

public class FantasyTeam {
	
	Node head;
	
	public FantasyTeam() {
		this.head = null;
	}
	
	public static FantasyTeam insert (FantasyTeam team, HockeyPlayer p) {
		Node newPlayer = new Node(p);
		newPlayer.next = null;
		
		if (team.head == null) {
			// If list empty, add player to the head (first)
			team.head = newPlayer;
		}
		else {
			// Traverse until we're at the end of the list, then add
			Node last = team.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newPlayer;
		}
		
		return team;
	}

	
	public static void printTeam (FantasyTeam team) {
		Node currNode = team.head;
		int num = 0;
		
		if (currNode == null) {
			System.out.println("Fantasy team is EMPTY!");
		}
		else {
			while (currNode != null) {
				num++;
				System.out.println(currNode.player.getFirstName());
				System.out.println(currNode.player.getLastName());
				System.out.println("Age: " + currNode.player.getAge());
				System.out.println("Team: " + currNode.player.getTeam());
				System.out.println("Position: " + currNode.player.getPosition());
				System.out.println("#" + currNode.player.getNumber());
				System.out.println();
				currNode = currNode.next;
			}
		}
		
		System.out.println("\n***A total of " + num + " players were found.***");
	}
}