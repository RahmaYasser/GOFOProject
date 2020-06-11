package GOFO2;

import javax.swing.Timer;

public class Booking {
    Item item;
    eWallet bookingWallet ;
    Timer timer;
    Double Price;
    int seconds;

    Booking(){
        seconds=1;
        item = new Item();
        bookingWallet= new eWallet();
        bookingWallet.setCurrentMoney(0);

    }
    
    
    @Override
    public String toString() {
        return "Playground name:" + item.name + "\n" +
                "location: " + item.location + "\n" +
                "Description: " + item.description + "\n" +
                "Size: " + item.size +"\n"+
                "Price per hour: " + item.pricePerHour +"\n"+
                "Total price: " + Price+"\n"+
                "Cancellation period " + String.valueOf(item.cancellationPeriod) +"minutes"+"\n"+
                "Available on: " + item.timeSlot.getDay() +" from "+String.valueOf(item.timeSlot.getStartTime()) +" to "+ String.valueOf(item.timeSlot.getEndTime())+"\n";

    }
}
