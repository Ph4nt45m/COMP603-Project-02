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

    public SingleRoom(boolean isStudent) {
        super("Single Room", isStudent, 150.00);
    }

    @Override
    public double calculateCost() {
        if (super.isStudent()) {
            this.setCost(this.cost * 0.85);
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
        return "No";
    }
    
    @Override
    public String getFamilyStatus() {
        return "No";
    }
}
