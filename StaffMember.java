/*
    ******************************* My changes were***************************************************************************************
    1. adding the STANDARD_VACATION constant for hold the base number of vaction days
    2. added the abstract Vacaction method to be implemented by the volunteer, Employee, Hourly, and Executive classes
    3. Took out the pay method and put it into the Payable interface, which is implemented by this class
    4. over rode the compareTo method and thus implemented the Comparable interface

    ************************************************************Important***********************************************************************************
    I Thomas Jessop only modifed this code and clam no ownership or credit for the orginal state of this program and only added documention to my edits
********************************************************************************************************************************************************
*@param  STANDARD_VACATION constant for hold the base number of vaction days

**/

//********************************************************************
//  StaffMember.java       Author: Lewis/Loftus
//
//  Represents a generic staff member.
//********************************************************************

abstract public class StaffMember implements Payable, Comparable<StaffMember> 
{
    protected String name;
    protected String address;
    protected String phone;
    //STANDARD_VACATION constant for hold the base number of vaction days
    protected final int STANDARD_VACATION = 14;

    //-----------------------------------------------------------------
    //  Constructor: Sets up this staff member using the specified
    //  information.
    //-----------------------------------------------------------------
    public StaffMember(String eName, String eAddress, String ePhone)
    {
        name = eName;
        address = eAddress;
        phone = ePhone;
    }

    //-----------------------------------------------------------------
    //  Returns a string including the basic employee information.
    //-----------------------------------------------------------------
    public String toString()
    {
        String result = "Name: " + name + "\n";

        result += "Address: " + address + "\n";
        result += "Phone: " + phone;

        return result;
    }

    /**
     * Vacaction method to be implemented by the Volunteer, Employee, Hourly, and Executive classes
     * @return int
     */
    public abstract int vacation();
    
    /**
     * Compares staffmembers for sorting on the base of camparing their names
     * 
     *@param nameC1 the name of this employee
     *@param nameC2 the name of the employee that is being compared to the curent employee
     *@param score intger used for holding the result of the string comparion of the employee names
     *@return score
     */
    public  int compareTo(StaffMember emp1){
        
        String nameC1 = this.name;
        String nameC2 = emp1.name;
        int score=nameC1.compareTo(nameC2);
        return score;
    }

   
    
 }
