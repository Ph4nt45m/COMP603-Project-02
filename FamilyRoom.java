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

    private boolean isFamily;
    
    public FamilyRoom(boolean isFamily) {
        super("Family Room", false, 350.00);
        this.isFamily = isFamily;
    }

    public boolean isFamily() {
        return isFamily;
    }

    public void setIsFamily(boolean isFamily) {
        this.isFamily = isFamily;
    }
    
    @Override
    public double calculateCost() {
        if (isFamily()) {
            this.setCost(this.cost * 0.75);
        }

        return this.cost;
    }
    
    @Override
    public String getStudentStatus() {
        return "No";
    }
    
    @Override
    public String getChildStatus() {
        return "No";
    }
    
    @Override
    public String getFamilyStatus() {
        String status = "";
        if (this.isFamily()) {
            status = "Yes";
        } else {
            status = "No";
        }
        
        return status;
    }
}
