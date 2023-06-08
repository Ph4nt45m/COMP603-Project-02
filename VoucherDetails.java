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

    private JPanel mainPanel;
    private JTextField recipientField;
    private JTextField giverField;
    JButton returnButton;
    Homepage homepage;
    private JTextField amountField = null; // Declare at the class level
    private JButton backButton;
    private JButton purchaseButton;
    Vouchers vouchers;
    protected String recipient;
    protected String giver;

    public VoucherDetails(Vouchers vouchers, Homepage home) {
        this.homepage = home;
        this.vouchers = vouchers;
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
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

    private void title() {

        JLabel titleLabel = new JLabel("Marl Avenue Hotel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(20, 10, 200, 30);

        mainPanel.add(titleLabel);
    }

    private void returnToHomepage() {

        returnButton = new JButton("Return to Homepage");
        returnButton.setBounds(20, 40, 150, 20);

        mainPanel.add(returnButton);
    }

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

    private void createForm(String voucherType) {
        JLabel titleLabel = new JLabel("Voucher Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(220, 70, 250, 30);

        JLabel recipientLabel = new JLabel("Recipient:");
        recipientLabel.setBounds(20, 120, 80, 20);

        recipientField = new JTextField();
        recipientField.setBounds(100, 120, 200, 20);

        JLabel giverLabel = new JLabel("Giver:");
        giverLabel.setBounds(20, 150, 80, 20);

        giverField = new JTextField();
        giverField.setBounds(100, 150, 200, 20);

        mainPanel.add(titleLabel);
        mainPanel.add(recipientLabel);
        mainPanel.add(recipientField);
        mainPanel.add(giverLabel);
        mainPanel.add(giverField);

        if (voucherType.equalsIgnoreCase("Momentary Gift Voucher")) {
            JLabel amountLabel = new JLabel("Amount:");
            amountLabel.setBounds(20, 180, 80, 20);

            amountField = new JTextField();
            amountField.setBounds(100, 180, 200, 20);

            mainPanel.add(amountLabel);
            mainPanel.add(amountField);
        }

//        mainPanel.add(continueButton);
    }

//    private void continueButtonClicked() {
//        recipient = recipientField.getText();
//        giver = giverField.getText();
//
//        if (amountField != null) {
//            // $200 gift voucher
//            String amount = amountField.getText();
//            System.out.println("Recipient: " + recipient);
//            System.out.println("Giver: " + giver);
//            System.out.println("Amount: " + amount);
//        } else {
//            // Momentary gift voucher
//            System.out.println("Recipient: " + recipient);
//            System.out.println("Giver: " + giver);
//        }
//
//        // Close the current frame
//        this.dispose();
//    }
//    private void purchaseButton() {
//
//        JButton purchase = new JButton("Purchase");
//        purchase.setBounds(380, 270, 100, 20);
//
//        purchase.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                purchaseButtonClicked();
//            }
//        });
//
//        mainPanel.add(purchase);
//    }
//
//    private void purchaseButtonClicked() {
//
////        String selectedVoucher = voucherOptionsGroup.getSelection().getActionCommand();
//        PaymentMenu paymentMenu = new PaymentMenu(homepage, this);
//        paymentMenu.setVisible(true);
//
//        // Close the Vouchers frame if payment is successful
//        this.dispose();
//    }
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

    private void purchaseButtonAction(ActionEvent evt) {
        PaymentMenu paymentMenu = new PaymentMenu(homepage, vouchers);
        paymentMenu.setLocationRelativeTo(null);
        paymentMenu.setVisible(true);
        dispose();
    }

    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }

    private void backButtonClicked() {
        // Dispose the current frame and show the homepage frame
        this.dispose();
        vouchers.setVisible(true);
    }

}
