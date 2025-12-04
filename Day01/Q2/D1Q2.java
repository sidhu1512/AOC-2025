import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D1q2 {

    public static int count = 0;

    public static void main(String[] args) {
        int dial = 50;
        try (BufferedReader bf = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                dial = spinDial(line, dial);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        System.out.println("Password Code: " + count);
    }

    public static int spinDial(String s, int dial) {
        // Parse the full number (e.g., 450)
        int number = Integer.parseInt(s.substring(1));

        // 1. Optimization: Add counts for full 360-degree spins
        count += number / 100;

        // Get the remaining steps
        int rotation = number % 100;

        // Optimization: If remaining rotation is 0, we only counted the full spins.
        // The dial position does not change.
        if (rotation == 0) {
            return dial;
        }

        if (s.charAt(0) == 'R') {
            rotation = dial + rotation;
            // Check if we crossed the 0/99 boundary moving Right
            if (rotation > 100) { // > 100 because 0 is index 0, so 100 is the first wrap
                count++;
            }
            // Wrap the value back to 0-99 range
            if (rotation > 99) {
                rotation = rotation - 100;
            }
        } else {
            rotation = dial - rotation;
            // Check if we crossed the 0/99 boundary moving Left
            if (rotation < 0) {
                rotation += 100;
                // Special edge case: If we started at 0 and moved left, 
                // we didn't "cross" it to generate a click, we just left it.
                if (dial != 0) {
                    count++;
                }
            }
        }

        // 3. Check if we landed exactly on 0
        if (rotation == 0) {
            count++;
        }
        return rotation;
    }
}
