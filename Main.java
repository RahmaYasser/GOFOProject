package GOFO2;

public class Main {

    public static Player currentPlayer = new Player();
    public static PlaygroundOwner currentOwner = new PlaygroundOwner();

    public static void main(String[] args) {
        //GUI gui = new GUI();
        //gui.playerOptions();
       // gui.registerPage();
       // gui.verificationCodePage();
        Playground playground = new Playground();
        playground.setDescription("description ");
        playground.setLocation("94 sdkjhds st ,Cairo");
        playground.setName("Ay 7aga ");
        playground.setPricePerHour(40);
        playground.setSize(30);
        playground.setCancellationPeriod(8);
        TimeSlot timeSlot = new TimeSlot(2,3,"Monday");
        TimeSlot timeSlot2 = new TimeSlot(4,6,"Sunday");
        playground.addSlot(timeSlot);
        playground.addSlot(timeSlot2);



        Playground playground2 = new Playground();
        playground2.setDescription("description ");
        playground2.setLocation("94 sdkjhds st ,Cairo");
        playground2.setName("Markaz shabaa el 7abaniah");
        playground2.setPricePerHour(40);
        playground2.setSize(30);
        playground2.setCancellationPeriod(4);
        TimeSlot timeSlot3 = new TimeSlot(2,3,"Monday");
        playground2.addSlot(timeSlot3);
        Playground playground3 = new Playground();
        playground3.setDescription("description ");
        playground3.setLocation("94 sdkjhds st ,Cairo");
        playground3.setName("Markaz shabaa el 7abaniah");
        playground3.setPricePerHour(40);
        playground3.setSize(30);
        playground3.setCancellationPeriod(3);
        TimeSlot timeSlot4 = new TimeSlot(2,3,"Monday");
        playground3.addSlot(timeSlot4);

        AvailablePlaygrounds.playgrounds.add(playground);
        AvailablePlaygrounds.playgrounds.add(playground2);
        AvailablePlaygrounds.playgrounds.add(playground3);
        //AvailablePlaygrounds availablePlaygrounds = new AvailablePlaygrounds();
        //availablePlaygrounds.fillItemsVector(null);

        GUI gui=new GUI();
        gui.PlayerOptionTwo();

    }

}
