import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking the number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        
        int[] p = new int[n];  // Array to hold process IDs
        int[] bt = new int[n]; // Array to hold burst times
        int[] wt = new int[n]; // Array to hold waiting times
        int[] tat = new int[n]; // Array to hold turnaround times
        
        // Input burst times for each process
        for (int i = 0; i < n; i++) {
            p[i] = i + 1; // Process IDs starting from 1
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            bt[i] = sc.nextInt();
        }
        
        // Calculating waiting time for each process
        wt[0] = 0; // First process has no waiting time
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1]; // Waiting time is cumulative
        }
        
        // Calculating turnaround time for each process
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i]; // Turnaround time = Waiting time + Burst time
        }
        
        // Displaying the results
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }
        
        sc.close();
    }
}