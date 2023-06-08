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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m4ria
 */
public class Homepage extends JFrame {

    private JLabel title;
    private JButton bookingButton;
    private JButton facilitiesButton;
    private JButton faqsButton;
    private JButton vouchersButton;
    private JButton contactsButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    protected final int screenWidth;
    protected final int screenHeight;
    protected final int width = 800;
    protected final int height = 600;
    protected DBManager dbManager;
    protected BookingMenu bookingMenu;
    protected Facilities facilities;
    protected Vouchers voucherMenu;
    protected Contacts contacts;
    protected FAQ faq;
    private final Toolkit toolKit;
    private final Dimension screenDim;

    public Homepage() {
        this.dbManager = new DBManager();
        this.dbManager.establishConnection();
        this.toolKit = Toolkit.getDefaultToolkit();
        this.screenDim = toolKit.getScreenSize();
        this.screenWidth = screenDim.width;
        this.screenHeight = screenDim.height;
        setComponents();
    }

    private void setComponents() {
        title = new JLabel();
        bookingButton = new JButton();
        facilitiesButton = new JButton();
        faqsButton = new JButton();
        vouchersButton = new JButton();
        contactsButton = new JButton();
        buttonPanel = new JPanel();
        mainPanel = new JPanel();

        setTitle();
        setBookingButton();
        setFacilitiesButton();
        setFAQsButton();
        setVouchersButton();
        setContactsButton();
        setButtonPanel();
        setMainPanel();
        setFrame();
    }

    private void setTitle() {
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setText("Welcome to Marl Avenue Hotel");
        title.setBounds(30, 0, 600, 200);
    }

    private void setBookingButton() {
        bookingButton.setFont(new Font("Segoe UI", 0, 16));
        bookingButton.setText("Booking");
        bookingButton.setPreferredSize(new Dimension(200, 45));
        
        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingButton(e);
            }
        });
    }

    private void bookingButton(ActionEvent evt) {
        bookingMenu = new BookingMenu(this);
        setVisible(false);
    }

    private void setFacilitiesButton() {
        facilitiesButton.setFont(new Font("Segoe UI", 0, 16));
        facilitiesButton.setText("Facilities");
        facilitiesButton.setPreferredSize(new Dimension(200, 45));
        
        facilitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitiesButton(e);
            }
        });
    }

    private void facilitiesButton(ActionEvent evt) {
        setVisible(false);
        facilities = new Facilities(this);
        facilities.setLocationRelativeTo(null);
        facilities.setVisible(true);
    }

    private void setFAQsButton() {
        faqsButton.setFont(new Font("Segoe UI", 0, 16));
        faqsButton.setText("FAQ");
        faqsButton.setPreferredSize(new Dimension(200, 45));
        
        faqsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    faqsButton(e);
                } catch (SQLException ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void faqsButton(ActionEvent evt) throws SQLException {
        setVisible(false);
        faq = new FAQ(this);
        faq.setLocationRelativeTo(null);
        faq.setVisible(true);
    }

    private void setVouchersButton() {
        vouchersButton.setFont(new Font("Segoe UI", 0, 16));
        vouchersButton.setText("Vouchers");
        vouchersButton.setPreferredSize(new Dimension(200, 45));
        
        vouchersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vouchersButton(e);
            }
        });
    }

    private void vouchersButton(ActionEvent evt) {
        voucherMenu = new Vouchers(this);
        voucherMenu.setVisible(true);
        setVisible(false);
    }

    private void setContactsButton() {
        contactsButton.setFont(new Font("Segoe UI", 0, 16));
        contactsButton.setText("Contact Us");
        contactsButton.setPreferredSize(new Dimension(200, 45));
        
        contactsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactButton(e);
            }
        });
    }

    private void contactButton(ActionEvent evt) {
        setVisible(false);
        contacts = new Contacts(this);
        contacts.setLocationRelativeTo(null);
        contacts.setVisible(true);
    }

    private void setButtonPanel() {
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBounds(20, 220, 200, 290);

        buttonPanel.add(bookingButton);
        buttonPanel.add(facilitiesButton);
        buttonPanel.add(faqsButton);
        buttonPanel.add(vouchersButton);
        buttonPanel.add(contactsButton);
    }

    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setLayout(null);

        mainPanel.add(title);
        mainPanel.add(buttonPanel);
    }
    
    private void setFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Marl Avenue Hotel");
        setBackground(Color.WHITE);
        setLocation(((screenWidth / 2) - (width / 2)), ((screenHeight / 2) - (height / 2)));
        setResizable(false);
        getContentPane().add(mainPanel);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dbManager.closeConnections();
                dispose();

                System.exit(0);
            }
        });
        
        setVisible(true);
    }
}
