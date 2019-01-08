/**
 * This class extends the Die creating a pair of dice object that has two die child objects
 * @param die1 one of the two dice
 * @param die2 one of the two dice
 */

public class PairOfDice extends Die {
    private Die die1;
    private Die die2;

    /**
     * Constructor without arguments
     * I didn't like how the die constructor simpliy sets the die to one.
     * To me that seemed against the nature of dice, so my constructor immediately rolls the new dice. 
     * @param die1 one of the two dice
    * @param die2 one of the two dice
     */

    public PairOfDice(){
        die1 = new Die();
        die2 = new Die();
        
        die1.roll();
        die2.roll();
    }//PairOfDice

    /**
     * Overloaded constructor with arguments that sets die faces 
     * @param faceOne int for setting the face of die one
     * @param faceTwo int for setting the face of die two
     * @param die1 one of the two dice
    * @param die2 one of the two dice
     */

    public PairOfDice(int faceOne, int faceTwo){
        die1 = new Die();
        die2 = new Die();

        die1.setFaceValue(faceOne);
        die2.setFaceValue(faceTwo);
    }//PairOfDice

    /**
     * Represents the state of this object in a string form
     * 
     * @param returnString holds the state of the dice in string form with some wrapping text for easier readalbity
     * @return returnString
     */
    public String toString(){
        String returnString = "Die one is :" + die1.toString() + " Die two is :" + die2.toString();
        return returnString; 
    }//toString

    /**
     * Gets the facevalue of die 1
     * @param die1
     * @param faceOneGet hold value for return
     * @return faceOneGet
     */
    
    public int getDie1() {
        int faceOneGet = die1.getFaceValue();
        return faceOneGet;
    }//getDie1

    
    /**
     * Gets the facevalue of die 2
     * @param die2
     * @param faceTwoGet hold value for return
     * @return faceTwoGet
     */

    public int getDie2() {
        int faceTwoGet = die2.getFaceValue();
        return faceTwoGet;
    }

    /**
     * Setts the face of die 1
     * @param die1
     * @param faceOneSet argument passed for seting face of die 1
     * @return faceOneSet
     */

    public void setDie1(int faceOneSet){
        die1.setFaceValue(faceOneSet);
    }// setDie1

    /**
     * Setts the face of die 2
     * @param die2
     * @param faceTwoSet argument passed for seting face of die 2
     * @return faceTwoSet
     */

    public void setDie2(int faceTwoSet){
        die2.setFaceValue(faceTwoSet);
    }// setDice2

    /**
     * Adds the values of die1 and die2 storing the in the int sum for return
     * @param sum holds the result of die1 plus die2
      * @param die1 one of the two dice
    * @param die2 one of the two dice
     * @return sum
     */

    public int sumOfDice(){
        int sum = die1.getFaceValue() + die2.getFaceValue();
        return sum;
    }// sumOfDice

    /**
     * Rolls die1 and die2 and returns their sum
     * @param rollSum hold the result of the post-roll addistion of die1 and die2
     * @param die1 one of the two dice
    * @param die2 one of the two dice
     * @return rollSum
     */

    public int  rollDice(){
        die1.roll();
        die2.roll();
        int rollSum = die1.getFaceValue() + die2.getFaceValue();
        return rollSum;
    }

}