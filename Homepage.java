/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author m4ria
 */
public class Homepage extends JFrame {

    protected DBManager dbManager;
    protected Booking bookingMenu;
    protected Facilities facilities;
    protected Vouchers vouchers;
    protected Contacts contacts;

    Toolkit toolKit;
    Dimension screenDim;
    int width;

    public Homepage() {
        dbManager = new DBManager();
        dbManager.establishConnection();
        toolKit = Toolkit.getDefaultToolkit();
        screenDim = toolKit.getScreenSize();
        width = screenDim.width;
        setComponents();
        setLocation((width / 2) - (this.getWidth() / 2), 200);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dbManager.closeConnections();

                dispose();
                System.exit(0);
            }
        });
    }

    private void setComponents() {
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton booking = new JButton("Booking");
        JButton facilities = new JButton("Facilities");
        JButton faqs = new JButton("FAQ");
        JButton vouchers = new JButton("Vouchers");
        JButton contact = new JButton("Contact");
        JLabel title = new JLabel();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Welcome to Marl Avenue Hotel");
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));
        setResizable(false);

        mainPanel.setLayout(null);

        buttonPanel.setPreferredSize(new Dimension(200, 270));
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBounds(20, 220, 200, 290);

        booking.setPreferredSize(new Dimension(200, 45));
        booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingButton(e);
            }
        });

        facilities.setPreferredSize(new Dimension(200, 45));
        facilities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitiesButton(e);
            }
        });

        faqs.setPreferredSize(new Dimension(200, 45));
        faqs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                faqButton(e);
            }
        });

        vouchers.setPreferredSize(new Dimension(200, 45));
        vouchers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vouchersButton(e);
            }
        });

        contact.setPreferredSize(new Dimension(200, 45));
        contact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactButton(e);
            }
        });

        buttonPanel.add(booking);
        buttonPanel.add(facilities);
        buttonPanel.add(faqs);
        buttonPanel.add(vouchers);
        buttonPanel.add(contact);

        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setText("Welcome to Marl Avenue Hotel");
        title.setBounds(30, 0, 600, 200);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);

        pack();
    }

    private void bookingButton(ActionEvent event) {
        setVisible(false);
        bookingMenu = new Booking(this);
        bookingMenu.setLocationRelativeTo(null);
        bookingMenu.setVisible(true);
    }

    private void facilitiesButton(ActionEvent event) {
        setVisible(false);
        facilities = new Facilities(this);
        facilities.setLocationRelativeTo(null);
        facilities.setVisible(true);
    }

    private void faqButton(ActionEvent event) {

    }

    private void vouchersButton(ActionEvent event) {
        setVisible(false);
        vouchers = new Vouchers(this);
        vouchers.setLocationRelativeTo(null);
        vouchers.setVisible(true);
    }

    private void contactButton(ActionEvent event) {
        setVisible(false);
        contacts = new Contacts(this);
        contacts.setLocationRelativeTo(null);
        contacts.setVisible(true);
    }
}
