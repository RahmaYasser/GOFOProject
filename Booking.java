package GOFO2;

import javax.swing.Timer;

public class Booking {
    Item item;
    eWallet bookingWallet = new eWallet();
    //Timer timer;
    Double Price;

    Booking(){
        bookingWallet.setCurrentMoney(0);
    }
}
