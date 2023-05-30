/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author snipi
 */
public class GroupRoom extends Room {

    private boolean hasChildren;

    public GroupRoom(boolean isStudent, boolean hasChildren) {
        super("Group Room", isStudent, 450.00);
        this.hasChildren = hasChildren;
    }

    public boolean hasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
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