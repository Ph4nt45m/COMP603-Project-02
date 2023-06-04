/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Contacts extends JFrame {

    JPanel mainPanel;
    Homepage homepage;
    JButton returnButton;

    public Contacts(Homepage home) {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(mainPanel);

        setResizable(false);
        this.homepage = home;
        setPreferredSize(new Dimension(800, 600));
        
        aboutUs();
        getContentPane().add(scrollPane);
        mainPanel.add(scrollPane);
        pack();
        
        setVisible(true);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });

    }

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
    }

    private void title() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Marl Avenue Hotel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(20, 10, 200, 30);

        mainPanel.add(titleLabel);
    }

    private void returnToHomepage() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        returnButton = new JButton("Return to Homepage");
        returnButton.setBounds(20, 40, 150, 20);
        mainPanel.add(returnButton);
    }

    private void hotelInfo() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel descriptionLabel = new JLabel("About Us:");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        descriptionLabel.setBounds(350, 20, 300, 50);

        JTextArea descriptionText = new JTextArea("Welcome to the Marl Avenue Hotel, an epitome "
                + "of luxury and sophistication. Nestled in the heart of a vibrant city, our iconic "
                + "hotel stands \nas a testament to unparalleled grandeur and elegance. From the "
                + "moment you step into our opulent lobby, adorned \nwith magnificent chandeliers "
                + "\nand exquisite artwork, you are transported into a world of refined indulgence. "
                + "Our meticulously \ndesigned rooms and suites offer a harmonious blend of timeless "
                + "aesthetics and modern comforts, \nproviding an oasis of serenity for the discerning"
                + " traveler. Indulge your senses with our world-class \namenities, including a "
                + "rooftop infinity pool offering breathtaking city views, a rejuvenating spa \n"
                + "offering bespoke treatments, and a Michelin-starred restaurant serving "
                + "gastronomic delights. As a \nrecipient of numerous prestigious awards, "
                + "the Marl Avenue Hotel sets the standard for excellence \nin hospitality. "
                + "Our dedicated staff is committed to delivering unparalleled personalized "
                + "service, \nensuring that every moment of your stay is nothing short of "
                + "extraordinary. Discover \nthe pinnacle of luxury at the Marl Avenue Hotel, "
                + "where dreams are turned into unforgettable \nexperiences.");
        descriptionText.setEditable(false);

        // Wrap the descriptionText in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(descriptionText);
        scrollPane.setBounds(20, 80, 760, 80);
        mainPanel.add(descriptionLabel);
        mainPanel.add(scrollPane);

    }

    private void history() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel descriptionLabel = new JLabel("History:");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        descriptionLabel.setBounds(350, 170, 280, 50);

        JTextArea descriptionText = new JTextArea("The Marl Avenue Hotel has a storied history"
                + " that began in 1950 as a modest inn. Over the years, it\n grew into a premier "
                + "destination renowned for its exceptional service and luxurious accommodations.\n"
                + " Through expansions and renovations, the hotel has seamlessly blended \ntimeless"
                + " charm with contemporary design, becoming an icon of luxury and sophistication.\n"
                + " Today, the Marl Avenue Hotel stands as a preferred choice for discerning guests"
                + " worldwide, offering breathtaking architecture, \nopulent interiors, and "
                + "world-class amenities. Its commitment to unparalleled \nservice has earned it"
                + " numerous accolades, solidifying its position as one of the finest \n"
                + "establishments in the hospitality industry.");

        descriptionText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(descriptionText);
        scrollPane.setBounds(20, 220, 760, 80);
        mainPanel.add(descriptionLabel);
        mainPanel.add(scrollPane);
    }

    private void contact() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel contactLabel = new JLabel("Contact Us");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 25));
        contactLabel.setBounds(350, 300, 280, 50);

        JTextArea infoText = new JTextArea("Fill out the online enquiry "
                + "form below or call us on +64 21 0123456 and one of our "
                + "members of staff at The Marl Avenue Hotel will be in\n"
                + "contact with you as soon as possible.");
        infoText.setEditable(false);
        infoText.setBounds(20, 350, 740, 40);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", 0, 18));
        nameLabel.setBounds(20, 400, 100, 30);

        JTextArea nameText = new JTextArea("");
        nameText.setBounds(80, 405, 150, 20);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Arial", 0, 18));
        phoneLabel.setBounds(400, 400, 150, 30);

        JTextArea phoneText = new JTextArea("");
        phoneText.setBounds(535, 405, 150, 20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", 0, 18));
        emailLabel.setBounds(20, 440, 100, 30);

        JTextArea emailText = new JTextArea("");
        emailText.setBounds(80, 445, 680, 20);

        JLabel additionalLabel = new JLabel("Additional Information:");
        additionalLabel.setFont(new Font("Arial", 0, 18));
        additionalLabel.setBounds(20, 475, 200, 30);

        JTextArea additionalText = new JTextArea("");
        JScrollPane additionalPane = new JScrollPane(additionalText);
        additionalPane.setBounds(210, 485, 552, 50);

        JButton sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", 0, 18));
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

    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }
}
