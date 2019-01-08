import java.util.Scanner;

/**
 * @author Thomas L Jessop
 * @since 2018-10-26
 * @version 1.2
 * @param degress holds the degress of the Temperature objects
 * @param type this holds a C or F for indentifing Fahrenheit or Celsius 
 * @param userInput scanner used by the readInput method  
 * 
 */

public class Temperature{
    double degrees;
    char type ;

    //used by the readInput method
    Scanner userInput = new Scanner(System.in);

    /**
     * Constructor that takes degress and type
     * @param degreesp
     * @param typep
     */
    Temperature( double degreesp, char typep ){
        degrees = degreesp;
        type = typep;

    }//Constructor that takes degress and type

    /**
     * Constructor that takes degress
     * @param degreesp
     */
    Temperature( double degreesp ){
        degrees = degreesp;
         type = 'C';

    }//Constructor that takes degress

    /**
     * Constructor that takes type
     * @param typep
     */
    Temperature( char typep ){
         degrees = 0.0;
        type = typep;

    }//Constructor that takes type

    /**
     * Constructor takes takes no arguments
     */
    Temperature(){
         degrees = 0;
         type = 'C';
    }//Constructor with no arguments

    /**
     * Writes the degrees and type to standard output
     * @param outString concats values for output
     */
    public void writeOutput(){
        String outString = this.degrees +" "+ this.type;
        System.out.println(outString);
    }//writeOutput

      /**
     * Writes the degrees to standard output in celsius
     * @param outString concats values for output
     */
    public void  writeC(){
        if (this.type == 'C' || this.type == 'c'){
            String outString =degrees +" " +this.type;
            System.out.println(outString);
        }//if c or C
         else{
            String  outString =  Math.round(((degrees-32)* 5/9 ) *10)/10.0 +" " +'C';
            System.out.println(outString );
            }// else c or C
    }//writeC

      /**
     * Writes the degrees to standard output in fahrenheit
     * @param outString concats values for output
     */
    public void writeF(){
        if (this.type == 'F' || this.type == 'f'){
            String outString =degrees +" " +this.type;
            System.out.println(outString);
        }// if F or f
        else{
            String  outString =  Math.round(((degrees*9/5)+32 ) *10)/10.0 +" " +'F';
            System.out.println(outString );
            }// else f or F
    }//writeF
    
      /**
     * Writes the degrees to output string in celsius
     * @param outString concats values for output
     */
    public String getC(){
        String temp;
        if( type == 'c' || type == 'C'){
            temp=degrees +" " +"C";
            return temp;
        } //if c or C
            else {
                temp=Math.round(((degrees-32)* 5/9 ) *10)/10.0 +" "+ "C";
                return temp;
            }// else c or C
    }//getC

      /**
     * Writes the degrees to output string in fahrenheit
     * @param outString concats values for output
     */
    public String getF(){
        String temp;
        if( type == 'F' || type == 'f'){
            temp=degrees +" "+ "F";
            return temp;
        } // if F or f
            else {
                temp=Math.round(((degrees*9/5) +32)) +" " +"F";
                return temp;
            }// else f or F
    }//getF

    /**
     * sets degress
     * @param degreesp in passed double that degrees is set to
     */
    public void set(double degreesp){
        this.degrees=degreesp;
    }//set degress

    /**
     * sets type
     * @param typep in passed char that type is set to
     */
    public void set(char typep){
        this.type=typep;
    }//set type

    /**
     * sets type and degess
     * @param degreesp in passed double that degrees is set to
     * @param typep in passed char that type is set to
     */
    public void set(double degreesp, char typep){
        this.type=typep;
        this.degrees=degreesp;

    }//set both values

    /**
     * Compairs two Temperature objects
     * 
     * @param theyAreEqual boolean flag
     * @param temp1 passed in Temperature object
     * @param workTemp Temperature object for type testing
     * @param workTemp2 Temperature object to prevent data mutation of the curent Temperature object
     * @param TOLERANCE
     * @return theyAreEqual
     */
    public boolean equals(Temperature temp1){
        //return flag
        boolean theyAreEqual;

        //used in compairing the two degrees
        final double TOLERANCE =0.00000001;
        
        //used to hold the the values of the original Temperature objects to prevent premature data mutation
        Temperature workTemp,workTemp2;

        if(temp1.type=='c'||temp1.type=='C'){
            workTemp=temp1;
        }//if c or C
            else{
            workTemp = new Temperature(((temp1.degrees -32) * 5/9), 'C');
            }// else c or C
        if (this.type=='c'||this.type=='C'){
            workTemp2 = new Temperature(this.degrees, this.type); 
        }//if this.type c or C
        else{
            workTemp2 = new Temperature(((temp1.degrees -32) * 5/9), 'C');
        }//else this.type c or C
      
            if(Math.abs( workTemp.degrees -  workTemp2.degrees)< TOLERANCE ){
                theyAreEqual =true;
            }//if equality test 
                else{
                theyAreEqual=false;
                }//else equality test 
        return theyAreEqual;
    }//equals

    /**
     * Presents the degress and type of the curent Temperature object as a string
     * @param tempString
     */
    public String toString(){
        String tempString = this.degrees + " " + this.type;
        return tempString;
    }//toString

    /**
     * reads userinput add sets degress and type baised on said userinput
     * @param parString used for catching and cutting out a char for setting type
     */
    public void readInput() {
        String parString;
        System.out.print("Please give degrees : ");
        this.degrees = userInput.nextDouble();

        System.out.println();
        System.out.println("Pease give type: ");
        parString = userInput.nextLine();
        parString = userInput.nextLine();

        // loop for check for too many characters
        while (parString.length()>1){
            System.out.println("Too many characters, please try again" );
            parString = userInput.nextLine();
        }//while parString length

        //loop for checking that the char in the 0 positon is either a f/F or c/C
        while (parString.charAt(0) != 'c' && parString.charAt(0) != 'C' && parString.charAt(0) != 'f' && parString.charAt(0) != 'F'){
            System.out.println("Invaid character choice, please try again" );
            parString = userInput.nextLine();
        }//while parString char at 0
        
        if (parString.charAt(0) == 'f') {
            this.type='F';
        }//if char at 0 f

        if (parString.charAt(0) == 'F') {
            this.type='F';
        }//if char at 0 F

        if (parString.charAt(0) == 'c'){
            this.type = 'C';
        }//if char at 0 c

        if (parString.charAt(0) == 'C'){
            this.type = 'C';
        }//if char at 0 C
    }//readInput    
}//class