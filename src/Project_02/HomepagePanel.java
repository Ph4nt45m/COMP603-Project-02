/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author snipi
 */
public class HomepagePanel extends JPanel {

    private MainPanel mainPanel;

    public HomepagePanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel title = new JLabel("Marl Avenue Hotel");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.setPreferredSize(new Dimension(600, 200));
        title.setBounds(30, 0, 600, 200);
        
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.WHITE);
        buttons.setLayout(new GridLayout(5, 1, 0, 10));
        buttons.setPreferredSize(new Dimension(200, 290));
        buttons.setBounds(20, 220, 200, 290);

        JButton booking = new JButton("Booking");
        JButton facilities = new JButton("Facilities");
        JButton faqs = new JButton("FAQ");
        JButton vouchers = new JButton("Vouchers");
        JButton exit = new JButton("Exit");

        ButtonListener buttonListener = new ButtonListener();

        booking.addActionListener(buttonListener);
        facilities.addActionListener(buttonListener);
        faqs.addActionListener(buttonListener);
        vouchers.addActionListener(buttonListener);
        exit.addActionListener(buttonListener);

        Dimension buttonSize = new Dimension(200, 45);
        booking.setPreferredSize(buttonSize);
        facilities.setPreferredSize(buttonSize);
        faqs.setPreferredSize(buttonSize);
        vouchers.setPreferredSize(buttonSize);
        exit.setPreferredSize(buttonSize);

        buttons.add(booking);
        buttons.add(facilities);
        buttons.add(faqs);
        buttons.add(vouchers);
        buttons.add(exit);
        
        add(title);
        add(buttons);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Booking":
                    mainPanel.switchPanel(mainPanel.booking);
                    break;
                case "Facilities":
                    mainPanel.switchPanel(mainPanel.facilities);
                    break;
                case "FAQ":
                    mainPanel.switchPanel(mainPanel.faqs);
                    break;
                case "Vouchers":
                    mainPanel.switchPanel(mainPanel.vouchers);
                    break;
                default:
                    break;
            }
        }
    }
}
