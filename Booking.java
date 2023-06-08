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
    protected Date dateBooked;
    protected Date dateLeave;
    protected String firstName;
    protected String surname;
    protected Room roomType;
    protected String phoneNumber;
    protected String email;
    private String addBookingSQLValue;
    
    public Booking() {
        this.addBookingSQLValue = "";
    }
}
