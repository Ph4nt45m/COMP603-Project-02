package Project_02;

/**
 *
 * @author m4ria
 */
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Facilities extends JFrame {

    Homepage homepage;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;

    public Facilities(Homepage home) {
        this.homepage = home;
        setSize(800, 600);
        createGUI();

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepageButton(e);
            }
        });
    }

    private void createGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Facilities");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(10, 0, 20, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        button1 = createButton("WIFI", "You have chosen WIFI.\n\n"
                + "Keep productive whilst staying at Marl Avenue Hotel, with unlimited Wi-Fi in all areas of the hotel. "
                + "The Business Centre offers guests 24-hour access to a range of facilities and services including computers, "
                + "printers, and photocopying, as well as courier and secretarial services.");

        button2 = createButton("Restaurant & Bar", "You have chosen Restaurant & Bar.\n\n"
                + "Whether you are a guest at Marl Avenue Hotel or out for a day in the central city, stop by our in-house Amore Restaurant. "
                + "The restaurant is located on Level 4 and is open daily 12:00pm - 3:00pm for Lunch and then from 5:00pm - 10.00 pm for Dinner.");

        button3 = createButton("Concierge", "You have chosen Concierge.\n\n"
                + "If you are looking to explore Auckland and want to know the best places to visit, book local\n"
                + "attractions, eat at the best restaurants in Auckland CBD or any other local recommendation,\n"
                + "get in touch with our Concierge team, located in the hotel lobby.");

        button4 = createButton("Sauna", "You have chosen Sauna.\n\n"
                + "A sauna to relax in after your training session.\n");

        button5 = createButton("Fitness Center", "You have chosen Fitness Center.\n\n"
                + "Stay active with our fitness facilities, designed to work around your\n"
                + "schedule. Our fitness centre operates 24/7, accessed via your room card.\n"
                + "It features bikes, treadmills and basic training machines, with extra towels available.");

        button6 = createButton("Laundry Service", "You have chosen the Laundry Service.\n\n"
                + "Marl Avenue Hotel has on-site laundry facilities available for guests.\n"
                + "Our self-service laundry is available 24/7 located on level 17. A small charge of $2 applies for this\n"
                + "service, with soap powder complimentary. We also offer a same-day laundry service, ensuring your\n"
                + "garments are treated with care and are ready for you on time. Service charges apply, with weekend\n"
                + "surcharges.");

        button7 = createButton("Indoor & Outdoor Swimming Pool", "You have chosen the Indoor & Outdoor Swimming Pool.\n\n"
                + "We have two outdoor swimming pools, one located in the first floor accompanied by a terrace. Our other\n"
                + "outdoor pool is on the top floor looking out into the views of Auckland. They are both open from\n"
                + "8:00 am - 10:00 pm. Our indoor swimming pool is also on the same floor as the Fitness Center, floor 12.\n"
                + "Open 24/7.");

        button8 = createButton("Conference/Meeting Rooms", "You have chosen the Conference/Meeting Rooms.\n\n"
                + "Leave a lasting impression on your guests with our venues modern interiors, floor to ceiling windows,\n"
                + "delicious catering, and relaxing outdoor space. Our conference venue is highly versatile and can be\n"
                + "configured in multiple ways, so whether you are hosting a small business meeting or networking event,\n"
                + "the room will be set up accordingly. Fitted with cutting-edge A/V facilities to make presenting, sound\n"
                + "configuration, and sorting out microphone connections stress-free, we have designed our new conference\n"
                + "venue to make hosting an event as easy as possible. You will also have a dedicated conference manager\n"
                + "to ensure everything runs smoothly.");

        button9 = new JButton("Return to Homepage");

        // Create more buttons using the createButton method
        buttonPanel.add(button1);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(button2);
        buttonPanel.add(Box.createVerticalStrut(10));

        buttonPanel.add(button3);
        buttonPanel.add(Box.createVerticalStrut(10));

        buttonPanel.add(button4);
        buttonPanel.add(Box.createVerticalStrut(10));

        buttonPanel.add(button5);
        buttonPanel.add(Box.createVerticalStrut(10));

        buttonPanel.add(button6);
        buttonPanel.add(Box.createVerticalStrut(10));

        buttonPanel.add(button7);
        buttonPanel.add(Box.createVerticalStrut(10));

        buttonPanel.add(button8);
        buttonPanel.add(Box.createVerticalStrut(10));

        buttonPanel.add(button9);

        // Add more buttons to the button panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.add(Box.createHorizontalGlue());
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createHorizontalGlue());

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(titlePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue());

        getContentPane().add(mainPanel);
        
        pack();
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
        frame.setSize(1480, 200);
        frame.setLocationRelativeTo(null);

        JPanel customPanel = new JPanel();
        JTextPane customTextPane = new JTextPane();
        customTextPane.setText(information);
        customTextPane.setFont(new Font("Arial", Font.PLAIN, 15));
        customTextPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(customTextPane);
        scrollPane.setPreferredSize(new Dimension(1450, 150));

        customPanel.add(scrollPane);
        frame.add(customPanel);
        frame.setVisible(true);

    }

    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }
}
