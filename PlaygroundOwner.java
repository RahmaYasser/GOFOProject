package GOFO2;


import java.util.Vector;

public class PlaygroundOwner extends User {
    Playground myPlayground = new Playground();
    public Vector<Booking> bookingHistory = new Vector();
    String request = "error";
    Vector<String> slots = new Vector();
    

    PlaygroundOwner() {
        bookingHistory = new Vector<>();
    }
}
