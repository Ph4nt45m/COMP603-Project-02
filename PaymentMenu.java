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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author m4ria
 */
public class PaymentMenu extends JFrame {

    //Components
    private JLabel paymentTitle;
    private JButton homeButton;
    private JButton backButton;
    private JLabel firstNameLabel;
    private JTextField firstNameInput;
    private JLabel firstNameErrorMsg;
    private JLabel surnameLabel;
    private JTextField surnameInput;
    private JLabel surnameErrorMsg;
    private JLabel phoneLabel;
    private JComboBox<String> phoneType;
    private JTextField phoneInput;
    private JLabel phoneErrorMsg;
    private JLabel emailLabel;
    private JTextField emailInput;
    private JLabel emailErrorMsg;
    private JLabel cardTitle;
    private JLabel cardLabel;
    private JTextField cardInput;
    private JLabel cardErrorMsg;
    private JLabel expiryLabel;
    private JTextField expiryInput;
    private JLabel expiryErrorMsg;
    private JLabel expiryFormatLabel;
    private JButton saveButton;
    private JPanel mainPanel;

    //Variables
    protected final int width = 720;
    protected final int height = 700;
    protected final String[] phoneTypes = {"Home 09", "Mobile + 64"};
    protected final String[] validEmails = {"@gmail.com", "@outlook.com", "@hotmail.com", "@hotmail.co.nz", "aol.com", "aim.com", "@yahoo.com", "@yahoo.co.nz", "@titan.com", "@icloud.com",
        "@protonmail.com", "@pm.com", "@zoho.com", "@yandex.com", "@gmx.com", "@hubspot.com", "@mail.com", "@tutatota.com", "@autuni.ac.nz"};
    protected LocalDate currentDate;
    protected Homepage homepage;
    protected DiscountMenu discounts;
    protected Vouchers vouchers;
    protected String firstName;
    protected String surname;
    protected String phoneNumber;
    protected String email;
    protected String cardNumber;
    protected String expiry;
    protected int monthExpiry;
    protected int yearExpiry;
    protected boolean expired;
    protected String selectedPhoneType;
    private Booking booking;
    private Room room;

    public PaymentMenu(Homepage home, Vouchers vouchers) {
        this.homepage = home;
        this.vouchers = vouchers;
        setComponents();
    }

    public PaymentMenu(Homepage home, DiscountMenu discount) {
        this.homepage = home;
        this.discounts = discount;
        setComponents();
    }

    private void setComponents() {
        paymentTitle = new JLabel();
        homeButton = new JButton();
        backButton = new JButton();
        firstNameLabel = new JLabel();
        firstNameInput = new JTextField();
        firstNameErrorMsg = new JLabel();
        surnameLabel = new JLabel();
        surnameInput = new JTextField();
        surnameErrorMsg = new JLabel();
        phoneLabel = new JLabel();
        phoneType = new JComboBox();
        phoneInput = new JTextField();
        phoneErrorMsg = new JLabel();
        emailLabel = new JLabel();
        emailInput = new JTextField();
        emailErrorMsg = new JLabel();
        cardTitle = new JLabel();
        cardLabel = new JLabel();
        cardInput = new JTextField();
        cardErrorMsg = new JLabel();
        expiryLabel = new JLabel();
        expiryInput = new JTextField();
        expiryErrorMsg = new JLabel();
        expiryFormatLabel = new JLabel();
        saveButton = new JButton();
        mainPanel = new JPanel();

        setTitle();
        setHomeButton();
        setBackButton();
        setFirstNameLabel();
        setFirstNameInput();
        setFirstNameErrMsg();
        setSurnameLabel();
        setSurnameInput();
        setSurnameErrMsg();
        setPhoneLabel();
        setPhoneType();
        setPhoneInput();
        setPhoneErrMsg();
        setEmailLabel();
        setEmailInput();
        setEmailErrMsg();
        setCardTitle();
        setCardLabel();
        setCardInput();
        setCardErrMsg();
        setExpiryLabel();
        setExpiryInput();
        setExpiryErrMsg();
        setExpiryFormatLabel();
        setSaveButton();
        setMainPanel();
        setFrame();
    }

    private void setTitle() {
        paymentTitle.setFont(new Font("Segoe UI", 0, 24));
        paymentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        paymentTitle.setText("Payment Details");
        paymentTitle.setBounds(((width / 2) - 150), 40, 300, 50);

    }

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

    private void homeButtonAction(ActionEvent evt) {
        disposeCurrent();
        returnToHome();
    }

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

    private void backButtonAction(ActionEvent evt) {
        discounts.setLocation(((homepage.width / 2) - (discounts.width / 2)), ((homepage.height / 2) - (discounts.height / 2)));
        discounts.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    private void setFirstNameLabel() {
        firstNameLabel.setFont(new Font("Segoe UI", 0, 18));
        firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        firstNameLabel.setText("First Name:");
        firstNameLabel.setBounds(30, 140, 120, 30);
    }

    private void setFirstNameInput() {
        firstNameInput.setFont(new Font("Segoe UI", 0, 17));
        firstNameInput.setBounds(180, 140, 290, 30);
    }

    private void setFirstNameErrMsg() {
        firstNameErrorMsg.setForeground(Color.red);
        firstNameErrorMsg.setBounds(490, 140, 200, 30);
    }

    private void setSurnameLabel() {
        surnameLabel.setFont(new Font("Segoe UI", 0, 18));
        surnameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        surnameLabel.setText("Surname:");
        surnameLabel.setBounds(30, 210, 120, 30);
    }

    private void setSurnameInput() {
        surnameInput.setFont(new Font("Segoe UI", 0, 17));
        surnameInput.setBounds(180, 210, 290, 30);
    }

    private void setSurnameErrMsg() {
        surnameErrorMsg.setForeground(Color.red);
        surnameErrorMsg.setBounds(490, 210, 200, 30);
    }

    private void setPhoneLabel() {
        phoneLabel.setFont(new Font("Segoe UI", 0, 18));
        phoneLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        phoneLabel.setText("Phone:");
        phoneLabel.setBounds(30, 280, 120, 30);
    }

    private void setPhoneType() {
        phoneType.setFont(new Font("Segoe UI", 0, 12));
        phoneType.setModel(new DefaultComboBoxModel<>(phoneTypes));
        phoneType.setBounds(180, 280, 90, 30);
    }

    private void setPhoneInput() {
        phoneInput.setFont(new Font("Segoe UI", 0, 17));
        phoneInput.setBounds(270, 280, 200, 30);
    }

    private void setPhoneErrMsg() {
        phoneErrorMsg.setForeground(Color.red);
        phoneErrorMsg.setBounds(490, 280, 200, 30);
    }

    private void setEmailLabel() {
        emailLabel.setFont(new Font("Segoe UI", 0, 18));
        emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        emailLabel.setText("Email:");
        emailLabel.setBounds(30, 350, 120, 30);
    }

    private void setEmailInput() {
        emailInput.setFont(new Font("Segoe UI", 0, 18));
        emailInput.setBounds(180, 350, 290, 30);
    }

    private void setEmailErrMsg() {
        emailErrorMsg.setForeground(Color.red);
        emailErrorMsg.setBounds(490, 350, 200, 30);
    }

    private void setCardTitle() {
        cardTitle.setFont(new Font("Segoe UI", 0, 20));
        cardTitle.setText("Card Details:");
        cardTitle.setBounds(180, 440, 130, 30);
    }

    private void setCardLabel() {
        cardLabel.setFont(new Font("Segoe UI", 0, 18));
        cardLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        cardLabel.setText("Card Number:");
        cardLabel.setBounds(30, 490, 120, 30);
    }

    private void setCardInput() {
        cardInput.setFont(new Font("Segoe UI", 0, 18));
        cardInput.setBounds(180, 490, 290, 30);
    }

    private void setCardErrMsg() {
        cardErrorMsg.setForeground(Color.red);
        cardErrorMsg.setBounds(490, 490, 200, 30);
    }

    private void setExpiryLabel() {
        expiryLabel.setFont(new Font("Segoe UI", 0, 18));
        expiryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        expiryLabel.setText("Expiry:");
        expiryLabel.setBounds(30, 560, 120, 30);
    }

    private void setExpiryInput() {
        expiryInput.setFont(new Font("Segoe UI", 0, 18));
        expiryInput.setBounds(180, 560, 290, 30);
    }

    private void setExpiryErrMsg() {
        expiryErrorMsg.setForeground(Color.red);
        expiryErrorMsg.setBounds(490, 560, 200, 30);
    }

    private void setExpiryFormatLabel() {
        expiryFormatLabel.setFont(new Font("Segoe UI", 2, 16));
        expiryFormatLabel.setText("MM/YYYY");
        expiryFormatLabel.setBounds(180, 595, 90, 25);
    }

    private void setSaveButton() {
        saveButton.setFont(new Font("Segoe UI", 0, 18));
        saveButton.setText("Save");
        saveButton.setBounds(((width / 2) - 45), (height - 55), 90, 30);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButtonAction(e);
            }
        });
    }

    private void saveButtonAction(ActionEvent evt) {
        firstNameErrorMsg.setText("");
        surnameErrorMsg.setText("");
        phoneErrorMsg.setText("");
        emailErrorMsg.setText("");
        cardErrorMsg.setText("");
        expiryErrorMsg.setText("");
        boolean validFirstName = verifyFirstName();
        boolean validSurname = verifySurname();
        boolean validPhone = verifyPhone();
        boolean validEmail = verifyEmail();
        boolean validCard = verifyCard();
        boolean validExpiry = verifyExpiry();

        if (!validFirstName) {
            if (firstNameInput.getText().isEmpty()) {
                firstNameErrorMsg.setText("* Text field required");
            } else {
                firstNameErrorMsg.setText("* Invalid input");
            }
        }
        if (!validSurname) {
            if (surnameInput.getText().isEmpty()) {
                surnameErrorMsg.setText("* Text field required");
            } else {
                surnameErrorMsg.setText("* Invalid input");
            }
        }
        if (!validPhone) {
            if (phoneInput.getText().isEmpty()) {
                phoneErrorMsg.setText("* Text field required");
            } else {
                phoneErrorMsg.setText("* Invalid input");
            }
        }
        if (!validEmail) {
            if (emailInput.getText().isEmpty()) {
                emailErrorMsg.setText("* Text field required");
            } else {
                emailErrorMsg.setText("* Invalid input");
            }
        }
        if (!validCard) {
            if (cardInput.getText().isEmpty()) {
                cardErrorMsg.setText("* Text field required");
            } else {
                cardErrorMsg.setText("* Invalid input");
            }
        }
        if (!validExpiry) {
            if (expiryInput.getText().isEmpty()) {
                expiryErrorMsg.setText("* Text field required");
            } else if (expired) {
                expiryErrorMsg.setText("* Card is expired");
            } else {
                expiryErrorMsg.setText("* Invalid input");
            }
        }

        if ((vouchers == null) && validFirstName && validSurname && validPhone && validEmail && validCard && validExpiry) {
            System.out.println("Valid booking made");
            booking = new Booking();
            booking.dateBooked = discounts.bookDetails.dateBooked;
            booking.dateLeave = discounts.bookDetails.dateLeave;
            booking.firstName = firstName;
            booking.surname = surname;
            makeRoom();
            booking.roomType = room;
            booking.roomType.setIsStudent(discounts.studentDisStatus);
            booking.roomType.setHasChildren(discounts.childDisStatus);
            booking.phoneNumber = phoneNumber;
            booking.email = email;
            homepage.dbManager.addToBookingList(booking);

            if (homepage.dbManager.isBSuccessful()) {
                homepage.dbManager.resetBSuccessful();
                JOptionPane.showMessageDialog(null, "Booking Successful!\nReturning to homepage", "Success", JOptionPane.INFORMATION_MESSAGE);
                disposeCurrent();
                returnToHome();
            } else {
                System.out.println("Failed to add booking");
            }
        } else if ((vouchers != null) && validFirstName && validSurname && validPhone && validEmail && validCard && validExpiry) {
            FileManager fm = new FileManager(vouchers);
            fm.makeVoucher();
            JOptionPane.showMessageDialog(null, "Voucher Sent to Email!\nReturning to Homepage.", "Success", JOptionPane.INFORMATION_MESSAGE);
            disposeVoucherCurrent();
            returnToHome();
        }
    }

    private boolean verifyFirstName() {
        String trimInput = firstNameInput.getText().trim();
        firstNameInput.setText(trimInput);
        if (firstNameInput.getText().isEmpty()) {
            return false;
        }

        String holder = "";
        if (firstNameInput.getText().contains(" ")) {
            holder = firstNameInput.getText().replaceAll(" ", "");
        } else {
            holder = firstNameInput.getText();
        }

        boolean isAlphabetic = true;
        for (int i = 0; i < holder.length(); i++) {
            if (!Character.isLetter(holder.charAt(i))) {
                isAlphabetic = false;
            }
        }

        if (isAlphabetic) {
            if (firstNameInput.getText().contains(" ")) {
                String[] firstNames = firstNameInput.getText().split(" ");
                String temp = "";
                for (String token : firstNames) {
                    if (token.length() > 0) {
                        temp += token.substring(0, 1).toUpperCase()
                                + token.substring(1) + " ";
                    }
                }
                firstName = temp;
            } else {
                String capitalizeInitial = holder.substring(0, 1).toUpperCase();
                String remaining = holder.substring(1);
                firstName = capitalizeInitial + remaining;
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean verifySurname() {
        String trimInput = surnameInput.getText().trim();
        surnameInput.setText(trimInput);
        if (surnameInput.getText().isEmpty()) {
            return false;
        }

        String holder = "";
        if (surnameInput.getText().contains(" ")) {
            holder = surnameInput.getText().replaceAll(" ", "");
        } else {
            holder = surnameInput.getText();
        }

        boolean isAlphabetic = true;
        for (int i = 0; i < holder.length(); i++) {
            if (!Character.isLetter(holder.charAt(i))) {
                isAlphabetic = false;
            }
        }

        if (isAlphabetic) {
            if (surnameInput.getText().contains(" ")) {
                String[] surnames = surnameInput.getText().split(" ");
                String temp = "";
                for (String token : surnames) {
                    if (token.length() > 0) {
                        temp += token.substring(0, 1).toUpperCase()
                                + token.substring(1) + " ";
                    }
                }
                surname = temp;
            } else {
                String capitalizeInitial = holder.substring(0, 1).toUpperCase();
                String remaining = holder.substring(1);
                surname = capitalizeInitial + remaining;
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean verifyPhone() {
        String trimInput = phoneInput.getText().trim();
        phoneInput.setText(trimInput);
        boolean valid = true;
        if (phoneInput.getText().isEmpty()) {
            valid = false;
        } else {
            selectedPhoneType = (String) phoneType.getSelectedItem();
            if (selectedPhoneType.contains("Home")) {
                valid = homePhone();
            } else if (selectedPhoneType.contains("Mobile")) {
                valid = mobilePhone();
            }
        }

        return valid;
    }

    private boolean homePhone() {
        String holder = phoneInput.getText();
        String temp = "";
        if (holder.startsWith("09")) {
            temp = holder.substring(2);
            holder = temp.trim();
        }
        if (holder.contains(" ")) {
            int spaceCount = 0;
            for (int i = 0; i < holder.length(); i++) {
                if (holder.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
            if (spaceCount > 1) {
                return false;
            } else {
                temp = holder.replaceAll(" ", "");
                holder = temp;
            }
        }
        if (holder.length() != 7) {
            return false;
        }

        boolean isDigit = true;
        for (int i = 0; i < holder.length(); i++) {
            if (!Character.isDigit(holder.charAt(i))) {
                isDigit = false;
            }
        }

        if (isDigit) {
            if (phoneInput.getText().contains(" ")) {
                String[] check = phoneInput.getText().split(" ");

                if (check[0].length() != 3 || check[1].length() != 4) {
                    return false;
                } else {
                    phoneNumber = "09 " + phoneInput.getText();
                }
            } else {
                phoneNumber = "09 " + phoneInput.getText().substring(0, 3) +
                        " " + phoneInput.getText().substring(3);
            }
        } else {
            return false;
        }

        return true;
    }

    private boolean mobilePhone() {
        String holder = phoneInput.getText();
        String temp = "";
        if (holder.startsWith("+64")) {
            temp = holder.substring(3);
        } else if (holder.startsWith("64")) {
            temp = holder.substring(2);
        } else {
            temp = holder;
        }

        if (temp.startsWith("0")) {
            holder = temp.substring(1);
        } else {
            holder = temp;
        }

        int spaceCount = 0;
        if (holder.contains(" ")) {
            for (int i = 0; i < holder.length(); i++) {
                if (holder.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
            if (spaceCount > 2) {
                return false;
            } else {
                temp = holder.replaceAll(" ", "");
            }
        } else {
            temp = holder;
        }

        if (temp.length() != 9) {
            return false;
        }

        boolean isDigit = true;
        for (int i = 0; i < temp.length(); i++) {
            if (!Character.isDigit(temp.charAt(i))) {
                isDigit = false;
            }
        }

        if (isDigit) {
            if (phoneInput.getText().contains(" ")) {
                String[] check = phoneInput.getText().split(" ");
                if (spaceCount == 2) {
                    if (check[0].length() != 2 || check[1].length() != 3 || check[2].length() != 4) {
                        return false;
                    } else {
                        phoneNumber = "+64 " + phoneInput.getText();
                    }
                } else if (spaceCount == 1) {
                    if (check[0].length() != 2 || check[1].length() != 7) {
                        return false;
                    } else {
                        phoneNumber = "+64 " + temp.substring(0,2) + " " +
                                temp.substring(2,5) + " " +
                                temp.substring(5);
                    }
                }
            } else {
                phoneNumber = "+64 " + temp.substring(0,2) + " " +
                        temp.substring(2,5) + " " +
                        temp.substring(5);
            }
            phoneInput.setText(temp);
        } else {
            return false;
        }

        return true;
    }

    private boolean verifyEmail() {
        String trimInput = emailInput.getText().trim();
        emailInput.setText(trimInput);
        boolean validEmail = false;
        if (emailInput.getText().isEmpty()) {
            return validEmail;
        }
        if (!emailInput.getText().contains("@") || emailInput.getText().contains(" ")) {
            return validEmail;
        }

        String[] holder = emailInput.getText().split("@");
        if (holder.length != 2) {
            return validEmail;
        }
        if (holder[0].isEmpty()) {
            return validEmail;
        }

        boolean valid = true;
        for (int i = 0; i < holder[0].length(); i++) {
            if (!Character.isAlphabetic(holder[0].charAt(i)) && !Character.isDigit(holder[0].charAt(i))) {
                valid = false;
            }
        }

        if (valid) {
            for (String suffix : validEmails) {
                if (suffix.contains(holder[1])) {
                    validEmail = true;
                    email = emailInput.getText();
                    break;
                }
            }
        }

        return validEmail;
    }

    private boolean verifyCard() {
        String trimInput = cardInput.getText().trim();
        cardInput.setText(trimInput);
        boolean validCard = false;
        if (cardInput.getText().isEmpty()) {
            return validCard;
        }

        List<String> cardNumbers = new ArrayList<>();
        if (cardInput.getText().contains(" ")) {
            cardNumbers = Arrays.asList(cardInput.getText().split(" "));
        } else {
            for (int i = 0; i < cardInput.getText().length(); i += 4) {
                if (i + 4 < cardInput.getText().length()) {
                    cardNumbers.add(cardInput.getText().substring(i, i + 4));
                } else {
                    cardNumbers.add(cardInput.getText().substring(i));
                }
            }
        }

        boolean isDigit = true;
        boolean validLength = true;
        if (cardNumbers.size() == 4) {
            for (String token : cardNumbers) {
                if (token.length() == 4) {
                    for (int i = 0; i < token.length(); i++) {
                        if (!Character.isDigit(token.charAt(i))) {
                            isDigit = false;
                            break;
                        }
                    }
                } else {
                    validLength = false;
                    break;
                }

                if (!isDigit) {
                    break;
                }
            }
        } else {
            validLength = false;
        }

        if (isDigit && validLength) {
            validCard = true;
            for (String token : cardNumbers) {
                cardNumber += token + " ";
            }
        }

        return validCard;
    }

    private boolean verifyExpiry() {
        String trimInput = expiryInput.getText().trim();
        expiryInput.setText(trimInput);
        boolean validExpiry = false;
        if (expiryInput.getText().isEmpty()) {
            return validExpiry;
        }
        if (!expiryInput.getText().contains("/")) {
            return validExpiry;
        }
        if (!verifyCharacters(expiryInput.getText())) {
            return validExpiry;
        }

        boolean isDigit = true;
        String[] holder = expiryInput.getText().split("/");
        for (int i = 0, j = 0; i < holder.length; j++) {
            if (!Character.isDigit(holder[i].charAt(j))) {
                isDigit = false;
            }
            if (j == holder[i].length() - 1) {
                i++;
            }
        }

        if (isDigit) {
            validExpiry = verifyDate(expiryInput.getText());
        }

        return validExpiry;
    }

    private boolean verifyCharacters(String date) {
        boolean valid = true;
        if (date.length() != 7) {
            valid = false;
        }

        int slashCount = 0;
        if (valid) {
            for (int i = 0; i < date.length(); i++) {
                char temp = date.charAt(i);
                if (!Character.isDigit(temp) && temp != '/') {
                    valid = false;
                    break;
                } else if (temp == '/') {
                    slashCount++;
                }

                if (slashCount > 1) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid && slashCount != 1) {
            valid = false;
        } else if (valid && slashCount == 1) {
            String[] holder = date.split("/");
            if (holder.length != 2) {
                valid = false;
            }
            if (!(holder[0].length() > 0 && holder[0].length() <= 2)) {
                valid = false;
            }
            if (holder[1].length() != 4) {
                valid = false;
            }
        }

        return valid;
    }

    private boolean verifyDate(String date) {
        currentDate = LocalDate.now();
        expired = false;
        String[] holder = date.split("/");
        int month = Integer.parseInt(holder[0]);
        int year = Integer.parseInt(holder[1]);
        boolean valid = true;

        if (year < currentDate.getYear()) {
            expired = true;
            valid = false;
        }

        if (valid) {
            if (!(month > 0 && month <= 12)) {
                valid = false;
            }
        }

        if (valid) {
            if (year == currentDate.getYear() && month == currentDate.getMonthValue()) {
                expired = true;
                valid = false;
            }
        }

        return valid;
    }

    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setLayout(null);

        mainPanel.add(paymentTitle);
        mainPanel.add(homeButton);
        mainPanel.add(backButton);
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameInput);
        mainPanel.add(firstNameErrorMsg);
        mainPanel.add(surnameLabel);
        mainPanel.add(surnameInput);
        mainPanel.add(surnameErrorMsg);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneType);
        mainPanel.add(phoneInput);
        mainPanel.add(phoneErrorMsg);
        mainPanel.add(emailLabel);
        mainPanel.add(emailInput);
        mainPanel.add(emailErrorMsg);
        mainPanel.add(cardTitle);
        mainPanel.add(cardLabel);
        mainPanel.add(cardInput);
        mainPanel.add(cardErrorMsg);
        mainPanel.add(expiryLabel);
        mainPanel.add(expiryInput);
        mainPanel.add(expiryErrorMsg);
        mainPanel.add(expiryFormatLabel);
        mainPanel.add(saveButton);

        getContentPane().add(mainPanel);
        pack();
    }

    private void setFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainPanel.setBackground(Color.decode("#fff3e9"));
        setLocation(((homepage.screenWidth / 2) - (width / 2)), ((homepage.screenHeight / 2) - (height / 2)));
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                homepage.dbManager.closeConnections();

                dispose();
                System.exit(0);
            }
        });
    }

    private void disposeVoucherCurrent() {
        vouchers.voucherDetails.dispose();
        vouchers.dispose();
    }

    private void disposeCurrent() {
        if (discounts.isDisplayable()) {
            discounts.dispose();
        }
        if (discounts.bookDetails.isDisplayable()) {
            discounts.bookDetails.dispose();
        }
        if (discounts.bookDetails.roomTypes.isDisplayable()) {
            discounts.bookDetails.roomTypes.dispose();
        }
        if (discounts.bookDetails.roomTypes.roomDetails.isDisplayable()) {
            discounts.bookDetails.roomTypes.roomDetails.dispose();
        }
        if (discounts.bookDetails.roomTypes.booking.isDisplayable()) {
            discounts.bookDetails.roomTypes.booking.dispose();
        }
    }

    private void returnToHome() {
        homepage.setLocation((homepage.screenWidth / 2) - (homepage.width / 2), ((homepage.screenHeight / 2) - (homepage.height / 2)));
        homepage.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    private void makeRoom() {
        if (homepage.bookingMenu.roomTypesMenu.selectedRoom.contains("Single")) {
            room = new SingleRoom();
        } else if (homepage.bookingMenu.roomTypesMenu.selectedRoom.contains("Double")) {
            room = new DoubleRoom();
        } else if (homepage.bookingMenu.roomTypesMenu.selectedRoom.contains("Family")) {
            room = new FamilyRoom();
        } else if (homepage.bookingMenu.roomTypesMenu.selectedRoom.contains("Group")) {
            room = new GroupRoom();
        }
    }
}
