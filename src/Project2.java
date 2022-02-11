import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class Project2 implements Runnable {
    Thread t;
    String threadName;
    int threadCounter = 0;
    int destroyedThreadCounter = 0;
    //int threadChildCounter = 0;
    List<Integer> threads = new ArrayList<>();




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
        System.out.println("Destroying 100 threads");
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

    // Question 2
    public void parentAndChildThreads(){

        System.out.println("Creating 100 threads " + threadName);
        for(int i=1; i<=10; i++)
        {
            System.out.println("Creating " + threadName + i);
            threadCounter +=1;
            threads.add(i);

            // foreach thread create 1000 child threads
            for(int threadName: threads)
            {
                for(int j=0; j<5; j++)
                {
                    System.out.println("Creating child of: "+ j + " of thread: " + threadName);
                }
            }
        }
    }
}


