import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<DataType> implements  Iterable<DataType>
{

    private class Node
    {
        DataType data;
        Node next;

    }

    private Node first;
    private Node last;


    private int size;

    public RandomizedQueue()
    {
        super();
    }

    public boolean isEmpty()
    {
        return size==0;
    }


    public int size()
    {
        return size;
    }


    public void enqueue(DataType data) throws IllegalArgumentException
    {
        if(data==null)
            throw new IllegalArgumentException();
        else
        {
            Node node = new Node();
            node.data = data;
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

    public DataType dequeue() throws NoSuchElementException
    {
        if(size==0)
            throw new NoSuchElementException();
        else if(size==1)
        {
            DataType data=first.data;
            size=0;
            first=null;
            last=null;
            return data;
        }
        else
        {
            Node temp = first;
            int random=new Random().nextInt(size-1);
            if(random==0)
            {
                first=first.next;
                temp.next=null;
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


    public DataType sample() throws NoSuchElementException
    {
        if(size==0)
            throw new NoSuchElementException();
        if(size==1)
        {
            return first.data;
        }
        else
        {
            Node temp=first;
            int random=new Random().nextInt(size-1);
            if(random==0)
            {
                return temp.data;
            }
            else
            {
                int count=0;
                while(count!=random)
                {
                    temp=temp.next;
                    count++;
                }
            }
            return temp.data;
        }

    }




    @Override
    public Iterator<DataType> iterator()

    {
        return new RandomizedIterable();


    }
    private class RandomizedIterable implements Iterator<DataType>
    {
        Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }


        @Override
        public DataType next() throws NoSuchElementException
        {
            if(current==null)
            {
                throw new NoSuchElementException();
            }

            DataType data=current.data;
            current=current.next;
            return data;
        }
    }


    public static void main(String[] args) {

    }
}
