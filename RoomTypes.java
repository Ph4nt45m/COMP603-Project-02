/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

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
 * @author snipi
 */
public class RoomTypes extends JFrame {

    private JLabel roomDetailsTitle;
    private JButton homeButton;
    private JButton backButton;
    private JPanel mainPanel;
    private JLabel roomTypesLabel;
    private JComboBox<String> roomTypes;
    private JButton selectButton;

    final String[] roomNameTypes = {"Single Room", "Double Room", "Family Room", "Group Room"};
    Homepage homepage;
    Booking booking;
    String selectedRoom;
    RoomDetailsForm roomDetails;
    BookingDetails userDetails;

    public RoomTypes(Homepage home, Booking bookingMenu) {
        this.homepage = home;
        this.booking = bookingMenu;
        setComponents();
        setLocation((homepage.width / 2) - (this.getWidth() / 2), 200);
        setVisible(true);
        roomDetails.setLocation((getX() + 8), (getY() + getHeight() - 2));
        roomDetails.setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                homepage.dbManager.closeConnections();

                dispose();
                System.exit(0);
            }
        });
    }

    private void setComponents() {
        roomDetailsTitle = new JLabel();
        homeButton = new JButton();
        backButton = new JButton();
        mainPanel = new JPanel();
        roomTypesLabel = new JLabel();
        roomTypes = new JComboBox();
        selectButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        roomDetailsTitle.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        roomDetailsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        roomDetailsTitle.setText("Room Details");
        roomDetailsTitle.setPreferredSize(new Dimension(142, 30));

        roomTypes.setFont(new Font("Segoe UI", 0, 17));
        roomTypes.setModel(new DefaultComboBoxModel<>(roomNameTypes));
        selectedRoom = (String) roomTypes.getSelectedItem();
        roomDetails = new RoomDetailsForm(selectedRoom, this);
        roomTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                roomTypesActionPerformed(evt);
            }
        });

        roomTypesLabel.setFont(new Font("Segoe UI", 0, 17)); // NOI18N
        roomTypesLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        roomTypesLabel.setText("Room Type:");

        selectButton.setText("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                selectRoomActionPerformed(evt);
            }
        });

        homeButton.setText("Homepage");
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        roomDetailsTitle.setBounds(255, 50, 142, 30);
        homeButton.setBounds(10, 10, 100, 30);
        backButton.setBounds(10, 50, 100, 30);
        roomTypesLabel.setBounds(150, 175, 100, 30);
        roomTypes.setBounds(260, 175, 150, 30);
        selectButton.setBounds(275, 240, 90, 30);

        mainPanel.setLayout(null);
        mainPanel.add(roomDetailsTitle);
        mainPanel.add(homeButton);
        mainPanel.add(backButton);
        mainPanel.add(roomTypesLabel);
        mainPanel.add(roomTypes);
        mainPanel.add(selectButton);

        mainPanel.setPreferredSize(new Dimension(650, 300));

        getContentPane().add(mainPanel);

        pack();
    }

    private void roomTypesActionPerformed(ActionEvent evt) {
        if (roomDetails != null) {
            roomDetails.dispose();
        }
        selectedRoom = (String) roomTypes.getSelectedItem();
        // createRoom() here
        roomDetails = new RoomDetailsForm(selectedRoom, this);
        roomDetails.setVisible(true);
    }

    private void selectRoomActionPerformed(ActionEvent evt) {
        userDetails = new BookingDetails(homepage, this);
        setVisible(false);
        roomDetails.setVisible(false);
    }

    private void homeButtonActionPerformed(ActionEvent evt) {
        homepage.setVisible(true);
        homepage.setLocation((homepage.width / 2) - (homepage.getWidth() / 2), 200);
        booking.dispose();
        roomDetails.dispose();
        dispose();
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        booking.setVisible(true);
        roomDetails.dispose();
        dispose();
    }
}
