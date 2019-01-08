import java.io.*;
  /** 
   * Algorithm
   *    1. Create an array of file objects representing the files in the current directory
   *    2. Test if each file object is a standard file
   *    3. Make sure that the file name is more than 5 characters long
   *    4. Test if the names of files not ending with ".java"
   *    5. logs the names of files failing the step four test via a exception event to an external text file
   * 
   * @author Thomas Jessop
   * @version 1.2
   * @since 2018-12-10
   */
public class JavaOrNot
{
    /**
     * Reads through the current directory and logs non-java files to nonJava.txt
     * @param args console arguments 
     * @paran folder  is current directory
     * @paran listOfFiles  array of File objects
     * @paran name = ""; Stores the name of the current working file
     * @paran outFile file names for the filewriter 
     * @paran fileName name of the output file
     */
   public static void main(String [] args) 
   {
        //***************************Variables*********************************************************
        File folder = new File(".");  //dot is current directory
        File[] listOfFiles = folder.listFiles(); //we now have array of File objects
        String name = ""; // Stores file name 
        String outFile = ""; // file names for the filewriter 
        String fileName ="nonJava.txt"; // name of the output file
        //*****************************************End of Variables*********************************************************
        
        try {
            //Instantiates the filewriter for output
            PrintWriter fileWriter = new PrintWriter(fileName); 
        
            for (File file : listOfFiles) {
                try { 
                    //#check it's a file not subdirectory
                    if (file.isFile()) {
                        name = file.getName(); //each file name is a String
                        if (name.length()>5) {
                            if (!name.endsWith(".java")){
                                //Creates a new NotJavaException Object
                                NotJavaException newError = new NotJavaException(name);
                                //throws the NotJavaException Object
                                throw newError;
                            }//if file name ends with
                        }// if file name length
                    }//if is a file
                }//try for NotJavaException
                    catch (NotJavaException error) {
                            //writes the string for the output file
                            outFile+=(error.getErrorFile() + "\n");
                        }//NotJavaExceptionr catch 

            }// for listOfFiles 
        
        //Writes the output file
         fileWriter.print(outFile);
        
         //Closes the output file
         fileWriter.close();
        
        }//Outer Try 
            catch (FileNotFoundException e) {
                System.out.println("A File not found error ocured at : " + e.getStackTrace());
            }//FileNotFoundException catch
    }//main
}//class