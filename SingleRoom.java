/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author snipi
 */
public class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 150.00);
    }

    @Override
    public double calculateCost() {
        if (super.isStudent()) {
            this.setCost(this.cost * 0.85);
        }
        return this.cost;
    }
    
    @Override
    public boolean hasChildren() {
        return false;
    }
    
    @Override
    public void setHasChildren(boolean hasChildren) {
        
    }
}
