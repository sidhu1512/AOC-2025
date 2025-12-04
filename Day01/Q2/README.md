# Day 1: Secret Entrance (Part Two)

In Part Two, the password logic changes. We must count the number of times the dial **points at 0**, regardless of whether it happens *during* a rotation or *at the end* of one.
This extends the logic from **[Part One](/Day01/Q1/README.md)**. Instead of just checking the final position, we now track the path taken.

## Approach & Thought Process

### 1. Mathematical Optimization
If a rotation is large (e.g., `R450`), the dial spins around the entire circle multiple times.
- Since the dial size is 100, `450 / 100 = 4` full revolutions.
- Each full revolution guarantees the dial passes `0` exactly once.
- **Formula:** `count += number / 100`

### 2. Boundary Logic (The Remainder)
After accounting for full loops, we handle the remaining steps (`number % 100`). We check if this partial rotation crosses the `0/99` boundary.

- **Right Rotation:**
    - Calculate new position: `current + rotation`.
    - If `new_pos > 100`, we crossed zero. Increment count.
- **Left Rotation:**
    - Calculate new position: `current - rotation`.
    - If `new_pos < 0`, we wrapped around zero. Increment count (unless we started exactly at 0, as we are moving away from it).

### 3. Final Landing
- If the dial lands exactly on `0` at the end of the rotation, increment count.

## Complexity Analysis
- **Time Complexity:** $O(N)$
- **Space Complexity:** $O(1)$

## Solution
[View Java Solution](./D1q2.java)
