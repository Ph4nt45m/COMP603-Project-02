/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author m4ria
 */
public class SingleRoom extends Room {

    //Constructs a Single Room object with the default name and cost.
    public SingleRoom() {
        super("Single Room", 150.00);
    }

    /* Calculates the cost of the Single Room.
     * If the occupant is a student, applies a discount of 15%.
     * returns the calculated cost of the room
     */
    @Override
    public double calculateCost() {
        if (super.isStudent()) {
            this.setCost(this.cost * 0.85);
        }
        return this.cost;
    }

    /*Checks if the Single Room has children.
     * Single Rooms do not have children, so it always returns false.
     * return false
     */
    @Override
    public boolean hasChildren() {
        return false;
    }

    /*Sets the availability of children in the Single Room. Since Single Rooms
     * do not have children, this method does nothing.
     */
    @Override
    public void setHasChildren(boolean hasChildren) {

    }
}
