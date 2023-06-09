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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author m4ria
 */
public class BookingMenu extends JFrame {

    private JButton homeButton;
    private JLabel bookingTitle;
    private JButton makeBookingButton;
    private JButton checkBookingButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    protected final int width = 240;
    protected final int height = 300;
    protected Homepage homepage;
    protected RoomTypes roomTypesMenu;
    protected CheckBooking checkBooking;

    //Creates a new instance of the BookingMenu class.
    public BookingMenu(Homepage home) {
        this.homepage = home;
        setComponents();
    }

    //Initializes and sets up the components of the booking menu frame.
    private void setComponents() {
        bookingTitle = new JLabel();
        makeBookingButton = new JButton();
        checkBookingButton = new JButton();
        homeButton = new JButton();
        buttonPanel = new JPanel();
        mainPanel = new JPanel();

        setTitle();
        setMakeBookingButton();
        setCheckBookingButton();
        setHomeButton();
        setButtonPanel();
        setMainPanel();
        setFrame();
    }

    //Sets title
    private void setTitle() {
        bookingTitle.setFont(new Font("Segoe UI", 0, 24));
        bookingTitle.setHorizontalAlignment(SwingConstants.CENTER);
        bookingTitle.setText("Booking Menu");
        bookingTitle.setBounds(25, 20, 200, 60);
    }

    //Sets a make booking button and if it's pressed, the action performed occurs
    private void setMakeBookingButton() {
        makeBookingButton.setFont(new Font("Segoe UI", 0, 16));
        makeBookingButton.setText("Make a Booking");
        makeBookingButton.setBounds(0, 0, 200, 45);

        makeBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                makeBookingActionPerformed(evt);
            }
        });
    }

    //Action performed when the "Make a Booking" button is clicked
    private void makeBookingActionPerformed(ActionEvent evt) {
        roomTypesMenu = new RoomTypes(homepage, this);
        setVisible(false);
    }

    //Sets up the "Check my Booking" button.
    private void setCheckBookingButton() {
        checkBookingButton.setFont(new Font("Segoe UI", 0, 16));
        checkBookingButton.setText("Check my Booking");
        checkBookingButton.setBounds(0, 65, 200, 45);

        checkBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                checkBookingActionPerformed(evt);
            }
        });
    }

    ///Action performed when the "Check my Booking" button is clicked.
    private void checkBookingActionPerformed(ActionEvent evt) {
        checkBooking = new CheckBooking(homepage, this);
        setVisible(false);
    }

    //Sets up the "Return to Homepage" button.
    private void setHomeButton() {
        homeButton.setFont(new Font("Segoe UI", 0, 16));
        homeButton.setText("Return to Homepage");
        homeButton.setBounds(0, 130, 200, 45);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeButtonAction(e);
            }
        });
    }

    //Action performed when the "Return to Homepage" button is clicked.
    private void homeButtonAction(ActionEvent evt) {
        homepage.setVisible(true);
        homepage.setLocation((homepage.screenWidth / 2) - (homepage.width / 2), ((homepage.screenHeight / 2) - (homepage.height / 2)));
        if (isDisplayable()) {
            dispose();
        }
    }

    //Sets up the button panel that contains the buttons.
    private void setButtonPanel() {
        buttonPanel.setBounds(25, 100, 200, 180);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(Color.decode("#fff3e9"));

        buttonPanel.add(makeBookingButton);
        buttonPanel.add(checkBookingButton);
        buttonPanel.add(homeButton);
    }

    //Sets up the main panel that contains the title label and button panel.
    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setLayout(null);

        mainPanel.add(bookingTitle);
        mainPanel.add(buttonPanel);
    }

    //Sets up the frame properties and behavior.
    private void setFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainPanel.setBackground(Color.decode("#fff3e9"));
        setLocation(((homepage.screenWidth / 2) - (width / 2)), ((homepage.screenHeight / 2) - (height / 2)));
        setResizable(false);
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
