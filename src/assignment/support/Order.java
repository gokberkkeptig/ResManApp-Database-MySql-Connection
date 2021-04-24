package assignment.support;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Order Class Declaration
 * */
public abstract class Order implements Payment, Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int orderID;
    private Date OrderDate;
    private String OrderDetails;
    private String ExtraNotes;

    /**Construct a default Order object*/
    public Order() {
        this.orderID = count.incrementAndGet();
        this.OrderDate = new Date();
        this.OrderDetails = "noDetails";
        this.ExtraNotes = "noNotes";
    }

    /**Construct a Order object with specified details and description value
     * orderID id of Order auto increments and set that value
     * @param orderDate  date of the order
     * @param orderDetails details of the order
     * @param extraNotes extra notes of the order */
    public Order( Date orderDate, String orderDetails, String extraNotes) {
        this.orderID = count.incrementAndGet();
        this.OrderDate = orderDate;
        this.OrderDetails = orderDetails;
        this.ExtraNotes = extraNotes;
    }
    /**Get a new id
     * @return orderID id of the order */
    public int getOrderID() {
        return orderID;
    }

    /**Set a new order date
     * @return orderDate date of the order */
    public Date getOrderDate() {
        return OrderDate;
    }
    /**Set a new order date
     * @param orderDate date of the order */
    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }
    /**Get a new details
     * @return  orderDetails details of the order */
    public String getOrderDetails() {
        return OrderDetails;
    }
    /**Set a new details
     * @param orderDetails details of the order */
    public void setOrderDetails(String orderDetails) {
        OrderDetails = orderDetails;
    }
    /**get extra Notes
     * @return extra notes of orders */
    public String getExtraNotes() {
        return ExtraNotes;
    }
    /**Set a new extra notes
     * @param extraNotes extra notes of the order */
    public void setExtraNotes(String extraNotes) {
        ExtraNotes = extraNotes;
    }

    @Override
    public void processPayment() {
        System.out.println("Thank you for your payment. Your transaction is complete and you will receive a receipt by e-mail.");
    }
}
