/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author m4ria
 */
public class Vouchers extends JFrame {

    Homepage homepage;

    JButton giftVoucherButton;
    JButton momentaryVoucherButton;
    JButton returnButton;
    JTextPane textPane;

    public Vouchers(Homepage home) {
        this.homepage = home;
        setSize(800, 600);
        createGUI();
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vouchers");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Vouchers");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitleLabel = new JLabel("Voucher Options:");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel labelsPanel = new JPanel(new BorderLayout());
        labelsPanel.add(titleLabel, BorderLayout.NORTH);
        labelsPanel.add(subtitleLabel, BorderLayout.CENTER);

        mainPanel.add(labelsPanel, BorderLayout.NORTH);

        String giftVoucherInfo = "testing testing";

        textPane = new JTextPane();
        textPane.setText(giftVoucherInfo);
        textPane.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 200));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Add scroll policy

        mainPanel.add(scrollPane, BorderLayout.CENTER); // Add textPane to mainPanel

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(150, 270));
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        giftVoucherButton = new JButton("$200 Gift Voucher");

        momentaryVoucherButton = new JButton("Momentary Gift Voucher");

        returnButton = new JButton("Return to Homepage");

        buttonPanel.add(giftVoucherButton);
        buttonPanel.add(momentaryVoucherButton);
        buttonPanel.add(returnButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER); // Add buttonPanel to mainPanel

        add(mainPanel);

        setVisible(true);
    }

    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }
}
