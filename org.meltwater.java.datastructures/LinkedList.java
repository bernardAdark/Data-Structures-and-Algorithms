package org.meltwater.java.datastructures;

import java.util.NoSuchElementException;

public class LinkedList   {
	
	
	
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