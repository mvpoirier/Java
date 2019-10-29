
public class LLIntegerTest {

	public static void main(String[] args) {
		LLInteger numList = new LLInteger();
		
		System.out.println(numList.isEmpty());
		
		numList.add(5);
		System.out.println(numList.isEmpty());
		
		numList.add(10);
		numList.add(67);
		
		numList.print();
		System.out.println("Size: " +  numList.size());
		
		System.out.println(numList.removeFirst());
		System.out.println("Size: " +  numList.size());
		numList.print();
	}

}
