/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

/**
 *
 * @author m4ria
 */
public class Booking {

    protected Date dateBooked;
    protected Date dateLeave;
    protected String firstName;
    protected String surname;
    protected Room roomType;
    protected String phoneNumber;
    protected String email;

    //Constructs a new Booking instance.
    public Booking() {

    }

    //Returns a string representation of the Booking object.
    @Override
    public String toString() {
        return "Date Booked: " + dateBooked.toString() + "\n"
                + "Date Leave: " + dateLeave.toString() + "\n"
                + "First Name: " + firstName + "\n"
                + "Surname: " + surname + "\n"
                + "Room Type: " + roomType.getRoomType() + "\n"
                + "Cost: " + roomType.calculateCost() + "\n"
                + "Phone: " + phoneNumber + "\n"
                + "Email: " + email + "\n\n";
    }
}
