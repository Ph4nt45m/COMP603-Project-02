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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Contacts extends JFrame {

    Homepage homepage;

    private JButton returnButton;
    private final JPanel mainPanel;
    private final JScrollPane mainScrollPane;
    private JLabel titleLabel;
    private JLabel historyLabel;
    private JLabel aboutUsLabel;
    private JTextArea aboutUsDescription;
    private JTextArea historyDescription;
    private JScrollPane aboutUsScrollPane;
    private JScrollPane historyScrollPane;
    private JLabel contactLabel;
    private JTextArea infoText;
    private JLabel nameLabel;
    private JTextArea nameText;
    private JLabel phoneLabel;
    private JTextArea phoneText;
    private JLabel emailLabel;
    private JTextArea emailText;
    private JLabel additionalLabel;
    private JTextArea additionalText;
    private JScrollPane additionalPane;
    private JButton sendButton;

    /*Constructor for the Contacts class. Creates and configures the main 
     *panel, sets the preferred size of the frame, and initializes the homepage 
     *reference.Calls the aboutUs() method to populate the GUI components.
     *Adds an action listener to the return button.
     */
    public Contacts(Homepage home) {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#fff3e9"));

        mainScrollPane = new JScrollPane(mainPanel);

        setResizable(false);
        this.homepage = home;
        setPreferredSize(new Dimension(800, 600));

        aboutUs();
        getContentPane().add(mainScrollPane);
        mainPanel.add(mainScrollPane);
        pack();

        setVisible(true);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });

    }

    /*Sets up the GUI components for the contact information frame. Calls
     *methods to create and configure the title, return button, hotel info,
     *history, and contact sections. Adds the components to the main panel.
     */
    private void aboutUs() {
        setTitle("Hotel Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title();
        returnToHomepage();
        hotelInfo();
        history();
        contact();

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

    /*Creates and configures the hotel information section.
     *Adds a title label and a text area containing the description to the 
     *main panel.
     */
    private void hotelInfo() {

        aboutUsLabel = new JLabel("About Us:");
        aboutUsLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        aboutUsLabel.setBounds(350, 20, 300, 50);

        aboutUsDescription = new JTextArea("Welcome to the Marl Avenue Hotel, an epitome "
                + "of luxury and sophistication. Nestled in the heart of a vibrant city, our iconic "
                + "hotel stands \nas a testament to unparalleled grandeur and elegance. From the "
                + "moment you step into our opulent lobby, adorned with magnificent\nchandeliers "
                + "and exquisite artwork, you are transported into a world of refined indulgence. "
                + "Our meticulously designed rooms and suites\noffer a harmonious blend of timeless "
                + "aesthetics and modern comforts, providing an oasis of serenity for the discerning"
                + " traveler. Indulge\nyour senses with our world-class amenities, including a "
                + "rooftop infinity pool offering breathtaking city views, a rejuvenating spa \n"
                + "offering bespoke treatments, and a Michelin-starred restaurant serving "
                + "gastronomic delights. As a recipient of numerous prestigious\nawards, "
                + "the Marl Avenue Hotel sets the standard for excellence in hospitality. "
                + "Our dedicated staff is committed to delivering unparalleled\npersonalized "
                + "service, ensuring that every moment of your stay is nothing short of "
                + "extraordinary. Discover the pinnacle of luxury at the Marl\nAvenue Hotel, "
                + "where dreams are turned into unforgettable experiences.");
        aboutUsDescription.setEditable(false);
        aboutUsDescription.setFont(new Font("Segoe UI", 0, 12));

        aboutUsScrollPane = new JScrollPane(aboutUsDescription);
        aboutUsScrollPane.setBounds(20, 80, 760, 80);

        mainPanel.add(aboutUsLabel);
        mainPanel.add(aboutUsScrollPane);

    }

    /*Creates and configures the history section. Adds a title label and a text 
    *area containing the history description to the main panel.
     */
    private void history() {

        historyLabel = new JLabel("History:");
        historyLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        historyLabel.setBounds(350, 170, 280, 50);

        historyDescription = new JTextArea("The Marl Avenue Hotel has a storied history"
                + " that began in 1950 as a modest inn. Over the years, it grew into a premier "
                + "destination\nrenowned for its exceptional service and luxurious accommodations."
                + " Through expansions and renovations, the hotel has seamlessly\nblended timeless"
                + " charm with contemporary design, becoming an icon of luxury and sophistication."
                + " Today, the Marl Avenue Hotel\nstands as a preferred choice for discerning guests"
                + " worldwide, offering breathtaking architecture, opulent interiors, and "
                + "world-class\namenities. Its commitment to unparalleled service has earned it"
                + " numerous accolades, solidifying its position as one of the finest \n"
                + "establishments in the hospitality industry.");
        historyDescription.setEditable(false);
        historyDescription.setFont(new Font("Segoe UI", 0, 12));

        historyScrollPane = new JScrollPane(historyDescription);
        historyScrollPane.setBounds(20, 220, 760, 80);

        mainPanel.add(historyLabel);
        mainPanel.add(historyScrollPane);
    }

    /*Creates and configures the contact section. Adds a title label,
     *information text, input fields, and a send button to the main panel.
     *Configures an action listener for the send button.
     */
    private void contact() {

        contactLabel = new JLabel("Contact Us");
        contactLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        contactLabel.setBounds(350, 300, 280, 50);

        infoText = new JTextArea("Fill out the online enquiry "
                + "form below or call us on +64 21 0123456 and one of our "
                + "members of staff at The Marl Avenue Hotel will be in\n"
                + "contact with you as soon as possible.");
        infoText.setEditable(false);
        infoText.setBounds(20, 350, 740, 40);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Segoe UI", 0, 18));
        nameLabel.setBounds(20, 400, 100, 30);

        nameText = new JTextArea("");
        nameText.setBounds(80, 405, 150, 20);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Segoe UI", 0, 18));
        phoneLabel.setBounds(400, 400, 150, 30);

        phoneText = new JTextArea("");
        phoneText.setBounds(535, 405, 150, 20);

        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", 0, 18));
        emailLabel.setBounds(20, 440, 100, 30);

        emailText = new JTextArea("");
        emailText.setBounds(80, 445, 680, 20);

        additionalLabel = new JLabel("Additional Information:");
        additionalLabel.setFont(new Font("Segoe UI", 0, 18));
        additionalLabel.setBounds(20, 475, 200, 30);

        additionalText = new JTextArea("");
        additionalPane = new JScrollPane(additionalText);
        additionalPane.setBounds(210, 485, 552, 50);

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Segoe UI", 0, 18));
        sendButton.setBounds(20, 505, 150, 20);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                phoneText.setText("");
                emailText.setText("");
                additionalText.setText("");
            }
        });

        mainPanel.add(contactLabel);
        mainPanel.add(infoText);
        mainPanel.add(nameLabel);
        mainPanel.add(nameText);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneText);
        mainPanel.add(emailLabel);
        mainPanel.add(emailText);
        mainPanel.add(additionalLabel);
        mainPanel.add(additionalPane);
        mainPanel.add(sendButton);
    }

    /*Called when the return button is clicked. It disposes of the current 
    *frame and makes the homepage frame visible.
     */
    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }
}
