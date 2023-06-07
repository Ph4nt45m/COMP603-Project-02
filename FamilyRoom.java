/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author snipi
 */
public class FamilyRoom extends Room {

    private boolean hasChildren;
    
    public FamilyRoom() {
        super("Family Room", 350.00);
        this.hasChildren = false;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
    
    @Override
    public double calculateCost() {
        if (hasChildren()) {
            this.setCost(this.cost * 0.75);
        }

        return this.cost;
    }
    
    @Override
    public boolean hasChildren() {
        return hasChildren;
    }
}
