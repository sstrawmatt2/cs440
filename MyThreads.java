import java.util.*;

public class MyThreads extends Thread{
    Thread t;
    String threadName;
    int createdThreadCounter = 0;
    int destroyedThreadCounter = 0;

    MyThreads(String name)
    {
        threadName = name;
    }
//    This run is for 2a
//    public void run() {
//        long creationStartTime = System.nanoTime();
//        System.out.println("Running " +  threadName );
//        // creating new threads
//        for(int i=1; i<=100000; i++)
//        {
//            System.out.println("Thread: " + threadName + ", " + i);
//            createdThreadCounter +=1;
//        }
//        long creationEndTime = System.nanoTime();
//        long createDuration = (creationEndTime - creationStartTime)/1000000;
//
//
//         // after threads have been created they are being destroyed in reverse order
//        long destroyStartTime = System.nanoTime();
//        System.out.println("Destroying Threads");
//        for(int i=100000; i>=1; i--)
//        {
//            System.out.println("Thread: " + threadName + ", " + i);
//            destroyedThreadCounter +=1;
//        }
//        System.out.println("Thread " +  threadName + " exiting.");
//        long destroyEndTime = System.nanoTime();
//        long destroyDuration = (destroyEndTime - destroyStartTime)/1000000;
//        System.out.println();
//        System.out.println("Time to create threads: " + createDuration + " milliseconds");
//        System.out.println("Time to destroy threads: " + destroyDuration + " milliseconds");
//        System.out.println("Number of threads created: " + createdThreadCounter);
//        System.out.println("Number of threads destroyed: " + destroyedThreadCounter);
//    }

    // this run is for 2b
    public void run()
    {
        ArrayList<Integer> parentThreads = new ArrayList<Integer>();

        // creating the parent threads
        for(int i=1; i<=100; i++)
        {
            System.out.println("Creating Thread: " + threadName + ", " + i);
            parentThreads.add(i);
        }
        // creating the child threads
        for(int parent: parentThreads)
        {
            for(int j =1; j<=1000; j++)
            {
                System.out.println("Creating child #: "+ j + " of thread: " + parent);
            }
        }
        // destroying the child threads
        for(int parent: parentThreads)
        {
            for(int k=1000; k>=1; k--)
            {
                System.out.println("Destroying child #: "+ k + " of thread: " + parent);
            }
        }
        // destroying the parent threads
        for(int i=100; i>=1; i--)
        {
            System.out.println("Destroying Thread: " + threadName + ", " + i);
            parentThreads.clear();
        }
        
    }


    public void start() {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    // we don't even need to call the start method. We only need to call this method because we are running the start in this method.
    // that is why we were getting those weird errors earlier. We were running the object calling the start method and running the start
    // method again in the time threads method

    public void timeThreads(){
        long startTime = System.nanoTime();
        run();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println("Time to create threads: " + duration + " milliseconds");
        System.out.println();
    }



}
