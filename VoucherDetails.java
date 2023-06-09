/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author m4ria
 */
public class VoucherDetails extends JFrame {

    Homepage homepage;
    Vouchers vouchers;
    PaymentMenu paymentMenu;

    private final JPanel mainPanel;
    private JTextField recipientField;
    private JTextField giverField;
    private JButton returnButton;
    private JTextField amountField = null;
    private JButton backButton;
    private JButton purchaseButton;
    private JLabel titleLabel;
    private JLabel voucherLabel;
    private JLabel recipientLabel;
    private JLabel giverLabel;
    private JLabel amountLabel;
    protected String recipient;
    protected String giver;

    /*Constructs a VoucherDetails object with the specified Vouchers and 
    *Homepage objects.
     */
    public VoucherDetails(Vouchers vouchers, Homepage home) {
        this.homepage = home;
        this.vouchers = vouchers;

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#fff3e9"));
        mainPanel.setPreferredSize(new Dimension(500, 300));

        setResizable(false);
        setTitle("Voucher Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu();

        createForm(vouchers.selectedVoucher);

        getContentPane().add(mainPanel);
        pack();
        setVisible(true);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });
    }

    //Sets up the menu of the JFrame by calling various helper methods.
    private void menu() {
        setTitle("Vouchers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title();
        returnToHomepage();
        createBackButton();
        purchaseButton();

        getContentPane().add(mainPanel);
        pack();
    }

    //Sets up the title label of the JFrame.
    private void title() {

        titleLabel = new JLabel("Marl Avenue Hotel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(20, 10, 200, 30);

        mainPanel.add(titleLabel);
    }

    /*Adds a return button to the main panel with the text "Return to Homepage" 
    *and sets its position.
     */
    private void returnToHomepage() {

        returnButton = new JButton("Return to Homepage");
        returnButton.setBounds(20, 40, 150, 20);

        mainPanel.add(returnButton);
    }

    //Creates a back button and adds it to the JFrame.
    private void createBackButton() {
        backButton = new JButton("Back");
        backButton.setBounds(20, 70, 100, 20);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonClicked();
            }
        });

        mainPanel.add(backButton);
    }

    /*Creates the form for entering recipient and giver information based on 
    *the selected voucher type.
     */
    private void createForm(String voucherType) {
        voucherLabel = new JLabel("Voucher Details");
        voucherLabel.setFont(new Font("Arial", Font.BOLD, 24));
        voucherLabel.setBounds(220, 70, 250, 30);

        recipientLabel = new JLabel("Recipient:");
        recipientLabel.setBounds(20, 120, 80, 20);

        recipientField = new JTextField();
        recipientField.setBounds(100, 120, 200, 20);

        giverLabel = new JLabel("Giver:");
        giverLabel.setBounds(20, 150, 80, 20);

        giverField = new JTextField();
        giverField.setBounds(100, 150, 200, 20);

        mainPanel.add(titleLabel);
        mainPanel.add(recipientLabel);
        mainPanel.add(recipientField);
        mainPanel.add(giverLabel);
        mainPanel.add(giverField);

        if (voucherType.equalsIgnoreCase("Momentary Gift Voucher")) {
            amountLabel = new JLabel("Amount:");
            amountLabel.setBounds(20, 180, 80, 20);

            amountField = new JTextField();
            amountField.setBounds(100, 180, 200, 20);

            mainPanel.add(amountLabel);
            mainPanel.add(amountField);
        }
    }

    //Adds a purchase button to the JFrame.
    private void purchaseButton() {
        purchaseButton = new JButton();
        purchaseButton.setText("Purchase");
        purchaseButton.setBounds(380, 270, 100, 20);

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchaseButtonAction(e);
            }
        });

        mainPanel.add(purchaseButton);
    }

    /*Action performed when the purchase button is clicked. Creates a 
    *PaymentMenu object, sets its location, makes it visible, and disposes of 
    *the current frame.
     */
    private void purchaseButtonAction(ActionEvent evt) {
        paymentMenu = new PaymentMenu(homepage, vouchers);
        paymentMenu.setLocationRelativeTo(null);
        paymentMenu.setVisible(true);

        dispose();
    }

    /*Action performed when the homepage button is clicked. Disposes of the
    *current frame and makes the homepage frame visible.
     */
    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }

    /*Action performed when the back button is clicked. Disposes of the current 
    *frame and makes the vouchers frame visible.
     */
    private void backButtonClicked() {
        this.dispose();
        vouchers.setVisible(true);
    }

}
