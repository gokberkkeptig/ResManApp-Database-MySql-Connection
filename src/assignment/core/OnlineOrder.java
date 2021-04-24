package assignment.core;

import assignment.support.Order;

import java.io.Serializable;
import java.util.Date;

/**
 * OnlineOrder Class Declaration
 * */
public class OnlineOrder extends Order implements Serializable {
    private String paymentType;
    private Junior deliveredBy;

    /**Construct a default OnlineOrder object*/
    public OnlineOrder(String paymentType, Junior deliveredBy) {
        this.paymentType = paymentType;
        this.deliveredBy = deliveredBy;
    }
    /**Construct a default OnlineOrder object with given values
     * @param orderDate order date of online order
     * @param orderDetails order details of online order
     * @param extraNotes extra notes of online order
     * @param paymentType paymentType
     * @param deliveredBy Junior that will delivered online order
    */
    public OnlineOrder(Date orderDate, String orderDetails, String extraNotes, String paymentType, Junior deliveredBy) {
        super(orderDate, orderDetails, extraNotes);
        this.paymentType = paymentType;
        this.deliveredBy = deliveredBy;
    }
    /**gets payment type
     * @return paymentType*/
    public String getPaymentType() {
        return paymentType;
    }
    /**Sets payment type with given paymentType*/
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    /** gets delivered by Junior
     * @return deliveredBy*/
    public Junior getDeliveredBy() {
        return deliveredBy;
    }
    /**sets deliveredBy with given Junior*/
    public void setDeliveredBy(Junior deliveredBy) {
        this.deliveredBy = deliveredBy;
    }
}
