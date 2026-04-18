import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SortDriver {

    public static void main(String[] args) throws Exception {
        Sorting sorting = new Sorting();

        if (args.length > 0 && args[0].equalsIgnoreCase("gen")) {
            runGeneratedMode(sorting, args);
            return;
        }

        if (args.length == 0) {
            System.out.println("Usage: java SortDriver <inputfile> or java SortDriver gen [algorithm] [size]");
            return;
        }

        int[] values = readInputFile(args[0]);
        Scanner scanner = new Scanner(System.in);

        printMenu();
        System.out.print("Enter the algorithm: ");
        String choice = scanner.nextLine().trim().toLowerCase();
        runFileMode(sorting, values, choice);
        scanner.close();
    }

    private static void runFileMode(Sorting sorting, int[] values, String choice) {
        int[] data = copyArray(values);
        long comparisons;

        switch (choice) {
            case "s":
                comparisons = sorting.selectionSort(data);
                printArray(data);
                System.out.println("#Selection-sort comparisons: " + comparisons);
                break;
            case "m":
                comparisons = sorting.mergeSort(data);
                printArray(data);
                System.out.println("#Merge-sort comparisons: " + comparisons);
                break;
            case "h":
                comparisons = sorting.heapSort(data);
                printArray(data);
                System.out.println("#Heap-sort comparisons: " + comparisons);
                break;
            case "q":
                comparisons = sorting.quickSortFirstPivot(data);
                printArray(data);
                System.out.println("#Quick-sort-fp comparisons: " + comparisons);
                break;
            case "r":
                comparisons = sorting.quickSortRandomPivot(data);
                printArray(data);
                System.out.println("#Quick-sort-rp comparisons: " + comparisons);
                break;
            default:
                System.out.println("Unknown algorithm choice.");
                break;
        }
    }

    private static void runGeneratedMode(Sorting sorting, String[] args) {
        String choice;
        int size;

        if (args.length >= 3) {
            choice = args[1].trim().toLowerCase();
            size = Integer.parseInt(args[2]);
        } else {
            Scanner scanner = new Scanner(System.in);
            printMenu();
            System.out.print("Enter the algorithm: ");
            choice = scanner.nextLine().trim().toLowerCase();
            System.out.print("Enter the input size: ");
            size = Integer.parseInt(scanner.nextLine().trim());
            scanner.close();
        }

        int[] values = generateRandomArray(size);
        int[] data = copyArray(values);

        long comparisons;
        switch (choice) {
            case "s":
                comparisons = sorting.selectionSort(data);
                System.out.println("#Selection-sort comparisons: " + comparisons);
                break;
            case "m":
                comparisons = sorting.mergeSort(data);
                System.out.println("#Merge-sort comparisons: " + comparisons);
                break;
            case "h":
                comparisons = sorting.heapSort(data);
                System.out.println("#Heap-sort comparisons: " + comparisons);
                break;
            case "q":
                comparisons = sorting.quickSortFirstPivot(data);
                System.out.println("#Quick-sort-fp comparisons: " + comparisons);
                break;
            case "r":
                comparisons = sorting.quickSortRandomPivot(data);
                System.out.println("#Quick-sort-rp comparisons: " + comparisons);
                break;
            default:
                System.out.println("Unknown algorithm choice.");
                break;
        }
    }

    private static int[] readInputFile(String fileName) throws FileNotFoundException {
        List<Integer> numbers = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNextInt()) {
            numbers.add(fileScanner.nextInt());
        }
        fileScanner.close();

        int[] values = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            values[i] = numbers.get(i);
        }
        return values;
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = random.nextInt(size * 10 + 1);
        }
        return values;
    }

    private static int[] copyArray(int[] values) {
        int[] copy = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            copy[i] = values[i];
        }
        return copy;
    }

    private static void printArray(int[] values) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                builder.append(' ');
            }
            builder.append(values[i]);
        }
        System.out.println(builder.toString());
    }

    private static void printMenu() {
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q)");
        System.out.println("quick-sort-rp (r)");
    }
}