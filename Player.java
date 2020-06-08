package GOFO2;

import java.util.ArrayList;
import java.util.Vector;

public class Player extends User{
    public Vector<Booking> bookingHistory;
    public Player(){
        bookingHistory = new Vector<>();
    }
}
