import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
/**
 * @author Thomas Jessop
 * @version 1.2
 * @since 2018-12-10
 * 
 * Algorithim
 *  1. Create an array of circle objects
 *  2. Populate the circle array 
 *  3. Test if created circles overlap, if they do set their fill to transparent light blue
 *  4. Display circles to the screen
 */

public class CircleOverLap extends Application{

    /**
     * Program launch point
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Build an array of circle objects, then sets them to transparent blue if they overlap 
     * 
     * @param root //root node holder
     * @param circles // the array of circle objects
     * @param scene // the display scene 
     */
    public void start(Stage primearyStage){
        
        // root node for the scene
        Pane root = new Pane();
        root.setPadding(new Insets(10, 50, 50, 50));

        //array of circle objects
        Circle[] circles = new Circle[20];
        
        for (int r =0; r < circles.length; r++) {
            
            //base circle setup
            Circle circle = new Circle();
            //Sudo-random radis
            circle.setRadius(((Math.random() * 20) +10));
            //Sudo-random x and y coordinates
            circle.setCenterX(((Math.random() * 430) +20));
            circle.setCenterY(((Math.random() * 430) +20));
            //base circle color setting
            circle.setStrokeWidth(2);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.BLACK);

            //array insertion
            circles[r] = circle;

            //helps controll the reverse progression by keeping track of the current iteration of the build loop
            int j = r ;

            for (int l= r-1; l >=0; l-- ){
                // used for knowing the distance between circle centers
                double distSq = (circles[l].getCenterX() - circles[j].getCenterX()) * (circles[l].getCenterX() - circles[j].getCenterX()) 
                            + (circles[l].getCenterY() - circles[j].getCenterY()) * (circles[l].getCenterY() - circles[j].getCenterY());

                //used for knowing the sum of their radii
                double radSumSq = (circles[l].getRadius() + circles[j].getRadius() ) * (circles[l].getRadius() + circles[j].getRadius() );
                
                //test if the distance of the circle centers is less than the sum of the two radii 
                if ( distSq < radSumSq ){
                    circles[l].setFill(Color.rgb(135, 206, 250, 0.3));
                    circles[j].setFill(Color.rgb(135, 206, 250, 0.3));
                }//if overlap check
            }// for reverse iterated overlap check
        }//for circle Creation
        
        //loop that adds the circles to root
        for (int v =0; v < circles.length; v++) {
            root.getChildren().add(circles[v]);
        }// for adding circles to root

        //declaring the scene 
        Scene scene = new Scene(root, 500, 500);
        //setting background color
        scene.setFill(Color.WHITE);

        //setting the scene
        primearyStage.setScene(scene);
        //setting the app title
        primearyStage.setTitle("Circle Overlap");
        //showing the scene
        primearyStage.show();
    }//start
}// class