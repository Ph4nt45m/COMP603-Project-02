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

    protected JRadioButton momentaryRadioButton;
    protected ButtonGroup voucherOptionsGroup;
    public String selectedVoucher;
    private final JPanel mainPanel;
    private JButton returnButton;
    public JRadioButton packageRadioButton;
    private JButton continueButton;
    private JTextArea momentaryInfoArea;
    private JTextArea packageInfoArea;
    private JLabel vouchersLabel;
    private JLabel titleLabel;

    /*Sets up the Vouchers class, initializes the main panel, sets the 
    *preferred size of the panel. Sets the frame to be not resizable, calls the 
    *menu method to set up the UI elements, and makes the frame visible. Adds an 
    *action listener to the return button which calls the homepageButton method 
    *when clicked.
     */
    public Vouchers(Homepage home) {
        this.homepage = home;
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#fff3e9"));
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

    //Sets up the menu of the JFrame by calling various helper methods.
    private void menu() {
        setTitle("Vouchers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title();
        returnToHomepage();
        labels();
        addRadioButtons();
        packageVoucherInfo();
        momentaryVoucherInfo();
        continueButton();

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
    }

    //Sets up the title label of the JFrame.
    private void title() {

        titleLabel = new JLabel("Marl Avenue Hotel");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setBounds(20, 10, 200, 30);

        mainPanel.add(titleLabel);
    }

    /*Adds a return button to the main panel with the text "Return to Homepage" 
    *and sets its position.
     */
    private void returnToHomepage() {

        returnButton = new JButton("Return to Homepage");
        returnButton.setBounds(20, 40, 150, 20);

        mainPanel.add(returnButton);
    }

    /*Adds labels to the main panel. Adds a large "Vouchers" label and a 
    *smaller "Voucher Options" subtitle.
     */
    private void labels() {

        vouchersLabel = new JLabel("Vouchers");
        vouchersLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
        vouchersLabel.setBounds(330, 40, 400, 50);

        JLabel vouchersSubtitle = new JLabel("Voucher Options:");
        vouchersSubtitle.setFont(new Font("Segoe UI", 0, 18));
        vouchersSubtitle.setBounds(350, 100, 250, 30);

        mainPanel.add(vouchersLabel);
        mainPanel.add(vouchersSubtitle);
    }

    /*Adds radio buttons to the main panel. Creates a ButtonGroup for the radio 
    *buttons, adds two radio buttons ("$200 Gift Voucher" and "Momentary Gift 
    *Voucher") to the group, and sets their positions.
     */
    private void addRadioButtons() {
        voucherOptionsGroup = new ButtonGroup();

        packageRadioButton = new JRadioButton("$200 Gift Voucher");
        packageRadioButton.setActionCommand("$200 Gift Voucher");
        packageRadioButton.setBounds(30, 230, 150, 30);
        packageRadioButton.setBackground(Color.decode("#fff3e9"));

        momentaryRadioButton = new JRadioButton("Momentary Gift Voucher");
        momentaryRadioButton.setActionCommand("Momentary Gift Voucher");
        momentaryRadioButton.setBounds(30, 430, 190, 30);
        momentaryRadioButton.setBackground(Color.decode("#fff3e9"));

        voucherOptionsGroup.add(packageRadioButton);
        voucherOptionsGroup.add(momentaryRadioButton);

        mainPanel.add(packageRadioButton);
        mainPanel.add(momentaryRadioButton);
    }

    /*Adds a text area to the main panel with the information about the $200 
    *gift voucher. Sets the description text and the bounds of the text area.
     */
    private void packageVoucherInfo() {

        packageInfoArea = new JTextArea();
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
        packageInfoArea.setFont(new Font("Segoe UI", 0, 12));
        packageInfoArea.setEditable(false);
        packageInfoArea.setText(description);
        packageInfoArea.setBounds(220, 140, 450, 170);

        mainPanel.add(packageInfoArea);
    }

    /*Adds a text area to the main panel with the information about the 
    *momentary gift voucher. Sets the description text and the bounds of the 
    *text area.
     */
    private void momentaryVoucherInfo() {

        momentaryInfoArea = new JTextArea();
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
        momentaryInfoArea.setFont(new Font("Segoe UI", 0, 12));
        momentaryInfoArea.setEditable(false);
        momentaryInfoArea.setText(description);
        momentaryInfoArea.setBounds(220, 360, 450, 200);

        mainPanel.add(momentaryInfoArea);
    }

    /*Adds a continue button to the main panel with the text "Continue". Sets 
    *the position of the button and adds an action listener that calls the 
    *continueButtonClicked method when clicked.
     */
    private void continueButton() {
        continueButton = new JButton("Continue");
        continueButton.setBounds(680, 570, 100, 20);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                continueButtonClicked();
            }
        });

        mainPanel.add(continueButton);
    }

    /*Called when the continue button is clicked. Checks if a voucher option is 
    *selected, displays an error message if not, and retrieves the selected 
    *voucher option and initializes the voucher details.
     */
    public void continueButtonClicked() {
        if (voucherOptionsGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select a voucher option.");
            return;
        }

        if(voucherOptionsGroup.getSelection() != null) {
            if(voucherOptionsGroup.getSelection() == packageRadioButton.getModel()) {
                selectedVoucher = "package";
            } if(voucherOptionsGroup.getSelection() == momentaryRadioButton.getModel()){
                selectedVoucher = "momentary";
            }
        }
        
        voucherDetails = new VoucherDetails(this, homepage);
        setVisible(false);
    }

    /*Called when the return button is clicked. It disposes of the current 
    *frame and makes the homepage frame visible.
     */
    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }

}
