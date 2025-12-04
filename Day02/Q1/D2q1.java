import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D2q1 {

    public static long sum = 0;

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("inputd2.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] ranges = line.split(",");
                for (String range : ranges) {
                    processRange(range);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        System.out.println("Total Sum of Invalid IDs: " + sum);
    }

    public static void processRange(String range) {
        String[] bounds = range.split("-");
        long start = Long.parseLong(bounds[0]);
        long end = Long.parseLong(bounds[1]);

        for (long i = start; i <= end; i++) {
            String numStr = String.valueOf(i);
            int len = numStr.length();

            if (len % 2 != 0) {
                continue;
            }

            int half = len / 2;
            String firstHalf = numStr.substring(0, half);
            String secondHalf = numStr.substring(half);

            if (firstHalf.equals(secondHalf)) {
                sum += i;
            }
        }
    }
}
