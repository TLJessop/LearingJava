//********************************************************************
//  Die.java       Author: Lewis/Loftus
//
//  Represents one die (singular of dice) with faces showing values
//  between 1 and 6.
//********************************************************************

/* As intructed in the assiment layed out in Canvas I am using the book class as a parent class for my PairofDice class. 
This unlike the other two classes subminited as part of the assignment is I clam no ownship of or credit due.
*/
public class Die
{
    private final int MAX = 6;  // maximum face value

    private int faceValue;  // current value showing on the die

    //-----------------------------------------------------------------
    //  Constructor: Sets the initial face value.
    //-----------------------------------------------------------------
    public Die()
    {
        faceValue = 1;
    }

    //-----------------------------------------------------------------
    //  Rolls the die and returns the result.
    //-----------------------------------------------------------------
    public int roll()
    {
        faceValue = (int)(Math.random() * MAX) + 1;

        return faceValue;
    }

    //-----------------------------------------------------------------
    //  Face value mutator.
    //-----------------------------------------------------------------
    public void setFaceValue(int value)
    {
        faceValue = value;
    }

    //-----------------------------------------------------------------
    //  Face value accessor.
    //-----------------------------------------------------------------
    public int getFaceValue()
    {
        return faceValue;
    }

    //-----------------------------------------------------------------
    //  Returns a string representation of this die.
    //-----------------------------------------------------------------
    public String toString()
    {
        String result = Integer.toString(faceValue);

        return result;
    }
}