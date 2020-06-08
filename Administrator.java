package GOFO2;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Administrator extends User implements ActionListener {
	
	public static ArrayList <Playground> playground = new ArrayList();
	String[] data = new String[20];
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel("Select PG no.");
	JLabel label3 = new JLabel("Location");
	JLabel label4 = new JLabel("Size");
	JLabel label5 = new JLabel("Description");
	JLabel label6 = new JLabel("Price Per Hour");
	JLabel label7 = new JLabel("Cancellation Period");
	JLabel label8 = new JLabel("Slots");
	JTextField text = new JTextField();
	JButton button = new JButton("Playgrounds");
	JButton button2 = new JButton("Go");
	JButton button3 = new JButton("Delete");
	JButton back1 = new JButton("<<");
	JButton back2 = new JButton("<<");
	
	Administrator() {
		displayWelcome();
	}
	
	/**
	 * This function builds the welcome page of the administrator
	 */
	private void displayWelcome() {
		panel.setVisible(true);
		panel2.setVisible(false);
		
		frame.setTitle("GoFo");
		frame.setSize(300, 450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(650, 200);
		
		button.setBackground(Color.ORANGE);
		button.setForeground(Color.DARK_GRAY);
		button.setBounds(80, 200, 130, 50);
		
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label.setForeground(Color.WHITE);
		label.setText("WELCOME");
		label.setFont (label.getFont ().deriveFont (23f));
		label.setBounds(80, 50, 130, 50);
		
		frame.add(panel);
		panel.add(button);
		panel.add(label);
		
		button.addActionListener(this);
	}
	
	/**
	 * The admin approves based on the request
	 * @param request defines if the playground information has an error or not
	 * @return boolean true or false
	 */
	public static boolean approvePlayground(String request) {
		if (request.contentEquals("error")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * The admin deletes a specific playground
	 * @param index is the index of the playground which the admin wants to delete
	 */
	public void deletePlayground(int index) {
		playground.remove(index-1);
		for (int i = index-1 ; i < data.length-1 ; i++) {
			data[i] = data[i+1];
		}
		data[data.length-1] = null;
	}
	
	/**
	 * This function to store playgrounds names into 'data' array
	 */
	private void storePlaygroundsTitle() {
		for (int i = 0 ; i < playground.size() ; i++) {
			data[i] = String.valueOf(i+1) + ") " + playground.get(i).getName();
		}
	}
	
	/**
	 * This function to display all the approved playgrounds names from 'data' array
	 */
	private void viewAllPlaygrounds() {
		JList list = new JList(data);
		
		panel.setVisible(false);
		panel3.setVisible(false);
		panel2.setVisible(true);
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setLayout(null);
		
		label.setText("Playgrounds");
		label.setBounds(70, 50, 150, 50);
		
		back1.setBounds(5, 5, 50, 30);
		back1.setFont (back1.getFont ().deriveFont (10f));
		back1.setBackground(Color.ORANGE);
		back1.setForeground(Color.DARK_GRAY);
		
		button2.setBackground(Color.ORANGE);
		button2.setForeground(Color.DARK_GRAY);
		button2.setBounds(200, 375, 80, 30);
		
		label2.setBounds(10, 375, 80, 30);
		label2.setFont (label2.getFont ().deriveFont (10f));
		label2.setForeground(Color.WHITE);
		
		text.setBounds(100, 375, 80, 30);
		
		list.setBackground(Color.WHITE);
		list.setForeground(Color.black);
		list.setBounds(40, 130, 200, 200);
		
		frame.add(panel2);
		panel2.add(back1);
		panel2.add(label);
		panel2.add(label2);
		panel2.add(button2);
		panel2.add(text);
		panel2.add(list);
		
		back1.addActionListener(this);
		button2.addActionListener(this);
	}
	
	/**
	 * @param index is the index of the playground which the admin wants to view
	 */
	private void viewPlayground(int index) {
		panel2.setVisible(false);
		panel3.setVisible(true);
		panel3.setBackground(Color.DARK_GRAY);
		panel3.setLayout(null);
		
		label.setText(playground.get(index-1).getName());
		label.setBounds(10, 50, 250, 50);
		
		back2.setBounds(5, 5, 50, 30);
		back2.setFont (back2.getFont ().deriveFont (10f));
		back2.setBackground(Color.ORANGE);
		back2.setForeground(Color.DARK_GRAY);
		
		button3.setBackground(Color.ORANGE);
		button3.setForeground(Color.DARK_GRAY);
		button3.setBounds(200, 375, 80, 30);
		
		label3.setText("Location: " + playground.get(index-1).getLocation());
		label3.setBounds(40, 110, 250, 20);
		label3.setFont (label3.getFont ().deriveFont (11f));
		label3.setForeground(Color.WHITE);
		
		label4.setText("Size: " + String.valueOf(playground.get(index-1).getSize()));
		label4.setBounds(40, 150, 250, 20);
		label4.setFont (label4.getFont ().deriveFont (11f));
		label4.setForeground(Color.WHITE);
		
		label5.setText("Description: " + playground.get(index-1).getDescription());
		label5.setBounds(40, 190, 250, 20);
		label5.setFont (label5.getFont ().deriveFont (11f));
		label5.setForeground(Color.WHITE);
		
		label6.setText("Price per hour: " + String.valueOf(playground.get(index-1).getPricePerHour()));
		label6.setBounds(40, 230, 250, 20);
		label6.setFont (label6.getFont ().deriveFont (11f));
		label6.setForeground(Color.WHITE);
		
		label7.setText("Cancellation period: " + String.valueOf(playground.get(index-1).getCancellationPeriod()));
		label7.setBounds(40, 270, 250, 20);
		label7.setFont (label7.getFont ().deriveFont (12f));
		label7.setForeground(Color.WHITE);
		
		frame.add(panel3);
		panel3.add(back2);
		panel3.add(label);
		panel3.add(label3);
		panel3.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		panel3.add(label7);
		panel3.add(button3);
		
		back2.addActionListener(this);
		button3.addActionListener(this);
	}
	
	/**
	 * This function to make actions based on a pressed button
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button) {
			storePlaygroundsTitle();
			viewAllPlaygrounds();
		}
		if (e.getSource() == button2) {
			String str = text.getText();
			int i = Integer.parseInt(str);
			viewPlayground(i);
		}
		if (e.getSource() == button3) {
			String str = text.getText();
			int i = Integer.parseInt(str);
			deletePlayground(i);
		}
		if (e.getSource() == back1) {
			displayWelcome();
		}
		else if (e.getSource() == back2) {
			viewAllPlaygrounds();
		}
		
	}
}
