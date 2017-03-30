/* Node class */
public class Node{

   //attributes 
   private Node next; 
   
   //constructor 
   public Node(Node n){ 
      next=n; 
   }
   
   //get and set methods
   public void setNext(Node n){
      next=n;
   }
   
   public Node getNext(){
      return next; 
   }
   
}                     