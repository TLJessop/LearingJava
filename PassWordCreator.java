import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * This program takes your name and a date and creates a password out of them for you.
 * Ps. I personaly wouldn't use said password.
 * 
 * Algorithm
 *  1. Display scene with labels for titile, two input prompts and the resulting genrated password. As well as two textboxs for input.
 *      ps. I know that I one more label than the assignment discription, but it makes the UI much clearer 
 *  2. Capture input from textboxs for password creation
 *  3. Take the first two chatacters from the name textbox, the last four chatcters from the date textbox a random two digit number to combine into a password.
 *  4. Set the result label to the new password
 *  5. Check in the event handeler to see if textboxes are filled, if not set result label to an error message
 * 
 * @author Thomas Jessop
 * @version 1.2
 * @since 2018-09-30
 */
public class PassWordCreator extends Application {
    /**
     * The main method launches the program
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }//main

    /**
     * Sets the stage and calls the scene
     */
    public void start(Stage primearyStage){
        Scene scene = new Scene(new PassWordPane(), 400, 300);
        
        primearyStage.setTitle("Password Genorator");
        primearyStage.setScene(scene);
        primearyStage.show();
    }//start
}//class PassWordCreator