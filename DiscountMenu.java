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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author m4ria
 */
public class DiscountMenu extends JFrame {

    private JLabel discountTitle;
    private JButton homeButton;
    private JButton backButton;
    private JLabel studentDOBLabel;
    private JRadioButton studentDiscount;
    private JTextField studentInput;
    private JLabel sDOBFormatLabel;
    private JLabel studentErrorMsg;
    private JLabel childDOBLabel;
    private JRadioButton childDiscount;
    private JTextField childInput;
    private JLabel cDOBFormatLabel;
    private JLabel childErrorMsg;
    private JButton applyButton;
    private JButton skipButton;
    private ButtonGroup selection;
    private JPanel mainPanel;

    protected final int width = 700;
    protected final int height = 460;
    protected Homepage homepage;
    protected BookingDetails bookDetails;
    protected PaymentMenu paymentDetails;
    protected LocalDate currentDate;
    protected boolean studentDisStatus;
    protected boolean childDisStatus;
    protected boolean validStudentInput;
    protected boolean validChildInput;

    //Constructor for Unit Testing - Booking
    public DiscountMenu() {
        this.homepage = new Homepage();
        this.bookDetails = new BookingDetails(this.homepage, new RoomTypes(this.homepage));
        setComponents();
    }
    
    /*Constructs a DiscountMenu object with the specified Homepage and BookingDetails objects.
     *Initializes various variables and sets up the UI components.
     */
    public DiscountMenu(Homepage home, BookingDetails bookingDetails) {
        this.homepage = home;
        this.bookDetails = bookingDetails;
        this.studentDisStatus = false;
        this.childDisStatus = false;
        this.validStudentInput = false;
        this.validChildInput = false;
        setComponents();
    }

    //Initializes and configures the UI components.
    private void setComponents() {
        discountTitle = new JLabel();
        homeButton = new JButton();
        backButton = new JButton();
        studentDOBLabel = new JLabel();
        studentDiscount = new JRadioButton();
        studentInput = new JTextField();
        sDOBFormatLabel = new JLabel();
        studentErrorMsg = new JLabel();
        childDOBLabel = new JLabel();
        childDiscount = new JRadioButton();
        childInput = new JTextField();
        cDOBFormatLabel = new JLabel();
        childErrorMsg = new JLabel();
        selection = new ButtonGroup();
        applyButton = new JButton();
        skipButton = new JButton();
        mainPanel = new JPanel();

        setTitle();
        setHomeButton();
        setBackButton();
        setStudentDOBLabel();
        setStudentDiscount();
        setStudentInput();
        setSDOBFormatLabel();
        setStudentErrMsg();
        setChildDOBLabel();
        setChildDiscount();
        setChildInput();
        setCDOBFormatLabel();
        setChildErrMsg();
        setApplyButton();
        setSkipButton();
        setMainPanel();
        setFrame();
    }

    //Sets the title label of the discount menu.
    private void setTitle() {
        discountTitle.setFont(new Font("Segoe UI", 0, 24));
        discountTitle.setHorizontalAlignment(SwingConstants.CENTER);
        discountTitle.setText("Discounts");
        discountTitle.setBounds(((width / 2) - (200 / 2)), 50, 200, 50);
    }

    //Sets the home button.
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

    //
    private void homeButtonAction(ActionEvent evt) {
        if (bookDetails.isDisplayable()) {
            bookDetails.dispose();
        }
        if (bookDetails.roomTypes.isDisplayable()) {
            bookDetails.roomTypes.dispose();
        }
        if (bookDetails.roomTypes.roomDetails.isDisplayable()) {
            bookDetails.roomTypes.roomDetails.dispose();
        }
        if (bookDetails.roomTypes.booking.isDisplayable()) {
            bookDetails.roomTypes.booking.dispose();
        }

        homepage.setLocation((homepage.screenWidth / 2) - (homepage.width / 2), ((homepage.screenHeight / 2) - (homepage.height / 2)));
        homepage.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    //Sets the backs button.
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

    /*Sets up the functionality for the back button. When the back button is
     * clicked, it navigates back to the previous screen.
     */
    private void backButtonAction(ActionEvent evt) {
        bookDetails.bDateInput.setText(bookDetails.datePicker.currentDate);
        bookDetails.durationInput.setText("");
        bookDetails.dateBooked = null;
        bookDetails.dateLeave = null;
        bookDetails.validBDate = false;
        bookDetails.validLDate = false;
        bookDetails.setLocation(((homepage.screenWidth / 2) - (bookDetails.width / 2)), ((homepage.screenHeight / 2) - (bookDetails.height / 2)));
        bookDetails.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    //Sets the child date of birth label.
    private void setStudentDOBLabel() {
        studentDOBLabel.setText("Date of birth:");
        studentDOBLabel.setBounds(230, 130, 90, 20);
    }

    //Sets the child discount radio button.
    private void setStudentDiscount() {
        studentDiscount.setFont(new Font("Segoe UI", 0, 16));
        studentDiscount.setText("Student Discount");
        studentDiscount.setBounds(80, 155, 150, 30);
        studentDiscount.setBackground(Color.decode("#fff3e9"));
    }

    //Sets the student input text field.
    private void setStudentInput() {
        studentInput.setFont(new Font("Segoe UI", 0, 17));
        studentInput.setBounds(230, 155, 200, 30);
    }

    //Sets the student date of birth format label.
    private void setSDOBFormatLabel() {
        sDOBFormatLabel.setFont(new Font("Segoe UI", 2, 16));
        sDOBFormatLabel.setText("DD/MM/YYYY");
        sDOBFormatLabel.setBounds(230, 190, 100, 25);
    }

    //Sets the student error message label.
    private void setStudentErrMsg() {
        studentErrorMsg.setForeground(Color.red);
        studentErrorMsg.setBounds(450, 155, 250, 30);
    }

    //Sets the child date of birth label.
    private void setChildDOBLabel() {
        childDOBLabel.setText("Date of birth:");
        childDOBLabel.setBounds(230, 265, 90, 20);
    }

    //Sets the child discount radio button.
    private void setChildDiscount() {
        childDiscount.setFont(new Font("Segoe UI", 0, 16));
        childDiscount.setText("Child Discount");
        childDiscount.setBounds(80, 290, 150, 30);
        childDiscount.setBackground(Color.decode("#fff3e9"));

    }

    //Sets the child input text field.
    private void setChildInput() {
        childInput.setFont(new Font("Segoe UI", 0, 17));
        childInput.setBounds(230, 290, 200, 30);
    }

    //Sets the child date of birth format label.
    private void setCDOBFormatLabel() {
        cDOBFormatLabel.setFont(new Font("Segoe UI", 2, 16));
        cDOBFormatLabel.setText("DD/MM/YYYY");
        cDOBFormatLabel.setBounds(230, 325, 100, 25);
    }

    //Sets the child error message label.
    private void setChildErrMsg() {
        childErrorMsg.setForeground(Color.red);
        childErrorMsg.setBounds(450, 290, 250, 30);
    }

    //Sets the apply button.
    private void setApplyButton() {
        applyButton.setText("Apply");
        applyButton.setBounds(((width / 2) - (90 + 20)), (height - (40 + 30)), 90, 40);

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyButtonAction(e);
            }
        });
    }

    /*Handles the action when the Apply button is clicked.
    *It performs the necessary validation and applies the selected discount.
     */
    private void applyButtonAction(ActionEvent evt) {
        applyDiscount();
        if (validStudentInput || validChildInput) {
            if (!studentErrorMsg.getText().isEmpty()) {
                studentErrorMsg.setText("");
            }
            if (!childErrorMsg.getText().isEmpty()) {
                childErrorMsg.setText("");
            }

            paymentDetails = new PaymentMenu(homepage, this);
            setVisible(false);
        } else {
            studentInput.setText("");
            childInput.setText("");
        }
    }

    /*Applies the selected discount based on the input validation results. If
     * the student or child input is valid and qualifies for the discount, it
     * applies the respective discount. If neither input is valid or qualifies
     * for the discount, it displays an error message.
     */
    private void applyDiscount() {
        if (selection.getSelection() != null) {
            if (selection.getSelection() == studentDiscount.getModel()) {
                if (!childErrorMsg.getText().isEmpty()) {
                    childErrorMsg.setText("");
                }
                if (studentInput.getText().isEmpty()) {
                    studentErrorMsg.setText("* Text field required");
                } else if (bookDetails.verifyCharacters(studentInput.getText())) {
                    if (checkStudent()) {
                        if (!studentErrorMsg.getText().isEmpty()) {
                            studentErrorMsg.setText("");
                        }
                    }
                } else {
                    setStudentErrorMsg("* Invalid input");
                }
            } else if (selection.getSelection() == childDiscount.getModel()) {
                if (!studentErrorMsg.getText().isEmpty()) {
                    studentErrorMsg.setText("");
                }
                if (childInput.getText().isEmpty()) {
                    childErrorMsg.setText("* Text field required");
                } else if (bookDetails.verifyCharacters(childInput.getText())) {
                    if (checkChild()) {
                        childDisStatus = true;
                        if (!childErrorMsg.getText().isEmpty()) {
                            childErrorMsg.setText("");
                        }
                    }
                } else {
                    setChildErrorMsg("* Invalid input");
                }
            }
        } else {
            setSelectionErrorMsg();
        }
    }

    /*Checks the validity of the student's date of birth input and determines
     * if it qualifies for the discount. Updates the student discount status and
     * sets the validity of the student input accordingly.
     * Return true if the student input is valid and qualifies for the
     * discount, false otherwise
     */
    private boolean checkStudent() {
        currentDate = LocalDate.now();
        String[] holder = studentInput.getText().split("/");
        int day = Integer.parseInt(holder[0]);
        int month = Integer.parseInt(holder[1]);
        int year = Integer.parseInt(holder[2]);
        if ((year >= currentDate.getYear()) || (year < currentDate.getYear() - 100)) {
            setStudentErrorMsg("* Invalid date");
            return validStudentInput;
        }
        if (currentDate.getYear() - year < 10) {
            validStudentInput = true;
        } else if (!(month > 0 && month <= 12)) {
            setStudentErrorMsg("* Invalid input");
            return validStudentInput;
        }
        if (!studentDisStatus && !validStudentInput) {
            int monthDayLimit = bookDetails.setDayLimit(month, year);
            if (!(day > 0 && day <= monthDayLimit)) {
                setStudentErrorMsg("* Invalid input");
                return validStudentInput;
            } else {
                studentDisStatus = true;
                validStudentInput = true;
            }
        }

        return validStudentInput;
    }

    /*Checks the validity of the child's date of birth input and determines if
     * it qualifies for the discount. Updates the child discount status and sets
     * the validity of the child input accordingly.
     * return true if the child input is valid and qualifies for the discount,
     * false otherwise
     */
    private boolean checkChild() {
        currentDate = LocalDate.now();
        String[] holder = childInput.getText().split("/");
        int day = Integer.parseInt(holder[0]);
        int month = Integer.parseInt(holder[1]);
        int year = Integer.parseInt(holder[2]);
        if (year > currentDate.getYear()) {
            setChildErrorMsg("* Invalid input");
            return validChildInput;
        }
        if (currentDate.getYear() - year > 10) {
            validChildInput = true;
        } else if (!(month > 0 && month <= 12)) {
            setChildErrorMsg("* Invalid input");
            return validChildInput;
        }
        if (!childDisStatus && !validChildInput) {
            if (day <= 0) {
                setChildErrorMsg("* Invalid input");
                return validChildInput;
            }
            if (year == currentDate.getYear() && month == currentDate.getMonthValue()) {
                if (day >= currentDate.getDayOfMonth()) {
                    setChildErrorMsg("* Invalid input");
                    return validChildInput;
                } else {
                    childDisStatus = true;
                    validChildInput = true;
                }
            } else {
                int monthDayLimit = bookDetails.setDayLimit(month, year);
                if (!(day > 0 && day <= monthDayLimit)) {
                    setChildErrorMsg("* Invalid input");
                    return validChildInput;
                } else {
                    childDisStatus = true;
                    validChildInput = true;
                }
            }
        }

        return validChildInput;
    }

    //Displays an error message indicating that a discount selection is required.
    private void setSelectionErrorMsg() {
        if (!studentErrorMsg.getText().isEmpty()) {
            studentErrorMsg.setText("");
        }
        if (!childErrorMsg.getText().isEmpty()) {
            childErrorMsg.setText("");
        }
        studentErrorMsg.setText("* Please select a discount");
        childErrorMsg.setText("*Please select a discount");
    }

    //Sets the error message for the student input.
    private void setStudentErrorMsg(String message) {
        if (!studentErrorMsg.getText().isEmpty()) {
            studentErrorMsg.setText("");
        }
        studentErrorMsg.setText(message);
    }

    //Sets the error message for the child input.
    private void setChildErrorMsg(String message) {
        if (!childErrorMsg.getText().isEmpty()) {
            childErrorMsg.setText("");
        }
        childErrorMsg.setText(message);
    }

    /* Sets up the skip button functionality. When the skip button is clicked,
     * it cancels the current order and prompts the user for confirmation. If
     * the user confirms, it resets the form and displays a success message. If
     * the user cancels, it does nothing.
     */
    private void setSkipButton() {
        skipButton.setText("Skip");
        skipButton.setBounds(((width / 2) + 20), (height - (40 + 30)), 90, 40);

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skipButtonAction(e);
            }
        });
    }

    /*Handles the action when the Skip button is clicked.
    * Clears the input fields and navigates to the payment details.
     */
    private void skipButtonAction(ActionEvent evt) {
        if (!studentInput.getText().isEmpty()) {
            studentInput.setText("");
        }
        if (!childInput.getText().isEmpty()) {
            studentInput.setText("");
        }
        if (!studentErrorMsg.getText().isEmpty()) {
            studentErrorMsg.setText("");
        }
        if (!childErrorMsg.getText().isEmpty()) {
            childErrorMsg.setText("");
        }

        paymentDetails = new PaymentMenu(homepage, this);
        setVisible(false);
    }

    /*Sets the main panel of the application. This method is responsible for
     * creating and configuring the main panel that holds the various components
     * and content of the application.
     */
    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setLayout(null);

        mainPanel.add(discountTitle);
        mainPanel.add(homeButton);
        mainPanel.add(backButton);
        mainPanel.add(studentDOBLabel);
        mainPanel.add(studentDiscount);
        mainPanel.add(studentInput);
        mainPanel.add(sDOBFormatLabel);
        mainPanel.add(studentErrorMsg);
        mainPanel.add(childDOBLabel);
        mainPanel.add(childDiscount);
        mainPanel.add(childInput);
        mainPanel.add(cDOBFormatLabel);
        mainPanel.add(childErrorMsg);

        selection.add(studentDiscount);
        selection.add(childDiscount);

        mainPanel.add(applyButton);
        mainPanel.add(skipButton);

        getContentPane().add(mainPanel);
        pack();
    }

    //Sets up the main frame of the application.
    private void setFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainPanel.setBackground(Color.decode("#fff3e9"));
        setLocation((homepage.screenWidth / 2) - (width / 2), ((homepage.screenHeight / 2) - (height / 2)));
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
}
