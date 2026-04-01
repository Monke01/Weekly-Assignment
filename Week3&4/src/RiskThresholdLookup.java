public class RiskThresholdLookup {

    // ================= LINEAR SEARCH =================
    // Search unsorted / exact threshold
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i] == target) {
                System.out.println("Linear Search:");
                System.out.println("Found at index " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("Not found");
        System.out.println("Comparisons: " + comparisons);

        return -1;
    }

    // ================= BINARY SEARCH =================
    // Find insertion point + floor + ceiling
    public static void binarySearchFloorCeiling(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int comparisons = 0;

        Integer floor = null;
        Integer ceiling = null;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            }

            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("\nBinary Search:");
        System.out.println("Floor = " + floor);
        System.out.println("Ceiling = " + ceiling);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Insertion index = " + low);
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};
        int target = 30;

        // Linear Search
        linearSearch(risks, target);

        // Binary Search floor / ceiling
        binarySearchFloorCeiling(risks, target);
    }
}