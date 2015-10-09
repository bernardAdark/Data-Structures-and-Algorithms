package org.meltwater.java.datastructures;

import java.util.NoSuchElementException;

// This is a queue that uses pointers to fetch or add elements

	public class Queue<E> {
		private E [] queue;
		private int begin;
		private int end;
		static int default_size = 5;
		
		public Queue(){
			queue = (E[]) new Object[default_size]; 
			begin = 0;
			end=-1;
		}
		
		
		public  Queue(int n){
			default_size = n;
			queue = (E[]) new Object[default_size]; 
			begin = 0;
			end=-1;
		}
		
		/** 
	     *This method adds an element to the top of the queue, 
		 *if there is no element; this element is the queue to enter and first to go out ,if there is an element, it is the end;
		 *@param e is new member of queue
		 *@throws
		 *Big O = O(1)  constant time
		  */
		public void push(E e )throws IllegalStateException{
			if(isFull()){
				throw new IllegalStateException("Queue is full");	
			}
			
		    if(end < default_size-1)
		    	queue[end + 1] = e;
		    if(end == default_size-1)
		    	end = -1 ;
		    	queue[end + 1] = e;
			end++;
		}
       
		
		/** 
	     *This method returns true if the stack is full and false if not 
		 *It checks if the last pointer(end) is equal to the queue's length or if last 
		 *returns a boolean;
		 *Big O = O(1)  constant time
		  */
		
	   public boolean isFull(){
		if (end == default_size - 1 && begin == 0)
			return true;
	    if((end < begin && begin -1 == 1)&& end != -1 )
	        return true;
	    return false;
		 }
	 
	   /** 
	     *This method takes out the first element in the queue
		 *if there is no element; this element is the queue to enter and first to go out
		 *moves the pointer to the next element or at the beginning if pointer was at the last element;
		 *@param e is new member of queue
		 *@throws an  exception if queue is empty
		 *Big O = O(1)  constant time
		  */
	    public E remove() throws NoSuchElementException{
	    	if(isEmpty())
	    		throw new NoSuchElementException("The element is missing");	    		
	        E temp = queue[begin];
	    	queue[begin] = null;
	    	if(begin == default_size-1)
	    		begin = 0 ;
	        else 
	        	begin++;
	    	return temp;
	    	
	     }
	    
	    /** 
	     *@throws Exception if queue is empty
		 *@returns the first element
		 *Big O = O(1)  constant time
		  */
	    public E peek(){
	       return queue[begin];
	    }
	    
	    /** 	     
		 *@returns true if pointers are at their initial positions
		 *pointers change when element is added or removed;
		 *Big O = O(1)  constant time
		  */
	    public boolean isEmpty(){
	    	return(end == -1 && begin ==0  );
	    }
	    
	    /** 	     
		 *@returns the number of elements in the queue;
		 *elements equals the last pointer + 1
		 *but if last pointer becomes less than first pointer, subtract we manually determine by algebra;
		 *Big O = O(1)  constant time
		  */
	    public int size(){
	    	if(end < begin && end != -1)
	    		return (default_size  - begin + end + 1 );
	    	return end +1;
	    }
	    
	    /** 	     
		 *@returns string representation of queue
		 *It begins from the first pointer to the last pointer 
		 *Big O = O(n)  
		  */
	    public String toString(){
	    	String str ="";
	    	for(int i = begin; i < queue.length; i++){
	    		str = str + queue[i] + " ";
	    		}
	    	if(end < begin){
	    	for(int i = 0; i < begin; i++){
	    		str = str + queue[i]+ " ";
	    	}
	    		}
	    	return str;
	    	
	    }
	    
	    /** 	     
		 *sets all elements to null
		 *returns pointers to their initial state
		 *Big O = O(n)
		  */
	    public void clear(){
	    	for(int i =0 ; i < default_size ; i++){
	    		queue[i] = null;
	    		begin = 0;
	    		end =-1;
	    	}
	    }
	  

}
