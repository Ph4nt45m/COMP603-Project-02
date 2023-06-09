/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author m4ria
 */
public class GroupRoom extends Room {

    private boolean hasChildren;

    //Constructs a new GroupRoom object.
    public GroupRoom() {
        super("Group Room", 450.00);
        this.hasChildren = false;
    }

    //Calculates the cost of the group room based on certain conditions. 
    //Returns calculated cost of the group room.
    @Override
    public double calculateCost() {
        if (super.isStudent()) {
            this.setCost(this.cost * 0.85);
        } else if (hasChildren) {
            this.setCost(this.cost * 0.8);
        }

        return this.cost;
    }

    //Checks if the group room has children.
    @Override
    public boolean hasChildren() {
        return hasChildren;
    }

    //Sets the status of whether the group room has children or not.
    @Override
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
