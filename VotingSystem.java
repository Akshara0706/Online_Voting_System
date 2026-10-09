
import java.util.*;

class Candidate {
    String name;
    int votes = 0;

    Candidate(String name) {
        this.name = name;
    }
}

class Voter {
    String voterID;
    boolean hasVoted = false;

    Voter(String voterID) {
        this.voterID = voterID;
    }
}

public class VotingSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final String ADMIN_USERNAME = "Lakshmi Praveena";
    private static final String ADMIN_PASSWORD = "aiml2024";

    static ArrayList<Candidate> candidates = new ArrayList<>();
    static ArrayList<Voter> voters = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== ONLINE VOTING SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Voter Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> adminLogin();
                case 2 -> voterMenu();
                case 3 -> {
                    System.out.println("\nThank you for using the Voting System!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // --- ADMIN LOGIN ---
    static void adminLogin() {
        System.out.print("\nEnter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(ADMIN_USERNAME) && pass.equals(ADMIN_PASSWORD)) {
            adminMenu();
        } else {
            System.out.println("Incorrect login!");
        }
    }

    // --- ADMIN MENU ---
    static void adminMenu() {
        while (true) {
            System.out.println("\n===== ADMIN PANEL =====");
            System.out.println("1. Add Candidate");
            System.out.println("2. View Candidates");
            System.out.println("3. View Results");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addCandidate();
                case 2 -> viewCandidates();
                case 3 -> showResults();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addCandidate() {
        System.out.print("Enter Candidate Name: ");
        String name = sc.nextLine();
        candidates.add(new Candidate(name));
        System.out.println("Candidate added successfully!");
    }

    static void viewCandidates() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates available.");
            return;
        }
        System.out.println("\n--- Candidate List ---");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).name);
        }
    }

    // --- VOTER SECTION ---
    static void voterMenu() {
        System.out.print("\nEnter your Voter ID: ");
        String id = sc.nextLine();

        Voter voter = findVoter(id);

        if (voter == null) {
            voter = new Voter(id);
            voters.add(voter);
            System.out.println("New voter registered.");
        }

        if (voter.hasVoted) {
            System.out.println("You have already voted!");
            return;
        }

        castVote(voter);
    }

    static void castVote(Voter voter) {
        if (candidates.isEmpty()) {
            System.out.println("No candidates available yet. Try later.");
            return;
        }

        System.out.println("\n--- Voting Panel ---");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).name);
        }

        System.out.print("Select candidate number: ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > candidates.size()) {
            System.out.println("Invalid vote!");
            return;
        }

        candidates.get(choice - 1).votes++;
        voter.hasVoted = true;
        System.out.println("Vote submitted successfully!");
    }

    static Voter findVoter(String id) {
        for (Voter v : voters) {
            if (v.voterID.equals(id)) {
                return v;
            }
        }
        return null;
    }

    // --- RESULTS ---
    static void showResults() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates registered.");
            return;
        }

        System.out.println("\n===== ELECTION RESULTS =====");
        Candidate winner = candidates.get(0);

        for (Candidate c : candidates) {
            System.out.println(c.name + " ➤ Votes: " + c.votes);
            if (c.votes > winner.votes) {
                winner = c;
            }
        }

        System.out.println("\n🏆 Winner: " + winner.name + " with " + winner.votes + " votes!");
    }
}
