import java.util.ArrayList;
import java.util.*;

public class Project2 implements Runnable {
    Thread t;
    String threadName;
    int createdThreadCounter = 0;
    int destroyedThreadCounter = 0;
    //int threadChildCounter = 0;





    Project2( String name) {
        threadName = name;
        //System.out.println("Creating " +  threadName );
    }

    public void run() {

        System.out.println("Running " +  threadName );
        try {
            // creating new threads
            for(int i=1; i<=100; i++)
            {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
                createdThreadCounter +=1;
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        // after threads have been created they are being destroyed in reverse order
        System.out.println("Destroying Threads");
        for(int i=100; i>=1; i--)
        {
            destroyedThreadCounter +=1;
            System.out.println("Thread: " + threadName + ", " + i);
        }

        System.out.println("Thread " +  threadName + " exiting.");
    }



    public void start() {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    public void timeThreads(){
        //https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java for the timing code
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        run();
        long duration = (endTime - startTime)/1000000 ;
        System.out.println("Time to create 100,000 threads: " + duration + " milliseconds");
        System.out.println();
        System.out.println();
        System.out.println();

        startTime = System.nanoTime();
        run();
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000 ;
        System.out.println("Time to destroy 100,000 threads: " + duration + " milliseconds");

    }

    public void calculations(){
        System.out.println("Created threads: " + createdThreadCounter);
        System.out.println("Destroyed threads: " + destroyedThreadCounter);
    }



}


