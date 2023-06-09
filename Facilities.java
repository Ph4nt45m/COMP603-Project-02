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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author m4ria
 */
public class Facilities extends JFrame {

    private JButton returnButton;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JButton wifi;
    private JButton restaurantBar;
    private JButton restaurantMenu;
    private JButton concierge;
    private JButton sauna;
    private JButton fitness;
    private JButton laundry;
    private JButton pool;
    private JButton conference;
    private JPanel mainPanel;

    Homepage homepage;

    public Facilities(Homepage home) {
        this.homepage = home;
        menu();
    }

    //Sets up the menu of the JFrame by calling various helper methods.
    private void menu() {
        titleLabel = new JLabel();
        descriptionLabel = new JLabel();
        mainPanel = new JPanel();

        returnToHomepage();
        title();
        faciltiesTitle();
        wifiButton();
        restaurantButton();
        conciergeButton();
        saunaButton();
        fitnessButton();
        laundryButton();
        swimmingPoolButton();
        conferenceButton();
        setMainPanel();
        setFrame();
    }

    /*Adds a return button to the main panel with the text "Return to Homepage" 
    *and sets its position.
     */
    private void returnToHomepage() {
        returnButton = new JButton("Return to Homepage");
        returnButton.setBounds(10, 40, 150, 20);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });

        mainPanel.add(returnButton);
    }

    /*Action performed when the homepage button is clicked. Disposes of the
    *current frame and makes the homepage frame visible.
     */
    private void homepageButton(ActionEvent event) {
        homepage.setVisible(true);
        this.dispose();
    }

    //Sets up the title label of the JFrame.
    private void title() {
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setText("Marl Avenue Hotel");
        titleLabel.setBounds(20, 10, 200, 30);
    }

    //Sets the title label of the topic.
    private void faciltiesTitle() {
        descriptionLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        descriptionLabel.setText("Facilities:");
        descriptionLabel.setBounds(220, 50, 300, 50);
    }

    //Sets the WIFI facility name and information in the button and sets the bounds.
    private void wifiButton() {
        wifi = createButton("WIFI", "You have chosen WIFI.\n\n"
                + "Keep productive whilst staying at Marl Avenue Hotel, with unlimited Wi-Fi in all areas of the hotel. "
                + "The Business Centre offers guests 24-hour access to a range of facilities and services including computers, "
                + "printers, and photocopying, as well as courier and secretarial services.");

        wifi.setBounds(205, 110, 150, 40);
    }

    //Sets the restaurant facility name and information in the button and sets the bounds.
    private void restaurantButton() {
        restaurantBar = createButton("Restaurant & Bar", "You have chosen Restaurant & Bar.\n\n"
                + "Whether you are a guest at Marl Avenue Hotel or out for a day in the central city, stop by our in-house Amore Restaurant. "
                + "The restaurant is located on Level 4 and is open daily 12:00pm - 3:00pm for Lunch and then from 5:00pm - 10.00 pm for Dinner.");

        restaurantBar.setBounds(205, 160, 150, 40);
    }

    //Sets the concierge facility name and information in the button and sets the bounds.
    private void conciergeButton() {
        concierge = createButton("Concierge", "You have chosen Concierge.\n\n"
                + "If you are looking to explore Auckland and want to know the best places to visit, book local\n"
                + "attractions, eat at the best restaurants in Auckland CBD or any other local recommendation,\n"
                + "get in touch with our Concierge team, located in the hotel lobby.");

        concierge.setBounds(205, 210, 150, 40);
    }

    //Sets the sauna facility name and information in the button and sets the bounds.
    private void saunaButton() {
        sauna = createButton("Sauna", "You have chosen Sauna.\n\n"
                + "A sauna to relax in after your training session.\n");

        sauna.setBounds(205, 260, 150, 40);
    }

    //Sets the fitness facility name and information in the button and sets the bounds.
    private void fitnessButton() {
        fitness = createButton("Fitness Center", "You have chosen Fitness Center.\n\n"
                + "Stay active with our fitness facilities, designed to work around your\n"
                + "schedule. Our fitness centre operates 24/7, accessed via your room card.\n"
                + "It features bikes, treadmills and basic training machines, with extra towels available.");

        fitness.setBounds(205, 310, 150, 40);
    }

    //Sets the ;aundry facility name and information in the button and sets the bounds.
    private void laundryButton() {
        laundry = createButton("Laundry Services",
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
    }

    //Sets the pool facility name and information in the button and sets the bounds.
    private void swimmingPoolButton() {
        pool = createButton("Swimming Pools",
                "You have chosen the Indoor & Outdoor Swimming Pool.\n"
                + "We have two outdoor swimming pools, one located in the first "
                + "floor accompanied by a terrace. Our other\n"
                + "outdoor pool is on the top floor looking out into the views "
                + "of Auckland. They are both open from\n"
                + "8:00 am - 10:00 pm. Our indoor swimming pool is also on the "
                + "same floor as the Fitness Center, floor 12.\n"
                + "Open 24/7.");

        pool.setBounds(205, 410, 150, 40);
    }

    //Sets the conference room facility name and information in the button and sets the bounds.
    private void conferenceButton() {
        conference = createButton("Conference Rooms", "You have chosen the Conference/Meeting Rooms.\n\n"
                + "Leave a lasting impression on your guests with our venues modern interiors, floor to ceiling windows,\n"
                + "delicious catering, and relaxing outdoor space. Our conference venue is highly versatile and can be\n"
                + "configured in multiple ways, so whether you are hosting a small business meeting or networking event,\n"
                + "the room will be set up accordingly. Fitted with cutting-edge A/V facilities to make presenting, sound\n"
                + "configuration, and sorting out microphone connections stress-free, we have designed our new conference\n"
                + "venue to make hosting an event as easy as possible. You will also have a dedicated conference manager\n"
                + "to ensure everything runs smoothly.");

        conference.setBounds(205, 460, 150, 40);
    }

    // Creates a JButton with the specified text and information.
    private JButton createButton(String buttonText, String information) {
        JButton button = new JButton(buttonText);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPanel(buttonText, information);
            }
        });

        return button;
    }

    /*Creates a panel to display facility information and name. But if it's the
    *restaurant, it adds a button for the Amore restaurant.
    */
    private void createPanel(String facilityName, String information) {
        JFrame frame = new JFrame();
        frame.setBackground(Color.decode("#fff3e9"));
        frame.setTitle(facilityName);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        int width = 800;
        int height = 400;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel customPanel = new JPanel();
        customPanel.setLayout(null);
        customPanel.setBackground(Color.decode("#fff3e9"));

        JLabel hotelTitleLabel = new JLabel("Marl Avenue Hotel");
        hotelTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        hotelTitleLabel.setBounds(20, 10, 200, 30);

        JLabel facilityLabel = new JLabel(facilityName);
        facilityLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
        facilityLabel.setBounds(340, 40, 300, 30);

        JTextPane customTextPane = new JTextPane();
        customTextPane.setText(information);
        customTextPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        customTextPane.setEditable(false);
        customTextPane.setBounds(20, 100, 740, 200);

        customPanel.add(hotelTitleLabel);
        customPanel.add(facilityLabel);
        customPanel.add(customTextPane);

        if (facilityName.equalsIgnoreCase("Restaurant & Bar")) {
            restaurantMenu = new JButton("Amore Menu");
            restaurantMenu.setBounds(600, 320, 150, 20);
            restaurantMenu.setFont(new Font("Segoe UI", 0, 12));
            customPanel.add(restaurantMenu);

            restaurantMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String filePath = "./resources/Menu.txt";
                    String menuContent = readMenuFile(filePath);
                    if (menuContent != null) {
                        JFrame menuFrame = new JFrame();
                        menuFrame.setTitle("Amore Menu");
                        menuFrame.setSize(800, 600);
                        menuFrame.setLocationRelativeTo(null);
                        menuFrame.setResizable(false);
                        menuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                        menuFrame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                menuFrame.dispose();
                            }
                        });

                        JTextPane menuTextPane = new JTextPane();
                        menuTextPane.setText(menuContent);
                        menuTextPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                        menuTextPane.setEditable(false);
                        menuTextPane.setBounds(20, 100, 740, 400);
                        menuFrame.add(menuTextPane);

                        menuFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error reading the menu file.");
                    }
                }
            });
        }

        frame.getContentPane().add(customPanel);
        frame.setVisible(true);
    }

    private String readMenuFile(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder menuContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                menuContent.append(line).append("\n");
            }
            reader.close();
            return menuContent.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Adds the components to the main panel.
    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(550, 550));
        mainPanel.setLayout(null);

        mainPanel.add(returnButton);
        mainPanel.add(titleLabel);
        mainPanel.add(descriptionLabel);
        mainPanel.add(wifi);
        mainPanel.add(restaurantBar);
        mainPanel.add(concierge);
        mainPanel.add(sauna);
        mainPanel.add(fitness);
        mainPanel.add(laundry);
        mainPanel.add(pool);
        mainPanel.add(conference);
    }

    //Sets the frame options like title, size, etc.
    private void setFrame() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainPanel.setBackground(Color.decode("#fff3e9"));
        setTitle("Facilities");
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
