# CSCI 2720 Sorting Project

**Authors:**
- Rishab Subramaniyan (rks00476@uga.edu)
- Jaisharan Ashok Kumar (jaa87686@uga.edu)

**Contributions:** 50% / 50%. Rishab and Jaisharan both sourced the geeksforgeeks code and adapted them together. Jaisharan did the bulk of experiment 1 and Rishab did bulk of experiment 2. Then we cross-referenced to make sure we understood what the other did and made any remaining edits together.

**Compile**

javac *.java

**Experiment 1: Run with input files**

java SortDriver ordered.txt
java SortDriver random.txt
java SortDriver reverse.txt

The program displays the menu, prompts for an algorithm, prints the sorted array, and prints the comparison count.

**Experiment 2: Run with generated random input**

java SortDriver gen s 1000
java SortDriver gen m 5000
java SortDriver gen h 10000
java SortDriver gen q 20000
java SortDriver gen r 30000

Running java SortDriver gen without extra arguments prompts for the algorithm and size interactively.

**Files**

- Sorting.java
- SortDriver.java
- ordered.txt, random.txt, reverse.txt

**Citations**

Sorting algorithm implementations were adapted from GeeksforGeeks:

- Selection Sort: https://www.geeksforgeeks.org/java/java-program-for-selection-sort/
- Merge Sort: https://www.geeksforgeeks.org/java/java-program-for-merge-sort/
- Heap Sort: https://www.geeksforgeeks.org/dsa/heap-sort/
- Quick Sort: https://www.geeksforgeeks.org/dsa/java-program-for-quicksort/

Modifications made:
- Added comparison counters to each algorithm
- Modified Quick Sort partition to use the first element as pivot (original uses last element)
- Added a random-pivot variant of Quick Sort