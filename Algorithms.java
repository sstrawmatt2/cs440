import java.util.Scanner;
import java.util.*;

public class Algorithms {


    public void Processes() {

        Scanner scanner1 = new Scanner(System.in);
        Random rand = new Random();
        int individualArrival;
        int individualBurst;
        ArrayList<Integer> allProcesses = new ArrayList<>();

        ArrayList<Integer> allArrivals = new ArrayList<>();

        ArrayList<Integer> allBursts = new ArrayList<>();


        int seed;
        int numberOfProcesses;
        int lastArrivalTime;
        int burstTime;
        int quantum;
        int latency;

        System.out.println("Please enter the following data:");
        System.out.print("\nSeed Value: ");
        seed = scanner1.nextInt();

        System.out.print("\nNumber of Processes (2, 100): ");
        numberOfProcesses = scanner1.nextInt();
        System.out.print("\nLast Arrival Time (0, 99): ");
        lastArrivalTime = scanner1.nextInt();
        System.out.print("\nMax Burst Time (1,100): ");
        burstTime = scanner1.nextInt();


        System.out.print("\nQuantum (1, 100): ");
        quantum = scanner1.nextInt();
        System.out.print("\nLatency (0, 10): ");
        latency = scanner1.nextInt();

        System.out.println("Seed Value: " + seed);
        System.out.println("Num of p: " + numberOfProcesses);
        System.out.println("last arrival: " + lastArrivalTime);
        System.out.println("max burst: " + burstTime);
        System.out.println("quantum: " + quantum);
        System.out.println("latency: " + latency);



        // adding processes to an arraylist
        if (numberOfProcesses >= 1) {
            for (int i = 1; i <= numberOfProcesses; i++) {
                //System.out.println("Process: " + i);
                allProcesses.add(i);
            }
        }

        // calculating arrival times for each process
        for(int process:allProcesses)
        {
            individualArrival = rand.nextInt(99);
            //System.out.println("Process: " + process + " Arrival Time: " + individualArrival);
            allArrivals.add(individualArrival);
        }

        for(int process: allProcesses)
        {
            individualBurst = rand.nextInt(100);
            //System.out.println("Process: " + process + " Burst Time: " + individualBurst);
            allBursts.add(individualBurst);
        }

        System.out.println("Processes         Arrivals          Bursts");
        for(int i=0; i<allProcesses.size(); i++)
        {
            System.out.println("   P: " + allProcesses.get(i) + "            " + allArrivals.get(i) + "                " + allBursts.get(i));
        }



        System.out.println("Random:");
        for(int i=0; i<allArrivals.size(); i++)
        {
            //int contextSwitchCounter =0;
            System.out.println("@t: " + allArrivals.get(i) +" P" +  allProcesses.get(i) + " selected for " + allBursts.get(i));
            //contextSwitchCounter +=1;
            //System.out.println("@t: " + i + " context switch " + contextSwitchCounter + " occurs");
        }




        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("SJF");
        int processCounter = 0;
        //sorting for sjf
        for(int i=0; i<allBursts.size(); i++)
        {
            for(int j=0; j<allBursts.size() - 1; j++)
            {
                if(allBursts.get(i) < allBursts.get(j))
                {
                    int temp = allBursts.get(i);
                    allBursts.set(i,allBursts.get(j));
                    allBursts.set(j,temp);
                    int temp2 = allArrivals.get(i);
                    allArrivals.set(i,allArrivals.get(j));
                    allArrivals.set(j,temp2);
//                    int temp3 = allProcesses.get(j);
//                    allProcesses.set(i, allProcesses.get(j));
//                    allProcesses.set(j,temp3);
                }

            }
        }

        for(int i=0; i<numberOfProcesses; i++)
        {
            System.out.println("@t: " + allArrivals.get(i) +" P" +  allProcesses.get(i) + " selected for " + allBursts.get(i));
        }
        // just the process number for this is off
        // arrivals and bursts are matching up


//        for(int k: allBursts)
//        {
//            System.out.println("selected for "+ k );
//            //+" P:" + allProcesses.get(i) + " selected for " + allBursts.get(i)
//        }
        // im sorting the shortest burst time correctly but I need to make sure every process stays with every time and every
        // burst that it belongs to
        // right now this is just assigning the shortest burst to the first process


        //fcfs
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("FCFS");
        for(int i=0; i<allProcesses.size(); i++)
        {
            for(int j=0; j<allProcesses.size()-1; j++)
            {
                if(allArrivals.get(i) < allArrivals.get(j))
                {
                    int temp = allArrivals.get(i);
                    allArrivals.set(i,allArrivals.get(j));
                    allArrivals.set(j,temp);
                    int temp2 = allBursts.get(j);
                    allBursts.set(i, allBursts.get(j));
                    allBursts.set(j,temp2);
                    int temp3 = allProcesses.get(j);
                    allProcesses.set(i, allProcesses.get(j));
                    allProcesses.set(j,temp3);
                }
            }
        }
        for(int i=0; i<allProcesses.size(); i++)
        {
            System.out.println("@t: " + allArrivals.get(i) +" P" +  i + " selected for " + allBursts.get(i));
        }
    }
}
