import java.io.*;
import java.util.StringTokenizer;

public class GameFile {

   File TeamOne = new File("TeamOne.txt");
   File TeamTwo = new File("TeamTwo.txt");
   
   public GameFile()
   {
      File TeamOne;
      File TeamTwo;
   }
   
   
     //get name of character
     //input team file and num of character you want to retrieve (1-3)
   public String getCharName(File one, int num)throws IOException
   {
      BufferedReader read = new BufferedReader(new FileReader(one));
      StringTokenizer token;
      String line, word;
      String name = "";
      int n = 0;
      int numLine = 1;

        while((line = read.readLine()) != null) {
               token = new StringTokenizer(line, " ");
               while(token.hasMoreTokens()) {
               word = token.nextToken();
                  if(n == 0 && numLine == num)
                     name = word;
               n++;  
                  
               }
            numLine++;
            n = 0;
        }
       
        read.close(); 
        return name;
   }
   
   //get character type
   //input name and team file
   public int getCharType(String name, File one)throws IOException
   {
      BufferedReader read = new BufferedReader(new FileReader(one));
      StringTokenizer token;
      String line, word, character;
      int type = 0;

        while((line = read.readLine()) != null) {
               token = new StringTokenizer(line, " ");
               while(token.hasMoreTokens()) {
                  word = token.nextToken(); 
                  if(word.equals(name)){
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