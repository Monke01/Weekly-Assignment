class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + "(" + riskScore + ", " + accountBalance + ")";
    }
}

public class ClientRiskRanking {

    // Bubble Sort → Ascending by riskScore
    public static void bubbleSort(Client[] clients) {
        int n = clients.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early stop
        }

        System.out.println("Bubble Sort (Ascending):");
        for (Client c : clients) {
            System.out.print(c + " ");
        }
        System.out.println("\nSwaps: " + swaps);
    }

    // Insertion Sort → Descending by riskScore + accountBalance
    public static void insertionSort(Client[] clients) {
        for (int i = 1; i < clients.length; i++) {
            Client key = clients[i];
            int j = i - 1;

            while (j >= 0 &&
                    (clients[j].riskScore < key.riskScore ||
                            (clients[j].riskScore == key.riskScore &&
                                    clients[j].accountBalance < key.accountBalance))) {

                clients[j + 1] = clients[j];
                j--;
            }

            clients[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending):");
        for (Client c : clients) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Top 10 highest risk clients
    public static void topRisks(Client[] clients) {
        System.out.println("\nTop Risk Clients:");
        int limit = Math.min(10, clients.length);

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + clients[i]);
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("A", 20, 5000),
                new Client("B", 50, 7000),
                new Client("C", 80, 3000)
        };

        // Bubble Sort copy
        Client[] bubbleArray = clients.clone();
        bubbleSort(bubbleArray);

        // Insertion Sort copy
        Client[] insertionArray = clients.clone();
        insertionSort(insertionArray);

        // Top risks after descending sort
        topRisks(insertionArray);
    }
}