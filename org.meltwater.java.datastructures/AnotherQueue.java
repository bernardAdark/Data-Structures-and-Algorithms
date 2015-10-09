package dataStructure;

import java.util.Arrays;

/** 
  @author   Megye wodi
*/
public class AnotherQueue<E> {
	private E [] elements;
	int size;
	int length;
	int default_size = 10;
	
	/** 
     * constructor method that takes param n
	   @param n is the size of the queue
	  */
	
	public AnotherQueue(int n){ 
		length = n;
		elements = (E[]) new Object[n];
		size =0 ;
	}
	
	/** 
     *constructor method that takes default size
	  */
	public AnotherQueue(){ 
		length = default_size;
		elements = (E[]) new Object[default_size];
		size =0 ;
	}
	public void add(E e) throws IllegalStateException {
		if(isFull()){
		throw new IllegalStateException("The queue is full");
		}
		 elements[size] = e;
		 size++;
		}
	
	public E peek(){
		return elements[0];
	}
	
	public E pull(){
		E temp = elements[0];
		for(int i = 0; i < size  ; i++ ){
			elements[i] = elements[i+1];
		}
		 elements[size] = null;
		 size--;
		 return temp;
	}
	
	public int size(){
     return size;
	}
	
	public void clear(){
		for(int i = 0; i <= size; i++ ){	   
			elements[i]= null;
		}
		size=0;
	 }
	public boolean isEmpty(){
		return(size == 0);	
	}
	
	public boolean isFull(){
		return(size == length);		
	}
	
	public E [] toArray(){
		return elements;
	}
	
	public String toString(){
		return Arrays.toString(elements);
	}
	
}

