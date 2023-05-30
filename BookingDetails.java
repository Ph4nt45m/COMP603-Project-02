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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author snipi
 */
public class BookingDetails extends JFrame {

    protected JLabel bDateErrorMsg;
    protected JLabel bDateFormatLabel;
    protected JTextField bDateInput;
    protected JLabel bDateLabel;
    protected JButton back;
    protected JButton book;
    protected JLabel durationFormatLabel;
    protected JTextField durationInput;
    protected JLabel durationLabel;
    protected JButton homeButton;
    protected JLabel lDateErrorMsg;
    protected JPanel mainPanel;
    protected JLabel title;

    protected Homepage homepage;
    protected RoomTypes roomTypes;
    protected DatePicker datePicker;
    protected DiscountMenu discounts;
    protected LocalDateTime currentTime;
    protected final int[] months30 = {4, 6, 9, 11};
    protected boolean validBDate;
    protected boolean validLDate;
    protected boolean bookToday;
    protected boolean longStay;
    protected Date dateBooked;
    protected Date dateLeave;

    public BookingDetails(Homepage home, RoomTypes rmTypes) {
        this.homepage = home;
        this.roomTypes = rmTypes;
        this.datePicker = new DatePicker(this);
        this.validBDate = false;
        this.validLDate = false;
        this.bookToday = true;
        this.longStay = false;
        setComponents();
        bDateInput.setText(datePicker.currentDate);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                homepage.dbManager.closeConnections();

                dispose();
                System.exit(0);
            }
        });

        setLocation((homepage.width / 2) - (this.getWidth() / 2), 200);
        setVisible(true);
    }

    private void verifyBookDate() {
        String holder = bDateInput.getText();
        boolean validLength = true;
        if (holder.length() >= 8 && holder.length() <= 10) {
            if (!holder.contains("/")) {
                validLength = false;
            }
        } else {
            validLength = false;
        }

        boolean validChars = false;
        if (validLength) {
            validChars = verifyBCharacters(holder);
        }

        if (validChars) {
            String[] check = holder.split("/");
            int day = Integer.parseInt(check[0]);
            int month = Integer.parseInt(check[1]);
            int year = Integer.parseInt(check[2]);
            boolean valid = true;

            if (!(year >= datePicker.year) || (year >= datePicker.year + 2)) {
                valid = false;
            }
            if (!(month > 0 && month <= 12) || (year == datePicker.year && month < datePicker.month)) {
                valid = false;
            }

            int dayMaxLimit = setDayLimit(month, year);
            if (!(day > 0 && day <= dayMaxLimit)) {
                // Don't do anything, day is not valid
            } else if (year == datePicker.year && month == datePicker.month && day < datePicker.day) {
                // Don't do anything, day is not valid
            } else if (year == datePicker.year && month == datePicker.month && day == datePicker.day) {
                currentTime = LocalDateTime.now();
                int currentHour = currentTime.getHour();
                if (currentHour >= 23) {
                    bookToday = false;
                } else {
                    validBDate = true;
                }
            } else {
                validBDate = true;
            }
        }

        if (!validBDate) {
            setBDateErrMsg();
        }
    }

    private void verifyLeaveDate() {
        String holder = durationInput.getText();
        boolean valid = true;
        for (int i = 0; i < holder.length(); i++) {
            if (!Character.isDigit(holder.charAt(i))) {
                valid = false;
                break;
            }
        }

        int days = 0;
        if (valid) {
            days = Integer.parseInt(holder);
            if (days > 0 && days <= 100) {
                validLDate = true;
            } else if (days > 100) {
                longStay = true;
            }
        }

        if (!validLDate) {
            setLDateErrMsg();
        }
    }

    private void setBDateErrMsg() {
        bDateInput.setText(datePicker.currentDate);

        if (bDateInput.getText().isEmpty()) {
            bDateErrorMsg.setText("* Text field required");
        } else if (!bookToday) {
            bDateErrorMsg.setText("* Too late to book today");
        } else {
            bDateErrorMsg.setText("* Invalid input");
        }

        bDateErrorMsg.setForeground(Color.red);
    }

    private void setLDateErrMsg() {
        durationInput.setText("");

        if (durationInput.getText().isEmpty()) {
            lDateErrorMsg.setText("* Textfield required");
        } else if (longStay) {
            lDateErrorMsg.setText("* Max duration of stay: 100 days");
        } else {
            lDateErrorMsg.setText("* Invalid input");
        }

        lDateErrorMsg.setForeground(Color.red);
    }

    private int setDayLimit(int month, int year) {
        int limit = 0;
        if (month == 2) {
            if (!((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))) {
                limit = 28;
            } else {
                limit = 29;
            }
        } else {
            for (int token : months30) {
                if (month == token) {
                    limit = 30;
                    break;
                }
            }
            if (limit != 30) {
                limit = 31;
            }
        }

        return limit;
    }

    private boolean verifyBCharacters(String date) {
        boolean valid = true;
        int slashCount = 0;
        for (int i = 0; i < date.length(); i++) {
            if (!Character.isDigit(date.charAt(i)) || !("/".equals(date.charAt(i)))) {
                valid = false;
                break;
            } else if ("/".equals(date.charAt(i))) {
                slashCount++;
            }

            if (slashCount > 2) {
                valid = false;
                break;
            }
        }

        if (slashCount != 2) {
            valid = false;
        } else {
            String[] holder = date.split("/");
            if (holder.length > 3) {
                valid = false;
            }
            if (!(holder[0].length() > 0 && holder[0].length() <= 2)) {
                valid = false;
            }
            if (!(holder[1].length() > 0 && holder[1].length() <= 2)) {
                valid = false;
            }
            if (holder[2].length() != 4) {
                valid = false;
            }
        }

        return valid;
    }

    private boolean verifyDCharacters(String duration) {
        boolean valid = true;

        return valid;
    }

    private void setComponents() {

        mainPanel = new JPanel();
        title = new JLabel();
        durationInput = new JTextField();
        durationLabel = new JLabel();
        bDateFormatLabel = new JLabel();
        durationFormatLabel = new JLabel();
        bDateInput = new JTextField();
        bDateLabel = new JLabel();
        book = new JButton();
        homeButton = new JButton();
        back = new JButton();
        bDateErrorMsg = new JLabel();
        lDateErrorMsg = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Make Booking Menu");
        setResizable(false);

        title.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Booking Details");

        durationInput.setFont(new Font("Segoe UI", 0, 17)); // NOI18N
        durationInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (datePicker.isVisible()) {
                    datePicker.setVisible(false);
                }
            }
        });

        durationLabel.setFont(new Font("Segoe UI", 0, 18));
        durationLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        durationLabel.setText("Duration of stay:");

        bDateFormatLabel.setFont(new Font("Segoe UI", 2, 15));
        bDateFormatLabel.setText("DD/MM/YYYY");
        bDateFormatLabel.setPreferredSize(new Dimension(90, 20));

        durationFormatLabel.setFont(new Font("Segoe UI", 2, 15));
        durationFormatLabel.setText("Number of days (Max: 100)");

        bDateInput.setFont(new Font("Segoe UI", 0, 17));
        bDateInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                int x = bDateInput.getLocationOnScreen().x + bDateInput.getWidth();
                int y = bDateInput.getLocationOnScreen().y;
                datePicker.setLocation(x, y);
                datePicker.setVisible(true);
            }
        });

        bDateLabel.setFont(new Font("Segoe UI", 0, 18));
        bDateLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        bDateLabel.setText("Booking Date:");

        book.setFont(new Font("Segoe UI", 0, 18));
        book.setText("Book Room");
        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookActionPerformed(e);
            }
        });

        homeButton.setText("Homepage");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeButtonActionPerformed(e);
            }
        });

        back.setText("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backActionPerformed(e);
            }
        });

        homeButton.setBounds(10, 10, 100, 30);
        back.setBounds(10, 50, 100, 30);
        title.setBounds(265, 40, 270, 50);
        bDateLabel.setBounds(30, 143, 200, 20);
        bDateInput.setBounds(240, 140, 290, 30);
        bDateFormatLabel.setBounds(245, 170, 120, 20);
        durationLabel.setBounds(30, 230, 200, 20);
        durationInput.setBounds(240, 228, 290, 30);
        durationFormatLabel.setBounds(245, 260, 200, 20);
        book.setBounds(335, 320, 140, 40);
        bDateErrorMsg.setBounds(540, 140, 250, 32);
        lDateErrorMsg.setBounds(540, 180, 250, 32);

        mainPanel.setLayout(null);
        mainPanel.add(homeButton);
        mainPanel.add(back);
        mainPanel.add(title);
        mainPanel.add(durationLabel);
        mainPanel.add(durationInput);
        mainPanel.add(bDateLabel);
        mainPanel.add(bDateInput);
        mainPanel.add(bDateFormatLabel);
        mainPanel.add(durationFormatLabel);
        mainPanel.add(book);
        mainPanel.add(bDateErrorMsg);
        mainPanel.add(lDateErrorMsg);

        mainPanel.setPreferredSize(new Dimension(800, 400));

        getContentPane().add(mainPanel);

        pack();
    }

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        roomTypes.booking.dispose();
        roomTypes.dispose();
        if (roomTypes.roomDetails.isVisible()) {
            roomTypes.roomDetails.dispose();
        }
        if (datePicker.isVisible()) {
            datePicker.dispose();
        }
        homepage.setLocation((homepage.width / 2) - (homepage.getWidth() / 2), 200);
        homepage.setVisible(true);
        dispose();
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        roomTypes.setLocation((homepage.width / 2) - (roomTypes.getWidth() / 2), 200);
        roomTypes.roomDetails.setLocation(roomTypes.getX() + 8, (roomTypes.getY() + roomTypes.getHeight() - 2));
        roomTypes.setVisible(true);
        roomTypes.roomDetails.setVisible(true);
        dispose();
    }

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {
        if (!bDateInput.getText().isEmpty()) {
            verifyBookDate();
        } else {
            setBDateErrMsg();
        }

        if (!durationInput.getText().isEmpty()) {
            verifyLeaveDate();
        } else {
            setLDateErrMsg();
        }

        if (validBDate && validLDate) {
            if (!bDateErrorMsg.getText().isEmpty()) {
                bDateErrorMsg.setText("");
            }
            if (!lDateErrorMsg.getText().isEmpty()) {
                lDateErrorMsg.setText("");
            }

//            discounts = new DiscountMenu(this.homepage);
//            discounts.setVisible(true);
//            datePicker.dispose();
//            dispose();
        }
    }
}
