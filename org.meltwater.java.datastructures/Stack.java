package org.meltwater.java.datastructures;

import java.util.EmptyStackException;

//A stack is a data structure that begins  execution  from the last element that entered the stack 
//A stack has a definite size and so I represent with an array;

public class Stack<E> {
	
	private E [] stack;
	private int lifo;
	private int filo;
	static int default_size = 10;
	
	public Stack(){
		stack = (E[]) new Object[default_size]; 
		lifo = -1;
		filo = 0;
	}
	
	public Stack(int n){
		default_size = n;
		stack = (E[]) new Object[default_size]; 
		lifo = -1;
		filo=0;
	}
	/** 
     *This method adds an element to the top of the stack, 
	 *if there is no element; this element is the  to enter and last to go out
	 *if there is an element, it is the lifo;
	 *@param e is new member of queue
	 *@throws Exception is stack is full
	 *Big O = O(1)  constant time
	  */
	public void push(E e )throws Error{
		if(isFull()){
			//throw error	
			}
		stack[lifo + 1] = e;
		lifo++;
	}
   
	/** 
     *@return true if stack is full, thus list pointer == index of last element
	 *Big O = O(1)  constant time
	  */
   public boolean isFull(){
	   return(lifo == default_size - 1);	 
   }
    
   	
    public void pop(){
    	if(isEmpty())
    		throw new EmptyStackException();
    	stack[lifo] = null;
    	lifo--;
    }
    
    public E peak(){
    	if(isEmpty())
    		throw new EmptyStackException();
    	return stack[lifo];
    }
    
    public boolean isEmpty(){
    	return(lifo < 0); 	
    }
    
    public int size(){
    	return lifo +1;
    }
    
    public String toString(){
    	String str ="";
    	for(int i = filo; i < stack.length; i++){
    		str = str + stack[i] + " ";
    		}
    	if(lifo < filo){
    	for(int i = 0; i < lifo; i++){
    		str = str + stack[i]+ " ";
    	}
    		}
    	return str;
    	
    }
    
    public void clear(){
    	for(int i = 0; i < default_size; i++){
    		stack[i] = null;
    		lifo =-1;
    		filo = 0;
    				
    	}
    }
}
