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

/**
 *
 * @author snipi
 */
public class BookingDetails extends JFrame {

    private JButton homeButton;
    private JButton backButton;
    private JLabel title;
    private JLabel bDateLabel;
    protected JTextField bDateInput;
    private JLabel bDateErrorMsg;
    private JLabel bDateFormatLabel;
    private JLabel durationLabel;
    protected JTextField durationInput;
    private JLabel lDateErrorMsg;
    private JLabel durationFormatLabel;
    private JButton bookButton;
    private JPanel mainPanel;

    protected final int width = 800;
    protected final int height = 400;
    protected Homepage homepage;
    protected RoomTypes roomTypes;
    protected DatePicker datePicker;
    protected DiscountMenu discounts;
    protected LocalDateTime currentTime;
    private final int[] months30 = {4, 6, 9, 11};
    protected boolean validBDate;
    protected boolean validLDate;
    protected Date dateBooked;
    protected Date dateLeave;

    public BookingDetails(Homepage home, RoomTypes rmTypes) {
        this.homepage = home;
        this.roomTypes = rmTypes;
        this.datePicker = new DatePicker(this);
        this.validBDate = false;
        this.validLDate = false;
        setComponents();
    }

    private void setComponents() {
        homeButton = new JButton();
        backButton = new JButton();
        title = new JLabel();
        bDateLabel = new JLabel();
        bDateInput = new JTextField();
        bDateErrorMsg = new JLabel();
        bDateFormatLabel = new JLabel();
        durationLabel = new JLabel();
        durationInput = new JTextField();
        lDateErrorMsg = new JLabel();
        durationFormatLabel = new JLabel();
        bookButton = new JButton();
        mainPanel = new JPanel();

        setHomeButton();
        setBackButton();
        setTitle();
        setBDateLabel();
        setBDateInput();
        setBDateErrorMsg();
        setBDateFormatLabel();
        setDurationLabel();
        setDurationInput();
        setDurationErrorMsg();
        setDurationFormatLabel();
        setBookButton();
        setMainPanel();
        setFrame();
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
        if (!roomTypes.booking.isDisplayable()) {
            roomTypes.booking.dispose();
        }
        if (!roomTypes.isDisplayable()) {
            roomTypes.dispose();
        }
        if (roomTypes.roomDetails.isDisplayable()) {
            roomTypes.roomDetails.dispose();
        }
        if (datePicker.isDisplayable()) {
            datePicker.dispose();
        }
        if (dateBooked != null) {
            dateBooked = null;
            validBDate = false;
        }
        if (dateLeave != null) {
            dateLeave = null;
            validLDate = false;
        }

        homepage.setLocation(((homepage.screenWidth / 2) - (homepage.width / 2)), ((homepage.screenHeight / 2) - (homepage.height / 2)));
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
        if (datePicker.isDisplayable()) {
            datePicker.dispose();
        }

        roomTypes.setLocation((homepage.screenWidth / 2) - (roomTypes.width / 2), ((homepage.screenHeight / 2) - (roomTypes.height / 2)));
        roomTypes.roomDetails.setLocation(roomTypes.getX() + 8, (roomTypes.getY() + roomTypes.getHeight() - 2));
        roomTypes.setVisible(true);
        roomTypes.roomDetails.setVisible(true);
        if (isDisplayable()) {
            dispose();
        }
    }

    private void setTitle() {
        title.setFont(new Font("Segoe UI", 0, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Booking Details");
        title.setBounds(265, 40, 270, 50);
    }

    private void setBDateLabel() {
        bDateLabel.setFont(new Font("Segoe UI", 0, 18));
        bDateLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        bDateLabel.setText("Booking Date:");
        bDateLabel.setBounds(30, 140, 200, 30);
    }

    private void setBDateInput() {
        bDateInput.setFont(new Font("Segoe UI", 0, 17));
        bDateInput.setBounds(240, 140, 290, 30);
        bDateInput.setText(datePicker.currentDate);

        bDateInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                int x = bDateInput.getLocationOnScreen().x + bDateInput.getWidth();
                int y = bDateInput.getLocationOnScreen().y;
                datePicker.setLocation(x, y);
                datePicker.setVisible(true);
            }
        });
    }

    private void setBDateErrorMsg() {
        bDateErrorMsg.setForeground(Color.red);
        bDateErrorMsg.setBounds(540, 140, 250, 30);
    }

    private void setBDateFormatLabel() {
        bDateFormatLabel.setFont(new Font("Segoe UI", 2, 15));
        bDateFormatLabel.setText("DD/MM/YYYY");
        bDateFormatLabel.setBounds(245, 170, 120, 20);
    }

    private void setDurationLabel() {
        durationLabel.setFont(new Font("Segoe UI", 0, 18));
        durationLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        durationLabel.setText("Duration of stay:");
        durationLabel.setBounds(30, 230, 200, 30);
    }

    private void setDurationInput() {
        durationInput.setFont(new Font("Segoe UI", 0, 17));
        durationInput.setBounds(240, 228, 290, 30);

        durationInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (datePicker.isVisible()) {
                    datePicker.setVisible(false);
                }
            }
        });
    }

    private void setDurationErrorMsg() {
        lDateErrorMsg.setForeground(Color.red);
        lDateErrorMsg.setBounds(540, 228, 250, 30);
    }

    private void setDurationFormatLabel() {
        durationFormatLabel.setFont(new Font("Segoe UI", 2, 15));
        durationFormatLabel.setText("Number of days (Max: 100)");
        durationFormatLabel.setBounds(245, 260, 200, 30);
    }

    private void setBookButton() {
        bookButton.setFont(new Font("Segoe UI", 0, 18));
        bookButton.setText("Book Room");
        bookButton.setBounds(335, 320, 140, 40);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookButtonAction(e);
            }
        });
    }

    private void bookButtonAction(ActionEvent evt) {
        if (!bDateErrorMsg.getText().isEmpty()) {
            bDateErrorMsg.setText("");
        }
        if (!lDateErrorMsg.getText().isEmpty()) {
            lDateErrorMsg.setText("");
        }

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

            discounts = new DiscountMenu(this.homepage, this);
            if (datePicker.isVisible()) {
                datePicker.setVisible(false);
            }
            if (isVisible()) {
                setVisible(false);
            }
        }
    }

    private void verifyBookDate() {
        String holder = bDateInput.getText();
        boolean validChars = true;
        validChars = verifyCharacters(holder);

        if (validChars) {
            String[] check = holder.split("/");
            int day = Integer.parseInt(check[0]);
            int month = Integer.parseInt(check[1]);
            int year = Integer.parseInt(check[2]);
            boolean valid = true;

            if (year < datePicker.year) {
                valid = false;
                bDateErrorMsg.setText("* Date already past");
            }
            if (year > datePicker.year + 2) {
                valid = false;
                bDateErrorMsg.setText("* Out of bounds");
            }
            if (!(month > 0 && month <= 12)) {
                valid = false;
                bDateErrorMsg.setText("* Invalid input");
            }
            if (year == datePicker.year && month < datePicker.month) {
                valid = false;
                bDateErrorMsg.setText("* Date already past");
            }

            if (valid) {
                int dayMaxLimit = setDayLimit(month, year);
                if (!(day > 0 && day <= dayMaxLimit)) {
                    bDateErrorMsg.setText("* Invalid input");
                } else if (year == datePicker.year && month == datePicker.month && day < datePicker.day) {
                    bDateErrorMsg.setText("* Date already past");
                } else if (year == datePicker.year && month == datePicker.month && day == datePicker.day) {
                    currentTime = LocalDateTime.now();
                    int currentHour = currentTime.getHour();
                    if (currentHour >= 23) {
                        bDateErrorMsg.setText("* Too late to book today");
                    } else {
                        validBDate = true;
                        setDateBooked(day, month, year);
                    }
                } else {
                    validBDate = true;
                    setDateBooked(day, month, year);
                }
            }
        }

        if (!validBDate && bDateErrorMsg.getText().isEmpty()) {
            bDateErrorMsg.setText("* Invalid input");
            setBDateErrMsg();
        } else if (!validBDate && !bDateErrorMsg.getText().isEmpty()) {
            setBDateErrMsg();
        }
    }

    private void setDateBooked(int day, int month, int year) {
        dateBooked = new Date(day, month, year);
    }

    private void setBDateErrMsg() {
        if (bDateInput.getText().isEmpty()) {
            bDateErrorMsg.setText("* Text field required");
        }

        bDateInput.setText(datePicker.currentDate);
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

        int duration = 0;
        if (valid) {
            duration = Integer.parseInt(holder);
            if (duration <= 0) {
                lDateErrorMsg.setText("* Invalid duration");
            } else if (duration > 100) {
                lDateErrorMsg.setText("* Beyond available duration");
            } else {
                validLDate = true;
            }
        }

        if (validLDate) {
            int day = dateBooked.getDay();
            int month = dateBooked.getMonth();
            int year = dateBooked.getYear();
            setDateLeave(duration, day, month, year);
        }

        if (!validLDate && lDateErrorMsg.getText().isEmpty()) {
            lDateErrorMsg.setText("* Invalid input");
            setLDateErrMsg();
        } else if (!validLDate && !lDateErrorMsg.getText().isEmpty()) {
            setLDateErrMsg();
        }
    }

    private void setDateLeave(int duration, int currentDay, int currentMonth, int currentYear) {
        int day = currentDay;
        int month = currentMonth;
        int year = currentYear;
        int dayLimit = setDayLimit(month, year);
        if ((day + duration) > dayLimit) {
            duration -= ((dayLimit - day) + 1);
            day = 1;
            if (month + 1 > 12) {
                month = 1;
                year++;
            } else {
                month++;
            }

            setDateLeave(duration, day, month, year);
        } else {
            day += duration;
            dateLeave = new Date(day, month, year);
        }
    }

    private void setLDateErrMsg() {
        if (durationInput.getText().isEmpty()) {
            lDateErrorMsg.setText("* Text field required");
        }

        durationInput.setText("");
    }

    protected int setDayLimit(int month, int year) {
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

    protected boolean verifyCharacters(String date) {
        boolean valid = true;
        if (!(date.length() > 7 && date.length() <= 10)) {
            valid = false;
        }

        if (valid) {
            int slashCount = 0;
            for (int i = 0; i < date.length(); i++) {
                char temp = date.charAt(i);
                if (!Character.isDigit(temp) && temp != '/') {
                    valid = false;
                    break;
                } else if (temp == '/') {
                    slashCount++;
                }

                if (slashCount > 2) {
                    valid = false;
                    break;
                }
            }

            if (valid && slashCount != 2) {
                valid = false;
            } else if (valid && slashCount == 2) {
                String[] holder = date.split("/");
                if (holder.length != 3) {
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
        }

        return valid;
    }

    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.setLayout(null);

        mainPanel.add(homeButton);
        mainPanel.add(backButton);
        mainPanel.add(title);
        mainPanel.add(durationLabel);
        mainPanel.add(durationInput);
        mainPanel.add(bDateLabel);
        mainPanel.add(bDateInput);
        mainPanel.add(bDateFormatLabel);
        mainPanel.add(durationFormatLabel);
        mainPanel.add(bookButton);
        mainPanel.add(bDateErrorMsg);
        mainPanel.add(lDateErrorMsg);
    }

    private void setFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBackground(Color.WHITE);
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
