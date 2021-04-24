package assignment.support;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Person Class Declaration
 * */
public abstract class Person implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int ID;
    private String name;
    private char gender;
    private Date dateOfBirth;

    /**Construct a default Customer object*/
    public Person() {
        this.ID = count.incrementAndGet();
        this.name = "noName";
        this.gender = 'U';
        this.dateOfBirth = new Date();
    }
    /**Construct a Person object with specified name , gender, date of birth values
     * ID number auto increments and set to that value
     * @param name name of customer
     * @param gender gender of customer
     * @param dateOfBirth Date of birth*/
    public Person( String name, char gender, Date dateOfBirth) {
        this.ID = count.incrementAndGet();
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    public Person(int ID, String name, char gender, Date dateOfBirth) {
        count.incrementAndGet();
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    /**Get id of Person
     * @return id of Person */
    public int getID() {
        return ID;
    }

    /**Get name of Person
     * @return name of Person */
    public String getName() {
        return name;
    }
    /**Set a new name
     * @param name name of person*/
    public void setName(String name) {
        this.name = name;
    }
    /**Get gender of Person
     * @return gender of Person */
    public char getGender() {
        return gender;
    }
    /**Set a new gender
     * @param gender gender of person*/
    public void setGender(char gender) {
        this.gender = gender;
    }
    /**Get date of birth of Person
     * @return birth date of Person */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**Set Date of Birth of staff
     * @param dateOfBirth Date of birth */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
