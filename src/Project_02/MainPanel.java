/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import javax.swing.JPanel;

/**
 *
 * @author snipi
 */
public class MainPanel extends JPanel {

    DBManager dbManager;
    Connection conn;
    BookingPanel booking;
    FacilitiesPanel facilities;
    FAQPanel faqs;
    VouchersPanel vouchers;

    public MainPanel() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
        booking = new BookingPanel();
        facilities = new FacilitiesPanel();
        faqs = new FAQPanel();
        vouchers = new VouchersPanel();
        setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        
        HomepagePanel homepagePanel = new HomepagePanel(this);
        this.add(homepagePanel);
    }

    public void switchPanel(JPanel panel) {
        this.removeAll();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
