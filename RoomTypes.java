/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author m4ria
 */
public class RoomTypes extends JFrame {

    private JButton homeButton;
    private JButton backButton;
    private JLabel roomTypesTitle;
    private JPanel mainPanel;
    private JLabel roomTypesLabel;
    private JComboBox<String> roomTypes;
    private JButton selectButton;

    protected final int width = 650;
    protected final int height = 300;
    private final String[] roomNameTypes = {"Single Room", "Double Room", "Family Room", "Group Room"};
    protected Homepage homepage;
    protected BookingMenu booking;
    protected RoomDetails roomDetails;
    protected BookingDetails bookingDetails;
    protected String selectedRoom;

    //Constructor for Unit Testing - Booking
    public RoomTypes(Homepage home) {
        this.homepage = home;
        this.booking = new BookingMenu(this.homepage);
        setComponents();
    }
    
    /*Constructs a RoomTypes object with the specified Homepage and
     * BookingMenu.
     */
    public RoomTypes(Homepage home, BookingMenu bookingMenu) {
        this.homepage = home;
        this.booking = bookingMenu;

        setLocation(((homepage.screenWidth / 2) - (width / 2)), (((homepage.screenHeight / 6) * 2) - (height / 2)));
        setComponents();
    }

    //Sets up the UI components for the Room Types window.
    private void setComponents() {
        roomTypesTitle = new JLabel();
        homeButton = new JButton();
        backButton = new JButton();
        roomTypesLabel = new JLabel();
        roomTypes = new JComboBox();
        selectButton = new JButton();
        mainPanel = new JPanel();

        setTitle();
        setHomeButton();
        setBackButton();
        setRoomTypesLabel();
        setRoomTypes();
        setSelectButton();
        setMainPanel();
        setFrame();
    }

    //Sets up the homepage button
    private void setHomeButton() {
        homeButton.setText("Homepage");
        homeButton.setBounds(10, 10, 100, 30);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeButtonAction(e);
            }
        });
    }

    /*Action performed when the homepage button is clicked. Disposes of the
    *current frame and makes the homepage frame visible.
     */
    private void homeButtonAction(ActionEvent evt) {
        if (booking.isDisplayable()) {
            booking.dispose();
        }
        if (roomDetails.isDisplayable()) {
            roomDetails.dispose();
        }

        homepage.setLocation((homepage.width / 2) - (homepage.getWidth() / 2), 200);
        homepage.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    /*Action performed when the back button is clicked. Disposes of the
    *current frame and makes the Booking frame visible.
     */
    private void setBackButton() {
        backButton.setText("Back");
        backButton.setBounds(10, 50, 100, 30);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonAction(e);
            }
        });
    }

    /*Action performed when the back button is clicked. Disposes of the current 
    *frame and makes the booking frame visible.
     */
    private void backButtonAction(ActionEvent evt) {
        if (roomDetails.isDisplayable()) {
            roomDetails.dispose();
        }

        booking.setLocation(((homepage.screenWidth / 2) - (booking.width / 2)), ((homepage.screenHeight / 2) - (booking.height / 2)));
        booking.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    //Sets up the title label of the JFrame.
    private void setTitle() {
        roomTypesTitle.setFont(new Font("Segoe UI", 0, 24));
        roomTypesTitle.setHorizontalAlignment(SwingConstants.CENTER);
        roomTypesTitle.setText("Room Details");
        roomTypesTitle.setBounds(255, 50, 142, 30);
    }

    //Sets up the title label of the panel.
    private void setRoomTypesLabel() {
        roomTypesLabel.setFont(new Font("Segoe UI", 0, 17));
        roomTypesLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        roomTypesLabel.setText("Room Type:");
        roomTypesLabel.setBounds(150, 175, 100, 30);
    }

    //Sets up the dropdown list for selecting room types.
    private void setRoomTypes() {
        roomTypes.setFont(new Font("Segoe UI", 0, 17));
        roomTypes.setModel(new DefaultComboBoxModel<>(roomNameTypes));
        roomTypes.setBounds(260, 175, 150, 30);
        selectedRoom = (String) roomTypes.getSelectedItem();
        roomDetails = new RoomDetails(selectedRoom, this);
        roomDetails.setVisible(true);

        roomTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomTypesAction(e);
            }
        });
    }

    //Action performed when a room type is selected from the dropdown list.
    private void roomTypesAction(ActionEvent evt) {
        if (roomDetails != null) {
            roomDetails.dispose();
        }
        selectedRoom = (String) roomTypes.getSelectedItem();
        roomDetails = new RoomDetails(selectedRoom, this);
        roomDetails.setVisible(true);
    }

    //Sets up the Select button
    private void setSelectButton() {
        selectButton.setText("Select");
        selectButton.setBounds(275, 240, 90, 30);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectRoomAction(e);
            }
        });
    }

    //Action performed when the Select button is clicked.
    private void selectRoomAction(ActionEvent evt) {
        bookingDetails = new BookingDetails(homepage, this);
        setVisible(false);
        roomDetails.setVisible(false);
    }

    //Sets up the main panel of the window.
    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setLayout(null);

        mainPanel.add(roomTypesTitle);
        mainPanel.add(homeButton);
        mainPanel.add(backButton);
        mainPanel.add(roomTypesLabel);
        mainPanel.add(roomTypes);
        mainPanel.add(selectButton);
    }

    //Sets up the frame properties and displays the window.
    private void setFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        mainPanel.setBackground(Color.decode("#fff3e9"));
        getContentPane().add(mainPanel);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                homepage.dbManager.closeConnections();

                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
