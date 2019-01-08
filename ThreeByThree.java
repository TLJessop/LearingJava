
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * @author Thomas L Jessop
 * @since 2018-10-26
 * @version 1.2
 * @param whosTurn a enum used for keeping track of turns
 * @param gameOver boolean flag used to know when the game is over
 * @param gameWon boolean flag used to know when a player has won
 * @param openSpaces boolean used to know when the board is full
 *      both gameWon & openSpaces are used in determining a stalemate
 * @param fullTiles count of number of full tiles
 * @param gameBoard a 3 by 3 two dimensional array of tiles that is the main gameboard
 * @param desscription this text is used initally instruct the user on the side buttons. After a win event this text changes to inform the user of the wining party
 *  
 * Algorithim 
 *  1. The user is shown a welcome scene that possessing a welcome message and a button that when pressed changes the scene to the main game scene
 *  2. On the main game scene there are too three be there grides, one of control buttons and one display tiles.
 *      2.2 when one of the buttons is press the tile in the corresponding position is filled with the curent player's marker
 *      2.3 after a title has been marked it will not be usable again untill the restarting of the game
 *  3. When either a player wins by getting three in a row or there is a stale mate from a lack of available tiles the game is over
 *      3.2 upon the end of a game the description text will change to inform the user.
 *      3.3 Said change in the description text will either delare the winning user or in the case of a stalemate the lack of a winner
 *      3.4 When the game is over a restart button will be added to the top node container
 *      3.5 Upon pressing the restart button game values will be reset and the user will be taken back to the welcome scene
 */


public class ThreeByThree extends Application {

//***********************************************************************************
// Class variables
      //used for keeping track of turns
    enum whosTurn{X, Y;}
    whosTurn currentTurn = whosTurn.X;

    //used in win/game over test
    boolean gameOver = false;
    boolean gameWon = false;
    boolean openSpaces = true;
    int fullTiles=0;

    //This piece of array was made a class variable so it could be changed by winCheck()
    Tile[][] gameBoard = new Tile[3][3];

    //This piece of text was made a class variable so it could be changed by winCheck()
    Text desscription ;
// End of Class variables
// ***************************************************************************************

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        
        //primary node holder for the main game scene
        VBox root = new VBox();
        
        //node holder for the title, usage dessscription.
        //At the end of a game the restart button is added to this node holder
        HBox textHolder =new HBox();
        
        Text title = new Text("Tic-Tack-Toe");
        title.setFont( Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 25 ) );
    

        desscription = new Text("Push Buttons in the relative position of the tile you wish to mark");
        desscription.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 18));
        textHolder.getChildren().add(title);
        textHolder.getChildren().add(desscription);
        textHolder.setSpacing(15);

        //main game
        Scene scene = new Scene(root, 750, 650);
        scene.setFill(Color.LIGHTBLUE);

        // Welcome screen root node holder 
        VBox openingRoot = new VBox(40);
        openingRoot.setBackground(Background.EMPTY);

        // Welcome screen title 
        Text openingTitle = new Text();
        openingTitle.setText("Welcome! \nLet's Play Tic-Tack-Toe");
        openingTitle.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 60));

        // Welcome screen to main game scene button 
        Button startButton = new Button("Start");
        startButton.setPrefSize(500, 100);
        startButton.setOnAction(e -> primaryStage.setScene(scene));
                
        openingRoot.getChildren().add(openingTitle);
        openingRoot.getChildren().add(startButton);

         // Welcome screen scene
        Scene openingScene = new Scene(openingRoot, 750, 450);
        openingScene.setFill(Color.LIGHTBLUE);

        //Restart button
        //this is added to the textHolder Hbox when gameOver is true
        Button restart =new Button("Restart?");
             restart.setPrefSize(100, 50);
             restart.setFont(Font.font(20));
            
             //restart lambda function
             restart.setOnAction(e ->{
                 //resetting boolean flags
                 gameOver=false;
                 gameWon=false;

                 //resetting the count of used tiles
                 fullTiles=0;

                 //resetting the desscription text
                 desscription.setText("Push Buttons in the relative position of the tile you wish to mark");
                 desscription.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 18));

                //hiding the restart button
                textHolder.getChildren().remove(restart);


                for (int i = 0; i < 3; i++) {

                    for (int j = 0; j < 3; j++) {
                        
                       if (gameBoard[i][j].isTileActive() ==true ){
                           gameBoard[i][j].setTileText("...");
                       }//if tile rewrite
                    }//inter for loop tile rewrite
                }//outter for loop tile rewrite

                primaryStage.setScene(openingScene);
                }); // end restart setOnAction

        //node holder for tiles and control buttons
        HBox gameBox = new HBox();

        //node holder for tiles
        Pane tilePane = new Pane();
        
            //Tile creation
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                         Tile tile = new Tile();
                         
                        tile.setTranslateX(j * 200 );
                        tile.setTranslateY(i * 200);
                        gameBoard[i][j] = tile;
                        
                        tilePane.getChildren().add(tile);
                        
                        
                }//inter for loop tile creation
            }//outer for loop tile creation
        
        // node holder for controll buttons
        Pane controlButons = new Pane();
           
            //Control button creation
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                            
                    Button button = new Button();
                            
                    button.setTranslateX(j * 40 );
                    button.setTranslateY(i * 40);
                    button.setPrefSize(40, 40);
                    
                    //Setts a final version of i and j for uses in the Anonymous inner class
                    final int I =i;
                    final int J =j;

                    //Control Buttion Anonymous inner class 
                        //ps I used a Anonymous inner class here instead of a lambda function just to show that I know how t use both    
                    button.setOnAction( new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e){ 

                        //blocking new actions from the control buttons if the game is over
                        if (gameOver==false){   
                            
                            //prevents reusing of tiles
                            if (gameBoard[I][J].isTileActive() == false){
                                        
                                //checking current turn to properly assign the writing of the tile
                                if (currentTurn == whosTurn.X) {

                                    //write to tile
                                    gameBoard[I][J].setTileText("X");
                                    
                                    //tests for win condtition
                                    winCheck();   
                                    
                                    //adds restart button to header if game is over
                                    if (gameOver==true){
                                        textHolder.getChildren().add(restart); 
                                    }//if add restart

                                    //Change turn
                                    currentTurn = whosTurn.Y;
                                    }// if currentTurn

                                        else {
                                            //write to tile
                                             gameBoard[I][J].setTileText("Y"); 

                                             //tests for win condtition
                                             winCheck();
                                                 
                                            if (gameOver==true){
                                                textHolder.getChildren().add(restart); 
                                            }//if add restart

                                            //Change turn
                                            currentTurn = whosTurn.X;
                                        }//else currentTurn
                                    }//if tileActive
                                          
                                }//if gameover
                            }//handle
                        });//setOnAction
                               
                        controlButons.getChildren().add(button);
                    }//inter for loop button creation
                }//outer for loop button creation
                        
              
        //adding the buttons and tiles to gameBox
        gameBox.getChildren().addAll(controlButons);
        gameBox.getChildren().addAll(tilePane);

        //set spacing for gameBox
        gameBox.setSpacing(90);
                
        //adding the gamebox and header to root
        root.getChildren().addAll(textHolder);
        root.getChildren().addAll(gameBox);

        //set spacing for gameBox nulling the background
        root.setSpacing(20);
        root.setBackground(Background.EMPTY);
        
        //seting primarystage 
        primaryStage.setScene(openingScene);
        primaryStage.setTitle("Three by Three");
        primaryStage.show();
    }//start

    /**
     * Call win checks and test for a stale mate
     * @param gameOver boolean flag for setting end of game
     * @param gameWon boolean flag for telling the diference between a win and a stale mate
     * @return void
     */
    private void winCheck(){
// win check calls
// *********************************** 
        checkWinRow1();
        checkWinRow2();
        checkWinRow3();
        checkWinColumn1();
        checkWinColumn2();
        checkWinColumn3();
        checkWinDiagoalR();
        checkWinDiagoalL();
// End of win checks
//**************************************

        //test for open spaces
        if (openSpaceCheck() == false){
            gameOver=true;
        }//if openSpace

        //Test for win or stale mate
        if (gameOver==true){
            if (gameWon== true){
                desscription.setText("Game Over, " + currentTurn + " won");
                desscription.setFont(new Font(30));
            }//if gameWon
                else{
                    desscription.setText("Game Over, no one won");
                    desscription.setFont(new Font(30));
                }//else gameWon
        }//if gameover
    }//winCheck

    /**
     * Counts unused tiles and set a boolean flag based on if the are any open tiles left.
     * @param openSpaces boolean flag
     * @param fullTiles count of used tiles
     * @return openSpaces
     */
    private boolean openSpaceCheck(){
        openSpaces = true;
        fullTiles=0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                
               if (gameBoard[i][j].isTileActive() ==true ){
                   fullTiles++;
               }//if tileActive
            }//inter for loop
        }//outer for loop

        //set boolean flag to false if all tiles are used
        if (fullTiles == 9) {
            openSpaces=false;
        }// if tile count

        return openSpaces;
    }//openSpaceCheck

    /**
    * Checks if row one is filled a one player
    * @param gameOver boolean flag for setting end of game
     * @param gameWon boolean flag for telling the diference between a win and a stale mate
     * @return void
     */
    private void checkWinRow1(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[0][0].getTextValue()=="X" && gameBoard[0][1].getTextValue()=="X"&& gameBoard[0][2].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }//if row 1 all X
        }//if turn is X
            else{
                if(gameBoard[0][0].getTextValue()=="Y" && gameBoard[0][1].getTextValue()=="Y"&& gameBoard[0][2].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }//if row one all Y
            }// else turn is X
    }//checkWinRow1

    /**
    * Checks if row two is filled a one player
    * @param gameOver boolean flag for setting end of game
    * @param gameWon boolean flag for telling the diference between a win and a stale mate
    * @return void
    */
    private void checkWinRow2(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[1][0].getTextValue()=="X" && gameBoard[1][1].getTextValue()=="X"&& gameBoard[1][2].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }
        }//if turn is X
            else{
                if(gameBoard[1][0].getTextValue()=="Y" && gameBoard[1][1].getTextValue()=="Y"&& gameBoard[1][2].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }
            }// else turn is X
    }//checkWinRow2

    /**
    * Checks if row three is filled a one player
    * @param gameOver boolean flag for setting end of game
    * @param gameWon boolean flag for telling the diference between a win and a stale mate
    * @return void
    */
    private void checkWinRow3(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[2][0].getTextValue()=="X" && gameBoard[2][1].getTextValue()=="X"&& gameBoard[2][2].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }
        }//if turn is X
            else{
                if(gameBoard[2][0].getTextValue()=="Y" && gameBoard[2][1].getTextValue()=="Y"&& gameBoard[2][2].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }
            }// else turn is X
    }//checkWinRow3

    /**
    * Checks if column one is filled a one player
    * @param gameOver boolean flag for setting end of game
    * @param gameWon boolean flag for telling the diference between a win and a stale mate
    * @return void
    */
    private void checkWinColumn1(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[0][0].getTextValue()=="X" && gameBoard[1][0].getTextValue()=="X"&& gameBoard[2][0].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }
        }//if turn is X
            else{
                if(gameBoard[0][0].getTextValue()=="Y" && gameBoard[1][0].getTextValue()=="Y"&& gameBoard[2][0].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }
            }// else turn is X
    }//checkWinColumn1

    /**
    * Checks if column two is filled a one player
    * @param gameOver boolean flag for setting end of game
    * @param gameWon boolean flag for telling the diference between a win and a stale mate
    * @return void
    */
    private void checkWinColumn2(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[0][1].getTextValue()=="X" && gameBoard[1][1].getTextValue()=="X"&& gameBoard[2][1].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }
        }//if turn is X
            else{
                if(gameBoard[0][1].getTextValue()=="Y" && gameBoard[1][1].getTextValue()=="Y"&& gameBoard[2][1].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }
            }// else turn is X
    }//checkWinColumn2

    /**
    * Checks if column three is filled a one player
    * @param gameOver boolean flag for setting end of game
    * @param gameWon boolean flag for telling the diference between a win and a stale mate
    * @return void
    */
    private void checkWinColumn3(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[0][2].getTextValue()=="X" && gameBoard[1][2].getTextValue()=="X"&& gameBoard[2][2].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }
        }//if turn is X
            else{
                if(gameBoard[0][2].getTextValue()=="Y" && gameBoard[1][2].getTextValue()=="Y"&& gameBoard[2][2].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }
            }// else turn is X
    }//checkWinColumn3

    /**
    * Checks if right diagoal is filled a one player
    * @param gameOver boolean flag for setting end of game
    * @param gameWon boolean flag for telling the diference between a win and a stale mate
    * @return void
    */
    private void checkWinDiagoalR(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[0][0].getTextValue()=="X" && gameBoard[1][1].getTextValue()=="X"&& gameBoard[2][2].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }
        }//if turn is X
            else{
                if(gameBoard[0][0].getTextValue()=="Y" && gameBoard[1][1].getTextValue()=="Y"&& gameBoard[2][2].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }
            }// else turn is X
    }//checkWinDiagoalR
    
    /**
    * Checks if right diagoal is filled a one player
    * @param gameOver boolean flag for setting end of game
    * @param gameWon boolean flag for telling the diference between a win and a stale mate
    * @return void
    */
    private void checkWinDiagoalL(){
        if (currentTurn == whosTurn.X){
            if(gameBoard[0][2].getTextValue()=="X" && gameBoard[1][1].getTextValue()=="X"&& gameBoard[2][0].getTextValue()=="X" ){
                gameOver = true;
                gameWon = true;
            }
        }//if turn is X
            else{
                if(gameBoard[0][2].getTextValue()=="Y" && gameBoard[1][1].getTextValue()=="Y"&& gameBoard[2][0].getTextValue()=="Y" ){
                    gameOver = true;
                    gameWon = true;
                }
            }// else turn is X
    }//checkWinDiagoalR  
}//class