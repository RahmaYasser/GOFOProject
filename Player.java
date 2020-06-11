package GOFO2;

import java.util.ArrayList;
import java.util.Vector;

public class Player extends User{
    private String notification="You didn't receive messages yet";

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

    public Player( String name, String location, String email, String password, String phone, eWallet userEwallet) {
        super( name, location, email, password, phone, userEwallet);
        bookingHistory = new Vector<>();

    }

    public Team team;
    public Vector<Booking> bookingHistory;
    public Player(){

        bookingHistory = new Vector<>();
        team = new Team();
    }
}
