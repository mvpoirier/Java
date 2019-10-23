public class StaticQueue {
	private int[] q;
	private boolean full;
	
	public StaticQueue (int n) {
		q = new int[n];
		full = false;
		
		for (int i = 0; i < q.length; i++) {
			q[i] = -1; //the value -1 is 'empty'
		}
	}
	
	public void enqueue (int value) {
		//TODO
	}
	
	public int dequeue () {
		//TODO
	}
}
