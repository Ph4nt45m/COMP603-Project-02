/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author snipi
 */
public class DatePicker extends JFrame {

    JPanel mainPanel = new JPanel();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTable calendar = new JTable();
    JLabel monthLabel = new JLabel();
    JButton leftButton = new JButton();
    JButton rightButton = new JButton();
    JLabel yearLabel = new JLabel();

    final String[] months = {"January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"};
    int monthIndex;
    int currentMonthIndex;
    int yearIndex;
    int yearLimit;
    final String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    LocalDate date;
    DateTimeFormatter formatter;
    String currentDate;
    int day;
    int month;
    int year;
    String selectedDate;
    Integer selectedDay;
    Integer selectedMonth;
    Integer selectedYear;
    BookingDetails userDetails;
    ImageIcon left;
    ImageIcon right;

    public DatePicker(BookingDetails usersDetails) {
        this.date = LocalDate.now();
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.day = date.getDayOfMonth();
        this.month = date.getMonthValue();
        this.year = date.getYear();
        this.monthIndex = this.month - 1;
        this.currentMonthIndex = this.month - 1;
        this.yearIndex = this.year;
        this.yearLimit = this.year + 1;
        this.currentDate = date.format(formatter);
        this.selectedDay = this.day;
        this.selectedMonth = this.month;
        this.selectedYear = this.year;
        this.userDetails = usersDetails;
        this.left = new ImageIcon("./resources/Left.png");
        this.right = new ImageIcon("./resources/Right.png");
        setComponents();
        DefaultTableModel tableModel = (DefaultTableModel) calendar.getModel();
        tableModel.setColumnCount(7);
        tableModel.setRowCount(6);
        tableModel.setColumnIdentifiers(days);

        calendar.setCellSelectionEnabled(true);
        calendar.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTableHeader tableHeader = calendar.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        monthLabel.setText(months[monthIndex]);
        yearLabel.setText(this.yearIndex + "");

        leftButton.setIcon(left);
        leftButton.setEnabled(false);
        rightButton.setIcon(right);

        updateCalendar();

        calendar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getSelectedDate();
            }
        });
    }

    class CustomTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component cell = super.getTableCellRendererComponent(table, value,
                    false, false, row, column);

            cell.setBackground(table.getBackground());
            
            return cell;
        }
    }

    private void decrementMonth() {
        if (monthIndex > 0 || (monthIndex == 0 && yearIndex > year)) {
            if (monthIndex == 0 && yearIndex > year) {
                monthIndex = months.length - 1;
                yearIndex--;
                yearLabel.setText(yearIndex + "");
            } else {
                monthIndex--;
            }
            monthLabel.setText(months[monthIndex]);
            rightButton.setEnabled(true);
        }

        if (monthIndex == currentMonthIndex && yearIndex == year) {
            leftButton.setEnabled(false);
        } else {
            leftButton.setEnabled(true);
        }

        if (monthIndex == months.length - 1 && yearIndex == yearLimit) {
            rightButton.setEnabled(false);
        } else {
            rightButton.setEnabled(true);
        }

        updateCalendar();
    }

    private void incrementMonth() {
        if (monthIndex < months.length - 1 || (monthIndex == months.length - 1 && yearIndex < yearLimit)) {
            if (monthIndex == months.length - 1 && yearIndex < yearLimit) {
                monthIndex = 0;
                yearIndex++;
                yearLabel.setText(yearIndex + "");
            } else {
                monthIndex++;
            }
            monthLabel.setText(months[monthIndex]);
            leftButton.setEnabled(true);
        }

        if (monthIndex == currentMonthIndex && yearIndex == year) {
            leftButton.setEnabled(false);
        } else {
            leftButton.setEnabled(true);
        }

        if (monthIndex == months.length - 1 && yearIndex == yearLimit) {
            rightButton.setEnabled(false);
        } else {
            rightButton.setEnabled(true);
        }

        updateCalendar();
    }

    private void updateCalendar() {
        LocalDate firstDayOfMonth = LocalDate.of(yearIndex, monthIndex + 1, 1);
        DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();
        int startColumn = (dayOfWeek.getValue() + 6) % 7; // Convert the enum index to 0-based

        DefaultTableModel tableModel = (DefaultTableModel) calendar.getModel();
        tableModel.setRowCount(6); // Reset the table rows

        int daysInMonth = YearMonth.of(yearIndex, monthIndex + 1).lengthOfMonth();
        int dayOfMonth = 1;
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 0 && col < startColumn) {
                    // Fills the leading empty slots
                    tableModel.setValueAt("", row, col);
                } else if (dayOfMonth > daysInMonth) {
                    // Fills the trailing empty slots
                    tableModel.setValueAt("", row, col);
                } else {
                    // Fills the slots with date numbers
                    tableModel.setValueAt(dayOfMonth, row, col);
                    dayOfMonth++;
                }
            }
        }
    }

    private void getSelectedDate() {
        int selectedRow = calendar.getSelectedRow();
        int selectedColumn = calendar.getSelectedColumn();

        if (selectedRow != -1 && selectedColumn != -1) {
            Object selectedValue = calendar.getValueAt(selectedRow, selectedColumn);
            if (selectedValue != null) {
                selectedDay = Integer.valueOf(selectedValue.toString());
            }
        }

        if (selectedDay != null) {
            selectedMonth = monthIndex + 1;
            selectedYear = yearIndex;
            if (selectedDay < 10) {
                selectedDate = "0" + selectedDay + "/";
            } else {
                selectedDate = selectedDay + "/";
            }

            if ((selectedMonth) < 10) {
                selectedDate += "0" + selectedMonth + "/" + selectedYear;
            } else {
                selectedDate += selectedMonth + "/" + selectedYear;
            }

            userDetails.bDateInput.setText("");
            userDetails.bDateInput.setText(selectedDate);
        }
    }

    private void setComponents() {

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setUndecorated(true);

        mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        calendar.setRowHeight(30);
        calendar.setShowHorizontalLines(true);
        calendar.setShowVerticalLines(true);
        jScrollPane2.setViewportView(calendar);

        monthLabel.setFont(new Font("Segoe UI", 0, 18));
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftButtonActionPerformed(e);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightButtonActionPerformed(e);
            }
        });

        yearLabel.setFont(new Font("Segoe UI", 0, 18));
        yearLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.setLayout(null);

        yearLabel.setBounds(116, 10, 80, 30);

        leftButton.setBounds(30, 50, 31, 37);
        monthLabel.setBounds(70, 45, 160, 40);
        rightButton.setBounds(245, 50, 31, 37);

        jScrollPane2.setBounds(5, 100, 300, 208);

        mainPanel.add(yearLabel);
        mainPanel.add(leftButton);
        mainPanel.add(monthLabel);
        mainPanel.add(rightButton);
        mainPanel.add(jScrollPane2);

        mainPanel.setPreferredSize(new Dimension(310, 315));
        getContentPane().add(mainPanel);

        pack();
    }

    private void leftButtonActionPerformed(ActionEvent evt) {
        decrementMonth();
    }

    private void rightButtonActionPerformed(ActionEvent evt) {
        incrementMonth();
    }
}
