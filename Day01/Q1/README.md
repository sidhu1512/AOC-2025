# Day 1: Secret Entrance (Part One)

## Approach & Thought Process

The dial functions as a circular array (buffer) of size 100.
1.  **Input Parsing:** - Read the input stream line by line.
    - Separate the direction ('L' or 'R') from the magnitude (the number).
    
2.  **Normalization:**
    - Since the dial is circular (0-99), a rotation of `150` is effectively the same as `50`.
    - I used the modulo operator (`rotation % 100`) to simplify the magnitude before calculating the new position.

3.  **State Management:**
    - I maintain a `dial` variable tracking the current position.
    - **Right (R):** Add the rotation. If it exceeds 99, subtract 100 (wrap around).
    - **Left (L):** Subtract the rotation. If it drops below 0, add 100 (wrap around).

4.  **Condition Checking:**
    - After applying the logic, check if `dial == 0`. If yes, increment the `count`.

## Complexity Analysis
- **Time Complexity:** $O(N)$ 
  - We process the input file line-by-line once. $N$ is the number of instructions.
- **Space Complexity:** $O(1)$
  - We stream the input using `BufferedReader` and only store a few integer variables for the state.

## Solution
[View Java Solution](./D1q1.java)
