import java.util.ArrayList;
import java.util.*;

public class Project2 implements Runnable {
    Thread t;
    String threadName;
    int threadCounter = 0;
    int destroyedThreadCounter = 0;
    //int threadChildCounter = 0;
    List<Integer> threads = new ArrayList<>();
    List<Integer> childThreads = new ArrayList<>();




    Project2( String name) {
        threadName = name;
        //System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    public void createThreads(){
        System.out.println("Creating 100,000 threads");
        for(int i=0; i<=99999; i++)
        {
            System.out.println("Creating " + threadName + i);
            threadCounter +=1;
            threads.add(i);
        }
    }

    public void destroyingThreads(){
        System.out.println("Destroying 100,000 threads");
        {
            for(int i=99999; i>0; i--)
            {
                System.out.println("Destroying " + threadName + i);
                destroyedThreadCounter +=1;
            }
        }
    }

    public void timeThreads(){
        //https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java for the timing code
        long startTime = System.nanoTime();
        createThreads();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000 ;
        System.out.println("Time to create 100 threads: " + duration + " milliseconds");
        System.out.println();
        System.out.println();
        System.out.println();

        startTime = System.nanoTime();
        destroyingThreads();
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000 ;
        System.out.println("Time to destroy 100 threads: " + duration + " milliseconds");

    }

    public void threadCalculations(){
        System.out.println("Threads Created: " + threadCounter);
        System.out.println("Threads Destroyed: " + destroyedThreadCounter);
    }

    // Question 2 part b
    public void parentAndChildThreads(){

        System.out.println("Creating 100 threads " + threadName);
        for(int i=0; i<=99; i++)
        {
            System.out.println("Creating " + threadName + i);
            threadCounter +=1;
            threads.add(i);
        }
        for(int threadName: threads)
        {
            System.out.println();
            System.out.println("Thread: " + threadName);
            for(int j=0; j<1000; j++)
            {
                System.out.println("Creating child #: "+ j+ " of thread: " + threadName);
                childThreads.add(j);

            }
        }

        // trying to delete all the child threads after they have been created
        for(int threadName: threads)
        {
            System.out.println("Thread: " + threadName);
            for(int j=999; j>0; j--)
            {
                System.out.println("deleting child #: "+ j+ " of thread: " + threadName);
                childThreads.remove(j);
            }
        }
        // Destroying all the parents in reverse order after all of the children have been destroyed.
        System.out.println("Destroying 100 threads");
        {
            for(int i=99; i>0; i--)
            {
                System.out.println("Destroying " + threadName + i);
                threads.remove(i);
            }
        }

    }
}


