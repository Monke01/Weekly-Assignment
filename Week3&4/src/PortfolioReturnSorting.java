class Asset {
    String name;
    double returnRate;
    double volatility;

    public Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    @Override
    public String toString() {
        return name + ":" + returnRate + "% (vol=" + volatility + ")";
    }
}

public class PortfolioReturnSorting {

    // ================= MERGE SORT =================
    // Stable sort by returnRate ASC (preserve original order if equal)
    public static void mergeSort(Asset[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(Asset[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].returnRate <= R[j].returnRate) {
                arr[k++] = L[i++];   // stability preserved
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // ================= QUICK SORT =================
    // Sort by returnRate DESC + volatility ASC
    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].returnRate > pivot.returnRate ||
                    (arr[j].returnRate == pivot.returnRate &&
                            arr[j].volatility < pivot.volatility)) {

                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ================= PRINT =================
    public static void printAssets(Asset[] arr) {
        for (Asset a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Asset[] assets = {
                new Asset("AAPL", 12, 0.30),
                new Asset("TSLA", 8, 0.60),
                new Asset("GOOG", 15, 0.25)
        };

        // Merge Sort copy
        Asset[] mergeArray = assets.clone();
        mergeSort(mergeArray, 0, mergeArray.length - 1);

        System.out.println("Merge Sort (Ascending Return):");
        printAssets(mergeArray);

        // Quick Sort copy
        Asset[] quickArray = assets.clone();
        quickSort(quickArray, 0, quickArray.length - 1);

        System.out.println("\nQuick Sort (Descending Return + Volatility):");
        printAssets(quickArray);
    }
}