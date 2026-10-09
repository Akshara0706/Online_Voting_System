import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

public class VotingSystemGUI {
    private static final String ADMIN_USERNAME = "Lakshmi Praveena";
    private static final String ADMIN_PASSWORD = "aiml2024";

    static ArrayList<Candidate> candidates = new ArrayList<>();
    static ArrayList<Voter> voters = new ArrayList<>();

    static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Online Voting System");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        showMainMenu();
        frame.setVisible(true);
    }

    // ---------- MAIN MENU ----------
    static void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(4, 1));

        JLabel title = new JLabel("ONLINE VOTING SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JButton adminBtn = new JButton("Admin Login");
        JButton voterBtn = new JButton("Voter Login");
        JButton exitBtn = new JButton("Exit");

        adminBtn.addActionListener(e -> adminLogin());
        voterBtn.addActionListener(e -> voterLogin());
        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(title);
        frame.add(adminBtn);
        frame.add(voterBtn);
        frame.add(exitBtn);

        frame.revalidate();
    }

    // ---------- ADMIN LOGIN ----------
    static void adminLogin() {
        String user = JOptionPane.showInputDialog(frame, "Enter Admin Username:");
        String pass = JOptionPane.showInputDialog(frame, "Enter Password:");

        if (user != null && pass != null && user.equals(ADMIN_USERNAME) && pass.equals(ADMIN_PASSWORD)) {
            adminMenu();
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect Login!");
        }
    }

    // ---------- ADMIN MENU ----------
    static void adminMenu() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("ADMIN PANEL", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));

        JButton addBtn = new JButton("Add Candidate");
        JButton viewBtn = new JButton("View Candidates");
        JButton resultBtn = new JButton("View Results");
        JButton logoutBtn = new JButton("Logout");

        addBtn.addActionListener(e -> addCandidate());
        viewBtn.addActionListener(e -> viewCandidates());
        resultBtn.addActionListener(e -> showResults());
        logoutBtn.addActionListener(e -> showMainMenu());

        frame.add(label);
        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(resultBtn);
        frame.add(logoutBtn);

        frame.revalidate();
    }

    static void addCandidate() {
        String name = JOptionPane.showInputDialog(frame, "Enter Candidate Name:");
        if (name != null && !name.isEmpty()) {
            candidates.add(new Candidate(name));
            JOptionPane.showMessageDialog(frame, "Candidate Added Successfully!");
        }
    }

    static void viewCandidates() {
        if (candidates.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No candidates available.");
            return;
        }

        StringBuilder list = new StringBuilder("--- Candidate List ---\n");
        for (int i = 0; i < candidates.size(); i++) {
            list.append(i + 1).append(". ").append(candidates.get(i).name).append("\n");
        }
        JOptionPane.showMessageDialog(frame, list.toString());
    }

    // ---------- VOTER LOGIN ----------
    static void voterLogin() {
        String id = JOptionPane.showInputDialog(frame, "Enter Voter ID:");

        if (id == null || id.isEmpty()) return;

        Voter voter = findVoter(id);

        if (voter == null) {
            voter = new Voter(id);
            voters.add(voter);
            JOptionPane.showMessageDialog(frame, "New Voter Registered.");
        }

        if (voter.hasVoted) {
            JOptionPane.showMessageDialog(frame, "You have already voted!");
        } else {
            castVote(voter);
        }
    }

    static void castVote(Voter voter) {
        if (candidates.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No candidates yet. Try later.");
            return;
        }

        String[] candidateNames = candidates.stream().map(c -> c.name).toArray(String[]::new);

        String selected = (String) JOptionPane.showInputDialog(
                frame, "Select a Candidate:", "Voting Panel",
                JOptionPane.PLAIN_MESSAGE, null, candidateNames, candidateNames[0]
        );

        if (selected != null) {
            for (Candidate c : candidates) {
                if (c.name.equals(selected)) {
                    c.votes++;
                    voter.hasVoted = true;
                    JOptionPane.showMessageDialog(frame, "Vote Submitted!");
                    return;
                }
            }
        }
    }

    // Find Voter
    static Voter findVoter(String id) {
        for (Voter v : voters) {
            if (v.voterID.equals(id)) return v;
        }
        return null;
    }

    // ---------- SHOW RESULTS ----------
    static void showResults() {
        if (candidates.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No candidates registered.");
            return;
        }

        StringBuilder result = new StringBuilder("===== RESULTS =====\n");
        Candidate winner = candidates.get(0);

        for (Candidate c : candidates) {
            result.append(c.name).append(" ➤ Votes: ").append(c.votes).append("\n");
            if (c.votes > winner.votes) winner = c;
        }

        result.append("\n🏆 Winner: ").append(winner.name).append(" with ").append(winner.votes).append(" votes!");

        JOptionPane.showMessageDialog(frame, result.toString());
    }
}
