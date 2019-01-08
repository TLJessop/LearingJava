/*
    ******************************* My changes were***************************************************************************************
    1. adding the vacationDays intger instance data field to hold the number of vacation days
    2. added the vacation method
************************************************************Important***********************************************************************************
    I Thomas Jessop only modifed this code and clam no ownership or credit for the orginal state of this program and only added documention to my edits
********************************************************************************************************************************************************

*@vacationDays intger instance data field to hold the number of vacation days

**/


//********************************************************************
//  Employee.java       Author: Lewis/Loftus
//
//  Represents a general paid employee.
//********************************************************************

public class Employee extends StaffMember implements Payable
{
    protected String socialSecurityNumber;
    protected double payRate;
    //Used to hold the employee's number of vacation days
    protected int vacationDays = super.STANDARD_VACATION;

    //-----------------------------------------------------------------
    //  Constructor: Sets up this employee with the specified
    //  information.
    //-----------------------------------------------------------------
    public Employee(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate)
    {
        super(eName, eAddress, ePhone);

        socialSecurityNumber = socSecNumber;
        payRate = rate;
    }

    //-----------------------------------------------------------------
    //  Returns information about an employee as a string.
    //-----------------------------------------------------------------
    public String toString()
    {
        String result = super.toString();

        result += "\nSocial Security Number: " + socialSecurityNumber;

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns the pay rate for this employee.
    //-----------------------------------------------------------------
    public double pay()
    {
        return payRate;
    }
    /**
     * Return the number of vacation days
     * @param vacationDays instance varible the holds the employee's number of vacation days.
     * @return vacationDays
     */
    public int vacation(){
        return vacationDays;
    }
  
}
