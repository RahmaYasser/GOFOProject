package GOFO2;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.swing.Timer;

import static GOFO2.Main.currentOwner;
import static GOFO2.Main.currentPlayer;


/**
 * This class includes all gui of the player frames and playground owner frames
 */
public class GUI extends JFrame implements MouseListener{
    private JCheckBox checkBox;
    private JFrame option1Frame, option2Frame, loginFrame,registerFrame ,verivicationFrame,PlayerOptionsFrame,option4Frame,showBookingInfoFrame;
    private Border border = BorderFactory.createLineBorder(Color.white, 1);
    private Border orangeBorder = BorderFactory.createLineBorder(new Color(255,134,0),2);
    private JPasswordField UserPF,registerPF;
    private JLabel NotificationLabel,Logout2,returnToOptions4;
    private JLabel emailLabel,PasswordLabel, returnToOptions3,returnToOptions, calcellationPeriodLabel,enterPlayerEmailLabel,teamFormationMsgLabel;
    private JLabel NewUserLabel,SignUpLabel,registerNameLabel,registerEmailLabel,registerPasswordLabel,registerPhoneLabel;
    private JLabel registerLocationLabel, errorInSignInLabel,errorInSignUpLabel,incorrectCodeLabel,verificationLabel,eWalletLabel;
    private JLabel minutesLabel,h, secondsLabel,welcomePlayer,Logout,selectTimeIntervalLabel,returnToOptions2;
    private JLabel playerOptionsLabelOne, playerOptionsLabelTwo, playerOptionsLabelthree, playerOptionsLabelFour;
    private JButton LoginButton, SignUPButton,CancelButton,verificationButton,addButton,showPlaygroundsButton,confirmBooking;
    private Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahma Yasser\\Desktop\\logotrans.png");
    private JRadioButton r1,r2;
    private ButtonGroup buttonGroup;
    private JComboBox DaysList,startTimeList,endTimeList;
    private JScrollPane scrollPane;
    private JList list1,list2;
    
    static int ItemIndex=0,BookingIndex=0, generatedCode;
    static boolean state;
    TimeSlot timeSlot;
    public boolean checked=false;
    private String notification;
    private String tmpName="",tmpEmail="",tmpPassword="",tmpLocation="",tmpPhone="",tmpID="";
    private JTextField UserEmailTF,registerNameTF,registerEmailTF,registerPhoneTF,registerLocationTF,codeTF,registerIDTF,playerEmailTF;

    JFrame frame, addPgFrame, updateFrame, slotsFrame, bookingFrame, eWalletFrame,option3Frame;
    JPanel ownerHome, addUpdatePanel, slotsPanel, vBookingPanel, eWalletPanel;
    JLabel header, addHeader, updateHeader, bookingHeader, eWalletHeader, slotsHeader;
    JLabel PgNameLabel, locationLabel, sizeLabel, descriptionLabel, priceLabel, cancellationLabel, addSlots;
    JLabel lmoney, lid, dayLabel, fromLabel, toLabel;
    JTextField nameText, locationText, sizeText, descriptionText,priceText, cancellationText;
    JTextField dayText, fromText, toText;
    JButton addPgButton, updatePgButton, vBookingButton, eWalletButton = new JButton("Status & eWallet");
    JButton addPlaygroundButton, updateButton, done;
    JButton addBack, updateBack, bookingBack, eWalletBack;
    
    public GUI() {}

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==codeTF) codeTF.setBorder(border);
        if(e.getSource() == registerIDTF) registerIDTF.setBorder(border);
        if(e.getSource() == playerEmailTF) playerEmailTF.setBorder(border);
        if(e.getSource() == UserEmailTF) UserEmailTF.setBorder(border);
        if(e.getSource() == registerNameTF)registerNameTF.setBorder(border);
        if(e.getSource() == registerEmailTF)registerEmailTF.setBorder(border);
        if(e.getSource() == registerPhoneTF)registerPhoneTF.setBorder(border);
        if(e.getSource() == registerLocationTF)registerLocationTF.setBorder(border);
        if(e.getSource() == UserPF)UserPF.setBorder(border);
        if(e.getSource() == registerPF)registerPF.setBorder(border);
        if(e.getSource() == SignUpLabel) {
            registerPage();
            setVisible(false);
        }
        if(e.getSource() == playerOptionsLabelOne) PlayerOptionOne();
        if(e.getSource() == playerOptionsLabelTwo) PlayerOptionTwo();
        if(e.getSource() == playerOptionsLabelthree) PlayerOptionThree();
        if(e.getSource() == playerOptionsLabelFour) PlayerOptionFour();
        if(e.getSource() == returnToOptions) {
            option2Frame.setVisible(false);
            playerOptions();
        }
        if(e.getSource() == returnToOptions2){
            showBookingInfoFrame.setVisible(false);
            playerOptions();
        }
        if(e.getSource() == returnToOptions3) {
            playerOptions();
            option3Frame.setVisible(false);
        }
        if(e.getSource()==returnToOptions4){
            playerOptions();
            option4Frame.setVisible(false);
        }
        if(e.getSource() == Logout){
            currentPlayer = null;
            currentOwner = null;
            PlayerOptionsFrame.setVisible(false);
            LoginPage();
        }
        if(e.getSource() == Logout2){
            currentPlayer = null;
            currentOwner = null;
            frame.setVisible(false);
            LoginPage();
        }
        if (e.getSource() == addSlots) {
            addSlotsFrame();
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==codeTF) codeTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerIDTF) registerIDTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == playerEmailTF) playerEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == UserEmailTF) UserEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerNameTF)registerNameTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerEmailTF)registerEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerPhoneTF)registerPhoneTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerLocationTF)registerLocationTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == UserPF)UserPF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerPF)registerPF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }

    ActionInterface obj = new ActionInterface();


    /**
     * This function builds the welcome page of the playground owner
     */
    private void ownerOptions() {
        frame = new JFrame();
        frame.setTitle("GoFo");
        frame.setSize(300, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocation(650, 200);

        ownerHome = new JPanel();
        ownerHome.setVisible(true);
        ownerHome.setLayout(null);
        ownerHome.setBackground(new java.awt.Color(105,105,105));

        header = new JLabel("WELCOME");
        header.setForeground(Color.WHITE);
        header.setFont (header.getFont ().deriveFont (23f));
        header.setBounds(80, 50, 130, 50);

        addPgButton = new JButton("Add Playground");
        updatePgButton = new JButton("Update Playground");
        vBookingButton = new JButton("View Bookings");
        eWalletButton = new JButton("Status & eWallet");

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

        Logout2 = new JLabel("logout");
        Logout2.setBounds(120, 340, 130, 50);
        Logout2.setBackground(new java.awt.Color(105,105,105));
        Logout2.setForeground(Color.white);
        Logout2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 17));
        Logout2.addMouseListener(this);


        frame.add(ownerHome);
        ownerHome.add(addPgButton);
        ownerHome.add(updatePgButton);
        ownerHome.add(vBookingButton);
        ownerHome.add(eWalletButton);
        ownerHome.add(header);
        ownerHome.add(Logout2);

        addPgButton.addActionListener(obj);
        updatePgButton.addActionListener(obj);
        vBookingButton.addActionListener(obj);
        eWalletButton.addActionListener(obj);
    }

    /**
     * This function displays when the owner presses on the add playground button,
     * then he fills the information of his playground
     */
    private void toAddPlayground() {

        addPgFrame = new JFrame();
        addPgFrame.setTitle("GoFo");
        addPgFrame.setSize(300, 450);
        addPgFrame.setVisible(true);
        addPgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addPgFrame.setResizable(false);
        addPgFrame.setLocation(650, 200);

        formDetails();

        addHeader = new JLabel("Add Playground");
        addHeader.setBounds(50, 30, 180, 50);
        addHeader.setForeground(Color.WHITE);
        addHeader.setFont (addHeader.getFont ().deriveFont (23f));

        addPlaygroundButton = new JButton("Add");
        addPlaygroundButton.setBackground(new Color(255,134,0));
        addPlaygroundButton.setForeground(Color.WHITE);
        addPlaygroundButton.setBounds(100, 375, 80, 30);
        addPlaygroundButton.setVisible(true);

        addBack = new JButton("<<");
        addBack.setBounds(5, 5, 50, 30);
        addBack.setFont (addBack.getFont ().deriveFont (10f));
        addBack.setBackground(new Color(255,134,0));
        addBack.setForeground(Color.white);
        addBack.addActionListener(obj);

        addPgFrame.add(addUpdatePanel);
        addUpdatePanel.add(addPlaygroundButton);
        addUpdatePanel.add(addHeader);
        addUpdatePanel.add(addBack);

        addPlaygroundButton.addActionListener(obj);
    }


    /**
     * To check if all fields are filled or not.
     * If all fields are filled, they are stored and the request will be ok.
     * If not, the request will be error because of uncompleted information.
     */
    public void getPlaygroundData() {
        if (!nameText.getText().contentEquals("") && !locationText.getText().contentEquals("") && !sizeText.getText().contentEquals("")
                && !descriptionText.getText().contentEquals("") && !priceText.getText().contentEquals("") && !cancellationText.getText().contentEquals("")) {

            currentOwner.myPlayground.setName(nameText.getText());
            currentOwner.myPlayground.setLocation(locationText.getText());
            currentOwner.myPlayground.setSize(Double.parseDouble(sizeText.getText()));
            currentOwner.myPlayground.setDescription(descriptionText.getText());
            currentOwner.myPlayground.setPricePerHour(Double.parseDouble(priceText.getText()));
            currentOwner.myPlayground.setCancellationPeriod(Integer.parseInt(cancellationText.getText()));
            currentOwner.myPlayground.playgroundOwner = currentOwner;
            currentOwner.request = "ok";
        }
        else {
            currentOwner.request = "error";
        }
    }

    /**
     * This function displays when the owner presses on the update playground button,
     * Then he can show or modify his playground information.
     */
    public void updatePlayground() {

        updateFrame = new JFrame();
        updateFrame.setTitle("GoFo");
        updateFrame.setSize(300, 450);
        updateFrame.setVisible(true);
        updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateFrame.setResizable(false);
        updateFrame.setLocation(650, 200);

        formDetails();

        updateHeader = new JLabel("Update Playground");
        updateHeader.setForeground(Color.WHITE);
        updateHeader.setBounds(30, 25, 220, 50);

        updateButton = new JButton("Update");
        updateButton.setBackground(new Color(255,134,0));
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(100, 375, 80, 30);
        updateButton.setVisible(true);
        addPlaygroundButton.setVisible(false);

        updateBack = new JButton("<<");
        updateBack.setBounds(5, 5, 50, 30);
        updateBack.setFont (updateBack.getFont ().deriveFont (10f));
        updateBack.setBackground(new Color(255,134,0));
        updateBack.setForeground(Color.white);
        updateBack.addActionListener(obj);

        String str;

        nameText.setText(currentOwner.myPlayground.getName());
        locationText.setText(currentOwner.myPlayground.getLocation());
        str = String.valueOf(currentOwner.myPlayground.getSize());
        sizeText.setText(str);
        descriptionText.setText(currentOwner.myPlayground.getDescription());
        str = String.valueOf(currentOwner.myPlayground.getPricePerHour());
        priceText.setText(str);
        str = String.valueOf(currentOwner.myPlayground.getCancellationPeriod());
        cancellationText.setText(str);

        updateFrame.add(addUpdatePanel);
        addUpdatePanel.add(updateButton);
        addUpdatePanel.add(updateHeader);
        addUpdatePanel.add(updateBack);

        updateButton.addActionListener(obj);
    }

    /**
     * If the admin approved the playground, the playground is stored in the array list
     */
    private void approvedAddPlayground() {
        AvailablePlaygrounds.playgrounds.add(currentOwner.myPlayground);
        currentOwner.myPlayground.setId(AvailablePlaygrounds.playgrounds.size());
    }

    /**
     * If the admin approved the playground update, the playground is modified in the array list
     */
    private void approvedUpdatePlayground() {
        int index = currentOwner.myPlayground.getId();
        AvailablePlaygrounds.playgrounds.set(index-1,currentOwner.myPlayground);
    }

    /**
     * To build the window of the add playground button and update playground button.
     */
    private void formDetails() {


        addUpdatePanel = new JPanel();
        addUpdatePanel.setVisible(true);
        addUpdatePanel.setBackground(new java.awt.Color(105,105,105));
        addUpdatePanel.setLayout(null);

        PgNameLabel = new JLabel("Name");
        locationLabel = new JLabel("Location");
        sizeLabel = new JLabel("Size");
        descriptionLabel = new JLabel("Description");
        priceLabel = new JLabel("Price Per Hour");
        cancellationLabel = new JLabel("Cancellation Period");
        addSlots = new JLabel("Add Slots");

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

        nameText = new JTextField();
        locationText = new JTextField();
        sizeText = new JTextField();
        descriptionText = new JTextField();
        priceText = new JTextField();
        cancellationText = new JTextField();

        nameText.setBounds(40, 90, 200, 20);
        locationText.setBounds(40, 130, 200, 20);
        sizeText.setBounds(40, 170, 200, 20);
        descriptionText.setBounds(40, 210, 200, 20);
        priceText.setBounds(40, 250, 200, 20);
        cancellationText.setBounds(40, 290, 200, 20);

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

    /**
     * to build add slot frame
     */
    public void addSlotsFrame() {
        slotsFrame = new JFrame();
        slotsFrame.setTitle("GoFo");
        slotsFrame.setSize(300, 450);
        slotsFrame.setVisible(true);
        slotsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        slotsFrame.setResizable(false);
        slotsFrame.setLocation(650, 200);

        slotsPanel = new JPanel();
        slotsPanel.setVisible(true);
        slotsPanel.setBackground(new java.awt.Color(105,105,105));
        slotsPanel.setLayout(null);

        slotsHeader = new JLabel("Add Slots");
        slotsHeader.setBounds(90, 25, 220, 50);
        slotsHeader.setForeground(Color.WHITE);
        slotsHeader.setFont (slotsHeader.getFont ().deriveFont (15f));

        dayLabel = new JLabel("Day");
        dayLabel.setBounds(60, 110, 80, 30);
        dayLabel.setFont (dayLabel.getFont ().deriveFont (12f));
        dayLabel.setForeground(Color.WHITE);

        fromLabel = new JLabel("From");
        fromLabel.setBounds(60, 150, 80, 30);
        fromLabel.setFont (fromLabel.getFont ().deriveFont (12f));
        fromLabel.setForeground(Color.WHITE);

        toLabel= new JLabel("To");
        toLabel.setBounds(60, 190, 80, 30);
        toLabel.setFont (toLabel.getFont ().deriveFont (12f));
        toLabel.setForeground(Color.WHITE);

        done = new JButton("Done");
        done.setBackground(new Color(255,134,0));
        done.setForeground(Color.WHITE);
        done.setBounds(100, 340, 80, 30);

        dayText = new JTextField();
        fromText = new JTextField();
        toText = new JTextField();

        dayText.setBounds(100, 110, 80, 30);
        fromText.setBounds(100, 150, 80, 30);
        toText.setBounds(100, 190, 80, 30);

        slotsFrame.add(slotsPanel);
        slotsPanel.add(slotsHeader);
        slotsPanel.add(dayLabel);
        slotsPanel.add(fromLabel);
        slotsPanel.add(toLabel);
        slotsPanel.add(done);
        slotsPanel.add(dayText);
        slotsPanel.add(fromText);
        slotsPanel.add(toText);

        done.addActionListener(obj);
    }

    /**
     * take owner's inputs to set slot to his playground
     */
    public void storeSlots() {
        if (!dayText.getText().contentEquals("") && !fromText.getText().contentEquals("") && !toText.getText().contentEquals("")) {
            TimeSlot slot = new TimeSlot();
            slot.setDay(dayText.getText());
            slot.setStartTime(Integer.parseInt(fromText.getText()));
            slot.setEndTime(Integer.parseInt(toText.getText()));
            currentOwner.myPlayground.timeSlot.add(slot);
        }
    }

    /**
     * This function displays when the owner presses on the vie bookings button,
     * and it displays the bookings of the owner playground.
     */
    public void viewBookings() {
        bookingFrame = new JFrame();
        bookingFrame.setTitle("GoFo");
        bookingFrame.setSize(300, 450);
        bookingFrame.setVisible(true);
        bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookingFrame.setLocation(650, 200);

        vBookingPanel = new JPanel();
        vBookingPanel.setVisible(true);
        vBookingPanel.setBackground(new java.awt.Color(105,105,105));
        vBookingPanel.setLayout(null);

        JList list = new JList(currentOwner.bookingHistory);
        class MyCellRenderer extends DefaultListCellRenderer {
            public static final String HTML_1 = "<html><body style='width: ";
            public static final String HTML_2 = "px'>";
            public static final String HTML_3 = "</html>";
            private int width;

            public MyCellRenderer(int width) {
                this.width = width;
            }

            @Override
            public Component getListCellRendererComponent(JList list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                String text = HTML_1 + String.valueOf(width) + HTML_2 + value.toString()
                        + HTML_3;
                return super.getListCellRendererComponent(list, text, index, isSelected,
                        cellHasFocus);
            }

        }

        list.setBackground(Color.WHITE);
        list.setForeground(Color.black);
        list.setBounds(10, 130, 265, 200);
        MyCellRenderer cellRenderer = new MyCellRenderer(200);
        list.setCellRenderer(cellRenderer);

        bookingHeader = new JLabel("Bookings");
        bookingHeader.setBounds(100, 50, 180, 50);
        bookingHeader.setForeground(Color.WHITE);

        bookingBack = new JButton("<<");
        bookingBack.setBounds(5, 5, 50, 30);
        bookingBack.setFont (bookingBack.getFont ().deriveFont (10f));
        bookingBack.setBackground(new Color(255,134,0));
        bookingBack.setForeground(Color.white);
        bookingBack.addActionListener(obj);

        bookingFrame.add(vBookingPanel);
        vBookingPanel.add(bookingBack);
        vBookingPanel.add(list);
        vBookingPanel.add(bookingHeader);
    }

    /**
     * This function to store bookings slots into 'data' array
     */
    private void storeSlotsTitle() {
        currentOwner.slots.clear();
        for (int i = 0 ; i < currentOwner.bookingHistory.size() ; i++) {
            currentOwner.slots.add(currentOwner.bookingHistory.get(i).item.timeSlot.getDay() + "From " + String.valueOf(currentOwner.bookingHistory.get(i).item.timeSlot.getStartTime()) + " to "
                    + String.valueOf(currentOwner.bookingHistory.get(i).item.timeSlot.getEndTime()));
        }
    }

    /**
     * This function displays when the owner presses on the update playground button,
     * and it displays the statue of the owner eWallet.
     */
    public void checkEwallet() {
        eWalletFrame = new JFrame();
        eWalletFrame.setTitle("GoFo");
        eWalletFrame.setSize(300, 450);
        eWalletFrame.setVisible(true);
        eWalletFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eWalletFrame.setResizable(false);
        eWalletFrame.setLocation(650, 200);

        eWalletPanel = new JPanel();
        eWalletPanel.setVisible(true);
        eWalletPanel.setBackground(new java.awt.Color(105,105,105));
        eWalletPanel.setLayout(null);

        eWalletHeader = new JLabel("eWallet");
        eWalletHeader.setForeground(Color.WHITE);
        eWalletHeader.setBounds(80, 50, 130, 50);

        String str;
        lmoney = new JLabel();
        lid = new JLabel();

        str = "Your Money: " + String.valueOf(currentOwner.getUserEwallet().getCurrentMoney());
        lmoney.setText(str);
        str = "Your eWallet ID: " + String.valueOf(currentOwner.getUserEwallet().getId());
        lid.setText(str);

        lmoney.setBounds(50, 120, 150, 50);
        lid.setBounds(50, 150, 150, 50);

        lmoney.setForeground(Color.WHITE);
        lid.setForeground(Color.WHITE);

        eWalletBack = new JButton("<<");
        eWalletBack.setBounds(5, 5, 50, 30);
        eWalletBack.setFont (eWalletBack.getFont ().deriveFont (10f));
        eWalletBack.setBackground(new Color(255,134,0));
        eWalletBack.setForeground(Color.white);
        eWalletBack.addActionListener(obj);

        eWalletFrame.add(eWalletPanel);
        eWalletPanel.add(eWalletHeader);
        eWalletPanel.add(lmoney);
        eWalletPanel.add(lid);
        eWalletPanel.add(eWalletBack);
    }


    /**
     *This function sends email with verification code to the user via gmail smtp server
     *
     */
    public void mail(String to,String code,String name){


        // Recipient's email ID needs to be mentioned.
        String from="rahma.y9079@gmail.com";
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "**********");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("This is the Subject Line!");
            // Now set the actual message
            message.setText("Hey"+ name+"\n" +
                    " here is your authentication code for GOFO Account\n" + code+"\n\n"+ "best regards\n");
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    /**
     *this function handles email validation errors
     *@param email is the user's email input
     */
    private boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&-]+)@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    /**
     * this function displays player options
     */
    public void playerOptions(){
        PlayerOptionsFrame = new JFrame();
        PlayerOptionsFrame.setTitle("Player options");
        PlayerOptionsFrame.setResizable(false);
        PlayerOptionsFrame.setVisible(true);
        PlayerOptionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayerOptionsFrame.setLayout(null);
        PlayerOptionsFrame.setSize(400,465);
        PlayerOptionsFrame.setLocation(500,100);
        PlayerOptionsFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));


        welcomePlayer = new JLabel("Welcome " + currentPlayer.getName(),SwingConstants.CENTER);
        welcomePlayer.setBackground(new java.awt.Color(105,105,105));
        welcomePlayer.setForeground(Color.white);
        welcomePlayer.setBounds(5,0,375,70);
        welcomePlayer.setFont(new Font("Serif", Font.BOLD, 28));


        playerOptionsLabelOne = new JLabel("Book suitable playgrounds",SwingConstants.CENTER);
        playerOptionsLabelOne.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelOne.setForeground(Color.white);
        playerOptionsLabelOne.setBounds(5,85,375,70);
        playerOptionsLabelOne.setBorder(orangeBorder);
        playerOptionsLabelOne.setFont(new Font("Serif", Font.BOLD, 18));
        playerOptionsLabelOne.addMouseListener(this);


        playerOptionsLabelTwo = new JLabel("Show your booking history",SwingConstants.CENTER);
        playerOptionsLabelTwo.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelTwo.setForeground(Color.white);
        playerOptionsLabelTwo.setBounds(5,160,375,70);
        playerOptionsLabelTwo.setBorder(orangeBorder);
        playerOptionsLabelTwo.setFont(new Font("Serif", Font.BOLD, 18));
        playerOptionsLabelTwo.addMouseListener(this);

        playerOptionsLabelthree = new JLabel("Make new team",SwingConstants.CENTER);
        playerOptionsLabelthree.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelthree.setForeground(Color.white);
        playerOptionsLabelthree.setBounds(5,235,375,70);
        playerOptionsLabelthree.setBorder(orangeBorder);
        playerOptionsLabelthree.setFont(new Font("Serif", Font.BOLD, 18));
        playerOptionsLabelthree.addMouseListener(this);


        playerOptionsLabelFour = new JLabel("Check your friends invitations",SwingConstants.CENTER);
        playerOptionsLabelFour.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelFour.setForeground(Color.white);
        playerOptionsLabelFour.setBounds(5,310,375,70);
        playerOptionsLabelFour.setBorder(orangeBorder);
        playerOptionsLabelFour.setFont(new Font("Serif", Font.BOLD, 18));
        playerOptionsLabelFour.addMouseListener(this);


        Logout = new JLabel("logout");
        Logout.setBackground(new java.awt.Color(105,105,105));
        Logout.setForeground(Color.white);
        Logout.setBounds(315,385,70,30);
        Logout.setFont(new Font("Serif", Font.ROMAN_BASELINE, 17));
        Logout.addMouseListener(this);


        PlayerOptionsFrame.add(welcomePlayer);PlayerOptionsFrame.add(playerOptionsLabelOne);PlayerOptionsFrame.add(playerOptionsLabelTwo);
        PlayerOptionsFrame.add(playerOptionsLabelthree);PlayerOptionsFrame.add(playerOptionsLabelFour);PlayerOptionsFrame.add(Logout);
    }

    /**
     * this function display login page
     */
    public void LoginPage() {
        //TODO show options
        loginFrame = new JFrame();
        // img logo
        loginFrame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 90, 0, null);

            }
        });



        // frame handling
        loginFrame.setTitle("Welcome User");
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(null);
        loginFrame.setSize(350,570);
        loginFrame.setLocation(500,30);
        loginFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));



        UserEmailTF = new JTextField();
        UserEmailTF.setBounds(10,230,315,35);
        UserEmailTF.setBackground(new Color(128,128,128));
        UserEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        UserEmailTF.setForeground(Color.white);
        UserEmailTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        UserEmailTF.addMouseListener(this);



        UserPF = new JPasswordField();
        UserPF.setBounds(10,340,315,35);
        UserPF.setBackground(new Color(128,128,128));
        UserPF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        UserPF.setForeground(Color.white);
        UserPF.addMouseListener(this);


        PasswordLabel = new JLabel("Password: ");
        PasswordLabel.setBounds(10,290,315,35);
        PasswordLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        PasswordLabel.setForeground(Color.white);


        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        emailLabel.setBounds(10,180,315,35);
        emailLabel.setForeground(Color.WHITE);







        LoginButton = new JButton("Login");
        LoginButton.setBounds(70,435,70,35);
        LoginButton.setForeground(Color.white);
        LoginButton.setBackground(new Color(255,134,0));
        LoginButton.setFont(new Font(Font.DIALOG, Font.BOLD,13));

        NewUserLabel = new JLabel("New user?");
        NewUserLabel.setBounds(170,435,60,35);
        NewUserLabel.setForeground(Color.white);
        NewUserLabel.setFont(new Font(Font.DIALOG, Font.PLAIN,12));

        SignUpLabel = new JLabel("Sign Up");
        SignUpLabel.setBounds(240,435,50,35);
        SignUpLabel.setForeground(Color.white);
        SignUpLabel.setFont(new Font(Font.DIALOG, Font.BOLD,13));
        SignUpLabel.addMouseListener(this);


        errorInSignInLabel = new JLabel("");
        errorInSignInLabel.setBounds(70,470,180,35);
        errorInSignInLabel.setFont(new Font(Font.DIALOG, Font.PLAIN,12));
        errorInSignInLabel.setForeground(new Color(255,134,0));


        loginFrame.add(emailLabel);loginFrame.add(UserEmailTF);loginFrame.add(PasswordLabel);loginFrame.add(UserPF);
        loginFrame.add(LoginButton);loginFrame.add(NewUserLabel);loginFrame.add(SignUpLabel);loginFrame.add(errorInSignInLabel);
        LoginButton.addActionListener(obj);


    }

    /**
     * this function displays registration page
     */
    public void registerPage(){
        loginFrame.setVisible(false);
        registerFrame = new JFrame();
        registerFrame.setTitle("New Account");
        registerFrame.setResizable(false);
        registerFrame.setVisible(true);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setLayout(null);
        registerFrame.setSize(400,650+85-20);
        registerFrame.setLocation(500,0);
        registerFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));

        registerNameLabel = new JLabel("Name: ");
        registerNameLabel.setBounds(10,30,300,35);
        registerNameLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        registerNameLabel.setForeground(Color.white);

        registerNameTF = new JTextField();
        registerNameTF.setBounds(10,70,365,35);
        registerNameTF.setBackground(new Color(128,128,128));
        registerNameTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        registerNameTF.setForeground(Color.white);
        registerNameTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        registerNameTF.addMouseListener(this);


        registerEmailLabel = new JLabel("Email: ");
        registerEmailLabel.setBounds(10,115,300,35);
        registerEmailLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        registerEmailLabel.setForeground(Color.white);

        registerEmailTF = new JTextField();
        registerEmailTF.setBounds(10,155,365,35);
        registerEmailTF.setBackground(new Color(128,128,128));
        registerEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        registerEmailTF.setForeground(Color.white);
        registerEmailTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        registerEmailTF.addMouseListener(this);


        registerPasswordLabel = new JLabel("Password");
        registerPasswordLabel.setBounds(10,200,300,35);
        registerPasswordLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        registerPasswordLabel.setForeground(Color.white);

        registerPF = new JPasswordField();
        registerPF.setBounds(10,240,365,35);
        registerPF.setBackground(new Color(128,128,128));
        registerPF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        registerPF.setForeground(Color.white);
        registerPF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        registerPF.addMouseListener(this);


        registerPhoneLabel = new JLabel("Phone number:");
        registerPhoneLabel.setBounds(10,285,300,35);
        registerPhoneLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        registerPhoneLabel.setForeground(Color.white);


        registerPhoneTF = new JTextField();
        registerPhoneTF.setBounds(10,325,365,35);
        registerPhoneTF.setBackground(new Color(128,128,128));
        registerPhoneTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        registerPhoneTF.setForeground(Color.white);
        registerPhoneTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        registerPhoneTF.addMouseListener(this);

        registerLocationLabel = new JLabel("Location:");
        registerLocationLabel.setBounds(10,370,300,35);
        registerLocationLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        registerLocationLabel.setForeground(Color.white);


        registerLocationTF = new JTextField();
        registerLocationTF.setBounds(10,410,365,35);
        registerLocationTF.setBackground(new Color(128,128,128));
        registerLocationTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        registerLocationTF.setForeground(Color.white);
        registerLocationTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        registerLocationTF.addMouseListener(this);


        eWalletLabel = new JLabel("eWallet ID");
        eWalletLabel.setBounds(10,455,300,35);
        eWalletLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        eWalletLabel.setForeground(Color.white);


        registerIDTF = new JTextField();
        registerIDTF.setBounds(10,495,365,35);
        registerIDTF.setBackground(new Color(128,128,128));
        registerIDTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        registerIDTF.setForeground(Color.white);
        registerIDTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        registerIDTF.addMouseListener(this);




        SignUPButton = new JButton("Sign Up");
        SignUPButton.setBounds(142,605,100,45);
        SignUPButton.setForeground(Color.white);
        SignUPButton.setBackground(new Color(255,134,0));
        SignUPButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD,17));
        SignUPButton.addActionListener(obj);


        r1 = new JRadioButton("Player");
        r1.setBounds(10,460+85,100,30);
        r1.setBackground(new java.awt.Color(105,105,105));
        r1.setFont(new Font(Font.SANS_SERIF, Font.BOLD,12));
        r1.setActionCommand("player");
        r2 = new JRadioButton("Playground owner");
        r2.setBounds(120,460+85,200,30);
        r2.setBackground(new java.awt.Color(105,105,105));
        r2.setFont(new Font(Font.SANS_SERIF, Font.BOLD,12));
        r2.setActionCommand("owner");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);buttonGroup.add(r2);


        errorInSignUpLabel=new JLabel("");
        errorInSignUpLabel.setBounds(120,560+85,250,35);
        errorInSignUpLabel.setFont(new Font(Font.DIALOG, Font.PLAIN,14));
        errorInSignUpLabel.setForeground(new Color(255,134,0));

        registerFrame.add(registerNameLabel);registerFrame.add(registerEmailLabel);registerFrame.add(registerPasswordLabel);registerFrame.add(registerLocationLabel);registerFrame.add(registerPhoneLabel);
        registerFrame.add(registerNameTF);registerFrame.add(registerEmailTF);registerFrame.add(registerLocationTF);registerFrame.add(registerPhoneTF);registerFrame.add(registerPF);
        registerFrame.add(SignUPButton);
        registerFrame.add(r1);registerFrame.add(r2);
        registerFrame.add(errorInSignUpLabel);
        registerFrame.add(eWalletLabel);registerFrame.add(registerIDTF);


    }

    /**
     * this function displays verificationCodePage that asks user to enter the
     * code sent to his email and check if it is correct
     */
    public void verificationCodePage(){

        registerFrame.setVisible(false);
        verivicationFrame = new JFrame();
        verivicationFrame.setTitle("Account Activation");
        verivicationFrame.setResizable(false);
        verivicationFrame.setVisible(true);
        verivicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        verivicationFrame.setLayout(null);
        verivicationFrame.setSize(350,300);
        verivicationFrame.setLocation(500,100);
        verivicationFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));

        verificationLabel = new JLabel("Check your mail box and verify your account");
        verificationLabel.setBounds(20,30,350,35);
        verificationLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
        verificationLabel.setForeground(Color.white);



        codeTF = new JTextField();
        codeTF.setBounds(65,100,200,35);
        codeTF.setBackground(new Color(128,128,128));
        codeTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        codeTF.setForeground(Color.white);
        codeTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        codeTF.addMouseListener(this);

        verificationButton = new JButton("Confirm");
        verificationButton.setBounds(120,170,90,35);
        verificationButton.setForeground(Color.white);
        verificationButton.setBackground(new Color(255,134,0));
        verificationButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD,12));
        verificationButton.addActionListener(obj);

        incorrectCodeLabel = new JLabel("");
        incorrectCodeLabel.setBounds(100,215,150,35);
        incorrectCodeLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 11));
        incorrectCodeLabel.setForeground(new Color(255,134,0));

        verivicationFrame.add(codeTF);
        verivicationFrame.add(verificationButton);verivicationFrame.add(incorrectCodeLabel);
        verivicationFrame.add(verificationLabel);
    }


    /**
     * this function handles the booking operation for the player,
     * it shows available bookings, enables player to choose from them and make booking process
     */
    public void PlayerOptionOne(){
        PlayerOptionsFrame.setVisible(false);
        timeSlot = new TimeSlot();
        option1Frame = new JFrame();
        option1Frame.setResizable(false);
        option1Frame.setVisible(true);
        option1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        option1Frame.setLayout(null);
        option1Frame.setSize(500,600);
        option1Frame.setLocation(500,100);
        option1Frame.getContentPane().setBackground(new java.awt.Color(105,105,105));
        selectTimeIntervalLabel = new JLabel("Specify time interval that suits you",SwingConstants.CENTER);
        selectTimeIntervalLabel.setBounds(90,0,300,50);
        selectTimeIntervalLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        selectTimeIntervalLabel.setForeground(Color.white);
        String days[] = {"All","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        DaysList = new JComboBox(days);
        DaysList.setSelectedItem(0);
        DaysList.setBounds(42,70,100,20);
        DaysList.setBackground(new java.awt.Color(142, 138, 138));
        String time[]={"All","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
        startTimeList = new JComboBox(time);
        startTimeList.setSelectedItem(0);
        startTimeList.setBounds(142,70,100,20);
        startTimeList.setBackground(new java.awt.Color(142, 138, 138));
        endTimeList = new JComboBox(time);
        endTimeList.setSelectedItem(0);
        endTimeList.setBounds(242,70,100,20);
        endTimeList.setBackground(new java.awt.Color(142, 138, 138));
        showPlaygroundsButton = new JButton("Show");
        showPlaygroundsButton.setBackground(new java.awt.Color( 142, 138, 138));
        showPlaygroundsButton.setForeground(Color.white);
        showPlaygroundsButton.setBounds(362,70,80,20);
        showPlaygroundsButton.setFont(new Font("Serif", Font.ROMAN_BASELINE, 13));
        showPlaygroundsButton.addActionListener(obj);
        option1Frame.add(startTimeList);
        option1Frame.add(endTimeList);
        option1Frame.add(DaysList);
        option1Frame.add(selectTimeIntervalLabel);
        option1Frame.add(showPlaygroundsButton);
    }

    /**
     * this function displays booking history for player
     */
    public void PlayerOptionTwo(){
        PlayerOptionsFrame.setVisible(false);
        option2Frame = new JFrame();
        option2Frame.setTitle("");
        option2Frame.setResizable(false);
        option2Frame.setVisible(true);
        option2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        option2Frame.setLayout(null);
        option2Frame.setSize(350,450);
        option2Frame.setLocation(400,100);
        option2Frame.getContentPane().setBackground(new java.awt.Color(105,105,105));
        class MyCellRenderer extends DefaultListCellRenderer {
            public static final String HTML_1 = "<html><body style='width: ";
            public static final String HTML_2 = "px'>";
            public static final String HTML_3 = "</html>";
            private int width;
            public MyCellRenderer(int width) {
                this.width = width;
            }
            @Override
            public Component getListCellRendererComponent(JList list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                String text = HTML_1 + String.valueOf(width) + HTML_2 + value.toString()
                        + HTML_3;
                return super.getListCellRendererComponent(list, text, index, isSelected,
                        cellHasFocus);
            }
        }
        list2 = new JList(currentPlayer.bookingHistory);
        list2.setBackground(new java.awt.Color(142, 138, 138));
        JScrollPane scrollPane2 = new JScrollPane(list2);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        MyCellRenderer cellRenderer = new MyCellRenderer(200);
        list2.setCellRenderer(cellRenderer);
        scrollPane2.setBounds(5,10,325,350);
        returnToOptions = new JLabel("Back to options");
        returnToOptions.setBounds(220,380,100,20);
        returnToOptions.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        returnToOptions.setForeground(Color.white);
        returnToOptions.addMouseListener(this);
        option2Frame.add(scrollPane2);
        option2Frame.add(returnToOptions);
    }

    /**
     * this function enables player to create team
     */
    public void PlayerOptionThree(){
        PlayerOptionsFrame.setVisible(false);
        option3Frame = new JFrame();
        option3Frame.setTitle("");
        option3Frame.setResizable(false);
        option3Frame.setVisible(true);
        option3Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        option3Frame.setLayout(null);
        option3Frame.setSize(350,350);
        option3Frame.setLocation(500,100);
        option3Frame.getContentPane().setBackground(new java.awt.Color(105,105,105));
        enterPlayerEmailLabel = new JLabel("Enter member email:",SwingConstants.LEFT);
        enterPlayerEmailLabel.setBounds(5,10,345,35);
        enterPlayerEmailLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        enterPlayerEmailLabel.setForeground(Color.white);
        playerEmailTF = new JTextField();
        playerEmailTF.setBounds(5,70,325,35);
        playerEmailTF.setBackground(new Color(128,128,128));
        playerEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        playerEmailTF.setForeground(Color.white);
        playerEmailTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        playerEmailTF.addMouseListener(this);
        addButton = new JButton("Add");
        addButton.setBounds(125,140,80,45);
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color(255,134,0));
        addButton.setFont(new Font(Font.DIALOG, Font.BOLD,13));
        addButton.addActionListener(obj);
        teamFormationMsgLabel = new JLabel("",SwingConstants.CENTER);
        teamFormationMsgLabel.setBounds(90,210,150,35);
        teamFormationMsgLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        teamFormationMsgLabel.setForeground(new Color(255,134,0));
        returnToOptions3 = new JLabel("Back to options");
        returnToOptions3.setBounds(200,270,100,20);
        returnToOptions3.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        returnToOptions3.setForeground(Color.white);
        returnToOptions3.addMouseListener(this);
        option3Frame.add(enterPlayerEmailLabel);option3Frame.add(playerEmailTF);option3Frame.add(addButton);option3Frame.add(teamFormationMsgLabel);
        option3Frame.add(returnToOptions3);
    }

    /**
     * this function shows notification of a member team
     */
    public void PlayerOptionFour(){
        PlayerOptionsFrame.setVisible(false);
        option4Frame = new JFrame();
        option4Frame.setTitle("");
        option4Frame.setResizable(false);
        option4Frame.setVisible(true);
        option4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        option4Frame.setLayout(null);
        option4Frame.setSize(300,300);
        option4Frame.setLocation(400,100);
        option4Frame.getContentPane().setBackground(new java.awt.Color(105,105,105));
        NotificationLabel = new JLabel("<html>" + currentPlayer.getNotification().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        NotificationLabel.setBounds(10,10,265,220);
        NotificationLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        NotificationLabel.setForeground(Color.white);
        NotificationLabel.setBorder(border);


        returnToOptions4 = new JLabel("Back to options");
        returnToOptions4.setBounds(170,235,100,20);
        returnToOptions4.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        returnToOptions4.setForeground(Color.white);
        returnToOptions4.addMouseListener(this);
        option4Frame.add(NotificationLabel);option4Frame.add(returnToOptions4);
    }

    /**
     * this function shows count down timer initialized by the cancellation period and
     * a cancel button to cancel the booking process
     */
    public void showBookingInfo(Booking booking){

        System.out.println("player money"+currentPlayer.getUserEwallet().getCurrentMoney());
        System.out.println("booking money" + booking.bookingWallet.getCurrentMoney());


        showBookingInfoFrame = new JFrame();
        showBookingInfoFrame.setResizable(false);
        showBookingInfoFrame.setVisible(true);
        showBookingInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showBookingInfoFrame.setLayout(null);
        showBookingInfoFrame.setSize(300,330);
        showBookingInfoFrame.setLocation(500,100);
        showBookingInfoFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));


        calcellationPeriodLabel = new JLabel("Cancellation period ends in",SwingConstants.CENTER);
        calcellationPeriodLabel.setBackground(new java.awt.Color(105,105,105));
        calcellationPeriodLabel.setForeground(Color.white);
        calcellationPeriodLabel.setBounds(5,10,270,70);
        calcellationPeriodLabel.setFont(new Font("Serif", Font.BOLD, 20));



        secondsLabel = new JLabel();
        secondsLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        secondsLabel.setBounds(150,90,80,70);
        secondsLabel.setForeground(Color.WHITE);


        minutesLabel = new JLabel();
        minutesLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        minutesLabel.setBounds(50,90,80,70);
        minutesLabel.setForeground(Color.WHITE);



        booking.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                booking.seconds--;
                secondsLabel.setText("seconds "+booking.seconds);
                minutesLabel.setText("minutes "+booking.item.cancellationPeriod);
                if(booking.seconds == 0 ){
                    booking.seconds=60;
                    booking.item.cancellationPeriod--;
                }
                if(booking.item.cancellationPeriod<0){
                    booking.seconds=0;booking.item.cancellationPeriod=0;
                    CancelButton.setVisible(false);
                    double money = booking.item.playgroundOwner.getUserEwallet().getCurrentMoney()+booking.bookingWallet.getCurrentMoney();
                    booking.item.playgroundOwner.getUserEwallet().setCurrentMoney(money);
                    booking.timer.stop();
                }
            }
        });
        booking.timer.start();


        CancelButton = new JButton("Cancel booking");
        CancelButton.setBounds(65,180,150,35);
        CancelButton.setForeground(Color.white);
        CancelButton.setBackground(new Color(255,134,0));
        CancelButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        CancelButton.addActionListener(obj);


        returnToOptions2 = new JLabel("Back to options");
        returnToOptions2.setBounds(180,240,100,20);
        returnToOptions2.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        returnToOptions2.setForeground(Color.white);
        returnToOptions2.addMouseListener(this);


        showBookingInfoFrame.add(secondsLabel);showBookingInfoFrame.add(minutesLabel);showBookingInfoFrame.add(CancelButton);showBookingInfoFrame.add(calcellationPeriodLabel);
        showBookingInfoFrame.add(returnToOptions2);

    }


    private class ActionInterface implements ActionListener {

        /**
         * this function handles all button action events in the application
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String accountType="";

            if(r1.isSelected()) accountType="p";
            if(r2.isSelected()) accountType="o";
            if(e.getSource() == SignUPButton ){

                tmpName = registerNameTF.getText().toString();
                tmpEmail = registerEmailTF.getText().toString();
                tmpPassword =new String(registerPF.getPassword());
                tmpPhone = registerPhoneTF.getText().toString();
                tmpLocation = registerLocationTF.getText().toString();
                tmpID = registerIDTF.getText().toString();

                if(tmpEmail.equals("")|| tmpLocation.equals("")||tmpName.equals("")||tmpPassword.equals("")||tmpPhone.equals("") || accountType.equals("") || tmpID.equals("")) errorInSignUpLabel.setText("Please enter all sections");
                else if(isValid(tmpEmail)){
                    generatedCode = (int) (Math.random() * (89467892 - 34278564 + 1)) + 34278564;
                    // mail(tmpEmail,String.valueOf(generatedCode),tmpName);
                    System.out.println(generatedCode);
                    registerFrame.setVisible(false);
                    verificationCodePage();
                }
                else{
                    errorInSignUpLabel.setText("Invalid email address");
                }

            }
            if(e.getSource() == LoginButton) {
                String email = UserEmailTF.getText().toString();
                String password = new String(UserPF.getPassword());

                boolean foundInPlayer=false,foundInOwner=false;
                for(Player player1:Account.Players){

                    if(player1.getEmail().equals(email) && player1.getPassword().equals(password)){
                        currentPlayer = player1;
                        playerOptions();
                        errorInSignInLabel.setText("");
                        loginFrame.setVisible(false);
                        return;
                    }
                }
                for( PlaygroundOwner playgroundOwner1:Account.Owners){

                    if(playgroundOwner1.getEmail().equals(email) && playgroundOwner1.getPassword().equals(password)){
                        currentOwner = playgroundOwner1;
                        ownerOptions();
                        errorInSignInLabel.setText("");
                        loginFrame.setVisible(false);
                        return;
                    }
                }
                //if(!(foundInPlayer||foundInOwner))
                errorInSignInLabel.setText("Incorrect email or password");

            }
            if(e.getSource()==verificationButton){

                String enteredCode = codeTF.getText().toString();
                if(enteredCode.equals(String.valueOf(generatedCode))){

                    if(accountType.equals("p")){
                        Player player = new Player();
                        player.setName(tmpName);player.setPassword(tmpPassword);player.setEmail(tmpEmail);player.setPhone(tmpPhone);player.setLocation(tmpLocation);player.getUserEwallet().setId(tmpID);
                        Account.Players.add(player);
                        currentPlayer = player;
                        playerOptions();
                    }
                    else {
                        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
                        playgroundOwner.setName(tmpName);playgroundOwner.setPassword(tmpPassword);playgroundOwner.setEmail(tmpEmail);playgroundOwner.setPhone(tmpPhone);playgroundOwner.setLocation(tmpLocation);playgroundOwner.getUserEwallet().setId(tmpID);
                        Account.Owners.add(playgroundOwner);
                        currentOwner = playgroundOwner;
                        ownerOptions();
                    }
                    verivicationFrame.setVisible(false);
                }
                else {
                    incorrectCodeLabel.setText("Incorrect code, try again");
                }
            }
            if (e.getSource() == addPgButton) {
                if (currentOwner.myPlayground.getId() == 0) {
                    frame.dispose();
                    toAddPlayground();
                }
            }
            if (e.getSource() == updatePgButton) {
                if (currentOwner.myPlayground.getId() != 0) {
                    frame.dispose();
                    updatePlayground();
                }
            }
            if (e.getSource() == vBookingButton) {
                frame.dispose();
                storeSlotsTitle();
                viewBookings();
            }
            if (e.getSource() == eWalletButton) {
                frame.dispose();
                checkEwallet();
            }
            if (e.getSource() == addPlaygroundButton) {
                addPgFrame.dispose();
                getPlaygroundData();
                ownerOptions();
                if (Administrator.approvePlayground(currentOwner.request)) {
                    approvedAddPlayground();
                }
            }
            if (e.getSource() == updateButton) {
                updateFrame.dispose();
                getPlaygroundData();
                ownerOptions();
                if (Administrator.approvePlayground(currentOwner.request)) {
                    approvedUpdatePlayground();
                }
            }
            if (e.getSource() == done) {
                storeSlots();
                slotsFrame.dispose();
            }
            if (e.getSource() == addBack) {
                addPgFrame.dispose();
                ownerOptions();
            }
            if (e.getSource() == updateBack) {
                updateFrame.dispose();
                ownerOptions();
            }
            if (e.getSource() == bookingBack) {
                bookingFrame.dispose();
                ownerOptions();
            }
            if (e.getSource() == eWalletBack) {
                eWalletFrame.dispose();
                ownerOptions();
            }
            if(e.getSource() == addButton){
                String mail = playerEmailTF.getText().toString();
                boolean found=false;
                for(Player player:Account.Players){
                    if(player.getEmail().equals(mail)){
                        found=true;
                        currentPlayer.team = new Team();
                        currentPlayer.team.teamList.add(player);
                        teamFormationMsgLabel.setText("Added successfully");
                        break;
                    }
                }
                if(!found) teamFormationMsgLabel.setText("Player not found");
            }
            if(e.getSource()==showPlaygroundsButton){
                String day = (String)DaysList.getSelectedItem();
                if( day.equals("All") ) timeSlot = null;
                else{
                    timeSlot.setDay((String)DaysList.getSelectedItem());
                    String st = (String)startTimeList.getSelectedItem();
                    String end=(String)endTimeList.getSelectedItem();
                    timeSlot.setStartTime(Integer.valueOf(st));
                    timeSlot.setEndTime(Integer.valueOf(end));
                }

                AvailablePlaygrounds availablePlaygrounds = new AvailablePlaygrounds();
                availablePlaygrounds.fillItemsVector(timeSlot);
                class MyCellRenderer extends DefaultListCellRenderer {
                    public static final String HTML_1 = "<html><body style='width: ";
                    public static final String HTML_2 = "px'>";
                    public static final String HTML_3 = "</html>";
                    private int width;

                    public MyCellRenderer(int width) {
                        this.width = width;
                    }

                    @Override
                    public Component getListCellRendererComponent(JList list, Object value,
                                                                  int index, boolean isSelected, boolean cellHasFocus) {
                        String text = HTML_1 + String.valueOf(width) + HTML_2 + value.toString()
                                + HTML_3;
                        return super.getListCellRendererComponent(list, text, index, isSelected,
                                cellHasFocus);
                    }

                }
                list1 = new JList(AvailablePlaygrounds.items);
                list1.setBackground(new java.awt.Color(142, 138, 138));
                scrollPane = new JScrollPane(list1);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                MyCellRenderer cellRenderer = new MyCellRenderer(200);
                list1.setCellRenderer(cellRenderer);
                scrollPane.setBounds(5,110,475,350);

                checkBox= new JCheckBox("Invite your team");
                checkBox.setBounds(340,500,120,20);
                checkBox.setBackground(new java.awt.Color(105,105,105));
                option1Frame.add(checkBox);
                checkBox.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange()==1) checked = true;
                    }
                });

                confirmBooking = new JButton("Confirm");
                confirmBooking.setBackground(new java.awt.Color(255,134,0 ));
                confirmBooking.setForeground(Color.white);
                confirmBooking.setBounds(190,490,100,45);
                confirmBooking.setFont(new Font("Serif", Font.ROMAN_BASELINE, 17));
                confirmBooking.addActionListener(obj);

                option1Frame.add(scrollPane);
                option1Frame.add(confirmBooking);
            }
            if(e.getSource()==confirmBooking){
                ItemIndex = list1.getSelectedIndex();
                System.out.println(ItemIndex);
                Booking booking = new Booking();
                int numOfHours;
                //if(timeSlot!=null)numOfHours = (timeSlot.getEndTime() - timeSlot.getStartTime());
                numOfHours = AvailablePlaygrounds.items.get(ItemIndex).timeSlot.getEndTime()-AvailablePlaygrounds.items.get(ItemIndex).timeSlot.getStartTime();
                booking.Price = AvailablePlaygrounds.items.get(ItemIndex).pricePerHour *numOfHours;
                if(currentPlayer.getUserEwallet().getCurrentMoney() >=booking.Price){
                    System.out.println("player has enough money");
                    booking.item=AvailablePlaygrounds.items.get(ItemIndex);
                    currentPlayer.bookingHistory.add(booking);
                    booking.item.playgroundOwner.bookingHistory.add(booking);
                    currentPlayer.getUserEwallet().setCurrentMoney(currentPlayer.getUserEwallet().getCurrentMoney()-booking.Price);
                    booking.bookingWallet.setCurrentMoney(booking.Price);
                    AvailablePlaygrounds.playgrounds.get(booking.item.i).Available[booking.item.j] = false;
                    System.out.println("gonna show booking info");
                    showBookingInfo(booking);
                    System.out.println("must be showed");
                    option1Frame.setVisible(false);
                }

                if(checked){
                    for(Player player:currentPlayer.team.teamList){
                        notification = currentPlayer.getName()+"Invites you to play\n playground info: "+booking.item.toString();
                        player.setNotification(notification);
                    }
                }

            }
            if(e.getSource()==CancelButton){

                //money handling
                Booking booking = currentPlayer.bookingHistory.get(currentPlayer.bookingHistory.size()-1);
                booking.bookingWallet.setCurrentMoney(0);
                currentPlayer.getUserEwallet().setCurrentMoney(currentPlayer.getUserEwallet().getCurrentMoney()+booking.Price);
                System.out.println("booking price after cancellation"+ booking.Price);
                System.out.println("player money after cancellation" + currentPlayer.getUserEwallet().getCurrentMoney());

                // booking history removing
                PlaygroundOwner playgroundOwner;
                System.out.println("player booking history"+currentPlayer.bookingHistory.size());
                playgroundOwner = AvailablePlaygrounds.items.get(ItemIndex).playgroundOwner;
                currentPlayer.bookingHistory.remove(currentPlayer.bookingHistory.size()-1);
                System.out.println("player booking history"+currentPlayer.bookingHistory.size());

                System.out.println("owner booking history"+playgroundOwner.bookingHistory.size());
                playgroundOwner.bookingHistory.remove(playgroundOwner.bookingHistory.size()-1);
                System.out.println("owner booking history"+playgroundOwner.bookingHistory.size());
                Item item = AvailablePlaygrounds.items.get(ItemIndex);

                // this slot is now available
                AvailablePlaygrounds.playgrounds.get(item.i).Available[item.j] = true;

                playerOptions();
            }
        }
    }

}

