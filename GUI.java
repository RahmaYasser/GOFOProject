package GOFO2;




import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.Timer;

import static GOFO2.Main.currentOwner;
import static GOFO2.Main.currentPlayer;


public class GUI extends JFrame implements MouseListener{
    private JFrame jFrameShowPlayGround;
    private Border border = BorderFactory.createLineBorder(Color.white, 1);
    private Border orangeBorder = BorderFactory.createLineBorder(new Color(255,134,0),2);
    private JTextField UserEmailTF,registerNameTF,registerEmailTF,registerPhoneTF,registerLocationTF,codeTF,registerIDTF;
    private JPasswordField UserPF,registerPF;
    private JLabel emailLabel,PasswordLabel,bookingNameLabel,bookingLocationLabel,bookingStTimeLabel,bookingEndTimeLabel,bookingDayLabel,bookingPriceLabel;
    private JLabel NewUserLabel,SignUpLabel,registerNameLabel,registerEmailLabel,registerPasswordLabel,registerPhoneLabel;
    private JLabel registerLocationLabel, errorInSignInLabel,errorInSignUpLabel,incorrectCodeLabel,verificationLabel,eWalletLabel;
    private JLabel m,h,s,welcomePlayer,Logout,selectTimeIntervalLabel;
    private JLabel playerOptionsLabelOne, playerOptionsLabelTwo, playerOptionsLabelthree, playerOptionsLabelFour;
    private JButton LoginButton, SignUPButton,verificationButton,StartButton,Back,showPlaygroundsButton,confirmBooking,selectButton;
    private Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahma Yasser\\Desktop\\logotrans.png");
    private JRadioButton r1,r2;
    private ButtonGroup buttonGroup;
    private JComboBox DaysList,startTimeList,endTimeList;
    private JScrollPane scrollPane;
    private JList list1,list2;
    static int miliseconds=0,seconds=3,minutes=0,hours=0,ItemIndex=0,BookingIndex=0;
    static boolean state;
    Timer timer;
    TimeSlot timeSlot;

    ActionInterface obj = new ActionInterface();


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

                return new PasswordAuthentication(from, "*********");

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


    private boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }



    public GUI() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        if(e.getSource()==playerOptionsLabelOne){
            PlayerOptionOne();
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
        if(e.getSource() == UserEmailTF) UserEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerNameTF)registerNameTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerEmailTF)registerEmailTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerPhoneTF)registerPhoneTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerLocationTF)registerLocationTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == UserPF)UserPF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == registerPF)registerPF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if(e.getSource() == playerOptionsLabelOne) {

        }


    }


    public void playerOptions(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Player options");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(400,465);
        jFrame.setLocation(500,100);
        jFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));


        welcomePlayer = new JLabel("Welcome " + currentPlayer.getName(),SwingConstants.CENTER);
        welcomePlayer.setBackground(new java.awt.Color(105,105,105));
        welcomePlayer.setForeground(Color.white);
        welcomePlayer.setBounds(5,0,375,70);
        //welcomePlayer.setBorder(border);
        welcomePlayer.setFont(new Font("Serif", Font.BOLD, 28));


        playerOptionsLabelOne = new JLabel("Book suitable playgrounds",SwingConstants.CENTER);
        playerOptionsLabelOne.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelOne.setForeground(Color.white);
        playerOptionsLabelOne.setBounds(5,85,375,70);
        playerOptionsLabelOne.setBorder(orangeBorder);
        playerOptionsLabelOne.setFont(new Font("Serif", Font.BOLD, 18));


        playerOptionsLabelTwo = new JLabel("Show your booking history",SwingConstants.CENTER);
        playerOptionsLabelTwo.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelTwo.setForeground(Color.white);
        playerOptionsLabelTwo.setBounds(5,160,375,70);
        playerOptionsLabelTwo.setBorder(orangeBorder);
        playerOptionsLabelTwo.setFont(new Font("Serif", Font.BOLD, 18));


        playerOptionsLabelthree = new JLabel("Make new team",SwingConstants.CENTER);
        playerOptionsLabelthree.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelthree.setForeground(Color.white);
        playerOptionsLabelthree.setBounds(5,235,375,70);
        playerOptionsLabelthree.setBorder(orangeBorder);
        playerOptionsLabelthree.setFont(new Font("Serif", Font.BOLD, 18));



        playerOptionsLabelFour = new JLabel("Check your friends invitations",SwingConstants.CENTER);
        playerOptionsLabelFour.setBackground(new java.awt.Color(105,105,105));
        playerOptionsLabelFour.setForeground(Color.white);
        playerOptionsLabelFour.setBounds(5,310,375,70);
        playerOptionsLabelFour.setBorder(orangeBorder);
        playerOptionsLabelFour.setFont(new Font("Serif", Font.BOLD, 18));

        Logout = new JLabel("logout");
        Logout.setBackground(new java.awt.Color(105,105,105));
        Logout.setForeground(Color.white);
        Logout.setBounds(315,385,70,30);
        Logout.setFont(new Font("Serif", Font.ROMAN_BASELINE, 17));



        jFrame.add(welcomePlayer);jFrame.add(playerOptionsLabelOne);jFrame.add(playerOptionsLabelTwo);
        jFrame.add(playerOptionsLabelthree);jFrame.add(playerOptionsLabelFour);jFrame.add(Logout);
    }
    public void Timer(){
        //JFrame jFrame = new JFrame();
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Timer");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(400,400);
        jFrame.setLocation(500,100);
        jFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));

        StartButton = new JButton("Start");
        StartButton.setBounds(142,200,100,45);
        StartButton.setForeground(Color.white);
        StartButton.setBackground(new Color(255,134,0));
        StartButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD,17));
        StartButton.addActionListener(obj);

        m = new JLabel("Minutes");
        m.setBounds(10,30,30,30);
        m.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        m.setForeground(Color.white);


        h = new JLabel("Hours");
        h.setBounds(50,30,30,35);
        h.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        h.setForeground(Color.white);



        s = new JLabel("sec");
        s.setBounds(90,30,30,35);
        s.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        s.setForeground(Color.white);

        Back = new JButton("Back");
        Back.setBounds(142,300,100,45);
        Back.setForeground(Color.white);
        Back.setBackground(new Color(255,134,0));
        Back.setFont(new Font(Font.SANS_SERIF, Font.BOLD,17));
        Back.addActionListener(obj);

        jFrame.add(s); jFrame.add(m);jFrame.add(h);jFrame.add(StartButton);jFrame.add(Back);
    }
    public void LoginPage(){
        //TODO show options

        // img logo
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 90, 0, null);

            }
        });





        // frame handling
        setTitle("Welcome User");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(350,570);
        setLocation(500,30);
        this.getContentPane().setBackground(new java.awt.Color(105,105,105));



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


        this.add(emailLabel);this.add(UserEmailTF);this.add(PasswordLabel);this.add(UserPF);this.add(LoginButton);this.add(NewUserLabel);this.add(SignUpLabel);this.add(errorInSignInLabel);



        LoginButton.addActionListener(obj);


    }
    public void registerPage(){

        JFrame jFrame = new JFrame();
        jFrame.setTitle("New Account");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(400,650+85-20);
        jFrame.setLocation(500,100);
        jFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));

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


        eWalletLabel = new JLabel("ID");
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

        jFrame.add(registerNameLabel);jFrame.add(registerEmailLabel);jFrame.add(registerPasswordLabel);jFrame.add(registerLocationLabel);jFrame.add(registerPhoneLabel);
        jFrame.add(registerNameTF);jFrame.add(registerEmailTF);jFrame.add(registerLocationTF);jFrame.add(registerPhoneTF);jFrame.add(registerPF);
        jFrame.add(SignUPButton);
        jFrame.add(r1);jFrame.add(r2);
        jFrame.add(errorInSignUpLabel);
        jFrame.add(eWalletLabel);jFrame.add(registerIDTF);


    }
    public void verificationCodePage(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Account Activation");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(350,300);
        jFrame.setLocation(500,100);
        jFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));

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

        jFrame.add(codeTF);
        jFrame.add(verificationButton);jFrame.add(incorrectCodeLabel);
        jFrame.add(verificationLabel);
    }
    public void PlayerOptionOne(){
        timeSlot = new TimeSlot();



        jFrameShowPlayGround = new JFrame();
        jFrameShowPlayGround.setResizable(false);
        jFrameShowPlayGround.setVisible(true);
        jFrameShowPlayGround.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameShowPlayGround.setLayout(null);
        jFrameShowPlayGround.setSize(500,600);
        jFrameShowPlayGround.setLocation(500,100);
        jFrameShowPlayGround.getContentPane().setBackground(new java.awt.Color(105,105,105));

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




        jFrameShowPlayGround.add(startTimeList);jFrameShowPlayGround.add(endTimeList);jFrameShowPlayGround.add(DaysList);
        jFrameShowPlayGround.add(selectTimeIntervalLabel);jFrameShowPlayGround.add(showPlaygroundsButton);
    }


    public void PlayerOptionTwo(){


        JFrame jFrame = new JFrame();
        jFrame.setTitle("");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(500,500);
        jFrame.setLocation(500,100);
        jFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));


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
        scrollPane2.setBounds(5,10,475,350);


        selectButton = new JButton("Select");
        selectButton.setBackground(new java.awt.Color(255,134,0 ));
        selectButton.setForeground(Color.white);
        selectButton.setBounds(190,390,100,45);
        selectButton.setFont(new Font("Serif", Font.ROMAN_BASELINE, 17));
        selectButton.addActionListener(obj);

        jFrame.add(scrollPane2);jFrame.add(selectButton);
    }


    public void showBookingInfo(Booking booking){
        JFrame jFrame = new JFrame();
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(500,600);
        jFrame.setLocation(500,100);
        jFrame.getContentPane().setBackground(new java.awt.Color(105,105,105));

        bookingNameLabel = new JLabel("Playground name:"+currentPlayer.bookingHistory.get(BookingIndex).item.name ,SwingConstants.LEFT);
        bookingNameLabel.setBounds(90,0,300,50);
         bookingNameLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        bookingNameLabel.setForeground(Color.white);


        bookingLocationLabel = new JLabel("Playground location:"+currentPlayer.bookingHistory.get(BookingIndex).item.location ,SwingConstants.LEFT);
        bookingLocationLabel.setBounds(90,0,300,50);
        bookingLocationLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        bookingLocationLabel.setForeground(Color.white);


        bookingDayLabel = new JLabel("Day: "+currentPlayer.bookingHistory.get(BookingIndex).item.timeSlot.getDay());
        bookingDayLabel.setBounds(90,0,300,50);
        bookingDayLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        bookingDayLabel.setForeground(Color.white);

        bookingStTimeLabel = new JLabel("Start time: "+String.valueOf(currentPlayer.bookingHistory.get(BookingIndex).item.timeSlot.getStartTime()));
        bookingStTimeLabel.setBounds(90,0,300,50);
        bookingStTimeLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        bookingStTimeLabel.setForeground(Color.white);


        bookingStTimeLabel = new JLabel("End time: "+String.valueOf(currentPlayer.bookingHistory.get(BookingIndex).item.timeSlot.getEndTime()));
        bookingStTimeLabel.setBounds(90,0,300,50);
        bookingStTimeLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        bookingStTimeLabel.setForeground(Color.white);


        bookingPriceLabel = new JLabel("Price: "+String.valueOf(currentPlayer.bookingHistory.get(BookingIndex).Price));
        bookingPriceLabel.setBounds(90,0,300,50);
        bookingPriceLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        bookingPriceLabel.setForeground(Color.white);



    }

    private class ActionInterface implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==confirmBooking){
                ItemIndex = list1.getSelectedIndex();
                System.out.println(ItemIndex);
                Booking booking = new Booking();
                booking.Price = AvailablePlaygrounds.items.get(ItemIndex).pricePerHour;// * (timeSlot.getEndTime() - timeSlot.getStartTime());
                if(currentPlayer.getUserEwallet().getCurrentMoney() >=booking.Price){
                    booking.item=AvailablePlaygrounds.items.get(ItemIndex);
                    currentPlayer.bookingHistory.add(booking);
                    currentPlayer.getUserEwallet().setCurrentMoney(currentPlayer.getUserEwallet().getCurrentMoney()-booking.Price);
                    booking.bookingWallet.setCurrentMoney(booking.Price);
                    AvailablePlaygrounds.playgrounds.get(booking.item.i).Available[booking.item.j] = false;

                }
            }
            if(e.getSource() == LoginButton) {
                String email = UserEmailTF.getText().toString();
                String password = UserPF.getPassword().toString();

                Player player=new Player();
                PlaygroundOwner playgroundOwner=new PlaygroundOwner();
                boolean foundInPlayer=false,foundInOwner=false;
                //TODO test after completing registration code
                for( int i=0;i<Account.Players.size();i++){
                    player = Account.Players.get(i);
                    if(player.getEmail().equals(email) && player.getPassword().equals(password))foundInPlayer=true;break;
                }
                for( int i=0;i<Account.Owners.size();i++){
                    playgroundOwner = Account.Owners.get(i);
                    if(playgroundOwner.getEmail().equals(email) && playgroundOwner.getPassword().equals(password))foundInOwner=true;break;
                }
                if(!(foundInPlayer||foundInOwner)) errorInSignInLabel.setText("Incorrect email or password");
                else {
                    if(foundInPlayer)currentPlayer = player;
                    else currentOwner = playgroundOwner;
                    errorInSignInLabel.setText("");
                }
                return;
            }
            String accountType="";int x=0;
            //if(r1.isSelected()) accountType="p";
            //if(r2.isSelected()) accountType="o";
            if(e.getSource() == SignUPButton ){
                String tmpName,tmpEmail,tmpPassword,tmpLocation,tmpPhone,tmpID;
                tmpName = registerNameTF.getText().toString();
                tmpEmail = registerEmailTF.getText().toString();
                tmpPassword = registerPF.getPassword().toString();
                tmpPhone = registerPhoneTF.getText().toString();
                tmpLocation = registerLocationTF.getText().toString();
                tmpID = registerIDTF.getText().toString();

                if(registerIDTF.equals("") ||tmpEmail.equals("")|| tmpLocation.equals("")||tmpName.equals("")||tmpPassword.equals("")||tmpPhone.equals("") || accountType.equals("")) errorInSignUpLabel.setText("Please enter all sections");
                else if(isValid(tmpEmail)){
                    x = (int) (Math.random() * (89467892 - 34278564 + 1)) + 34278564;
                    mail(tmpEmail,String.valueOf(x),tmpName);
                    verificationCodePage();
                }
                else{
                    errorInSignUpLabel.setText("Invalid email address");
                }
                if(e.getSource()==verificationButton){
                    String enteredCode = codeTF.getText().toString();
                    if(enteredCode.equals(String.valueOf(x))){
                        if(accountType.equals("p")){
                            Player player = new Player();
                            player.setName(tmpName);player.setPassword(tmpPassword);player.setEmail(tmpEmail);player.setPhone(tmpPhone);player.setLocation(tmpLocation);
                            Account.Players.add(player);
                            currentPlayer = player;
                        }
                        else {
                            PlaygroundOwner playgroundOwner = new PlaygroundOwner();
                            playgroundOwner.setName(tmpName);playgroundOwner.setPassword(tmpPassword);playgroundOwner.setEmail(tmpEmail);playgroundOwner.setPhone(tmpPhone);playgroundOwner.setLocation(tmpLocation);
                            Account.Owners.add(playgroundOwner);
                            currentOwner = playgroundOwner;
                        }

                        // TODO call options methods
                    }
                    else {
                        incorrectCodeLabel.setText("Incorrect code, try again");
                    }
                }

            }
            if(e.getSource() == StartButton){
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        seconds--;
                        s.setText(""+seconds);
                        m.setText(""+minutes);
                        if(seconds == 0 ){
                            seconds=60;
                            minutes--;
                        }
                        if(minutes<0){
                            seconds=0;minutes=0;
                            timer.stop();
                        }

                    }
                });
                timer.start();
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


                confirmBooking = new JButton("Confirm");
                confirmBooking.setBackground(new java.awt.Color(255,134,0 ));
                confirmBooking.setForeground(Color.white);
                confirmBooking.setBounds(190,490,100,45);
                confirmBooking.setFont(new Font("Serif", Font.ROMAN_BASELINE, 17));
                confirmBooking.addActionListener(obj);

                jFrameShowPlayGround.add(scrollPane);jFrameShowPlayGround.add(confirmBooking);
            }
            if(e.getSource()==selectButton){
                BookingIndex = list2.getSelectedIndex();
                showBookingInfo(currentPlayer.bookingHistory.get(BookingIndex));
            }
        }

    }
}

