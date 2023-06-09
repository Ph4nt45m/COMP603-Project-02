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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

/**
 *
 * @author snipi
 */
public class CheckBooking extends JFrame {

    private JButton homeButton;
    private JButton backButton;
    private JLabel title;
    private JLabel firstNameLabel;
    private JTextField firstNameInput;
    private JLabel firstNameErrorMsg;
    private JLabel surnameLabel;
    private JTextField surnameInput;
    private JLabel surnameErrorMsg;
    private JLabel phoneLabel;
    private JComboBox<String> phoneTypes;
    private JTextField phoneInput;
    private JLabel phoneErrorMsg;
    private JButton findButton;
    private JTextPane result;
    private JScrollPane scrollPane;
    private JPanel mainPanel;

    protected final int width = 800;
    protected final int height = 740;
    protected final String[] phTypes = {"Home 09", "Mobile + 64"};
    protected Homepage homepage;
    protected BookingMenu bookingMenu;
    protected String firstName;
    protected String surname;
    protected String phone;
    protected String selectedPhoneType;

        //Constructs a CheckBooking object with the specified Homepage and BookingMenu.
    public CheckBooking(Homepage home, BookingMenu bookMenu) {
        this.homepage = home;
        this.bookingMenu = bookMenu;
        setComponents();
    }

        //Sets up the components of the JFrame.
    private void setComponents() {
        homeButton = new JButton();
        backButton = new JButton();
        title = new JLabel();
        firstNameLabel = new JLabel();
        firstNameInput = new JTextField();
        firstNameErrorMsg = new JLabel();
        surnameLabel = new JLabel();
        surnameInput = new JTextField();
        surnameErrorMsg = new JLabel();
        phoneLabel = new JLabel();
        phoneTypes = new JComboBox();
        phoneInput = new JTextField();
        phoneErrorMsg = new JLabel();
        findButton = new JButton();
        result = new JTextPane();
        scrollPane = new JScrollPane();
        mainPanel = new JPanel();

        setHomeButton();
        setBackButton();
        setTitle();
        setFirstNameLabel();
        setFirstNameInput();
        setFirstNameErrMsg();
        setSurnameLabel();
        setSurnameInput();
        setSurnameErrMsg();
        setPhoneLabel();
        setPhoneTypes();
        setPhoneInput();
        setPhoneErrMsg();
        setFindButton();
        setResultPane();
        setScrollPane();
        setMainPanel();
        setFrame();
    }

        //Set up the home button.
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
    
    // Action to perform when the home button is clicked
    private void homeButtonAction(ActionEvent evt) {
        if (bookingMenu.isDisplayable()) {
            bookingMenu.dispose();
        }

        homepage.setLocation(((homepage.screenWidth / 2) - (homepage.width / 2)), ((homepage.screenHeight / 2) - (homepage.height / 2)));
        homepage.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

        //Set up the back button.
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
    
    // Action to perform when the back button is clicked
    private void backButtonAction(ActionEvent evt) {
        bookingMenu.setLocation((homepage.screenWidth / 2) - (bookingMenu.width / 2), ((homepage.screenHeight / 2) - (bookingMenu.height / 2)));
        bookingMenu.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }
    
    // Set up the title label
    private void setTitle() {
        title.setFont(new Font("Segoe UI", 0, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Check Booking");
        title.setBounds(265, 40, 270, 50);
    }

        // Set up the first name label
    private void setFirstNameLabel() {
        firstNameLabel.setFont(new Font("Segoe UI", 0, 18));
        firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        firstNameLabel.setText("First Name:");
        firstNameLabel.setBounds(30, 140, 200, 30);
    }

        // Set up the first name input field
    private void setFirstNameInput() {
        firstNameInput.setFont(new Font("Segoe UI", 0, 17));
        firstNameInput.setBounds(240, 140, 290, 30);
    }

        // Set up the first name error message label
    private void setFirstNameErrMsg() {
        firstNameErrorMsg.setForeground(Color.red);
        firstNameErrorMsg.setBounds(540, 140, 250, 30);
    }

        // Set up the surname label
    private void setSurnameLabel() {
        surnameLabel.setFont(new Font("Segoe UI", 0, 18));
        surnameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        surnameLabel.setText("Surname:");
        surnameLabel.setBounds(30, 220, 200, 30);
    }

        // Set up the surname input field
    private void setSurnameInput() {
        surnameInput.setFont(new Font("Segoe UI", 0, 17));
        surnameInput.setBounds(240, 220, 290, 30);
    }

        // Set up the surname error message label
    private void setSurnameErrMsg() {
        surnameErrorMsg.setForeground(Color.red);
        surnameErrorMsg.setBounds(540, 220, 250, 30);
    }

        // Set up the phone label
    private void setPhoneLabel() {
        phoneLabel.setFont(new Font("Segoe UI", 0, 18));
        phoneLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        phoneLabel.setText("Phone:");
        phoneLabel.setBounds(30, 300, 200, 30);
    }

        // Set up the phone types combo box
    private void setPhoneTypes() {
        phoneTypes.setFont(new Font("Segoe UI", 0, 12));
        phoneTypes.setModel(new DefaultComboBoxModel<>(phTypes));
        phoneTypes.setBounds(240, 300, 90, 30);
    }

        // Set up the phone input field
    private void setPhoneInput() {
        phoneInput.setFont(new Font("Segoe UI", 0, 17));
        phoneInput.setBounds(330, 300, 200, 30);
    }

        // Set up the phone error message label
    private void setPhoneErrMsg() {
        phoneErrorMsg.setForeground(Color.red);
        phoneErrorMsg.setBounds(540, 300, 250, 30);
    }

        // Set up the find button
    private void setFindButton() {
        findButton.setFont(new Font("Segoe UI", 0, 18));
        findButton.setText("Find");
        findButton.setBounds(((width / 2) - (140 / 2)), 360, 140, 40);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findButtonAction(e);
            }
        });
    }
    
    // Action to perform when the find button is clicked
    private void findButtonAction(ActionEvent evt) {
        firstNameErrorMsg.setText("");
        surnameErrorMsg.setText("");
        phoneErrorMsg.setText("");
        if (!firstNameInput.getText().trim().isEmpty()) {
            boolean validFirstName = verifyFirstName();
            if (!validFirstName) {
                firstNameErrorMsg.setText("* Invalid input");
            }
        }
        if (!surnameInput.getText().trim().isEmpty()) {
            boolean validSurname = verifySurname();
            if (!validSurname) {
                surnameErrorMsg.setText("* Invalid input");
            }
        }
        if (!phoneInput.getText().trim().isEmpty()) {
            boolean validPhone = verifyPhone();
            if (!validPhone) {
                phoneErrorMsg.setText("* Invalid input");
            }
        }
        setResult();
    }
    
    //Verifies the first name input field. Return true if the first name is valid, false otherwise.
    private boolean verifyFirstName() {
        String trimInput = firstNameInput.getText().trim();
        firstNameInput.setText(trimInput);

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
    
    //Verifies the last name input field. Return true if the last name is valid, false otherwise.
    private boolean verifySurname() {
        String trimInput = surnameInput.getText().trim();
        surnameInput.setText(trimInput);

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
    
    //Verifies the phone input field based on the selected phone type. Return true if the phone number is valid, false otherwise.
    private boolean verifyPhone() {
        String trimInput = phoneInput.getText().trim();
        phoneInput.setText(trimInput);
        boolean valid = true;

        selectedPhoneType = (String) phoneTypes.getSelectedItem();
        if (selectedPhoneType.contains("Home")) {
            valid = homePhone();
        } else if (selectedPhoneType.contains("Mobile")) {
            valid = mobilePhone();
        }

        return valid;
    }
    
    //Verifies the home phone number input. Return true if the home phone number is valid, false otherwise.
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
                    phone = "09 " + phoneInput.getText();
                }
            } else {
                phone = "09 " + phoneInput.getText().substring(0, 3)
                        + " " + phoneInput.getText().substring(3);
            }
        } else {
            return false;
        }

        return true;
    }

    //Verifies the mobile phone number input. Return true if the mobile phone number is valid, false otherwise.
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
                        phone = "+64 " + phoneInput.getText();
                    }
                } else if (spaceCount == 1) {
                    if (check[0].length() != 2 || check[1].length() != 7) {
                        return false;
                    } else {
                        phone = "+64 " + temp.substring(0,2) + " " +
                                temp.substring(2,5) + " " +
                                temp.substring(5);
                    }
                }
            } else {
                phone = "+64 " + temp.substring(0,2) + " " +
                        temp.substring(2,5) + " " +
                        temp.substring(5);
            }
            phoneInput.setText(temp);
        } else {
            return false;
        }

        return true;
    }

    //Sets the result text based on the search query.
    private void setResult() {
        ArrayList<Booking> found = homepage.dbManager.checkForBooking(firstName, surname, phone);
        String foundBookings = "";
        if (!found.isEmpty()) {
            for (Booking token : found) {
                foundBookings += token.toString();
            }

            result.setText(foundBookings);
            firstName = "";
            surname = "";
            phone = "";
        } else {
            result.setText("No results found.");
        }

    }

     // Set up the result text pane
    private void setResultPane() {
        result.setFont(new Font("Segoe UI", 0, 17));
        result.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        result.setEditable(false);
    }

    // Set up the scroll pane for the result pane
    private void setScrollPane() {
        scrollPane.setBounds(150, 450, 500, 250);
        scrollPane.setViewportView(result);
    }

    //Sets the main panel properties.
    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setBackground(Color.decode("#fff3e9"));
        mainPanel.setLayout(null);

        mainPanel.add(homeButton);
        mainPanel.add(backButton);
        mainPanel.add(title);
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameInput);
        mainPanel.add(firstNameErrorMsg);
        mainPanel.add(surnameLabel);
        mainPanel.add(surnameInput);
        mainPanel.add(surnameErrorMsg);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneTypes);
        mainPanel.add(phoneInput);
        mainPanel.add(phoneErrorMsg);
        mainPanel.add(findButton);
        mainPanel.add(scrollPane);
    }
    
    //Sets the frame and properties.
    private void setFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
