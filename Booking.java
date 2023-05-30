/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author snipi
 */
public class Booking extends JFrame {

    Homepage homepage;
    RoomTypes roomTypesMenu;

    public Booking(Homepage home) {
        this.homepage = home;
        setComponents();
        setLocation((homepage.width / 2) - (this.getWidth() / 2), 200);

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
        JPanel mainPanel = new JPanel();
        JLabel bookingTitle = new JLabel();
        JPanel buttonPanel = new JPanel();
        JButton makeBooking = new JButton();
        JButton checkBooking = new JButton();
        JButton returnHomepage = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(250, 310));
        Border border = BorderFactory.createEmptyBorder(15, 25, 15, 25);
        mainPanel.setBorder(border);
        setResizable(false);
        
        mainPanel.setLayout(null);

        bookingTitle.setFont(new java.awt.Font("Segoe UI", 0, 24));
        bookingTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookingTitle.setText("Booking Menu");
        bookingTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bookingTitle.setBounds(25, 25, 200, 35);

        buttonPanel.setPreferredSize(new Dimension(200, 220));
        buttonPanel.setBounds(25, 90, 200, 170);

        makeBooking.setText("Make a Booking");
        makeBooking.setPreferredSize(new Dimension(200, 45));
        makeBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                makeBookingActionPerformed(evt);
            }
        });

        checkBooking.setText("Check my Booking");
        checkBooking.setPreferredSize(new Dimension(200, 45));
        checkBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkBookingActionPerformed(evt);
            }
        });

        returnHomepage.setText("Return to Homepage");
        returnHomepage.setPreferredSize(new Dimension(200, 45));
        returnHomepage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                returnHomepageActionPerformed(evt);
            }
        });

        buttonPanel.add(makeBooking);
        buttonPanel.add(checkBooking);
        buttonPanel.add(returnHomepage);

        mainPanel.add(bookingTitle, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);

        pack();
    }

    private void makeBookingActionPerformed(ActionEvent evt) {
        roomTypesMenu = new RoomTypes(homepage, this);
        setVisible(false);
    }

    private void checkBookingActionPerformed(ActionEvent evt) {
        
    }

    private void returnHomepageActionPerformed(ActionEvent evt) {
        homepage.setVisible(true);
        homepage.setLocationRelativeTo(null);
        dispose();
    }
}
