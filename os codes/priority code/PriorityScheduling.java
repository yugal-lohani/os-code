import java.util.Scanner;

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of p (processes)
        System.out.print("Enter number of p: ");
        int n = sc.nextInt();
        
        int[] p = new int[n];   // Process IDs
        int[] bt = new int[n];  // Burst Times
        int[] pri = new int[n]; // Priorities
        int[] wt = new int[n];  // Waiting Times
        int[] tat = new int[n]; // Turnaround Times
        
        // Input burst times and priorities
        for (int i = 0; i < n; i++) {
            p[i] = i + 1; // Process IDs
            System.out.print("Enter bt for p" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            System.out.print("Enter priority for p" + (i + 1) + ": ");
            pri[i] = sc.nextInt();
        }
        
        // Sorting based on priority (lower priority number means higher priority)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pri[i] > pri[j]) {
                    // Swap burst time
                    int temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    // Swap priority
                    temp = pri[i];
                    pri[i] = pri[j];
                    pri[j] = temp;

                    // Swap process IDs
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }

        // Calculating waiting time
        wt[0] = 0; // First process has no waiting time
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1]; // Cumulative waiting time
        }
        
        // Calculating turnaround time
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i]; // Turnaround time = Waiting time + Burst time
        }
        
        // Display results
        System.out.println("\np\tbt\tpri\twt\ttat");
        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + "\t" + bt[i] + "\t" + pri[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        
        sc.close();
    }
}