import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.print("What is your name: ");
        Scanner myscan = new Scanner(System.in);

        String input =j myscan.next();

        System.out.println("\nNice to meet you, " + input);
        System.out.println("done");
        
        myscan.close();
    }
}