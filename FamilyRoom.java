/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author m4ria
 */
public class FamilyRoom extends Room {

    private boolean hasChildren;

    //Constructs a new FamilyRoom object.
    public FamilyRoom() {
        super("Family Room", 350.00);
        this.hasChildren = false;
    }

    //Calculates the cost of the family room based on whether it has children or not.
    @Override
    public double calculateCost() {
        if (hasChildren()) {
            this.setCost(this.cost * 0.75);
        }

        return this.cost;
    }

    //Checks if the family room has children.
    @Override
    public boolean hasChildren() {
        return hasChildren;
    }

    //Sets the status of whether the family room has children or not.
    @Override
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
