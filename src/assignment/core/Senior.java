package assignment.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Senior Class Declaration
 * */
public class Senior extends Staff implements Serializable {
    private int grossSalaryYearly;
    private ArrayList<Junior>responsibleFrom;

    /**Construct a default Senior object*/
    public Senior(Date startDate, int grossSalaryYearly) {
        super(startDate);
        this.grossSalaryYearly = grossSalaryYearly;
        this.responsibleFrom = new ArrayList<Junior>();
    }
    /**Construct a Senior object with specified name , gender, date of birth values
     * ID number auto increments and set to that value
     * @param name name of customer
     * @param gender gender of customer
     * @param dateOfBirth Date of birth
     * @param startDate Starting date of senior
     * @param grossSalaryYearly Yearly Salary */
    public Senior(String name, char gender, Date dateOfBirth, Date startDate, int grossSalaryYearly) {
        super(name, gender, dateOfBirth, startDate);
        this.grossSalaryYearly = grossSalaryYearly;
        this.responsibleFrom = new ArrayList<Junior>();
    }
    /**Get gross salary of Senior
     * @return grossSalaryYearly of Senior */
    public int getGrossSalaryYearly() {
        return grossSalaryYearly;
    }
    /**Set gross salary of Senior */
    public void setGrossSalaryYearly(int grossSalaryYearly) {
        this.grossSalaryYearly = grossSalaryYearly;
    }
    /**Get resposibleFrom of Senior
     * @return resposibleFrom of Senior */
    public ArrayList<Junior> getResponsibleFrom() {
        return responsibleFrom;
    }
    /**Set resposible from Senior */
    public void setResponsibleFrom(ArrayList<Junior> responsibleFrom) {
        this.responsibleFrom = responsibleFrom;
    }
    /**get Salary method calculates Senior's monthly salary according to their years of working
     * */
    @Override
    public int getSalary() {
        Date currentDate = new Date();
        int monthlySalary;
        long difference = currentDate.getTime() - getStartDate().getTime();
        long yearsOfWorking = difference/(1000l * 60 * 60 * 24 * 365);
        System.out.println(" Years of Working:"+(int)yearsOfWorking);
        if(yearsOfWorking > 0){
            monthlySalary = (grossSalaryYearly + (grossSalaryYearly / 10 * (int)(yearsOfWorking))/12);
        }
        else{
            monthlySalary = grossSalaryYearly/12;
        }
        return monthlySalary;

    }
}
