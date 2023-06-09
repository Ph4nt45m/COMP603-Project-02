/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author m4ria
 */
public abstract class Room {

    private String roomType;
    protected double cost;
    private boolean isStudent;

    //Constructs a new Room object with the specified room type and cost.
    public Room(String roomType, double cost) {
        this.roomType = roomType;
        this.cost = cost;
        this.isStudent = false;
    }

    //Checks if the room is assigned to a student, returns true if it is, otherwise, return false.
    public boolean isStudent() {
        return isStudent;
    }

    //Sets the student status of the room. If the room is assigned to a student, false otherwise.
    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    //Retrieves the room type.
    public String getRoomType() {
        return roomType;
    }

    //Sets the room type.
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    //Sets the cost of the room.
    public void setCost(double cost) {
        this.cost = cost;
    }

    //Calculates the cost of the room.
    public abstract double calculateCost();

    //Checks if the room has children.
    public abstract boolean hasChildren();

    //Sets the status of the room regarding children.
    public abstract void setHasChildren(boolean status);
}
