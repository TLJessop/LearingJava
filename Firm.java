/*
    ******************************* The only change I needed to make to this file was adding a call to the new sort method****************************************
************************************************************Important***********************************************************************************
    I Thomas Jessop only modifed this code and clam no ownership or credit for the orginal state of this program and only added documention to my edits
********************************************************************************************************************************************************
**/

//********************************************************************
//  Firm.java       Author: Lewis/Loftus
//
//  Demonstrates polymorphism via inheritance.
//********************************************************************

public class Firm
{
    //-----------------------------------------------------------------
    //  Creates a staff of employees for a firm and pays them.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        Staff personnel = new Staff();
        //call for the new sort method
        personnel.sort();

        personnel.payday();
    }
}
