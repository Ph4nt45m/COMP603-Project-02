/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author snipi
 */
public final class FileManager {

    private BufferedReader br;
    private String singleRoomDetails;
    private String doubleRoomDetails;
    private String familyRoomDetails;
    private String groupRoomDetails;
    private String details;

    public FileManager() {
        this.singleRoomDetails = "";
        this.doubleRoomDetails = "";
        this.familyRoomDetails = "";
        this.groupRoomDetails = "";
        this.details = "";
    }

    public String readRoomDetails(String roomType) {
        try {
            br = new BufferedReader(new FileReader("./resources/" + roomType + ".txt"));
            String line = null;

            try {
                while ((line = br.readLine()) != null) {
                    if (roomType.contains("Single")) {
                        this.singleRoomDetails += line + "\n";
                    } else if (roomType.contains("Double")) {
                        this.doubleRoomDetails += line + "\n";
                    } else if (roomType.contains("Family")) {
                        this.familyRoomDetails += line + "\n";
                    } else if (roomType.contains("Group")) {
                        this.groupRoomDetails += line + "\n";
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File for Single Room details was not found!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("There was an error closing BufferedReader");
                }
            }

            if (roomType.contains("Single")) {
                this.details += this.singleRoomDetails;
            } else if (roomType.contains("Double")) {
                this.details += this.doubleRoomDetails;
            } else if (roomType.contains("Family")) {
                this.details += this.familyRoomDetails;
            } else if (roomType.contains("Group")) {
                this.details += this.groupRoomDetails;
            }
        }
        
        return this.details;
    }
}
