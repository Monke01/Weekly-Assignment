import java.util.ArrayList;

class Transaction {
    String id;
    double fee;
    String timestamp;

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class FeeSortingSystem {

    // Bubble Sort → sort by fee only (ascending)
    public static void bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();
        int swaps = 0;
        int passes = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) break; // early termination
        }

        System.out.println("BubbleSort Result:");
        for (Transaction t : list) {
            System.out.println(t);
        }
        System.out.println("Passes: " + passes + ", Swaps: " + swaps);
    }

    // Insertion Sort → sort by fee + timestamp
    public static void insertionSort(ArrayList<Transaction> list) {
        int shifts = 0;

        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0))) {

                list.set(j + 1, list.get(j));
                j--;
                shifts++;
            }

            list.set(j + 1, key);
        }

        System.out.println("\nInsertionSort Result:");
        for (Transaction t : list) {
            System.out.println(t);
        }
        System.out.println("Shifts: " + shifts);
    }

    // High-fee outliers > $50
    public static void detectOutliers(ArrayList<Transaction> list) {
        System.out.println("\nHigh-fee Outliers:");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("none");
        }
    }

    public static void main(String[] args) {

        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        // Bubble Sort copy
        ArrayList<Transaction> bubbleList = new ArrayList<>(transactions);
        bubbleSort(bubbleList);

        // Insertion Sort copy
        ArrayList<Transaction> insertionList = new ArrayList<>(transactions);
        insertionSort(insertionList);

        // Outlier detection
        detectOutliers(transactions);
    }
}