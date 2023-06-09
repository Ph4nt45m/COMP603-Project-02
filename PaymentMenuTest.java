/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Project_02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author snipi
 */
public class PaymentMenuTest {
    
    PaymentMenu bookingInstance = new PaymentMenu(new DiscountMenu());
    PaymentMenu vouchersInstance = new PaymentMenu(new Vouchers(bookingInstance.homepage));
    
    public PaymentMenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidBooking() {
        int expected = bookingInstance.homepage.dbManager.bookingsList.size();
        bookingInstance.phoneType.setSelectedItem("Home");
        bookingInstance.cardInput.setText("0000 0000 0000 0000");
        bookingInstance.expiryInput.setText("07/2025");
        bookingInstance.discounts.bookDetails.dateBooked = new Date(1, 1, 2025);
        bookingInstance.discounts.bookDetails.dateLeave = new Date(11, 1, 2025);
        bookingInstance.firstNameInput.setText("Karl");
        bookingInstance.surnameInput.setText("Francisco");
        bookingInstance.discounts.bookDetails.roomTypes.selectedRoom = "Single Room";
        bookingInstance.discounts.studentDisStatus = false;
        bookingInstance.discounts.childDisStatus = false;
        bookingInstance.phoneInput.setText("8284386");
        bookingInstance.emailInput.setText("testing@hotmail.com");
        int result = bookingInstance.homepage.dbManager.bookingsList.size();
        assertEquals(expected, result, 0);
    }
    
    @Test
    public void testvalidBookingChildDiscount() {
        double expected = 127.5;
        bookingInstance.phoneType.setSelectedItem("Home");
        bookingInstance.cardInput.setText("0000 0000 0000 0000");
        bookingInstance.expiryInput.setText("07/2025");
        bookingInstance.discounts.bookDetails.dateBooked = new Date(28, 9, 2025);
        bookingInstance.discounts.bookDetails.dateLeave = new Date(12, 3, 2025);
        bookingInstance.firstNameInput.setText("Karl");
        bookingInstance.surnameInput.setText("Francisco");
        bookingInstance.discounts.bookDetails.roomTypes.selectedRoom = "Family Room";
        bookingInstance.discounts.studentDisStatus = false;
        bookingInstance.discounts.childDisStatus = true;
        bookingInstance.phoneInput.setText("8284386");
        bookingInstance.emailInput.setText("testing@hotmail.com");
        double result = bookingInstance.homepage.dbManager.bookingsList.get(bookingInstance.homepage.dbManager.bookingsList.size() - 2).roomType.cost;
        assertEquals(expected, result, 0);
    }
    
    @Test
    public void testValidBookingStudentDiscount() {
        double expected = 127.5;
        bookingInstance.phoneType.setSelectedItem("Home");
        bookingInstance.cardInput.setText("0000 0000 0000 0000");
        bookingInstance.expiryInput.setText("07/2025");
        bookingInstance.discounts.bookDetails.dateBooked = new Date(4, 13, 2025);
        bookingInstance.discounts.bookDetails.dateLeave = new Date(7, 2, 2025);
        bookingInstance.firstNameInput.setText("Karl");
        bookingInstance.surnameInput.setText("Francisco");
        bookingInstance.discounts.bookDetails.roomTypes.selectedRoom = "Single Room";
        bookingInstance.discounts.studentDisStatus = true;
        bookingInstance.discounts.childDisStatus = false;
        bookingInstance.phoneInput.setText("8284386");
        bookingInstance.emailInput.setText("testing@hotmail.com");
        JButton button = bookingInstance.saveButton;
        double result = bookingInstance.homepage.dbManager.bookingsList.get(bookingInstance.homepage.dbManager.bookingsList.size() - 2).roomType.cost;
        assertEquals(expected, result, 0);
    }
}
