/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Project_02;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

/**
 *
 * @author snipi
 */
public class RoomDetails extends JFrame {

    private JTextPane detailsPane;
    private JScrollPane scrollPane;
    private JPanel mainPanel;

    protected FileManager fm;
    protected RoomTypes roomTypes;
    protected String roomType;

    public RoomDetails(String roomType, RoomTypes rmTypes) {
        this.fm = new FileManager();
        this.roomTypes = rmTypes;
        this.roomType = roomType;
        setComponents();
    }

    private void setComponents() {
        detailsPane = new JTextPane();
        scrollPane = new JScrollPane();
        mainPanel = new JPanel();

        setDetailsPane();
        setScrollPane();
        setMainPanel();
        setFrame();
    }

    private void setDetailsPane() {
        detailsPane.setFont(new Font("Segoe UI", 0, 17));
        detailsPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        detailsPane.setText(this.fm.readRoomDetails(roomType));
        detailsPane.setEditable(false);
    }

    private void setScrollPane() {
        scrollPane.setBounds(50, 20, 550, 260);
        scrollPane.setViewportView(detailsPane);
    }

    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(650, 300));
        mainPanel.setLayout(null);
        
        mainPanel.add(scrollPane);
    }

    private void setFrame() {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setAutoRequestFocus(false);
        setUndecorated(true);
        setResizable(false);
        setLocation(this.roomTypes.getX() + 8, (this.roomTypes.getY() + this.roomTypes.height + 45));

        getContentPane().add(mainPanel);
        pack();
    }
}
