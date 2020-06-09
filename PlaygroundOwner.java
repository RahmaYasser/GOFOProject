package GOFO2;


import java.util.Vector;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PlaygroundOwner extends User// implements ActionListener, MouseListener{
{
    Playground myPlayground = new Playground();
    public Vector<Booking> bookingHistory = new Vector();
    String request = "error";
    Vector<String> slots = new Vector();

    /*JFrame frame = new JFrame();
    JPanel ownerHome = new JPanel();
    JPanel addUpdatePanel = new JPanel();
    JPanel slotsPanel = new JPanel();
    JPanel vBookingPanel = new JPanel();
    JPanel eWalletPanel = new JPanel();
    JLabel header = new JLabel();
    JLabel PgNameLabel = new JLabel("Name");
    JLabel locationLabel = new JLabel("Location");
    JLabel sizeLabel = new JLabel("Size");
    JLabel descriptionLabel = new JLabel("Description");
    JLabel priceLabel = new JLabel("Price Per Hour");
    JLabel cancellationLabel = new JLabel("Cancellation Period");
    JLabel addSlots = new JLabel("Add Slots");
    JLabel viewSlots = new JLabel("View Slots");
    JLabel logout = new JLabel("logout");
    JLabel lmoney = new JLabel();
    JLabel lid = new JLabel();
    JTextField nameText = new JTextField();
    JTextField locationText = new JTextField();
    JTextField sizeText = new JTextField();
    JTextField descriptionText = new JTextField();
    JTextField priceText = new JTextField();
    JTextField cancellationText = new JTextField();
    JTextField day = new JTextField();
    JTextField from = new JTextField();
    JTextField to = new JTextField();
    JButton addPgButton = new JButton("Add Playground");
    JButton updatePgButton = new JButton("Update Playground");
    JButton vBookingButton = new JButton("View Bookings");
    JButton eWalletButton = new JButton("Status & eWallet");
    JButton addPlaygroundButton = new JButton("Add");
    JButton updateButton = new JButton("Update");
    JButton done = new JButton("Done");
    JButton ownerBack1 = new JButton("<<");*/

    PlaygroundOwner(){
       //ownerOptions();
       bookingHistory = new Vector<>();
    }

   /* *//**
     * This function builds the welcome page of the playground owner
     *//*
    private void ownerOptions() {
        ownerHome.setVisible(true);
        addUpdatePanel.setVisible(false);
        slotsPanel.setVisible(false);
        vBookingPanel.setVisible(false);
        eWalletPanel.setVisible(false);

        frame.setTitle("GoFo");
        frame.setSize(300, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocation(650, 200);
        ownerHome.setLayout(null);
        ownerHome.setBackground(new java.awt.Color(105,105,105));

        addPgButton.setBackground(new Color(255,134,0));
        addPgButton.setForeground(Color.white);
        addPgButton.setBounds(20, 200, 110, 50);
        addPgButton.setFont (header.getFont ().deriveFont (9f));

        updatePgButton.setBackground(new Color(255,134,0));
        updatePgButton.setForeground(Color.white);
        updatePgButton.setBounds(160, 200, 110, 50);
        updatePgButton.setFont (header.getFont ().deriveFont (8f));

        vBookingButton.setBackground(new Color(255,134,0));
        vBookingButton.setForeground(Color.white);
        vBookingButton.setBounds(20, 270, 110, 50);
        vBookingButton.setFont (header.getFont ().deriveFont (9f));

        eWalletButton.setBackground(new Color(255,134,0));
        eWalletButton.setForeground(Color.white);
        eWalletButton.setBounds(160, 270, 110, 50);
        eWalletButton.setFont (header.getFont ().deriveFont (9f));


        header.setForeground(Color.WHITE);
        header.setText("WELCOME");
        header.setFont (header.getFont ().deriveFont (23f));
        header.setBounds(80, 50, 130, 50);

        logout.setForeground(Color.WHITE);
        logout.setBounds(120, 340, 130, 50);

        frame.add(ownerHome);
        ownerHome.add(addPgButton);
        ownerHome.add(updatePgButton);
        ownerHome.add(vBookingButton);
        ownerHome.add(eWalletButton);
        ownerHome.add(header);
        ownerHome.add(logout);

        addPgButton.addActionListener(this);
        updatePgButton.addActionListener(this);
        vBookingButton.addActionListener(this);
        eWalletButton.addActionListener(this);
        logout.addMouseListener(this);
    }

    *//**
     * This function displays when the owner presses on the add playground button,
     * then he fills the information of his playground
     *//*
    private void toAddPlayground() {

        formDetails();

        header.setText("Add Playground");
        header.setBounds(50, 30, 180, 50);

        addPlaygroundButton.setBackground(new Color(255,134,0));
        addPlaygroundButton.setForeground(Color.WHITE);
        addPlaygroundButton.setBounds(100, 375, 80, 30);
        addPlaygroundButton.setVisible(true);
        updateButton.setVisible(false);

        ownerBack1Details();

        addUpdatePanel.add(addPlaygroundButton);
        addPlaygroundButton.addActionListener(this);
    }



    *//**
     * To check if all fields are filled or not.
     * If all fields are filled, they are stored and the request will be ok.
     * If not, the request will be error because of uncompleted information.
     *//*
    public void getPlaygroundData() {
        if (!nameText.getText().contentEquals("") && !locationText.getText().contentEquals("") && !sizeText.getText().contentEquals("")
                && !descriptionText.getText().contentEquals("") && !priceText.getText().contentEquals("") && !cancellationText.getText().contentEquals("")) {

            myPlayground.setName(nameText.getText());
            myPlayground.setLocation(locationText.getText());
            myPlayground.setSize(Double.parseDouble(sizeText.getText()));
            myPlayground.setDescription(descriptionText.getText());
            myPlayground.setPricePerHour(Double.parseDouble(priceText.getText()));
            myPlayground.setCancellationPeriod(Integer.parseInt(cancellationText.getText()));
            request = "ok";
        }
        else {
            request = "error";
        }
    }

    *//**
     * This function displays when the owner presses on the update playground button,
     * Then he can show or modify his playground information.
     *//*
    public void updatePlayground() {

        formDetails();

        header.setText("Update Playground");
        header.setBounds(30, 25, 220, 50);

        updateButton.setBackground(new Color(255,134,0));
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(100, 375, 80, 30);
        updateButton.setVisible(true);
        addPlaygroundButton.setVisible(false);

        ownerBack1Details();

        String str;

        nameText.setText(myPlayground.getName());
        locationText.setText(myPlayground.getLocation());
        str = String.valueOf(myPlayground.getSize());
        sizeText.setText(str);
        descriptionText.setText(myPlayground.getDescription());
        str = String.valueOf(myPlayground.getPricePerHour());
        priceText.setText(str);
        str = String.valueOf(myPlayground.getCancellationPeriod());
        cancellationText.setText(str);

        addUpdatePanel.add(updateButton);
        updateButton.addActionListener(this);
    }

    *//**
     * If the admin approved the playground, the playground is stored in the array list
     *//*
    private void approvedAddPlayground() {
        AvailablePlaygrounds.playgrounds.add(myPlayground);
        myPlayground.setId(AvailablePlaygrounds.playgrounds.size());
    }

    *//**
     * If the admin approved the playground update, the playground is modified in the array list
     *//*
    private void approvedUpdatePlayground() {
        int index = myPlayground.getId();
        AvailablePlaygrounds.playgrounds.get(index-1).equals(myPlayground);
    }

    *//**
     * To build the window of the add playground button and update playground button.
     *//*
    private void formDetails() {
        ownerHome.setVisible(false);
        slotsPanel.setVisible(false);
        addUpdatePanel.setVisible(true);
        addUpdatePanel.setBackground(new java.awt.Color(105,105,105));
        addUpdatePanel.setLayout(null);

        PgNameLabel.setText("Name");
        PgNameLabel.setBounds(40, 70, 80, 20);
        PgNameLabel.setFont (PgNameLabel.getFont ().deriveFont (10f));
        PgNameLabel.setForeground(Color.WHITE);

        locationLabel.setText("Location");
        locationLabel.setBounds(40, 110, 80, 20);
        locationLabel.setFont (locationLabel.getFont ().deriveFont (10f));
        locationLabel.setForeground(Color.WHITE);

        sizeLabel.setText("Size");
        sizeLabel.setBounds(40, 150, 80, 20);
        sizeLabel.setFont (sizeLabel.getFont ().deriveFont (10f));
        sizeLabel.setForeground(Color.WHITE);

        descriptionLabel.setText("Description");
        descriptionLabel.setBounds(40, 190, 80, 20);
        descriptionLabel.setFont (descriptionLabel.getFont ().deriveFont (10f));
        descriptionLabel.setForeground(Color.WHITE);

        priceLabel.setText("Price Per Hour");
        priceLabel.setBounds(40, 230, 80, 20);
        priceLabel.setFont (priceLabel.getFont ().deriveFont (10f));
        priceLabel.setForeground(Color.WHITE);

        cancellationLabel.setText("Cancellation Period");
        cancellationLabel.setBounds(40, 270, 120, 20);
        cancellationLabel.setFont (cancellationLabel.getFont ().deriveFont (10f));
        cancellationLabel.setForeground(Color.WHITE);

        addSlots.setBounds(110, 330, 120, 20);
        addSlots.setFont (addSlots.getFont ().deriveFont (13f));
        addSlots.setForeground(Color.WHITE);

        nameText.setBounds(40, 90, 200, 20);
        locationText.setBounds(40, 130, 200, 20);
        sizeText.setBounds(40, 170, 200, 20);
        descriptionText.setBounds(40, 210, 200, 20);
        priceText.setBounds(40, 250, 200, 20);
        cancellationText.setBounds(40, 290, 200, 20);

        frame.add(addUpdatePanel);
        addUpdatePanel.add(ownerBack1);
        addUpdatePanel.add(header);
        addUpdatePanel.add(PgNameLabel);
        addUpdatePanel.add(locationLabel);
        addUpdatePanel.add(sizeLabel);
        addUpdatePanel.add(descriptionLabel);
        addUpdatePanel.add(priceLabel);
        addUpdatePanel.add(cancellationLabel);
        addUpdatePanel.add(addSlots);
        addUpdatePanel.add(nameText);
        addUpdatePanel.add(locationText);
        addUpdatePanel.add(sizeText);
        addUpdatePanel.add(descriptionText);
        addUpdatePanel.add(priceText);
        addUpdatePanel.add(cancellationText);

        addSlots.addMouseListener(this);
    }

    public void addSlotsFrame() {
        addUpdatePanel.setVisible(false);
        slotsPanel.setVisible(true);
        slotsPanel.setBackground(new java.awt.Color(105,105,105));
        slotsPanel.setLayout(null);

        header.setText("Add Slots");
        header.setBounds(80, 25, 220, 50);

        PgNameLabel.setText("Day");
        PgNameLabel.setBounds(60, 110, 80, 30);
        PgNameLabel.setFont (PgNameLabel.getFont ().deriveFont (12f));
        PgNameLabel.setForeground(Color.WHITE);

        locationLabel.setText("From");
        locationLabel.setBounds(60, 150, 80, 30);
        locationLabel.setFont (locationLabel.getFont ().deriveFont (12f));
        locationLabel.setForeground(Color.WHITE);

        sizeLabel.setText("To");
        sizeLabel.setBounds(60, 190, 80, 30);
        sizeLabel.setFont (sizeLabel.getFont ().deriveFont (12f));
        sizeLabel.setForeground(Color.WHITE);

        done.setBackground(new Color(255,134,0));
        done.setForeground(Color.WHITE);
        done.setBounds(100, 340, 80, 30);

        day.setText("");
        from.setText("");
        to.setText("");

        day.setBounds(100, 110, 80, 30);
        from.setBounds(100, 150, 80, 30);
        to.setBounds(100, 190, 80, 30);

        addSlots.setBounds(110, 300, 120, 20);

        frame.add(slotsPanel);
        slotsPanel.add(header);
        slotsPanel.add(PgNameLabel);
        slotsPanel.add(locationLabel);
        slotsPanel.add(sizeLabel);
        slotsPanel.add(done);
        slotsPanel.add(day);
        slotsPanel.add(from);
        slotsPanel.add(to);
        slotsPanel.add(addSlots);

        addSlots.addMouseListener(this);
        done.addActionListener(this);
    }

    public void storeSlots() {
        if (!day.getText().contentEquals("") && !from.getText().contentEquals("") && !to.getText().contentEquals("")) {
            TimeSlot slot = new TimeSlot();
            slot.setDay(day.getText());
            slot.setEndTime(Integer.parseInt(to.getText()));
            myPlayground.timeSlot.add(slot);
        }
    }

    *//**
     * This function displays when the owner presses on the vie bookings button,
     * and it displays the bookings of the owner playground.
     *//*
    public void viewBookings() {
        ownerHome.setVisible(false);
        vBookingPanel.setVisible(true);
        vBookingPanel.setBackground(new java.awt.Color(105,105,105));
        vBookingPanel.setLayout(null);

        JList list = new JList(slots);

        list.setBackground(Color.WHITE);
        list.setForeground(Color.black);
        list.setBounds(40, 130, 200, 200);

        header.setText("Bookings");
        header.setBounds(100, 50, 180, 50);

        ownerBack1Details();

        frame.add(vBookingPanel);
        vBookingPanel.add(ownerBack1);
        vBookingPanel.add(list);
        vBookingPanel.add(header);
    }

    *//**
     * This function to store bookings slots into 'data' array
     *//*
    private void storePlaygroundsTitle() {
        slots.clear();
        for (int i = 0 ; i < bookingHistory.size() ; i++) {
            slots.add(bookingHistory.get(i).item.timeSlot.getDay() + "From " + String.valueOf(bookingHistory.get(i).item.timeSlot.getStartTime()) + " to "
                    + String.valueOf(bookingHistory.get(i).item.timeSlot.getEndTime()));
        }
    }

    *//**
     * This function displays when the owner presses on the update playground button,
     * and it displays the statue of the owner eWallet.
     *//*
    public void checkEwallet() {
        ownerHome.setVisible(false);
        eWalletPanel.setVisible(true);
        eWalletPanel.setBackground(new java.awt.Color(105,105,105));
        eWalletPanel.setLayout(null);

        header.setText("eWallet");

        String str;

        str = "Your Money: " + String.valueOf(this.getUserEwallet().getCurrentMoney());
        lmoney.setText(str);
        str = "Your eWallet ID: " + String.valueOf(this.getUserEwallet().getId());
        lid.setText(str);

        lmoney.setBounds(50, 120, 150, 50);
        lid.setBounds(50, 150, 150, 50);

        lmoney.setForeground(Color.WHITE);
        lid.setForeground(Color.WHITE);

        ownerBack1Details();

        frame.add(eWalletPanel);
        eWalletPanel.add(header);
        eWalletPanel.add(lmoney);
        eWalletPanel.add(lid);
        eWalletPanel.add(ownerBack1);
    }

    *//**
     * To set back details(color, font, ...)
     *//*
    private void ownerBack1Details() {
        ownerBack1.setBounds(5, 5, 50, 30);
        ownerBack1.setFont (ownerBack1.getFont ().deriveFont (10f));
        ownerBack1.setBackground(new Color(255,134,0));
        ownerBack1.setForeground(Color.white);

        ownerBack1.addActionListener(this);
    }

    *//**
     * This function to make actions based on a pressed button
     *//*
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addPgButton) {
            if (myPlayground.getId() == 0) {
                toAddPlayground();
            }
        }
        if (e.getSource() == updatePgButton) {
            if (myPlayground.getId() != 0) {
                updatePlayground();
            }
        }
        if (e.getSource() == vBookingButton) {
            viewBookings();
        }
        if (e.getSource() == eWalletButton) {
            checkEwallet();
        }
        if (e.getSource() == addPlaygroundButton) {
            getPlaygroundData();
            ownerOptions();
            if (Administrator.approvePlayground(request)) {
                approvedAddPlayground();
            }
        }
        if (e.getSource() == updateButton) {
            getPlaygroundData();
            ownerOptions();
            if (Administrator.approvePlayground(request)) {
                approvedUpdatePlayground();
            }
        }
        if (e.getSource() == done) {
            toAddPlayground();
        }
        if (e.getSource() == ownerBack1) {
            ownerOptions();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == addSlots) {
            storeSlots();
            addSlotsFrame();
        }
        if (e.getSource() == logout) {
            //login()
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

*/
    public static void main(String[] args) {
        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
    }
}
