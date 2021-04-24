package assignment.core;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**This is PopulateDate Class*/
public class PopulateData {
    private ArrayList<Staff> staffList = new ArrayList<>();
    private ArrayList<Customer> customerList = new ArrayList<>();

    /**Construct a default populate data object
     * @exception ParseException parsing error
     */
    public PopulateData() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        staffList.add(new Senior("Micheal Scott",'M',dateFormat.parse("5/1/1990"),dateFormat.parse("1/1/2019"),12000));
        staffList.add(new Senior("Jim Halpert",'M',dateFormat.parse("1/10/1992"),dateFormat.parse("1/10/2016"),15000));
        staffList.add(new Senior("Dwight Schrute",'M',dateFormat.parse("15/2/1985"),dateFormat.parse("12/1/2014"),10000));
        staffList.add(new Junior("Jack Jones",'M',dateFormat.parse("15/2/1990"),dateFormat.parse("12/10/2020"),7000,dateFormat.parse("22/1/2020")));
        staffList.add(new Junior("Wanda Burgess",'F',dateFormat.parse("15/2/1985"),dateFormat.parse("20/11/2013"),5000,dateFormat.parse("15/10/2020")));
        staffList.add(new Junior("Phil Jones",'M',dateFormat.parse("15/2/1999"),dateFormat.parse("10/5/2012"),6000,dateFormat.parse("12/12/2020")));
        customerList.add(new Customer("Ryan Howard",'M',dateFormat.parse("5/6/1995"),dateFormat.parse("7/7/2005"),"12346798"));
        customerList.add(new Customer("Kelly Kapoor",'F',dateFormat.parse("5/6/1994"),dateFormat.parse("7/7/2005"),"12346798"));
        customerList.add(new Customer("Angela Martin",'F',dateFormat.parse("5/6/1988"),dateFormat.parse("7/7/2005"),"12346798"));
        customerList.get(0).makeBooking(dateFormat.parse("11/9/2018"));
        customerList.get(1).makeBooking(dateFormat.parse("21/7/2020"));
        customerList.get(2).makeBooking(dateFormat.parse("11/1/2019"));
        customerList.get(0).getBookings().get(0).makeResOrder(dateFormat.parse("15/6/2009"),"Salad With Chicken Strips","Salad",1);
        customerList.get(1).getBookings().get(0).makeResOrder(dateFormat.parse("25/3/2019"),"Deluxe Burger","Iceberg Lettuce,Cheese and Patty",2);
        customerList.get(2).getBookings().get(0).makeResOrder(dateFormat.parse("5/11/2020"),"Fresh Lime","Soda",10);

    }
    /**Get customer List
     * @return customer list */
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    /**Set customer list
     * @param customerList takes a customer list */
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    /**Get Staff List
     * @return staff list */
    public ArrayList<Staff> getStaffList() {
        return staffList;
    }
    /**Set Staff list
     * @param listStaff takes a staff list*/
    public void setStaffList(ArrayList<Staff> listStaff) {
        staffList = listStaff;
    }
}