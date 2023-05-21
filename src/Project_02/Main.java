/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import javax.swing.JFrame;

/**
 *
 * @author snipi
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Marl Avenue Hotel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        MainPanel controlPanel = new MainPanel();
        frame.add(controlPanel);
        
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
