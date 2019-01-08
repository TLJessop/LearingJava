/*
    ******************************* The only change I needed to make to this file was adding the vacaction method****************************************
************************************************************Important***********************************************************************************
    I Thomas Jessop only modifed this code and clam no ownership or credit for the orginal state of this program and only added documention to my edits
********************************************************************************************************************************************************
*/

//********************************************************************
//  Volunteer.java       Author: Lewis/Loftus
//
//  Represents a staff member that works as a volunteer.
//********************************************************************

public class Volunteer extends StaffMember
{
    //-----------------------------------------------------------------
    //  Constructor: Sets up this volunteer using the specified
    //  information.
    //-----------------------------------------------------------------
    public Volunteer(String eName, String eAddress, String ePhone)
    {
        super(eName, eAddress, ePhone);
    }

    //-----------------------------------------------------------------
    //  Returns a zero pay value for this volunteer.
    //-----------------------------------------------------------------
    public double pay()
    {
        return 0.0;
    }

    /**
     * Returns a 0 because Volunters are not awarded vacation time
     * @return int
     */
    public int vacation(){
        return 0;
    }

}
