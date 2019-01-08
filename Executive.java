/*
    ******************************* My changes were***************************************************************************************
    1. adding extraVacation which is a instance data field holding the number of extra vacation days
    2. added the vacation method 
    3. added the setExtraVacation method with sets the number of extra vacation days
    4.  added the getExVacation method which gets the curent value of instance data field holding the number of extra vacation days

    p.s I know that the getter and setter methods were not asked for, but only make sence t be there
    ************************************************************Important***********************************************************************************
    I Thomas Jessop only modifed this code and clam no ownership or credit for the orginal state of this program and only added documention to my edits
********************************************************************************************************************************************************
*@param extraVacation holds their numvber if extra vacation days

**/


//********************************************************************
//  Executive.java       Author: Lewis/Loftus
//
//  Represents an executive staff member, who can earn a bonus.
//********************************************************************

public class Executive extends Employee
{
    private double bonus;

    //holds their numvber if extra vacation days
    private int extraVacation;

    //-----------------------------------------------------------------
    //  Constructor: Sets up this executive with the specified
    //  information.
    //-----------------------------------------------------------------
    public Executive(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate, int exVacation)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        //sets the number of extra vacation days
        this.extraVacation = exVacation;

        bonus = 0;  // bonus has yet to be awarded
    }

    //-----------------------------------------------------------------
    //  Awards the specified bonus to this executive.
    //-----------------------------------------------------------------
    public void awardBonus(double execBonus)
    {
        bonus = execBonus;
    }

    //-----------------------------------------------------------------
    //  Computes and returns the pay for an executive, which is the
    //  regular employee payment plus a one-time bonus.
    //-----------------------------------------------------------------
    public double pay()
    {
        double payment = super.pay() + bonus;

        bonus = 0;

        return payment;
    }

       /**
     * Returns the sum of vacationDays and extarVacation
     * @param vacationDays instance varible the holds the executive's number of standard vacation days.
     * @param extarVacation instance varible the holds the  executives number of extra vacation days.
     */
    public int vacation(){
        return (vacationDays + extraVacation);
    }

    /**
     * Setts the number of extra vacation days
     * @param extraDays passed in for setting extraVacation
     * @param extraVacation the instance data field holding the number of extra vacation days
     */
    public void setExtraVacation(int extraDays){
        this.extraVacation = extraDays;
    }

    /**
     * gets the curent value of instance data field holding the number of extra vacation days
     * @return extraVacation
     */
    public int getExVacation(){
        return this.extraVacation;
    } 

}
