import java.util.Scanner;
/**
 * @author Thomas L Jessop
 * @since 2018-10-16
 * @version 1.2
 * @param userInput a Scaner used in asking the user wheather or not they want to reroll
 * @param whosTurn a enum used for keeping track of turns
 * 
 * Algorithim
 *  1. Create set of dice from with PairOfDice constuctor
 *  2. Player one's turn
 *      2.1 Player one rolls dice 
 *      2.2 If either is 1 turnis over and score is not added to
 *      2.3 Upon ataining a vaid roll the sum is added to player one's score 
 *      2.4 Player one is prompted to chose whether to hold(end thier turn) or roll again
 *      2.5 Player one's turn continues untill they hold, lose their turn or win condision is met
 *  3. Player two's turn (NPC)
 *      3.1 Player rolls dice
 *      3.2 If either is 1 turnis over and score is not added to
 *      3.3 Upon ataining a vaid roll the sum is added to player two's score
 *      3.4 If player two gains 20 or more points in a turn they will automaticly hold
 *      3.5 Player two's turn continues untill they hold, lose their turn or win condision is met
 *  4. 2 and 3 are repeted untill one of the players gains 50 or more points
 * 
 * Ps. this code would have been a lot shorter if the driver program was allowed more than one method 
 */

public class Weasel{
    //used for keeping track of turns
    enum whosTurn{PLAYER_ONE, PLAYER_TWO;}
    
    //used in the reroll check
    static Scanner userInput = new Scanner(System.in);
    /**
     * Where everything interesting hapens
     *
     * @param args
     * @param gameOver a flag used to tell when a player has won
     * @param playerOneScore tallys player one's score
     * @param playerTwoScoreTotal tallys player two's total score
     * @param playerTwoScoreTurn tallys player two's score per turn
     * @param controllString used when player one choses whether to hold(end thier turn) or roll again
     * @param currentTurn used for keeping track of turns
     * @param setOfDice set of dice created from with PairOfDice constuctor
     */
    public static void main(String[] args)
    {

    // Variable declartions *******************************************************************************************************************
    boolean gameOver = false;
    int playerOneScore = 0 ;
    int playerTwoScoreTotal =0;
    int playerTwoScoreTurn =0;
    String controllString;
    whosTurn currentTurn = whosTurn.PLAYER_ONE;
    PairOfDice setOfDice = new PairOfDice();
    // End of Variable declartions **************************************************************************************************************

    System.out.println("Let's play Weasel");

    //This loop keeps the game runing untill one of the players wins
    while(gameOver== false){

            //This while loop controlls the human player's turn
            while (currentTurn == whosTurn.PLAYER_ONE && gameOver==false) {
                setOfDice.rollDice();

                //test for p1 turn loss
                if (setOfDice.getDie1() == 1 || setOfDice.getDie2() == 1) {
                    System.out.println("You rolled " + setOfDice.getDie1() + " and "+ setOfDice.getDie2() );
                    System.out.println("You lose your turn");
                    System.out.println("Your score is " + playerOneScore);
                    currentTurn = whosTurn.PLAYER_TWO;
                }//if p1 turn loss check 

                 else {
                    playerOneScore += setOfDice.sumOfDice();
                    System.out.println("You rolled " + setOfDice.sumOfDice() );
                    
                    //Test for win condision for player one
                    if(playerOneScore >=50){
                        System.out.println("You win!");
                        gameOver=true;
                    }//if p1 win
                    else{
                        System.out.print("Would you like to roll or hold? (type r to roll or h to hold)");
                        controllString = userInput.nextLine();

                         if (controllString.equalsIgnoreCase("r") ) {
                             } //if p1 reroll check
                            else { 
                                if (controllString.equalsIgnoreCase("h")) {
                                 currentTurn = whosTurn.PLAYER_TWO;
                                System.out.println("Player two's turn");
                                }//if hold check 
                                    else{
                                        while(!controllString.equalsIgnoreCase("h") && !controllString.equalsIgnoreCase("r")){
                                            System.out.print("Please type r or h :");
                                            controllString = userInput.nextLine();
                                        }//while controllString not vaid choice

                                        //retesing for turn change
                                        if (controllString.equalsIgnoreCase("h")) {
                                            currentTurn = whosTurn.PLAYER_TWO;
                                           System.out.println("Player two's turn");
                                           }//if hold check 
                                    }// else p1 hold check 

                            }// else p1 reroll check

                    }//else p1 win check
                    
                }//else p1 turn loss check   

                //gives empty line between rolls
                System.out.println();
            }//while p1

            //This while loop controlls the computer player's turn
            while (currentTurn==whosTurn.PLAYER_TWO && gameOver== false) {
                setOfDice.rollDice();

                //test to see if p2 losses
                if (setOfDice.getDie1() == 1 || setOfDice.getDie2() == 1) {
                    System.out.println("Player two rolled " + setOfDice.getDie1() + " and "+ setOfDice.getDie2() );
                    System.out.println("Players two's turn is over");
                    System.out.println("Player two's score is " + playerTwoScoreTotal);
                    currentTurn = whosTurn.PLAYER_ONE;
                }//if p2 turn loss check
                    else{
                        playerTwoScoreTotal += setOfDice.sumOfDice();
                        playerTwoScoreTurn += setOfDice.sumOfDice();
                        System.out.println("Player Two's current score is " + setOfDice.sumOfDice() );
                    }//else p2 turn loss check

                //p2 win check
                if(playerTwoScoreTotal >=50){
                    System.out.println("Player Two wins!");
                    gameOver=true;
                    }//if p2 win check

                    else{
                
                    //if player 2 gains 20 or more points without lossing a turn then player 2 ends their turn.
                    if(playerTwoScoreTurn>= 20){
                        currentTurn= whosTurn.PLAYER_ONE;
                        playerTwoScoreTurn=0;
                        }//if p2 hold check

                    }//else p2 win check

                 //gives empty line between rolls
                 System.out.println();
            }//while p2

        }//while game not over

    }//main

}//class