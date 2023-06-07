/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author snipi
 */
public class DoubleRoom extends Room {
    
    private boolean hasChildren;

    public DoubleRoom() {
        super("Double Room",  250.00);
        this.hasChildren = false;
    }

    public void setChildren(boolean children) {
        this.hasChildren = children;
    }
    
    @Override
    public double calculateCost() {
        if (super.isStudent()) {
            this.setCost(this.cost * 0.85);
        } else if (hasChildren) {
            this.setCost(this.cost * 0.8);
        }

        return this.cost;
    }
    
    @Override
    public boolean hasChildren() {
        return hasChildren;
    }
}
