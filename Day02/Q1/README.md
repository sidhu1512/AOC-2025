# Day 2: Gift Shop (Part One)

## Approach & Thought Process

The problem asks us to check specific patterns within numerical ranges.



1.  **Input Parsing:**
    - The input comes as a single line of comma-separated ranges (`11-22,95-115`).
    - I split the line by `,` to isolate each range, then split by `-` to get the `start` and `end` values.

2.  **Iteration (Brute Force):**
    - I iterate through every number `i` from `start` to `end`.

3.  **Pattern Validation:**
    - Convert the number to a String.
    - **Length Check:** If the length is odd, it cannot be a perfect repetition of two halves, so we skip it.
    - **Substring Comparison:** - Split the string into two equal halves.
        - Check if `firstHalf.equals(secondHalf)`.
    - If they match, add `i` to the running `sum`.

## Complexity Analysis
- **Time Complexity:** $O(R \times D)$ 
  - $R$ is the total count of numbers in the ranges.
  - $D$ is the number of digits (string conversion and comparison cost).
- **Space Complexity:** $O(1)$ 
  - (Technically $O(D)$ for temporary string allocation per number).

## Solution
[View Java Solution](./D2q1.java)
