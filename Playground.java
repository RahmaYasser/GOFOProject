package GOFO2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class Playground {
    private String name, location, description;
    private double size, pricePerHour;
    private int cancellationPeriod;
    private int id;


    ArrayList<TimeSlot> timeSlot = new ArrayList<>();
    public boolean Available[];
    public PlaygroundOwner playgroundOwner;


    public Playground() {
        Available = new boolean[50];
        for(int i=0;i<50;i++) Available[i] = true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public double getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public ArrayList<TimeSlot> getTimeSlot() {
        return timeSlot;
    }

    public TimeSlot getSlot(int index){
        return timeSlot.get(index);
    }

    public void addSlot(TimeSlot t){
        timeSlot.add(t);
    }

    public void setSlot(TimeSlot t,int index ){
        timeSlot.set(index,t);
    }

    public void setCancellationPeriod(int cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    public int getCancellationPeriod() {
        return cancellationPeriod;
    }

    public int timeSlotSize(){
        return timeSlot.size();
    }

}
