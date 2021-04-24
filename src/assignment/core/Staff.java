package assignment.core;

import assignment.support.Employee;
import assignment.support.Person;

import java.io.Serializable;
import java.util.Date;

/**
 * Staff Class Declaration
 * */
public class Staff extends Person implements Employee, Serializable {
    private Date startDate;

    /**Construct a default Staff object*/
    public Staff(Date startDate) {
        super();
        this.startDate = startDate;
    }
    /**Construct a default Staff object with given values
     * @param name name of staff
     * @param dateOfBirth date of birth of staff
     * @param gender gender of staff
     * @param startDate starting date of staff*/
    public Staff( String name, char gender, Date dateOfBirth, Date startDate) {
        super( name, gender, dateOfBirth);
        this.startDate = startDate;
    }

    /**Get start date
     * @return start date*/
    public Date getStartDate() {
        return startDate;
    }
    /**set start date with given start date
     * @param startDate starting date*/
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public int getSalary() {
        return 0;
    }


}
