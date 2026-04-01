import java.util.Arrays;

public class AccountLookup {

    // ================= LINEAR SEARCH =================
    // Find first occurrence + count comparisons
    public static int linearSearch(String[] logs, String target) {
        int comparisons = 0;

        for (int i = 0; i < logs.length; i++) {
            comparisons++;

            if (logs[i].equals(target)) {
                System.out.println("Linear Search:");
                System.out.println("First occurrence at index " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not found");
        return -1;
    }

    // ================= BINARY SEARCH =================
    // Exact match + duplicate count
    public static void binarySearch(String[] logs, String target) {
        int low = 0;
        int high = logs.length - 1;
        int comparisons = 0;
        int found = -1;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (logs[mid].equals(target)) {
                found = mid;
                break;
            } else if (logs[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found == -1) {
            System.out.println("Binary Search: Not found");
            return;
        }

        // Count duplicates
        int count = 1;

        int left = found - 1;
        while (left >= 0 && logs[left].equals(target)) {
            count++;
            left--;
        }

        int right = found + 1;
        while (right < logs.length && logs[right].equals(target)) {
            count++;
            right++;
        }

        System.out.println("\nBinary Search:");
        System.out.println("Found at index " + found);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Occurrences: " + count);
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Sort first for binary search
        Arrays.sort(logs);

        System.out.println("Sorted Logs:");
        System.out.println(Arrays.toString(logs));

        // Linear Search
        linearSearch(logs, "accB");

        // Binary Search
        binarySearch(logs, "accB");
    }
}