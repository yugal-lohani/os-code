import java.io.*;

public class P {
    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("echo", "Hello Process").start();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            System.out.println(r.readLine());
        }
    }
}