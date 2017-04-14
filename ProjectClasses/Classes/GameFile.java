import java.io.*;
import java.util.StringTokenizer;

public class GameFile {

   File Characters = new File("Characters.txt");
   
   public GameFile()
   {
      File Characters;
   }
   
   //save characters 
   public void createCharacters(Character one, Character two, Character three)throws IOException{
      FileWriter fwritter = new FileWriter(Characters, true);
      PrintWriter outputFile = new PrintWriter(fwritter);
         
      //input stats
      outputFile.println(one.getName() + " "  + one.getHp() + " " + one.getType());
      outputFile.println(two.getName() + " " + two.getHp() + " " + two.getType());
      outputFile.println(three.getName() + " " + three.getHp() + " " + three.getType());
         
      fwritter.close();
      outputFile.close();
     }
   
   //save character hp
   public void saveCharHp(Character c)throws IOException
   {
      StringTokenizer token;
      File tempFile = new File("temp.txt");
         
      BufferedReader reader = new BufferedReader(new FileReader("Characters.txt"));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
      
      String currentLine, word;
      
      while((currentLine = reader.readLine()) != null) {
               token = new StringTokenizer(currentLine, " ");
               while(token.hasMoreTokens()) {
                  word = token.nextToken();
                  writer.write(word + " ");
                  if(word.equals(c.getName())){
                     writer.write(c.getHp() + " ");
                     word = token.nextToken();
                  }
  
               }
               writer.newLine();
        }
        
        writer.close(); 
        reader.close(); 
   }
   
   //get character hp
   public int getCharHp(Character c)throws IOException
   {
      BufferedReader read = new BufferedReader(new FileReader("Characters.txt"));
      StringTokenizer token;
      String line, word, health;
      int hp = 0;

        while((line = read.readLine()) != null) {
               token = new StringTokenizer(line, " ");
               while(token.hasMoreTokens()) {
                  word = token.nextToken(); 
                  if(word.equals(c.getName())){
                     health = token.nextToken();
                     hp = Integer.parseInt(health);
                  }
                  
               }
                 
        }
       
        read.close(); 
        return hp;
   }
   
   //get character type
   public int getCharType(Character c)throws IOException
   {
      BufferedReader read = new BufferedReader(new FileReader("Characters.txt"));
      StringTokenizer token;
      String line, word, character;
      int type = 0;

        while((line = read.readLine()) != null) {
               token = new StringTokenizer(line, " ");
               while(token.hasMoreTokens()) {
                  word = token.nextToken(); 
                  if(word.equals(c.getName())){
                     word = token.nextToken();
                     character = token.nextToken();
                     type = Integer.parseInt(character);
                  }
                  
               }
                 
        }
       
        read.close(); 
        return type;
   }
   
   //save team one
   public void saveTeamOne(Character one, Character two, Character three) throws IOException
   {
      File TeamOne = new File("TeamOne.txt");
      
      FileWriter fwritter = new FileWriter(TeamOne, true);
      PrintWriter outputFile = new PrintWriter(fwritter);
         
      outputFile.println(one.getName() + " " + one.getType());
      outputFile.println(two.getName() + " " + two.getType());
      outputFile.println(three.getName() + " " + three.getType());
         
      fwritter.close();
      outputFile.close();
     }
   
   //save team two
   public void saveTeamTwo(Character one, Character two, Character three) throws IOException
   {
      File TeamTwo = new File("TeamTwo.txt");
      
      FileWriter fwritter = new FileWriter(TeamTwo, true);
      PrintWriter outputFile = new PrintWriter(fwritter);
         
      outputFile.println(one.getName() + " " + one.getType());
      outputFile.println(two.getName() + " " + two.getType());
      outputFile.println(three.getName() + " " + three.getType());
         
      fwritter.close();
      outputFile.close();
   }
   
}