/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author m4ria
 */
public class DoubleRoom extends Room {

    private boolean hasChildren;

    //Constructs a new DoubleRoom object.
    public DoubleRoom() {
        super("Double Room", 250.00);
        this.hasChildren = false;
    }

    //Sets the status of whether the double room has children or not.
    public void setChildren(boolean children) {
        this.hasChildren = children;
    }

    //Calculates the cost of the double room based on whether it is for a student or has children.
    @Override
    public double calculateCost() {
        if (super.isStudent()) {
            this.setCost(this.cost * 0.85);
        } else if (hasChildren) {
            this.setCost(this.cost * 0.8);
        }

        return this.cost;
    }

    //Checks if the double room has children.
    @Override
    public boolean hasChildren() {
        return hasChildren;
    }

    //Sets the status of whether the double room has children or not.
    @Override
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
