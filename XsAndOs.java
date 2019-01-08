//XsAndOs.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

/**
 * @author Thomas L Jessop
 * @since 2018-11-01
 * @version 1.0
 * 
 *  @param gameOver boolean flag used to know when the game is over
 *  @param whoseTurn  a char used for keeping track of turns
 *          ps. Why is this a char instead of a emun? I mean it would lock potential values to only the two we want.
 *   @param board a 3 by 3 two dimensional array of cells that is the main gameboard
 *   @param statusLabel a label that informs the user of game state
 * 
 * *************************** Important ******************************************************************
 * I do not claim credit for the base structure of this program. I only claim credit for my addisions that render functionality.
 * The skeleton of this assignment was given to me by Prof. Conner for me to modify
 * ********************************************************************************************************
 * 
 * Algorithm
 *  1. Display a three by three grid of cells and a label that informs the user of game state 
 *  2. When the user clicks on a cell their token will be drawn on the cell
 *      2.2 When a cell have been marked with a token it will not be able to be remarked for the duration of the game
 *      2.3 When the token is drawn the current turn is shifted to the other player
 *  3. When a user gets three Xs of three Os in a row they win
 *      3.2 If the board is fill without meeting a win condision the game ends in a stalemate and the user is informed that no one won
 * 
 */


public class XsAndOs extends Application {
// ********************** Instance variables ***********************************************************************
    private boolean gameOver = false;  //flag
    private char whoseTurn = 'X'; // 'X' or 'O' but 'X' starts 
    private Cell[][] board =  new Cell[3][3];  //the board for playing
    private Label statusLabel = new Label("X's turn to play");  //let user know status of game
// *******************************************************************************************************************
 
    /**
     * Where the stage is built
     * 
     * @param pane node that holds the cells
     */

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane(); 
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    Cell cell = new Cell();

                    cell.setTranslateX(j*100);
                    cell.setTranslateY(i*100);
                
                    board[i][j] = cell;
                    pane.getChildren().add(cell);
                }//for cell creation inter loop
            }//for cell creation outer loop

        //Root node
        BorderPane borderPane = new BorderPane();
        //adding Children to the root node
        borderPane.setCenter(pane);
        borderPane.setBottom(statusLabel);
       

        //set up the scene
        Scene scene = new Scene(borderPane, 300, 320);
        primaryStage.setTitle("XsAndOs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }//start

    /**
     * Checks for a full board by counting used cells
     * @param full flag for return
     * @return full
     */
     public boolean isFull() {
         boolean full = false;
         int count = 0;
         for (int i =0; i<3; i++){
             for (int j =0; j<3; j++){
                if (board[i][j].isCellActive()==true){
                    count++;
                }//if cell used
             }// inter counting loop
         }//outter counting loop

         if (count==9){
             full=true;
         }//if count =9
            else {
                full= false;
            }//else count = 9

         return full;
     }//isFull

    /**
     * Runs the win checks
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    public boolean hasWon(char tkn) {
       
        if (checkWinRow1(tkn) == true || checkWinRow2(tkn) == true ||  checkWinRow3(tkn) == true 
            || checkWinColum1(tkn)==true || checkWinColum2(tkn)==true  || checkWinColum3(tkn)==true
            || checkWinDiagoalR(tkn)==true || checkWinDiagoalL(tkn)==true){
            return true;
        }//if won
            else{
                return false;
            }//else won

            
    }//hasWon

   /**
     * Run the win check for row 1
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinRow1(char tkn){
      
        if (tkn == 'X'){
            if(board[0][0].getToken() =='X' && board[0][1].getToken() =='X' && board[0][2].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 1 all X
        }//if turn is X
            else{
                if(board[0][0].getToken() =='O' && board[0][1].getToken() =='O' && board[0][2].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row one all O
            }// else turn is X

        //If neither checks passed return false 
        return false;
    }//checkWinRow1

     /**
     * Run the win check for row 2
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinRow2(char tkn){
      
        if (tkn == 'X'){
            if(board[1][0].getToken() =='X' && board[1][1].getToken() =='X' && board[1][2].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 2 all X
        }//if turn is X
            else{
                if(board[1][0].getToken() =='O' && board[1][1].getToken() =='O' && board[1][2].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row 2 all O
            }// else turn is X

        //If neither checks passed return false
        return false;
    }//checkWinRow2

     /**
     * Run the win check for row 3
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinRow3(char tkn){
      
        if (tkn == 'X'){
            if(board[2][0].getToken() =='X' && board[2][1].getToken() =='X' && board[2][2].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 2 all X
        }//if turn is X
            else{
                if(board[2][0].getToken() =='O' && board[2][1].getToken() =='O' && board[2][2].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row 2 all O
            }// else turn is X
        
        //If neither checks passed return false
        return false;
    }//checkWinRow3

     /**
     * Run the win check for Colum 1
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinColum1(char tkn){
      
        if (tkn == 'X'){
            if(board[0][0].getToken() =='X' && board[1][0].getToken() =='X' && board[2][0].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 2 all X
        }//if turn is X
            else{
                if(board[0][0].getToken() =='O' && board[1][0].getToken() =='O' && board[2][0].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row 2 all O
            }// else turn is X
            
        //If neither checks passed return false
        return false;
    }//checkWinColum1

    /**
     * Run the win check for Colum 2
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinColum2(char tkn){
      
        if (tkn == 'X'){
            if(board[0][1].getToken() =='X' && board[1][1].getToken() =='X' && board[2][1].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 2 all X
        }//if turn is X
            else{
                if(board[0][1].getToken() =='O' && board[1][1].getToken() =='O' && board[2][1].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row 2 all O
            }// else turn is X

        //If neither checks passed return false
        return false;
    }//checkWinColum2

    /**
     * Run the win check for Colum 3
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinColum3(char tkn){
      
        if (tkn == 'X'){
            if(board[0][2].getToken() =='X' && board[1][2].getToken() =='X' && board[2][2].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 2 all X
        }//if turn is X
            else{
                if(board[0][2].getToken() =='O' && board[1][2].getToken() =='O' && board[2][2].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row 2 all O
            }// else turn is X

        //If neither checks passed return false
        return false;
    }//checkWinColum3


    /**
     * Run the win check for right diagoal
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinDiagoalR(char tkn){
      
        if (tkn == 'X'){
            if(board[0][0].getToken() =='X' && board[1][1].getToken() =='X' && board[2][2].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 2 all X
        }//if turn is X
            else{
                if(board[0][0].getToken() =='O' && board[1][1].getToken() =='O' && board[2][2].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row 2 all O
            }// else turn is X

        //If neither checks passed return false
        return false;
    }//checkWinDiagoalR

    /**
     * Run the win check for left diagoal
     * @param tkn used for knowing which player is being check for a win condision
     * @return boolean
     */
    private boolean checkWinDiagoalL(char tkn){
      
        if (tkn == 'X'){
            if(board[2][0].getToken() =='X' && board[1][1].getToken() =='X' && board[0][2].getToken() =='X'  ){
                gameOver = true;
                return true;
            }//if row 2 all X
        }//if turn is X
            else{
                if(board[2][0].getToken() =='O' && board[1][1].getToken() =='O' && board[0][2].getToken() =='O'  ){
                    gameOver = true;
                    return true;
                }//if row 2 all O
            }// else turn is X

        //If neither checks passed return false
        return false;
    }//checkWinDiagoalL

    //HERE IS INNER CLASS REPRESENTING ONE CELL IN BOARD
    //The inner class has access to all of the outer classes data/methods

    /**
     * Inner class for the cell object
     * @param token used for token marking of cells
     */

    public class Cell extends Pane {
// ********************** Instance variable ***********************************************************************
        private char token = ' ';   // one of blank, X, or O
// *********************************************************************************************
        /**
         * Cell constructor
         */
        public Cell() {
            setStyle("-fx-border-color: black"); 
            setPrefSize(100, 100);
            setOnMouseClicked(e -> handleMouseClick());
        }

        /**
         * Gets the cell's token value
         * @return token
         */
        public char getToken() {
             return token;
         }

         /**
          * Tests if cell is used
          * @return boolean
          */
         public boolean isCellActive() {
            if (getToken()==' ') {
                return false;
            }//if token is default value
                else{
                    return true;
                }//else token is default value
            }

        /**
         * Draws the X token on the cell and set the char token for later referance
         * @param token knowing cell value
         * @param line1 one the lines of the drawn X 
         * @param line2 one the lines of the drawn X 
        */ 
        public void drawX() {
             token ='X';

             Line line1 = new Line(5, 5, 95, 95);
             line1.setStrokeWidth(2);
             Line line2 = new Line(95, 5, 5, 95);
             line2.setStrokeWidth(2);
             getChildren().addAll(line1, line2); 
         }//drawX

        /**
         * Draws the O token on the cell and set the char token for later referance
         * @param token knowing cell value
         * @param ellipse the drawn token for O
        */ 
         public void drawO() {
           token = 'O';

            Ellipse ellipse = new Ellipse(50, 50, 45, 45);
            ellipse.setFill(null);
            ellipse.setStroke(Color.BLACK);
            getChildren().add(ellipse);
         }//drawO

        /**
         * Used for calling the draw methods
         * @param c
         */ 
        public void setToken(char c) {
            if(c=='X'){
                drawX();
                
            }//if c = x
                else{
                    drawO();
                    whoseTurn = 'X';
                }//else c = x 
        }//setToken

        /**
         * Mouse event handleder for the cell
         * @param s string used for updating the bottom label
         */
        private void handleMouseClick() {
            //for updating statusLabel
            String s = "";

            if (!gameOver) {

                if (isCellActive()==false){
                    if (whoseTurn=='X'){
                        //Draw the X token
                        setToken('X');

                        //shift the turn value
                        whoseTurn = 'O';
                        // update for statusLabel
                        s = "O's turn to play";

                        if (hasWon('X')==true ){
                            s= "X has won";
                        }//if X has won
                            else{
                                //for test stalemates
                                if(isFull()==true){
                                    // update for statusLabel
                                    s="No one won";
                                }//if isFull 
                            }//else X has won

                    }//if turn X
                        else{
                            //Draw the O token
                            setToken('O');

                            //shift the turn value
                            whoseTurn = 'X';

                            // update for statusLabel
                            s = "X's turn to play";

                            if (hasWon('O')==true ){
                                s= "O has won";
                            }// if O won

                            else{

                                //for test stalemates
                                if(isFull()==true){

                                     // update for statusLabel
                                    s="No one won";
                                }//if isFull
                            }//else O won
                        }// else turn X
                    //Reset the bottom label
                    statusLabel.setText(s);
                }//if isCellActive
            }//if game over 
        }//mouseClick 
    }//Cell 
  
    /**
     * Launcher for the rest of the program
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
