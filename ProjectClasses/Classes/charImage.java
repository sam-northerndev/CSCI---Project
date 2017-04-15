import java.io.*;
import javafx.scene.image.*;

public class charImage {

   public charImage(){}
   
   //gets character image, input character, and team
   public Image getImage(Character c, String n){
      Image i = new Image(new File("redmage.png").toURI().toString());
      if(n.equals("R")){
         if(c.getType() == 0)
            new Image(new File("redrogue.png").toURI().toString());
         else if (c.getType() == 1)
            new Image(new File("redwarrior.png").toURI().toString());
         else if (c.getType() == 2)
            new Image(new File("redmage.png").toURI().toString());
         else
            new Image(new File("redtank.png").toURI().toString());
      }
      if(n.equals("B")){
         if(c.getType() == 0)
            new Image(new File("bluerogue.png").toURI().toString());
         else if (c.getType() == 1)
            new Image(new File("bluewarrior.png").toURI().toString());
         else if (c.getType() == 2)
            new Image(new File("bluemage.png").toURI().toString());
         else
            new Image(new File("bluetank.png").toURI().toString());
      }
      return i;
   }
   
}