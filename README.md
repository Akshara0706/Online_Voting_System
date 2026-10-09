# Online_Voting_System

## 📌 About the Project

The **Online Voting System** is a Java-based application designed to simplify the voting process. It allows an administrator to manage candidates and view election results, while voters can register using a Voter ID and cast their votes.

The project includes both a **console-based version** and a **Graphical User Interface (GUI) version** developed using Java Swing.

## ✨ Features

* **Admin Login:** Provides access to administrative functions.
* **Add Candidates:** Allows the administrator to add election candidates.
* **View Candidates:** Displays the list of registered candidates.
* **Voter Registration:** Registers voters using their Voter ID.
* **Cast Vote:** Allows registered voters to select a candidate and submit their vote.
* **Duplicate Voting Prevention:** Prevents a voter from voting more than once during the current application session.
* **Election Results:** Displays the vote count for each candidate and announces the winner.
* **User-Friendly GUI:** Provides buttons and dialog boxes through Java Swing.

## 🛠️ Technologies Used

* Java
* Java Swing
* Java AWT
* Object-Oriented Programming (OOP)
* ArrayList for storing candidates and voters

## 📂 Project Structure

```text
Online-Voting-System/
│
├── VotingSystem.java
├── VotingSystemGUI.java
├── Candidate.java
├── Voter.java
└── README.md
```

*Note: `Candidate` and `Voter` are currently defined inside the Java source files. They do not need separate `.java` files unless you choose to split them.*

## ▶️ How to Run the Project

### Prerequisites

* Java Development Kit (JDK) installed
* VS Code or another Java-compatible IDE (optional)

### 1. Clone the Repository

```bash
git clone YOUR_REPOSITORY_URL
```

### 2. Open the Project Folder

```bash
cd Online-Voting-System
```

### 3. Compile the Console Version

```bash
javac VotingSystem.java
```

### 4. Run the Console Version

```bash
java VotingSystem
```

### 5. Run the GUI Version

Compile the GUI source file:

```bash
javac VotingSystemGUI.java
```

Run the application:

```bash
java VotingSystemGUI
```

## 🗳️ How It Works

1. The application displays the main menu.
2. The administrator logs in and can add candidates, view the candidate list, and check election results.
3. A voter enters a Voter ID to register or access their existing session record.
4. The voter selects a candidate and submits their vote.
5. The system updates the candidate's vote count and prevents the same voter record from voting again.
6. The administrator can view the final vote counts and the candidate with the highest number of votes.

## 🎯 Learning Outcomes

* Understanding Java classes and objects.
* Implementing arrays and collections using `ArrayList`.
* Using conditional statements, loops, and methods.
* Developing graphical applications with Java Swing and AWT.
* Implementing basic voter tracking and vote-counting logic.

## ⚠️ Limitations

* Candidate and voter data are stored in memory and are lost when the application closes.
* The application uses basic hardcoded administrator credentials.
* Voter IDs are not verified against an official voter database.
* This is an educational project and is not suitable for real elections without additional security, authentication, data storage, and auditing mechanisms.

## 🚀 Future Enhancements

* Integrate a database such as MySQL to store voters, candidates, and results.
* Add secure administrator authentication.
* Improve voter identity verification.
* Add election scheduling and voting deadlines.
* Enhance the GUI with a more modern design.
* Generate downloadable election reports.

## 👩‍💻 Project Purpose

This project was developed for educational purposes to demonstrate Java programming, GUI development, object-oriented concepts, and basic voting system logic.

---

**If you find this project useful, feel free to star the repository!**
