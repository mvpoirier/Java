import java.util.*;
import java.io.*;

public class CeasarCipher {

	public static void main(String[] args) throws IOException { // Need to throw IOE when creating a file.
		
		String plaintext;
		String encrypted = new String();
		String decrypted = new String();
		char alphabet;
		int shift;
		
		Scanner myScan = new Scanner(System.in);
		
		FileWriter myFile = new FileWriter("encrypted.txt");
		PrintWriter myWriter = new PrintWriter(myFile);
		
		System.out.print("Message to encrypt: ");
		plaintext = myScan.nextLine().toLowerCase();
		
		System.out.print("\nShift value: ");
		shift = myScan.nextInt();
		
		for (int i = 0; i < plaintext.length(); i++) {
			alphabet = (char) plaintext.charAt(i);
			
			if (alphabet >= 'a' && alphabet < ( (char) 'z' - shift + 1)) {
				alphabet = (char) (alphabet + shift);
			}
			else if (alphabet >= (char) 'z' - shift + 1) {
				alphabet = (char) (alphabet + 'a' - 'z' + shift - 1); // How does this work?
			}
			
			encrypted = encrypted + alphabet;
		}
		
		System.out.print("\nEncrypted message: " + encrypted);
		myWriter.print(encrypted); // Write to file
		myWriter.close();
		
		System.out.println("\n\n*** Read Secret Message***");
		
		FileReader fr = new FileReader("secretmessage.txt"); 
        BufferedReader br = new BufferedReader(fr); 
		
		shift = Integer.parseInt(br.readLine());
		plaintext = br.readLine().toLowerCase();
		br.close();
		
		for (int i = 0; i < plaintext.length(); i++) {
			alphabet = (char) plaintext.charAt(i);
			
			// TODO REVISE FOR DECRYPT
			if (alphabet >= 'a' && alphabet < ( (char) 'z' - shift + 1)) {
				alphabet = (char) (alphabet - shift);
			}
			else if (alphabet >= (char) 'z' - shift + 1) {
				alphabet = (char) (alphabet + 'a' - 'z' - (shift - 1)); // How does this work?
			}
			
			decrypted = decrypted + alphabet;
		}
		
		System.out.print("\nDecrypted message from secretmessage.txt: " + decrypted);

	}
	

}
