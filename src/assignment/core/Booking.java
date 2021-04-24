package assignment.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Booking Class Declaration
 * */
public class Booking implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Date bookingDate;
    private int bookingID;
    private ArrayList<InRestrOrder> restrOrder;

    /**Construct a default Booking object*/
    public Booking() {
        this.bookingDate = new Date();
        this.bookingID = count.incrementAndGet();
        this.restrOrder = new ArrayList<>(1);
    }
    /**Construct a default Booking object with given values
     * @param bookingDate date of booking*/
    public Booking(Date bookingDate) {
        this.bookingDate = bookingDate;
        this.bookingID = count.incrementAndGet();
        this.restrOrder = new ArrayList<>(1);
    }
    /**Construct a default Booking object with given values
     * @param bookingDate date of booking*/
    public Booking(int bookingID,Date bookingDate) {
        count.incrementAndGet();
        this.bookingDate = bookingDate;
        this.bookingID = bookingID;
        this.restrOrder = new ArrayList<>(1);
    }
    /**gets booking date
     * @return bookingDate*/
    public Date getBookingDate() {
        return bookingDate;
    }
    /**Sets date of booking date*/
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    /**gets booking ID
     * @return bookingID*/
    public int getBookingID() {
        return bookingID;
    }
    /**returns InRestOrder arraylist
     * @return restOrder*/
    public ArrayList<InRestrOrder> getRestrOrder() {
        return restrOrder;
    }
    /**sets RestOrder wtih given InRestOrder arraylist*/
    public void setRestrOrder(ArrayList<InRestrOrder> restrOrder) {
        this.restrOrder = restrOrder;
    }
    /**makeResOrder method create a new in restaurant order with given values
     * @param orderDate
     * @param extraNotes
     * @param orderDetails
     * @param tableNumber */
    public void makeResOrder(Date orderDate, String orderDetails, String extraNotes, int tableNumber){
        this.restrOrder.add(new InRestrOrder(orderDate,orderDetails,extraNotes,tableNumber));
    }
}
