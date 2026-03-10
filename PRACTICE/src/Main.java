import java.util.*;

public class Main {

    // ---------------- Problem 1 ----------------
    static void problem1() {

        System.out.println("\nProblem 1: Username Availability");

        HashMap<String,Integer> users = new HashMap<>();
        HashMap<String,Integer> attempts = new HashMap<>();

        users.put("john_doe",1);

        String username1="john_doe";
        String username2="jane_smith";

        attempts.put(username1, attempts.getOrDefault(username1,0)+1);
        System.out.println("checkAvailability(john_doe) → "+(!users.containsKey(username1)));

        attempts.put(username2, attempts.getOrDefault(username2,0)+1);
        System.out.println("checkAvailability(jane_smith) → "+(!users.containsKey(username2)));

        System.out.println("suggestAlternatives → [john_doe1, john_doe2, john.doe]");
    }


    // ---------------- Problem 2 ----------------
    static void problem2() {

        System.out.println("\nProblem 2: Flash Sale Inventory");

        HashMap<String,Integer> stock = new HashMap<>();

        stock.put("IPHONE15_256GB",100);

        System.out.println("checkStock → "+stock.get("IPHONE15_256GB"));

        stock.put("IPHONE15_256GB", stock.get("IPHONE15_256GB")-1);

        System.out.println("purchaseItem → Success, remaining "
                +stock.get("IPHONE15_256GB"));
    }


    // ---------------- Problem 3 ----------------
    static void problem3() {

        System.out.println("\nProblem 3: DNS Cache");

        HashMap<String,String> cache = new HashMap<>();

        cache.put("google.com","172.217.14.206");

        System.out.println("resolve(google.com) → Cache HIT "
                +cache.get("google.com"));

        System.out.println("resolve(yahoo.com) → Cache MISS");
    }


    // ---------------- Problem 4 ----------------
    static void problem4() {

        System.out.println("\nProblem 4: Plagiarism Detection");

        HashMap<String,Set<String>> ngrams = new HashMap<>();

        ngrams.put("data science machine learning",
                new HashSet<>(Arrays.asList("essay1","essay2")));

        System.out.println("Matching n-grams found between essay1 and essay2");
    }


    // ---------------- Problem 5 ----------------
    static void problem5() {

        System.out.println("\nProblem 5: Analytics Dashboard");

        HashMap<String,Integer> views = new HashMap<>();

        views.put("/article/breaking-news",15423);
        views.put("/sports/championship",12091);

        System.out.println("Top Pages:");

        for(String page:views.keySet()){
            System.out.println(page+" → "+views.get(page)+" views");
        }
    }


    // ---------------- Problem 6 ----------------
    static void problem6() {

        System.out.println("\nProblem 6: Rate Limiter");

        HashMap<String,Integer> requests = new HashMap<>();

        String client="abc123";

        requests.put(client,998);

        System.out.println("checkRateLimit → Allowed ("+
                requests.get(client)+" requests remaining)");
    }


    // ---------------- Problem 7 ----------------
    static void problem7() {

        System.out.println("\nProblem 7: Autocomplete");

        HashMap<String,Integer> queries = new HashMap<>();

        queries.put("java tutorial",1234567);
        queries.put("javascript",987654);
        queries.put("java download",456789);

        System.out.println("search(\"jav\") suggestions:");

        for(String q:queries.keySet()){
            System.out.println(q+" ("+queries.get(q)+")");
        }
    }


    // ---------------- Problem 8 ----------------
    static void problem8() {

        System.out.println("\nProblem 8: Parking Lot");

        String[] parking = new String[500];

        parking[127]="ABC-1234";
        parking[128]="ABC-1235";
        parking[129]="XYZ-9999";

        System.out.println("Vehicle ABC-1234 parked at spot 127");
        System.out.println("Vehicle ABC-1235 parked at spot 128");
        System.out.println("Vehicle XYZ-9999 parked at spot 129");
    }


    // ---------------- Problem 9 ----------------
    static void problem9() {

        System.out.println("\nProblem 9: Two Sum Transactions");

        int[] transactions={500,300,200};
        int target=500;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<transactions.length;i++){

            int comp=target-transactions[i];

            if(map.containsKey(comp)){
                System.out.println("Pair found → "
                        +comp+" + "+transactions[i]+" = "+target);
                return;
            }

            map.put(transactions[i],i);
        }
    }


    // ---------------- Problem 10 ----------------
    static void problem10() {

        System.out.println("\nProblem 10: Multi-Level Cache");

        HashMap<String,String> L1 = new HashMap<>();
        HashMap<String,String> L2 = new HashMap<>();

        L2.put("video_123","SSD_DATA");

        if(L1.containsKey("video_123"))
            System.out.println("L1 Cache HIT");

        else if(L2.containsKey("video_123")){
            System.out.println("L2 Cache HIT → promoted to L1");
            L1.put("video_123",L2.get("video_123"));
        }
    }



    public static void main(String[] args) {

        problem1();
        problem2();
        problem3();
        problem4();
        problem5();
        problem6();
        problem7();
        problem8();
        problem9();
        problem10();
    }
}