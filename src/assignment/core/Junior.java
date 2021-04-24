package assignment.core;

import java.io.Serializable;
import java.util.Date;

/**
 * Junior Class Declaration
 * */
public class Junior extends Staff implements Serializable {
    private int monthlySalary;
    private Date expectedEndDate;

    /**Construct a default Junior object*/
    public Junior(Date startDate, int monthlySalary, Date expectedEndDate) {
        super(startDate);
        this.monthlySalary = monthlySalary;
        this.expectedEndDate = expectedEndDate;
    }
    /**Construct a Senior object with specified name , gender, date of birth values
     * ID number auto increments and set to that value
     * @param name name of customer
     * @param gender gender of customer
     * @param dateOfBirth Date of birth
     * @param startDate Starting date of senior
     * @param monthlySalary MonthlySalary
     * @param expectedEndDate expected ending date  */
    public Junior(String name, char gender, Date dateOfBirth, Date startDate, int monthlySalary, Date expectedEndDate) {
        super(name, gender, dateOfBirth, startDate);
        this.monthlySalary = monthlySalary;
        this.expectedEndDate = expectedEndDate;
    }

    @Override
    public int getSalary() {
        return monthlySalary;
    }
}
