/*
    ******************************* My changes were***************************************************************************************
    1. adding a zero the Executive constructor call for Sam to match with the new extraVacationDays added to the Executive constructor
    2. added the sort method, which sorts the staffList by name into decending alphabetic order
    3. added a call to vacation in the payday method and printed the result to the screen
************************************************************Important***********************************************************************************
    I Thomas Jessop only modifed this code and clam no ownership or credit for the orginal state of this program and only added documention to my edits
********************************************************************************************************************************************************
**/

//********************************************************************
//  Staff.java       Author: Lewis/Loftus
//
//  Represents the personnel staff of a particular business.
//********************************************************************

public class Staff
{
    private StaffMember[] staffList;

    //-----------------------------------------------------------------
    //  Constructor: Sets up the list of staff members.
    //-----------------------------------------------------------------
    public Staff()
    {
        staffList = new StaffMember[6];

        staffList[0] = new Executive("Sam", "123 Main Line",
                "555-0469", "123-45-6789", 2423.07, 0);

        staffList[1] = new Employee("Carla", "456 Off Line",
                "555-0101", "987-65-4321", 1246.15);
        staffList[2] = new Employee("Woody", "789 Off Rocker",
                "555-0000", "010-20-3040", 1169.23);

        staffList[3] = new Hourly("Diane", "678 Fifth Ave.",
                "555-0690", "958-47-3625", 10.55);

        staffList[4] = new Volunteer("Norm", "987 Suds Blvd.",
                "555-8374");
        staffList[5] = new Volunteer("Cliff", "321 Duds Lane",
                "555-7282");

        ((Executive)staffList[0]).awardBonus(500.00);

        ((Hourly)staffList[3]).addHours(40);
    }

    //-----------------------------------------------------------------
    //  Pays all staff members.
    //-----------------------------------------------------------------
    public void payday ()
    {
        double amount;

        for (int count=0; count < staffList.length; count++)
        {
            System.out.println(staffList[count]);

            amount = staffList[count].pay();  // polymorphic

            if (amount == 0.0)
                System.out.println("Thanks!");
            else
                System.out.println("Paid: " + amount);
            
            System.out.println("Vacation days: " + staffList[count].vacation());

            System.out.println("-----------------------------------");
        }
    }
    /**
     * Instantiates a Sorting object and then using the new Sorting object staffList is sorted via selection sorting.
     * @param sorter the Sorting class object used to alphabetize
     * @return void
     */
    public void sort(){
        Sorting<StaffMember> sorter = new Sorting<StaffMember>();
        sorter.selectionSort(staffList);
    }
}//class
