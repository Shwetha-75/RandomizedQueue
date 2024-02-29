import java.util.Iterator;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        RandomizedQueue<Integer> queue=new RandomizedQueue<Integer>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        System.out.println(queue.sample());
        Iterator<Integer> itr =queue.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next()+" ");
        }

    }
}