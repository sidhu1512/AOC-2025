import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D2q2 {

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
            if (checkPattern(numStr)) {
                sum += i;
            }
        }
    }

    // Helper function to check if string is made of repeating chunks
    public static boolean checkPattern(String num) {
        int len = num.length();
        int chunkSize = 1;

        // We only need to check chunks up to half the length of the string
        while (chunkSize <= len / 2) {
            
            // A chunk can only form the string if the length is divisible by it
            if (len % chunkSize != 0) {
                chunkSize++;
                continue;
            }

            String pattern = num.substring(0, chunkSize);
            boolean isMatch = true;

            // Check the rest of the string against this pattern
            for (int i = chunkSize; i < len; i += chunkSize) {
                int nextIndex = i + chunkSize;
                
                // Extract the next chunk to compare
                String currentChunk = num.substring(i, nextIndex);
                
                if (!pattern.equals(currentChunk)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                return true; // Found a valid repeating pattern
            }
            chunkSize++;
        }
        return false;
    }
}
