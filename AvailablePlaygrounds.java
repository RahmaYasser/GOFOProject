package GOFO2;

import java.time.Duration;
import java.util.Vector;

public class AvailablePlaygrounds {
    public static Vector<Playground> playgrounds = new Vector<>();
    public static Vector<Item> items;



    public void fillItemsVector(TimeSlot ts){ // ts is time slot coming from filtration
        Item item=new Item();
        items = new Vector<>();
        if(ts!=null){
            for(int i=0;i<playgrounds.size();i++){
                item.name = playgrounds.get(i).getName();
                item.description =playgrounds.get(i).getDescription() ;
                item.cancellationPeriod = playgrounds.get(i).getCancellationPeriod();
                item.location = playgrounds.get(i).getLocation();
                item.size = playgrounds.get(i).getSize();
                item.pricePerHour = playgrounds.get(i).getPricePerHour();
                for(int j=0;j<playgrounds.get(i).timeSlotSize();j++){
                    if(equals(playgrounds.get(i).getSlot(j),ts) ){
                        item.timeSlot = playgrounds.get(i).getSlot(j);
                        item.i = i;item.j = j;
                        items.add(item);
                    }
                }
            }
        }
        else{
            for(int i=0;i<playgrounds.size();i++){
                item.name = playgrounds.get(i).getName();
                item.description =playgrounds.get(i).getDescription() ;
                item.cancellationPeriod = playgrounds.get(i).getCancellationPeriod();
                item.location = playgrounds.get(i).getLocation();
                item.size = playgrounds.get(i).getSize();
                item.pricePerHour = playgrounds.get(i).getPricePerHour();
                for(int j=0;j<playgrounds.get(i).timeSlotSize();j++){
                    item.timeSlot = playgrounds.get(i).getSlot(j);
                    items.add(item);
                }
            }
        }
    }
    public boolean equals(TimeSlot t1,TimeSlot t2){
        return t1.getDay().equals(t2.getDay()) && (t1.getStartTime()>=t2.getStartTime() &&t1.getEndTime()<=t2.getEndTime());
    }
}
