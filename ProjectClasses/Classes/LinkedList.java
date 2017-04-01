/* Linked List class*/ 
public class LinkedList{
   
   //atributes
   private Node front; 
   private int count; 
   
   //constructor 
   public LinkedList(){
      front=null; 
      count=0; 
   }
   
   //method 1: add new node to the front of the list 
   public void addToFront(Node n){  
      front= n; 
      count ++; 
   }
   
   //method 2: get size of list 
   public int size(){
      return count; 
   }
   
   //method 3: see if list is empty 
   public boolean isEmpty(){
      if (front==null)
         return true; 
      else 
         return false; 
   }
   
   //method 4: clear the list
   public void clear(){
      front= null; 
      count=0; 
   }
   
   //method 6: get the reference to the first node 
   public Node getFront(){
      return front; 
   }
   
   //method 7: enumerate 
   public void enumerate(){
      if (!isEmpty()){  
         Node curr=front; 
         while(curr!=null){
            System.out.println(curr); 
            curr=curr.getNext(); 
         }
      }
      else 
         System.out.println("Empty List."); 
   } 
   
   //method 8: remove the first node 
   public void removeFront(){ 
      if(!isEmpty()){ 
         front=front.getNext(); 
         count--; 
      }
      else 
         System.out.println("Empty List."); 
   } 
   
   //method 9: add Node to the end of the list 
   public void addToEnd(Node n){  
      if(isEmpty())
         front=n; 
      else{
         Node curr=front; 
         while(curr.getNext()!=null){ 
            curr=curr.getNext(); 
         }
         curr.setNext(n); 
      }
      count++; 
   } 
 
   //method 10: remove the last node 
   public void removeLast(){ 
      if(isEmpty())
         System.out.println("Empty List."); 
      else if(front.getNext()==null){ 
         front=null; 
         count--; 
      }
      else{ 
         Node curr=front;
         while(curr.getNext().getNext()!=null)
            curr=curr.getNext(); 
         curr.setNext(null); 
      }
      count--; 
   }

   //method 12: add node at a given index
   public void add(int index, Node n){ 
      if(index<0||index >=size())
         System.out.println("Out of bounds."); 
      else if(index==0)
         addToFront(n); 
      else{
         Node curr=front; 
         for(int i=0; i<index; i++)
            curr=curr.getNext();   
         curr.setNext(n); 
         count++;   
      }
   }  
      
   //method 13: remove a node at a given index 
   public void remove(int index){ 
      if(index<0|| index>=size())
         System.out.println("Out of bounds."); 
      else if(index==0)
         removeFront(); 
      else{ 
         Node curr=front; 
         for(int i=0; i<index-1; i++)
            curr=curr.getNext(); 
         curr.setNext(curr.getNext().getNext()); 
         count--;
      }
   }   
   
   //method 14: return the reference for a node at a given index
   public Node getNode(int index){
      Node curr=null; 
      if(index<0||index>=size())
         System.out.println("Out of bounds.");
      else if(index==0)
         curr=front; 
      else{
         curr=front; 
         for(int i=0; i<index; i++)
            curr=curr.getNext(); 
      }
      return curr; 
   }
   public void replace(int index, Node n) {
	   if(index<0||index >=size())//check to make sure the index in bounds, or at the front --> add to front.
	         System.out.println("Out of bounds."); 
	      else if(index==0)
	         addToFront(n); 
	      else {
	         Node curr=front;
	         for(int i=0; i < index-1; i++) //getting to element that must be replaced.
	             curr=curr.getNext();//curr is now element before one that needs to be replaced
	         Node temp = curr.getNext().getNext(); //temp node to hold the next of the element that needs to be replaced
	         n.setNext(temp);//replacing the element 
	         curr.setNext(n);
	         
	      }
	}
}

               
                     
                                                                                                         