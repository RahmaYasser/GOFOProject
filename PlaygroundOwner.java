package GOFO2;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PlaygroundOwner extends User implements ActionListener, MouseListener{
	
	Playground myPlayground = new Playground();
	public Vector<Booking> ownerBookingHistory = new Vector();
	String request = "error";
	String[] slots = new String[20];
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel("Name");
	JLabel label3 = new JLabel("Location");
	JLabel label4 = new JLabel("Size");
	JLabel label5 = new JLabel("Description");
	JLabel label6 = new JLabel("Price Per Hour");
	JLabel label7 = new JLabel("Cancellation Period");
	JLabel addSlots = new JLabel("Add Slots");
	JLabel viewSlots = new JLabel("View Slots");
	JLabel logout = new JLabel("logout");
	JLabel lmoney = new JLabel();
	JLabel lid = new JLabel();
	JTextField text = new JTextField();
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();
	JTextField text4 = new JTextField();
	JTextField text5 = new JTextField();
	JTextField text6 = new JTextField();
	JTextField day = new JTextField();
	JTextField from = new JTextField();
	JTextField to = new JTextField();
	JButton button = new JButton("Add Playground");
	JButton button2 = new JButton("Update Playground");
	JButton button3 = new JButton("View Bookings");
	JButton button4 = new JButton("Status & eWallet");
	JButton button5 = new JButton("Add");
	JButton button6 = new JButton("Update");
	JButton done = new JButton("Done");
	JButton back1 = new JButton("<<");
	
	PlaygroundOwner(){
		displayWelcome();
	}
	
	/**
	 * This function builds the welcome page of the playground owner
	 */
	private void displayWelcome() {
		panel.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);
		
		frame.setTitle("GoFo");
		frame.setSize(300, 450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(650, 200);
		
		button.setBackground(Color.ORANGE);
		button.setForeground(Color.DARK_GRAY);
		button.setBounds(20, 200, 110, 50);
		button.setFont (label.getFont ().deriveFont (9f));
		
		button2.setBackground(Color.ORANGE);
		button2.setForeground(Color.DARK_GRAY);
		button2.setBounds(160, 200, 110, 50);
		button2.setFont (label.getFont ().deriveFont (10f));
		
		button3.setBackground(Color.ORANGE);
		button3.setForeground(Color.DARK_GRAY);
		button3.setBounds(20, 270, 110, 50);
		button3.setFont (label.getFont ().deriveFont (9f));
		
		button4.setBackground(Color.ORANGE);
		button4.setForeground(Color.DARK_GRAY);
		button4.setBounds(160, 270, 110, 50);
		button4.setFont (label.getFont ().deriveFont (9f));
		
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label.setForeground(Color.WHITE);
		label.setText("WELCOME");
		label.setFont (label.getFont ().deriveFont (23f));
		label.setBounds(80, 50, 130, 50);
		
		logout.setForeground(Color.WHITE);
		logout.setBounds(120, 340, 130, 50);
		
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(label);
		panel.add(logout);
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		logout.addMouseListener(this);
	}
	
	/**
	 * This function displays when the owner presses on the add playground button,
	 * then he fills the information of his playground
	 */
	private void toAddPlayground() {
		
		formDetails();
		
		label.setText("Add Playground");
		label.setBounds(50, 30, 180, 50);
		
		button5.setBackground(Color.ORANGE);
		button5.setForeground(Color.DARK_GRAY);
		button5.setBounds(100, 375, 80, 30);
		button5.setVisible(true);
		button6.setVisible(false);
		
		back1Details();
		
		panel2.add(button5);
		button5.addActionListener(this);
	}
	
	/**
	 * To check if all fields are filled or not.
	 * If all fields are filled, they are stored and the request will be ok.
	 * If not, the request will be error because of uncompleted information.
	 */
	public void getPlaygroundData() {
		if (!text.getText().contentEquals("") && !text2.getText().contentEquals("") && !text3.getText().contentEquals("")
			&& !text4.getText().contentEquals("") && !text5.getText().contentEquals("") && !text6.getText().contentEquals("")) {
			
			myPlayground.setName(text.getText());
			myPlayground.setLocation(text2.getText());
			myPlayground.setSize(Double.parseDouble(text3.getText()));
			myPlayground.setDescription(text4.getText());
			myPlayground.setPricePerHour(Double.parseDouble(text5.getText()));
			myPlayground.setCancellationPeriod(Integer.parseInt(text6.getText()));
			//ground.setSlots(text7.getText());
			request = "ok";
		}
		else {
			request = "error";
		}
	}
	
	/**
	 * This function displays when the owner presses on the update playground button,
	 * Then he can show or modify his playground information.
	 */
	public void updatePlayground() {
		
		formDetails();
		
		label.setText("Update Playground");
		label.setBounds(30, 25, 220, 50);
		
		button6.setBackground(Color.ORANGE);
		button6.setForeground(Color.DARK_GRAY);
		button6.setBounds(100, 375, 80, 30);
		button6.setVisible(true);
		button5.setVisible(false);
		
		back1Details();
			
		String str;
		
		text.setText(myPlayground.getName());
		text2.setText(myPlayground.getLocation());
		str = String.valueOf(myPlayground.getSize());
		text3.setText(str);
		text4.setText(myPlayground.getDescription());
		str = String.valueOf(myPlayground.getPricePerHour());
		text5.setText(str);
		str = String.valueOf(myPlayground.getCancellationPeriod());
		text6.setText(str);
		
		panel2.add(button6);
		button6.addActionListener(this);
	}
	
	/**
	 * If the admin approved the playground, the playground is stored in the array list
	 */
	private void approvedAddPlayground() {
		AvailablePlaygrounds.playgrounds.add(myPlayground);
		myPlayground.setId(AvailablePlaygrounds.playgrounds.size());
	}
	
	/**
	 * If the admin approved the playground update, the playground is modified in the array list
	 */
	private void approvedUpdatePlayground() {
		int index = myPlayground.getId();
		AvailablePlaygrounds.playgrounds.get(index-1).equals(myPlayground);
	}
	
	/**
	 * To build the window of the add playground button and update playground button.
	 */
	private void formDetails() {
		panel.setVisible(false);
		panel3.setVisible(false);
		panel2.setVisible(true);
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setLayout(null);
		
		label2.setText("Name");
		label2.setBounds(40, 70, 80, 20);
		label2.setFont (label2.getFont ().deriveFont (10f));
		label2.setForeground(Color.WHITE);
		
		label3.setText("Location");
		label3.setBounds(40, 110, 80, 20);
		label3.setFont (label3.getFont ().deriveFont (10f));
		label3.setForeground(Color.WHITE);
		
		label4.setText("Size");
		label4.setBounds(40, 150, 80, 20);
		label4.setFont (label4.getFont ().deriveFont (10f));
		label4.setForeground(Color.WHITE);
		
		label5.setText("Description");
		label5.setBounds(40, 190, 80, 20);
		label5.setFont (label5.getFont ().deriveFont (10f));
		label5.setForeground(Color.WHITE);
		
		label6.setText("Price Per Hour");
		label6.setBounds(40, 230, 80, 20);
		label6.setFont (label6.getFont ().deriveFont (10f));
		label6.setForeground(Color.WHITE);
		
		label7.setText("Cancellation Period");
		label7.setBounds(40, 270, 120, 20);
		label7.setFont (label7.getFont ().deriveFont (10f));
		label7.setForeground(Color.WHITE);
		
		addSlots.setBounds(110, 330, 120, 20);
		addSlots.setFont (addSlots.getFont ().deriveFont (13f));
		addSlots.setForeground(Color.WHITE);
		
		text.setBounds(40, 90, 200, 20);
		text2.setBounds(40, 130, 200, 20);
		text3.setBounds(40, 170, 200, 20);
		text4.setBounds(40, 210, 200, 20);
		text5.setBounds(40, 250, 200, 20);
		text6.setBounds(40, 290, 200, 20);
		
		frame.add(panel2);
		panel2.add(back1);
		panel2.add(label);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		panel2.add(label7);
		panel2.add(addSlots);
		panel2.add(text);
		panel2.add(text2);
		panel2.add(text3);
		panel2.add(text4);
		panel2.add(text5);
		panel2.add(text6);
		
		addSlots.addMouseListener(this);
	}
	
	public void addSlotsFrame() {
		panel2.setVisible(false);
		panel3.setVisible(true);
		panel3.setBackground(Color.DARK_GRAY);
		panel3.setLayout(null);
		
		label.setText("Add Slots");
		label.setBounds(80, 25, 220, 50);
		
		label2.setText("Day");
		label2.setBounds(60, 110, 80, 30);
		label2.setFont (label2.getFont ().deriveFont (12f));
		label2.setForeground(Color.WHITE);
		
		label3.setText("From");
		label3.setBounds(60, 150, 80, 30);
		label3.setFont (label3.getFont ().deriveFont (12f));
		label3.setForeground(Color.WHITE);
		
		label4.setText("To");
		label4.setBounds(60, 190, 80, 30);
		label4.setFont (label4.getFont ().deriveFont (12f));
		label4.setForeground(Color.WHITE);
		
		done.setBackground(Color.ORANGE);
		done.setForeground(Color.DARK_GRAY);
		done.setBounds(100, 340, 80, 30);
		
		day.setText("");
		from.setText("");
		to.setText("");
		
		day.setBounds(100, 110, 80, 30);
		from.setBounds(100, 150, 80, 30);
		to.setBounds(100, 190, 80, 30);
			
		addSlots.setBounds(110, 300, 120, 20);
		
		frame.add(panel3);
		panel3.add(label);
		panel3.add(label2);
		panel3.add(label3);
		panel3.add(label4);
		panel3.add(done);
		panel3.add(day);
		panel3.add(from);
		panel3.add(to);
		panel3.add(addSlots);
		
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
	
	/**
	 * This function displays when the owner presses on the vie bookings button,
	 * and it displays the bookings of the owner playground.
	 */
	public void viewBookings() {
		panel.setVisible(false);
		panel4.setVisible(true);
		panel4.setBackground(Color.DARK_GRAY);
		panel4.setLayout(null);
		
		JList list = new JList(slots);
		
		list.setBackground(Color.WHITE);
		list.setForeground(Color.black);
		list.setBounds(40, 130, 200, 200);
		
		label.setText("Bookings");
		label.setBounds(100, 50, 180, 50);
		
		back1Details();
		
		frame.add(panel4);
		panel4.add(back1);
		panel4.add(list);
		panel4.add(label);
	}
	
	/**
	 * This function to store bookings slots into 'data' array
	 */
	private void storePlaygroundsTitle() {
		for (int i = 0 ; i < ownerBookingHistory.size() ; i++) {
			slots[i] = "From " + String.valueOf(ownerBookingHistory.get(i).item.timeSlot.getStartTime()) + " to "
					+ String.valueOf(ownerBookingHistory.get(i).item.timeSlot.getEndTime());
		}
	}
	
	/**
	 * This function displays when the owner presses on the update playground button,
	 * and it displays the statue of the owner eWallet.
	 */
	public void checkEwallet() {
		panel.setVisible(false);
		panel5.setVisible(true);
		panel5.setBackground(Color.DARK_GRAY);
		panel5.setLayout(null);
		
		label.setText("eWallet");
		
		String str;
		
		str = "Your Money: " + String.valueOf(this.getUserEwallet().getCurrentMoney());
		lmoney.setText(str);
		str = "Your eWallet ID: " + String.valueOf(this.getUserEwallet().getId());
		lid.setText(str);
		
		lmoney.setBounds(50, 120, 150, 50);
		lid.setBounds(50, 150, 150, 50);
		
		lmoney.setForeground(Color.WHITE);
		lid.setForeground(Color.WHITE);
		
		back1Details();
		
		frame.add(panel5);
		panel5.add(label);
		panel5.add(lmoney);
		panel5.add(lid);
		panel5.add(back1);
	}
	
	/**
	 * To set back details(color, font, ...)
	 */
	private void back1Details() {
		back1.setBounds(5, 5, 50, 30);
		back1.setFont (back1.getFont ().deriveFont (10f));
		back1.setBackground(Color.ORANGE);
		back1.setForeground(Color.DARK_GRAY);
		
		back1.addActionListener(this);
	}
	
	/**
	 * This function to make actions based on a pressed button
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button) {
			if (myPlayground.getId() == 0) {
				toAddPlayground();
			}
		}
		if (e.getSource() == button2) {
			if (myPlayground.getId() != 0) {
				updatePlayground();
			}
		}
		if (e.getSource() == button3) {
			viewBookings();
		}
		if (e.getSource() == button4) {
			checkEwallet();
		}
		if (e.getSource() == button5) {
			getPlaygroundData();
			displayWelcome();
			if (Administrator.approvePlayground(request)) {
				approvedAddPlayground();
			}
		}
		if (e.getSource() == button6) {
			getPlaygroundData();
			displayWelcome();
			if (Administrator.approvePlayground(request)) {
				approvedUpdatePlayground();
			}
		}
		if (e.getSource() == done) {
			toAddPlayground();
		}
		if (e.getSource() == back1) {
			displayWelcome();
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
}



