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

    public DoubleRoom(boolean isStudent, boolean haschildren) {
        super("Double Room", isStudent, 250.00);
        this.hasChildren = haschildren;
    }

    public boolean hasChildren() {
        return hasChildren;
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
    public String getStudentStatus() {
        String status = "";
        if (super.isStudent()) {
            status = "Yes";
        } else {
            status = "No";
        }
        
        return status;
    }
    
    @Override
    public String getChildStatus() {
        String status = "";
        if (this.hasChildren()) {
            status = "Yes";
        } else {
            status = "No";
        }
        
        return status;
    }
    
    @Override
    public String getFamilyStatus() {
        return "No";
    }
}
