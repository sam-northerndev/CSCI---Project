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
   public void addToFront(String d){ 
      Node n= new Node(d, front); 
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
   
   //method 5: get front data 
   public String getFrontData(){
      return front.getData();
   }
   
   //method 6: ge the reference to the first node 
   public Node getFrontNode(){
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
   public void addToEnd(String d){ 
      Node n= new Node(d, null); 
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
   
   //method 11: returns index of given string 
   public int contains(String d){
      Node curr=front; 
      int index=-1;
      boolean found= false; 
      while(curr!=null&&!found){
         index++; 
         if(curr.getData().equals(d))
            found=true; 
         curr=curr.getNext(); 
      }
      if(!found)
         return -1; 
      else 
         return index; 
   }
   
   //method 12: add node at a given index
   public void add(int index, String d){ 
      if(index<0||index >=size())
         System.out.println("Out of bounds."); 
      else if(index==0)
         addToFront(d); 
      else{
         Node curr=front; 
         for(int i=0; i<index; i++)
            curr=curr.getNext();   
         Node n= new Node(d, curr.getNext());
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
}                           
               
                     
                                                                                                         