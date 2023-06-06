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
import javax.swing.JTextPane;

/**
 *
 * @author m4ria
 */
public class Facilities extends JFrame {

    Homepage homepage;
    JPanel mainPanel;
    JButton returnButton;
    JButton backButton;
    Facilities facilities;

    public Facilities(Homepage home) {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(550, 550));

        setResizable(false);
        this.homepage = home;

        menu();
        pack();

        setVisible(true);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goingBackButton(e);
            }
        });
    }

    private void menu() {
        setTitle("Facilities");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title();
        returnToHomepage();
        faciltiesTitle();
        wifiButton();
        restaurantButton();
        conciergeButton();
        saunaButton();
        fitnessButton();
        laundryButton();
        swimmingPoolButton();
        conferenceButton();

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

    private void faciltiesTitle() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel descriptionLabel = new JLabel("Facilities:");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        descriptionLabel.setBounds(220, 50, 300, 50);

        mainPanel.add(descriptionLabel);
    }

    private void wifiButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

//        JButton wifi = createButton("WIFI", "You have chosen WIFI.\n\n"
//                + "Keep productive whilst staying at Marl Avenue Hotel, with unlimited Wi-Fi in all areas of the hotel. "
//                + "The Business Centre offers guests 24-hour access to a range of facilities and services including computers, "
//                + "printers, and photocopying, as well as courier and secretarial services.");

    JButton wifi = new JButton();
    wifi.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            createPanel("WIFI", "You have chosen WIFI.\n\n" + 
                    "Keep productive whilst staying at Marl Avenue Hotel, with unlimited Wi-Fi in all areas of the hotel. " +
                    "The Business Centre offers guests 24-hour access to a range of facilities and services including computers, " +
                    "printers, and photocopying, as well as courier and secretarial services.");
            dispose();
        }
    });
        wifi.setBounds(205, 110, 150, 40);

        mainPanel.add(wifi);
    }

    private void restaurantButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton restaurantBar = createButton("Restaurant & Bar", "You have chosen Restaurant & Bar.\n\n"
                + "Whether you are a guest at Marl Avenue Hotel or out for a day in the central city, stop by our in-house Amore Restaurant. "
                + "The restaurant is located on Level 4 and is open daily 12:00pm - 3:00pm for Lunch and then from 5:00pm - 10.00 pm for Dinner.");
        restaurantBar.setBounds(205, 160, 150, 40);

        mainPanel.add(restaurantBar);
    }

    private void conciergeButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton concierge = createButton("Concierge", "You have chosen Concierge.\n\n"
                + "If you are looking to explore Auckland and want to know the best places to visit, book local\n"
                + "attractions, eat at the best restaurants in Auckland CBD or any other local recommendation,\n"
                + "get in touch with our Concierge team, located in the hotel lobby.");
        concierge.setBounds(205, 210, 150, 40);

        mainPanel.add(concierge);
    }

    private void saunaButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton sauna = createButton("Sauna", "You have chosen Sauna.\n\n"
                + "A sauna to relax in after your training session.\n");
        sauna.setBounds(205, 260, 150, 40);

        mainPanel.add(sauna);
    }

    private void fitnessButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton fitness = createButton("Fitness Center", "You have chosen Fitness Center.\n\n"
                + "Stay active with our fitness facilities, designed to work around your\n"
                + "schedule. Our fitness centre operates 24/7, accessed via your room card.\n"
                + "It features bikes, treadmills and basic training machines, with extra towels available.");
        fitness.setBounds(205, 310, 150, 40);

        mainPanel.add(fitness);
    }

    private void laundryButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton laundry = createButton("Laundry Services",
                "You have chosen the Laundry Service.\n\n"
                + "Marl Avenue Hotel has on-site laundry facilities available "
                + "for guests.\n"
                + "Our self-service laundry is available 24/7 located on level "
                + "17. A small charge of $2 applies for this\n"
                + "service, with soap powder complimentary. We also offer a "
                + "same-day laundry service, ensuring your\n"
                + "garments are treated with care and are ready for you on "
                + "time. Service charges apply, with weekend\n"
                + "surcharges.");
        laundry.setBounds(205, 360, 150, 40);

        mainPanel.add(laundry);
    }

    private void swimmingPoolButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton pool = createButton("Swimming Pools",
                "You have chosen the Indoor & Outdoor Swimming Pool.\n"
                + "We have two outdoor swimming pools, one located in the first "
                + "floor accompanied by a terrace. Our other\n"
                + "outdoor pool is on the top floor looking out into the views "
                + "of Auckland. They are both open from\n"
                + "8:00 am - 10:00 pm. Our indoor swimming pool is also on the "
                + "same floor as the Fitness Center, floor 12.\n"
                + "Open 24/7.");
        pool.setBounds(205, 410, 150, 40);

        mainPanel.add(pool);
    }

    private void conferenceButton() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton conference = createButton("Conference Rooms", "You have chosen the Conference/Meeting Rooms.\n\n"
                + "Leave a lasting impression on your guests with our venues modern interiors, floor to ceiling windows,\n"
                + "delicious catering, and relaxing outdoor space. Our conference venue is highly versatile and can be\n"
                + "configured in multiple ways, so whether you are hosting a small business meeting or networking event,\n"
                + "the room will be set up accordingly. Fitted with cutting-edge A/V facilities to make presenting, sound\n"
                + "configuration, and sorting out microphone connections stress-free, we have designed our new conference\n"
                + "venue to make hosting an event as easy as possible. You will also have a dedicated conference manager\n"
                + "to ensure everything runs smoothly.");

        conference.setBounds(205, 460, 150, 40);
        mainPanel.add(conference);
    }

    private JButton createButton(String buttonText, final String information) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPanel(buttonText, information);
            }
        });
        return button;
    }

    private void createPanel(String facilityName, String information) {
        JFrame frame = new JFrame();
        frame.setTitle(facilityName);
        int width = 800;
        int height = 600;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel customPanel = new JPanel();
        customPanel.setLayout(null);

        // Title
        JLabel titleLabel = new JLabel("Marl Avenue Hotel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(20, 10, 200, 30);
        customPanel.add(titleLabel);

        JLabel facilityLabel = new JLabel(facilityName);
        facilityLabel.setFont(new Font("Arial", Font.BOLD, 21));
        facilityLabel.setBounds(380, 40, 300, 30);
        customPanel.add(titleLabel);

        JTextPane customTextPane = new JTextPane();
        customTextPane.setText(information);
        customTextPane.setFont(new Font("Arial", Font.PLAIN, 15));
        customTextPane.setEditable(false);
        customTextPane.setBounds(20, 100, 740, 200);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(20, 70, 150, 20);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current panel/frame
                facilities.setVisible(true); // Show the previous facilities panel
            }
        });
        customPanel.add(backButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });

        customPanel.add(facilityLabel);
        customPanel.add(titleLabel);
        customPanel.add(customTextPane);
        customPanel.add(returnButton);
        goBack();
        frame.add(customPanel);
        frame.setVisible(true);
    }

    private void returnToHomepage() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        returnButton = new JButton("Return to Homepage");
        returnButton.setBounds(20, 40, 150, 20);
        mainPanel.add(returnButton);
    }

    private void goBack() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        backButton = new JButton("Back");
        backButton.setBounds(20, 70, 150, 20);
    }

    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }

    private void goingBackButton(ActionEvent event) {
        this.dispose();
        facilities.setVisible(true);
    }

}
