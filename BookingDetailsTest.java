/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Project_02;

import java.time.LocalDate;
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
public class BookingDetailsTest {

    BookingDetails instance = new BookingDetails();

    public BookingDetailsTest() {
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
    public void testPastBookingDate() {
        String givenDate = "08/06/2023";
        instance.bDateInput.setText(givenDate);
        instance.verifyBookDate();
        boolean result = instance.validBDate;
        assertFalse(result);
    }
    
    @Test
    public void testInvalidBookingDate() {
        String givenDate = "Hello World";
        instance.bDateInput.setText(givenDate);
        instance.verifyBookDate();
        boolean result = instance.validBDate;
        assertFalse(result);
    }
}
