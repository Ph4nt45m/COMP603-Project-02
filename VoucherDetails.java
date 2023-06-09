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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    protected int amount;

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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                homepage.dbManager.closeConnections();

                dispose();
                System.exit(0);
            }
        });
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

        if (voucherType.contains("momentary")) {
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
        boolean validRecipient = false;
        boolean validGiver = false;
        validRecipient = verifyRecipient();
        validGiver = verifyGiver();

        if (validRecipient && validGiver) {
            paymentMenu = new PaymentMenu(homepage, vouchers);
            paymentMenu.setLocationRelativeTo(null);
            paymentMenu.setVisible(true);

            if (vouchers.selectedVoucher.contains("momentary")) {
                if (verifyAmount()) {
                    amount = Integer.parseInt(amountField.getText());

                }
            }
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please input "
                    + "recipient and giver names", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Verifies the amount that is inputted into the momentary voucher.
    private boolean verifyAmount() {
        String holder = amountField.getText().trim();
        if (holder.isEmpty()) {
            return false;
        }

        boolean isDigit = true;
        for (int i = 0; i < holder.length(); i++) {
            if (!Character.isDigit(holder.charAt(i))) {
                isDigit = false;
                break;
            }
        }

        if (isDigit) {
            return true;
        } else {
            return false;
        }
    }

    /*Verifies the validity of the recipient name entered in the recipient field.
    *Trims the input, checks if it is empty, and removes any whitespace.
    *Checks if the input contains only alphabetic characters and capitalizes the first letter if it is valid.
    *Returns false if the input is empty or contains non-alphabetic characters, otherwise it returns true
     */
    private boolean verifyRecipient() {
        String trimInput = recipientField.getText().trim();
        recipientField.setText(trimInput);
        if (recipientField.getText().isEmpty()) {
            return false;
        }

        String holder = "";
        if (recipientField.getText().contains(" ")) {
            holder = recipientField.getText().replaceAll(" ", "");
        } else {
            holder = recipientField.getText();
        }

        boolean isAlphabetic = true;
        for (int i = 0; i < holder.length(); i++) {
            if (!Character.isLetter(holder.charAt(i))) {
                isAlphabetic = false;
            }
        }

        if (isAlphabetic) {
            if (recipientField.getText().contains(" ")) {
                String[] firstNames = recipientField.getText().split(" ");
                String temp = "";
                for (String token : firstNames) {
                    if (token.length() > 0) {
                        temp += token.substring(0, 1).toUpperCase()
                                + token.substring(1) + " ";
                    }
                }
                recipient = temp;
            } else {
                String capitalizeInitial = holder.substring(0, 1).toUpperCase();
                String remaining = holder.substring(1);
                recipient = capitalizeInitial + remaining;
            }
        } else {
            return false;
        }

        return true;
    }

    /*Verifies the validity of the giver name entered in the giver field.
    *Trims the input, checks if it is empty, and removes any whitespace.
    *Checks if the input contains only alphabetic characters and capitalizes the first letter if it is valid.
    *Returns false if the input is empty or contains non-alphabetic characters, otherwise it returns true
     */
    private boolean verifyGiver() {
        String trimInput = giverField.getText().trim();
        giverField.setText(trimInput);
        if (giverField.getText().isEmpty()) {
            return false;
        }

        String holder = "";
        if (giverField.getText().contains(" ")) {
            holder = giverField.getText().replaceAll(" ", "");
        } else {
            holder = giverField.getText();
        }

        boolean isAlphabetic = true;
        for (int i = 0; i < holder.length(); i++) {
            if (!Character.isLetter(holder.charAt(i))) {
                isAlphabetic = false;
            }
        }

        if (isAlphabetic) {
            if (giverField.getText().contains(" ")) {
                String[] firstNames = giverField.getText().split(" ");
                String temp = "";
                for (String token : firstNames) {
                    if (token.length() > 0) {
                        temp += token.substring(0, 1).toUpperCase()
                                + token.substring(1) + " ";
                    }
                }
                giver = temp;
            } else {
                String capitalizeInitial = holder.substring(0, 1).toUpperCase();
                String remaining = holder.substring(1);
                giver = capitalizeInitial + remaining;
            }
        } else {
            return false;
        }

        return true;
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
