import javax.swing.*;
import java.util.Scanner;

public class FrontEnd {
	
	public static void main(String[] args) {
		
		System.out.println("Hello World!!");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i<10);
		}
		
		int x = 0;
        int i = 5;
        
        while (x < 10){
            System.out.print(x + " ");
            x++;
        }
        System.out.print("\n\n");
        
        do {
            System.out.println("BACON!");
            i++;
        } while (i <= 10);
        System.out.print("\n\n");
        
        for (int z = 0; z < 4; z++) {
            System.out.println(Math.pow(z,2));
        }
        
        System.out.println(getNum());
        
        LinkyList myList = new LinkyList();
        System.out.println(myList.getLinky());
        myList.setLinky(8);
        System.out.println(myList.getLinky());
        
        MuchoLinky superLinky = new MuchoLinky();
        System.out.println(superLinky.getLinky());
        
        LinkyList[] myListArray = new LinkyList [10];
        for (i = 0; i < myListArray.length; i++) {
        	myListArray[i] = new LinkyList();
        }
        
        for (i = 0; i < myListArray.length; i++) {
        	myListArray[i].setLinky((int)(Math.random() * 100));
        }
       
        for (i = 0; i < myListArray.length; i++) {
        	System.out.println(myListArray[i].getLinky());
        }
        
        System.out.println(Math.sin(Math.toRadians(90.0)));
        
        Scanner myScan = new Scanner (System.in);
        String s; int a; float b;
        
        String fruit = JOptionPane.showInputDialog("What is your favorite fruit?");
        System.out.println(fruit);
        
        System.out.println("\nEnter your name: ");
        s = myScan.nextLine();
        System.out.println("Hello, " + s + "!");
        
        System.out.println("\nEnter your age: ");
        a = myScan.nextInt();
        if (a > 34) {
        	System.out.println("You are " + (a - 34) + " years older than me!");
        }
        else if (a < 34) {
        	System.out.println("You are " + (34 - a) + " years younger than me!");
        }
        else {
        	System.out.println("Wow, we're the same age!");
        }
        
        System.out.println("\nEnter a float: ");
        b = myScan.nextFloat();
        System.out.println("The value is: " + b);
        myScan.close();
        
        JOptionPane.showMessageDialog(null, "End of program :-)");
        
}
	
	public static int getNum() {
		return 5;
	}
}
