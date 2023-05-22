/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author snipi
 */

public abstract class Room {

    private String roomType;
    protected double cost;
    private boolean isStudent;
    
    public Room(String roomType, boolean isStudent, double cost) {
        this.roomType = roomType;
        this.cost = cost;
        this.isStudent = isStudent;
    }
    
    public boolean isStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }
    
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public abstract double calculateCost();
    
    public abstract String getStudentStatus();
    
    public abstract String getChildStatus();
    
    public abstract String getFamilyStatus();
}
