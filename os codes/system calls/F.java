import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        File f = new File("ex.txt");
        if (f.createNewFile()) System.out.println("File created.");
        else System.out.println("File exists.");

        try (BufferedWriter w = new BufferedWriter(new FileWriter(f))) {
            w.write("Hello");
        }

        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            System.out.println(r.readLine());
        }

        if (f.delete()) System.out.println("File deleted.");
        else System.out.println("Delete failed.");
    }
}
