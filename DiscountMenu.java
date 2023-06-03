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
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
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
 * @author snipi
 */
public class DiscountMenu extends JFrame {

    JPanel mainPanel;
    JLabel discountTitle;
    JButton homeButton;
    JButton backButton;
    JLabel studentDOBLabel;
    JRadioButton studentDiscount;
    JTextField studentInput;
    JLabel sDOBFormatLabel;
    JLabel studentErrorMsg;
    JLabel childDOBLabel;
    JRadioButton childDiscount;
    JTextField childInput;
    JLabel cDOBFormatLabel;
    JLabel childErrorMsg;
    JButton applyButton;
    JButton skipButton;
    ButtonGroup selection;
    JRadioButton selectedDiscount;

    Homepage homepage;
    BookingDetails bookDetails;
    private boolean validInput;
    
    public DiscountMenu() {
        setComponents();
    }

    public DiscountMenu(Homepage home, BookingDetails bookingDetails) {
        this.homepage = home;
        this.bookDetails = bookingDetails;
        this.validInput = true;
        setComponents();
    }

    private void setComponents() {
        mainPanel = new JPanel();
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

    private void setFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(780, 460));
        setLocation((homepage.width / 2) - (this.getWidth() / 2), ((homepage.height / 2) - (this.getHeight() / 2)));
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                homepage.dbManager.closeConnections();

                dispose();
                System.exit(0);
            }
        });
    }

    private void setTitle() {
        discountTitle.setFont(new Font("Segoe UI", 0, 24));
        discountTitle.setHorizontalAlignment(SwingConstants.CENTER);
        discountTitle.setText("Discounts");
        discountTitle.setBounds(250, 50, 200, 50);
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

        homepage.setLocation((homepage.width / 2) - (homepage.getWidth() / 2), ((homepage.height / 2) - (homepage.getHeight())));
        homepage.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
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
        bookDetails.setLocation(((homepage.width / 2) - (bookDetails.getWidth() / 2)), ((homepage.height / 2) - (bookDetails.getHeight() / 2)));
        bookDetails.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    private void setStudentDOBLabel() {
        studentDOBLabel.setText("Date of birth:");
        studentDOBLabel.setBounds(230, 130, 90, 20);
    }

    private void setStudentDiscount() {
        studentDiscount.setFont(new Font("Segoe UI", 0, 16));
        studentDiscount.setText("Student Discount");
        studentDiscount.setBounds(80, 155, 150, 30);
    }

    private void setStudentInput() {
        studentInput.setFont(new Font("Segoe UI", 0, 17));
        studentInput.setBounds(230, 155, 200, 30);
    }

    private void setSDOBFormatLabel() {
        sDOBFormatLabel.setFont(new Font("Segoe UI", 2, 16));
        sDOBFormatLabel.setText("DD/MM/YYYY");
        sDOBFormatLabel.setBounds(230, 190, 100, 25);
    }

    private void setStudentErrMsg() {
        studentErrorMsg.setForeground(Color.red);
        studentErrorMsg.setBounds(450, 155, 250, 30);
    }

    private void setChildDOBLabel() {
        childDOBLabel.setText("Date of birth:");
        childDOBLabel.setBounds(230, 265, 90, 20);
    }

    private void setChildDiscount() {
        childDiscount.setFont(new Font("Segoe UI", 0, 16));
        childDiscount.setText("Child Discount");
        childDiscount.setBounds(80, 290, 150, 30);
    }

    private void setChildInput() {
        childInput.setFont(new Font("Segoe UI", 0, 17));
        childInput.setBounds(230, 290, 200, 30);
    }

    private void setCDOBFormatLabel() {
        cDOBFormatLabel.setFont(new Font("Segoe UI", 2, 16));
        cDOBFormatLabel.setText("DD/MM/YYYY");
        cDOBFormatLabel.setBounds(230, 325, 100, 25);
    }

    private void setChildErrMsg() {
        childErrorMsg.setForeground(Color.red);
        childErrorMsg.setBounds(450, 290, 100, 30);
    }

    private void setApplyButton() {
        applyButton.setText("Apply");
        applyButton.setBounds(240, 390, 90, 40);
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyButtonAction(e);
            }
        });
    }

    private void applyButtonAction(ActionEvent evt) {
        if (selection.getSelection() != null) {
            if (selection.getSelection() == studentDiscount.getModel()) {
                if (bookDetails.verifyCharacters(studentInput.getText().trim())) {
                    if (!checkStudent()) {
                        
                    } else {
                        
                    }
                } else {
                    validInput = false;
                    setStudentErrorMsg();
                }
            }

            if (selection.getSelection() == childDiscount.getModel()) {
                if (bookDetails.verifyCharacters(childInput.getText().trim())) {
                    if (!checkChild()) {
                        
                    } else {
                        
                    }
                } else {
                    validInput = false;
                    setChildErrorMsg();
                }
            }
        } else {
            setSelectionErrorMsg();
        }
    }

    private boolean checkStudent() {
        boolean valid = true;
        String[] holder = studentInput.getText().trim().split("/");

        return valid;
    }

    private boolean checkChild() {
        boolean valid = true;

        return valid;
    }

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

    private void setStudentErrorMsg() {
        if (!validInput) {
            studentErrorMsg.setText("* Invalid input");
        }
    }

    private void setChildErrorMsg() {
        
    }

    private void setSkipButton() {
        skipButton.setText("Skip");
        skipButton.setBounds(370, 390, 90, 40);
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skipButtonAction(e);
            }
        });
    }

    private void skipButtonAction(ActionEvent evt) {

    }

    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(700, 460));
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
}
