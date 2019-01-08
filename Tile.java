import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

/**
 * @author Thomas L Jessop
 * @since 2018-10-26
 * @version 1.2
 * @param tileText set as class variable for mutilmethod actcess
 * 
 */

public class Tile extends StackPane{
     private Text tileText = new Text();

    /**
     * Tile constrctor
     * @param boader for seeing the egde of the tiles
     * @param tileText 
     */
    Tile(){
        Rectangle boader = new Rectangle(200, 200);
        boader.setStroke(Color.BLACK);
        boader.setFill(null);

        tileText = new Text("...");
        tileText.setFont(new Font(72));
        
        getChildren().addAll(boader, tileText);
    }//Tile

    /**
     * Sets test of the tile
     * @param passText
     */
    public void setTileText(String passText){
        this.tileText.setText(passText);

    }//setTileText

    /**
     * Get the tile's text in string form
     * @return
     */
    public String getTextValue() {
        return tileText.getText();
    }//getTextValue

    /**
     * Tests if tileText is default value
     * @return
     */
    public boolean isTileActive() {
        if (tileText.getText().equals("...")) {
            return false;
        }//if tileText is default value
            else{
                return true;
            }//else tileText is default value
    }//isTileActive
}//class Tile