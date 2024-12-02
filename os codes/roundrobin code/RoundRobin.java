import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of p (processes)
        System.out.print("Enter number of p: ");
        int n = sc.nextInt();
        
        System.out.print("Enter time quantum: ");
        int tq = sc.nextInt(); // Time Quantum
        
        int[] p = new int[n];   // Process IDs
        int[] bt = new int[n];  // Burst Times
        int[] rem_bt = new int[n]; // Remaining Burst Times
        int[] wt = new int[n];  // Waiting Times
        int[] tat = new int[n]; // Turnaround Times
        
        // Input burst times
        for (int i = 0; i < n; i++) {
            p[i] = i + 1; // Process IDs
            System.out.print("Enter bt for p" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            rem_bt[i] = bt[i]; // Initialize remaining burst times
        }
        
        // Round Robin Scheduling
        int completed = 0, currTime = 0;
        while (completed < n) {
            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) { // Process still has remaining time
                    if (rem_bt[i] > tq) {
                        rem_bt[i] -= tq;
                        currTime += tq;
                    } else {
                        currTime += rem_bt[i];
                        wt[i] = currTime - bt[i]; // Waiting time calculation
                        tat[i] = wt[i] + bt[i]; // Turnaround time calculation
                        rem_bt[i] = 0;
                        completed++;
                    }
                }
            }
        }
        
        // Display results
        System.out.println("\np\tbt\twt\ttat");
        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        
        sc.close();
    }
}