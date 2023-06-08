/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author m4ria
 */
public class Vouchers extends JFrame {

    Homepage homepage;
    VoucherDetails voucherDetails;
    JPanel mainPanel;
    JButton returnButton;
    JRadioButton packageRadioButton;
    JRadioButton momentaryRadioButton;
    protected ButtonGroup voucherOptionsGroup;
    String selectedVoucher;

    public Vouchers(Homepage home) {
        this.homepage = home;
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(800, 600));

        setResizable(false);

        menu();
        pack();

        setVisible(true);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });
    }

    private void menu() {
        setTitle("Vouchers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title();
        returnToHomepage();
        labels();
        //        packageVoucherButton();
        //        momentaryVoucherButton();
        addRadioButtons();
        packageVoucherInfo();
        momentaryVoucherInfo();
//        purchaseButton();
        continueButton();

        getContentPane().add(mainPanel);
        pack();
    }

    private void title() {

        JLabel titleLabel = new JLabel("Marl Avenue Hotel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(20, 10, 200, 30);

        mainPanel.add(titleLabel);
    }

    private void returnToHomepage() {

        returnButton = new JButton("Return to Homepage");
        returnButton.setBounds(20, 40, 150, 20);

        mainPanel.add(returnButton);
    }

    private void labels() {

        JLabel vouchersLabel = new JLabel("Vouchers");
        vouchersLabel.setFont(new Font("Arial", Font.BOLD, 38));
        vouchersLabel.setBounds(330, 40, 400, 50);

        JLabel vouchersSubtitle = new JLabel("Voucher Options:");
        vouchersSubtitle.setFont(new Font("Arial", 0, 18));
        vouchersSubtitle.setBounds(350, 100, 250, 30);

        mainPanel.add(vouchersLabel);
        mainPanel.add(vouchersSubtitle);
    }

    private void addRadioButtons() {
        voucherOptionsGroup = new ButtonGroup();

        packageRadioButton = new JRadioButton("$200 Gift Voucher");
        packageRadioButton.setActionCommand("$200 Gift Voucher");
        packageRadioButton.setBounds(30, 230, 150, 30);

        momentaryRadioButton = new JRadioButton("Momentary Gift Voucher");
        momentaryRadioButton.setActionCommand("Momentary Gift Voucher");
        momentaryRadioButton.setBounds(30, 430, 190, 30);

        voucherOptionsGroup.add(packageRadioButton);
        voucherOptionsGroup.add(momentaryRadioButton);

        mainPanel.add(packageRadioButton);
        mainPanel.add(momentaryRadioButton);
    }

    private void packageVoucherInfo() {

        JTextArea infoArea = new JTextArea();
        String description = "Indulge in the epitome of luxury with our $200 "
                + "gift voucher, redeemable at our \nprestigious and opulent "
                + "hotel. Treat yourself or a loved one to an unforgettable\n"
                + "experience filled with elegance and sophistication. Immerse "
                + "yourself in lavish\naccommodations, impeccable service, and"
                + "world-class amenities. Whether it's a\nserene spa retreat, a "
                + "sumptuous fine dining experience, or a rejuvenating\nweekend "
                + "getaway, this gift voucher grants you access to a world of "
                + "refined luxury.\nEscape the ordinary and bask in the "
                + "extraordinary as you embark on a remarkable\njourney of "
                + "relaxation and indulgence. Create timeless memories and "
                + "elevate your\nstay to new heights with this $200 gift voucher "
                + "at our distinguished and\nenchanting hotel.";
        infoArea.setEditable(false);
        infoArea.setText(description);
        infoArea.setBounds(220, 140, 450, 170);

        mainPanel.add(infoArea);
    }

    private void momentaryVoucherInfo() {

        JTextArea infoArea = new JTextArea();
        String description = "Experience a taste of luxury with our exclusive "
                + "momentary gift voucher. With a\nminimum purchase of $50, this "
                + "voucher allows you to unlock a world of\nindulgence at our "
                + "prestigious and opulent hotel. Treat yourself or a loved one "
                + "to a\nfleeting escape filled with elegance and sophistication. "
                + "Immerse yourself in the\nfinest accommodations, impeccable "
                + "service, and world-class amenities. Whether\nit's enjoying a "
                + "relaxing spa treatment, savoring delectable culinary "
                + "delights at our\naward-winning restaurant, or unwinding in "
                + "the tranquil oasis of our luxurious pool,\nthis momentary "
                + "gift voucher grants you the opportunity to enhance your "
                + "stay with a\ntouch of opulence. From the moment you step "
                + "foot in our captivating surroundings,\nyou'll be enveloped "
                + "in an ambiance of refined luxury. Our dedicated staff is\n"
                + "committed to ensuring your every desire is fulfilled, as "
                + "we strive to provide an\nunforgettable experience tailored to "
                + "your preferences.";
        infoArea.setEditable(false);
        infoArea.setText(description);
        infoArea.setBounds(220, 360, 450, 200);

        mainPanel.add(infoArea);
    }

    private void continueButton() {
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(680, 570, 100, 20);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                continueButtonClicked();
            }
        });

        mainPanel.add(continueButton);
    }

    private void continueButtonClicked() {
        if (voucherOptionsGroup.getSelection() == null) {
            // No voucher option selected
            JOptionPane.showMessageDialog(this, "Please select a voucher option.");
            return;
        }

        selectedVoucher = voucherOptionsGroup.getSelection().getActionCommand();

        // Open VoucherDetails frame with the selected voucher option
        voucherDetails = new VoucherDetails(this, homepage);
    }

    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }

}
