package GOFO2;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class Administrator extends User implements ActionListener, MouseListener {
	
	Vector<String> data = new Vector();
	
	JFrame frame = new JFrame();
	JPanel adminHome = new JPanel();
	JPanel adminAllPlaygrounds = new JPanel();
	JPanel adminPlayground = new JPanel();
	JLabel header = new JLabel();
	JLabel PgNumLabel = new JLabel("Select PG no.");
	JLabel locationLabel = new JLabel("Location");
	JLabel sizeLabel = new JLabel("Size");
	JLabel descriptionLabel = new JLabel("Description");
	JLabel priceLabel = new JLabel("Price Per Hour");
	JLabel cancellationLabel = new JLabel("Cancellation Period");
	JLabel logout = new JLabel("logout");
	JTextField PgNumText = new JTextField();
	JButton aPlaygroundsButton = new JButton("Playgrounds");
	JButton goButton = new JButton("Go");
	JButton deleteButton = new JButton("Delete");
	JButton adminBack1 = new JButton("<<");
	JButton adminBack2 = new JButton("<<");
	
	Administrator() {
		displayWelcome();
	}
	
	/**
	 * This function builds the welcome page of the administrator
	 */
	private void displayWelcome() {
		adminHome.setVisible(true);
		adminAllPlaygrounds.setVisible(false);
		
		frame.setTitle("GoFo");
		frame.setSize(300, 450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(650, 200);
		
		aPlaygroundsButton.setBackground(new Color(255,134,0));
		aPlaygroundsButton.setForeground(Color.WHITE);
		aPlaygroundsButton.setBounds(80, 200, 130, 50);
		
		adminHome.setLayout(null);
		adminHome.setBackground(new java.awt.Color(105,105,105));
		
		header.setForeground(Color.WHITE);
		header.setText("WELCOME");
		header.setFont (header.getFont ().deriveFont (23f));
		header.setBounds(80, 50, 130, 50);
		
		logout.setForeground(Color.WHITE);
		logout.setBounds(120, 300, 130, 50);
		
		frame.add(adminHome);
		adminHome.add(aPlaygroundsButton);
		adminHome.add(header);
		adminHome.add(logout);
		
		logout.addMouseListener(this);
		aPlaygroundsButton.addActionListener(this);
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
		PlaygroundOwner owner = AvailablePlaygrounds.playgrounds.get(index-1).playgroundOwner;
		AvailablePlaygrounds.playgrounds.remove(index-1);
		storePlaygroundsTitle();
		
		for (int i = 0 ; i < Account.Owners.size() ; i++) {
			if (Account.Owners.get(i).equals(owner)) {
				Account.Owners.get(i).myPlayground.setId(0);
			}
		}
	}
	
	/**
	 * This function to store playgrounds names into 'data' array
	 */
	private void storePlaygroundsTitle() {
		data.clear();
		for (int i = 0 ; i < AvailablePlaygrounds.playgrounds.size() ; i++) {
			data.add(String.valueOf(i+1) + ") " + AvailablePlaygrounds.playgrounds.get(i).getName());
		}
	}
	
	/**
	 * This function to display all the approved playgrounds names from 'data' array
	 */
	private void viewAllPlaygrounds() {
		JList list = new JList(data);
		
		adminHome.setVisible(false);
		adminPlayground.setVisible(false);
		adminAllPlaygrounds.setVisible(true);
		adminAllPlaygrounds.setBackground(new java.awt.Color(105,105,105));
		adminAllPlaygrounds.setLayout(null);
		
		header.setText("Playgrounds");
		header.setBounds(70, 50, 150, 50);
		
		adminBack1.setBounds(5, 5, 50, 30);
		adminBack1.setFont (adminBack1.getFont ().deriveFont (10f));
		adminBack1.setBackground(new Color(255,134,0));
		adminBack1.setForeground(Color.WHITE);
		
		goButton.setBackground(new Color(255,134,0));
		goButton.setForeground(Color.WHITE);
		goButton.setBounds(200, 375, 80, 30);
		
		PgNumLabel.setBounds(10, 375, 80, 30);
		PgNumLabel.setFont (PgNumLabel.getFont ().deriveFont (10f));
		PgNumLabel.setForeground(Color.WHITE);
		
		PgNumText.setText("");
		PgNumText.setBounds(100, 375, 80, 30);
		
		list.setBackground(Color.WHITE);
		list.setForeground(Color.black);
		list.setBounds(40, 130, 200, 200);
		
		frame.add(adminAllPlaygrounds);
		adminAllPlaygrounds.add(adminBack1);
		adminAllPlaygrounds.add(header);
		adminAllPlaygrounds.add(PgNumLabel);
		adminAllPlaygrounds.add(goButton);
		adminAllPlaygrounds.add(PgNumText);
		adminAllPlaygrounds.add(list);
		
		adminBack1.addActionListener(this);
		goButton.addActionListener(this);
	}
	
	/**
	 * @param index is the index of the playground which the admin wants to view
	 */
	private void viewPlayground(int index) {
		adminAllPlaygrounds.setVisible(false);
		adminPlayground.setVisible(true);
		adminPlayground.setBackground(new java.awt.Color(105,105,105));
		adminPlayground.setLayout(null);
		
		header.setText(AvailablePlaygrounds.playgrounds.get(index-1).getName());
		header.setBounds(10, 50, 250, 50);
		
		adminBack2.setBounds(5, 5, 50, 30);
		adminBack2.setFont (adminBack2.getFont ().deriveFont (10f));
		adminBack2.setBackground(new Color(255,134,0));
		adminBack2.setForeground(Color.WHITE);
		
		deleteButton.setBackground(new Color(255,134,0));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setBounds(200, 375, 80, 30);
		
		locationLabel.setText("Location: " + AvailablePlaygrounds.playgrounds.get(index-1).getLocation());
		locationLabel.setBounds(40, 110, 250, 20);
		locationLabel.setFont (locationLabel.getFont ().deriveFont (12f));
		locationLabel.setForeground(Color.WHITE);
		
		sizeLabel.setText("Size: " + String.valueOf(AvailablePlaygrounds.playgrounds.get(index-1).getSize()));
		sizeLabel.setBounds(40, 150, 250, 20);
		sizeLabel.setFont (sizeLabel.getFont ().deriveFont (12f));
		sizeLabel.setForeground(Color.WHITE);
		
		descriptionLabel.setText("Description: " + AvailablePlaygrounds.playgrounds.get(index-1).getDescription());
		descriptionLabel.setBounds(40, 190, 250, 20);
		descriptionLabel.setFont (descriptionLabel.getFont ().deriveFont (12f));
		descriptionLabel.setForeground(Color.WHITE);
		
		priceLabel.setText("Price per hour: " + String.valueOf(AvailablePlaygrounds.playgrounds.get(index-1).getPricePerHour()));
		priceLabel.setBounds(40, 230, 250, 20);
		priceLabel.setFont (priceLabel.getFont ().deriveFont (12f));
		priceLabel.setForeground(Color.WHITE);
		
		cancellationLabel.setText("Cancellation period: " + String.valueOf(AvailablePlaygrounds.playgrounds.get(index-1).getCancellationPeriod()));
		cancellationLabel.setBounds(40, 270, 250, 20);
		cancellationLabel.setFont (cancellationLabel.getFont ().deriveFont (12f));
		cancellationLabel.setForeground(Color.WHITE);
		
		frame.add(adminPlayground);
		adminPlayground.add(adminBack2);
		adminPlayground.add(header);
		adminPlayground.add(locationLabel);
		adminPlayground.add(sizeLabel);
		adminPlayground.add(descriptionLabel);
		adminPlayground.add(priceLabel);
		adminPlayground.add(cancellationLabel);
		adminPlayground.add(deleteButton);
		
		adminBack2.addActionListener(this);
		deleteButton.addActionListener(this);
	}
	
	/**
	 * This function to make actions based on a pressed button
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == aPlaygroundsButton) {
			storePlaygroundsTitle();
			viewAllPlaygrounds();
		}
		if (e.getSource() == goButton) {
			String str = PgNumText.getText();
			int i = Integer.parseInt(str);
			if (i>0 && i<=AvailablePlaygrounds.playgrounds.size()) {
				viewPlayground(i);
			}
		}
		if (e.getSource() == deleteButton) {
			String str = PgNumText.getText();
			int i;
			try {
				i = Integer.parseInt(str);
				if (i>0 && i<=AvailablePlaygrounds.playgrounds.size()) {
					deletePlayground(i);
				}
				viewAllPlaygrounds();
			}
			catch (NumberFormatException e1) {
				viewAllPlaygrounds();
			}
		}
		if (e.getSource() == adminBack1) {
			displayWelcome();
		}
		else if (e.getSource() == adminBack2) {
			viewAllPlaygrounds();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == logout) {
			frame.dispose();
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
