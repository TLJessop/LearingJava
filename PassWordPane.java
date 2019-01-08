import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * This builds  the scene and holds the event handelers
 * @author Thomas Jessop
 * @version 1.2
 * @since 2018-09-30
 * 
 * @param name this is the textbox for name input
 * @param date this is the textbox for date input
 * @param result this label is used both for displaying the created password and the empty textbox methods
 */

public class PassWordPane extends GridPane {
    private TextField name;
    private TextField date;
    private Label result;
    /**
     * builds the scene
     * @param font the font size determinate
     * @param tileLabel The app's tile
     * @param nameLabel the prompt for the name
     * @param dateLabel the prompt for the date
     * @param yourPasswd the label indocating the nature of the result label
     * 
     */
    
   public PassWordPane(){

    Font font = new Font(18);
   
       Label tileLabel = new Label("Thomas's password genorator");
       GridPane.setHalignment(tileLabel, HPos.CENTER);
       tileLabel.setFont(font);
       tileLabel.setTextFill(Color.WHITE);

       Label nameLabel = new Label("Please give your name :");
       nameLabel.setFont(font);
       GridPane.setHalignment(nameLabel, HPos.RIGHT);
       nameLabel.setTextFill(Color.WHITE);

       Label dateLabel = new Label("Please give a six digit date :");
       dateLabel.setFont(font);
       GridPane.setHalignment(dateLabel, HPos.RIGHT);
       dateLabel.setTextFill(Color.WHITE);

       name = new TextField();
       name.setAlignment(Pos.CENTER);
       name.setPrefWidth(100);
       name.setOnAction(this::passwdGenName);

       date =new TextField();
       date.setAlignment(Pos.CENTER);
       date.setPrefWidth(100);
       date.setOnAction(this::passwdGenDate);

       Label yourPasswd = new Label("Your new Password is :");
        GridPane.setHalignment(yourPasswd, HPos.RIGHT);
        yourPasswd.setFont(font);
        yourPasswd.setTextFill(Color.WHITE);

       result = new Label("---");
       result.setFont(font);
       GridPane.setHalignment(result, HPos.CENTER);
       result.setTextFill(Color.WHITESMOKE);

       setAlignment(Pos.CENTER);
       setHgap(20);
       setVgap(10);
       setStyle("-fx-background-color: blue");

       add(tileLabel, 0, 0);
       add(nameLabel, 0, 2);
       add(name, 1, 2);
       add(dateLabel, 0, 3);
       add(date, 1, 3);
       add(yourPasswd, 0, 4);
       add(result, 1, 4);




     }//construtor PassWordPane

     /**
      * the actionevent handeler tied to the name textbox.
      *It creates a password and sets result to the new password, unless date is empty then result is set to an error prompt
      * @param event an event object
      *@param pName takes the contents of name and stores it in a string
      *@param pDate takes the contents of date and stores it in a string
      @param pResult take the first two char of pName, a '.', a digit random number and the last four char of pDate concatinating them into a single string. 
      */
     public void passwdGenName(ActionEvent event){
        if (date.getText().isEmpty()) {
            result.setText("Please give a date");
            result.setUnderline(true);
            
        }else{
            String pName = name.getText();
            String pDate = date.getText();
            String pResult = pName.substring(0, 2) + "." + (int) ( Math.random() * 99) +
             pDate.substring(pDate.length() -4);
           result.setText(pResult);
           
        }
     }//passwdGenName


    /**
      * the actionevent handeler tied to the date textbox.
      *It creates a password and sets result to the new password, unless name is empty then result is set to an error prompt
      * @param event an event object
      *@param pName takes the contents of name and stores it in a string
      *@param pDate takes the contents of date and stores it in a string
      @param pResult take the first two char of pName, a '.', a digit random number and the last four char of pDate concatinating them into a single string. 
      */
     public void passwdGenDate(ActionEvent event){
        if (name.getText().isEmpty() ) {
            result.setText("Please give your name");
            result.setUnderline(true);
        } else {
            String pName = name.getText();
             String pDate = date.getText();
             String pResult = pName.substring(0, 2) + "." + (int) ( Math.random() * 99) +
              pDate.substring(pDate.length() -4);
            result.setText(pResult);
        
        } 
     }//passwdGenDate


}// class PasswordPane