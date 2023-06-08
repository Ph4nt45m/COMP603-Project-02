/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author snipi
 */
public final class DBManager {

    private final String USER_NAME = "MAH";
    private final String PASSWORD = "MAH";
    private final String projectFolderPath;
    private final String databaseFolderPath;
    private ArrayList<Booking> bookingsList;
    private boolean bookingSuccessful;
    private LocalDate currentDate;

    Connection conn;

    public DBManager() {
        this.projectFolderPath = System.getProperty("user.dir");
        this.databaseFolderPath = "jdbc:derby:" + this.projectFolderPath + "/MarlAvenueHotelDB;create = true";
        this.bookingsList = new ArrayList<>();
        this.bookingSuccessful = false;
        this.currentDate = LocalDate.now();

        establishConnection();
//        readBookingsList();
        flagBookings();
    }

    public Connection getConnection() {
        return this.conn;
    }

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

    private void readBookingsList() {
        try {
            Statement statement = conn.createStatement();
            ResultSet booking = statement.executeQuery("SELECT * FROM BOOKINGLIST");

            while (booking.next()) {
                String[] bookingDate = booking.getString("BOOKINGDATE").split("/");
                int dayBook = Integer.parseInt(bookingDate[0]);
                int monthBook = Integer.parseInt(bookingDate[1]);
                int yearBook = Integer.parseInt(bookingDate[2]);
                Date dateBook = new Date(dayBook, monthBook, yearBook);
                
                String[] bookingLeave = booking.getString("BOOKINGDLEAVE").split("/");
                int dayLeave = Integer.parseInt(bookingLeave[0]);
                int monthLeave = Integer.parseInt(bookingLeave[1]);
                int yearLeave = Integer.parseInt(bookingLeave[2]);
                Date dateLeave = new Date(dayLeave, monthLeave, yearLeave);
                
                String firstName = booking.getString("FIRSTNAME");
                String surname = booking.getString("SURNAME");
                String roomType = booking.getString("ROOMTYPE");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isBSuccessful() {
        return this.bookingSuccessful;
    }

    public void resetBSuccessful() {
        this.bookingSuccessful = false;
    }

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

    public Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> faqMap = new HashMap<>();

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

        return faqMap;
    }
}
