/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m4ria
 */
public final class DBManager {

    private final String USER_NAME = "MAH";
    private final String PASSWORD = "MAH";
    private final String projectFolderPath;
    private final String databaseFolderPath;
    private final LocalDate currentDate;
    protected ArrayList<Booking> bookingsList;
    private boolean bookingSuccessful;
    private Room room;
    protected Map<String, String> faqMap;

    Connection conn;

    //Constructor for the DBManager class. Initializes the DBManager with  variables and establishes a connection to the database.
    public DBManager() {
        this.projectFolderPath = System.getProperty("user.dir");
        this.databaseFolderPath = "jdbc:derby:" + this.projectFolderPath + "/MarlAvenueHotelDB;create = true";
        this.bookingsList = new ArrayList<>();
        this.bookingSuccessful = false;
        this.currentDate = LocalDate.now();

        establishConnection();
        readBookingsList();
        flagBookings();
    }

    // Returns the connection object for the database.
    public Connection getConnection() {
        return this.conn;
    }

    /*Establishes a connection to the database if a connection doesn't already exist.
    *Prints a success message if the connection is established.
    *Exits the program with an error message if the connection fails.
     */
    public void establishConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(databaseFolderPath, USER_NAME, PASSWORD);
                if (conn != null) {
                    System.out.println("Connection established successfully.");
                }
            } catch (SQLException ex) {
                System.out.println("Connection failed. Error: " + ex.getMessage());
                System.exit(0);
            }
        }
    }

    /*Closes the connection to the database if it is open.
    *Prints a success message if the disconnection is successful.
    *Prints an error message if the disconnection fails.
     */
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Disconnected successfully.");
            } catch (SQLException ex) {
                System.out.println("Disconnect failed. Error: " + ex.getMessage());
            }
        }
    }

    /*Reads the bookings from the BOOKINGLIST table in the database and populates the bookingsList array list.
    *Converts the retrieved data into Booking objects and adds them to the list.
    */
    private void readBookingsList() {
        try {
            Statement statement = conn.createStatement();
            ResultSet booking = statement.executeQuery("SELECT * FROM BOOKINGLIST");

            while (booking.next()) {
                Booking newBooking = new Booking();

                String[] bookingDate = booking.getString("BOOKINGDATE").split("/");
                int dayBook = Integer.parseInt(bookingDate[0]);
                int monthBook = Integer.parseInt(bookingDate[1]);
                int yearBook = Integer.parseInt(bookingDate[2]);
                newBooking.dateBooked = new Date(dayBook, monthBook, yearBook);

                String[] bookingLeave = booking.getString("BOOKINGLEAVE").split("/");
                int dayLeave = Integer.parseInt(bookingLeave[0]);
                int monthLeave = Integer.parseInt(bookingLeave[1]);
                int yearLeave = Integer.parseInt(bookingLeave[2]);
                newBooking.dateLeave = new Date(dayLeave, monthLeave, yearLeave);

                newBooking.firstName = booking.getString("FIRSTNAME");
                newBooking.surname = booking.getString("SURNAME");
                String roomType = booking.getString("ROOMTYPE");
                makeRoom(roomType);
                room.setIsStudent(booking.getBoolean("STUDENTDISCOUNT"));
                room.setHasChildren(booking.getBoolean("CHILDDISCOUNT"));
                room.cost = booking.getDouble("COST");
                newBooking.roomType = room;
                newBooking.phoneNumber = booking.getString("PHONENUMBER");
                newBooking.email = booking.getString("EMAIL");

                bookingsList.add(newBooking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Creates a Room object based on the provided roomType and returns it.
    *RoomType is determined by the value stored in the database for the corresponding booking.
    */
    private Room makeRoom(String roomType) {
        if (roomType.contains("Single")) {
            room = new SingleRoom();
        } else if (roomType.contains("Double")) {
            room = new DoubleRoom();
        } else if (roomType.contains("Family")) {
            room = new FamilyRoom();
        } else if (roomType.contains("Group")) {
            room = new GroupRoom();
        }

        return room;
    }

    /*Searches for bookings based on the provided first name, surname, and phone number.
    *Returns an ArrayList of bookings that match the search criteria.
    */
    public ArrayList<Booking> checkForBooking(String firstName, String surname, String phone) {
        ArrayList<Booking> foundBookings = new ArrayList<>();
        for (Booking token : bookingsList) {
            if (firstName != null) {
                if (firstName.equalsIgnoreCase(token.firstName)) {
                    if (!foundBookings.contains(token)) {
                        foundBookings.add(token);
                    }
                }
            }
            if (surname != null) {
                if (surname.equalsIgnoreCase(token.surname)) {
                    if (!foundBookings.contains(token)) {
                        foundBookings.add(token);
                    }
                }
            }
            if (phone != null) {
                if (phone.equals(token.phoneNumber)) {
                    if (!foundBookings.contains(token)) {
                        foundBookings.add(token);
                    }
                }
            }
        }

        return foundBookings;
    }

    /*Adds a new booking to the BOOKINGLIST table in the database.
    *Inserts the booking data into the corresponding columns of the table.
    *Sets the bookingSuccessful flag to true if the booking is added successfully.
     */
    public void addToBookingList(Booking booking) {
        try {
            String query = "INSERT INTO BOOKINGLIST (BOOKINGDATE, BOOKINGLEAVE, FIRSTNAME, SURNAME, ROOMTYPE, STUDENTDISCOUNT, "
                    + "CHILDDISCOUNT, COST, PHONENUMBER, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, booking.dateBooked.toString());
                statement.setString(2, booking.dateLeave.toString());
                statement.setString(3, booking.firstName);
                statement.setString(4, booking.surname);
                statement.setString(5, booking.roomType.getRoomType());
                statement.setBoolean(6, booking.roomType.isStudent());
                statement.setBoolean(7, booking.roomType.hasChildren());
                statement.setDouble(8, booking.roomType.calculateCost());
                statement.setString(9, booking.phoneNumber);
                statement.setString(10, booking.email);

                statement.executeUpdate();
                this.bookingSuccessful = true;
                bookingsList.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Returns the value of the bookingSuccessful flag.
    public boolean isBSuccessful() {
        return this.bookingSuccessful;
    }

    // Resets the bookingSuccessful flag to false.
    public void resetBSuccessful() {
        this.bookingSuccessful = false;
    }

    /*Retrieves bookings from the BOOKINGLIST table that have a booking date in the current month or later.
    *Inserts these bookings into the FLAGGEDBOOKINGS table for further processing or analysis.
    */
    private void flagBookings() {
        try {
            ResultSet bookings;

            try (Statement statement = conn.createStatement()) {
                bookings = statement.executeQuery("SELECT * FROM BOOKINGLIST");

                while (bookings.next()) {
                    String[] bookingDate = bookings.getString("BOOKINGDATE").split("/");
                    int day = Integer.parseInt(bookingDate[0]);
                    int month = Integer.parseInt(bookingDate[1]);
                    int year = Integer.parseInt(bookingDate[2]);

                    if (year == currentDate.getYear()) {
                        if (month == currentDate.getMonthValue()) {
                            if (day >= currentDate.getDayOfMonth()) {
                                addFlaggedBooking(bookings);
                            }
                        }
                    }
                }
            }

            bookings.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Inserts a booking from the BOOKINGLIST table into the FLAGGEDBOOKINGS table.
    *Copies the data from the corresponding columns of the BOOKINGLIST table to the FLAGGEDBOOKINGS table.
    */
    private void addFlaggedBooking(ResultSet booking) {
        try {
            String query = "INSERT INTO FLAGGEDBOOKINGS (BOOKINGDATE, BOOKINGLEAVE, FIRSTNAME, SURNAME, ROOMTYPE, STUDENTDISCOUNT, "
                    + "CHILDDISCOUNT, COST, PHONENUMBER, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, booking.getString("BOOKINGDATE"));
                statement.setString(2, booking.getString("BOOKINGLEAVE"));
                statement.setString(3, booking.getString("FIRSTNAME"));
                statement.setString(4, booking.getString("SURNAME"));
                statement.setString(5, booking.getString("ROOMTYPE"));
                statement.setBoolean(6, booking.getBoolean("STUDENTDISCOUNT"));
                statement.setBoolean(7, booking.getBoolean("CHILDDISCOUNT"));
                statement.setDouble(8, booking.getDouble("COST"));
                statement.setString(9, booking.getString("PHONENUMBER"));
                statement.setString(10, booking.getString("EMAIL"));

                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Retrieves the questions and answers from the FAQ table in the database.
    *Populates the faqMap with the retrieved data, where the question is the key and the answer is the value.
    */
    public void getQuestionsAndAnswers() {
        faqMap = new HashMap<>();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT QUESTION, ANSWER FROM FAQ");

            while (resultSet.next()) {
                String question = resultSet.getString("QUESTION");
                String answer = resultSet.getString("ANSWER");
                faqMap.put(question, answer);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Retrieves a map of similar questions and their corresponding answers
     * based on the user's question.
     */
    public Map<String, String> getAnswerForQuestion(String question) {
        Map<String, String> similarQ = new HashMap();

        String[] compareQ = question.split(" ");
        int count = 0;
        for (Map.Entry<String, String> entry : faqMap.entrySet()) {
            String[] holder = entry.getKey().split(" ");
            for (String main : holder) {
                for (String target : compareQ) {
                    if (target.equalsIgnoreCase(main)) {
                        count++;
                        break;
                    }
                }
            }
            double percentage = (double) count;
            double compatibility = (((double) compareQ.length + (double) holder.length)) * 0.25;
            if (percentage >= compatibility) {
                similarQ.put(entry.getKey(), entry.getValue());
                count = 0;
            }
            
        }

        return similarQ;
    }
}
