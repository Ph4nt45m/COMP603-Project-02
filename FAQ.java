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
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class FAQ extends JFrame {

    Homepage homepage;
    JPanel mainPanel;
    JButton returnButton;
    JButton sendQuestionButton;

    private String userQuestion;
    private JTextPane responseBox;
    private JTextField askQuestion;
    private Map<String, String> faqMap;
    private JTextPane textPane;
    private JLabel descriptionLabel;
    private JLabel titleLabel;
    private JLabel questionsLabel;

    /*Initializes the FAQ page with the given Homepage instance. Sets up the 
    *main panel and UI components, and registers event listeners for button 
    *clicks.
     */
    public FAQ(Homepage home) {
        this.homepage = home;
        homepage.dbManager.getQuestionsAndAnswers();
        this.faqMap = homepage.dbManager.faqMap;
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

        sendQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userQuestion = askQuestion.getText().trim();
                processUserQuestion();
            }
        });
    }

    //Sets up the menu of the JFrame by calling various helper methods.
    private void menu() {
        setTitle("FAQ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title();
        returnToHomepage();
        label();
        displayedQuestions();
        responseBox();
        otherQuestions();
        submitButton();

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
    private void label() {
        descriptionLabel = new JLabel("Frequently Asked Questions");
        descriptionLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        descriptionLabel.setBounds(250, 50, 500, 50);

        mainPanel.add(descriptionLabel);
    }

    /*Adds the displayed questions pane to the main panel. The pane shows a
     *list of pre-defined questions and their corresponding answers.
     */
    private void displayedQuestions() {
        textPane = new JTextPane();
        textPane.setBounds(20, 110, 760, 260);
        textPane.setEditable(false);
        String string = "";
        for (Map.Entry<String, String> entry : faqMap.entrySet()) {
            String question = entry.getKey();
            String answer = entry.getValue();

            string += question + "\n" + answer + "\n\n";
        }
        textPane.setText(string);
        textPane.setFont(new Font("Segoe UI", 0, 12));

        mainPanel.add(textPane);
    }

    /*Adds the response box to the main panel. The response box displays the
     *answer to a user's question.
     */
    private void responseBox() {
        responseBox = new JTextPane();
        responseBox.setBounds(20, 380, 760, 100);
        responseBox.setEditable(false);

        mainPanel.add(responseBox);
    }

    /*Adds the "Any Other Questions?" label and the ask question text field to
     * the main panel. Users can enter their own questions in the text field.
     */
    private void otherQuestions() {
        questionsLabel = new JLabel("Any Other Questions?");
        questionsLabel.setFont(new Font("Segoe UI", 0, 20));
        questionsLabel.setBounds(20, 490, 200, 50);

        askQuestion = new JTextField();
        askQuestion.setBounds(230, 500, 550, 30);

        mainPanel.add(questionsLabel);
        mainPanel.add(askQuestion);
    }

    /*Adds the submit button to the main panel. The submit button triggers the
     * processing of the user's question.
     */
    private void submitButton() {
        sendQuestionButton = new JButton("Send Question");
        sendQuestionButton.setBounds(660, 560, 120, 20);

        mainPanel.add(sendQuestionButton);
    }

    /*Processes the user's question by querying the database for a similar
     * question and its corresponding answer. The response is displayed in the
     * response box.
     */
    private void processUserQuestion() {
        Map<String, String> similarQ = homepage.dbManager.getAnswerForQuestion(userQuestion);
        String answer = "";
        if(!similarQ.isEmpty()){
            for(Map.Entry<String, String> entry : similarQ.entrySet()) {
                answer += entry.getKey() + "\n" + entry.getValue() + "\n\n";
            }
        } else {
            answer = "Thanks for your question. Our staff at Marl Hotel Avenue will get back to you as soon as possible!";
        }
        
        responseBox.setText(answer);
    }

    /*Action performed when the homepage button is clicked. Disposes of the
    *current frame and makes the homepage frame visible.
     */
    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }
}
