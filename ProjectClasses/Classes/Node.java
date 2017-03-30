/* Node class */
public class Node{

   //attributes
   private String data; 
   private Node next; 
   
   //constructor 
   public Node(String d, Node n){
      data=d; 
      next=n; 
   }
   
   //get and set methods
   public void setData(String d){
      data=d; 
   }
   
   public void setNext(Node n){
      next=n;
   }
   
   public String getData(){
      return data; 
   }
   
   public Node getNext(){
      return next; 
   }
   
   //toString method 
   public String toString(){
      return data + "-->";
   }
}                     