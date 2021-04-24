package assignment.core;

import assignment.support.Order;
import assignment.support.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Customer Class Declaration
 * */
public class Customer extends Person implements Serializable {
    private Date registrationDate;
    private ArrayList<Order> orders;
    private String creditDetails;
    private ArrayList<Booking> bookings;

    public Customer(Date registrationDate, String creditDetails) {
        this.registrationDate = registrationDate;
        this.orders = new ArrayList<Order>();
        this.creditDetails = creditDetails;
        this.bookings = new ArrayList<Booking>();
    }

    public Customer(String name, char gender, Date dateOfBirth, Date registrationDate, String creditDetails) {
        super(name, gender, dateOfBirth);
        this.registrationDate = registrationDate;
        this.orders = new ArrayList<Order>();
        this.creditDetails = creditDetails;
        this.bookings = new ArrayList<Booking>();
    }

    public Customer(int ID,String name, char gender, Date dateOfBirth, Date registrationDate, String creditDetails) {
        super(ID,name, gender, dateOfBirth);
        this.registrationDate = registrationDate;
        this.orders = new ArrayList<Order>();
        this.creditDetails = creditDetails;
        this.bookings = new ArrayList<Booking>();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getCreditDetails() {
        return creditDetails;
    }

    public void setCreditDetails(String creditDetails) {
        this.creditDetails = creditDetails;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public void makeBooking(Date bookingDate){
        this.bookings.add(new Booking(bookingDate));
    }
    public void makeBooking(int bookID,Date bookingDate){
        this.bookings.add(new Booking(bookID,bookingDate));
    }
    public void makeOrder(Date orderDate, String orderDetails, String extraNotes, String paymentType, Junior deliveredBy){
        this.orders.add(new OnlineOrder(orderDate,orderDetails,extraNotes,paymentType,deliveredBy));
    }
    public void makeOrder(Date bookingDate,Date orderDate, String orderDetails, String extraNotes, int tableNumber){
        this.orders.add(new InRestrOrder(bookingDate, orderDate,orderDetails,extraNotes,tableNumber));
    }
}
