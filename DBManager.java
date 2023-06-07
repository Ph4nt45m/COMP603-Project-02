/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author snipi
 */
public final class DBManager {

    private final String USER_NAME = "MAH";
    private final String PASSWORD = "MAH";
    private final String projectFolderPath;
    private final String databaseFolderPath;

    Connection conn;

    public DBManager() {
        this.projectFolderPath = System.getProperty("user.dir");
        this.databaseFolderPath = "jdbc:derby:" + this.projectFolderPath + "/MarlAvenueHotelDB;create = true";

        establishConnection();
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void establishConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(databaseFolderPath, USER_NAME, PASSWORD);
                if (conn != null) {
                    System.out.println("Connection established successfully.");
                }
            } catch (SQLException ex) {
                System.out.println("Connection failed. Error: " + ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Disconnected successfully.");
            } catch (SQLException ex) {
                System.out.println("Disconnect failed. Error: " + ex.getMessage());
            }
        }
    }
    
    public void addToBookingList() {
        
    }
}
