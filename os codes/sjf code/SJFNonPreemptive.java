import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class SJFNonPreemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter number of p: ");
        int n = sc.nextInt();

        int[] p = new int[n];   // Process IDs
        int[] bt = new int[n];  // Burst times
        int[] wt = new int[n];  // Waiting times
        int[] tat = new int[n]; // Turnaround times

        // Input burst times for each process
        for (int i = 0; i < n; i++) {
            p[i] = i + 1;
            System.out.print("Enter bt for p" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
        }

        // Sort by burst time (Shortest Job First)
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = p[i];
            arr[i][1] = bt[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        // Calculate waiting and turnaround times
        wt[0] = 0; // First process has no waiting time
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + arr[i - 1][1];
        }
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + arr[i][1];
        }

        // Display results
        System.out.println("\np\tbt\twt\ttat");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1] + "\t" + wt[i] + "\t" + tat[i]);
        }

        sc.close();
    }
}