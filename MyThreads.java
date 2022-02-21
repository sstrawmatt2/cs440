import java.lang.reflect.Array;
import java.util.*;

public class MyThreads extends Thread{
    Thread t;
    String threadName;
    int createdThreadCounter = 0;
    int destroyedThreadCounter = 0;

    int createParentThreadCounter = 0;
    int destroyParentThreadCounter = 0;
    int createChildThreadCounter = 0;
    int destroyChildThreadCounter = 0;
    int createGrandChildThreadCounter = 0;
    int destroyGrandChildThreadCounter = 0;

    long destroyStartTime;
    long destroyDuration;
    long createDuration;
    long destroyEndTime;
    long creationEndTime;
    long creationStartTime;


    ArrayList<Integer> parentThreads = new ArrayList<>();
    ArrayList<Integer> childThreads = new ArrayList<>();

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
//    public void run()
//    {
//        ArrayList<Integer> parentThreads = new ArrayList<Integer>();
//
//
//        long creationStartTime = System.nanoTime();
//        // creating the parent threads
//        for(int i=1; i<=100; i++)
//        {
//            System.out.println("Creating Thread: " + threadName + ", " + i);
//            parentThreads.add(i);
//            createParentThreadCounter += 1;
//        }
//        // creating the child threads
//        for(int parent: parentThreads)
//        {
//            for(int j =1; j<=1000; j++)
//            {
//                System.out.println("Creating child #: "+ j + " of thread: " + parent);
//                createChildThreadCounter += 1;
//            }
//
//        }
//        long creationEndTime = System.nanoTime();
//        long createDuration = (creationEndTime - creationStartTime)/1000000;
//
//
//        // destroying the child threads
//        long destroyStartTime = System.nanoTime();
//        for(int parent: parentThreads)
//        {
//            for(int k=1000; k>=1; k--)
//            {
//                System.out.println("Destroying child #: "+ k + " of thread: " + parent);
//                destroyChildThreadCounter += 1;
//            }
//
//        }
//        // destroying the parent threads
//        for(int i=100; i>=1; i--)
//        {
//            System.out.println("Destroying Thread: " + threadName + ", " + i);
//            parentThreads.clear();
//            destroyParentThreadCounter += 1;
//        }
//        long destroyEndTime = System.nanoTime();
//        long destroyDuration = (destroyEndTime - destroyStartTime)/1000000;
//        System.out.println();
//        System.out.println("Time to create threads: " + createDuration + " milliseconds");
//        System.out.println("Time to destroy threads: " + destroyDuration + " milliseconds");
//        System.out.println("Parent threads created: " + createParentThreadCounter);
//        System.out.println("Parent threads destroyed: " + destroyParentThreadCounter);
//        System.out.println("Child threads created: " + createChildThreadCounter);
//        System.out.println("Child threads destroyed: " + destroyChildThreadCounter);
//    }


    // this method is for 2c
//    public void run()
//    {
//
//
//
//
//        long creationStartTime = System.nanoTime();
//        // creating the parent threads
//        for(int i=1; i<=10; i++)
//        {
//            System.out.println("Creating Thread: " + i);
//            parentThreads.add(i);
//            createParentThreadCounter += 1;
//        }
//        // creating the child threads
//        for(int parent: parentThreads)
//        {
//            for(int j =1; j<=1000; j++)
//            {
//                System.out.println("Creating child #: "+ j + " of thread: " + parent);
//                createChildThreadCounter += 1;
//                childThreads.add(j);
//            }
//        }
//
//        // creating grand children
//        for(int child: childThreads)
//        {
//            for(int grandChild=1; grandChild<=1000; grandChild++)
//            {
//                System.out.println("Creating grandchild #: " + grandChild + " of child: " + child + " of parent: " + parentThreads);
//                createGrandChildThreadCounter+=1;
//            }
//        }
//        long creationEndTime = System.nanoTime();
//        long createDuration = (creationEndTime - creationStartTime)/1000000;
//
//
//        // destroying the grandchild threads
//        long destroyStartTime = System.nanoTime();
//
//        for(int child: childThreads)
//        {
//            for(int grandChild=1000; grandChild>=1; grandChild--)
//            {
//                System.out.println("Destroying grandchild #: " + grandChild + " of child: " + child + " of parent: " + parentThreads);
//                destroyGrandChildThreadCounter +=1;
//            }
//        }

    //    destroying child threads
//        for(int parent: parentThreads)
//        {
//            for(int k=1000; k>=1; k--)
//            {
//                System.out.println("Destroying child #: "+ k + " of thread: " + parent);
//                destroyChildThreadCounter += 1;
//            }
//
//        }
//        // destroying the parent threads
//        for(int i=10; i>=1; i--)
//        {
//            System.out.println("Destroying Thread: " + threadName + ", " + i);
//            parentThreads.clear();
//            destroyParentThreadCounter += 1;
//        }
//        long destroyEndTime = System.nanoTime();
//        long destroyDuration = (destroyEndTime - destroyStartTime)/1000000;
//        System.out.println();
//        System.out.println("Time to create threads: " + createDuration + " milliseconds");
//        System.out.println("Time to destroy threads: " + destroyDuration + " milliseconds");
//        System.out.println("Parent threads created: " + createParentThreadCounter);
//        System.out.println("Parent threads destroyed: " + destroyParentThreadCounter);
//        System.out.println("Child threads created: " + createChildThreadCounter);
//        System.out.println("Child threads destroyed: " + destroyChildThreadCounter);
//        System.out.println("Grand child threads created: " + createGrandChildThreadCounter);
//        System.out.println("Grand child threads destroyed: " + createGrandChildThreadCounter);
//    }

    // this run, createParents, createChildren, createGrandChildren, destroyParents, destroyChildren, destroyGrandChildren
    // are all meant for 2c. To see the other pieces running, comment out these methods listed and uncomment out the other
    // run methods above.
    public void run(){
        creationStartTime = System.nanoTime();
        createParents();
        creationEndTime = System.nanoTime();
        createDuration = (creationEndTime - creationStartTime)/1000000;

        destroyStartTime = System.nanoTime();
        destroyParents();
        destroyEndTime = System.nanoTime();
        destroyDuration = (destroyEndTime - destroyStartTime)/1000000;

        calculations();

    }

    public void createParents(){
        for(int i=1; i<=10; i++)
        {
            System.out.println("Creating Thread: " + i);
            parentThreads.add(i);
            createParentThreadCounter += 1;
            createChildren(i);
        }

    }

    public void createChildren(int parentThread){

        for(int j =1; j<=10; j++)
        {
            System.out.println("Creating child #: "+ j + " of thread: " + parentThread);
            createChildThreadCounter += 1;
            childThreads.add(j);
            createGrandChildren(parentThread, j);
        }


    }

    public void createGrandChildren(int parentThread, int childThread){

        for(int grandChild=1; grandChild<=10; grandChild++)
        {
            System.out.println("Creating grandchild #: " + grandChild + " of child: " + childThread + " of parent: " + parentThread);
            createGrandChildThreadCounter+=1;
        }

    }




    public void destroyParents(){
        for(int i=10; i>=1; i--)
        {
            System.out.println("Destroying Thread: " + i);
            parentThreads.clear();
            destroyParentThreadCounter += 1;
            destroyChildren(i);
        }

    }

    public void destroyChildren(int parentThread){

        for(int j =1000; j>=1; j--)
        {
            System.out.println("Creating child #: "+ j + " of thread: " + parentThread);
            destroyChildThreadCounter += 1;
            childThreads.clear();
            destroyGrandChildren(parentThread, j);
        }


    }

    public void destroyGrandChildren(int parentThread, int childThread){

        for(int grandChild=1000; grandChild>=1; grandChild--)
        {
            System.out.println("Creating grandchild #: " + grandChild + " of child: " + childThread + " of parent: " + parentThread);
            destroyGrandChildThreadCounter+=1;
        }

    }





    public void calculations(){
        System.out.println("Time to create threads: " + createDuration + " milliseconds");
        System.out.println("Time to destroy threads: " + destroyDuration + " milliseconds");
        System.out.println("Parent threads created: " + createParentThreadCounter);
        System.out.println("Parent threads destroyed: " + destroyParentThreadCounter);
        System.out.println("Child threads created: " + createChildThreadCounter);
        System.out.println("Child threads destroyed: " + destroyChildThreadCounter);
        System.out.println("Grand child threads created: " + createGrandChildThreadCounter);
        System.out.println("Grand child threads destroyed: " + createGrandChildThreadCounter);

    }



    public void start() {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
