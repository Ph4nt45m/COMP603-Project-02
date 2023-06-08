/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public FAQ(Homepage home) {
        this.homepage = home;
        homepage.dbManager.getQuestionsAndAnswers();
        this.faqMap = homepage.dbManager.faqMap;
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

        sendQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userQuestion = askQuestion.getText().trim();
                processUserQuestion();
            }
        });
    }

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

    private void label() {
        JLabel descriptionLabel = new JLabel("Frequently Asked Questions");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 28));
        descriptionLabel.setBounds(250, 50, 500, 50);

        mainPanel.add(descriptionLabel);
    }

    private void displayedQuestions() {
        JTextPane textPane = new JTextPane();
        textPane.setBounds(20, 110, 760, 260);
        textPane.setEditable(false);
        String string = "";
        for (Map.Entry<String, String> entry : faqMap.entrySet()) {
            String question = entry.getKey();
            String answer = entry.getValue();

            string += question + "\n" + answer + "\n\n";
        }
        textPane.setText(string);

        mainPanel.add(textPane);
    }

    private void responseBox() {
        responseBox = new JTextPane();
        responseBox.setBounds(20, 380, 760, 100);
        responseBox.setEditable(false);

        mainPanel.add(responseBox);
    }

    private void otherQuestions() {
        JLabel questionsLabel = new JLabel("Any Other Questions?");
        questionsLabel.setFont(new Font("Arial", 0, 20));
        questionsLabel.setBounds(20, 490, 200, 50);

        askQuestion = new JTextField();
        askQuestion.setBounds(230, 500, 550, 30);

        mainPanel.add(questionsLabel);
        mainPanel.add(askQuestion);
    }

    private void submitButton() {
        sendQuestionButton = new JButton("Send Question");
        sendQuestionButton.setBounds(660, 560, 120, 20);

        mainPanel.add(sendQuestionButton);
    }

    private void processUserQuestion() {
        Map<String, String> similarQ = homepage.dbManager.getAnswerForQuestion(userQuestion);
        String answer = "";
        for (Map.Entry<String, String> entry : similarQ.entrySet()) {
            answer += entry.getKey() + "\n" + entry.getValue() + "\n\n";
        }
        responseBox.setText(answer);
    }

//
//    private String getAnswerForQuestion(String question) {
//        for (Map.Entry<String, String> entry : faqMap.entrySet()) {
//            String existingQuestion = entry.getKey();
//            String answer = entry.getValue();
//
//            if (existingQuestion.equalsIgnoreCase(question)) {
//                return answer;
//            }
//        }
//        return "Sorry, the answer to your question is not available in the FAQ.";
//    }

    private void homepageButton(ActionEvent event) {
        this.dispose();
        homepage.setVisible(true);
    }
}
