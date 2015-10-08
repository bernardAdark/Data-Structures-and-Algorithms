package org.meltwater.java.datastructures;



public class LinkedList<E> {
	
	private Nodde myNode;
	int counter = 0 ;
	
	public LinkedList(){
		myNode = new Nodde(null);
		counter = 0;
	}
	
	/** 
     * method that add an element to the end of the list;
     * creates a node and store it in a temp variable
	 * takes a current node and increments till  the element it points to is null;
	 * it then points the current node to the temporary node, and increases the counter
	 @param element is new member of LinkedList
	 Big O = O(1) constant time;
	 */
	
	public void add(Object data){
		Nodde temp = new Nodde(data);
	    Nodde current = myNode;
	    while(current.getNext() != null){
	     	current = current.getNext();
	    }
		    current.setNext(temp);
	   	 	counter ++;
	  }
	
	
	/** 
     * method that add an element to a specific position of the list;
     * creates a node and store it in a temp variable
	 * takes a current node and increments till  the element it point to is occupying that position;
	 * points the current node to the temporary node, and points temp to the element on that position
	 @param element is new member of LinkedList
	 @param position is index of element
	 Big O = O(1) constant time;
	 */
	public void add( int position , Object data){
		 
	    Nodde temp = new Nodde(data);
	    Nodde current = myNode;
	    for(int i = 0; i < position && current.getNext() != null; i++){
	    	current = current.getNext();
	      }
	    temp.setNext(current.getNext());
	    current.setNext(temp);
	    counter ++;
	   }
	
	
	/** 
     * method that gets the value of the node at specific index;
     * @param position is index of element
     * if next node is not less than position; current node is the next node
	 * during loop; if next node is null, method returns null
	 * after loop, current node is before the node occupying the position
	 * @return the value of nextNode
	 * Big O = O(1) constant time;
	 */
	public Object get(int position){
		Nodde current = myNode;
		
		for (int i = 0 ; i < position ; i ++){
			if(current.getNext() == null)
				return null;
			current = current.getNext();
			}
		 return current.getNext().getValue();
		}
    
	/** 
	 * @return number of elements in list
	 * Big O = O(1) constant time;
	 */
	public int size(){
		return counter;
	}
	
	
	/** 
     * method get the value of an index and removes it by linking the preceding Node to the node after node after;
     * @param position is index of element to be removed
	 * @return true if the position is not null or invalid
	 * Big O = O(1) constant time;
	 */
	public boolean remove(int position ){
		if (position < 0 || position > counter)
			return false;
	    Nodde current = myNode;
	    for(int i = 0 ; i < position - 1; i++){
	    	if(current.getNext() == null)
	    		return false;
	    	current = current.getNext();
	    }
	    
	    current.setNext(current.getNext().getNext());
	    counter --;
		return true;
	}
	
	public String toString(){
		String str = "";
		Nodde current = myNode.getNext();
		while(current != null){
			str = str + current.getValue().toString() + "";
		}
		return str;
	}
	
	public Object head(){
		if(myNode == null){}
          //Exception			
		return myNode.getNext();
	}
	
	public Object tail(){
		if(myNode == null){}
	          //Exception	
		Nodde current = myNode;
		for(int i = 0; i < counter ; i++){
			current = current.getNext();
		}
		return current;
	}
	
	public boolean isEmpty(){
		return(counter == 0);
	}
	
	public boolean contains( Object e){
		Nodde current = myNode;
		for (int i = 0 ; i < counter; i++ ){
			 if(current.getNext().getValue() == e){
				 return true;
			 }
			 current = current.getNext();
		}
		return false;
	}
	
	public void insertAfter(Object e, Object d){
		Nodde current = myNode;
		Nodde temp = new Nodde(d);
		for(int i = 0 ; i < counter; i ++){
			if(current.getValue() == e){
				temp.setNext(current.getNext());
				current.setNext(temp);
				counter ++;
				break;
			}
		 current = current.getNext();
		}
	}
	
	public void reverse(){
		Nodde temp = new Nodde(null);
		Nodde current = myNode;
		for(int i = 0; i < counter; i++){
			
		}
		
	}
	
	public void insertBefore(Object e, Object d){
//		error
		Nodde current = myNode;
		Nodde temp = new Nodde(e);
		for(int i = 0 ; i < counter ; i ++){
			if(current.getNext().getValue() == e){
				temp.setNext(current.getNext());
				current.setNext(temp);;
				break;
			}
		}
		
	}

	
}



 class Nodde {
	
	Object value;
	Nodde reference;
	
	
	
	public Nodde(Object a , Nodde b){
		this.value = a;
		this.reference = b;
	}
	
	public Nodde(Object a){
		this.value = a;
		this.reference =null;
	}
	
	public Nodde getNext(){
		return reference;
	}

	public void setNext(Nodde b){
		reference = b;
	}
	public Object getValue(){
		return value;
	}
	public void setValue(Object a){
		value = a;
	}
}