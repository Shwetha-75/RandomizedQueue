import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements  Iterable<Item>
{


    //private class node
    private class Node
    {
        //attributes
        Item data;
        Node next;

    }
    //attributes
    private Node first;
    private Node last;


    private int size;



    public RandomizedQueue()
    {

        super();
    }


    //checking for the size
    public boolean isEmpty()
    {

        return size == 0;
    }


    public int size()
    {
        return size;
    }


    //inserting the element at the end

    public void enqueue(Item data)
    {
        //if the data is invalid
        if (data == null)
            throw new IllegalArgumentException();
        else
        {
            //creating the node obj for data
            Node node = new Node();
            //inserting the data value
            node.data = data;
            //insertion is  first
            if (first == null) {
                first = node;
                last = node;
            } else {
                last.next = node;
                last = node;
            }
            size++;
        }
    }


    //deleting the node from the random number generation
    public Item dequeue()
    {
        //no elements in the linked list
        if (size == 0)
            throw new NoSuchElementException();
        else if (size == 1)
        {
            Item data = first.data;
            size = 0;
            first = null;
            last = null;
            return data;
        }
        else
        {
            Node temp = first;
            int random = StdRandom.uniformInt(size);

            if (random == 0)
            {
                first = first.next;
                temp.next = null;
                size--;
                return temp.data;
            }
            else
            {
                int count = 0;
                while (count != random - 1) {
                    temp = temp.next;
                    count++;
                }
                Node deleted = temp.next;
                temp.next = deleted.next;
                deleted.next = null;
                temp=deleted;
            }
            size--;
            return temp.data;
        }

    }


    public Item sample()
    {
        if (size == 0)
            throw new NoSuchElementException();
        if (size == 1)
        {
            return first.data;
        }
        else
        {
            Node temp = first;
            int random = StdRandom.uniformInt(size);
            if (random == 0)
            {
                return temp.data;
            }
            else
            {
                int count = 0;
                while (count != random)
                {
                    temp = temp.next;
                    count++;
                }
            }
            return temp.data;
        }

    }




    @Override
    public Iterator<Item> iterator()

    {
        return new RandomizedIterable();


    }
    private class RandomizedIterable implements Iterator<Item>
    {

        Item dataTypes[] = (Item[])new Object[size()];

        {

            Node temp = first;
            int i = 0;
            while (temp != null) {
                dataTypes[i++] = temp.data;
                temp = temp.next;
            }
            StdRandom.shuffle(dataTypes);

        }

        int current = 0;

        private RandomizedIterable() {
        }

        @Override
        public boolean hasNext() {

            return current != size();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


        @Override
        public Item next()
        {
            if (current == size())
            {
                throw new NoSuchElementException();
            }
            //incomplete
            return dataTypes[current++];


        }
    }


    public static void main(String[] args)
    {

    }
}
