package GOFO2;

import java.time.Duration;

public class Item {

    public String name, location, description;
    public double size, pricePerHour;
    public int cancellationPeriod,i,j;
    public TimeSlot timeSlot;
    public PlaygroundOwner playgroundOwner;

    public Item() {
        timeSlot = new TimeSlot();
    }

    @Override
    public String toString() {

        return
        "Playground name:" + name + "\n" +
                "location: " + location + "\n" +
                "Description: " + description + "\n" +
                "Size: " + size +"\n"+
                "Price per hour: " + pricePerHour +"\n"+
                "Cancellation period " + String.valueOf(cancellationPeriod) +"minutes"+"\n"+
                "Available on: " + timeSlot.getDay() +" from "+String.valueOf(timeSlot.getStartTime()) +" to "+ String.valueOf(timeSlot.getEndTime())+"\n";

    }
}
