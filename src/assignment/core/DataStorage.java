package assignment.core;

import assignment.support.Person;

import java.sql.*;
import java.util.Date;

/**
 * Data Storage class here
 * */

public class DataStorage extends Main {
    private Connection connection;
    private Statement statement;
    private static final String TABLE_PERSON = "hms.person";
    private static final String TABLE_CUSTOMER = "hms.customer";
    private static final String TABLE_BOOKING = "hms.booking";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DOB = "date_of_birth";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_CUSTOMER_ID = "customerID";
    private static final String COLUMN_BOOKING_CUSTOMER_ID = "customer_ID";
    private static final String COLUMN_CREDIT = "creditDetails";
    private static final String COLUMN_REG_DATE = "registration_date";
    private static final String COLUMN_BOOKING_ID = "bookingID";
    private static final String COLUMN_BOOKING_DATE = "booking_date";

    /**default constructor enables the data connection between program and mysql server
     * */
    DataStorage(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","cng443user","1234");
            System.out.println("Database connected!");
            statement = connection.createStatement();
        }catch(SQLException exception){
            System.out.println("Something went wrong!" + exception.getMessage());
        }
    }
    /**
     * readDate Method reads from database and makes some changes for customerList, bookingList for customer according to data that receives from database
     * @see Customer
     * @see Booking
     * */
    public void readData(){
        StringBuilder sb = new StringBuilder("SELECT * FROM person INNER JOIN customer ON  person.id = customer.customerID ");
        StringBuilder bb = new StringBuilder("SELECT * FROM customer INNER JOIN booking ON  customer.customerID = booking.customer_id ");
        try {
            ResultSet results = statement.executeQuery(String.valueOf(sb));
            while(results.next()){
                int ID = results.getInt(COLUMN_ID);
                String name = results.getString(COLUMN_NAME);
                long dob = results.getLong(COLUMN_DOB);
                char gender = results.getString(COLUMN_GENDER).charAt(0);
                String credit = results.getString(COLUMN_CREDIT);
                long reg =results.getLong(COLUMN_REG_DATE);
                System.out.println(name+"Date: "+new Date(dob));
                System.out.println(name+"Reg: "+new Date(reg));
                customerList.add(new Customer(ID,name,gender,new Date(dob),new Date(reg),credit));
                System.out.println("Loaded from Database");
            }
            ResultSet bookingResults = statement.executeQuery(String.valueOf(bb));
            while(bookingResults.next()){
                int ID = bookingResults.getInt(COLUMN_CUSTOMER_ID);
                int bookID = bookingResults.getInt("bookingID");
                long booking_date = results.getLong("booking_date");
                for (int i = 0; i < customerList.size(); i++) {
                    if(ID == customerList.get(i).getID()){
                        customerList.get(i).makeBooking(bookID,new Date(booking_date));
                        System.out.println("Loaded from Database");
                    }
                }
            }
        } catch (SQLException exception) {
            System.out.println("Query failed!"+exception.getMessage());
        }
    }

    /**
     * This method deletes customer from database and their details according to ID given by user
     * Their bookings will be deleted as well
     * */
    public void deleteData(int ID){
        try{
            String personDelete = "DELETE FROM person WHERE id = '"+ID+"' ";
            String customerDelete = "DELETE FROM customer WHERE customerID = '"+ID+"' ";
            String bookingDelete = "DELETE FROM booking WHERE customer_ID = '"+ID+"' ";
            PreparedStatement preparedCustomerStatement = connection.prepareStatement(customerDelete);
            PreparedStatement preparedPersonStatement = connection.prepareStatement(personDelete);
            PreparedStatement preparedBookingStatement = connection.prepareStatement(bookingDelete);
            preparedBookingStatement.executeUpdate();
            preparedCustomerStatement.executeUpdate();
            preparedPersonStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Query failed!"+e.getMessage());
        }
    }

    /**
     * This method writes data to database it saves the current data in app to database
     * */
    public void writeData(){
        try {
            String personInsert = "INSERT IGNORE INTO "+ TABLE_PERSON + " (" + COLUMN_ID+ ", " + COLUMN_NAME+ ", " + COLUMN_DOB+", "+COLUMN_GENDER+ " ) "+"VALUES(?, ?, ?, ?)";
            String customerInsert = "INSERT IGNORE INTO "+ TABLE_CUSTOMER + " (" + COLUMN_CUSTOMER_ID+ ", " + COLUMN_CREDIT+ ", " + COLUMN_REG_DATE+ " ) "+"VALUES(?, ?, ?)";
            String bookingInsert = "INSERT IGNORE INTO "+ TABLE_BOOKING + " (" + COLUMN_BOOKING_ID+ ", " + COLUMN_BOOKING_CUSTOMER_ID+ ", " + COLUMN_BOOKING_DATE+ " ) "+"VALUES(?, ?, ?)";
            PreparedStatement preparedPersonStatement = connection.prepareStatement(personInsert);
            PreparedStatement preparedCustomerStatement = connection.prepareStatement(customerInsert);
            PreparedStatement preparedBookingStatement = connection.prepareStatement(bookingInsert);
            for (int i = 0; i < customerList.size(); i++) {
                long date = customerList.get(i).getDateOfBirth().getTime();
                long regDate= customerList.get(i).getRegistrationDate().getTime();
                preparedPersonStatement.setInt(1, customerList.get(i).getID());
                preparedPersonStatement.setString(2, customerList.get(i).getName());
                preparedPersonStatement.setLong(3, date);
                preparedPersonStatement.setString(4, String.valueOf(customerList.get(i).getGender()));
                preparedPersonStatement.executeUpdate();
                preparedCustomerStatement.setInt(1, customerList.get(i).getID());
                preparedCustomerStatement.setString(2, customerList.get(i).getCreditDetails());
                preparedCustomerStatement.setLong(3, regDate);
                preparedCustomerStatement.executeUpdate();
                for (int j = 0; j < customerList.get(i).getBookings().size(); j++) {
                    long bookDate = customerList.get(i).getBookings().get(j).getBookingDate().getTime();
                    preparedBookingStatement.setInt(1,customerList.get(i).getBookings().get(j).getBookingID());
                    preparedBookingStatement.setInt(2,customerList.get(i).getID());
                    preparedBookingStatement.setLong(3,bookDate);
                    preparedBookingStatement.executeUpdate();
                }
                System.out.println("INSERT COMPLETED");
            }
            for (int i = 0; i < staffList.size(); i++) {
                long date = staffList.get(i).getDateOfBirth().getTime();
                preparedPersonStatement.setInt(1, staffList.get(i).getID());
                preparedPersonStatement.setString(2, staffList.get(i).getName());
                preparedPersonStatement.setLong(3, date);
                preparedPersonStatement.setString(4, String.valueOf(staffList.get(i).getGender()));
                preparedPersonStatement.executeUpdate();
                System.out.println("INSERT COMPLETED");
            }
         } catch (SQLException exception) {
            System.out.println("Query failed!"+exception.getMessage());
        }
    }
}
