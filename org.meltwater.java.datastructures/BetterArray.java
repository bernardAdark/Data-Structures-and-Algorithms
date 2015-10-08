package org.meltwater.java.datastructures;

/** 	     
 * A dynamic array that can increase its length;
 */

import java.util.Arrays;

public class BetterArray<E> {
	int originalSize = 10;
	E [] array;
	int size;

   public BetterArray(){
   	array = (E[]) new Object[originalSize];
   	size = 0;
   }
   
   /** 	     
	 *appends elements to the end of the array
	 *Big O = O(n)  
   */
   public void add( E [] arr){
		for(E i : arr){
		add(i);
		}
    }
    
   /** 	     
  	 *appends an element to the end of the array
  	 *Big O = O(1)  constant time 
    */
	public void add(E e){
	 if (size == array.length){
      	E newArray[] = (E[])new Object [array.length*2];
      	for(int i =0; i < size; i++){
      	newArray [i]= array[i];
      	}
      	array =newArray;
    } 
      
	 array[size] = e;
	 size ++;
   }
	
	 /** 	     
	  *@return the index of an element if it is in the array;
	  *@return negative integer if element is not in the array;
	  *Big O = O(n)  
	   */
	public int index(E e){
		for(int i = 0 ; i < size ; i++)
		  if(array[i] == e)
			return  i;
		return -1;
	}
	
	 /**
	  * @return the element at a specific index 	     
	  *@throws Exception if index is a negative integer or if its greater than array size;
	  */
	public E get(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("the index is not within the range");
		return array[index];
	}
	
	 /** 	     
  	 *puts an element at a specific position in array;
  	 *shift the array if the array back position was already occupied by an element
  	 *appends if position is exist and its at end of array;
  	 *Big O = O(1)  constant time 
    */
	public void append(E e){
		insert(size, e);
	}
	
	 /** 	     
  	 *appends an element to the beginning of the array ans shift the rest of elements back
  	 *Big O = O(1)  constant time 
    */
	public void Shift(E e){
		insert(0,e);
	}
	
	 /** 	     
  	 *@return boolean; true if element is in the array and false if its not
  	 *Big O  = O(n);
    */
	public boolean contains(E e){
		return(!(index(e) < 0));
	}
	
	 /** 	     
  	 *@returns number of elements;
  	 *@return 0 if array is empty;
  	 *Big O = O(1)  constant time 
    */
	public int size(){
		return size;
	}
	
	 /** 	     
  	 *removes an element of a specific index;
  	 *shift the elements above index forward
  	 *@throw an Exception if element is negative or element > size;
  	 *Big O Best case = O(1)  constant time when index is at end
  	 *Big O worst case = O(n)  when index is at first;
    */
	public void remove(int index)throws IndexOutOfBoundsException{
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("the index is not within the range");
		for (int i = index; i < size-1 ; i ++){
			array[i] = array [i + 1];;
		}
		   array[size -1] = null;
		   size --;
	}
	
	 /** 	     
  	 *throw NullPointerException if Element is not in the array;
  	 *Big O = O(1)  constant time 
    */
	public void remove(E e)throws NullPointerException{
		int i = index(e);
		if(i <0)
			throw new NullPointerException("The specified element could not be found");
		remove(i);
	}
	
	
	 /** 	     
  	 *reverses the elements in the array
  	 *it swaps the first and last, second and last but 1, until the middle element is reached.
  	 *Big O = O(n)  
    */
	public void reverse(){
		for(int i = 1; i <= size/2 ; i++){
			E temp = array[i-1];
			array[i-1] = array[size-i];	
			array[size-i]= temp;
		}
	}

	 /** 	     
  	 *puts an element at a specific index;
  	 *if position is the first,  Big O is O(n) because elements have to be shifted
  	 *Big O = O(1)  constant time 
    */
	public void insert(int position , E e){
		if (position  > size  || position < 0 ){
			throw new IndexOutOfBoundsException("The specified position is out of reach");
			
		}
		else if( position == size ){
			    add(e);
		}
          else  {
			 add(e);
		     for(int j = size-1; j >= position ;j-- ){
		           array[j+1] = array[j];
                 }
	             array[position]= e;
	             array[size]= null;
	         }
		}
	
	 /** 	     
  	 *@return true if no element in array- if the size -1 < 0
  	 *Big O = O(1)  constant time 
    */
		public boolean isEmpty(){
			return(size -1 < 0);
		}
	
	    public String toString(){
		return Arrays.toString(array);
		}
	    
	  
}