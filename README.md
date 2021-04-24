# ResManApp-Database-MySql-Connection

#Aims

This project has two aims: (1) to learn how to connect a Java application to a 
backend database; (2) to learn how to use part of the object serialization and Java 
Security API. We will connect it to a backend database 
and also use MD5 algorithm to do security checks. 


#Object Serialization and Security

When the user wants to close the application, besides storing the data to a backend 
database, application need to also serialize customer objects into an external file. This 
will be used to check if somebody is trying to attack Customer data while the 
application is not running. This will do this as follows: when user closes the application,
application will make Customer objects persistent to a file, generate an MD5 for that file 
and write it into another external file. When the application is loaded again, application will 
read regenerate the MD5 for the serialized objects in external file and check if it 
is the same with the MD5 that you stored when the application was closed. If they are 
the same, that means the serialized objects are not modified, if they are not then application 
will need to warn the user that the data has been updated.


# Requirements and Explanations of Methods

The overall requirements are based on this class diagram, which is also summarised
below:
• The main application called ResManApp will be used to maintain information
about staff and customers. ResManApp will also have the main method and will
provide the overall interaction with the application. Therefore, this class should
include the main method where an instance of this class is constructed and the
menu of commands is displayed to the user. The required methods are as follows. 

o menu(): This method will display the interaction menu to the user;

o addStaff(): This method will add new staff to the list of Staff maintained;

o deleteStaff(): This method will be used to delete a staff.

o listStaffDetails(): This method will display the details of a staff (In the
previous assignment, this was referred as getStaffDetails).

o addCustomer(): This method will add a customer.

o deleteCustomer(): This method will delete a customer.

o addBooking(): This method will receive the details of a customer and
create a booking for that customer. The method needs to also get the
relevant booking details.

o listCustomerDetails(): This method will display a customer details (In
the previous assignment, this was called getCustomerDetails).

o displayCustomerLastBooking(): This method will display the most
recent booking done by the customer.

o listCustomerOrders(): This method will display the orders made by a
particular customer (In the previous assignment, this was referred as
getCustomerOrder).

o listStaff(): This method will list all the staff.

o listCustomer(): This method will list all the customer.

o exit(): This method should terminate the program.

o addOrder(): This method will get the details of a customer and an order,
and will create an order for that customer. In this case, the order type
has to be specified, if it is online then an online order should be created.
If it is being done within the restaurant, then it should be an
InRestrOrder.

o listAllSaffSalary(): This method will display the salary details of all
staff in the application. Depending on whether the staff is junior or
senior, the salary calculation will be done via getSalary() method
specified in the interface as follows:
§ If the staff is a seniorthen the monthly salary is calculated as
follows: for every year who has been a staff (currentDateStartDate to find the number of years) who gets %10 increment
on the grossSalaryYearly. This will be divided by 12. For
example, if the employee is working for 2 years and the
grossSalaryYearly is 12000, then he will have a salary of 1200 per month. This is because he received 1200 for the first year
and 1200 for the second year as increments.
§ If the Staff is a junior, then the monthlySalary value will be
displayed.

o listAllOrder(): This method will display all online and in restaurant
orders that have been made. This will display all the orders made within
the rest. and their associated bookings (if it exists). Please note that an
in restaurant order can be made without a booking.

o addOrderOfBooking(): This method will get the details of a customer
and a booking, and will create an order for that customer and booking.
Payment interface has a method called “processPayment()”. Since in this
a gui-project, we are not actually going to process payments, it just need to
implement it in a simple way to display a message on the screen.


# UML-Diagram

![alt text](https://i.imgur.com/W6VMU6T.png)
