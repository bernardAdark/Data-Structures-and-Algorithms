package org.meltwater.java.datastructures;



public class BinarySearchTree{
    Node myMainNode;
    int size;

 // this constructs a binary tree
    public BinarySearchTree() 
    {
        myMainNode = null;
        size = 0;
    }

     private Node insertNode(Node rootNode, Node myNewNode) {
        if (rootNode == null) {
            rootNode = myNewNode;
            
        } else if (myNewNode.value < rootNode.value) {
            rootNode.firstNode = insertNode(rootNode.firstNode, myNewNode);
        } else {
            rootNode.secondNode = 
               insertNode(rootNode.secondNode, myNewNode);
        }
        size++;
        return rootNode;
    }

    public void add(Node newNode) {
        myMainNode = insertNode(myMainNode, newNode);
    }

   
    private void inorder(Node rootNode) {
        if (rootNode != null) {
            inorder(rootNode.firstNode);	
            rootNode.show(); 			
            inorder(rootNode.secondNode);	
        }
    }

   

    public String toString() {
        inorder(myMainNode);
        return null;
    }


    protected Node search(Node rootNode, int searchValue) {
        if (rootNode == null) {
            return null;
        } else {
            if (searchValue == rootNode.value) {
                return rootNode;
            } else if (searchValue < rootNode.value) {
                return search(rootNode.firstNode, searchValue);
            } else {
                return search(rootNode.secondNode, searchValue);
            }
        }
    }

   
    public Node searchBST(int key) {
        Node temp = search(myMainNode, key);
        if (temp == null) {
           return null;
       }else {
           return temp;
        }
    }
    
    public boolean contains(int e){
    	return (searchBST(e) == null) ? false : true;
    }
    
    private Node farLeft(Node nd){
    	if(nd.firstNode == null)
    		return nd;
    	return farLeft(nd.firstNode);
    }
    
    private Node farRight(Node nd){
    	if(nd.secondNode == null)
    		return nd;
    	return farRight(nd.secondNode);
    }
    
    public int smallest(){
            return farLeft(myMainNode).value;
    }
    
    public int largest(){
    	return farRight(myMainNode).value;
    }
}

class Node {

public Node firstNode,  secondNode; 
public int value;

// this constructs a node 
public Node(int v ) {
    this.value = v;
    this.firstNode = null;
    this.secondNode = null;
}

public void show() {
   
    System.out.print(value + " | ");
}
}