/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestLoops;

/**
 *
 * @author admin
 */
public class TestLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //SWING GUI TEST
        TestJFrame mySwingFrame = new TestJFrame();
        mySwingFrame.setVisible(true);
        
        // TODO code application logic here
        System.out.println("Hello World!");
        System.out.print("\n\n");

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
        
    }   
}
