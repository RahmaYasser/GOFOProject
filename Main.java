package GOFO2;

/**
 * @author Rahma Yasser Ahmed 20180100
 * @author Eman Mahmoud Mostafa Talha 20180064
 * @author Sarah Hisham Mohamed 20180118
 * This class includes the main method to start the program
 * which is a program for booking playgrounds.
 */
public class Main {

    public static Player currentPlayer = new Player();
    public static PlaygroundOwner currentOwner = new PlaygroundOwner();


    public static void main(String[] args) {
        
        GUI gui=new GUI();
        gui.LoginPage();
        Administrator admin = new Administrator();
    }

}
