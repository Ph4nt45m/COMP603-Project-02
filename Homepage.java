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
    private final JLabel imageLabel;

    //Constructs a new Homepage object.
    public Homepage() {
        this.dbManager = new DBManager();
        this.dbManager.establishConnection();
        this.toolKit = Toolkit.getDefaultToolkit();
        this.screenDim = toolKit.getScreenSize();
        this.screenWidth = screenDim.width;
        this.screenHeight = screenDim.height;
        this.imageLabel = new JLabel(new ImageIcon("./resources/logo.png"));
        setComponents();
    }

    //Sets up the components of the homepage.
    private void setComponents() {
        title = new JLabel();
        bookingButton = new JButton();
        facilitiesButton = new JButton();
        faqsButton = new JButton();
        vouchersButton = new JButton();
        contactsButton = new JButton();
        buttonPanel = new JPanel();
        mainPanel = new JPanel();

        settingLogo();
        setBookingButton();
        setFacilitiesButton();
        setFAQsButton();
        setVouchersButton();
        setContactsButton();
        setButtonPanel();
        setMainPanel();
        setFrame();
    }

    //Sets up the logo for the homepage.
    private void settingLogo() {
        imageLabel.setBounds(0, 0, 800, 200);
        mainPanel.add(imageLabel);
    }

    //Sets up the booking button.
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

    //Handles the action when the booking button is clicked.
    private void bookingButton(ActionEvent evt) {
        bookingMenu = new BookingMenu(this);
        setVisible(false);
    }

    //Sets up the facilities button.
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

    //Handles the action when the facilities button is clicked.
    private void facilitiesButton(ActionEvent evt) {
        setVisible(false);
        facilities = new Facilities(this);
        facilities.setLocationRelativeTo(null);
        facilities.setVisible(true);
    }

    //Sets up the FAQs button.
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

    //Handles the action when the FAQs button is clicked.
    private void faqsButton(ActionEvent evt) throws SQLException {
        setVisible(false);
        faq = new FAQ(this);
        faq.setLocationRelativeTo(null);
        faq.setVisible(true);
    }

    //Sets up the vouchers button.
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

    //Handles the action when the vouchers button is clicked.
    private void vouchersButton(ActionEvent evt) {
        voucherMenu = new Vouchers(this);
        voucherMenu.setVisible(true);
        setVisible(false);
    }

    //Sets up the contacts button.
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

    //Handles the action when the contacts button is clicked.
    private void contactButton(ActionEvent evt) {
        setVisible(false);
        contacts = new Contacts(this);
        contacts.setLocationRelativeTo(null);
        contacts.setVisible(true);
    }

    //Sets up the button panel.
    private void setButtonPanel() {
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBounds(310, 220, 200, 290);
        buttonPanel.setBackground(Color.decode("#fff3e9"));

        buttonPanel.add(bookingButton);
        buttonPanel.add(facilitiesButton);
        buttonPanel.add(faqsButton);
        buttonPanel.add(vouchersButton);
        buttonPanel.add(contactsButton);
    }

    //Sets up the main panel.
    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setLayout(null);

        mainPanel.add(title);
        mainPanel.add(buttonPanel);
    }

    //Sets up the frame properties.
    private void setFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Marl Avenue Hotel");
        mainPanel.setBackground(Color.decode("#fff3e9"));

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
