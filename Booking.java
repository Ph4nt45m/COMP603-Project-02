/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author snipi
 */
public class Booking {
    protected Room roomType;
    protected Date dateBooked;
    protected Date dateLeave;
    protected String firstName;
    protected String surname;
    protected String phoneNumber;
    protected String email;
    private String addBookingSQLValue;
    
    public Booking() {
        this.addBookingSQLValue = "";
    }
    
    public void addBookingSQLValue() {
        this.addBookingSQLValue += "'" + dateBooked.toString() + "', '" + dateLeave.toString() + "', '"
                + firstName + "', '" + surname + "', '" + roomType.getRoomType() + "', '" + roomType.isStudent()
                + "', '" + roomType.hasChildren() + "', '" + roomType.calculateCost() + "', '" + phoneNumber
                + "', '" + email + "'";
    }
}
