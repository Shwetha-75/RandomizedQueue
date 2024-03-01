import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import edu.princeton.cs.algs4.StdRandom;//download the  jar file from  https://algs4.cs.princeton.edu/code/ to get access
public class RandomizedQueue<DataType> implements  Iterable<DataType>
{
    //linked list class 
    private class Node
    {
        //attributes
        DataType data;
        Node next;

    }
    //attrin=butes
    private Node first;
    private Node last;
    private int size;


    /* constructor*/
    public RandomizedQueue()
    {
        super();
    }


    //checking linked list exists
    //
    public boolean isEmpty()
    {
        return size==0;
    }

    //size of the linked list 
    //makes the note for each operation performed
    public int size()
    {
        return size;
    }

    //insertion at end 
    //insertion can be in any way either at first or at last 
    public void enqueue(DataType data) throws IllegalArgumentException
    {
        //if the user enter no data 
        if(data==null)
            throw new IllegalArgumentException();
        else
        {
            //inerstion at last
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


    //removing the random data from the linked list
    public DataType dequeue() throws NoSuchElementException
    {
        //observations 
        if(size==0)
            throw new NoSuchElementException();
        //if the size itself is 1 no need to generate random number 
        else if(size==1)
        {
            DataType data=first.data;
            size=0;
            first=null;
            last=null;
            return data;
        }
         //rando data is to be displayed    
        else
        {
            
            Node temp = first;
            //generating random number from the Random class and method is nextInt method
            int random=new Random().nextInt(size-1);
            //if the generated random number itself is 0 
            //then no need to iterate over the lniked list
            if(random==0)
            {
                //deletion at first
                first=first.next;
                temp.next=null;
                size--;
                return temp.data;
            }
            else
            {
                //if the random number ist at intermediatory or last position
                int count = 0;
                //loop until the prev node
                while (count != random - 1) {
                    temp = temp.next;
                    count++;
                }
                //deletd node 
                Node deleted = temp.next;
                temp.next = deleted.next;
                deleted.next = null;
                temp=deleted;
            }
            size--;
            return temp.data;
        }

    }

    //displaying the random linked list data 
    public DataType sample() throws NoSuchElementException
    {
        //linked list is empty 
        if(size==0)
            throw new NoSuchElementException();
        //list has only one node
        if(size==1)
        {
            return first.data;
        }
        else
        {
            //generating the random number to display the data
            Node temp=first;
            int random=new Random().nextInt(size-1);
           //display the first node data
            if(random==0)
            {
                return temp.data;
            }
            else
            {
                //if the random is not generated
                int count=0;
                //until prev node
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
        DataType dataType[];

        {
            Node temp=first;
            int i=0;
            dataType= (DataType[]) new Object[size()];
            while(temp!=null)
                {
                    dataTypes[i++]=temp.data;
                    temp=temp.next;
                }
            StdRandom.shuffle(dataTypes);
                
                
        }
        int current=0;
        @Override
        public boolean hasNext() {
            return current!=size();
        }

        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }


        @Override
        public DataType next() throws NoSuchElementException
        {
            if(current==size())
            {
                throw new NoSuchElementException();
            }
            //incomplete cause it has to return random data for call 
            // DataType data=current.data;
            // current=current.next;
            // return data;
            //Implemented 
             return dataTypes[current++];
            
        }
    }


    public static void main(String[] args) {

    }
}
