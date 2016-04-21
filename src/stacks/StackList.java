package src.stacks;
import java.util.Iterator;

/**
 * Objects of type StackList manage items in a singly linked list.
 * Have two inner classes, Node class and StackIterator class for iterating on Objects of type StackList.
 * @author swati
 *
 * @param <T>
 */

public class StackList<T> extends LinkedList<T> implements Iterable <T> 
{
    private String name;
    private Node top;

    /**
     * @param top the top to set
     */
    public void setTop(Node top)
    {
        this.top = top;
    }

    /**
     * @return the top
     */
    public Node getTop()
    {
        return top;
    }

    StackList()
    {
        this.name = "";    
        setTop(super.getHead());
    }

    /**
     *  adds or pushes an item onto the top of this stack
     * @return 
     */
    public T push(T item)
    {
        addToFront(item);
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function
     */
    public T pop()
    {
        if (super.isEmpty())
        {
            System.err.println("Empty stack");
            return null;
        }        
        return (T) super.removeFirstNode().getData();
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.

     */
    public T peek()
    {
        if(super.isEmpty())
        {
            System.out.println("Empty Stack");
            return null;
        }
        return (T) this.top.getData();        
    }


    @Override
    public Iterator<T> iterator()
    {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    /**
     * inner Node class having generic data
     * @author swati
     *
     */
    public class Node
    {
        private T data; 
        private Node next;

        public Node(T newData) 
        {
            this.data = newData;
            this.next = null;
        }

        public T getData()
        {
            // TODO Auto-generated method stub
            return this.data;
        }

        public void setNext(Node someNode)
        {
            // TODO Auto-generated method stub
            this.next = someNode;            
        }

        public Node getNext()
        {
            // TODO Auto-generated method stub
            return this.next;
        }

        public String toString()
        {
            return this.data.toString();
        }
    }

    /**
     * provides an iterator over the outer generic StackList.
     * @author swati
     *
     */    
    class StackIterator implements Iterator<T>
    {
        /**
         *  A generic field that keeps track of the current location being traversed.
         */
        private Node current;

        public StackIterator() 
        {   current = top; }

        public boolean hasNext() 
        {
            // check if the next node is valid
            // if node is invalid, return false
            if (current == null)
                return false;

            // otherwise we haven't reached the end of the list
            return true;
        }

        public T next() 
        {   
            if (current == null)
            {
                throw new java.util.NoSuchElementException();
            }

            // if we're here, then we're looking at a valid current node
            // so grab the data portion, to give to the caller
            T data = (T) current.data;

            // move in preparation for the next time.
            current = current.next;

            return data;  
        }

        public void remove() 
        {
            throw new UnsupportedOperationException();
        }
    }
}
