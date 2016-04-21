package src.stacks;

import src.stacks.StackList.Node;

/**
 * @class LinkedList [a generic LinkedList of Node objects and its size]
 */
public class LinkedList<T> 
{
    // keeps track of the front of the list
    private Node head;

    // keeps track of the number of nodes in the list
    private int size;

    /**
     *  Creates an new list that is empty.
     */
    public LinkedList()
    {
        this.head = null;
        this.size = 0;
    }

    /**
     * Checks if head is pointing to any node.
     */
    public boolean isEmpty()
    {
        // If head is not pointing to any nodes, then our list is empty.
        if (this.head == null)  
            return true;

        // Otherwise, there are one or more nodes in the list.
        return false;
    }

    /**
     * adds the data to the front of list
     * @param data [type: generic, creates new node that is added to front]
     */
    public void addToFront(T data)
    {         
        Node walker = new StackList<T>().new Node(data);

        if(isEmpty())
        {            
            this.head = walker;
            size++;
            return;
        }

        walker.setNext(head);
        head = walker;
        size++;
    }

    /**
     * 
     * @return first node of list
     */
    public Node removeFirstNode()
    {
        // if list is empty return null
        if(this.isEmpty() == true)
            return null;

        // else return firstNode       
        Node firstNode = head;
        head = head.getNext();
        size--;
        return firstNode;        
    }

    /**
     * The number of nodes in the list. 
     */
    public int size() 
    {
        return this.size;
    }

    public String toString()
    {
        // Uses a StringBuffer to concatenate strings
        StringBuilder list = new StringBuilder();

        list.append("[");

        Node walker = this.head;

        while (walker != null)
        {
            list.append(walker.getData() + "\n"); 
            walker = walker.getNext();            
        }
        list.append("]");
        return list.toString();  

    }

    public StackList<T>.Node getHead()
    {
        // TODO Auto-generated method stub
        return this.head;
    }
}
