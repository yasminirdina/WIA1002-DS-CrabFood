package crabfood;

import java.util.LinkedList;

public class OrderQueue<E> {
    LinkedList<E> list = new LinkedList<>();
    
    public void enqueue(E element)
    {
        list.addLast(element);
    }
    
    public E dequeue()
    {
        return list.removeFirst();
    }
    
    public E peek()
    {
        return list.peek();
    }
    
    public int getSize()
    {
        return list.size();
    }
    
    public boolean isEmpty()
    {
        return getSize() == 0;
    }
    
    public boolean contains(E e)
    {
        return list.contains(e);
    }
    
    @Override
    public String toString()
    {
        return list.toString();
    }

    
    public E[] toArray(String[] string) {
        return (E[]) list.toArray();
    }
    
}