package assignment.core;

import java.text.ParseException;
import java.util.*;

/**
 * @author Yusuf Gökberk Keptiğ
 * @version 4.0
 * */


public class Main {
    static PopulateData populateData;         //Creates populateData object

    static {
        try {
            populateData = new PopulateData();         //Populates Data
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    static DataStorage db = new DataStorage();
    static ArrayList<Staff> staffList = populateData.getStaffList();  //Makes staff list which gets list from data we populated
    //static ArrayList<Customer> customerList = populateData.getCustomerList();  //Makes staff list which gets list from data we populated
    static ArrayList<Customer> customerList = new ArrayList<>();  //Makes staff list which gets list from data we populated

    /**
     * This is the main class method.
     *
     * @param args String[] args
     */
    public static void main(String[] args) {
        db.readData(); //Read data from db
        guiTool myFrame = new guiTool();
        myFrame.check(); //MD5 check
    }
}