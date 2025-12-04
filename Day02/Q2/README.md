# Day 2: Gift Shop (Part Two)


### Connection to Part 1
In **[Part One](../Q1)**, we only checked if the string could be split into two equal halves. Here, we must check for *all possible* repetition cycles.

## Approach & Thought Process

My goal was to check if the number string is built from a smaller "seed" string (chunk) repeated $N$ times.



### 1. The Brute Force Pattern Matching
For a number string `S` (e.g., "121212"), I try to find a "chunk size" that works.
- I iterate through possible chunk sizes starting from `1` up to `length / 2`.
- **Pruning (Optimization):** A chunk of size `k` can only generate a string of length `L` if `L` is divisible by `k`.
  - `if (len % chunk != 0) continue;`
  - This skips unnecessary checks (e.g., you can't build a 5-digit number from 2-digit chunks).

### 2. Verification
Once I have a valid chunk size, I compare the first chunk against all subsequent chunks in the string.
- If **all** chunks match the first one, the ID is invalid (add to sum).
- If **any** mismatch is found, break and try the next chunk size.

## Complexity Analysis
- **Time Complexity:** $O(R \times D^2)$
  - $R$ is the range of numbers.
  - $D$ is the number of digits.
- **Space Complexity:** $O(D)$
  - Used for storing the string representation of the number.

## Solution
[View Java Solution](./D2q2.java)
