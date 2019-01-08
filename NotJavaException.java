/**
 * This class is a user-defineded excption event made for JavaOrNot
 * @param errorFilename holds the name of the triggering file 
 * @author Thomas Jessop
 * @version 1.2
 * @since 2018-12-10
 */

public class NotJavaException extends Exception{

    //holds the name of the triggering file
    private String errorFilename;

    /**
     * Constuctor for the exception object
     * @param triggerFile stroes the name of the triggering file
     */
    public NotJavaException(String triggerFile){
        this.errorFilename = triggerFile;
    }//NotJavaException

    /**
     * Gets the stored value of the name of the triggering file
     * @return errorFilename
     */
    public String getErrorFile(){
        return this.errorFilename;
    }//getErrorFile
}// Class