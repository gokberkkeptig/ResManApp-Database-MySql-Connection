package assignment.core;

import assignment.support.Order;

import java.io.Serializable;
import java.util.Date;

/**
 * InRestrOrde Class Declaration
 * */
public class InRestrOrder extends Order implements Serializable {
    private int tableNumber;
    private Booking bookingOrder;

    /**Construct a default InRestOrder object*/
    public InRestrOrder(int tableNumber) {
        this.tableNumber = tableNumber;
        this.bookingOrder = new Booking();
    }
    /**Construct a default InRestOrder object with given values
     * @param orderDate date of in restaurant order
     * @param orderDetails details of birth of in restaurant order
     * @param extraNotes extra notes of in restaurant order
     * @param tableNumber table number of in restaurant order */
    public InRestrOrder(Date orderDate, String orderDetails, String extraNotes, int tableNumber) {
        super(orderDate, orderDetails, extraNotes);
        this.tableNumber = tableNumber;
        this.bookingOrder = new Booking();
    }
    /**Construct a default InRestOrder object with given values
     * @param bookingDate date of booking
     * @param orderDate date of in restaurant order
     * @param orderDetails details of birth of in restaurant order
     * @param extraNotes extra notes of in restaurant order
     * @param tableNumber table number of in restaurant order */
    public InRestrOrder(Date bookingDate,Date orderDate, String orderDetails, String extraNotes, int tableNumber) {
        super(orderDate, orderDetails, extraNotes);
        this.tableNumber = tableNumber;
        this.bookingOrder = new Booking(bookingDate);
    }
    /**get table number
     * @return tableNumber*/
    public int getTableNumber() {
        return tableNumber;
    }
    /**set table number with given table number*/
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    /**get booking of the order
     * @see Booking
     * @return bookingOrder*/
    public Booking getBookingOrder() {
        return bookingOrder;
    }
    /**set Booking order with given booking*/
    public void setBookingOrder(Booking bookingOrder) {
        this.bookingOrder = bookingOrder;
    }

}
